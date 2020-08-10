package com.azure.digitaltwins.core;

import com.azure.core.annotation.ServiceClient;
import com.azure.core.http.HttpPipeline;
import com.azure.digitaltwins.core.models.DigitalTwinsGetByIdResponse;
import reactor.core.publisher.Mono;

@ServiceClient(builder = DigitalTwinsClientBuilder.class)
public class DigitalTwinsAsyncClient
{
    protected final DigitalTwinsServiceVersion serviceVersion;

    protected final AzureDigitalTwinsAPI protocolLayer;

    protected DigitalTwinsAsyncClient(HttpPipeline pipeline, DigitalTwinsServiceVersion serviceVersion, String host) {
        this.protocolLayer = new AzureDigitalTwinsAPIBuilder().host(host).pipeline(pipeline).buildClient();
        this.serviceVersion = serviceVersion;
    }

    public DigitalTwinsServiceVersion getServiceVersion()
    {
        return this.serviceVersion;
    }

    public HttpPipeline getHttpPipeline()
    {
        return this.protocolLayer.getHttpPipeline();
    }

    // TODO This is just a temporary implementation for test purposes. This should be spruced up/replaced once this API is actually designed
    public Mono<DigitalTwinsGetByIdResponse> getDigitalTwin(String digitalTwinId)
    {
        return this.protocolLayer.getDigitalTwins().getByIdWithResponseAsync(digitalTwinId);
    }
}
