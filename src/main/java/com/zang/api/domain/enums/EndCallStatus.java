package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum EndCallStatus {
    CANCELED, COMPLETED;

    private static Map<EndCallStatus, String> map;

    static {
        map = new HashMap<EndCallStatus, String>();
        map.put(CANCELED, "canceled");
        map.put(COMPLETED, "completed");
    }

    @JsonCreator
    public static EndCallStatus forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}