package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface ApplicationClientsProxy {
    @GET
    @Path("Accounts/{AccountSid}/Applications/{ApplicationSid}.json")
    @Produces("application/json")
    Response viewApplicationClient(@PathParam("AccountSid") String accountSid,
            @PathParam("ApplicationSid") String applicationSid,
            @PathParam("ClientSid") String clientSid);

    @GET
    @Path("Accounts/{AccountSid}/Applications.json")
    @Produces("application/json")
    Response listApplicationClients(@PathParam("AccountSid") String accountSid,
            @PathParam("ApplicationSid") String applicationSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize);

    @POST
    @Path("Accounts/{AccountSid}/Applications.json")
    @Produces("application/json")
    Response createApplicationClient(@PathParam("AccountSid") String accountSid,
            @PathParam("ApplicationSid") String applicationSid,
            @FormParam("Nickname") String nickname);
}

