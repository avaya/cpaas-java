package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "url"
})
@XmlRootElement(name = "Ping")
public class Ping implements ResponseElement {

    @XmlValue
    protected String url;
    @XmlAttribute(name = "method")
    protected HttpMethod method;

    public static PingBuilder builder() {
        return new PingBuilder();
    }

    public Ping() {
    }

    public Ping(String url, HttpMethod method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }

}
