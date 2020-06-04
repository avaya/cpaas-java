package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ApplicationClientsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.list.ApplicationClientsList;
import com.zang.api.exceptions.ZangException;

public class ApplicationClientsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ApplicationClientsConnector conn = ZangConnectorFactory.getApplicationClientsConnector(conf);


        // view application client
        try {
            ApplicationClient applicationClient = conn.viewApplicationClient("TestApplicationSid",
                    "TestApplicationClientSid");
        } catch (ZangException e) {
            e.printStackTrace();
        }


        // list application clients
        try {
            ApplicationClientsList applicationClients = conn.listApplicationClients("TestAccountSid",
                    "TestApplicationSid", 0, 10);
        } catch (ZangException e) {
            e.printStackTrace();
        }

        // create application client
        try {
            ApplicationClient applicationClient = conn.createApplicationClient("TestApplicationSid",
                    "MyApplicationClient");
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
