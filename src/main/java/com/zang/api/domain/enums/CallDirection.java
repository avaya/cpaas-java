package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum CallDirection {
    INBOUND, OUTBOUND_API, OUTBOUND_DIAL, UNKNOWN;

    private static Map<CallDirection, String> map;

    static {
        map = new HashMap<CallDirection, String>();
        map.put(INBOUND, "inbound");
        map.put(OUTBOUND_API, "outbound-api");
        map.put(OUTBOUND_DIAL, "outbound-dial");
    }

    @JsonCreator
    public static CallDirection forValue(String s) {
        return EnumUtil.getValue(s, map, UNKNOWN);
    }

    @Override
    public String toString() {
        return map.get(this);
    }

}
