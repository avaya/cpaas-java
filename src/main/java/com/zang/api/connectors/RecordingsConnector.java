package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Recording;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.list.RecordingsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.RecordCallParams;
import com.zang.api.restproxies.RecordingsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


/**
 * Used for all forms of communication with the Recordings endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class RecordingsConnector extends BaseConnector {

    private RecordingsProxy proxy;

    RecordingsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(RecordingsProxy.class);
    }


    /**
     * Shows information about a Recording.
     * @param accountSid Account SID
     * @param recordingSid Recording SID
     * @return Information about Recording
     * @throws ZangException
     */
    public Recording viewRecording(String accountSid, String recordingSid) throws ZangException {
        return returnThrows(proxy.viewRecording(accountSid, recordingSid), Recording.class);
    }

    /**
     * Shows information about a Recording.
     * @param recordingSid Recording SID
     * @return Information about Recording
     * @throws ZangException
     */
    public Recording viewRecording(String recordingSid) throws ZangException {
        return viewRecording(conf.getSid(), recordingSid);
    }

    /**
     * Shows info on all recordings associated with an account.
     * @param accountSid Account SID
     * @param callSid Call SID
     * @param dateCreatedGte Filter by date created greater than or equal.
     * @param dateCreatedLt Filter by date created less then.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Recordings.
     * @throws ZangException
     */
    public RecordingsList listRecordings(String accountSid, String callSid, Date dateCreatedGte, Date dateCreatedLt, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listRecordings(accountSid, callSid, getDateString(dateCreatedGte), getDateString(dateCreatedLt), page, pageSize), RecordingsList.class);
    }

    /**
     * Shows info on all recordings associated with an account.
     * @param callSid Call SID
     * @param dateCreatedGte Filter by date created greater than or equal.
     * @param dateCreatedLt Filter by date created less then.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Recordings.
     * @throws ZangException
     */
    public RecordingsList listRecordings(String callSid, Date dateCreatedGte, Date dateCreatedLt, Integer page, Integer pageSize) throws ZangException {
        return listRecordings(conf.getSid(), callSid, dateCreatedGte, dateCreatedLt, page, pageSize);
    }

    /**
     * Records a call
     * @param accountSid Account SID
     * @param callSid Call SID
     * @param record Specifies if a call recording should start or end. Any number of simultaneous, separate recordings
     *               can be initiated.
     * @param direction Specifies which audio stream to record. Allowed values are "in" to record the incoming caller's
     *                  audio, "out" to record the outgoing caller's audio, and "both" to record both.
     * @param timeLimit The maximum duration of the recording. Allowed value is an integer greater than 0.
     * @param callbackUrl A URL that will be requested when the recording ends, sending information about the recording.
     *                    The longer the recording, the longer the delay in processing the recording and requesting
     *                    the CallbackUrl. Url length is limited to 200 characters.
     * @param fileFormat Specifies the file format of the recording.
     * @param trimSilence Trims all silence from the beginning of the recording.
     * @param transcribe Specifies if the recording should be transcribed.
     * @param transcriptionQuality Specifies the quality of the transcription. Allowed values are "auto" for automated
     *                             transcriptions and "hybrid" for human-reviewed transcriptions.
     * @param transcribeCallback A URL that will be requested when the call ends, sending information about the
     *                           transcription. The longer the recording, the longer the delay in processing the
     *                           transcription and requesting the TranscribeCallback. Url length is limited to
     *                           200 characters.
     * @return Information about the Recording
     * @throws ZangException
     */
    public Recording recordCall(String accountSid, String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        return returnThrows(proxy.recordCall(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback), Recording.class);
    }

    /**
     * Records a call
     * @param callSid Call SID
     * @param record Specifies if a call recording should start or end. Any number of simultaneous, separate recordings
     *               can be initiated.
     * @param direction Specifies which audio stream to record. Allowed values are "in" to record the incoming caller's
     *                  audio, "out" to record the outgoing caller's audio, and "both" to record both.
     * @param timeLimit The maximum duration of the recording. Allowed value is an integer greater than 0.
     * @param callbackUrl A URL that will be requested when the recording ends, sending information about the recording.
     *                    The longer the recording, the longer the delay in processing the recording and requesting
     *                    the CallbackUrl. Url length is limited to 200 characters.
     * @param fileFormat Specifies the file format of the recording.
     * @param trimSilence Trims all silence from the beginning of the recording.
     * @param transcribe Specifies if the recording should be transcribed.
     * @param transcriptionQuality Specifies the quality of the transcription. Allowed values are "auto" for automated
     *                             transcriptions and "hybrid" for human-reviewed transcriptions.
     * @param transcribeCallback A URL that will be requested when the call ends, sending information about the
     *                           transcription. The longer the recording, the longer the delay in processing the
     *                           transcription and requesting the TranscribeCallback. Url length is limited to
     *                           200 characters.
     * @return Information about the Recording
     * @throws ZangException
     */
    public Recording recordCall(String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        return recordCall(conf.getSid(), callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback);
    }

    /**
     * Records a call.
     * @param params Parameters with which to record the call.
     * @return Information about the created Recording.
     * @throws ZangException
     * @see RecordCallParams
     * @see com.zang.api.params.RecordCallParamsBuilder
     */
    public Recording recordCall(RecordCallParams params) throws ZangException {
        return recordCall(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getCallSid(), params.getRecord(), params.getDirection(), params.getTimeLimit(), params.getCallbackUrl(), params.getFileFormat(), params.getTrimSilence(), params.getTranscribe(), params.getTranscriptionQuality(), params.getTranscribeCallback());
    }

    /**
     * Deletes a recording.
     * @param accountSid Account SID
     * @param recordingSid Recording SID
     * @return The deleted Recording.
     * @throws ZangException
     */
    public Recording deleteRecording(String accountSid, String recordingSid) throws ZangException {
        return returnThrows(proxy.deleteRecording(accountSid, recordingSid), Recording.class);
    }

    /**
     * Deletes a recording.
     * @param recordingSid Recording SID
     * @return The deleted Recording.
     * @throws ZangException
     */
    public Recording deleteRecording(String recordingSid) throws ZangException {
        return deleteRecording(conf.getSid(), recordingSid);
    }
}
