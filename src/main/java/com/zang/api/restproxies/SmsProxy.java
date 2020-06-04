package com.zang.api.restproxies;

import com.zang.api.domain.enums.HttpMethod;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface SmsProxy {
    @GET
    @Path("Accounts/{AccountSid}/SMS/Messages/{SMSMessageSid}.json")
    @Produces("application/json")
    Response getSmsMessage(@PathParam("AccountSid") String accountSid,
                           @PathParam("SMSMessageSid") String smsMessageSid);

    @GET
    @Path("Accounts/{AccountSid}/SMS/Messages.json")
    @Produces("application/json")
    Response getSmsMessageList(
            @PathParam("AccountSid") String accountSid,
            @QueryParam(value = "To") String to,
            @QueryParam(value = "From") String from,
            @QueryParam(value = "DateSent>") String dateSentGte,
            @QueryParam(value = "DateSent<") String dateSentLt,
            @QueryParam(value = "Page") Integer page,
            @QueryParam(value = "PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SMS/Messages.json")
    @Produces("application/json")
    Response sendSmsMessage(
            @PathParam("AccountSid") String accountSid,
            @FormParam(value = "To") String to,
            @FormParam(value = "From") String from,
            @FormParam(value = "Body") String body,
            @FormParam(value = "StatusCallback") String statusCallback,
            @FormParam(value = "StatusCallbackMethod") HttpMethod statusCallbackMethod,
            @FormParam(value = "AllowMultiple") Boolean allowMultiple
    );

}

