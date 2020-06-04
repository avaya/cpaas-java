package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface AccountsProxy {
    @GET
    @Path("Accounts/{AccountSid}.json")
    @Produces("application/json")
    Response getAccount(@PathParam("AccountSid") String accountSid);


    @POST
    @Path("Accounts/{AccountSid}.json")
    @Produces("application/json")
    Response updateAccount(
            @PathParam("AccountSid") String accountSid,
            @FormParam("FriendlyName") String friendlyName);

}
