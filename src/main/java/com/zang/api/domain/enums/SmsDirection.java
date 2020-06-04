package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum SmsDirection {
    OUTBOUND_API, INCOMING, OUTBOUND_CALL, OUTBOUND_REPLY, UNKNOWN;

    private static Map<SmsDirection, String> map;

    static {
        map = new HashMap<SmsDirection, String>();
        map.put(OUTBOUND_API, "outbound-api");
        map.put(INCOMING, "incoming");
        map.put(OUTBOUND_CALL, "outbound-call");
        map.put(OUTBOUND_REPLY, "outbound-reply");
    }

    @JsonCreator
    public static SmsDirection forValue(String s) {
        return EnumUtil.getValue(s, map, UNKNOWN);
    }

    @Override
    public String toString() {
        return map.get(this);
    }

}
