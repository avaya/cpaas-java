package com.zang.api.params;

import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

/**
 * Utility class for executing the Record Call request
 * @see com.zang.api.connectors.RecordingsConnector
 * @see RecordCallParamsBuilder
 */
public class RecordCallParams {
    private  String accountSid;
    private  String callSid;
    private  Boolean record;
    private  RecordingAudioDirection direction;
    private  Integer timeLimit;
    private  String callbackUrl;
    private  RecordingFileFormat fileFormat;
    private  Boolean trimSilence;
    private  Boolean transcribe;
    private TranscriptionQuality transcriptionQuality;
    private  String transcribeCallback;

    public static RecordCallParamsBuilder builder() {
        return new RecordCallParamsBuilder();
    }

    /**
     * @see RecordCallParamsBuilder
     */
    public RecordCallParams() {
    }

    /**
     * @see RecordCallParamsBuilder
     */
    public RecordCallParams(String accountSid, String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.record = record;
        this.direction = direction;
        this.timeLimit = timeLimit;
        this.callbackUrl = callbackUrl;
        this.fileFormat = fileFormat;
        this.trimSilence = trimSilence;
        this.transcribe = transcribe;
        this.transcriptionQuality = transcriptionQuality;
        this.transcribeCallback = transcribeCallback;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getCallSid() {
        return callSid;
    }

    public void setCallSid(String callSid) {
        this.callSid = callSid;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public RecordingAudioDirection getDirection() {
        return direction;
    }

    public void setDirection(RecordingAudioDirection direction) {
        this.direction = direction;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public RecordingFileFormat getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(RecordingFileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }

    public Boolean getTrimSilence() {
        return trimSilence;
    }

    public void setTrimSilence(Boolean trimSilence) {
        this.trimSilence = trimSilence;
    }

    public Boolean getTranscribe() {
        return transcribe;
    }

    public void setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
    }

    public TranscriptionQuality getTranscriptionQuality() {
        return transcriptionQuality;
    }

    public void setTranscriptionQuality(TranscriptionQuality transcriptionQuality) {
        this.transcriptionQuality = transcriptionQuality;
    }

    public String getTranscribeCallback() {
        return transcribeCallback;
    }

    public void setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
    }
}
