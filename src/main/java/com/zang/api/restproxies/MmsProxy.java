package com.zang.api.restproxies;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface MmsProxy {

    @POST
    @Path("Accounts/{AccountSid}/MMS/Messages.json")
    @Produces("application/json")
    Response sendMmsMessage(
            @PathParam("AccountSid") String accountSid,
            @FormParam(value = "To") String to,
            @FormParam(value = "From") String from,
            @FormParam(value = "Body") String body,
            @FormParam(value = "StatusCallback") String statusCallback,
            @FormParam(value = "MediaUrl") URI mediaUrl
    );

}

