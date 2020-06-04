package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "PlayLastRecording")
public class PlayLastRecording implements ResponseElement, GatherElement, GetSpeechElement {

    public static PlayLastRecordingBuilder builder() {
        return new PlayLastRecordingBuilder();
    }

    public PlayLastRecording() {
    }
}
