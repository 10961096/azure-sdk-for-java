// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.indexes.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The ServiceCounters model. */
@Fluent
public final class ServiceCounters {
    /*
     * Total number of documents across all indexes in the service.
     */
    @JsonProperty(value = "documentCount", required = true)
    private ResourceCounter documentCounter;

    /*
     * Total number of indexes.
     */
    @JsonProperty(value = "indexesCount", required = true)
    private ResourceCounter indexCounter;

    /*
     * Total number of indexers.
     */
    @JsonProperty(value = "indexersCount", required = true)
    private ResourceCounter indexerCounter;

    /*
     * Total number of data sources.
     */
    @JsonProperty(value = "dataSourcesCount", required = true)
    private ResourceCounter dataSourceCounter;

    /*
     * Total size of used storage in bytes.
     */
    @JsonProperty(value = "storageSize", required = true)
    private ResourceCounter storageSizeCounter;

    /*
     * Total number of synonym maps.
     */
    @JsonProperty(value = "synonymMaps", required = true)
    private ResourceCounter synonymMapCounter;

    /** Creates an instance of ServiceCounters class. */
    @JsonCreator
    public ServiceCounters(
            @JsonProperty(value = "documentCount") ResourceCounter documentCounter,
            @JsonProperty(value = "indexesCount") ResourceCounter indexCounter,
            @JsonProperty(value = "indexersCount") ResourceCounter indexerCounter,
            @JsonProperty(value = "dataSourcesCount") ResourceCounter dataSourceCounter,
            @JsonProperty(value = "storageSize") ResourceCounter storageSizeCounter,
            @JsonProperty(value = "synonymMaps") ResourceCounter synonymMapCounter) {
        this.documentCounter = documentCounter;
        this.indexCounter = indexCounter;
        this.indexerCounter = indexerCounter;
        this.dataSourceCounter = dataSourceCounter;
        this.storageSizeCounter = storageSizeCounter;
        this.synonymMapCounter = synonymMapCounter;
    }

    /**
     * Get the documentCounter property: Total number of documents across all indexes in the service.
     *
     * @return the documentCounter value.
     */
    public ResourceCounter getDocumentCounter() {
        return this.documentCounter;
    }

    /**
     * Set the documentCounter property: Total number of documents across all indexes in the service.
     *
     * @param documentCounter the documentCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Get the indexCounter property: Total number of indexes.
     *
     * @return the indexCounter value.
     */
    public ResourceCounter getIndexCounter() {
        return this.indexCounter;
    }

    /**
     * Set the indexCounter property: Total number of indexes.
     *
     * @param indexCounter the indexCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Get the indexerCounter property: Total number of indexers.
     *
     * @return the indexerCounter value.
     */
    public ResourceCounter getIndexerCounter() {
        return this.indexerCounter;
    }

    /**
     * Set the indexerCounter property: Total number of indexers.
     *
     * @param indexerCounter the indexerCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Get the dataSourceCounter property: Total number of data sources.
     *
     * @return the dataSourceCounter value.
     */
    public ResourceCounter getDataSourceCounter() {
        return this.dataSourceCounter;
    }

    /**
     * Set the dataSourceCounter property: Total number of data sources.
     *
     * @param dataSourceCounter the dataSourceCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Get the storageSizeCounter property: Total size of used storage in bytes.
     *
     * @return the storageSizeCounter value.
     */
    public ResourceCounter getStorageSizeCounter() {
        return this.storageSizeCounter;
    }

    /**
     * Set the storageSizeCounter property: Total size of used storage in bytes.
     *
     * @param storageSizeCounter the storageSizeCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Get the synonymMapCounter property: Total number of synonym maps.
     *
     * @return the synonymMapCounter value.
     */
    public ResourceCounter getSynonymMapCounter() {
        return this.synonymMapCounter;
    }

    /**
     * Set the synonymMapCounter property: Total number of synonym maps.
     *
     * @param synonymMapCounter the synonymMapCounter value to set.
     * @return the ServiceCounters object itself.
     */
    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (getDocumentCounter() == null) {
            throw new IllegalArgumentException("Missing required property documentCounter in model ServiceCounters");
        } else {
            getDocumentCounter().validate();
        }
        if (getIndexCounter() == null) {
            throw new IllegalArgumentException("Missing required property indexCounter in model ServiceCounters");
        } else {
            getIndexCounter().validate();
        }
        if (getIndexerCounter() == null) {
            throw new IllegalArgumentException("Missing required property indexerCounter in model ServiceCounters");
        } else {
            getIndexerCounter().validate();
        }
        if (getDataSourceCounter() == null) {
            throw new IllegalArgumentException("Missing required property dataSourceCounter in model ServiceCounters");
        } else {
            getDataSourceCounter().validate();
        }
        if (getStorageSizeCounter() == null) {
            throw new IllegalArgumentException("Missing required property storageSizeCounter in model ServiceCounters");
        } else {
            getStorageSizeCounter().validate();
        }
        if (getSynonymMapCounter() == null) {
            throw new IllegalArgumentException("Missing required property synonymMapCounter in model ServiceCounters");
        } else {
            getSynonymMapCounter().validate();
        }
    }
}
