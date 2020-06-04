package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sipAddress"
})
@XmlRootElement(name = "Sip")
public class Sip implements DialElement {

    @XmlValue
    protected String sipAddress;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "username")
    protected String username;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;

    public static SipBuilder builder() {
        return new SipBuilder();
    }

    public Sip() {
    }

    public Sip(String sipAddress, String action, HttpMethod method, String username, String password, String sendDigits) {
        this.sipAddress = sipAddress;
        this.action = action;
        this.method = method;
        this.username = username;
        this.password = password;
        this.sendDigits = sendDigits;
    }

    public String getSipAddress() {
        return sipAddress;
    }


    public void setSipAddress(String sipAddress) {
        this.sipAddress = sipAddress;
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


    public String getUsername() {
        return username;
    }


    public void setUsername(String value) {
        this.username = value;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String value) {
        this.password = value;
    }


    public String getSendDigits() {
        return sendDigits;
    }


    public void setSendDigits(String value) {
        this.sendDigits = value;
    }

}
