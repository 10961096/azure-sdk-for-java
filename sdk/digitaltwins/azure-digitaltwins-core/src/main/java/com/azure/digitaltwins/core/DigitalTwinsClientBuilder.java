package com.azure.digitaltwins.core;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.*;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ServiceClientBuilder(serviceClients = {DigitalTwinsClient.class, DigitalTwinsAsyncClient.class})
public class DigitalTwinsClientBuilder
{
    // mandatory
    private String endpoint;
    private TokenCredential tokenCredential;

    // optional or has default values
    private DigitalTwinsServiceVersion version;
    private HttpPipeline httpPipeline;
    private HttpClient httpClient;
    private HttpLogOptions logOptions;
    private final List<HttpPipelinePolicy> additionalPolicies = new ArrayList<>();


    public DigitalTwinsClient buildClient() {
        return new DigitalTwinsClient(buildAsyncClient());
    }

    public DigitalTwinsAsyncClient buildAsyncClient() {
        Objects.requireNonNull(tokenCredential, "'tokenCredential' cannot be null.");
        Objects.requireNonNull(endpoint, "'endpoint' cannot be null");

        DigitalTwinsServiceVersion serviceVersion = version != null ? version : DigitalTwinsServiceVersion.getLatest();

        HttpPipeline pipeline = (httpPipeline != null) ? httpPipeline : buildPipeline(tokenCredential, endpoint, logOptions, httpClient, additionalPolicies);

        return new DigitalTwinsAsyncClient(pipeline, serviceVersion, endpoint);
    }

    public static HttpPipeline buildPipeline(TokenCredential tokenCredential, String endpoint,
                                             HttpLogOptions logOptions, HttpClient httpClient,
                                             List<HttpPipelinePolicy> additionalPolicies)
    {
        // Closest to API goes first, closest to wire goes last.
        List<HttpPipelinePolicy> policies = new ArrayList<>();

        policies.add(new RequestIdPolicy());

        HttpPolicyProviders.addBeforeRetryPolicies(policies);

        policies.add(new AddDatePolicy());

        HttpPipelinePolicy credentialPolicy = new BearerTokenAuthenticationPolicy(tokenCredential, GetAuthorizationScopes(endpoint));

        policies.add(credentialPolicy);

        policies.addAll(additionalPolicies);

        HttpPolicyProviders.addAfterRetryPolicies(policies);

        policies.add(new HttpLoggingPolicy(logOptions));

        return new HttpPipelineBuilder()
            .policies(policies.toArray(new HttpPipelinePolicy[0]))
            .httpClient(httpClient)
            .build();
    }

    private static String[] GetAuthorizationScopes(String endpoint)
    {
        Objects.requireNonNull(endpoint);

        // Uri representation for azure digital twin app Id "0b07f429-9f4b-4714-9392-cc5e8e80c8b0" in the public cloud.
        String adtPublicCloudAppId = "https://digitaltwins.azure.net";
        String defaultPermissionConsent = "/.default";

        // If the endpoint is in Azure public cloud, the suffix will have "azure.net" or "ppe.net".
        // Once ADT becomes available in other clouds, their corresponding scope has to be matched and set.
        if (endpoint.indexOf("azure.net") > 0
            || endpoint.indexOf("ppe.net") > 0)
        {
            return new String[] { adtPublicCloudAppId + defaultPermissionConsent };
        }

        throw new IllegalArgumentException(String.format("Azure digital twins instance endpoint %s is not valid.", endpoint));
    }

    // mandatory
    public DigitalTwinsClientBuilder endpoint(String endpoint)
    {
        this.endpoint = endpoint;
        return this;
    }


    public DigitalTwinsClientBuilder tokenCredential(TokenCredential tokenCredential)
    {
        this.tokenCredential = tokenCredential;
        return this;
    }

    // optional or has default values
    public DigitalTwinsClientBuilder version(DigitalTwinsServiceVersion version)
    {
        this.version = version;
        return this;
    }

    public DigitalTwinsClientBuilder httpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
        return this;
    }

    public DigitalTwinsClientBuilder logOptions(HttpLogOptions logOptions)
    {
        this.logOptions = logOptions;
        return this;
    }

    public DigitalTwinsClientBuilder addPolicy(HttpPipelinePolicy pipelinePolicy)
    {
        this.additionalPolicies.add(Objects.requireNonNull(pipelinePolicy, "'pipelinePolicy' cannot be null"));
        return this;
    }

    public DigitalTwinsClientBuilder version(HttpPipeline httpPipeline)
    {
        this.httpPipeline = httpPipeline;
        return this;
    }
}
