package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.enums.ConferenceStatus;
import com.zang.api.domain.list.ConferencesList;
import com.zang.api.domain.list.ParticipantsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.ConferencesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


/**
 * Used for all forms of communication with the Conferences endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class ConferencesConnector extends BaseConnector {

    private ConferencesProxy proxy;

    ConferencesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(ConferencesProxy.class);
    }


    /**
     * Shows information about a conference
     * @param accountSid Account SID
     * @param conferenceSid SID of the conference for which you want to retrieve information
     * @return Information about the Conference
     * @throws ZangException
     */
    public Conference viewConference(String accountSid, String conferenceSid)
            throws ZangException {
        return returnThrows(proxy.viewConference(accountSid,
                conferenceSid), Conference.class);
    }

    /**
     * Shows information about a conference
     * @param conferenceSid SID of the conference for which you want to retrieve information
     * @return Information about the Conference
     * @throws ZangException
     */
    public Conference viewConference(String conferenceSid)
            throws ZangException {
        return viewConference(conf.getSid(), conferenceSid);
    }


    /**
     * List conferences associated with an account
     * @param accountSid Account SID
     * @param friendlyName Filter by Friendly Name
     * @param status Filter by status
     * @param dateCreatedGte Filter by date created greater or equal than
     * @param dateCreatedLt Filter by date created less than
     * @param dateUpdatedGte Filter by date updated greater or equal than
     * @param dateUpdatedLt Filter by date updated less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Conferences
     * @throws ZangException
     */
    public ConferencesList listConferences(String accountSid,
                                           String friendlyName, ConferenceStatus status, Date dateCreatedGte,
                                           Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
                                           Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listConferences(accountSid,
                friendlyName, status, getDateString(dateCreatedGte),
                getDateString(dateCreatedLt), getDateString(dateUpdatedGte),
                getDateString(dateUpdatedLt), page, pageSize), ConferencesList.class);
    }

    /**
     * List conferences associated with your account
     * @param friendlyName Filter by Friendly Name
     * @param status Filter by status
     * @param dateCreatedGte Filter by date created greater or equal than
     * @param dateCreatedLt Filter by date created less than
     * @param dateUpdatedGte Filter by date updated greater or equal than
     * @param dateUpdatedLt Filter by date updated less than
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Conferences
     * @throws ZangException
     */
    public ConferencesList listConferences(String friendlyName, ConferenceStatus status, Date dateCreatedGte,
                                           Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
                                           Integer page, Integer pageSize) throws ZangException {
        return listConferences(conf.getSid(), friendlyName, status,
                dateCreatedGte, dateCreatedLt, dateUpdatedGte, dateUpdatedLt,
                page, pageSize);
    }


    /**
     * List up to 50 conferences associated with your account
     * @return List of Conferences
     * @throws ZangException
     */
    public ConferencesList listConferences() throws ZangException {
        return listConferences(null, null, null, null, null, null, null, null);
    }


    /**
     * Shows information about a Conference participant
     * @param accountSid Account SID
     * @param conferenceSid SID of conference a participant is a part of
     * @param participantSid SID of the participant
     * @return Information about a Participant
     * @throws ZangException
     */
    public Participant viewParticipant(String accountSid, String conferenceSid,
                                       String participantSid) throws ZangException {
        return returnThrows(proxy.viewParticipant(accountSid,
                conferenceSid, participantSid), Participant.class);
    }


    /**
     * Shows information about a Conference participant
     * @param conferenceSid SID of conference a participant is a part of
     * @param participantSid SID of the participant
     * @return Information about a Participant
     * @throws ZangException
     */
    public Participant viewParticipant(String conferenceSid, String participantSid)
            throws ZangException {
        return returnThrows(proxy.viewParticipant(conf.getSid(),
                conferenceSid, participantSid), Participant.class);
    }


    /**
     * List participants in a conference.
     * @param accountSid Account SID
     * @param conferenceSid Conference SID
     * @param muted Filter only muted participants
     * @param deaf Filter only deaf participants
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of participants
     * @throws ZangException
     */
    public ParticipantsList listParticipants(String accountSid,
                                             String conferenceSid, Boolean muted, Boolean deaf, Integer page,
                                             Integer pageSize) throws ZangException {
        return returnThrows(proxy.listParticipants(accountSid,
                conferenceSid, muted, deaf, page, pageSize), ParticipantsList.class);
    }


    /**
     * List participants in a conference.
     * @param conferenceSid Conference SID
     * @param muted Filter only muted participants
     * @param deaf Filter only deaf participants
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of participants
     * @throws ZangException
     */
    public ParticipantsList listParticipants(
            String conferenceSid, Boolean muted, Boolean deaf, Integer page,
            Integer pageSize) throws ZangException {
        return listParticipants(conf.getSid(), conferenceSid, muted, deaf, page, pageSize);
    }


    /**
     * List up to 50 participants in a conference.
     * @param conferenceSid Conference SID
     * @return List of participants
     * @throws ZangException
     */
    public ParticipantsList listParticipants(String conferenceSid) throws ZangException {
        return listParticipants(conferenceSid, null, null, null, null);
    }


    /**
     * Set status of participant in a conference to muted or deaf
     * @param accountSid Account SID
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @param muted Specifies whether the participant should be muted.
     * @param deaf Specifies whether the participant should be deaf.
     * @return The participant in question.
     * @throws ZangException
     */
    public Participant deafOrMuteParticipant(String accountSid, String conferenceSid, String participantSid, Boolean muted, Boolean deaf) throws ZangException {
        return returnThrows(proxy.muteDeafParticipant(accountSid, conferenceSid, participantSid, muted, deaf), Participant.class);
    }


    /**
     * Set status of participant in a conference to muted or deaf
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @param muted Specifies whether the participant should be muted.
     * @param deaf Specifies whether the participant should be deaf.
     * @return The participant in question.
     * @throws ZangException
     */
    public Participant deafOrMuteParticipant(String conferenceSid, String participantSid, Boolean muted, Boolean deaf) throws ZangException {
        return returnThrows(proxy.muteDeafParticipant(conf.getSid(), conferenceSid, participantSid, muted, deaf), Participant.class);
    }


    /**
     * Hangs up a conference participant.
     * @param accountSid Account SID
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @return The participant that was hung up.
     * @throws ZangException
     */
    public Participant hangupParticipant(String accountSid, String conferenceSid,
                                         String participantSid) throws ZangException {
        return returnThrows(proxy.hangupParticipant(accountSid, conferenceSid, participantSid), Participant.class);
    }


    /**
     * Hangs up a conference participant.
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @return The participant that was hung up.
     * @throws ZangException
     */
    public Participant hangupParticipant(String conferenceSid, String participantSid)
            throws ZangException {
        return returnThrows(proxy.hangupParticipant(conf.getSid(),
                conferenceSid, participantSid), Participant.class);
    }


    /**
     * Plays an audio file to a conference participant
     * @param accountSid Account SID
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @param audioUrl A URL to the audio file that will be played to the participant.
     * @return Participant in question.
     * @throws ZangException
     */
    public Participant playAudioToParticipant(String accountSid,
                                              String conferenceSid, String participantSid, String audioUrl)
            throws ZangException {
        return returnThrows(proxy.playAudioToParticipant(accountSid,
                conferenceSid, participantSid, audioUrl), Participant.class);
    }

    /**
     * Plays an audio file to a conference participant
     * @param conferenceSid Conference SID
     * @param participantSid Participant SID
     * @param audioUrl A URL to the audio file that will be played to the participant.
     * @return Participant in question.
     * @throws ZangException
     */
    public Participant playAudioToParticipant(String conferenceSid,
                                              String participantSid, String audioUrl) throws ZangException {
        return playAudioToParticipant(conf.getSid(), conferenceSid, participantSid,
                audioUrl);
    }

}
