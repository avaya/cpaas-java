package com.zang.api.restproxies;

import com.zang.api.domain.enums.HttpMethod;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface SipDomainsProxy {
    @GET
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}.json")
    @Produces("application/json")
    Response viewDomain(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/Domains.json")
    @Produces("application/json")
    Response listDomains(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/Domains.json")
    @Produces("application/json")
    Response createDomain(
            @PathParam("AccountSid") String accountSid,
            @FormParam("DomainName") String domainName,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("VoiceUrl") String voiceUrl,
            @FormParam("VoiceMethod") HttpMethod voiceMethod,
            @FormParam("VoiceFallbackUrl") String voiceFallbackUrl,
            @FormParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
            @FormParam("HeartbeatUrl") String heartbeatUrl,
            @FormParam("HeartbeatMethod") HttpMethod heartbeatMethod,
            @FormParam("VoiceStatusCallback") String voiceStatusCallback,
            @FormParam("VoiceStatusCallbackMethod") HttpMethod voiceStatusCallbackMethod
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}.json")
    @Produces("application/json")
    Response updateDomain(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("VoiceUrl") String voiceUrl,
            @FormParam("VoiceMethod") HttpMethod voiceMethod,
            @FormParam("VoiceFallbackUrl") String voiceFallbackUrl,
            @FormParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
            @FormParam("HeartbeatUrl") String heartbeatUrl,
            @FormParam("HeartbeatMethod") HttpMethod heartbeatMethod,
            @FormParam("VoiceStatusCallback") String voiceStatusCallback,
            @FormParam("VoiceStatusCallbackMethod") HttpMethod voiceStatusCallbackMethod
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}.json")
    @Produces("application/json")
    Response deleteDomain(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/CredentialListMappings.json")
    @Produces("application/json")
    Response listMappedCredentialsLists(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/CredentialListMappings.json")
    @Produces("application/json")
    Response mapCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @FormParam("CredentialListSid") String credentialListSid
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/CredentialListMappings/{CredentialsListSid}.json")
    @Produces("application/json")
    Response deleteMappedCredentialsList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @PathParam("CredentialsListSid") String credentialsListSid
    );


    @GET
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/IpAccessControlListMappings.json")
    @Produces("application/json")
    Response listMappedIpAccessControlLists(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/IpAccessControlListMappings.json")
    @Produces("application/json")
    Response mapIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @FormParam("IpAccessControlListSid") String ipAccessControlListSid
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/Domains/{DomainSid}/IpAccessControlListMappings/{AccessControlListSid}.json")
    @Produces("application/json")
    Response deleteMappedIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("DomainSid") String domainSid,
            @PathParam("AccessControlListSid") String accessControlListSid
    );

}

