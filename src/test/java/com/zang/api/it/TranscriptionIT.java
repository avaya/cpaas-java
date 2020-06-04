package com.zang.api.it;

import com.zang.api.connectors.TranscriptionsConnector;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.list.TranscriptionsList;
import com.zang.api.exceptions.ZangException;
import org.junit.Test;

public class TranscriptionIT extends BaseIntegrationTest {


    public TranscriptionIT() throws ZangException {
    }

    @Test
    public void transcribeAudioUrl() throws ZangException {
        TranscriptionsConnector conn = connectorFactory.getTranscriptionsConnector();
        conn.transcribeAudioUrl(testParameters.getMp3Url(), null, null, 0, 50, TranscriptionQuality.AUTO);
        TranscriptionsList list = conn.listTranscriptions();
        for(Transcription transcription : list) {
            System.out.println(transcription.getTranscriptionText());
        }
    }

}
