package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class PlayBuilder {
    private String url;
    private Integer loop;
    private HttpMethod method;

    PlayBuilder() {
    }

    /**
     * URL of audio file you wish to play.
     * @param url
     * @return
     */
    public PlayBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * The amount of times the <Play> should be repeated. 0 indicates an infinite loop. The default value is 1. Allowed values are integers greater than or equal to 0.
     * @param loop
     * @return
     */
    public PlayBuilder setLoop(Integer loop) {
        this.loop = loop;
        return this;
    }

    public PlayBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Play build() {
        return new Play(url, loop, method);
    }
}