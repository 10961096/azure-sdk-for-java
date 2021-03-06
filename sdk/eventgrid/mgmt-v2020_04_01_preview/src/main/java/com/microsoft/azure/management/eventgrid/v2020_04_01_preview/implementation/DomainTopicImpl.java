/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventgrid.v2020_04_01_preview.implementation;

import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.DomainTopic;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.DomainTopicProvisioningState;

class DomainTopicImpl extends CreatableUpdatableImpl<DomainTopic, DomainTopicInner, DomainTopicImpl> implements DomainTopic, DomainTopic.Definition, DomainTopic.Update {
    private final EventGridManager manager;
    private String resourceGroupName;
    private String domainName;
    private String domainTopicName;

    DomainTopicImpl(String name, EventGridManager manager) {
        super(name, new DomainTopicInner());
        this.manager = manager;
        // Set resource name
        this.domainTopicName = name;
        //
    }

    DomainTopicImpl(DomainTopicInner inner, EventGridManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.domainTopicName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.domainName = IdParsingUtils.getValueFromIdByName(inner.id(), "domains");
        this.domainTopicName = IdParsingUtils.getValueFromIdByName(inner.id(), "topics");
        //
    }

    @Override
    public EventGridManager manager() {
        return this.manager;
    }

    @Override
    public Observable<DomainTopic> createResourceAsync() {
        DomainTopicsInner client = this.manager().inner().domainTopics();
        return client.createOrUpdateAsync(this.resourceGroupName, this.domainName, this.domainTopicName)
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<DomainTopic> updateResourceAsync() {
        DomainTopicsInner client = this.manager().inner().domainTopics();
        return client.createOrUpdateAsync(this.resourceGroupName, this.domainName, this.domainTopicName)
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<DomainTopicInner> getInnerAsync() {
        DomainTopicsInner client = this.manager().inner().domainTopics();
        return client.getAsync(this.resourceGroupName, this.domainName, this.domainTopicName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public DomainTopicProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public DomainTopicImpl withExistingDomain(String resourceGroupName, String domainName) {
        this.resourceGroupName = resourceGroupName;
        this.domainName = domainName;
        return this;
    }

}
