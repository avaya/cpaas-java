package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class SmsBuilder {
    private String text;
    private String to;
    private String from;
    private String action;
    private HttpMethod method;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;

    SmsBuilder() {
    }

    /**
     * Text to send in the SMS.
     * @param text
     * @return
     */
    public SmsBuilder setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * The phone number that will receive the SMS message. If this parameter is not specified, the SMS will be sent back to the number that made the request to the Zang number’s SMS request URL.
     * @param to
     * @return
     */
    public SmsBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    /**
     * The number that will display as sending the SMS message. This should be one of your Zang numbers. If this parameter is not specified, the default from number is the Zang number hosting the SMS request URL.
     * @param from
     * @return
     */
    public SmsBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    /**
     * URL to direct Zang to once the <Sms> element is executed. Parameters specific to <Sms> are sent here along with the request.
     * @param action
     * @return
     */
    public SmsBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Method used to request the action URL. Default Value: POST.
     * @param method
     * @return
     */
    public SmsBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * URL where the status of the SMS can be sent.
     * @param statusCallback
     * @return
     */
    public SmsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public SmsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public Sms build() {
        return new Sms(text, to, from, action, method, statusCallback, statusCallbackMethod);
    }
}