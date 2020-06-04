package com.zang.api.domain;

import com.zang.api.domain.enums.AuthType;
import com.zang.api.domain.enums.HttpMethod;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Domain extends BaseZangObject {

    @JsonProperty(value = "friendly_name")
    private String friendlyName;
    @JsonProperty(value = "domain_name")
    private String domainName;
    @JsonProperty(value = "auth_type")
    private AuthType authType;
    @JsonProperty(value = "voice_url")
    private String voiceUrl;
    @JsonProperty(value = "voice_method")
    private HttpMethod voiceMethod;
    @JsonProperty(value = "voice_fallback_url")
    private String voiceFallbackUrl;
    @JsonProperty(value = "voice_fallback_method")
    private HttpMethod voiceFallbackMethod;
    @JsonProperty(value = "voice_heartbeat_callback")
    private String voiceHeartbeatCallback;
    @JsonProperty(value = "voice_heartbeat_callback_method")
    private HttpMethod voiceHeartbeatCallbackMethod;
    @JsonProperty(value = "voice_status_callback_url")
    private String voiceStatusCallbackUrl;
    @JsonProperty(value = "voice_status_callback_method")
    private HttpMethod voiceStatusCallbackMethod;
    @JsonProperty(value = "domain_sip_url")
    private String domainSipUrl;
    @JsonProperty(value = "ip_access_control_list_mappings")
    private String ipAccessControlListMappings;
    @JsonProperty(value = "credential_list_mappings")
    private String credentialListMappings;

    @JsonProperty("subresource_uris")
    private DomainSubresourceUris subresourceUris;

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
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

    public String getVoiceHeartbeatCallback() {
        return voiceHeartbeatCallback;
    }

    public void setVoiceHeartbeatCallback(String voiceHeartbeatCallback) {
        this.voiceHeartbeatCallback = voiceHeartbeatCallback;
    }

    public HttpMethod getVoiceHeartbeatCallbackMethod() {
        return voiceHeartbeatCallbackMethod;
    }

    public void setVoiceHeartbeatCallbackMethod(HttpMethod voiceHeartbeatCallbackMethod) {
        this.voiceHeartbeatCallbackMethod = voiceHeartbeatCallbackMethod;
    }

    public String getVoiceStatusCallbackUrl() {
        return voiceStatusCallbackUrl;
    }

    public void setVoiceStatusCallbackUrl(String voiceStatusCallbackUrl) {
        this.voiceStatusCallbackUrl = voiceStatusCallbackUrl;
    }

    public HttpMethod getVoiceStatusCallbackMethod() {
        return voiceStatusCallbackMethod;
    }

    public void setVoiceStatusCallbackMethod(HttpMethod voiceStatusCallbackMethod) {
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
    }

    public String getDomainSipUrl() {
        return domainSipUrl;
    }

    public void setDomainSipUrl(String domainSipUrl) {
        this.domainSipUrl = domainSipUrl;
    }

    public String getIpAccessControlListMappings() {
        return ipAccessControlListMappings;
    }

    public void setIpAccessControlListMappings(String ipAccessControlListMappings) {
        this.ipAccessControlListMappings = ipAccessControlListMappings;
    }

    public String getCredentialListMappings() {
        return credentialListMappings;
    }

    public void setCredentialListMappings(String credentialListMappings) {
        this.credentialListMappings = credentialListMappings;
    }

    public DomainSubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

    public void setSubresourceUris(DomainSubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }
}
