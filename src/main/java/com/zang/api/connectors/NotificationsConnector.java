package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Notification;
import com.zang.api.domain.enums.LogLevel;
import com.zang.api.domain.list.NotificationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.NotificationsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Notifications endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class NotificationsConnector extends BaseConnector {

    private NotificationsProxy proxy;

    NotificationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(NotificationsProxy.class);
    }


    /**
     * Shows information about a notification.
     * @param accountSid Account SID
     * @param notificationSid Notification SID
     * @return The requested Notification
     * @throws ZangException
     */
    public Notification viewNotification(String accountSid, String notificationSid) throws ZangException {
        return returnThrows(proxy.viewNotification(accountSid, notificationSid), Notification.class);
    }

    /**
     * Shows information about a notification.
     * @param notificationSid Notification SID
     * @return The requested Notification
     * @throws ZangException
     */
    public Notification viewNotification(String notificationSid) throws ZangException {
        return viewNotification(conf.getSid(), notificationSid);
    }

    /**
     * Lists notifications associated with an account.
     * @param accountSid Account SID
     * @param log Specifies that only notifications with the given log level value should be listed.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Notifications.
     * @throws ZangException
     */
    public NotificationsList listNotifications(String accountSid, LogLevel log, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listNotifications(accountSid, log, page, pageSize), NotificationsList.class);
    }

    /**
     * Lists notifications associated with your account.
     * @param log Specifies that only notifications with the given log level value should be listed.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Notifications.
     * @throws ZangException
     */
    public NotificationsList listNotifications(LogLevel log, Integer page, Integer pageSize) throws ZangException {
        return listNotifications(conf.getSid(), log, page, pageSize);
    }

    /**
     * Lists up to 50 notifications associated with your account.
     * @return A list of Notifications.
     * @throws ZangException
     */
    public NotificationsList listNotifications() throws ZangException {
        return listNotifications(conf.getSid(), null, null, null);
    }


}
