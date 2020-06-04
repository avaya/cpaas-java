package com.zang.api.it;

import com.zang.api.connectors.RecordingsConnector;
import com.zang.api.domain.Call;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import org.junit.Test;

public class RecordingsIT extends BaseIntegrationTest {


    private final RecordingsConnector conn;

    public RecordingsIT() throws ZangException {
        conn = connectorFactory.getRecordingsConnector();
    }

    @Test
    public void listRecordings() throws ZangException {
        CallsList calls = connectorFactory.getCallsConnector().listCalls();
        for (Call call : calls) {
            conn.listRecordings(call.getSid(), null, null, 0, 50);
        }
    }

}
