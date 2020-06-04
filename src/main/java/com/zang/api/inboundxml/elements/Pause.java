package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "Pause")
public class Pause implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlAttribute(name = "length")
    protected Integer length;

    public static PauseBuilder builder() {
        return new PauseBuilder();
    }

    public Pause() {
    }

    public Pause(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }


    public void setLength(Integer value) {
        this.length = value;
    }

}
