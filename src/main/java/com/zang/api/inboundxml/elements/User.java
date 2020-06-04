package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "User")
public class User implements DialElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;
    @XmlAttribute(name = "params")
    protected String params;

    public UserBuilder builder() {
        return new UserBuilder();
    }

    public User() {
    }

    public User(String content, String sendDigits, String params) {
        this.content = content;
        this.sendDigits = sendDigits;
        this.params = params;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public String getSendDigits() {
        return sendDigits;
    }


    public void setSendDigits(String value) {
        this.sendDigits = value;
    }


    public String getParams() {
        return params;
    }


    public void setParams(String value) {
        this.params = value;
    }

}
