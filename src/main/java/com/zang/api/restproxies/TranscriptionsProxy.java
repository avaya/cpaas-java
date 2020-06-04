package com.zang.api.restproxies;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.enums.TranscriptionStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface TranscriptionsProxy {

    @GET
    @Path("Accounts/{AccountSid}/Transcriptions/{TranscriptionSid}.json")
    @Produces("application/json")
    Response viewTranscription(
            @PathParam("AccountSid") String accountSid,
            @PathParam("TranscriptionSid") String transcriptionSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Transcriptions.json")
    @Produces("application/json")
    Response listTranscriptions(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Status") TranscriptionStatus status,
            @QueryParam("DateTranscribed>") String dateSentGte,
            @QueryParam("DateTranscribed<") String dateSentLt,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Recordings/{RecordingSid}/Transcriptions.json")
    @Produces("application/json")
    Response transcribeRecording(
            @PathParam("AccountSid") String accountSid,
            @PathParam("RecordingSid") String recordingSid,
            @FormParam("TranscribeCallback") String transcribeCallback,
            @FormParam("CallbackMethod") HttpMethod callbackMethod,
            @FormParam("SliceStart") Integer sliceStart,
            @FormParam("SliceDuration") Integer sliceDuration,
            @FormParam("Quality") TranscriptionQuality quality
    );

    @POST
    @Path("Accounts/{AccountSid}/Transcriptions.json")
    @Produces("application/json")
    Response transcribeAudioUrl(
            @PathParam("AccountSid") String accountSid,
            @FormParam("AudioUrl") String audioUrl,
            @FormParam("TranscribeCallback") String transcribeCallback,
            @FormParam("CallbackMethod") HttpMethod callbackMethod,
            @FormParam("SliceStart") Integer sliceStart,
            @FormParam("SliceDuration") Integer sliceDuration,
            @FormParam("Quality") TranscriptionQuality quality
    );
}
