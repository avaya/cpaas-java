package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.AvailablePhoneNumbersConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.enums.AvailableNumberType;
import com.zang.api.domain.list.AvailablePhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListAvailableNumbersParams;


public class AvailablePhoneNumbersExample  {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        AvailablePhoneNumbersConnector connector = new ZangConnectorFactory(conf).getAvailablePhoneNumbersConnector();


        //list available numbers
        try {
            AvailablePhoneNumbersList numbers = connector.listAvailableNumbers(ListAvailableNumbersParams.builder()
                    .setCountry("HR")
                    .setType(AvailableNumberType.TOLLFREE)
                    .setContains("123")
                    .setAreaCode("052")
                    .setInRegion("Istria")
                    .setInPostalCode("52210")
                    .setPage(0)
                    .setPageSize(20)
                    .build());
            System.out.println(numbers.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }

}

