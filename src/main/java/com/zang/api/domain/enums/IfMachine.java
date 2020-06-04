package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum IfMachine {
    @XmlEnumValue("continue")
    CONTINUE,
    @XmlEnumValue("redirect")
    REDIRECT,
    @XmlEnumValue("hangup")
    HANGUP;

    private static Map<IfMachine, String> map;

    static {
        map = new HashMap<IfMachine, String>();
        map.put(CONTINUE, "continue");
        map.put(REDIRECT, "redirect");
        map.put(HANGUP, "hangup");
    }

    @JsonCreator
    public static IfMachine forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
