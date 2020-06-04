package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.inboundxml.elements.enums.SamplingRate;

public class RecordBuilder {
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private String finishOnKey;
    private Integer maxLength;
    private Boolean transcribe;
    private String transcribeCallback;
    private TranscriptionQuality transcriptionQuality;
    private Integer sliceStart;
    private Integer sliceDuration;
    private Boolean playBeep;
    private Boolean bothLegs;
    private RecordingFileFormat fileFormat;
    private RecordingAudioDirection direction;
    private Boolean background;
    private SamplingRate sampleRate;
    private Boolean trimSilence;
    private Integer lifetime;

    RecordBuilder() {
    }

    /**
     * URL where some parameters specific to <Record> will be sent for further processing.
     * @param action
     * @return
     */
    public RecordBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Method used to request the action URL. Default value is POST.
     * @param method
     * @return
     */
    public RecordBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * The number of seconds <Record> should wait during silence before ending. Default timeout value is 5 seconds. Valid value is integer greater than or equal to 0.
     * @param timeout
     * @return
     */
    public RecordBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * The key a caller can press to end the <Record>. Default value is #. Allowed values are digits from 0 to 9, # or *.
     * @param finishOnKey
     * @return
     */
    public RecordBuilder setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
        return this;
    }

    /**
     * The maximum length in seconds a recording should be. Default Value: 3600. Allowed Value: integer greater than or equal to 0
     * @param maxLength
     * @return
     */
    public RecordBuilder setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Boolean value specifying if the recording should be transcribed. Default Value: false.
     * @param transcribe
     * @return
     */
    public RecordBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    /**
     * Specifies the quality used to process the transcription. Default Value: auto
     * @param transcriptionQuality
     * @return
     */
    public RecordBuilder setTranscriptionQuality(TranscriptionQuality transcriptionQuality) {
        this.transcriptionQuality = transcriptionQuality;
        return this;
    }

    /**
     * A URL some parameters regarding the transcription will be passed to once it is completed. Allowed Value: Valid URL.
     * @param transcribeCallback
     * @return
     */
    public RecordBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public RecordBuilder setSliceStart(Integer sliceStart) {
        this.sliceStart = sliceStart;
        return this;
    }

    public RecordBuilder setSliceDuration(Integer sliceDuration) {
        this.sliceDuration = sliceDuration;
        return this;
    }

    /**
     * Boolean value specifying if a beep should be played when the recording begins. Default Value: false.
     * @param playBeep
     * @return
     */
    public RecordBuilder setPlayBeep(Boolean playBeep) {
        this.playBeep = playBeep;
        return this;
    }

    public RecordBuilder setBothLegs(Boolean bothLegs) {
        this.bothLegs = bothLegs;
        return this;
    }

    /**
     * The recording file format. Can be mp3 or wav. Default is mp3. Default Value: mp3.
     * @param fileFormat
     * @return
     */
    public RecordBuilder setFileFormat(RecordingFileFormat fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    /**
     * Specifies which stream of call audio to record. “in” to record the incoming caller audio, “out” to record the out going caller audio, or “both” to record all audio on the call. “out” audio can only be captured if an outbound Dial is performed during the call. “in” blocks any subsequent XML elements until the inbound audio recording is finished (via finishOnKey or timeout). Default Value: both.
     * @param direction
     * @return
     */
    public RecordBuilder setDirection(RecordingAudioDirection direction) {
        this.direction = direction;
        return this;
    }

    /**
     * Begin recording the call while continuing the execution of any other present InboundXML in the background (true) or block the execution of subsequent InboundXML until the record element finishes (via finishOnKey or timeout). Note that the timeout, finishOnKey, and playBeep attributes have no effect when the background is set to true. Default Value: true.
     * @param background
     * @return
     */
    public RecordBuilder setBackground(Boolean background) {
        this.background = background;
        return this;
    }

    public RecordBuilder setSampleRate(SamplingRate sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }

    /**
     * Trims all silence from the beginning of the recording. Allowed values are "true" or "false" - any other value will default to "false".
     * @param trimSilence
     * @return
     */
    public RecordBuilder setTrimSilence(Boolean trimSilence) {
        this.trimSilence = trimSilence;
        return this;
    }

    public RecordBuilder setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public Record build() {
        return new Record(action, method, timeout, finishOnKey, maxLength, transcribe, transcribeCallback, transcriptionQuality, sliceStart, sliceDuration, playBeep, bothLegs, fileFormat, direction, background, sampleRate, trimSilence, lifetime);
    }
}