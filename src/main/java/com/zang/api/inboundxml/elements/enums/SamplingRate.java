package com.zang.api.inboundxml.elements.enums;

import com.zang.api.domain.enums.util.EnumUtil;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;


@XmlType(name = "sample_rate")
@XmlEnum
public enum SamplingRate {
    @XmlEnumValue("8000")
    SR_8000,
    @XmlEnumValue("16000")
    SR_16000,
    @XmlEnumValue("32000")
    SR_32000,
    @XmlEnumValue("48000")
    SR_48000;

    private static Map<SamplingRate, String> map;

    static {
        map = new HashMap<SamplingRate, String>();
        map.put(SR_8000, "8000");
        map.put(SR_16000, "16000");
        map.put(SR_32000, "32000");
        map.put(SR_48000, "48000");

    }

    public static SamplingRate forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}