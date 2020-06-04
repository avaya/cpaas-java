package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.RecordingsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Recording;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.list.RecordingsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.RecordCallParams;
import com.zang.api.testutil.TestParameters;


public class RecordingsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        RecordingsConnector connector = ZangConnectorFactory.getRecordingsConnector(conf);

        //view recording
        try {
            Recording recording = connector.viewRecording("TestRecordingSid");
            System.out.println(recording.getDuration());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list recordings
        try {
            RecordingsList recordingsList = connector.listRecordings("TestCallSid", TestParameters.getFromDate(),
                    TestParameters.getToDate(), 0, 33);
            System.out.println(recordingsList.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //record call
        try {
            Recording recording = connector.recordCall(RecordCallParams.builder()
                    .setCallSid("TestCallSid")
                    .setRecord(true)
                    .setDirection(RecordingAudioDirection.OUT)
                    .setTimeLimit(1337)
                    .setCallbackUrl("CallbackUrl")
                    .setFileFormat(RecordingFileFormat.WAV)
                    .setTrimSilence(true)
                    .setTranscribe(true)
                    .setTranscriptionQuality(TranscriptionQuality.HYBRID)
                    .setTranscribeCallback("TranscribeCallback")
                    .build());
            System.out.println(recording.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //delete recording
        try {
            Recording recording = connector.deleteRecording("TestRecordingSid");
            System.out.println(recording.getPrice());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }

}
