package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import java.util.ArrayList;
import java.util.List;

public class DialBuilder {
    private List<DialElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private Boolean hangupOnStar;
    private Integer timeLimit;
    private String callerId;
    private Boolean hideCallerId;
    private String callerName;
    private String dialMusic;
    private String callbackUrl;
    private HttpMethod callbackMethod;
    private String confirmSound;
    private String digitsMatch;
    private Boolean straightToVm;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String forwardedFrom;
    private Boolean record;
    private RecordingAudioDirection recordDirection;
    private String recordCallbackUrl;
    private Integer recordLifetime;
    private RecordingFileFormat recordFormat;
    private IfMachine ifMachine;
    private String ifMachineUrl;
    private HttpMethod ifMachineMethod;
    private Boolean outboundAction;

    DialBuilder() {
        this.content = new ArrayList<DialElement>();
    }

    /**
     * Adds an element to the Dial element.
     * @param element
     * @return
     */
    public DialBuilder addElement(DialElement element) {
        this.content.add(element);
        return this;
    }

    /**
     * Adds a Conference element to the Dial element.
     * @param conference
     * @return
     */
    public DialBuilder conference(Conference conference) {
        this.content.add(conference);
        return this;
    }

    /**
     * Adds a Number element to the Dial element.
     * @param number
     * @return
     */
    public DialBuilder number(Number number) {
        this.content.add(number);
        return this;
    }

    /**
     * Adds a Sip element to the Dial element.
     * @param sip
     * @return
     */
    public DialBuilder sip(Sip sip) {
        this.content.add(sip);
        return this;
    }

    /**
     * Replaces the whole content of the Dial element.
     * @param content
     * @return
     */
    public DialBuilder setContent(List<DialElement> content) {
        this.content = content;
        return this;
    }

    /**
     * URL where some parameters specific to <Dial> will be sent for further processing. The calling party can be redirected here upon the hangup of the B leg caller.
     * @param action
     * @return
     */
    public DialBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Method used to request the action URL. Default Value: POST.
     * @param method
     * @return
     */
    public DialBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public DialBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public DialBuilder setHangupOnStar(Boolean hangupOnStar) {
        this.hangupOnStar = hangupOnStar;
        return this;
    }

    /**
     * The duration in seconds a call made through <Dial> should occur for before ending. Default Value: 14400. Allowed Value: integer greater than or equal to 1.
     * @param timeLimit
     * @return
     */
    public DialBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    /**
     * Number to display as calling. Defaults to the ID of phone being used.
     * @param callerId
     * @return
     */
    public DialBuilder setCallerId(String callerId) {
        this.callerId = callerId;
        return this;
    }

    /**
     * Boolean value specifying if the caller ID should be hidden or not. Default Value: false.
     * @param hideCallerId
     * @return
     */
    public DialBuilder setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
        return this;
    }

    public DialBuilder setCallerName(String callerName) {
        this.callerName = callerName;
        return this;
    }

    /**
     * URL to an InboundXML document to be executed in place of the call ringtone (a <Say> or <Play> would be appropriate in this document).
     * @param dialMusic
     * @return
     */
    public DialBuilder setDialMusic(String dialMusic) {
        this.dialMusic = dialMusic;
        return this;
    }

    /**
     * URL requested when the dialed call connects and ends. Note that this URL only receives parameters containing information about the call, the call does not execute XML given as a callbackUrl.
     * @param callbackUrl
     * @return
     */
    public DialBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Method used to request the callback URL. Default Value: POST.
     * @param callbackMethod
     * @return
     */
    public DialBuilder setCallbackMethod(HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * The URL that Zang should reach out to when the called party answers. The URL should return InboundXML containing <Play>, <Pause>, and/or <Say> elements only. Any other elements will be ignored.
     * @param confirmSound
     * @return
     */
    public DialBuilder setConfirmSound(String confirmSound) {
        this.confirmSound = confirmSound;
        return this;
    }

    /**
     * Specifies digits that Zang should listen for and send to the callbackUrl if a caller inputs them. Separate additional digits or digit patterns with a comma. Allowed Value: Pattern made up of the digits 0-9, #, or *.
     * @param digitsMatch
     * @return
     */
    public DialBuilder setDigitsMatch(String digitsMatch) {
        this.digitsMatch = digitsMatch;
        return this;
    }

    /**
     * Boolean value specifying if call should be redirected to voicemail immediately. Note: only works if dialing TO a mobile number. Default Value: false.
     * @param straightToVm
     * @return
     */
    public DialBuilder setStraightToVm(Boolean straightToVm) {
        this.straightToVm = straightToVm;
        return this;
    }

    /**
     * A URL Zang can request every 60 seconds during the call to notify of elapsed time and pass other general information.
     * @param heartbeatUrl
     * @return
     */
    public DialBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    /**
     * Method used to request the heartbeatUrl. Default Value: POST.
     * @param heartbeatMethod
     * @return
     */
    public DialBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    /**
     * Specifies the number to list the call as forwarded from.
     * @param forwardedFrom
     * @return
     */
    public DialBuilder setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
        return this;
    }

    /**
     * Specifies if this call should be recorded.
     * @param record
     * @return
     */
    public DialBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    /**
     * Specifies which stream of call audio to record. “in” to record the incoming caller audio, “out” to record the outgoing caller audio, or “both” to record all audio on the call. “out” audio can only be captured if an outbound <Dial> is performed during the call. “in” blocks any subsequent InboundXML elements until the inbound audio recording is finished (via finishOnKey or timeout). Default Value: both.
     * @param recordDirection
     * @return
     */
    public DialBuilder setRecordDirection(RecordingAudioDirection recordDirection) {
        this.recordDirection = recordDirection;
        return this;
    }

    /**
     * URL where some parameters specific to the recording will be sent for further processing.
     * @param recordCallbackUrl
     * @return
     */
    public DialBuilder setRecordCallbackUrl(String recordCallbackUrl) {
        this.recordCallbackUrl = recordCallbackUrl;
        return this;
    }

    public DialBuilder setRecordLifetime(Integer recordLifetime) {
        this.recordLifetime = recordLifetime;
        return this;
    }

    public DialBuilder setRecordFormat(RecordingFileFormat recordFormat) {
        this.recordFormat = recordFormat;
        return this;
    }

    /**
     * Specifies how Zang should handle this dial if the receiving phone number is unanswered and goes to voicemail. “continue” to proceed as normal, “redirect” to redirect the call to the ifMachineUrl, or “hangup” to hangup the call. Please note: ifMachine could detect an answering machine via the tone stream. Therefore, the accuracy is around 90% and may not work in all countries. Default Value: continue. Allowed Value: continue, redirect, hangup.
     * @param ifMachine
     * @return
     */
    public DialBuilder setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    /**
     * The URL Zang will redirect to if a voicemail machine is detected while the ifMachine=“redirect” attribute is set.
     * @param ifMachineUrl
     * @return
     */
    public DialBuilder setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
        return this;
    }

    /**
     * The method used to request the ifMachineUrl. Default Value: POST.
     * @param ifMachineMethod
     * @return
     */
    public DialBuilder setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
        return this;
    }

    public DialBuilder setOutboundAction(Boolean outboundAction) {
        this.outboundAction = outboundAction;
        return this;
    }

    public Dial build() {
        return new Dial(content, action, method, timeout, hangupOnStar, timeLimit, callerId, hideCallerId, callerName, dialMusic, callbackUrl, callbackMethod, confirmSound, digitsMatch, straightToVm, heartbeatUrl, heartbeatMethod, forwardedFrom, record, recordDirection, recordCallbackUrl, recordLifetime, recordFormat, ifMachine, ifMachineUrl, ifMachineMethod, outboundAction);
    }
}