package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for communicating with the Applications endpoint.
 * @see com.zang.api.connectors.ApplicationsConnector
 * @see ApplicationParams
 */
public class ApplicationParamsBuilder {
    private String accountSid;
    private String friendlyName;
    private String voiceUrl;
    private HttpMethod voiceMethod;
    private String voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private Boolean voiceCallerIdLookup;
    private String smsUrl;
    private HttpMethod smsMethod;
    private String smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;
    private String hangupCallback;
    private HttpMethod hangupCallbackMethod;

    ApplicationParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public ApplicationParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Friendly name for the new application
     * @param friendlyName
     * @return
     */
    public ApplicationParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The URL requested once the call connects. This URL must be valid and should return InboundXML
     * containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     * the FallbackUrl but return an error without placing the call. Url length is limited
     * to 200 characters.
     * @param voiceUrl
     * @return
     */
    public ApplicationParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The HTTP method used to request the URL once the call connects.
     * @param voiceMethod
     * @return
     */
    public ApplicationParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * URL used if the required URL is unavailable or if any errors occur during execution of
     * the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackUrl
     * @return
     */
    public ApplicationParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The HTTP method used to request the FallbackUrl once the call connects.
     * @param voiceFallbackMethod
     * @return
     */
    public ApplicationParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param voiceCallerIdLookup
     * @return
     */
    public ApplicationParamsBuilder setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The URL requested when an SMS is received. This URL must be valid and should return InboundXML
     * containing instructions on how to process the SMS. A badly formatted URL will NOT fallback to the
     * FallbackUrl but return an error without placing the call. URL length is limited to 200 characters.
     * @param smsUrl
     * @return
     */
    public ApplicationParamsBuilder setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The HTTP method used to request the URL when an SMS is received.
     * @param smsMethod
     * @return
     */
    public ApplicationParamsBuilder setSmsMethod(HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * URL used if the required URL is unavailable or if any errors occur during execution of
     * the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param smsFallbackUrl
     * @return
     */
    public ApplicationParamsBuilder setSmsFallbackUrl(String smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The HTTP method used to request the smsFallbackUrl when an SMS is received.
     * @param smsFallbackMethod
     * @return
     */
    public ApplicationParamsBuilder setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * A URL that will be requested every 60 seconds during the call, sending information about
     * the call. The HeartbeatUrl will NOT be requested unless at least 60 seconds of call time
     * have elapsed. URL length is limited to 200 characters.
     * @param heartbeatUrl
     * @return
     */
    public ApplicationParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    /**
     * The HTTP method used to request the HeartbeatUrl.
     * @param heartbeatMethod
     * @return
     */
    public ApplicationParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    /**
     * A URL that will be requested when the call connects and ends, sending information about
     * the call. URL length is limited to 200 characters.
     * @param statusCallback
     * @return
     */
    public ApplicationParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The HTTP method used to request the StatusCallback URL.
     * @param statusCallbackMethod
     * @return
     */
    public ApplicationParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * This is a StatusCallback clone that will be phased out in future versions.
     * @param hangupCallback
     * @return
     */
    public ApplicationParamsBuilder setHangupCallback(String hangupCallback) {
        this.hangupCallback = hangupCallback;
        return this;
    }

    /**
     * This is a StatusCallbackMethod clone that will be phased out in future versions.
     * @param hangupCallbackMethod
     * @return
     */
    public ApplicationParamsBuilder setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
        this.hangupCallbackMethod = hangupCallbackMethod;
        return this;
    }

    public ApplicationParams build() {
        return new ApplicationParams(accountSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }
}