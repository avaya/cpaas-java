package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum TranscriptionQuality {
    @XmlEnumValue("auto")
    AUTO,
    @XmlEnumValue("hybrid")
    HYBRID,
    @XmlEnumValue("keywords")
    KEYWORDS;

    private static Map<TranscriptionQuality, String> map;

    static {
        map = new HashMap<TranscriptionQuality, String>();
        map.put(AUTO, "auto");
        map.put(HYBRID, "hybrid");
        map.put(KEYWORDS, "keywords");
    }

    @JsonCreator
    public static TranscriptionQuality forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}