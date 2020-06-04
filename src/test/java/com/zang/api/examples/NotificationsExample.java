package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.NotificationsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Notification;
import com.zang.api.domain.enums.LogLevel;
import com.zang.api.domain.list.NotificationsList;
import com.zang.api.exceptions.ZangException;


public class NotificationsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        NotificationsConnector connector = ZangConnectorFactory.getNotificationsConnector(conf);

        //view notification
        try {
            Notification notification = connector.viewNotification("TestNotificationSid");
            System.out.println(notification.getMessageText());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list notifications
        try {
            NotificationsList list = connector.listNotifications(LogLevel.INFO, 0, 33);
            for (Notification notification : list) {
                System.out.println(notification.getMessageText());
            }
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }


}
