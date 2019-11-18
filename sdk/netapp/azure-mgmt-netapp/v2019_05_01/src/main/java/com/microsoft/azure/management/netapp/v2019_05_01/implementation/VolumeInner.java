/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.netapp.v2019_05_01.implementation;

import com.microsoft.azure.management.netapp.v2019_05_01.ServiceLevel;
import com.microsoft.azure.management.netapp.v2019_05_01.VolumePropertiesExportPolicy;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Volume resource.
 */
@JsonFlatten
public class VolumeInner extends Resource {
    /**
     * FileSystem ID.
     * Unique FileSystem Identifier.
     */
    @JsonProperty(value = "properties.fileSystemId", access = JsonProperty.Access.WRITE_ONLY)
    private String fileSystemId;

    /**
     * Creation Token or File Path.
     * A unique file path for the volume. Used when creating mount targets.
     */
    @JsonProperty(value = "properties.creationToken", required = true)
    private String creationToken;

    /**
     * serviceLevel.
     * The service level of the file system. Possible values include:
     * 'Standard', 'Premium', 'Ultra'.
     */
    @JsonProperty(value = "properties.serviceLevel", required = true)
    private ServiceLevel serviceLevel;

    /**
     * usageThreshold.
     * Maximum storage quota allowed for a file system in bytes. This is a soft
     * quota used for alerting only. Minimum size is 100 GiB. Upper limit is
     * 100TiB.
     */
    @JsonProperty(value = "properties.usageThreshold")
    private Long usageThreshold;

    /**
     * exportPolicy.
     * Set of export policy rules.
     */
    @JsonProperty(value = "properties.exportPolicy")
    private VolumePropertiesExportPolicy exportPolicy;

    /**
     * Azure lifecycle management.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * Snapshot ID.
     * UUID v4 used to identify the Snapshot.
     */
    @JsonProperty(value = "properties.snapshotId")
    private String snapshotId;

    /**
     * Baremetal Tenant ID.
     * Unique Baremetal Tenant Identifier.
     */
    @JsonProperty(value = "properties.baremetalTenantId", access = JsonProperty.Access.WRITE_ONLY)
    private String baremetalTenantId;

    /**
     * The Azure Resource URI for a delegated subnet. Must have the delegation
     * Microsoft.NetApp/volumes.
     */
    @JsonProperty(value = "properties.subnetId")
    private String subnetId;

    /**
     * Get unique FileSystem Identifier.
     *
     * @return the fileSystemId value
     */
    public String fileSystemId() {
        return this.fileSystemId;
    }

    /**
     * Get a unique file path for the volume. Used when creating mount targets.
     *
     * @return the creationToken value
     */
    public String creationToken() {
        return this.creationToken;
    }

    /**
     * Set a unique file path for the volume. Used when creating mount targets.
     *
     * @param creationToken the creationToken value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withCreationToken(String creationToken) {
        this.creationToken = creationToken;
        return this;
    }

    /**
     * Get the service level of the file system. Possible values include: 'Standard', 'Premium', 'Ultra'.
     *
     * @return the serviceLevel value
     */
    public ServiceLevel serviceLevel() {
        return this.serviceLevel;
    }

    /**
     * Set the service level of the file system. Possible values include: 'Standard', 'Premium', 'Ultra'.
     *
     * @param serviceLevel the serviceLevel value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
        return this;
    }

    /**
     * Get maximum storage quota allowed for a file system in bytes. This is a soft quota used for alerting only. Minimum size is 100 GiB. Upper limit is 100TiB.
     *
     * @return the usageThreshold value
     */
    public Long usageThreshold() {
        return this.usageThreshold;
    }

    /**
     * Set maximum storage quota allowed for a file system in bytes. This is a soft quota used for alerting only. Minimum size is 100 GiB. Upper limit is 100TiB.
     *
     * @param usageThreshold the usageThreshold value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withUsageThreshold(Long usageThreshold) {
        this.usageThreshold = usageThreshold;
        return this;
    }

    /**
     * Get set of export policy rules.
     *
     * @return the exportPolicy value
     */
    public VolumePropertiesExportPolicy exportPolicy() {
        return this.exportPolicy;
    }

    /**
     * Set set of export policy rules.
     *
     * @param exportPolicy the exportPolicy value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withExportPolicy(VolumePropertiesExportPolicy exportPolicy) {
        this.exportPolicy = exportPolicy;
        return this;
    }

    /**
     * Get azure lifecycle management.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get uUID v4 used to identify the Snapshot.
     *
     * @return the snapshotId value
     */
    public String snapshotId() {
        return this.snapshotId;
    }

    /**
     * Set uUID v4 used to identify the Snapshot.
     *
     * @param snapshotId the snapshotId value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    /**
     * Get unique Baremetal Tenant Identifier.
     *
     * @return the baremetalTenantId value
     */
    public String baremetalTenantId() {
        return this.baremetalTenantId;
    }

    /**
     * Get the Azure Resource URI for a delegated subnet. Must have the delegation Microsoft.NetApp/volumes.
     *
     * @return the subnetId value
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set the Azure Resource URI for a delegated subnet. Must have the delegation Microsoft.NetApp/volumes.
     *
     * @param subnetId the subnetId value to set
     * @return the VolumeInner object itself.
     */
    public VolumeInner withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

}