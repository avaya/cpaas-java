package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

public class SayBuilder {
    private String text;
    private Integer loop;
    private Voice voice;
    private Language language;

    SayBuilder() {
    }

    /**
     * The gender of the voice that will speak the text. Allowed values are "man" or "woman". The default value is "woman".
     * @param voice
     * @return
     */
    public SayBuilder setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    /**
     * Text to say.
     * @param text
     * @return
     */
    public SayBuilder setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * The amount of times the text should be repeated. Allowed values are any integer greater than or equal to 0. "0" indicates an infinite loop.
     * @param loop
     * @return
     */
    public SayBuilder setLoop(Integer loop) {
        this.loop = loop;
        return this;
    }

    /**
     * The language used to speak the text. Allowed values are "en" (American English), "en-gb" (British English), "es" (Spanish), "fr" (French), "it" (Italian) and "de" (German). The default value is "en"
     * @param language
     * @return
     */
    public SayBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Say build() {
        return new Say(text, loop, voice, language);
    }
}