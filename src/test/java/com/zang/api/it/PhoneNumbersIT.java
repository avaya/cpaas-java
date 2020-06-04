package com.zang.api.it;

import com.zang.api.connectors.AvailablePhoneNumbersConnector;
import com.zang.api.connectors.IncomingPhoneNumbersConnector;
import com.zang.api.domain.enums.AvailableNumberType;
import com.zang.api.domain.list.AvailablePhoneNumbersList;
import com.zang.api.domain.list.IncomingPhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListAvailableNumbersParams;
import org.junit.Test;

public class PhoneNumbersIT extends BaseIntegrationTest {


    public PhoneNumbersIT() throws ZangException {
    }

    @Test
    public void incomingPhoneNumbers() throws ZangException {
        IncomingPhoneNumbersConnector conn = connectorFactory.getIncomingPhoneNumbersConnector();
        IncomingPhoneNumbersList list = conn.listIncomingNumbers(null, null, 0, 25);
        if (list.getTotal() > 0) {
            conn.viewIncomingNumber(list.iterator().next().getSid());
        }
    }

    @Test
    public void availablePhoneNumbers() throws ZangException {
        AvailablePhoneNumbersConnector conn = connectorFactory.getAvailablePhoneNumbersConnector();
        AvailablePhoneNumbersList list = conn.listAvailableNumbers(ListAvailableNumbersParams.builder()
                .setCountry("HR")
                .setType(AvailableNumberType.LOCAL)
                .build());
        System.out.println(list.getTotal());
    }

}
