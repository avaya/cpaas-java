package com.zang.api.inboundxml.elements.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "gather_input")
@XmlEnum
public enum GatherInput {

    @XmlEnumValue("speech")
    SPEECH("speech"),
    @XmlEnumValue("dtmf")
    DTMF("dtmf"),
    @XmlEnumValue("speech dtmf")
    SPEECH_DTMF("speech dtmf");
    
    private final String value;

    GatherInput(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GatherInput fromValue(String v) {
        for (GatherInput c : GatherInput.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
