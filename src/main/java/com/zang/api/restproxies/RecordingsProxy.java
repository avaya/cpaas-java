package com.zang.api.restproxies;

import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface RecordingsProxy {
    @GET
    @Path("Accounts/{AccountSid}/Recordings/{RecordingSid}.json")
    @Produces("application/json")
    Response viewRecording(
            @PathParam("AccountSid") String accountSid,
            @PathParam("RecordingSid") String recordingSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Recordings.json")
    @Produces("application/json")
    Response listRecordings(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("CallSid") String callSid,
            @QueryParam("DateCreated>") String dateCreatedGte,
            @QueryParam("DateCreated<") String dateCreatedLt,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );


    @POST
    @Path("Accounts/{AccountSid}/Calls/{CallSid}/Recordings.json")
    @Produces("application/json")
    Response recordCall(
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

    @DELETE
    @Path("Accounts/{AccountSid}/Recordings/{RecordingSid}.json")
    @Produces("application/json")
    Response deleteRecording(
            @PathParam("AccountSid") String accountSid,
            @PathParam("RecordingSid") String recordingSid
    );
}

