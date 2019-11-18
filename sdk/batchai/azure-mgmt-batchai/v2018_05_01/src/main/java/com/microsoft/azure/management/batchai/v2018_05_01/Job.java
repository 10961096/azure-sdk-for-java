/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_05_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.batchai.v2018_05_01.implementation.JobInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.batchai.v2018_05_01.implementation.BatchAIManager;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Type representing Job.
 */
public interface Job extends HasInner<JobInner>, Indexable, Refreshable<Job>, Updatable<Job.Update>, HasManager<BatchAIManager> {
    /**
     * @return the caffe2Settings value.
     */
    Caffe2Settings caffe2Settings();

    /**
     * @return the caffeSettings value.
     */
    CaffeSettings caffeSettings();

    /**
     * @return the chainerSettings value.
     */
    ChainerSettings chainerSettings();

    /**
     * @return the cluster value.
     */
    ResourceId cluster();

    /**
     * @return the cntkSettings value.
     */
    CNTKsettings cntkSettings();

    /**
     * @return the constraints value.
     */
    JobPropertiesConstraints constraints();

    /**
     * @return the containerSettings value.
     */
    ContainerSettings containerSettings();

    /**
     * @return the creationTime value.
     */
    DateTime creationTime();

    /**
     * @return the customMpiSettings value.
     */
    CustomMpiSettings customMpiSettings();

    /**
     * @return the customToolkitSettings value.
     */
    CustomToolkitSettings customToolkitSettings();

    /**
     * @return the environmentVariables value.
     */
    List<EnvironmentVariable> environmentVariables();

    /**
     * @return the executionInfo value.
     */
    JobPropertiesExecutionInfo executionInfo();

    /**
     * @return the executionState value.
     */
    ExecutionState executionState();

    /**
     * @return the executionStateTransitionTime value.
     */
    DateTime executionStateTransitionTime();

    /**
     * @return the horovodSettings value.
     */
    HorovodSettings horovodSettings();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the inputDirectories value.
     */
    List<InputDirectory> inputDirectories();

    /**
     * @return the jobOutputDirectoryPathSegment value.
     */
    String jobOutputDirectoryPathSegment();

    /**
     * @return the jobPreparation value.
     */
    JobPreparation jobPreparation();

    /**
     * @return the mountVolumes value.
     */
    MountVolumes mountVolumes();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the nodeCount value.
     */
    Integer nodeCount();

    /**
     * @return the outputDirectories value.
     */
    List<OutputDirectory> outputDirectories();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the provisioningStateTransitionTime value.
     */
    DateTime provisioningStateTransitionTime();

    /**
     * @return the pyTorchSettings value.
     */
    PyTorchSettings pyTorchSettings();

    /**
     * @return the schedulingPriority value.
     */
    JobPriority schedulingPriority();

    /**
     * @return the secrets value.
     */
    List<EnvironmentVariableWithSecretValue> secrets();

    /**
     * @return the stdOutErrPathPrefix value.
     */
    String stdOutErrPathPrefix();

    /**
     * @return the tensorFlowSettings value.
     */
    TensorFlowSettings tensorFlowSettings();

    /**
     * @return the toolType value.
     */
    ToolType toolType();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the Job definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithExperiment, DefinitionStages.WithCluster, DefinitionStages.WithNodeCount, DefinitionStages.WithStdOutErrPathPrefix, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of Job definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a Job definition.
         */
        interface Blank extends WithExperiment {
        }

        /**
         * The stage of the job definition allowing to specify Experiment.
         */
        interface WithExperiment {
           /**
            * Specifies resourceGroupName, workspaceName, experimentName.
            * @param resourceGroupName Name of the resource group to which the resource belongs
            * @param workspaceName The name of the workspace. Workspace names can only contain a combination of alphanumeric characters along with dash (-) and underscore (_). The name must be from 1 through 64 characters long
            * @param experimentName The name of the experiment. Experiment names can only contain a combination of alphanumeric characters along with dash (-) and underscore (_). The name must be from 1 through 64 characters long
            * @return the next definition stage
            */
            WithCluster withExistingExperiment(String resourceGroupName, String workspaceName, String experimentName);
        }

        /**
         * The stage of the job definition allowing to specify Cluster.
         */
        interface WithCluster {
           /**
            * Specifies cluster.
            * @param cluster Resource ID of the cluster on which this job will run
            * @return the next definition stage
            */
            WithNodeCount withCluster(ResourceId cluster);
        }

        /**
         * The stage of the job definition allowing to specify NodeCount.
         */
        interface WithNodeCount {
           /**
            * Specifies nodeCount.
            * @param nodeCount Number of compute nodes to run the job on. The job will be gang scheduled on that many compute nodes
            * @return the next definition stage
            */
            WithStdOutErrPathPrefix withNodeCount(int nodeCount);
        }

        /**
         * The stage of the job definition allowing to specify StdOutErrPathPrefix.
         */
        interface WithStdOutErrPathPrefix {
           /**
            * Specifies stdOutErrPathPrefix.
            * @param stdOutErrPathPrefix The path where the Batch AI service will store stdout, stderror and execution log of the job
            * @return the next definition stage
            */
            WithCreate withStdOutErrPathPrefix(String stdOutErrPathPrefix);
        }

        /**
         * The stage of the job definition allowing to specify Caffe2Settings.
         */
        interface WithCaffe2Settings {
            /**
             * Specifies caffe2Settings.
             * @param caffe2Settings Settings for Caffe2 job
             * @return the next definition stage
             */
            WithCreate withCaffe2Settings(Caffe2Settings caffe2Settings);
        }

        /**
         * The stage of the job definition allowing to specify CaffeSettings.
         */
        interface WithCaffeSettings {
            /**
             * Specifies caffeSettings.
             * @param caffeSettings Settings for Caffe job
             * @return the next definition stage
             */
            WithCreate withCaffeSettings(CaffeSettings caffeSettings);
        }

        /**
         * The stage of the job definition allowing to specify ChainerSettings.
         */
        interface WithChainerSettings {
            /**
             * Specifies chainerSettings.
             * @param chainerSettings Settings for Chainer job
             * @return the next definition stage
             */
            WithCreate withChainerSettings(ChainerSettings chainerSettings);
        }

        /**
         * The stage of the job definition allowing to specify CntkSettings.
         */
        interface WithCntkSettings {
            /**
             * Specifies cntkSettings.
             * @param cntkSettings Settings for CNTK (aka Microsoft Cognitive Toolkit) job
             * @return the next definition stage
             */
            WithCreate withCntkSettings(CNTKsettings cntkSettings);
        }

        /**
         * The stage of the job definition allowing to specify Constraints.
         */
        interface WithConstraints {
            /**
             * Specifies constraints.
             * @param constraints Constraints associated with the Job
             * @return the next definition stage
             */
            WithCreate withConstraints(JobBasePropertiesConstraints constraints);
        }

        /**
         * The stage of the job definition allowing to specify ContainerSettings.
         */
        interface WithContainerSettings {
            /**
             * Specifies containerSettings.
             * @param containerSettings Docker container settings for the job. If not provided, the job will run directly on the node
             * @return the next definition stage
             */
            WithCreate withContainerSettings(ContainerSettings containerSettings);
        }

        /**
         * The stage of the job definition allowing to specify CustomMpiSettings.
         */
        interface WithCustomMpiSettings {
            /**
             * Specifies customMpiSettings.
             * @param customMpiSettings Settings for custom MPI job
             * @return the next definition stage
             */
            WithCreate withCustomMpiSettings(CustomMpiSettings customMpiSettings);
        }

        /**
         * The stage of the job definition allowing to specify CustomToolkitSettings.
         */
        interface WithCustomToolkitSettings {
            /**
             * Specifies customToolkitSettings.
             * @param customToolkitSettings Settings for custom tool kit job
             * @return the next definition stage
             */
            WithCreate withCustomToolkitSettings(CustomToolkitSettings customToolkitSettings);
        }

        /**
         * The stage of the job definition allowing to specify EnvironmentVariables.
         */
        interface WithEnvironmentVariables {
            /**
             * Specifies environmentVariables.
             * @param environmentVariables A list of user defined environment variables which will be setup for the job
             * @return the next definition stage
             */
            WithCreate withEnvironmentVariables(List<EnvironmentVariable> environmentVariables);
        }

        /**
         * The stage of the job definition allowing to specify HorovodSettings.
         */
        interface WithHorovodSettings {
            /**
             * Specifies horovodSettings.
             * @param horovodSettings Settings for Horovod job
             * @return the next definition stage
             */
            WithCreate withHorovodSettings(HorovodSettings horovodSettings);
        }

        /**
         * The stage of the job definition allowing to specify InputDirectories.
         */
        interface WithInputDirectories {
            /**
             * Specifies inputDirectories.
             * @param inputDirectories A list of input directories for the job
             * @return the next definition stage
             */
            WithCreate withInputDirectories(List<InputDirectory> inputDirectories);
        }

        /**
         * The stage of the job definition allowing to specify JobPreparation.
         */
        interface WithJobPreparation {
            /**
             * Specifies jobPreparation.
             * @param jobPreparation A command line to be executed on each node allocated for the job before tool kit is launched
             * @return the next definition stage
             */
            WithCreate withJobPreparation(JobPreparation jobPreparation);
        }

        /**
         * The stage of the job definition allowing to specify MountVolumes.
         */
        interface WithMountVolumes {
            /**
             * Specifies mountVolumes.
             * @param mountVolumes Information on mount volumes to be used by the job. These volumes will be mounted before the job execution and will be unmounted after the job completion. The volumes will be mounted at location specified by $AZ_BATCHAI_JOB_MOUNT_ROOT environment variable
             * @return the next definition stage
             */
            WithCreate withMountVolumes(MountVolumes mountVolumes);
        }

        /**
         * The stage of the job definition allowing to specify OutputDirectories.
         */
        interface WithOutputDirectories {
            /**
             * Specifies outputDirectories.
             * @param outputDirectories A list of output directories for the job
             * @return the next definition stage
             */
            WithCreate withOutputDirectories(List<OutputDirectory> outputDirectories);
        }

        /**
         * The stage of the job definition allowing to specify PyTorchSettings.
         */
        interface WithPyTorchSettings {
            /**
             * Specifies pyTorchSettings.
             * @param pyTorchSettings Settings for pyTorch job
             * @return the next definition stage
             */
            WithCreate withPyTorchSettings(PyTorchSettings pyTorchSettings);
        }

        /**
         * The stage of the job definition allowing to specify SchedulingPriority.
         */
        interface WithSchedulingPriority {
            /**
             * Specifies schedulingPriority.
             * @param schedulingPriority Scheduling priority associated with the job. Possible values: low, normal, high. Possible values include: 'low', 'normal', 'high'
             * @return the next definition stage
             */
            WithCreate withSchedulingPriority(JobPriority schedulingPriority);
        }

        /**
         * The stage of the job definition allowing to specify Secrets.
         */
        interface WithSecrets {
            /**
             * Specifies secrets.
             * @param secrets A list of user defined environment variables with secret values which will be setup for the job. Server will never report values of these variables back
             * @return the next definition stage
             */
            WithCreate withSecrets(List<EnvironmentVariableWithSecretValue> secrets);
        }

        /**
         * The stage of the job definition allowing to specify TensorFlowSettings.
         */
        interface WithTensorFlowSettings {
            /**
             * Specifies tensorFlowSettings.
             * @param tensorFlowSettings Settings for Tensor Flow job
             * @return the next definition stage
             */
            WithCreate withTensorFlowSettings(TensorFlowSettings tensorFlowSettings);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<Job>, DefinitionStages.WithCaffe2Settings, DefinitionStages.WithCaffeSettings, DefinitionStages.WithChainerSettings, DefinitionStages.WithCntkSettings, DefinitionStages.WithConstraints, DefinitionStages.WithContainerSettings, DefinitionStages.WithCustomMpiSettings, DefinitionStages.WithCustomToolkitSettings, DefinitionStages.WithEnvironmentVariables, DefinitionStages.WithHorovodSettings, DefinitionStages.WithInputDirectories, DefinitionStages.WithJobPreparation, DefinitionStages.WithMountVolumes, DefinitionStages.WithOutputDirectories, DefinitionStages.WithPyTorchSettings, DefinitionStages.WithSchedulingPriority, DefinitionStages.WithSecrets, DefinitionStages.WithTensorFlowSettings {
        }
    }
    /**
     * The template for a Job update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<Job>, UpdateStages.WithCaffe2Settings, UpdateStages.WithCaffeSettings, UpdateStages.WithChainerSettings, UpdateStages.WithCntkSettings, UpdateStages.WithConstraints, UpdateStages.WithContainerSettings, UpdateStages.WithCustomMpiSettings, UpdateStages.WithCustomToolkitSettings, UpdateStages.WithEnvironmentVariables, UpdateStages.WithHorovodSettings, UpdateStages.WithInputDirectories, UpdateStages.WithJobPreparation, UpdateStages.WithMountVolumes, UpdateStages.WithOutputDirectories, UpdateStages.WithPyTorchSettings, UpdateStages.WithSchedulingPriority, UpdateStages.WithSecrets, UpdateStages.WithTensorFlowSettings {
    }

    /**
     * Grouping of Job update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the job update allowing to specify Caffe2Settings.
         */
        interface WithCaffe2Settings {
            /**
             * Specifies caffe2Settings.
             * @param caffe2Settings Settings for Caffe2 job
             * @return the next update stage
             */
            Update withCaffe2Settings(Caffe2Settings caffe2Settings);
        }

        /**
         * The stage of the job update allowing to specify CaffeSettings.
         */
        interface WithCaffeSettings {
            /**
             * Specifies caffeSettings.
             * @param caffeSettings Settings for Caffe job
             * @return the next update stage
             */
            Update withCaffeSettings(CaffeSettings caffeSettings);
        }

        /**
         * The stage of the job update allowing to specify ChainerSettings.
         */
        interface WithChainerSettings {
            /**
             * Specifies chainerSettings.
             * @param chainerSettings Settings for Chainer job
             * @return the next update stage
             */
            Update withChainerSettings(ChainerSettings chainerSettings);
        }

        /**
         * The stage of the job update allowing to specify CntkSettings.
         */
        interface WithCntkSettings {
            /**
             * Specifies cntkSettings.
             * @param cntkSettings Settings for CNTK (aka Microsoft Cognitive Toolkit) job
             * @return the next update stage
             */
            Update withCntkSettings(CNTKsettings cntkSettings);
        }

        /**
         * The stage of the job update allowing to specify Constraints.
         */
        interface WithConstraints {
            /**
             * Specifies constraints.
             * @param constraints Constraints associated with the Job
             * @return the next update stage
             */
            Update withConstraints(JobBasePropertiesConstraints constraints);
        }

        /**
         * The stage of the job update allowing to specify ContainerSettings.
         */
        interface WithContainerSettings {
            /**
             * Specifies containerSettings.
             * @param containerSettings Docker container settings for the job. If not provided, the job will run directly on the node
             * @return the next update stage
             */
            Update withContainerSettings(ContainerSettings containerSettings);
        }

        /**
         * The stage of the job update allowing to specify CustomMpiSettings.
         */
        interface WithCustomMpiSettings {
            /**
             * Specifies customMpiSettings.
             * @param customMpiSettings Settings for custom MPI job
             * @return the next update stage
             */
            Update withCustomMpiSettings(CustomMpiSettings customMpiSettings);
        }

        /**
         * The stage of the job update allowing to specify CustomToolkitSettings.
         */
        interface WithCustomToolkitSettings {
            /**
             * Specifies customToolkitSettings.
             * @param customToolkitSettings Settings for custom tool kit job
             * @return the next update stage
             */
            Update withCustomToolkitSettings(CustomToolkitSettings customToolkitSettings);
        }

        /**
         * The stage of the job update allowing to specify EnvironmentVariables.
         */
        interface WithEnvironmentVariables {
            /**
             * Specifies environmentVariables.
             * @param environmentVariables A list of user defined environment variables which will be setup for the job
             * @return the next update stage
             */
            Update withEnvironmentVariables(List<EnvironmentVariable> environmentVariables);
        }

        /**
         * The stage of the job update allowing to specify HorovodSettings.
         */
        interface WithHorovodSettings {
            /**
             * Specifies horovodSettings.
             * @param horovodSettings Settings for Horovod job
             * @return the next update stage
             */
            Update withHorovodSettings(HorovodSettings horovodSettings);
        }

        /**
         * The stage of the job update allowing to specify InputDirectories.
         */
        interface WithInputDirectories {
            /**
             * Specifies inputDirectories.
             * @param inputDirectories A list of input directories for the job
             * @return the next update stage
             */
            Update withInputDirectories(List<InputDirectory> inputDirectories);
        }

        /**
         * The stage of the job update allowing to specify JobPreparation.
         */
        interface WithJobPreparation {
            /**
             * Specifies jobPreparation.
             * @param jobPreparation A command line to be executed on each node allocated for the job before tool kit is launched
             * @return the next update stage
             */
            Update withJobPreparation(JobPreparation jobPreparation);
        }

        /**
         * The stage of the job update allowing to specify MountVolumes.
         */
        interface WithMountVolumes {
            /**
             * Specifies mountVolumes.
             * @param mountVolumes Information on mount volumes to be used by the job. These volumes will be mounted before the job execution and will be unmounted after the job completion. The volumes will be mounted at location specified by $AZ_BATCHAI_JOB_MOUNT_ROOT environment variable
             * @return the next update stage
             */
            Update withMountVolumes(MountVolumes mountVolumes);
        }

        /**
         * The stage of the job update allowing to specify OutputDirectories.
         */
        interface WithOutputDirectories {
            /**
             * Specifies outputDirectories.
             * @param outputDirectories A list of output directories for the job
             * @return the next update stage
             */
            Update withOutputDirectories(List<OutputDirectory> outputDirectories);
        }

        /**
         * The stage of the job update allowing to specify PyTorchSettings.
         */
        interface WithPyTorchSettings {
            /**
             * Specifies pyTorchSettings.
             * @param pyTorchSettings Settings for pyTorch job
             * @return the next update stage
             */
            Update withPyTorchSettings(PyTorchSettings pyTorchSettings);
        }

        /**
         * The stage of the job update allowing to specify SchedulingPriority.
         */
        interface WithSchedulingPriority {
            /**
             * Specifies schedulingPriority.
             * @param schedulingPriority Scheduling priority associated with the job. Possible values: low, normal, high. Possible values include: 'low', 'normal', 'high'
             * @return the next update stage
             */
            Update withSchedulingPriority(JobPriority schedulingPriority);
        }

        /**
         * The stage of the job update allowing to specify Secrets.
         */
        interface WithSecrets {
            /**
             * Specifies secrets.
             * @param secrets A list of user defined environment variables with secret values which will be setup for the job. Server will never report values of these variables back
             * @return the next update stage
             */
            Update withSecrets(List<EnvironmentVariableWithSecretValue> secrets);
        }

        /**
         * The stage of the job update allowing to specify TensorFlowSettings.
         */
        interface WithTensorFlowSettings {
            /**
             * Specifies tensorFlowSettings.
             * @param tensorFlowSettings Settings for Tensor Flow job
             * @return the next update stage
             */
            Update withTensorFlowSettings(TensorFlowSettings tensorFlowSettings);
        }

    }
}