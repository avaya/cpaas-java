package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class RedirectBuilder {
    private String url;
    private HttpMethod method;

    RedirectBuilder() {
    }

    /**
     * The URL of the InboundXML document you wish to redirect to.
     * @param url
     * @return
     */
    public RedirectBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Method used to request the InboundXML document the call is being redirected to. Default Value: POST.
     * @param method
     * @return
     */
    public RedirectBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Redirect build() {
        return new Redirect(url, method);
    }
}