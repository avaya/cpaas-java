package com.zang.api.unit;

import com.zang.api.connectors.CallsConnector;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.*;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.MakeCallParams;
import com.zang.api.testutil.TestParameters;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;


public class CallsTest extends BaseUnitTest {

    @Test
    public void viewCall() throws ZangException, IOException {
        createExpectation("CallsTest", "viewCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.viewCall("TestCallSid");
        checkCall(call);
    }

    @Test
    public void listCalls() throws ZangException, IOException {
        createExpectation("CallsTest", "listCalls");
        CallsConnector connector = connectorFactory.getCallsConnector();

        CallsList callsList = connector.listCalls(
                "+123456",
                "+654321",
                CallStatus.COMPLETED,
                TestParameters.getFromDate(),
                TestParameters.getToDate(),
                0,
                10);
        Assert.assertEquals(1, (int) callsList.getTotal());
        checkCall(callsList.iterator().next());
    }

    @Test
    public void makeCall() throws ZangException, IOException {
        createExpectation("CallsTest", "makeCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.makeCall(MakeCallParams.builder()
                .setTo("+123456")
                .setFrom("+654321")
                .setUrl("TestUrl")
                .setMethod(HttpMethod.GET)
                .setFallbackUrl("FallbackUrl")
                .setFallbackMethod(HttpMethod.POST)
                .setStatusCallback("StatusCallback")
                .setStatusCallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.GET)
                .setForwardedFrom("1234")
                .setPlayDtmf("123#")
                .setTimeout(122)
                .setHideCallerId(true)
                .setRecord(true)
                .setRecordCallback("RecordCallback")
                .setRecordCallbackMethod(HttpMethod.GET)
                .setTranscribe(true)
                .setTranscribeCallback("TranscribeCallback")
                .setStraightToVoicemail(true)
                .setIfMachine(IfMachine.REDIRECT)
                .setIfMachineUrl("IfMachineUrl")
                .setIfMachineMethod(HttpMethod.GET)
                .setSipAuthUsername("username")
                .setSipAuthPassword("password")
                .build());
        checkCall(call);
    }

    @Test
    public void interruptLiveCall() throws ZangException, IOException {
        createExpectation("CallsTest", "interruptLiveCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.interruptLiveCall("TestCallSid", "TestUrl", HttpMethod.GET, EndCallStatus.CANCELED);
        checkCall(call);
    }

    @Test
    public void sendDigitsToLiveCall() throws ZangException, IOException {
        createExpectation("CallsTest", "sendDigitsToLiveCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.sendDigitsToLiveCall("TestCallSid", "0123#", AudioDirection.OUT);
        checkCall(call);
    }

    @Test
    public void recordLiveCall() throws ZangException, IOException {
        createExpectation("CallsTest", "recordLiveCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.recordLiveCall("TestCallSid", true, RecordingAudioDirection.BOTH, 15, "TestUrl", RecordingFileFormat.MP3, true, true, TranscriptionQuality.HYBRID, "TestTranscribeUrl");
        checkCall(call);
    }

    @Test
    public void playAudioToLiveCall() throws ZangException, IOException {
        createExpectation("CallsTest", "playAudioToLiveCall");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.playAudioToLiveCall("TestCallSid", "AudioUrl", RecordingAudioDirection.BOTH, true);
        checkCall(call);
    }

    //@Test
    public void applyVoiceEffect() throws ZangException, IOException {
        createExpectation("CallsTest", "applyVoiceEffect");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.applyVoiceEffect("TestCallSid", AudioDirection.OUT, 5.0, 4.0, 3.0, 2.0, 1.0);
        checkCall(call);
    }


    private void checkCall(Call call) {
        Assert.assertEquals(AnsweredBy.TBD, call.getAnsweredBy());
        BigDecimal expect = new BigDecimal(0.1872);
        BigDecimal receive = call.getPrice();
        expect = expect.setScale(4, BigDecimal.ROUND_HALF_UP);
        receive = receive.setScale(4, BigDecimal.ROUND_HALF_UP);
        Assert.assertEquals(0, expect.compareTo(receive));
        Assert.assertEquals(CallStatus.COMPLETED, call.getStatus());
    }

}
