package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for communicating with the Sip Domains endpoint.
 * @see com.zang.api.connectors.SipDomainsConnector
 * @see DomainParams
 */
public class DomainParamsBuilder {
    private String accountSid;
    private String domainSid;
    private String domainName;
    private String friendlyName;
    private String voiceUrl;
    private HttpMethod voiceMethod;
    private String voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String voiceStatusCallback;
    private HttpMethod voiceStatusCallbackMethod;

    DomainParamsBuilder() {

    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public DomainParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Used only for update domain requests. Domain SID.
     * @param domainSid
     * @return
     */
    public DomainParamsBuilder setDomainSid(String domainSid) {
        this.domainSid = domainSid;
        return this;
    }

    /**
     * Used only for create domain requests. An address on Zang uniquely associated with your account and through which all your SIP traffic is routed.
     * @param domainName
     * @return
     */
    public DomainParamsBuilder setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * A human-readable name associated with this domain.
     * @param friendlyName
     * @return
     */
    public DomainParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The URL requested when a call is received by your domain.
     * @param voiceUrl
     * @return
     */
    public DomainParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The HTTP method used when requesting the VoiceUrl.
     * @param voiceMethod
     * @return
     */
    public DomainParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL requested if the VoiceUrl fails.
     * @param voiceFallbackUrl
     * @return
     */
    public DomainParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The HTTP method used when requesting the VoiceFallbackUrl.
     * @param voiceFallbackMethod
     * @return
     */
    public DomainParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * URL that can be requested every 60 seconds during the call to notify of elapsed time and pass other general
     * information.
     * @param heartbeatUrl
     * @return
     */
    public DomainParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    /**
     * Specifies the HTTP method used to request HeartbeatUrl.
     * @param heartbeatMethod
     * @return
     */
    public DomainParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    /**
     * The URL that Zang will use to send you status notifications regarding your SIP call.
     * @param voiceStatusCallback
     * @return
     */
    public DomainParamsBuilder setVoiceStatusCallback(String voiceStatusCallback) {
        this.voiceStatusCallback = voiceStatusCallback;
        return this;
    }

    /**
     * The HTTP method used when requesting the VoiceStatusCallback.
     * @param voiceStatusCallbackMethod
     * @return
     */
    public DomainParamsBuilder setVoiceStatusCallbackMethod(HttpMethod voiceStatusCallbackMethod) {
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
        return this;
    }

    public DomainParams build() {
        return new DomainParams(accountSid, domainSid, domainName, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusCallbackMethod);
    }
}