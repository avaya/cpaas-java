package com.zang.api.unit;

import com.zang.api.connectors.AvailablePhoneNumbersConnector;
import com.zang.api.domain.AvailablePhoneNumber;
import com.zang.api.domain.enums.AvailableNumberType;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListAvailableNumbersParams;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class AvailablePhoneNumbersTest extends BaseUnitTest {

    private AvailablePhoneNumbersConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getAvailablePhoneNumbersConnector();
    }

    @Test
    public void listAvailablePhoneNumbers() throws ZangException, IOException {
        createExpectation("AvailablePhoneNumbersTest", "listAvailablePhoneNumbers");
        checkAvailablePhoneNumber(connector.listAvailableNumbers(ListAvailableNumbersParams.builder()
                .setCountry("HR")
                .setType(AvailableNumberType.TOLLFREE)
                .setContains("123")
                .setAreaCode("052")
                .setInRegion("Istria")
                .setInPostalCode("52210")
                .setPage(0)
                .setPageSize(20)
                .build()).iterator().next());
    }


    private void checkAvailablePhoneNumber(AvailablePhoneNumber availablePhoneNumber) {
        Assert.assertEquals("HR", availablePhoneNumber.getIsoCountry());

    }

}
