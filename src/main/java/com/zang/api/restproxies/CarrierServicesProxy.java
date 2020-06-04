package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public interface CarrierServicesProxy {
    @POST
    @Path("Accounts/{AccountSid}/Lookups/Carrier.json")
    @Produces("application/json")
    Response carrierLookup(
            @PathParam("AccountSid") String accountSid,
            @FormParam("PhoneNumber") List<String> phoneNumbers
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Carrier.json")
    @Produces("application/json")
    Response listCarrierLookups(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Lookups/Cnam.json")
    @Produces("application/json")
    Response cnamLookup(
            @PathParam("AccountSid") String accountSid,
            @FormParam("PhoneNumber") List<String> phoneNumbers
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Cnam.json")
    @Produces("application/json")
    Response listCnamLookups(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Lookups/Bna.json")
    @Produces("application/json")
    Response bnaLookup(
            @PathParam("AccountSid") String accountSid,
            @FormParam("PhoneNumber") List<String> phoneNumbers
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Bna.json")
    @Produces("application/json")
    Response listBnaLookups(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );
}
