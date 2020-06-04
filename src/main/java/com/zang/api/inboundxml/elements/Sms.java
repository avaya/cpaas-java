package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "text"
})
@XmlRootElement(name = "Sms")
public class Sms implements ResponseElement {

    @XmlValue
    protected String text;
    @XmlAttribute(name = "to", required = true)
    protected String to;
    @XmlAttribute(name = "from", required = true)
    protected String from;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "statusCallback")
    @XmlSchemaType(name = "anyURI")
    protected String statusCallback;
    @XmlAttribute(name = "statusCallbackMethod")
    protected HttpMethod statusCallbackMethod;

    public static SmsBuilder builder() {
        return new SmsBuilder();
    }

    public Sms() {
    }

    public Sms(String text, String to, String from, String action, HttpMethod method, String statusCallback, HttpMethod statusCallbackMethod) {
        this.text = text;
        this.to = to;
        this.from = from;
        this.action = action;
        this.method = method;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getTo() {
        return to;
    }


    public void setTo(String value) {
        this.to = value;
    }


    public String getFrom() {
        return from;
    }


    public void setFrom(String value) {
        this.from = value;
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


    public String getStatusCallback() {
        return statusCallback;
    }


    public void setStatusCallback(String value) {
        this.statusCallback = value;
    }


    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }


    public void setStatusCallbackMethod(HttpMethod value) {
        this.statusCallbackMethod = value;
    }

}
