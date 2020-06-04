package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "url"
})
@XmlRootElement(name = "Play")
public class Play implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlValue
    protected String url;
    @XmlAttribute(name = "loop")
    protected Integer loop;
    @XmlAttribute(name = "method")
    protected HttpMethod method;

    public static PlayBuilder builder() {
        return new PlayBuilder();
    }

    public Play() {
    }

    public Play(String url, Integer loop, HttpMethod method) {
        this.url = url;
        this.loop = loop;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public Integer getLoop() {
        return loop;
    }


    public void setLoop(Integer value) {
        this.loop = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }

}
