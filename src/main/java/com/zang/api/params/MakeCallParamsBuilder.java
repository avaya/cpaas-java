package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;

/**
 * Utility class for executing the Make Call request.
 * @see com.zang.api.connectors.CallsConnector
 * @see MakeCallParams
 */
public class MakeCallParamsBuilder {
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

    MakeCallParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public MakeCallParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * The phone number or SIP endpoint to call. Phone number should be in international format and one
     *           recipient per request. For e.g, to dial a number in the US, the To should be, +17325551212.
     *           SIP endpoints must be prefixed with sip: e.g sip:12345@sip.zang.io.
     * @param to
     * @return
     */
    public MakeCallParamsBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    /**
     * The number to display as calling (i.e. Caller ID). The value does not have to be a real phone number
     *             or even in a valid format. For example, 8143 could be passed to the From parameter and would be
     *             displayed as the caller ID. Spoofed calls carry an additional charge.
     * @param from
     * @return
     */
    public MakeCallParamsBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    /**
     * The URL requested once the call connects. This URL must be valid and should return InboundXML
     *            containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *            the FallbackUrl but return an error without placing the call. Url length is limited
     *            to 200 characters.
     * @param url
     * @return
     */
    public MakeCallParamsBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * The HTTP method used to request the URL once the call connects.
     * @param method
     * @return
     */
    public MakeCallParamsBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * URL used if the required URL is unavailable or if any errors occur during execution of
     *                    the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param fallbackUrl
     * @return
     */
    public MakeCallParamsBuilder setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    /**
     * The HTTP method used to request the FallbackUrl once the call connects.
     * @param fallbackMethod
     * @return
     */
    public MakeCallParamsBuilder setFallbackMethod(HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    /**
     * The HTTP method used to request the HeartbeatUrl.
     * @param statusCallback
     * @return
     */
    public MakeCallParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A URL that will be requested when the call connects and ends, sending information about
     *                       the call. URL length is limited to 200 characters.
     * @param statusCallbackMethod
     * @return
     */
    public MakeCallParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * A URL that will be requested every 60 seconds during the call, sending information about
     *                     the call. The HeartbeatUrl will NOT be requested unless at least 60 seconds of call time
     *                     have elapsed. URL length is limited to 200 characters.
     * @param heartbeatUrl
     * @return
     */
    public MakeCallParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    /**
     * The HTTP method used to request the HeartbeatUrl.
     * @param heartbeatMethod
     * @return
     */
    public MakeCallParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    /**
     * Specifies the Forwarding From number to pass to the carrier.
     * @param forwardedFrom
     * @return
     */
    public MakeCallParamsBuilder setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
        return this;
    }

    /**
     * Dial digits or play tones using DTMF as soon as the call connects. Useful for navigating IVRs.
     *                 Allowed values for digits are 0-9, #, *, W, or w (W and w are for .5 second pauses), for example
     *                 142##* (spaces are valid). Tones follow the @1000 syntax, for example to play the tone 4 for two
     *                 seconds, 4@2000 (milliseconds) would be used.
     * @param playDtmf
     * @return
     */
    public MakeCallParamsBuilder setPlayDtmf(String playDtmf) {
        this.playDtmf = playDtmf;
        return this;
    }

    /**
     * Number of seconds call stays on line while waiting for an answer. The max time limit is 999.
     * @param timeout
     * @return
     */
    public MakeCallParamsBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     *
     * @param hideCallerId
     * @return
     */
    public MakeCallParamsBuilder setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
        return this;
    }

    /**
     * Specifies if the Caller ID will be blocked.
     * @param record
     * @return
     */
    public MakeCallParamsBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    /**
     * The URL some parameters regarding the recording will be passed to once it is completed.
     *                       The longer the recording time, the longer the process delay in returning the recording
     *                       information. If no RecordCallback is given, the recording will still be saved to the
     *                       system and available either in your Recording Logs or via a REST List Recordings request.
     *                       Url length is limited to 200 characters.
     * @param recordCallback
     * @return
     */
    public MakeCallParamsBuilder setRecordCallback(String recordCallback) {
        this.recordCallback = recordCallback;
        return this;
    }

    /**
     * The HTTP method used to request the RecordCallback.
     * @param recordCallbackMethod
     * @return
     */
    public MakeCallParamsBuilder setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
        return this;
    }

    /**
     * Specifies whether this call should be transcribed.
     * @param transcribe
     * @return
     */
    public MakeCallParamsBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    /**
     * The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. Url length is limited to 200 characters.
     * @param transcribeCallback
     * @return
     */
    public MakeCallParamsBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    /**
     * Specifies whether this call should be sent straight to the user's voicemail.
     * @param straightToVoicemail
     * @return
     */
    public MakeCallParamsBuilder setStraightToVoicemail(Boolean straightToVoicemail) {
        this.straightToVoicemail = straightToVoicemail;
        return this;
    }

    /**
     * Specifies how Zang should handle this call if it goes to voicemail. Allowed values are
     *                  "continue" to proceed as normal, "redirect" to redirect the call to the ifMachineUrl, or
     *                  "hangup" to hang up the call. Hangup occurs when the tone is played. IfMachine accuracy is
     *                  around 90% and may not work in all countries.
     * @param ifMachine
     * @return
     */
    public MakeCallParamsBuilder setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    /**
     * The URL Zang will redirect to for instructions if a voicemail machine is detected while the
     *                     IfMachine parameter is set to "redirect". Url length is limited to 200 characters.
     * @param ifMachineUrl
     * @return
     */
    public MakeCallParamsBuilder setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
        return this;
    }

    /**
     * The HTTP method used to request the IfMachineUrl.
     * @param ifMachineMethod
     * @return
     */
    public MakeCallParamsBuilder setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
        return this;
    }

    /**
     * Your authenticated SIP username, used only for SIP calls.
     * @param sipAuthUsername
     * @return
     */
    public MakeCallParamsBuilder setSipAuthUsername(String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
        return this;
    }

    /**
     * Your authenticated SIP password, used only for SIP calls.
     * @param sipAuthPassword
     * @return
     */
    public MakeCallParamsBuilder setSipAuthPassword(String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
        return this;
    }

    public MakeCallParams build() {
        return new MakeCallParams(accountSid, to, from, url, method, fallbackUrl, fallbackMethod, statusCallback, statusCallbackMethod, heartbeatUrl, heartbeatMethod, forwardedFrom, playDtmf, timeout, hideCallerId, record, recordCallback, recordCallbackMethod, transcribe, transcribeCallback, straightToVoicemail, ifMachine, ifMachineUrl, ifMachineMethod, sipAuthUsername, sipAuthPassword);
    }
}