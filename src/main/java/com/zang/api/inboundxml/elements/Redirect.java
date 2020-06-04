package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "url"
})
@XmlRootElement(name = "Redirect")
public class Redirect implements ResponseElement {

    @XmlValue
    protected String url;
    @XmlAttribute(name = "method")
    protected HttpMethod method;

    public static RedirectBuilder builder() {
        return new RedirectBuilder();
    }

    public Redirect() {
    }

    public Redirect(String url, HttpMethod method) {
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
