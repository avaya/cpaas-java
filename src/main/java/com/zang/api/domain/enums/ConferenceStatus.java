package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum ConferenceStatus {
    INIT, IN_PROGRESS, COMPLETED;

    private static Map<ConferenceStatus, String> map;

    static {
        map = new HashMap<ConferenceStatus, String>();
        map.put(INIT, "init");
        map.put(IN_PROGRESS, "in-progress");
        map.put(COMPLETED, "completed");
    }

    @JsonCreator
    public static ConferenceStatus forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}