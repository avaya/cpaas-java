package com.zang.api.unit;

import com.zang.api.connectors.ConferencesConnector;
import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.enums.ConferenceStatus;
import com.zang.api.domain.list.ConferencesList;
import com.zang.api.domain.list.ParticipantsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.testutil.TestParameters;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;


public class ConferencesTest extends BaseUnitTest {

    @Test
    public void viewConference() throws ZangException, IOException {
        createExpectation("ConferencesTest", "viewConference");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        Conference conference = connector.viewConference("TestConferenceSid");
        checkConference(conference);
    }

    @Test
    public void listConferences() throws ZangException, IOException {
        createExpectation("ConferencesTest", "listConferences");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();

        ConferencesList conferences = connector.listConferences("TestConference", ConferenceStatus.COMPLETED,
                TestParameters.getFromDate(), TestParameters.getToDate(), TestParameters.getFromDate(), TestParameters.getToDate(), 0, 10);

        Assert.assertEquals(2, (int) conferences.getTotal());
        checkConference(conferences.iterator().next());
    }

    @Test
    public void viewParticipant() throws ZangException, IOException {
        createExpectation("ConferencesTest", "viewParticipant");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        Participant participant = connector.viewParticipant("TestConferenceSid", "TestParticipantSid");
        checkParticipant(participant);
    }

    @Test
    public void listParticipants() throws ZangException, IOException {
        createExpectation("ConferencesTest", "listParticipants");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        ParticipantsList participants = connector.listParticipants("TestConferenceSid", false, false, 0, 10);
        Assert.assertEquals(1, (int) participants.getTotal());
        checkParticipant(participants.iterator().next());
    }

    @Test
    public void muteDeafParticipant() throws ZangException, IOException {
        createExpectation("ConferencesTest", "muteDeafParticipant");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        Participant participant = connector.deafOrMuteParticipant("TestConferenceSid", "TestParticipantSid", true, true);
        checkParticipant(participant);
    }

    @Test
    public void playAudioToParticipant() throws ZangException, IOException {
        createExpectation("ConferencesTest", "playAudioToParticipant");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        Participant participant = connector.playAudioToParticipant("TestConferenceSid", "TestParticipantSid", "http://mydomain.com/audio.mp3");
        checkParticipant(participant);
    }

    @Test
    public void hangupParticipant() throws ZangException, IOException {
        createExpectation("ConferencesTest", "hangupParticipant");
        ConferencesConnector connector = connectorFactory.getConferencesConnector();
        Participant participant = connector.hangupParticipant("TestConferenceSid", "TestParticipantSid");
        checkParticipant(participant);
    }

    private void checkConference(Conference conference) {
        Assert.assertEquals("TestConferenceSid", conference.getSid());
        Assert.assertEquals(ConferenceStatus.COMPLETED, conference.getStatus());
        Assert.assertEquals("TestConference", conference.getFriendlyName());
    }

    private void checkParticipant(Participant participant) {
        Assert.assertEquals("TestParticipantSid", participant.getSid());
        Assert.assertEquals("TestConferenceSid", participant.getConferenceSid());
        Assert.assertFalse(participant.getMuted());
    }

}
