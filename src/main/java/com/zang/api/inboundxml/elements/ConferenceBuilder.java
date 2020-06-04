package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

public class ConferenceBuilder {
    private String name;
    private Boolean muted;
    private Boolean beep;
    private Boolean startConferenceOnEnter;
    private Boolean endConferenceOnExit;
    private Integer maxParticipants;
    private Integer timeLimit;
    private String waitUrl;
    private HttpMethod waitMethod;
    private Boolean hangupOnStar;
    private String callbackUrl;
    private HttpMethod callbackMethod;
    private HttpMethod method;
    private String waitSound;
    private HttpMethod waitSoundMethod;
    private String digitsMatch;
    private Boolean stayAlone;
    private Boolean record;
    private RecordingFileFormat recordFileFormat;
    private String recordCallbackUrl;
    private HttpMethod recordCallbackMethod;

    ConferenceBuilder() {
    }

    /**
     * The conference room name.
     * @param name
     * @return
     */
    public ConferenceBuilder setName(String name) {
        this.name = name;
        return this;
    }




    /**
     * Boolean value specifying if the conference should be muted. Default Value: false.
     * @param muted
     * @return
     */
    public ConferenceBuilder setMuted(Boolean muted) {
        this.muted = muted;
        return this;
    }

    /**
     * Boolean value specifying if a beep should play upon entrance to conference. Default Value: false.
     * @param beep
     * @return
     */

    public ConferenceBuilder setBeep(Boolean beep) {
        this.beep = beep;
        return this;
    }

    /**
     * Boolean value specifying if conference should begin upon entrance. Default Value: false.
     * @param startConferenceOnEnter
     * @return
     */
    public ConferenceBuilder setStartConferenceOnEnter(Boolean startConferenceOnEnter) {
        this.startConferenceOnEnter = startConferenceOnEnter;
        return this;
    }

    /**
     * Boolean value specifying if conference should end upon a specific users exit. Default Value: false.
     * @param endConferenceOnExit
     * @return
     */
    public ConferenceBuilder setEndConferenceOnExit(Boolean endConferenceOnExit) {
        this.endConferenceOnExit = endConferenceOnExit;
        return this;
    }

    /**
     * The maximum number of participants allowed in the conference call. Default Value: 40. Allowed Value: integer from 1 to 40.
     * @param maxParticipants
     * @return
     */
    public ConferenceBuilder setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
        return this;
    }

    public ConferenceBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    public ConferenceBuilder setWaitUrl(String waitUrl) {
        this.waitUrl = waitUrl;
        return this;
    }

    public ConferenceBuilder setWaitMethod(HttpMethod waitMethod) {
        this.waitMethod = waitMethod;
        return this;
    }

    /**
     * Boolean value specifying if pressing * should end the conference. Default Value: false.
     * @param hangupOnStar
     * @return
     */
    public ConferenceBuilder setHangupOnStar(Boolean hangupOnStar) {
        this.hangupOnStar = hangupOnStar;
        return this;
    }

    /**
     * URL where some parameters specific to <Conference> will be sent when participants enter and exit the conference and once it is completed. There is only one callbackUrl allowed per conference. The first callbackUrl will be the only one used.
     * @param callbackUrl
     * @return
     */
    public ConferenceBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Method used to request the callback URL. Default Value: POST.
     * @param callbackMethod
     * @return
     */
    public ConferenceBuilder setCallbackMethod(HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * Method used to request the action URL. Default Value: POST.
     * @param method
     * @return
     */
    public ConferenceBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * URL to inboundXML where conference participants can be sent to while they wait for entrance into the conference. Only <Play> method supported at this time.
     * @param waitSound
     * @return
     */
    public ConferenceBuilder setWaitSound(String waitSound) {
        this.waitSound = waitSound;
        return this;
    }

    public ConferenceBuilder setWaitSoundMethod(HttpMethod waitSoundMethod) {
        this.waitSoundMethod = waitSoundMethod;
        return this;
    }

    /**
     * Specifies digits that Zang should listen for and send to the callbackUrl if a caller inputs them. Separate additional digits or digit patterns with a comma. Allowed Value: Pattern made up of the digits 0-9, #, or *.
     * @param digitsMatch
     * @return
     */
    public ConferenceBuilder setDigitsMatch(String digitsMatch) {
        this.digitsMatch = digitsMatch;
        return this;
    }

    /**
     * Boolean value specifying if the caller should stay alone in the conference call. Default Value: false.
     * @param stayAlone
     * @return
     */
    public ConferenceBuilder setStayAlone(Boolean stayAlone) {
        this.stayAlone = stayAlone;
        return this;
    }

    /**
     * Boolean value specifying if the conference should be recorded. Default Value: false.
     * @param record
     * @return
     */
    public ConferenceBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    /**
     * File format in which the recording will be saved in. Default Value: mp3. Allowed Value: mp3 or wav.
     * @param recordFileFormat
     * @return
     */
    public ConferenceBuilder setRecordFileFormat(RecordingFileFormat recordFileFormat) {
        this.recordFileFormat = recordFileFormat;
        return this;
    }

    /**
     * URL to sound that the recording will be sent to from the conference.
     * @param recordCallbackUrl
     * @return
     */
    public ConferenceBuilder setRecordCallbackUrl(String recordCallbackUrl) {
        this.recordCallbackUrl = recordCallbackUrl;
        return this;
    }

    public ConferenceBuilder setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
        return this;
    }

    public Conference build() {
        return new Conference(name, muted, beep, startConferenceOnEnter, endConferenceOnExit, maxParticipants, timeLimit, waitUrl, waitMethod, hangupOnStar, callbackUrl, callbackMethod, method, waitSound, waitSoundMethod, digitsMatch, stayAlone, record, recordFileFormat, recordCallbackUrl, recordCallbackMethod);
    }
}