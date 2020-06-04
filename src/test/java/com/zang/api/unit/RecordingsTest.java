package com.zang.api.unit;

import com.zang.api.connectors.RecordingsConnector;
import com.zang.api.domain.Recording;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.RecordCallParams;
import com.zang.api.testutil.TestParameters;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class RecordingsTest extends BaseUnitTest {

    private RecordingsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getRecordingsConnector();
    }

    @Test
    public void viewRecording() throws ZangException, IOException {
        createExpectation("RecordingsTest", "viewRecording");
        checkRecording(connector.viewRecording("TestRecordingSid"));
    }

    @Test
    public void listRecordings() throws ZangException, IOException {
        createExpectation("RecordingsTest", "listRecordings");
        connector.listRecordings("TestCallSid", TestParameters.getFromDate(), TestParameters.getToDate(), 0, 33);
    }

    @Test
    public void recordCall() throws ZangException, IOException {
        createExpectation("RecordingsTest", "recordCall");
        checkRecording(connector.recordCall(RecordCallParams.builder()
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
                .build()));
    }

    @Test
    public void deleteRecording() throws ZangException, IOException {
        createExpectation("RecordingsTest", "deleteRecording");
        checkRecording(connector.deleteRecording("TestRecordingSid"));
    }


    private void checkRecording(Recording recording) {
        Assert.assertEquals("http://recordings.telapi.com/RBfcc94a3e2b5d4e4c89f7017d6387ffb8/RE4288908463cd614b41084509ad8893a7.mp3", recording.getRecordingUrl());
    }

}
