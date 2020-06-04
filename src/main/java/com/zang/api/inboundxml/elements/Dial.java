package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Dial")
public class Dial implements ResponseElement {

    @XmlElementRefs({
            @XmlElementRef(name = "User", type = User.class, required = false),
            @XmlElementRef(name = "Sip", type = Sip.class, required = false),
            @XmlElementRef(name = "Conference", type = Conference.class, required = false),
            @XmlElementRef(name = "Number", type = Number.class, required = false)
    })
    @XmlMixed
    protected List<DialElement> content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "timeout")
    protected Integer timeout;
    @XmlAttribute(name = "hangupOnStar")
    protected Boolean hangupOnStar;
    @XmlAttribute(name = "timeLimit")
    protected Integer timeLimit;
    @XmlAttribute(name = "callerId")
    protected String callerId;
    @XmlAttribute(name = "hideCallerId")
    protected Boolean hideCallerId;
    @XmlAttribute(name = "callerName")
    protected String callerName;
    @XmlAttribute(name = "dialMusic")
    @XmlSchemaType(name = "anyURI")
    protected String dialMusic;
    @XmlAttribute(name = "callbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String callbackUrl;
    @XmlAttribute(name = "callbackMethod")
    protected HttpMethod callbackMethod;
    @XmlAttribute(name = "confirmSound")
    protected String confirmSound;
    @XmlAttribute(name = "digitsMatch")
    protected String digitsMatch;
    @XmlAttribute(name = "straightToVm")
    protected Boolean straightToVm;
    @XmlAttribute(name = "heartbeatUrl")
    @XmlSchemaType(name = "anyURI")
    protected String heartbeatUrl;
    @XmlAttribute(name = "heartbeatMethod")
    protected HttpMethod heartbeatMethod;
    @XmlAttribute(name = "forwardedFrom")
    protected String forwardedFrom;
    @XmlAttribute(name = "record")
    protected Boolean record;
    @XmlAttribute(name = "recordDirection")
    protected RecordingAudioDirection recordDirection;
    @XmlAttribute(name = "recordCallbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String recordCallbackUrl;
    @XmlAttribute(name = "recordLifetime")
    protected Integer recordLifetime;
    @XmlAttribute(name = "recordFormat")
    protected RecordingFileFormat recordFormat;
    @XmlAttribute(name = "ifMachine")
    protected IfMachine ifMachine;
    @XmlAttribute(name = "ifMachineUrl")
    @XmlSchemaType(name = "anyURI")
    protected String ifMachineUrl;
    @XmlAttribute(name = "ifMachineMethod")
    protected HttpMethod ifMachineMethod;
    @XmlAttribute(name = "outboundAction")
    protected Boolean outboundAction;

    public static DialBuilder builder() {
        return new DialBuilder();
    }

    public Dial() {
    }

    public Dial(List<DialElement> content, String action, HttpMethod method, Integer timeout, Boolean hangupOnStar, Integer timeLimit, String callerId, Boolean hideCallerId, String callerName, String dialMusic, String callbackUrl, HttpMethod callbackMethod, String confirmSound, String digitsMatch, Boolean straightToVm, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom, Boolean record, RecordingAudioDirection recordDirection, String recordCallbackUrl, Integer recordLifetime, RecordingFileFormat recordFormat, IfMachine ifMachine, String ifMachineUrl, HttpMethod ifMachineMethod, Boolean outboundAction) {
        this.content = content;
        this.action = action;
        this.method = method;
        this.timeout = timeout;
        this.hangupOnStar = hangupOnStar;
        this.timeLimit = timeLimit;
        this.callerId = callerId;
        this.hideCallerId = hideCallerId;
        this.callerName = callerName;
        this.dialMusic = dialMusic;
        this.callbackUrl = callbackUrl;
        this.callbackMethod = callbackMethod;
        this.confirmSound = confirmSound;
        this.digitsMatch = digitsMatch;
        this.straightToVm = straightToVm;
        this.heartbeatUrl = heartbeatUrl;
        this.heartbeatMethod = heartbeatMethod;
        this.forwardedFrom = forwardedFrom;
        this.record = record;
        this.recordDirection = recordDirection;
        this.recordCallbackUrl = recordCallbackUrl;
        this.recordLifetime = recordLifetime;
        this.recordFormat = recordFormat;
        this.ifMachine = ifMachine;
        this.ifMachineUrl = ifMachineUrl;
        this.ifMachineMethod = ifMachineMethod;
        this.outboundAction = outboundAction;
    }


    public List<DialElement> getContent() {
        if (content == null) {
            content = new ArrayList<DialElement>();
        }
        return this.content;
    }

    public void setContent(List<DialElement> content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }


    public void setAction(String value) {
        this.action = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }


    public Integer getTimeout() {
        return timeout;
    }


    public void setTimeout(Integer value) {
        this.timeout = value;
    }


    public Boolean getHangupOnStar() {
        return hangupOnStar;
    }


    public void setHangupOnStar(Boolean value) {
        this.hangupOnStar = value;
    }


    public Integer getTimeLimit() {
        return timeLimit;
    }


    public void setTimeLimit(Integer value) {
        this.timeLimit = value;
    }


    public String getCallerId() {
        return callerId;
    }


    public void setCallerId(String value) {
        this.callerId = value;
    }


    public Boolean getHideCallerId() {
        return hideCallerId;
    }


    public void setHideCallerId(Boolean value) {
        this.hideCallerId = value;
    }


    public String getCallerName() {
        return callerName;
    }


    public void setCallerName(String value) {
        this.callerName = value;
    }


    public String getDialMusic() {
        return dialMusic;
    }


    public void setDialMusic(String value) {
        this.dialMusic = value;
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


    public String getConfirmSound() {
        return confirmSound;
    }


    public void setConfirmSound(String value) {
        this.confirmSound = value;
    }


    public String getDigitsMatch() {
        return digitsMatch;
    }


    public void setDigitsMatch(String value) {
        this.digitsMatch = value;
    }


    public Boolean getStraightToVm() {
        return straightToVm;
    }


    public void setStraightToVm(Boolean value) {
        this.straightToVm = value;
    }


    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }


    public void setHeartbeatUrl(String value) {
        this.heartbeatUrl = value;
    }


    public HttpMethod getHeartbeatMethod() {
        return heartbeatMethod;
    }


    public void setHeartbeatMethod(HttpMethod value) {
        this.heartbeatMethod = value;
    }


    public String getForwardedFrom() {
        return forwardedFrom;
    }


    public void setForwardedFrom(String value) {
        this.forwardedFrom = value;
    }


    public Boolean getRecord() {
        return record;
    }


    public void setRecord(Boolean value) {
        this.record = value;
    }


    public RecordingAudioDirection getRecordDirection() {
        return recordDirection;
    }


    public void setRecordDirection(RecordingAudioDirection value) {
        this.recordDirection = value;
    }


    public String getRecordCallbackUrl() {
        return recordCallbackUrl;
    }


    public void setRecordCallbackUrl(String value) {
        this.recordCallbackUrl = value;
    }


    public Integer getRecordLifetime() {
        return recordLifetime;
    }


    public void setRecordLifetime(Integer value) {
        this.recordLifetime = value;
    }


    public RecordingFileFormat getRecordFormat() {
        return recordFormat;
    }


    public void setRecordFormat(RecordingFileFormat value) {
        this.recordFormat = value;
    }


    public IfMachine getIfMachine() {
        return ifMachine;
    }


    public void setIfMachine(IfMachine value) {
        this.ifMachine = value;
    }


    public String getIfMachineUrl() {
        return ifMachineUrl;
    }


    public void setIfMachineUrl(String value) {
        this.ifMachineUrl = value;
    }


    public HttpMethod getIfMachineMethod() {
        return ifMachineMethod;
    }


    public void setIfMachineMethod(HttpMethod value) {
        this.ifMachineMethod = value;
    }


    public Boolean getOutboundAction() {
        return outboundAction;
    }


    public void setOutboundAction(Boolean value) {
        this.outboundAction = value;
    }

}
