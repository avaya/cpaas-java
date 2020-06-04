package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum RecordingAudioDirection {
    @XmlEnumValue("in")
    IN,
    @XmlEnumValue("out")
    OUT,
    @XmlEnumValue("both")
    BOTH;

    private static Map<RecordingAudioDirection, String> map;

    static {
        map = new HashMap<RecordingAudioDirection, String>();
        map.put(IN, "in");
        map.put(OUT, "out");
        map.put(BOTH, "both");
    }

    @JsonCreator
    public static RecordingAudioDirection forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
