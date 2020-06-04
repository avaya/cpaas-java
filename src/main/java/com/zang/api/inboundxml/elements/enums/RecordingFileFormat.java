package com.zang.api.inboundxml.elements.enums;

import com.zang.api.domain.enums.util.EnumUtil;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum RecordingFileFormat {
    @XmlEnumValue("mp3")
    MP3,
    @XmlEnumValue("wav")
    WAV;

    private static Map<RecordingFileFormat, String> map;

    static {
        map = new HashMap<RecordingFileFormat, String>();
        map.put(MP3, "mp3");
        map.put(WAV, "wav");
    }

    public static RecordingFileFormat forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
