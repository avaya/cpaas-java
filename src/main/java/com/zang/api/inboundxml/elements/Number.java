package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "number"
})
@XmlRootElement(name = "Number")
public class Number implements DialElement {

    @XmlValue
    protected String number;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlAttribute(name = "sendOnPreanswer")
    protected Boolean sendOnPreanswer;

    public static NumberBuilder builder() {
        return new NumberBuilder();
    }

    public Number() {
    }

    public Number(String number, String sendDigits, HttpMethod method, String url, Boolean sendOnPreanswer) {
        this.number = number;
        this.sendDigits = sendDigits;
        this.method = method;
        this.url = url;
        this.sendOnPreanswer = sendOnPreanswer;
    }

    public String getNumber() {
        return number;
    }


    public void setNumber(String value) {
        this.number = value;
    }


    public String getSendDigits() {
        return sendDigits;
    }


    public void setSendDigits(String value) {
        this.sendDigits = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String value) {
        this.url = value;
    }


    public Boolean getSendOnPreanswer() {
        return sendOnPreanswer;
    }


    public void setSendOnPreanswer(Boolean value) {
        this.sendOnPreanswer = value;
    }

}
