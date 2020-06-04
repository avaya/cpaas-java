package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.RejectReason;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "Hangup")
public class Hangup implements ResponseElement {

    @XmlAttribute(name = "schedule")
    protected Integer schedule;
    @XmlAttribute(name = "reason")
    protected RejectReason reason;

    public static HangupBuilder builder() {
        return new HangupBuilder();
    }


    public Hangup() {
    }

    public Hangup(Integer schedule, RejectReason reason) {
        this.schedule = schedule;
        this.reason = reason;
    }


    public Integer getSchedule() {
        return schedule;
    }


    public void setSchedule(Integer value) {
        this.schedule = value;
    }


    public RejectReason getReason() {
        return reason;
    }


    public void setReason(RejectReason value) {
        this.reason = value;
    }

}
