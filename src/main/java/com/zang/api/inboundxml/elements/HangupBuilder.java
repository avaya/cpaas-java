package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.RejectReason;

public class HangupBuilder {
    private Integer schedule;
    private RejectReason reason;

    HangupBuilder() {
    }

    /**
     * Specifies in seconds when a hangup should occur during a call. Allowed Value: integer greater than or equal to 0
     * @param schedule
     * @return
     */
    public HangupBuilder setSchedule(Integer schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * Reason for the hangup. It can be rejected or busy. Default is none.
     * @param reason
     * @return
     */
    public HangupBuilder setReason(RejectReason reason) {
        this.reason = reason;
        return this;
    }

    public Hangup build() {
        return new Hangup(schedule, reason);
    }
}