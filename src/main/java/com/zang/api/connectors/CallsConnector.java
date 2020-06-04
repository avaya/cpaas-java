package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.*;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.MakeCallParams;
import com.zang.api.restproxies.CallsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;
import java.util.Date;


/**
 * Used for all forms of communication with the Calls endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class CallsConnector extends BaseConnector {

    private CallsProxy proxy;

    CallsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(CallsProxy.class);
    }

    /**
     * View information about a call
     * @param accountSid Account SID
     * @param callSid Call SID
     * @return Information about a call
     * @throws ZangException
     */
    public Call viewCall(String accountSid, String callSid) throws ZangException {
        Response response = proxy.getCall(accountSid, callSid);
        return returnThrows(response, Call.class);
    }

    /**
     * View information about a call
     * @param callSid Call SID
     * @return Information about a call
     * @throws ZangException
     */
    public Call viewCall(String callSid) throws ZangException {
        return viewCall(conf.getSid(), callSid);
    }


    /**
     * List and filter calls associated with an account
     * @param accountSid Account SID
     * @param to Filter by receiving number
     * @param from Filter by calling number
     * @param status Filter by status
     * @param startTimeGte Filter by start time greater or equal than
     * @param startTimeLt Filter by start time less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of calls
     * @throws ZangException
     */
    public CallsList listCalls(String accountSid, String to, String from, CallStatus status, Date startTimeGte, Date startTimeLt, Integer page, Integer pageSize) throws ZangException {
        Response response = proxy.getCallsList(accountSid, to, from, status, getDateString(startTimeGte), getDateString(startTimeLt), page, pageSize);
        return returnThrows(response, CallsList.class);
    }

    /**
     * List and filter calls associated with your account.
     * @param to Filter by receiving number
     * @param from Filter by calling number
     * @param status Filter by status
     * @param startTimeGte Filter by start time greater or equal than
     * @param startTimeLt Filter by start time less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of calls.
     * @throws ZangException
     */
    public CallsList listCalls(String to, String from, CallStatus status, Date startTimeGte, Date startTimeLt, Integer page, Integer pageSize) throws ZangException {
        return listCalls(conf.getSid(), to, from, status, startTimeGte, startTimeLt, page, pageSize);
    }

    /**
     * List up to 50 calls associated with your account
     * @return List of calls
     * @throws ZangException
     */
    public CallsList listCalls() throws ZangException {
        return listCalls(conf.getSid(), null, null, null, null, null, null, null);
    }


    /**
     * Make a call
     * @param accountSid Account SID
     * @param to Required. The phone number or SIP endpoint to call. Phone number should be in international format and one
     *           recipient per request. For e.g, to dial a number in the US, the To should be, +17325551212.
     *           SIP endpoints must be prefixed with sip: e.g sip:12345@sip.zang.io.
     * @param from Required. The number to display as calling (i.e. Caller ID). The value does not have to be a real phone number
     *             or even in a valid format. For example, 8143 could be passed to the From parameter and would be
     *             displayed as the caller ID. Spoofed calls carry an additional charge.
     * @param url Required. The URL requested once the call connects. This URL must be valid and should return InboundXML
     *            containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *            the FallbackUrl but return an error without placing the call. Url length is limited
     *            to 200 characters.
     * @param method The HTTP method used to request the URL once the call connects.
     * @param fallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                    the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param fallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
     * @param heartbeatUrl A URL that will be requested every 60 seconds during the call, sending information about
     *                     the call. The HeartbeatUrl will NOT be requested unless at least 60 seconds of call time
     *                     have elapsed. URL length is limited to 200 characters.
     * @param heartbeatMethod The HTTP method used to request the HeartbeatUrl.
     * @param statusCallback A URL that will be requested when the call connects and ends, sending information about
     *                       the call. URL length is limited to 200 characters.
     * @param statusCallbackMethod The HTTP method used to request the StatusCallback URL.
     * @param forwardedFrom Specifies the Forwarding From number to pass to the carrier.
     * @param playDtmf Dial digits or play tones using DTMF as soon as the call connects. Useful for navigating IVRs.
     *                 Allowed values for digits are 0-9, #, *, W, or w (W and w are for .5 second pauses), for example
     *                 142##* (spaces are valid). Tones follow the @1000 syntax, for example to play the tone 4 for two
     *                 seconds, 4@2000 (milliseconds) would be used.
     * @param timeout Number of seconds call stays on line while waiting for an answer. The max time limit is 999.
     * @param hideCallerId Specifies if the Caller ID will be blocked.
     * @param record Specifies if this call should be recorded.
     * @param recordCallback The URL some parameters regarding the recording will be passed to once it is completed.
     *                       The longer the recording time, the longer the process delay in returning the recording
     *                       information. If no RecordCallback is given, the recording will still be saved to the
     *                       system and available either in your Recording Logs or via a REST List Recordings request.
     *                       Url length is limited to 200 characters.
     * @param recordCallbackMethod The HTTP method used to request the RecordCallback.
     * @param transcribe Specifies whether this call should be transcribed.
     * @param transcribeCallback The URL some parameters regarding the transcription will be passed to once it is
     *                           completed. The longer the recording time, the longer the process delay in returning
     *                           the transcription information. If no TranscribeCallback is given, the recording will
     *                           still be saved to the system and available either in your Transcriptions Logs or via
     *                           a REST List Transcriptions request. Url length is limited to 200 characters.
     * @param straightToVoicemail Specifies whether this call should be sent straight to the user's voicemail.
     * @param ifMachine Specifies how Zang should handle this call if it goes to voicemail. Allowed values are
     *                  "continue" to proceed as normal, "redirect" to redirect the call to the ifMachineUrl, or
     *                  "hangup" to hang up the call. Hangup occurs when the tone is played. IfMachine accuracy is
     *                  around 90% and may not work in all countries.
     * @param ifMachineUrl The URL Zang will redirect to for instructions if a voicemail machine is detected while the
     *                     IfMachine parameter is set to "redirect". Url length is limited to 200 characters.
     * @param ifMachineMethod The HTTP method used to request the IfMachineUrl.
     * @param sipAuthUsername Your authenticated SIP username, used only for SIP calls.
     * @param sipAuthPassword Your authenticated SIP password, used only for SIP calls.
     * @return Information about the created Call
     * @throws ZangException
     */
    public Call makeCall(String accountSid, String to, String from, String url, HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod, String statusCallback, HttpMethod statusCallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom, String playDtmf, Integer timeout, Boolean hideCallerId, Boolean record, String recordCallback, HttpMethod recordCallbackMethod, Boolean transcribe, String transcribeCallback, Boolean straightToVoicemail, IfMachine ifMachine, String ifMachineUrl, HttpMethod ifMachineMethod, String sipAuthUsername, String sipAuthPassword) throws ZangException {
        Response response = proxy.makeCall(accountSid, to, from, url, method, fallbackUrl, fallbackMethod, statusCallback, statusCallbackMethod, heartbeatUrl, heartbeatMethod, forwardedFrom, playDtmf, timeout, hideCallerId, record, recordCallback, recordCallbackMethod, transcribe, transcribeCallback, straightToVoicemail, ifMachine, ifMachineUrl, ifMachineMethod, sipAuthUsername, sipAuthPassword);
        return returnThrows(response, Call.class);
    }

    /**
     * Make a call.
     * @param callParams Parameters to make a call with.
     * @return Information about the created Call
     * @throws ZangException
     */
    public Call makeCall(MakeCallParams callParams) throws ZangException {
        return makeCall(callParams.getAccountSid() != null ? callParams.getAccountSid() : conf.getSid(), callParams.getTo(), callParams.getFrom(), callParams.getUrl(), callParams.getMethod(), callParams.getFallbackUrl(), callParams.getFallbackMethod(), callParams.getStatusCallback(), callParams.getStatusCallbackMethod(), callParams.getHeartbeatUrl(), callParams.getHeartbeatMethod(), callParams.getForwardedFrom(), callParams.getPlayDtmf(), callParams.getTimeout(), callParams.getHideCallerId(), callParams.getRecord(), callParams.getRecordCallback(), callParams.getRecordCallbackMethod(), callParams.getTranscribe(), callParams.getTranscribeCallback(), callParams.getStraightToVoicemail(), callParams.getIfMachine(), callParams.getIfMachineUrl(), callParams.getIfMachineMethod(), callParams.getSipAuthUsername(), callParams.getSipAuthPassword());
    }

    /**
     * Send new instructions to a call.
     * @param accountSid Account SID
     * @param callSid SID of the call to send instructions to
     * @param url The URL that in-progress calls will request for new instructions.
     * @param method The HTTP method used to request the redirect URL.
     * @param status The status used to end the call. Allowed values are "canceled" for ending queued or ringing calls,
     *               and "completed" to end in-progress calls in addition to queued and ringing calls.
     * @return The Call to which new instructions are sent to.
     * @throws ZangException
     */
    public Call interruptLiveCall(String accountSid, String callSid, String url, HttpMethod method, EndCallStatus status) throws ZangException {
        Response response = proxy.interruptLiveCall(accountSid, callSid, url, method, status);
        return returnThrows(response, Call.class);
    }

    /**
     * Send new instructions to a call.
     * @param callSid SID of the call to send instructions to
     * @param url The URL that in-progress calls will request for new instructions.
     * @param method The HTTP method used to request the redirect URL.
     * @param status The status used to end the call. Allowed values are "canceled" for ending queued or ringing calls,
     *               and "completed" to end in-progress calls in addition to queued and ringing calls.
     * @return The Call to which new instructions are sent to.
     * @throws ZangException
     */
    public Call interruptLiveCall(String callSid, String url, HttpMethod method, EndCallStatus status) throws ZangException {
        return interruptLiveCall(conf.getSid(), callSid, url, method, status);
    }

    /**
     * Use DTMF tones to mimic button presses.
     * @param accountSid Account SID
     * @param callSid The call to send digit to.
     * @param playDtmf Allowed values are the digits 0-9, #, *, W, or w. "w" and "W"stand for 1/2 second pauses.
     *                 You can combine these values together, for example, "12ww34". Tones are also supported and
     *                 follow the @1000 syntax, for example to play the tone 4 for two seconds, 4@2000 (milliseconds)
     *                 would be used.
     * @param playDtmfDirection Specifies which leg of the call DTMF tones will be played on. Allowed values are “in”
     *                          to send tones to the incoming caller or “out” to send tones to the out going caller.
     * @return The Call to which digits are sent to
     * @throws ZangException
     */
    public Call sendDigitsToLiveCall(String accountSid, String callSid, String playDtmf, AudioDirection playDtmfDirection) throws ZangException {
        Response response = proxy.sendDigitsToLiveCall(accountSid, callSid, playDtmf, playDtmfDirection);
        return returnThrows(response, Call.class);
    }

    /**
     * Use DTMF tones to mimic button presses.
     * @param callSid The call to send digit to.
     * @param playDtmf Allowed values are the digits 0-9, #, *, W, or w. "w" and "W"stand for 1/2 second pauses.
     *                 You can combine these values together, for example, "12ww34". Tones are also supported and
     *                 follow the @1000 syntax, for example to play the tone 4 for two seconds, 4@2000 (milliseconds)
     *                 would be used.
     * @param playDtmfDirection Specifies which leg of the call DTMF tones will be played on. Allowed values are “in”
     *                          to send tones to the incoming caller or “out” to send tones to the out going caller.
     * @return The Call to which digits are sent to
     * @throws ZangException
     */
    public Call sendDigitsToLiveCall(String callSid, String playDtmf, AudioDirection playDtmfDirection) throws ZangException {
        return sendDigitsToLiveCall(conf.getSid(), callSid, playDtmf, playDtmfDirection);
    }

    /**
     * Records a live call. Options include time limit, file format, trimming silence and transcribing.
     * @param accountSid Account SID
     * @param callSid SID of the Call to be recorded.
     * @param record Specifies if a call recording should start or end. Allowed values are "true" to start recording
     *               and "false" to end recording. Any number of simultaneous, separate recordings can be initiated.
     * @param direction Specifies which audio stream to record. Allowed values are "in" to record the incoming
     *                  caller's audio, "out" to record the outgoing caller's audio, and "both" to record both.
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
     * @return The Call for which recording is requested.
     * @throws ZangException
     */
    public Call recordLiveCall(String accountSid, String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        Response response = proxy.recordLiveCall(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, true, transcriptionQuality, transcribeCallback);
        return returnThrows(response, Call.class);
    }

    /**
     * Records a live call. Options include time limit, file format, trimming silence and transcribing.
     * @param callSid SID of the Call to be recorded.
     * @param record Specifies if a call recording should start or end. Allowed values are "true" to start recording
     *               and "false" to end recording. Any number of simultaneous, separate recordings can be initiated.
     * @param direction Specifies which audio stream to record. Allowed values are "in" to record the incoming
     *                  caller's audio, "out" to record the outgoing caller's audio, and "both" to record both.
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
     * @return The Call for which recording is requested.
     * @throws ZangException
     */
    public Call recordLiveCall(String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        return recordLiveCall(conf.getSid(), callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, true, transcriptionQuality, transcribeCallback);
    }

    /**
     * Plays audio to a live call. Options include restricting to one caller and looping.
     * @param accountSid Account SID
     * @param callSid Sid of the Call to play live audio to.
     * @param audioUrl A URL returning the sound file to play. Progressive downloads and SHOUTCAST streaming are
     *                 also supported.
     * @param direction Specifies which caller will hear the played audio. Allowed values are "in" to play audio to
     *                  the incoming caller, "out" to play to the outgoing caller, and "both" to play the audio to both
     *                  callers.
     * @param loop Specifies whether the audio will loop.
     * @return The Call live audio is played to.
     * @throws ZangException
     */
    public Call playAudioToLiveCall(String accountSid, String callSid, String audioUrl, RecordingAudioDirection direction, Boolean loop) throws ZangException {
        Response response = proxy.playAudioToLiveCall(accountSid, callSid, audioUrl, direction, loop);
        return returnThrows(response, Call.class);
    }

    /**
     * Plays audio to a live call. Options include restricting to one caller and looping.
     * @param callSid Sid of the Call to play live audio to.
     * @param audioUrl A URL returning the sound file to play. Progressive downloads and SHOUTCAST streaming are
     *                 also supported.
     * @param direction Specifies which caller will hear the played audio. Allowed values are "in" to play audio to
     *                  the incoming caller, "out" to play to the outgoing caller, and "both" to play the audio to both
     *                  callers.
     * @param loop Specifies whether the audio will loop.
     * @return The Call live audio is played to.
     * @throws ZangException
     */
    public Call playAudioToLiveCall(String callSid, String audioUrl, RecordingAudioDirection direction, Boolean loop) throws ZangException {
        return playAudioToLiveCall(conf.getSid(), callSid, audioUrl, direction, loop);
    }

    /**
     * Applies voice effect to the call.
     * @param accountSid Account SID
     * @param callSid SID of Call for which voice effects will be applied to
     * @param direction Specifies which caller should have their voice modified. Allowed values are "in" for the
     *                  incoming caller and "out" for the outgoing caller. This value can be changed as often as you
     *                  like to control live call flow.
     * @param pitch Sets the pitch. The lower the value, the lower the tone. Allowed values are doubles greater than 0.
     * @param pitchSemiTones Changes the pitch of audio in semitone intervals. Allowed values are doubles between -14
     *                       and 14.
     * @param pitchOctaves Changes the pitch of the audio in octave intervals. Allowed values are doubles between
     *                     -1 and 1.
     * @param rate Sets the rate. The lower the value, the lower the rate. Allowed values are doubles greater than 0.
     * @param tempo Sets the tempo. The lower the value, the slower the tempo. Allowed values are doubles greater
     *              than 0.
     * @return Call voice effects are applied to.
     * @throws ZangException
     */
    public Call applyVoiceEffect(String accountSid, String callSid, AudioDirection direction, Double pitch, Double pitchSemiTones, Double pitchOctaves, Double rate, Double tempo) throws ZangException {
        Response response = proxy.applyVoiceEffect(accountSid, callSid, direction, pitch, pitchSemiTones, pitchOctaves, rate, tempo);
        return returnThrows(response, Call.class);
    }

    /**
     * Applies voice effect to the call.
     * @param callSid SID of Call for which voice effects will be applied to
     * @param direction Specifies which caller should have their voice modified. Allowed values are "in" for the
     *                  incoming caller and "out" for the outgoing caller. This value can be changed as often as you
     *                  like to control live call flow.
     * @param pitch Sets the pitch. The lower the value, the lower the tone. Allowed values are doubles greater than 0.
     * @param pitchSemiTones Changes the pitch of audio in semitone intervals. Allowed values are doubles between -14
     *                       and 14.
     * @param pitchOctaves Changes the pitch of the audio in octave intervals. Allowed values are doubles between
     *                     -1 and 1.
     * @param rate Sets the rate. The lower the value, the lower the rate. Allowed values are doubles greater than 0.
     * @param tempo Sets the tempo. The lower the value, the slower the tempo. Allowed values are doubles greater
     *              than 0.
     * @return Call voice effects are applied to.
     * @throws ZangException
     */
    public Call applyVoiceEffect(String callSid, AudioDirection direction, Double pitch, Double pitchSemiTones, Double pitchOctaves, Double rate, Double tempo) throws ZangException {
        return applyVoiceEffect(conf.getSid(), callSid, direction, pitch, pitchSemiTones, pitchOctaves, rate, tempo);
    }

     /**
     * Applies voice effect to the call.
     * @param callSid SID of Call for which voice effects will be applied to
     * @param pitchSemiTones Changes the pitch of audio in semitone intervals. Allowed values are doubles between -14
     *                       and 14.
     * @return Call voice effects are applied to.
     * @throws ZangException
     */
    public Call applyVoiceEffect(String callSid, Double pitchSemiTones) throws ZangException {
        return applyVoiceEffect(conf.getSid(), callSid, AudioDirection.OUT, Double.NaN, pitchSemiTones, Double.NaN, Double.NaN, Double.NaN);
    }
}
