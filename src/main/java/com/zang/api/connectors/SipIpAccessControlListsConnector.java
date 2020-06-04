package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.IpAddress;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.IpAddressesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.SipIpAccessControlListsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Sip IP Access Control Lists endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SipIpAccessControlListsConnector extends BaseConnector {

    private SipIpAccessControlListsProxy proxy;

    SipIpAccessControlListsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SipIpAccessControlListsProxy.class);
    }


    /**
     * View information for an IP access control list.
     * @param accountSid Account SID
     * @param ipAccessControlListSid IP ACL SID
     * @return The requested Access Control List
     * @throws ZangException
     */
    public AccessControlList viewIpAccessControlList(String accountSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(proxy.viewIpAccessControlList(accountSid, ipAccessControlListSid), AccessControlList.class);
    }

    /**
     * View information for an IP access control list.
     * @param ipAccessControlListSid IP ACL SID
     * @return The requested Access Control List
     * @throws ZangException
     */
    public AccessControlList viewIpAccessControlList(String ipAccessControlListSid) throws ZangException {
        return viewIpAccessControlList(conf.getSid(), ipAccessControlListSid);
    }

    /**
     * Lists IP Access Control Lists associated with an account.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of IP Access Control Lists
     * @throws ZangException
     */
    public AccessControlListsList listIpAccessControlLists(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listIpAccessControlLists(accountSid, page, pageSize), AccessControlListsList.class);
    }

    /**
     * Lists IP Access Control Lists associated with your account.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of IP Access Control Lists
     * @throws ZangException
     */
    public AccessControlListsList listIpAccessControlLists(Integer page, Integer pageSize) throws ZangException {
        return listIpAccessControlLists(conf.getSid(), page, pageSize);
    }

    /**
     * Creates an IP Access Control List
     * @param accountSid Account SID
     * @param friendlyName A human-readable name associated with this IP ACL.
     * @return The created Access Control List
     * @throws ZangException
     */
    public AccessControlList createIpAccessControlList(String accountSid,  String friendlyName) throws ZangException {
        return returnThrows(proxy.createIpAccessControlList(accountSid, friendlyName), AccessControlList.class);
    }

    /**
     * Creates an IP Access Control List
     * @param friendlyName A human-readable name associated with this IP ACL.
     * @return The created Access Control List
     * @throws ZangException
     */
    public AccessControlList createIpAccessControlList(String friendlyName) throws ZangException {
        return createIpAccessControlList(conf.getSid(), friendlyName);
    }

    /**
     * Updates information for an IP access control list.
     * @param accountSid Account SID
     * @param ipAccessControlListSid Access Control List SID
     * @param friendlyName A human-readable name associated with this IP ACL.
     * @return The updated Access Control List
     * @throws ZangException
     */
    public AccessControlList updateIpAccessControlList(String accountSid, String ipAccessControlListSid,  String friendlyName) throws ZangException {
        return returnThrows(proxy.updateIpAccessControlList(accountSid, ipAccessControlListSid, friendlyName), AccessControlList.class);
    }

    /**
     * Updates information for an IP access control list.
     * @param ipAccessControlListSid Access Control List SID
     * @param friendlyName A human-readable name associated with this IP ACL.
     * @return The updated Access Control List
     * @throws ZangException
     */
    public AccessControlList updateIpAccessControlList(String ipAccessControlListSid,  String friendlyName) throws ZangException {
        return updateIpAccessControlList(conf.getSid(), ipAccessControlListSid, friendlyName);
    }

    /**
     * Deletes an IP Access Control List
     * @param accountSid Account SID
     * @param ipAccessControlListSid Access Control List SID
     * @return The deleted Access Control List
     * @throws ZangException
     */
    public AccessControlList deleteIpAccessControlList(String accountSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(proxy.deleteIpAccessControlList(accountSid, ipAccessControlListSid), AccessControlList.class);
    }

    /**
     * Deletes an IP Access Control List
     * @param ipAccessControlListSid Access Control List SID
     * @return The deleted Access Control List
     * @throws ZangException
     */
    public AccessControlList deleteIpAccessControlList(String ipAccessControlListSid) throws ZangException {
        return deleteIpAccessControlList(conf.getSid(), ipAccessControlListSid);
    }


    /**
     * View information on an IP access control list IP address.
     * @param accountSid Account SID
     * @param ipAccessControlListSid Access Control List SID
     * @param ipSid IP Address SID
     * @return Information about the requested IP Address
     * @throws ZangException
     */
    public IpAddress viewAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid) throws ZangException {
        return returnThrows(proxy.viewAccessControlListIp(accountSid, ipAccessControlListSid, ipSid), IpAddress.class);
    }

    /**
     * View information on an IP access control list IP address.
     * @param ipAccessControlListSid Access Control List SID
     * @param ipSid IP Address SID
     * @return Information about the requested IP Address
     * @throws ZangException
     */
    public IpAddress viewAccessControlListIp(String ipAccessControlListSid, String ipSid) throws ZangException {
        return viewAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid);
    }

    /**
     * Lists IP addresses attached to an IP access control list.
     * @param accountSid Account SID
     * @param ipAccessControlListSid Access Control List SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of IP Addresses
     * @throws ZangException
     */
    public IpAddressesList listAccessControlListIps(String accountSid, String ipAccessControlListSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listAccessControlListIps(accountSid, ipAccessControlListSid, page, pageSize), IpAddressesList.class);
    }

    /**
     * Lists IP addresses attached to an IP access control list.
     * @param ipAccessControlListSid Access Control List SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of IP Addresses
     * @throws ZangException
     */
    public IpAddressesList listAccessControlListIps(String ipAccessControlListSid, Integer page, Integer pageSize) throws ZangException {
        return listAccessControlListIps(conf.getSid(), ipAccessControlListSid, page, pageSize);
    }


    /**
     * Adds a new IP to an access control list.
     * @param accountSid Account SID
     * @param ipAccessControlListSid Access Control List SID
     * @param friendlyName A human-readable name associated with this IP Address.
     * @param ipAddress An IP address from which you wish to accept traffic. At this time, only IPv4 supported.
     * @return The associated IP Address.
     * @throws ZangException
     */
    public IpAddress addAccessControlListIp(String accountSid, String ipAccessControlListSid,  String friendlyName,  String ipAddress) throws ZangException {
        return returnThrows(proxy.addAccessControlListIp(accountSid, ipAccessControlListSid, friendlyName, ipAddress), IpAddress.class);
    }

    /**
     * Adds a new IP to an access control list.
     * @param ipAccessControlListSid Access Control List SID
     * @param friendlyName A human-readable name associated with this IP Address.
     * @param ipAddress An IP address from which you wish to accept traffic. At this time, only IPv4 supported.
     * @return The associated IP Address.
     * @throws ZangException
     */
    public IpAddress addAccessControlListIp(String ipAccessControlListSid,  String friendlyName,  String ipAddress) throws ZangException {
        return addAccessControlListIp(conf.getSid(), ipAccessControlListSid, friendlyName, ipAddress);
    }

    /**
     * Updates IP Address for an IP Access Control List
     * @param accountSid Account SID
     * @param ipAccessControlListSid IP Access Control List SID
     * @param ipSid IP Address SID
     * @param friendlyName A human-readable name associated with this IP Address.
     * @param ipAddress An IP address from which you wish to accept traffic. At this time, only IPv4 supported.
     * @return The updated IP Address.
     * @throws ZangException
     */
    public IpAddress updateAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid,  String friendlyName,  String ipAddress) throws ZangException {
        return returnThrows(proxy.updateAccessControlListIp(accountSid, ipAccessControlListSid, ipSid, friendlyName, ipAddress), IpAddress.class);
    }

    /**
     * Updates IP Address for an IP Access Control List
     * @param ipAccessControlListSid IP Access Control List SID
     * @param ipSid IP Address SID
     * @param friendlyName A human-readable name associated with this IP Address.
     * @param ipAddress An IP address from which you wish to accept traffic. At this time, only IPv4 supported.
     * @return The updated IP Address.
     * @throws ZangException
     */
    public IpAddress updateAccessControlListIp(String ipAccessControlListSid, String ipSid,  String friendlyName,  String ipAddress) throws ZangException {
        return updateAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid, friendlyName, ipAddress);
    }

    /**
     * Removes an IP address from an Access Control List.
     * @param accountSid Account SID
     * @param ipAccessControlListSid IP Access Control List SID
     * @param ipSid IP Address SID
     * @return The removed IP Address
     * @throws ZangException
     */
    public IpAddress deleteAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid) throws ZangException {
        return returnThrows(proxy.deleteAccessControlListIp(accountSid, ipAccessControlListSid, ipSid), IpAddress.class);
    }

    /**
     * Removes an IP address from an Access Control List.
     * @param ipAccessControlListSid IP Access Control List SID
     * @param ipSid IP Address SID
     * @return The removed IP Address
     * @throws ZangException
     */
    public IpAddress deleteAccessControlListIp(String ipAccessControlListSid, String ipSid) throws ZangException {
        return deleteAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid);
    }
}
