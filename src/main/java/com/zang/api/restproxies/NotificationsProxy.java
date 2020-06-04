package com.zang.api.restproxies;

import com.zang.api.domain.enums.LogLevel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface NotificationsProxy {
    @GET
    @Path("Accounts/{AccountSid}/Notifications/{NotificationSid}.json")
    @Produces("application/json")
    Response viewNotification(
            @PathParam("AccountSid") String accountSid,
            @PathParam("NotificationSid") String notificationSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Notifications.json")
    @Produces("application/json")
    Response listNotifications(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Log") LogLevel log,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );
}

