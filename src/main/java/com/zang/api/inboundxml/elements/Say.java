package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "text"
})
@XmlRootElement(name = "Say")
public class Say implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlValue
    protected String text;
    @XmlAttribute(name = "loop")
    protected Integer loop;
    @XmlAttribute(name = "voice")
    protected Voice voice;
    @XmlAttribute(name = "language")
    protected Language language;

    public static SayBuilder builder() {
        return new SayBuilder();
    }

    public Say() {
    }

    public Say(String text, Integer loop, Voice voice, Language language) {
        this.text = text;
        this.loop = loop;
        this.voice = voice;
        this.language = language;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public Integer getLoop() {
        return loop;
    }


    public void setLoop(Integer value) {
        this.loop = value;
    }


    public Voice getVoice() {
        return voice;
    }


    public void setVoice(Voice value) {
        this.voice = value;
    }


    public Language getLanguage() {
        return language;
    }


    public void setLanguage(Language value) {
        this.language = value;
    }

}
