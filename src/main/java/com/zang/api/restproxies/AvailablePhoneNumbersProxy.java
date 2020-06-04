package com.zang.api.restproxies;

import com.zang.api.domain.enums.AvailableNumberType;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface AvailablePhoneNumbersProxy {
    @GET
    @Path("Accounts/{AccountSid}/AvailablePhoneNumbers/{Country}/{Type}.json")
    @Produces("application/json")
    Response listAvailableNumbers(
            @PathParam("AccountSid") String accountSid,
            @PathParam("Country") String country,
            @PathParam("Type") AvailableNumberType type,
            @QueryParam("Contains") String contains,
            @QueryParam("AreaCode") String areaCode,
            @QueryParam("InRegion") String inRegion,
            @QueryParam("InPostalCode") String inPostalCode,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

}

