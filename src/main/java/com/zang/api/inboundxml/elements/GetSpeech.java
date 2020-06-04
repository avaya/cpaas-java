package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "GetSpeech")
public class GetSpeech implements ResponseElement {

    @XmlElementRefs({
            @XmlElementRef(name = "Pause", type = Pause.class, required = false),
            @XmlElementRef(name = "Say", type = Say.class, required = false),
            @XmlElementRef(name = "Play", type = Play.class, required = false),
            @XmlElementRef(name = "PlayLastRecording", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<GetSpeechElement> content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "timeout")
    protected Integer timeout;
    @XmlAttribute(name = "playBeep")
    protected Boolean playBeep;
    @XmlAttribute(name = "grammar", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String grammar;

    public static GetSpeechBuilder builder() {
        return new GetSpeechBuilder();
    }

    public GetSpeech() {
    }

    public GetSpeech(List<GetSpeechElement> content, String action, HttpMethod method, Integer timeout, Boolean playBeep, String grammar) {
        this.content = content;
        this.action = action;
        this.method = method;
        this.timeout = timeout;
        this.playBeep = playBeep;
        this.grammar = grammar;
    }


    public List<GetSpeechElement> getContent() {
        if (content == null) {
            content = new ArrayList<GetSpeechElement>();
        }
        return this.content;
    }

    public void setContent(List<GetSpeechElement> content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }


    public void setAction(String value) {
        this.action = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }


    public Integer getTimeout() {
        return timeout;
    }


    public void setTimeout(Integer value) {
        this.timeout = value;
    }


    public Boolean getPlayBeep() {
        return playBeep;
    }


    public void setPlayBeep(Boolean value) {
        this.playBeep = value;
    }


    public String getGrammar() {
        return grammar;
    }


    public void setGrammar(String value) {
        this.grammar = value;
    }

}
