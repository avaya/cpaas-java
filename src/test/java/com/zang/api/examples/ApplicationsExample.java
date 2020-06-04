package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ApplicationsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Application;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.ApplicationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ApplicationParams;

public class ApplicationsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ApplicationsConnector connector = ZangConnectorFactory.getApplicationsConnector(conf);

        //view application
        try {
            Application application = connector.viewApplication("TestApplicationSid");
            System.out.println(application.getClientCount());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list applications
        try {
            ApplicationsList applications = connector.listApplications("TestAccountSid", "TestApplication", 0, 10);
            System.out.println(applications.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //create application
        try {
            ApplicationParams applicationParams = ApplicationParams.builder()
                    .setAccountSid("TestAccountSid")
                    .setFriendlyName("TestApplication")
                    .setVoiceUrl("voiceUrl")
                    .setVoiceMethod(HttpMethod.POST)
                    .setVoiceFallbackUrl("voiceFallbackUrl")
                    .setVoiceFallbackMethod(HttpMethod.GET)
                    .setVoiceCallerIdLookup(true)
                    .setSmsUrl("smsUrl")
                    .setSmsMethod(HttpMethod.POST)
                    .setSmsFallbackUrl("smsFallbackUrl")
                    .setSmsFallbackMethod(HttpMethod.GET)
                    .setHeartbeatUrl("heartbeatUrl")
                    .setHeartbeatMethod(HttpMethod.GET)
                    .setStatusCallback("statusCallback")
                    .setStatusCallbackMethod(HttpMethod.POST)
                    .setHangupCallback("hangupCallback")
                    .setHangupCallbackMethod(HttpMethod.GET)
                    .build();
            Application application = connector.createApplication(applicationParams);
            System.out.println(application.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //update application
        try {
            Application application = connector.updateApplication("TestAccountSid", "TestApplicationSid",
                    "TestApplication", "voiceUrl", HttpMethod.POST, "voiceFallbackUrl", HttpMethod.GET, true, "smsUrl",
                    HttpMethod.POST, "smsFallbackUrl", HttpMethod.GET, "heartbeatUrl", HttpMethod.GET, "statusCallback",
                    HttpMethod.POST, "hangupCallback", HttpMethod.GET);
            System.out.println(application.getVoiceFallbackUrl());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete application
        try {
            Application application = connector.deleteApplication("TestApplicationSid");
            System.out.println(application.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
