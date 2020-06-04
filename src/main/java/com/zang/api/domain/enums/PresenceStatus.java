package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum PresenceStatus {
    INIT, IDLE, LOGGED_IN, LOGGED_OUT;

    private static Map<PresenceStatus, String> map;

    static {
        map = new HashMap<PresenceStatus, String>();
        map.put(INIT, "init");
        map.put(IDLE, "idle");
        map.put(LOGGED_IN, "loggedin");
        map.put(LOGGED_OUT, "loggedout");
    }

    @JsonCreator
    public static PresenceStatus forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}