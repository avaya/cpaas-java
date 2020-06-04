package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.RejectReason;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "Reject")
public class Reject implements ResponseElement {

    @XmlAttribute(name = "reason")
    protected RejectReason reason;

    public static RejectBuilder builder() {
        return new RejectBuilder();
    }

    public Reject() {
    }

    public Reject(RejectReason reason) {
        this.reason = reason;
    }

    public RejectReason getReason() {
        return reason;
    }


    public void setReason(RejectReason value) {
        this.reason = value;
    }

}
