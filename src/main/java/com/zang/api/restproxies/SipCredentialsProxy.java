package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface SipCredentialsProxy {
    @GET
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}.json")
    @Produces("application/json")
    Response viewCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/CredentialLists.json")
    @Produces("application/json")
    Response listCredentialsLists(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/CredentialLists.json")
    @Produces("application/json")
    Response createCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @FormParam("FriendlyName") String friendlyName
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}.json")
    @Produces("application/json")
    Response updateCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @FormParam("FriendlyName") String friendlyName
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}.json")
    @Produces("application/json")
    Response deleteCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}/Credentials/{CredentialSid}.json")
    @Produces("application/json")
    Response viewCredential(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @PathParam("CredentialSid") String credentialSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}/Credentials.json")
    @Produces("application/json")
    Response listCredentials(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}/Credentials.json")
    @Produces("application/json")
    Response createCredential(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @FormParam("Username") String username,
            @FormParam("Password") String password
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}/Credentials/{CredentialSid}.json")
    @Produces("application/json")
    Response updateCredential(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @PathParam("CredentialSid") String credentialSid,
            @FormParam("Password") String password
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/CredentialLists/{CredentialsListSid}/Credentials/{CredentialSid}.json")
    @Produces("application/json")
    Response deleteCredential(
            @PathParam("AccountSid") String accountSid,
            @PathParam("CredentialsListSid") String credentialsListSid,
            @PathParam("CredentialSid") String credentialSid
    );


}

