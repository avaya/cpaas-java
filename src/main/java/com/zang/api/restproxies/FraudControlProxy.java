package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface FraudControlProxy {
    @POST
    @Path("Accounts/{AccountSid}/Fraud/Block/{CountryCode}.json")
    @Produces("application/json")
    Response blockDestination(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CountryCode") String countryCode,
            @FormParam("MobileEnabled") Boolean mobileEnabled,
            @FormParam("LandlineEnabled") Boolean landlineEnabled,
            @FormParam("SmsEnabled") Boolean smsEnabled
    );

    @POST
    @Path("Accounts/{AccountSid}/Fraud/Authorize/{CountryCode}.json")
    @Produces("application/json")
    Response authorizeDestination(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CountryCode") String countryCode,
            @FormParam("MobileEnabled") Boolean mobileEnabled,
            @FormParam("LandlineEnabled") Boolean landlineEnabled,
            @FormParam("SmsEnabled") Boolean smsEnabled
    );

    @POST
    @Path("Accounts/{AccountSid}/Fraud/Extend/{CountryCode}.json")
    @Produces("application/json")
    Response extendDestinationAuthorization(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CountryCode") String countryCode
    );

    @POST
    @Path("Accounts/{AccountSid}/Fraud/Whitelist/{CountryCode}.json")
    @Produces("application/json")
    Response whitelistDestination(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CountryCode") String countryCode,
            @FormParam("MobileEnabled") Boolean mobileEnabled,
            @FormParam("LandlineEnabled") Boolean landlineEnabled,
            @FormParam("SmsEnabled") Boolean smsEnabled
    );

    @GET
    @Path("Accounts/{AccountSid}/Fraud.json")
    @Produces("application/json")
    Response listFraudControlResources(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

}
