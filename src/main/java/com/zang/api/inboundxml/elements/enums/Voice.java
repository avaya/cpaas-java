package com.zang.api.inboundxml.elements.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "say_voice")
@XmlEnum
public enum Voice {

    @XmlEnumValue("female")
    FEMALE("female"),
    @XmlEnumValue("male")
    MALE("male");
    private final String value;

    Voice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Voice fromValue(String v) {
        for (Voice c : Voice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
