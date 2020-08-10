// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.digitaltwins.core;

import com.azure.core.annotation.ServiceClient;
import com.azure.core.http.HttpPipeline;
import com.azure.digitaltwins.core.models.DigitalTwinsGetByIdResponse;

@ServiceClient(builder = DigitalTwinsClientBuilder.class)
public class DigitalTwinsClient
{
    private final DigitalTwinsAsyncClient digitalTwinsAsyncClient;

    DigitalTwinsClient(DigitalTwinsAsyncClient digitalTwinsAsyncClient)
    {
        this.digitalTwinsAsyncClient = digitalTwinsAsyncClient;
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return The pipeline.
     */
    public HttpPipeline getHttpPipeline() {
        return digitalTwinsAsyncClient.getHttpPipeline();
    }

    /**
     * Gets the service version the client is using.
     *
     * @return the service version the client is using.
     */
    public DigitalTwinsServiceVersion getServiceVersion() {
        return this.digitalTwinsAsyncClient.getServiceVersion();
    }

    // TODO This is just a temporary implementation for test purposes. This should be spruced up/replaced once this API is actually designed
    public DigitalTwinsGetByIdResponse getDigitalTwin(String digitalTwinId)
    {
        // Blocking calls to the async client is the established pattern in track 2 Java SDKs
        return this.digitalTwinsAsyncClient.getDigitalTwin(digitalTwinId).block();
    }
}
