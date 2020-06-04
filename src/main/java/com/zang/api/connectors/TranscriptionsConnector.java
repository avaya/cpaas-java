package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.enums.TranscriptionStatus;
import com.zang.api.domain.list.TranscriptionsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.TranscriptionsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


/**
 * Used for all forms of communication with the Transcriptions endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class TranscriptionsConnector extends BaseConnector {

    private TranscriptionsProxy proxy;

    TranscriptionsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(TranscriptionsProxy.class);
    }

    /**
     * Shows info on a transcription.
     * @param accountSid Account SID
     * @param transcriptionSid Transcription SID
     * @return The requested Transcription.
     * @throws ZangException
     */
    public Transcription viewTranscription(String accountSid, String transcriptionSid) throws ZangException {
        return returnThrows(proxy.viewTranscription(accountSid, transcriptionSid), Transcription.class);
    }

    /**
     * Shows info on a transcription.
     * @param transcriptionSid Transcription SID
     * @return The requested Transcription.
     * @throws ZangException
     */
    public Transcription viewTranscription(String transcriptionSid) throws ZangException {
        return viewTranscription(conf.getSid(), transcriptionSid);
    }

    /**
     * Shows info on all transcriptions associated with an account.
     * @param accountSid Account SID
     * @param status Filter by transcriptions with a given status.
     * @param dateTranscribedGte Filter by date transcribed greater or equal than
     * @param dateTranscribedLt filter by date transcribed less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Transcriptions.
     * @throws ZangException
     */
    public TranscriptionsList listTranscriptions(String accountSid, TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listTranscriptions(accountSid, status, getDateString(dateTranscribedGte), getDateString(dateTranscribedLt), page, pageSize), TranscriptionsList.class);
    }

    /**
     * Shows info on all transcriptions associated with your account.
     * @param status Filter by transcriptions with a given status.
     * @param dateTranscribedGte Filter by date transcribed greater or equal than
     * @param dateTranscribedLt filter by date transcribed less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Transcriptions.
     * @throws ZangException
     */
    public TranscriptionsList listTranscriptions(TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Integer page, Integer pageSize) throws ZangException {
        return listTranscriptions(conf.getSid(), status, dateTranscribedGte, dateTranscribedLt, page, pageSize);
    }

    /**
     * Shows info on up to 50 transcriptions associated with your account.
     * @return A list of Transcriptions
     * @throws ZangException
     */
    public TranscriptionsList listTranscriptions() throws ZangException {
        return listTranscriptions(conf.getSid(), null, null, null, null, null);
    }

    /**
     * Transcribes a recording.
     * @param accountSid Account SID
     * @param recordingSid Recording SID
     * @param transcribeCallback The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. URL length is limited to 200 characters.
     * @param callbackMethod The HTTP method used to request the TranscribeCallback.
     * @param sliceStart Start point for slice transcription (in seconds).
     * @param sliceDuration Duration of slice transcription (in seconds).
     * @param quality Specifies the transcription quality. Transcription price differs for each quality tier.
     *                See pricing page for details. Allowed values are "auto", "hybrid" and "keywords", where "auto"
     *                is a machine-generated transcription, "hybrid" is reviewed by a human for accuracy and "keywords"
     *                returns topics and keywords for given audio file.
     * @return Information about the Transcription.
     * @throws ZangException
     */
    public Transcription transcribeRecording(String accountSid, String recordingSid, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return returnThrows(proxy.transcribeRecording(accountSid, recordingSid, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality), Transcription.class);
    }

    /**
     * Transcribes a recording.
     * @param recordingSid Recording SID
     * @param transcribeCallback The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. URL length is limited to 200 characters.
     * @param callbackMethod The HTTP method used to request the TranscribeCallback.
     * @param sliceStart Start point for slice transcription (in seconds).
     * @param sliceDuration Duration of slice transcription (in seconds).
     * @param quality Specifies the transcription quality. Transcription price differs for each quality tier.
     *                See pricing page for details. Allowed values are "auto", "hybrid" and "keywords", where "auto"
     *                is a machine-generated transcription, "hybrid" is reviewed by a human for accuracy and "keywords"
     *                returns topics and keywords for given audio file.
     * @return Information about the Transcription.
     * @throws ZangException
     */
    public Transcription transcribeRecording(String recordingSid, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return transcribeRecording(conf.getSid(), recordingSid, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality);
    }

    /**
     * Transcribes an audio file on an URL.
     * @param accountSid Account SID
     * @param audioUrl URL where the audio to be transcribed is located.
     * @param transcribeCallback The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. URL length is limited to 200 characters.
     * @param callbackMethod The HTTP method used to request the TranscribeCallback.
     * @param sliceStart Start point for slice transcription (in seconds).
     * @param sliceDuration Duration of slice transcription (in seconds).
     * @param quality Specifies the transcription quality. Transcription price differs for each quality tier.
     *                See pricing page for details. Allowed values are "auto", "hybrid" and "keywords", where "auto"
     *                is a machine-generated transcription, "hybrid" is reviewed by a human for accuracy and "keywords"
     *                returns topics and keywords for given audio file.
     * @return Information about the Transcription.
     * @throws ZangException
     */
    public Transcription transcribeAudioUrl(String accountSid, String audioUrl, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return returnThrows(proxy.transcribeAudioUrl(accountSid, audioUrl, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality), Transcription.class);
    }

    /**
     * Transcribes an audio file on an URL.
     * @param audioUrl URL where the audio to be transcribed is located.
     * @param transcribeCallback The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. URL length is limited to 200 characters.
     * @param callbackMethod The HTTP method used to request the TranscribeCallback.
     * @param sliceStart Start point for slice transcription (in seconds).
     * @param sliceDuration Duration of slice transcription (in seconds).
     * @param quality Specifies the transcription quality. Transcription price differs for each quality tier.
     *                See pricing page for details. Allowed values are "auto", "hybrid" and "keywords", where "auto"
     *                is a machine-generated transcription, "hybrid" is reviewed by a human for accuracy and "keywords"
     *                returns topics and keywords for given audio file.
     * @return Information about the Transcription.
     * @throws ZangException
     */
    public Transcription transcribeAudioUrl(String audioUrl, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return transcribeAudioUrl(conf.getSid(), audioUrl, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality);
    }
}


