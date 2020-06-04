package com.zang.api.it;

import com.zang.api.connectors.CallsConnector;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.MakeCallParams;
import org.junit.Test;

public class CallsIT extends BaseIntegrationTest {


    private final CallsConnector conn;

    public CallsIT() throws ZangException {
        conn = connectorFactory.getCallsConnector();
    }

    @Test
    public void makeCall() throws ZangException {
        conn.makeCall(MakeCallParams.builder()
                .setRecord(true)
                .setFrom(testParameters.getPhone2())
                .setTo(testParameters.getPhone1())
                .setUrl(testParameters.getInboundXmlUrl())
                .build());
    }

}
