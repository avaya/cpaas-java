package com.zang.api.params;

import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

/**
 * Utility class for executing the Record Call request
 * @see com.zang.api.connectors.RecordingsConnector
 * @see RecordCallParams
 */
public class RecordCallParamsBuilder {
    private String accountSid;
    private String callSid;
    private Boolean record;
    private RecordingAudioDirection direction;
    private Integer timeLimit;
    private String callbackUrl;
    private RecordingFileFormat fileFormat;
    private Boolean trimSilence;
    private Boolean transcribe;
    private TranscriptionQuality transcriptionQuality;
    private String transcribeCallback;

    RecordCallParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public RecordCallParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Call SID
     * @param callSid
     * @return
     */
    public RecordCallParamsBuilder setCallSid(String callSid) {
        this.callSid = callSid;
        return this;
    }

    /**
     * Specifies if a call recording should start or end. Any number of simultaneous, separate recordings
     *               can be initiated.
     * @param record
     * @return
     */
    public RecordCallParamsBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    /**
     * Specifies which audio stream to record. Allowed values are "in" to record the incoming caller's
     *                  audio, "out" to record the outgoing caller's audio, and "both" to record both.
     * @param direction
     * @return
     */
    public RecordCallParamsBuilder setDirection(RecordingAudioDirection direction) {
        this.direction = direction;
        return this;
    }

    /**
     * The maximum duration of the recording. Allowed value is an integer greater than 0.
     * @param timeLimit
     * @return
     */
    public RecordCallParamsBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    /**
     * A URL that will be requested when the recording ends, sending information about the recording.
     *                    The longer the recording, the longer the delay in processing the recording and requesting
     *                    the CallbackUrl. Url length is limited to 200 characters.
     * @param callbackUrl
     * @return
     */
    public RecordCallParamsBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Specifies the file format of the recording.
     * @param fileFormat
     * @return
     */
    public RecordCallParamsBuilder setFileFormat(RecordingFileFormat fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    /**
     * Trims all silence from the beginning of the recording.
     * @param trimSilence
     * @return
     */
    public RecordCallParamsBuilder setTrimSilence(Boolean trimSilence) {
        this.trimSilence = trimSilence;
        return this;
    }

    /**
     * Specifies if the recording should be transcribed.
     * @param transcribe
     * @return
     */
    public RecordCallParamsBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    /**
     * Specifies the quality of the transcription. Allowed values are "auto" for automated
     *                             transcriptions and "hybrid" for human-reviewed transcriptions.
     * @param transcriptionQuality
     * @return
     */
    public RecordCallParamsBuilder setTranscriptionQuality(TranscriptionQuality transcriptionQuality) {
        this.transcriptionQuality = transcriptionQuality;
        return this;
    }

    /**
     * A URL that will be requested when the call ends, sending information about the
     *                           transcription. The longer the recording, the longer the delay in processing the
     *                           transcription and requesting the TranscribeCallback. Url length is limited to
     *                           200 characters.
     * @param transcribeCallback
     * @return
     */
    public RecordCallParamsBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public RecordCallParams build() {
        return new RecordCallParams(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback);
    }
}