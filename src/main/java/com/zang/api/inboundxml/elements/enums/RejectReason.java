package com.zang.api.inboundxml.elements.enums;

import com.zang.api.domain.enums.util.EnumUtil;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum RejectReason {
    @XmlEnumValue("busy")
    BUSY,
    @XmlEnumValue("rejected")
    REJECTED;

    private static Map<RejectReason, String> map;

    static {
        map = new HashMap<RejectReason, String>();
        map.put(BUSY, "busy");
        map.put(REJECTED, "rejected");
    }

    public static RejectReason forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}