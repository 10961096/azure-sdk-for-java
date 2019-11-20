/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis.v2018_03_01;

import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Patch schedule entry for a Premium Redis Cache.
 */
public class ScheduleEntry {
    /**
     * Day of the week when a cache can be patched. Possible values include:
     * 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday',
     * 'Sunday', 'Everyday', 'Weekend'.
     */
    @JsonProperty(value = "dayOfWeek", required = true)
    private DayOfWeek dayOfWeek;

    /**
     * Start hour after which cache patching can start.
     */
    @JsonProperty(value = "startHourUtc", required = true)
    private int startHourUtc;

    /**
     * ISO8601 timespan specifying how much time cache patching can take.
     */
    @JsonProperty(value = "maintenanceWindow")
    private Period maintenanceWindow;

    /**
     * Get day of the week when a cache can be patched. Possible values include: 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Everyday', 'Weekend'.
     *
     * @return the dayOfWeek value
     */
    public DayOfWeek dayOfWeek() {
        return this.dayOfWeek;
    }

    /**
     * Set day of the week when a cache can be patched. Possible values include: 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Everyday', 'Weekend'.
     *
     * @param dayOfWeek the dayOfWeek value to set
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Get start hour after which cache patching can start.
     *
     * @return the startHourUtc value
     */
    public int startHourUtc() {
        return this.startHourUtc;
    }

    /**
     * Set start hour after which cache patching can start.
     *
     * @param startHourUtc the startHourUtc value to set
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withStartHourUtc(int startHourUtc) {
        this.startHourUtc = startHourUtc;
        return this;
    }

    /**
     * Get iSO8601 timespan specifying how much time cache patching can take.
     *
     * @return the maintenanceWindow value
     */
    public Period maintenanceWindow() {
        return this.maintenanceWindow;
    }

    /**
     * Set iSO8601 timespan specifying how much time cache patching can take.
     *
     * @param maintenanceWindow the maintenanceWindow value to set
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withMaintenanceWindow(Period maintenanceWindow) {
        this.maintenanceWindow = maintenanceWindow;
        return this;
    }

}