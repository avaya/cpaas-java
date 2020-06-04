package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;

/**
 * Utility class for executing the Make Call request.
 * @see com.zang.api.connectors.CallsConnector
 * @see MakeCallParamsBuilder
 */
public class MakeCallParams {

    private String accountSid;
    private String to;
    private String from;
    private String url;
    private HttpMethod method;
    private String fallbackUrl;
    private HttpMethod fallbackMethod;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String forwardedFrom;
    private String playDtmf;
    private Integer timeout;
    private Boolean hideCallerId;
    private Boolean record;
    private String recordCallback;
    private HttpMethod recordCallbackMethod;
    private Boolean transcribe;
    private String transcribeCallback;
    private Boolean straightToVoicemail;
    private IfMachine ifMachine;
    private String ifMachineUrl;
    private HttpMethod ifMachineMethod;
    private String sipAuthUsername;
    private String sipAuthPassword;

    public static MakeCallParamsBuilder builder() {
        return new MakeCallParamsBuilder();
    }

    /**
     * @see MakeCallParamsBuilder
     */
    public MakeCallParams() {
    }

    /**
     * @see MakeCallParamsBuilder
     */
    public MakeCallParams(String accountSid, String to, String from, String url, HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod, String statusCallback, HttpMethod statusCallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom, String playDtmf, Integer timeout, Boolean hideCallerId, Boolean record, String recordCallback, HttpMethod recordCallbackMethod, Boolean transcribe, String transcribeCallback, Boolean straightToVoicemail, IfMachine ifMachine, String ifMachineUrl, HttpMethod ifMachineMethod, String sipAuthUsername, String sipAuthPassword) {
        this.accountSid = accountSid;
        this.to = to;
        this.from = from;
        this.url = url;
        this.method = method;
        this.fallbackUrl = fallbackUrl;
        this.fallbackMethod = fallbackMethod;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.heartbeatUrl = heartbeatUrl;
        this.heartbeatMethod = heartbeatMethod;
        this.forwardedFrom = forwardedFrom;
        this.playDtmf = playDtmf;
        this.timeout = timeout;
        this.hideCallerId = hideCallerId;
        this.record = record;
        this.recordCallback = recordCallback;
        this.recordCallbackMethod = recordCallbackMethod;
        this.transcribe = transcribe;
        this.transcribeCallback = transcribeCallback;
        this.straightToVoicemail = straightToVoicemail;
        this.ifMachine = ifMachine;
        this.ifMachineUrl = ifMachineUrl;
        this.ifMachineMethod = ifMachineMethod;
        this.sipAuthUsername = sipAuthUsername;
        this.sipAuthPassword = sipAuthPassword;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public void setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
    }

    public HttpMethod getFallbackMethod() {
        return fallbackMethod;
    }

    public void setFallbackMethod(HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
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

    public String getForwardedFrom() {
        return forwardedFrom;
    }

    public void setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
    }

    public String getPlayDtmf() {
        return playDtmf;
    }

    public void setPlayDtmf(String playDtmf) {
        this.playDtmf = playDtmf;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Boolean getHideCallerId() {
        return hideCallerId;
    }

    public void setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public String getRecordCallback() {
        return recordCallback;
    }

    public void setRecordCallback(String recordCallback) {
        this.recordCallback = recordCallback;
    }

    public HttpMethod getRecordCallbackMethod() {
        return recordCallbackMethod;
    }

    public void setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
    }

    public Boolean getTranscribe() {
        return transcribe;
    }

    public void setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
    }

    public String getTranscribeCallback() {
        return transcribeCallback;
    }

    public void setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
    }

    public Boolean getStraightToVoicemail() {
        return straightToVoicemail;
    }

    public void setStraightToVoicemail(Boolean straightToVoicemail) {
        this.straightToVoicemail = straightToVoicemail;
    }

    public IfMachine getIfMachine() {
        return ifMachine;
    }

    public void setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
    }

    public String getIfMachineUrl() {
        return ifMachineUrl;
    }

    public void setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
    }

    public HttpMethod getIfMachineMethod() {
        return ifMachineMethod;
    }

    public void setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
    }

    public String getSipAuthUsername() {
        return sipAuthUsername;
    }

    public void setSipAuthUsername(String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
    }

    public String getSipAuthPassword() {
        return sipAuthPassword;
    }

    public void setSipAuthPassword(String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
    }
}
