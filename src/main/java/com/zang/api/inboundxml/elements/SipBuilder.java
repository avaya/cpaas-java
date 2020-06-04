package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class SipBuilder {
    private String sipAddress;
    private String action;
    private HttpMethod method;
    private String username;
    private String password;
    private String sendDigits;

    SipBuilder() {
    }

    /**
     * Sip address to call.
     * @param sipAddress
     * @return
     */
    public SipBuilder setSipAddress(String sipAddress) {
        this.sipAddress = sipAddress;
        return this;
    }

    public SipBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public SipBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * If provided, will be passed along as sip authentication username.
     * @param username
     * @return
     */
    public SipBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * If provided, will be passed along as sip authentication password.
     * @param password
     * @return
     */
    public SipBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public SipBuilder setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    public Sip build() {
        return new Sip(sipAddress, action, method, username, password, sendDigits);
    }
}