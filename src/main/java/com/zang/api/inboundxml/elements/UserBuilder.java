package com.zang.api.inboundxml.elements;

public class UserBuilder {
    private String content;
    private String sendDigits;
    private String params;

    UserBuilder() {
    }

    public UserBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public UserBuilder setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    public UserBuilder setParams(String params) {
        this.params = params;
        return this;
    }

    public User build() {
        return new User(content, sendDigits, params);
    }
}