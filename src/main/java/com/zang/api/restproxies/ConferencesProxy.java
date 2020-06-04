package com.zang.api.restproxies;

import com.zang.api.domain.enums.ConferenceStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface ConferencesProxy {
    @GET
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}.json")
    @Produces("application/json")
    Response viewConference(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Conferences.json")
    @Produces("application/json")
    Response listConferences(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("FriendlyName") String friendlyName,
            @QueryParam("Status") ConferenceStatus status,
            @QueryParam("DateCreated>") String dateCreatedGte,
            @QueryParam("DateCreated<") String dateCreatedLt,
            @QueryParam("DateUpdated>") String dateUpdatedGte,
            @QueryParam("DateUpdated<") String dateUpdatedLt,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @GET
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{ParticipantSid}.json")
    @Produces("application/json")
    Response viewParticipant(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid,
            @PathParam("ParticipantSid") String participantSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants.json")
    @Produces("application/json")
    Response listParticipants(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid,
            @QueryParam("Muted") Boolean muted,
            @QueryParam("Deaf") Boolean deaf,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{ParticipantSid}.json")
    @Produces("application/json")
    Response muteDeafParticipant(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid,
            @PathParam("ParticipantSid") String participantSid,
            @FormParam("Muted") Boolean muted,
            @FormParam("Deaf") Boolean deaf
    );


    @DELETE
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{ParticipantSid}.json")
    @Produces("application/json")
    Response hangupParticipant(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid,
            @PathParam("ParticipantSid") String participantSid
    );


    @POST
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{ParticipantSid}/Play.json")
    @Produces("application/json")
    Response playAudioToParticipant(
            @PathParam("AccountSid") String accountSid,
            @PathParam("ConferenceSid") String conferenceSid,
            @PathParam("ParticipantSid") String participantSid,
            @FormParam("AudioUrl") String audioUrl
    );

}

