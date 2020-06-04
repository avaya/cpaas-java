package com.zang.api.inboundxml.elements;

public class PauseBuilder {
    private Integer length;

    PauseBuilder() {
    }

    /**
     * The length in seconds the pause should be. Default Value: 1. Allowed Value: integer greater than 0, less than 99999
     * @param length
     * @return
     */
    public PauseBuilder setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Pause build() {
        return new Pause(length);
    }
}