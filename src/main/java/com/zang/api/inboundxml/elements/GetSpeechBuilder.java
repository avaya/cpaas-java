package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class GetSpeechBuilder {
    private List<GetSpeechElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private Boolean playBeep;
    private String grammar;

    GetSpeechBuilder() {
        this.content = new ArrayList<GetSpeechElement>();
    }

    /**
     * Adds an element to the GetSpeech element.
     * @param element
     * @return
     */
    public GetSpeechBuilder addElement(GetSpeechElement element) {
        this.content.add(element);
        return this;
    }

    /**
     * Adds a Say element to the GetSpeech element.
     * @param say
     * @return
     */
    public GetSpeechBuilder say(Say say) {
        this.content.add(say);
        return this;
    }

    /**
     * Adds a Play element to the GetSpeech element.
     * @param play
     * @return
     */
    public GetSpeechBuilder play(Play play) {
        this.content.add(play);
        return this;
    }

    /**
     * Adds a Pause element to the GetSpeech element.
     * @param pause
     * @return
     */
    public GetSpeechBuilder pause(Pause pause) {
        this.content.add(pause);
        return this;
    }

    /**
     * Adds a PlayLastRecording element to the GetSpeech element.
     * @param playLastRecording
     * @return
     */
    public GetSpeechBuilder playLastRecording(PlayLastRecording playLastRecording) {
        this.content.add(playLastRecording);
        return this;
    }

    /**
     * Replaces the whole content of the GetSpeech element.
     * @param content
     * @return
     */
    public GetSpeechBuilder setContent(List<GetSpeechElement> content) {
        this.content = content;
        return this;
    }

    public GetSpeechBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public GetSpeechBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public GetSpeechBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public GetSpeechBuilder setPlayBeep(Boolean playBeep) {
        this.playBeep = playBeep;
        return this;
    }

    public GetSpeechBuilder setGrammar(String grammar) {
        this.grammar = grammar;
        return this;
    }

    public GetSpeech build() {
        return new GetSpeech(content, action, method, timeout, playBeep, grammar);
    }
}