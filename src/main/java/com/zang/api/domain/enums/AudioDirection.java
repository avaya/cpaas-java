package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum AudioDirection {
    @XmlEnumValue("in")
    IN,
    @XmlEnumValue("out")
    OUT;

    private static Map<AudioDirection, String> map;

    static {
        map = new HashMap<AudioDirection, String>();
        map.put(IN, "in");
        map.put(OUT, "out");
    }

    @JsonCreator
    public static AudioDirection forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
