package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for communicating with the Applications endpoint.
 * @see com.zang.api.connectors.ApplicationsConnector
 * @see ApplicationParamsBuilder
 */
public class ApplicationParams {
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

    /**
     * Utility class for creating ApplicationParams objects.
     * @return ApplicationParamsBuilder
     */
    public static ApplicationParamsBuilder builder() {
        return new ApplicationParamsBuilder();
    }

    /**
     * @see ApplicationParamsBuilder
     */
    public ApplicationParams() {
    }

    /**
     * @see ApplicationParamsBuilder
     */
    public ApplicationParams(String accountSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) {
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.voiceUrl = voiceUrl;
        this.voiceMethod = voiceMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.smsUrl = smsUrl;
        this.smsMethod = smsMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsFallbackMethod = smsFallbackMethod;
        this.heartbeatUrl = heartbeatUrl;
        this.heartbeatMethod = heartbeatMethod;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.hangupCallback = hangupCallback;
        this.hangupCallbackMethod = hangupCallbackMethod;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public HttpMethod getVoiceMethod() {
        return voiceMethod;
    }

    public void setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
    }

    public String getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    public void setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
    }

    public HttpMethod getVoiceFallbackMethod() {
        return voiceFallbackMethod;
    }

    public void setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
    }

    public Boolean getVoiceCallerIdLookup() {
        return voiceCallerIdLookup;
    }

    public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public HttpMethod getSmsMethod() {
        return smsMethod;
    }

    public void setSmsMethod(HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
    }

    public String getSmsFallbackUrl() {
        return smsFallbackUrl;
    }

    public void setSmsFallbackUrl(String smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
    }

    public HttpMethod getSmsFallbackMethod() {
        return smsFallbackMethod;
    }

    public void setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
    }

    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    public void setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
    }

    public HttpMethod getHeartbeatMethod() {
        return heartbeatMethod;
    }

    public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
    }

    public String getStatusCallback() {
        return statusCallback;
    }

    public void setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
    }

    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    public void setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
    }

    public String getHangupCallback() {
        return hangupCallback;
    }

    public void setHangupCallback(String hangupCallback) {
        this.hangupCallback = hangupCallback;
    }

    public HttpMethod getHangupCallbackMethod() {
        return hangupCallbackMethod;
    }

    public void setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
        this.hangupCallbackMethod = hangupCallbackMethod;
    }
}
