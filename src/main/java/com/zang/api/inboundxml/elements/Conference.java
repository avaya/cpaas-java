package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
@XmlRootElement(name = "Conference")
public class Conference implements DialElement {

    @XmlValue
    protected String name;
    @XmlAttribute(name = "muted")
    protected Boolean muted;
    @XmlAttribute(name = "beep")
    protected Boolean beep;
    @XmlAttribute(name = "startConferenceOnEnter")
    protected Boolean startConferenceOnEnter;
    @XmlAttribute(name = "endConferenceOnExit")
    protected Boolean endConferenceOnExit;
    @XmlAttribute(name = "maxParticipants")
    protected Integer maxParticipants;
    @XmlAttribute(name = "timeLimit")
    protected Integer timeLimit;
    @XmlAttribute(name = "waitUrl")
    @XmlSchemaType(name = "anyURI")
    protected String waitUrl;
    @XmlAttribute(name = "waitMethod")
    protected HttpMethod waitMethod;
    @XmlAttribute(name = "hangupOnStar")
    protected Boolean hangupOnStar;
    @XmlAttribute(name = "callbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String callbackUrl;
    @XmlAttribute(name = "callbackMethod")
    protected HttpMethod callbackMethod;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "waitSound")
    @XmlSchemaType(name = "anyURI")
    protected String waitSound;
    @XmlAttribute(name = "waitSoundMethod")
    protected HttpMethod waitSoundMethod;
    @XmlAttribute(name = "digitsMatch")
    protected String digitsMatch;
    @XmlAttribute(name = "stayAlone")
    protected Boolean stayAlone;
    @XmlAttribute(name = "record")
    protected Boolean record;
    @XmlAttribute(name = "recordFileFormat")
    protected RecordingFileFormat recordFileFormat;
    @XmlAttribute(name = "recordCallbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String recordCallbackUrl;
    @XmlAttribute(name = "recordCallbackMethod")
    protected HttpMethod recordCallbackMethod;

    public static ConferenceBuilder builder() {
        return new ConferenceBuilder();
    }

    public Conference() {
    }

    public Conference(String name, Boolean muted, Boolean beep, Boolean startConferenceOnEnter, Boolean endConferenceOnExit, Integer maxParticipants, Integer timeLimit, String waitUrl, HttpMethod waitMethod, Boolean hangupOnStar, String callbackUrl, HttpMethod callbackMethod, HttpMethod method, String waitSound, HttpMethod waitSoundMethod, String digitsMatch, Boolean stayAlone, Boolean record, RecordingFileFormat recordFileFormat, String recordCallbackUrl, HttpMethod recordCallbackMethod) {
        this.name = name;
        this.muted = muted;
        this.beep = beep;
        this.startConferenceOnEnter = startConferenceOnEnter;
        this.endConferenceOnExit = endConferenceOnExit;
        this.maxParticipants = maxParticipants;
        this.timeLimit = timeLimit;
        this.waitUrl = waitUrl;
        this.waitMethod = waitMethod;
        this.hangupOnStar = hangupOnStar;
        this.callbackUrl = callbackUrl;
        this.callbackMethod = callbackMethod;
        this.method = method;
        this.waitSound = waitSound;
        this.waitSoundMethod = waitSoundMethod;
        this.digitsMatch = digitsMatch;
        this.stayAlone = stayAlone;
        this.record = record;
        this.recordFileFormat = recordFileFormat;
        this.recordCallbackUrl = recordCallbackUrl;
        this.recordCallbackMethod = recordCallbackMethod;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

    public Boolean getMuted() {
        return muted;
    }


    public void setMuted(Boolean value) {
        this.muted = value;
    }


    public Boolean getBeep() {
        return beep;
    }


    public void setBeep(Boolean value) {
        this.beep = value;
    }


    public Boolean getStartConferenceOnEnter() {
        return startConferenceOnEnter;
    }


    public void setStartConferenceOnEnter(Boolean value) {
        this.startConferenceOnEnter = value;
    }


    public Boolean getEndConferenceOnExit() {
        return endConferenceOnExit;
    }


    public void setEndConferenceOnExit(Boolean value) {
        this.endConferenceOnExit = value;
    }


    public Integer getMaxParticipants() {
        return maxParticipants;
    }


    public void setMaxParticipants(Integer value) {
        this.maxParticipants = value;
    }


    public Integer getTimeLimit() {
        return timeLimit;
    }


    public void setTimeLimit(Integer value) {
        this.timeLimit = value;
    }


    public String getWaitUrl() {
        return waitUrl;
    }


    public void setWaitUrl(String value) {
        this.waitUrl = value;
    }


    public HttpMethod getWaitMethod() {
        return waitMethod;
    }


    public void setWaitMethod(HttpMethod value) {
        this.waitMethod = value;
    }


    public Boolean getHangupOnStar() {
        return hangupOnStar;
    }


    public void setHangupOnStar(Boolean value) {
        this.hangupOnStar = value;
    }


    public String getCallbackUrl() {
        return callbackUrl;
    }


    public void setCallbackUrl(String value) {
        this.callbackUrl = value;
    }


    public HttpMethod getCallbackMethod() {
        return callbackMethod;
    }


    public void setCallbackMethod(HttpMethod value) {
        this.callbackMethod = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }


    public String getWaitSound() {
        return waitSound;
    }


    public void setWaitSound(String value) {
        this.waitSound = value;
    }


    public HttpMethod getWaitSoundMethod() {
        return waitSoundMethod;
    }


    public void setWaitSoundMethod(HttpMethod value) {
        this.waitSoundMethod = value;
    }


    public String getDigitsMatch() {
        return digitsMatch;
    }


    public void setDigitsMatch(String value) {
        this.digitsMatch = value;
    }


    public Boolean getStayAlone() {
        return stayAlone;
    }


    public void setStayAlone(Boolean value) {
        this.stayAlone = value;
    }


    public Boolean getRecord() {
        return record;
    }


    public void setRecord(Boolean value) {
        this.record = value;
    }


    public RecordingFileFormat getRecordFileFormat() {
        return recordFileFormat;
    }


    public void setRecordFileFormat(RecordingFileFormat value) {
        this.recordFileFormat = value;
    }


    public String getRecordCallbackUrl() {
        return recordCallbackUrl;
    }


    public void setRecordCallbackUrl(String value) {
        this.recordCallbackUrl = value;
    }


    public HttpMethod getRecordCallbackMethod() {
        return recordCallbackMethod;
    }


    public void setRecordCallbackMethod(HttpMethod value) {
        this.recordCallbackMethod = value;
    }

}
