package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import com.zang.api.restproxies.SipDomainsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Sip Domains endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SipDomainsConnector extends BaseConnector {

    private SipDomainsProxy proxy;

    SipDomainsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SipDomainsProxy.class);
    }

    /**
     * Get information on your SIP domain
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @return Info on the requested Domain.
     * @throws ZangException
     */
    public Domain viewDomain(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.viewDomain(accountSid, domainSid), Domain.class);
    }

    /**
     * Get information on your SIP domain
     * @param domainSid Domain SID
     * @return Info on the requested Domain.
     * @throws ZangException
     */
    public Domain viewDomain(String domainSid) throws ZangException {
        return viewDomain(conf.getSid(), domainSid);
    }

    /**
     * List your SIP domains.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of SIP Domains
     * @throws ZangException
     */
    public DomainsList listDomains(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listDomains(accountSid, page, pageSize), DomainsList.class);
    }

    /**
     * List your SIP domains.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of SIP Domains
     * @throws ZangException
     */
    public DomainsList listDomains(Integer page, Integer pageSize) throws ZangException {
        return listDomains(conf.getSid(), page, pageSize);
    }

    /**
     * Create a new SIP domain.
     * @param accountSid Account SID
     * @param domainName An address on Zang uniquely associated with your account and through which all your SIP
     *                   traffic is routed.
     * @param friendlyName A human-readable name associated with this domain.
     * @param voiceUrl The URL requested when a call is received by your domain.
     * @param voiceMethod The HTTP method used when requesting the VoiceUrl.
     * @param voiceFallbackUrl The URL requested if the VoiceUrl fails.
     * @param voiceFallbackMethod The HTTP method used when requesting the VoiceFallbackUrl.
     * @param heartbeatUrl URL that can be requested every 60 seconds during the call to notify of elapsed time and
     *                     pass other general information.
     * @param heartbeatMethod 	Specifies the HTTP method used to request HeartbeatUrl.
     * @param voiceStatusCallback The URL that Zang will use to send you status notifications regarding your SIP call.
     * @param voiceStatusCallbackMethod The HTTP method used when requesting the VoiceStatusCallback.
     * @return Created SIP domain.
     * @throws ZangException
     */
    public Domain createDomain(String accountSid, String domainName, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusCallbackMethod) throws ZangException {
        return returnThrows(proxy.createDomain(accountSid, domainName, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusCallbackMethod), Domain.class);
    }

    /**
     * Create a new SIP domain.
     * @param domainName An address on Zang uniquely associated with your account and through which all your SIP
     *                   traffic is routed.
     * @param friendlyName A human-readable name associated with this domain.
     * @param voiceUrl The URL requested when a call is received by your domain.
     * @param voiceMethod The HTTP method used when requesting the VoiceUrl.
     * @param voiceFallbackUrl The URL requested if the VoiceUrl fails.
     * @param voiceFallbackMethod The HTTP method used when requesting the VoiceFallbackUrl.
     * @param heartbeatUrl URL that can be requested every 60 seconds during the call to notify of elapsed time and
     *                     pass other general information.
     * @param heartbeatMethod 	Specifies the HTTP method used to request HeartbeatUrl.
     * @param voiceStatusCallback The URL that Zang will use to send you status notifications regarding your SIP call.
     * @param voiceStatusCallbackMethod The HTTP method used when requesting the VoiceStatusCallback.
     * @return Created SIP domain.
     * @throws ZangException
     */
    public Domain createDomain(String domainName, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusCallbackMethod) throws ZangException {
        return createDomain(conf.getSid(), friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusCallbackMethod);
    }

    /**
     * Creates a new SIP domain
     * @param params Parameters with which to create a new SIP domain
     * @return Created SIP domain.
     * @throws ZangException
     * @see com.zang.api.params.DomainParamsBuilder
     * @see DomainParams
     */
    public Domain createDomain(DomainParams params) throws ZangException {
        return createDomain(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getDomainName(), params.getFriendlyName(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getVoiceStatusCallback(), params.getVoiceStatusCallbackMethod());
    }

    /**
     * Updates a SIP Domain.
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param friendlyName A human-readable name associated with this domain.
     * @param voiceUrl The URL requested when a call is received by your domain.
     * @param voiceMethod The HTTP method used when requesting the VoiceUrl.
     * @param voiceFallbackUrl The URL requested if the VoiceUrl fails.
     * @param voiceFallbackMethod The HTTP method used when requesting the VoiceFallbackUrl.
     * @param heartbeatUrl URL that can be requested every 60 seconds during the call to notify of elapsed time and
     *                     pass other general information.
     * @param heartbeatMethod 	Specifies the HTTP method used to request HeartbeatUrl.
     * @param voiceStatusCallback The URL that Zang will use to send you status notifications regarding your SIP call.
     * @param voiceStatusCallbackMethod The HTTP method used when requesting the VoiceStatusCallback.
     * @return The updated Domain.
     * @throws ZangException
     */
    public Domain updateDomain(String accountSid, String domainSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusCallbackMethod) throws ZangException {
        return returnThrows(proxy.updateDomain(accountSid, domainSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusCallbackMethod), Domain.class);
    }

    /**
     * Updates a SIP Domain.
     * @param domainSid Domain SID
     * @param friendlyName A human-readable name associated with this domain.
     * @param voiceUrl The URL requested when a call is received by your domain.
     * @param voiceMethod The HTTP method used when requesting the VoiceUrl.
     * @param voiceFallbackUrl The URL requested if the VoiceUrl fails.
     * @param voiceFallbackMethod The HTTP method used when requesting the VoiceFallbackUrl.
     * @param heartbeatUrl URL that can be requested every 60 seconds during the call to notify of elapsed time and
     *                     pass other general information.
     * @param heartbeatMethod 	Specifies the HTTP method used to request HeartbeatUrl.
     * @param voiceStatusCallback The URL that Zang will use to send you status notifications regarding your SIP call.
     * @param voiceStatusCallbackMethod The HTTP method used when requesting the VoiceStatusCallback.
     * @return The updated Domain.
     * @throws ZangException
     */
    public Domain updateDomain(String domainSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusCallbackMethod) throws ZangException {
        return updateDomain(conf.getSid(), domainSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusCallbackMethod);
    }

    /**
     * Updates a SIP domain.
     * @param params Parameters with which to update a SIP domain. DomainSID must be set.
     * @return Updated SIP domain.
     * @throws ZangException
     * @see com.zang.api.params.DomainParamsBuilder
     * @see DomainParams
     */
    public Domain updateDomain(DomainParams params) throws ZangException {
        return updateDomain(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getDomainSid(), params.getFriendlyName(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getVoiceStatusCallback(), params.getVoiceStatusCallbackMethod());
    }

    /**
     * Deletes a SIP domain.
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @return The deleted SIP Domain
     * @throws ZangException
     */
    public Domain deleteDomain(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.deleteDomain(accountSid, domainSid), Domain.class);
    }

    /**
     * Deletes a SIP domain.
     * @param domainSid Domain SID
     * @return The deleted SIP Domain
     * @throws ZangException
     */
    public Domain deleteDomain(String domainSid) throws ZangException {
        return deleteDomain(conf.getSid(), domainSid);
    }


    /**
     * Shows info on credential lists attached to a SIP domain
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credential Lists
     * @throws ZangException
     */
    public CredentialsListsList listMappedCredentialsLists(String accountSid, String domainSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listMappedCredentialsLists(accountSid, domainSid, page, pageSize), CredentialsListsList.class);
    }

    /**
     * Shows info on credential lists attached to a SIP domain
     * @param domainSid Domain SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credential Lists
     * @throws ZangException
     */
    public CredentialsListsList listMappedCredentialsLists(String domainSid, Integer page, Integer pageSize) throws ZangException {
        return listMappedCredentialsLists(conf.getSid(), domainSid, page, pageSize);
    }


    /**
     * Maps a Credentials List to a SIP Domain
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param credentialsListSid Credentials List SID
     * @return The mapped Credentials List
     * @throws ZangException
     */
    public CredentialsList mapCredentialsList(String accountSid, String domainSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.mapCredentialsList(accountSid, domainSid, credentialsListSid), CredentialsList.class);
    }

    /**
     * Maps a Credentials List to a SIP Domain
     * @param domainSid Domain SID
     * @param credentialsListSid Credentials List SID
     * @return The mapped Credentials List
     * @throws ZangException
     */
    public CredentialsList mapCredentialsList(String domainSid, String credentialsListSid) throws ZangException {
        return mapCredentialsList(conf.getSid(), domainSid, credentialsListSid);
    }

    /**
     * Deletes a Credentials List mapping.
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param credentialsListSid Credentials List SID
     * @return The unmapped Credentials List
     * @throws ZangException
     */
    public CredentialsList deleteMappedCredentialsList(String accountSid, String domainSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.deleteMappedCredentialsList(accountSid, domainSid, credentialsListSid), CredentialsList.class);
    }

    /**
     * Deletes a Credentials List mapping.
     * @param domainSid Domain SID
     * @param credentialsListSid Credentials List SID
     * @return The unmapped Credentials List
     * @throws ZangException
     */
    public CredentialsList deleteMappedCredentialsList(String domainSid, String credentialsListSid) throws ZangException {
        return deleteMappedCredentialsList(conf.getSid(), domainSid, credentialsListSid);
    }

    /**
     * Shows info on IP access control lists attached to a SIP domain.
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Access Control Lists.
     * @throws ZangException
     */
    public AccessControlListsList listMappedIpAccessControlLists(String accountSid, String domainSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listMappedIpAccessControlLists(accountSid, domainSid, page, pageSize), AccessControlListsList.class);
    }

    /**
     * Shows info on IP access control lists attached to a SIP domain.
     * @param domainSid Domain SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Access Control Lists.
     * @throws ZangException
     */
    public AccessControlListsList listMappedIpAccessControlLists(String domainSid, Integer page, Integer pageSize) throws ZangException {
        return listMappedIpAccessControlLists(conf.getSid(), domainSid, page, pageSize);
    }

    /**
     * Maps an IP access control list to a SIP domain.
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param ipAccessControlListSid The Sid of the IP ACL that you wish to associate with this domain.
     * @return The mapped IP ACL
     * @throws ZangException
     */
    public AccessControlList mapIpAccessControlList(String accountSid, String domainSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(proxy.mapIpAccessControlList(accountSid, domainSid, ipAccessControlListSid), AccessControlList.class);
    }

    /**
     * Maps an IP access control list to a SIP domain.
     * @param domainSid Domain SID
     * @param ipAccessControlListSid The Sid of the IP ACL that you wish to associate with this domain.
     * @return The mapped IP ACL
     * @throws ZangException
     */
    public AccessControlList mapIpAccessControlList(String domainSid, String ipAccessControlListSid) throws ZangException {
        return mapIpAccessControlList(conf.getSid(), domainSid, ipAccessControlListSid);
    }

    /**
     * Detaches an IP access control list from a SIP domain
     * @param accountSid Account SID
     * @param domainSid Domain SID
     * @param accessControlListSid Access Control List SID
     * @return The detached IP ACL
     * @throws ZangException
     */
    public AccessControlList deleteMappedIpAccessControlList(String accountSid, String domainSid, String accessControlListSid) throws ZangException {
        return returnThrows(proxy.deleteMappedIpAccessControlList(accountSid, domainSid, accessControlListSid), AccessControlList.class);
    }

    /**
     * Detaches an IP access control list from a SIP domain
     * @param domainSid Domain SID
     * @param accessControlListSid Access Control List SID
     * @return The detached IP ACL
     * @throws ZangException
     */
    public AccessControlList deleteMappedIpAccessControlList(String domainSid, String accessControlListSid) throws ZangException {
        return deleteMappedIpAccessControlList(conf.getSid(), domainSid, accessControlListSid);
    }
}
