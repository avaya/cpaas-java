package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * When Zang receives an InboundXML document, the "instructions" are contained within the <Response> </Response>
 * elements. Zang begins reading at <Response> and behaves accordingly as it encounters each new instruction
 * element until the end of the </Response>. All InboundXML elements are camelCased and are categorized as either
 * Verbs or Nouns.
 */
public class ResponseBuilder {

    private List<ResponseElement> content;
    private String statusCallback;
    private HttpMethod statusMethod;
    private String heartbeatCallback;
    private HttpMethod heartbeatMethod;

    ResponseBuilder() {
        content = new ArrayList<ResponseElement>();
    }

    /**
     * Adds an element to the InboundXML
     * @param element
     * @return
     */
    public ResponseBuilder addElement(ResponseElement element) {
        content.add(element);
        return this;
    }

    /**
     * Adds a Dial element to the response.
     * @param dial
     * @return
     */
    public ResponseBuilder dial(Dial dial) {
        content.add(dial);
        return this;
    }

    /**
     * Adds a Gather element to the response.
     * @param gather
     * @return
     */
    public ResponseBuilder gather(Gather gather) {
        content.add(gather);
        return this;
    }

    /**
     * Adds a GetSpeech element to the response.
     * @param getSpeech
     * @return
     */
    public ResponseBuilder getSpeech(GetSpeech getSpeech) {
        content.add(getSpeech);
        return this;
    }

    /**
     * Adds a Hangup element to the response.
     * @param hangup
     * @return
     */
    public ResponseBuilder hangup(Hangup hangup) {
        content.add(hangup);
        return this;
    }

    /**
     * Adds a Pause element to the response.
     * @param pause
     * @return
     */
    public ResponseBuilder pause(Pause pause) {
        content.add(pause);
        return this;
    }

    /**
     * Adds a Ping element to the response.
     * @param ping
     * @return
     */
    public ResponseBuilder ping(Ping ping) {
        content.add(ping);
        return this;
    }

    /**
     * Adds a Play element to the response.
     * @param play
     * @return
     */
    public ResponseBuilder play(Play play) {
        content.add(play);
        return this;
    }

    /**
     * Adds a Record element to the response.
     * @param record
     * @return
     */
    public ResponseBuilder record(Record record) {
        content.add(record);
        return this;
    }

    /**
     * Adds a redirect element to the response.
     * @param redirect
     * @return
     */
    public ResponseBuilder redirect(Redirect redirect) {
        content.add(redirect);
        return this;
    }

    /**
     * Adds a Reject element to the response.
     * @param reject
     * @return
     */
    public ResponseBuilder reject(Reject reject) {
        content.add(reject);
        return this;
    }

    /**
     * Adds a Say element to the response.
     * @param say
     * @return
     */
    public ResponseBuilder say(Say say) {
        content.add(say);
        return this;
    }

    /**
     * Adds an SMS element to the response.
     * @param sms
     * @return
     */
    public ResponseBuilder sms(Sms sms) {
        content.add(sms);
        return this;
    }

    /**
     * Adds an MMS element to the response.
     * @param mms
     * @return
     */
    public ResponseBuilder mms(Mms mms) {
        content.add(mms);
        return this;
    }

    /**
     * Adds a PlayLastRecording element to the response.
     * @param playLastRecording
     * @return
     */
    public ResponseBuilder playLastRecording(PlayLastRecording playLastRecording) {
        this.content.add(playLastRecording);
        return this;
    }

    /**
     * Replaces the whole content of the Response element.
     * @param content
     * @return
     */
    public ResponseBuilder setContent(List<ResponseElement> content) {
        this.content = content;
        return this;
    }

    /**
     * Sets the status callback.
     * @param statusCallback
     * @return
     */
    public ResponseBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * Sets the status method.
     * @param statusMethod
     * @return
     */
    public ResponseBuilder setStatusMethod(HttpMethod statusMethod) {
        this.statusMethod = statusMethod;
        return this;
    }

    /**
     * Sets the heartbeat callback.
     * @param heartbeatCallback
     * @return
     */
    public ResponseBuilder setHeartbeatCallback(String heartbeatCallback) {
        this.heartbeatCallback = heartbeatCallback;
        return this;
    }

    /**
     * Sets the heartbeat method.
     * @param heartbeatMethod
     * @return
     */
    public ResponseBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public Response build() {
        return new Response(content, statusCallback, statusMethod, heartbeatCallback, heartbeatMethod);
    }
}