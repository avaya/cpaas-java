package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;

public class SmsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        SmsConnector conn = ZangConnectorFactory.getSmsConnector(conf);

        //send sms message
        try {
            SmsMessage sentSmsMessage = conn
                    .sendSmsMessage(
                            "(XXX) XXX-XXXX",
                            "(XXX) XXX-XXXX",
                            "This is an SMS message sent from the Zang Java wrapper! Easy as 1, 2, 3!",
                            null, null, null);


        } catch (ZangException e) {
            e.printStackTrace();
        }

        //view sms message
        try {
            SmsMessage message = conn.viewSmsMessage("SmsMessageSID");
            System.out.println(message.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list sms messages
        try {
            SmsMessageList smsMessageList = conn.listSmsMessages();
            for (SmsMessage smsMessage : smsMessageList) {
                System.out.println(smsMessage.getSid());
            }
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }
}
