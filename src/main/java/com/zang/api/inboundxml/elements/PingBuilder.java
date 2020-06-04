package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class PingBuilder {
    private String url;
    private HttpMethod method;

    PingBuilder() {
    }

    /**
     * Url you wish to ping (send default voice request parmeters to).
     * @param url
     * @return
     */
    public PingBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Method used to request ping url. Default Value: POST.
     * @param method
     * @return
     */
    public PingBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Ping build() {
        return new Ping(url, method);
    }
}