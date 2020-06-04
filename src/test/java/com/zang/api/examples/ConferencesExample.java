package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ConferencesConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.enums.ConferenceStatus;
import com.zang.api.domain.list.ConferencesList;
import com.zang.api.domain.list.ParticipantsList;
import com.zang.api.exceptions.ZangException;

import java.util.Calendar;
import java.util.Date;

public class ConferencesExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ConferencesConnector connector = ZangConnectorFactory.getConferencesConnector(conf);

        //view conference
        try {
            Conference conference = connector.viewConference("TestConferenceSid");
            System.out.println(conference.getFriendlyName());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list conferences
        try {
            Calendar from = Calendar.getInstance();
            from.set(2016, Calendar.DECEMBER, 12);
            Date fromDate = from.getTime();
            Calendar to = Calendar.getInstance();
            to.set(2017, Calendar.MARCH, 19);
            Date toDate = to.getTime();
            ConferencesList conferences = connector.listConferences("TestConference", ConferenceStatus.COMPLETED,
                    fromDate, toDate, fromDate, toDate, 0, 10);
            for(Conference conference : conferences) {
                System.out.println(conference.getFriendlyName());
            }

        } catch (ZangException e) {
            e.printStackTrace();
        }

        //view participant
        try {
            Participant participant = connector.viewParticipant("TestConferenceSid", "TestParticipantSid");
            System.out.println(participant.getCallerName());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list participants
        try {
            ParticipantsList participants = connector.listParticipants("TestConferenceSid", false, false, 0, 10);
            System.out.println(participants.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //mute/deaf participant
        try {
            Participant participant = connector.deafOrMuteParticipant("TestConferenceSid", "TestParticipantSid", true, true);
            System.out.println(participant.getMuted());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //play audio to participant
        try {
            Participant participant = connector.playAudioToParticipant("TestConferenceSid", "TestParticipantSid", "http://mydomain.com/audio.mp3");
            System.out.println(participant.getDuration());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //hangup participant
        try {
            Participant participant = connector.hangupParticipant("TestConferenceSid", "TestParticipantSid");
            System.out.println(participant.getCallerNumber());
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }
}
