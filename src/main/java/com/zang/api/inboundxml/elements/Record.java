package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.inboundxml.elements.enums.SamplingRate;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "Record")
public class Record implements ResponseElement {

    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "timeout")
    protected Integer timeout;
    @XmlAttribute(name = "finishOnKey")
    protected String finishOnKey;
    @XmlAttribute(name = "maxLength")
    protected Integer maxLength;
    @XmlAttribute(name = "transcribe")
    protected Boolean transcribe;
    @XmlAttribute(name = "transcribeCallback")
    @XmlSchemaType(name = "anyURI")
    protected String transcribeCallback;
    @XmlAttribute(name = "transcribeQuality")
    protected TranscriptionQuality transcriptionQuality;
    @XmlAttribute(name = "sliceStart")
    protected Integer sliceStart;
    @XmlAttribute(name = "sliceDuration")
    protected Integer sliceDuration;
    @XmlAttribute(name = "playBeep")
    protected Boolean playBeep;
    @XmlAttribute(name = "bothLegs")
    protected Boolean bothLegs;
    @XmlAttribute(name = "fileFormat")
    protected RecordingFileFormat fileFormat;
    @XmlAttribute(name = "direction")
    protected RecordingAudioDirection direction;
    @XmlAttribute(name = "background")
    protected Boolean background;
    @XmlAttribute(name = "sampleRate")
    protected SamplingRate sampleRate;
    @XmlAttribute(name = "trimSilence")
    protected Boolean trimSilence;
    @XmlAttribute(name = "lifetime")
    protected Integer lifetime;

    public static RecordBuilder builder() {
        return new RecordBuilder();
    }

    public Record() {
    }

    public Record(String action, HttpMethod method, Integer timeout, String finishOnKey, Integer maxLength, Boolean transcribe, String transcribeCallback, TranscriptionQuality transcriptionQuality, Integer sliceStart, Integer sliceDuration, Boolean playBeep, Boolean bothLegs, RecordingFileFormat fileFormat, RecordingAudioDirection direction, Boolean background, SamplingRate sampleRate, Boolean trimSilence, Integer lifetime) {
        this.action = action;
        this.method = method;
        this.timeout = timeout;
        this.finishOnKey = finishOnKey;
        this.maxLength = maxLength;
        this.transcribe = transcribe;
        this.transcribeCallback = transcribeCallback;
        this.transcriptionQuality = transcriptionQuality;
        this.sliceStart = sliceStart;
        this.sliceDuration = sliceDuration;
        this.playBeep = playBeep;
        this.bothLegs = bothLegs;
        this.fileFormat = fileFormat;
        this.direction = direction;
        this.background = background;
        this.sampleRate = sampleRate;
        this.trimSilence = trimSilence;
        this.lifetime = lifetime;
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


    public String getFinishOnKey() {
        return finishOnKey;
    }


    public void setFinishOnKey(String value) {
        this.finishOnKey = value;
    }


    public Integer getMaxLength() {
        return maxLength;
    }


    public void setMaxLength(Integer value) {
        this.maxLength = value;
    }


    public Boolean getTranscribe() {
        return transcribe;
    }


    public void setTranscribe(Boolean value) {
        this.transcribe = value;
    }


    public String getTranscribeCallback() {
        return transcribeCallback;
    }


    public void setTranscribeCallback(String value) {
        this.transcribeCallback = value;
    }


    public TranscriptionQuality getTranscriptionQuality() {
        return transcriptionQuality;
    }


    public void setTranscriptionQuality(TranscriptionQuality value) {
        this.transcriptionQuality = value;
    }


    public Integer getSliceStart() {
        return sliceStart;
    }


    public void setSliceStart(Integer value) {
        this.sliceStart = value;
    }


    public Integer getSliceDuration() {
        return sliceDuration;
    }


    public void setSliceDuration(Integer value) {
        this.sliceDuration = value;
    }


    public Boolean getPlayBeep() {
        return playBeep;
    }


    public void setPlayBeep(Boolean value) {
        this.playBeep = value;
    }


    public Boolean getBothLegs() {
        return bothLegs;
    }


    public void setBothLegs(Boolean value) {
        this.bothLegs = value;
    }


    public RecordingFileFormat getFileFormat() {
        return fileFormat;
    }


    public void setFileFormat(RecordingFileFormat value) {
        this.fileFormat = value;
    }


    public RecordingAudioDirection getDirection() {
        return direction;
    }


    public void setDirection(RecordingAudioDirection value) {
        this.direction = value;
    }


    public Boolean getBackground() {
        return background;
    }


    public void setBackground(Boolean value) {
        this.background = value;
    }


    public SamplingRate getSampleRate() {
        return sampleRate;
    }


    public void setSampleRate(SamplingRate value) {
        this.sampleRate = value;
    }


    public Boolean getTrimSilence() {
        return trimSilence;
    }


    public void setTrimSilence(Boolean value) {
        this.trimSilence = value;
    }


    public Integer getLifetime() {
        return lifetime;
    }


    public void setLifetime(Integer value) {
        this.lifetime = value;
    }

}
