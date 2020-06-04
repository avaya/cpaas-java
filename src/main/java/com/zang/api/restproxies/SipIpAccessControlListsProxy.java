package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface SipIpAccessControlListsProxy {
    @GET
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}.json")
    @Produces("application/json")
    Response viewIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists.json")
    @Produces("application/json")
    Response listIpAccessControlLists(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists.json")
    @Produces("application/json")
    Response createIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @FormParam("FriendlyName") String friendlyName
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}.json")
    @Produces("application/json")
    Response updateIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @FormParam("FriendlyName") String friendlyName
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}.json")
    @Produces("application/json")
    Response deleteIpAccessControlList(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses/{IpSid}.json")
    @Produces("application/json")
    Response viewAccessControlListIp(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @PathParam("IpSid") String ipSid
    );

    @GET
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses.json")
    @Produces("application/json")
    Response listAccessControlListIps(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses.json")
    @Produces("application/json")
    Response addAccessControlListIp(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("IpAddress") String ipAddress
    );

    @POST
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses/{IpSid}.json")
    @Produces("application/json")
    Response updateAccessControlListIp(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @PathParam("IpSid") String ipSid,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("IpAddress") String ipAddress
    );

    @DELETE
    @Path("Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses/{IpSid}.json")
    @Produces("application/json")
    Response deleteAccessControlListIp(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IpAccessControlListSid") String ipAccessControlListSid,
            @PathParam("IpSid") String ipSid
    );


}

