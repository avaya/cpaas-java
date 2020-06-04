package com.zang.api.restproxies;

import com.zang.api.domain.enums.*;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface CallsProxy {
    @GET
    @Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
    @Produces("application/json")
    Response getCall(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Calls.json")
    @Produces("application/json")
    Response getCallsList(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("To") String to,
            @QueryParam("From") String from,
            @QueryParam("Status") CallStatus status,
            @QueryParam("StartTime>") String startTimeGte,
            @QueryParam("StartTime<") String startTimeLt,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Calls.json")
    @Produces("application/json")
    Response makeCall(
            @PathParam("AccountSid") String accountSid,
            @FormParam("To") String to,
            @FormParam("From") String from,
            @FormParam("Url") String url,
            @FormParam("Method") HttpMethod method,
            @FormParam("FallbackUrl") String fallbackUrl,
            @FormParam("FallbackMethod") HttpMethod fallbackMethod,
            @FormParam("StatusCallback") String statusCallback,
            @FormParam("StatusCallbackMethod") HttpMethod statusCallbackMethod,
            @FormParam("HeartbeatUrl") String heartbeatUrl,
            @FormParam("HeartbeatMethod") HttpMethod heartbeatMethod,
            @FormParam("ForwardedFrom") String forwardedFrom,
            @FormParam("PlayDtmf") String playDtmf,
            @FormParam("Timeout") Integer timeout,
            @FormParam("HideCallerId") Boolean hideCallerId,
            @FormParam("Record") Boolean record,
            @FormParam("RecordCallback") String recordCallback,
            @FormParam("RecordCallbackMethod") HttpMethod recordCallbackMethod,
            @FormParam("Transcribe") Boolean transcribe,
            @FormParam("TranscribeCallback") String transcribeCallback,
            @FormParam("StraightToVoicemail") Boolean straightToVoicemail,
            @FormParam("IfMachine") IfMachine ifMachine,
            @FormParam("IfMachineUrl") String ifMachineUrl,
            @FormParam("IfMachineMethod") HttpMethod ifMachineMethod,
            @FormParam("SipAuthUsername") String sipAuthUsername,
            @FormParam("SipAuthPassword") String sipAuthPassword
    );

    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
    @Produces("application/json")
    Response interruptLiveCall(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid,
            @FormParam("Url") String url,
            @FormParam("Method") HttpMethod method,
            @FormParam("Status") EndCallStatus status
    );

    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
    @Produces("application/json")
    Response sendDigitsToLiveCall(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid,
            @FormParam("PlayDtmf") String playDtmf,
            @FormParam("PlayDtmfDirection") AudioDirection playDtmfDirection
    );


    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}/Recordings.json")
    @Produces("application/json")
    Response recordLiveCall(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid,
            @FormParam("Record") Boolean record,
            @FormParam("Direction") RecordingAudioDirection direction,
            @FormParam("TimeLimit") Integer timeLimit,
            @FormParam("CallbackUrl") String callbackUrl,
            @FormParam("FileFormat") RecordingFileFormat fileFormat,
            @FormParam("TrimSilence") Boolean trimSilence,
            @FormParam("Transcribe") Boolean transcribe,
            @FormParam("TranscribeQuality") TranscriptionQuality transcriptionQuality,
            @FormParam("TranscribeCallback") String transcribeCallback
    );

    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}/Play.json")
    @Produces("application/json")
    Response playAudioToLiveCall(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid,
            @FormParam("AudioUrl") String audioUrl,
            @FormParam("Direction") RecordingAudioDirection direction,
            @FormParam("Loop") Boolean loop
    );

    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}/Effect.json")
    @Produces("application/json")
    Response applyVoiceEffect(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CallSid") String callSid,
            @FormParam("AudioDirection") AudioDirection direction,
            @FormParam("Pitch") Double pitch,
            @FormParam("PitchSemiTones") Double pitchSemiTones,
            @FormParam("PitchOctaves") Double pitchOctaves,
            @FormParam("Rate") Double rate,
            @FormParam("Tempo") Double tempo
    );

}

