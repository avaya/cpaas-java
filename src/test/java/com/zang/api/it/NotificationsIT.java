package com.zang.api.it;

import com.zang.api.connectors.NotificationsConnector;
import com.zang.api.domain.list.NotificationsList;
import com.zang.api.exceptions.ZangException;
import org.junit.Test;

public class NotificationsIT extends BaseIntegrationTest {


    public NotificationsIT() throws ZangException {
    }

    @Test
    public void notifications() throws ZangException {
        NotificationsConnector conn = connectorFactory.getNotificationsConnector();
        NotificationsList list = conn.listNotifications();
        if (list.getTotal() > 0) {
            conn.viewNotification(list.iterator().next().getSid());
        }
    }

}
