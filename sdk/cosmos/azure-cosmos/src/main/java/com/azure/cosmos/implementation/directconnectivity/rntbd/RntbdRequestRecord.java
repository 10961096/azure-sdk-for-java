// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity.rntbd;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.implementation.RequestTimeline;
import com.azure.cosmos.implementation.RequestTimeoutException;
import com.azure.cosmos.implementation.directconnectivity.StoreResponse;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.micrometer.core.instrument.Timer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;
import static com.azure.cosmos.implementation.guava27.Strings.lenientFormat;

@JsonSerialize(using = RntbdRequestRecord.JsonSerializer.class)
public final class RntbdRequestRecord extends CompletableFuture<StoreResponse> {

    private static final Logger logger = LoggerFactory.getLogger(RntbdRequestRecord.class);

    private static final AtomicIntegerFieldUpdater<RntbdRequestRecord> REQUEST_LENGTH =
        AtomicIntegerFieldUpdater.newUpdater(RntbdRequestRecord.class, "requestLength");

    private static final AtomicIntegerFieldUpdater<RntbdRequestRecord> RESPONSE_LENGTH =
        AtomicIntegerFieldUpdater.newUpdater(RntbdRequestRecord.class, "responseLength");

    private static final AtomicReferenceFieldUpdater<RntbdRequestRecord, Stage> STAGE =
        AtomicReferenceFieldUpdater.newUpdater(
            RntbdRequestRecord.class,
            Stage.class,
            "stage");

    private final RntbdRequestArgs args;
    private final RntbdRequestTimer timer;

    private volatile int requestLength;
    private volatile int responseLength;
    private volatile Stage stage;

    private volatile Instant timeCompleted;
    private volatile Instant timePipelined;
    private volatile Instant timeQueued;
    private volatile Instant timeSent;
    private volatile Instant timeReceived;

    public RntbdRequestRecord(final RntbdRequestArgs args, final RntbdRequestTimer timer) {

        checkNotNull(args, "expected non-null args");
        checkNotNull(timer, "expected non-null timer");

        this.timeQueued = Instant.now();
        this.requestLength = -1;
        this.responseLength = -1;
        this.stage = Stage.QUEUED;
        this.args = args;
        this.timer = timer;
    }

    // region Accessors

    public UUID activityId() {
        return this.args.activityId();
    }

    public RntbdRequestArgs args() {
        return this.args;
    }

    public Duration lifetime() {
        return this.args.lifetime();
    }

    public int requestLength() {
        return this.requestLength;
    }

    RntbdRequestRecord requestLength(int value) {
        REQUEST_LENGTH.set(this, value);
        return this;
    }

    public int responseLength() {
        return this.responseLength;
    }

    RntbdRequestRecord responseLength(int value) {
        RESPONSE_LENGTH.set(this, value);
        return this;
    }

    public Stage stage() {
        return this.stage;
    }

    public RntbdRequestRecord stage(final Stage value) {

        final Instant time = Instant.now();

        STAGE.updateAndGet(this, current -> {

            switch (value) {
                case PIPELINED:
                    if (current != Stage.QUEUED) {
                        logger.debug("Expected transition from QUEUED to PIPELINED, not {} to PIPELINED", current);
                        break;
                    }
                    this.timePipelined = time;
                    break;
                case SENT:
                    if (current != Stage.PIPELINED) {
                        logger.debug("Expected transition from PIPELINED to SENT, not {} to SENT", current);
                        break;
                    }
                    this.timeSent = time;
                    break;
                case RECEIVED:
                    if (current != Stage.SENT) {
                        logger.debug("Expected transition from SENT to RECEIVED, not {} to RECEIVED", current);
                        break;
                    }
                    this.timeReceived = time;
                    break;
                case COMPLETED:
                    if (current == Stage.COMPLETED) {
                        logger.debug("Request already COMPLETED", current);
                        break;
                    }
                    this.timeCompleted = time;
                    break;
                default:
                    throw new IllegalStateException(lenientFormat("there is no transition from %s to %s",
                        current,
                        value));
            }

            return value;
        });

        return this;
    }

    public Instant timeCompleted() {
        return this.timeCompleted;
    }

    public Instant timeCreated() {
        return this.args.timeCreated();
    }

    public Instant timePipelined() {
        return this.timePipelined;
    }

    public Instant timeQueued() {
        return this.timeQueued;
    }

    public Instant timeReceived() {
        return this.timeReceived;
    }

    public Instant timeSent() {
        return this.timeSent;
    }

    public long transportRequestId() {
        return this.args.transportRequestId();
    }

    // endregion

    // region Methods

    public boolean expire() {
        final RequestTimeoutException error = new RequestTimeoutException(this.toString(), this.args.physicalAddress());
        BridgeInternal.setRequestHeaders(error, this.args.serviceRequest().getHeaders());
        return this.completeExceptionally(error);
    }

    public Timeout newTimeout(final TimerTask task) {
        return this.timer.newTimeout(task);
    }

    public RequestTimeline takeTimelineSnapshot() {

        Instant now = Instant.now();

        Instant timeCreated = this.timeCreated();
        Instant timeQueued = this.timeQueued();
        Instant timePipelined = this.timePipelined();
        Instant timeSent = this.timeSent();
        Instant timeReceived = this.timeReceived();
        Instant timeCompleted = this.timeCompleted();
        Instant timeCompletedOrNow = timeCompleted == null ? now : timeCompleted;

        return RequestTimeline.of(
            new RequestTimeline.Event("created",
                timeCreated, timeQueued == null ? timeCompletedOrNow : timeQueued),
            new RequestTimeline.Event("queued",
                timeQueued, timePipelined == null ? timeCompletedOrNow : timePipelined),
            new RequestTimeline.Event("pipelined",
                timePipelined, timeSent == null ? timeCompletedOrNow : timeSent),
            new RequestTimeline.Event("transitTime",
                timeSent, timeReceived == null ? timeCompletedOrNow : timeReceived),
            new RequestTimeline.Event("received",
                timeReceived, timeCompletedOrNow),
            new RequestTimeline.Event("completed",
                timeCompleted, now));
    }

    public long stop(Timer requests, Timer responses) {
        return this.args.stop(requests, responses);
    }

    @Override
    public String toString() {
        return RntbdObjectMapper.toString(this);
    }

    // endregion

    // region Types

    public enum Stage {
        QUEUED, PIPELINED, SENT, RECEIVED, COMPLETED
    }

    static final class JsonSerializer extends StdSerializer<RntbdRequestRecord> {

        private static final long serialVersionUID = -6869331366500298083L;

        JsonSerializer() {
            super(RntbdRequestRecord.class);
        }

        @Override
        public void serialize(
            final RntbdRequestRecord value,
            final JsonGenerator generator,
            final SerializerProvider provider) throws IOException {

            generator.writeStartObject();
            generator.writeObjectField("args", value.args());
            generator.writeNumberField("requestLength", value.requestLength());
            generator.writeNumberField("responseLength", value.responseLength());

            // status

            generator.writeObjectFieldStart("status");
            generator.writeBooleanField("done", value.isDone());
            generator.writeBooleanField("cancelled", value.isCancelled());
            generator.writeBooleanField("completedExceptionally", value.isCompletedExceptionally());

            if (value.isCompletedExceptionally()) {

                try {

                    value.get();

                } catch (final ExecutionException executionException) {

                    final Throwable error = executionException.getCause();

                    generator.writeObjectFieldStart("error");
                    generator.writeStringField("type", error.getClass().getName());
                    generator.writeObjectField("value", error);
                    generator.writeEndObject();

                } catch (CancellationException | InterruptedException exception) {

                    generator.writeObjectFieldStart("error");
                    generator.writeStringField("type", exception.getClass().getName());
                    generator.writeObjectField("value", exception);
                    generator.writeEndObject();
                }
            }

            generator.writeEndObject();

            generator.writeObjectField("timeline", value.takeTimelineSnapshot());
            generator.writeEndObject();
        }
    }

    // endregion
}
