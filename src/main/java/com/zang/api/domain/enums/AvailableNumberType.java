package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum AvailableNumberType {
    LOCAL, TOLLFREE;

    private static Map<AvailableNumberType, String> map;

    static {
        map = new HashMap<AvailableNumberType, String>();
        map.put(LOCAL, "Local");
        map.put(TOLLFREE, "Tollfree");
    }

    @JsonCreator
    public static AvailableNumberType forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
