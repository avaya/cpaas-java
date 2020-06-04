package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface UsagesProxy {
    @GET
    @Path("Accounts/{AccountSid}/Usages/{UsageSid}.json")
    @Produces("application/json")
    Response getUsage(
            @PathParam("AccountSid") String accountSid,
            @PathParam("UsageSid") String usageSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Usages.json")
    @Produces("application/json")
    Response listUsages(
            @PathParam("AccountSid") String accountSid,
            @QueryParam(value = "Day") Integer day,
            @QueryParam(value = "Month") Integer month,
            @QueryParam(value = "Year") Integer year,
            @QueryParam(value = "Product") Integer product,
            @QueryParam(value = "Page") Integer page,
            @QueryParam(value = "PageSize") Integer pageSize
    );


}
