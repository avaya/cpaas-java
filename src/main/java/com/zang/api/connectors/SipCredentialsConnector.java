package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.SipCredentialsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Sip Credentials endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SipCredentialsConnector extends BaseConnector {

    private SipCredentialsProxy proxy;

    SipCredentialsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SipCredentialsProxy.class);
    }


    /**
     * View info on a SIP domain credentials list.
     * @param accountSid Account SID
     * @param credentialsListSid Credentials list SID
     * @return The Credentials List
     * @throws ZangException
     */
    public CredentialsList viewCredentialsList(String accountSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.viewCredentialsList(accountSid, credentialsListSid), CredentialsList.class);
    }

    /**
     * View info on a SIP domain credentials list.
     * @param credentialsListSid Credentials list SID
     * @return The Credentials List
     * @throws ZangException
     */
    public CredentialsList viewCredentialsList(String credentialsListSid) throws ZangException {
        return viewCredentialsList(conf.getSid(), credentialsListSid);
    }


    /**
     * Show info on SIP domain credentials lists
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credentials Lists
     * @throws ZangException
     */
    public CredentialsListsList listCredentialsLists(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCredentialsLists(accountSid, page, pageSize), CredentialsListsList.class);
    }

    /**
     * Show info on SIP domain credentials lists
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credentials Lists
     * @throws ZangException
     */
    public CredentialsListsList listCredentialsLists(Integer page, Integer pageSize) throws ZangException {
        return listCredentialsLists(conf.getSid(), page, pageSize);
    }


    /**
     * Creates a SIP domain credentials list.
     * @param accountSid Account SID
     * @param friendlyName A human readable name for this credentials list.
     * @return The created Credentials List
     * @throws ZangException
     */
    public CredentialsList createCredentialsList(String accountSid, String friendlyName) throws ZangException {
        return returnThrows(proxy.createCredentialsList(accountSid, friendlyName), CredentialsList.class);
    }

    /**
     * Creates a SIP domain credentials list.
     * @param friendlyName A human readable name for this credentials list.
     * @return The created Credentials List
     * @throws ZangException
     */
    public CredentialsList createCredentialsList(String friendlyName) throws ZangException {
        return createCredentialsList(conf.getSid(), friendlyName);
    }


    /**
     * Updates information for a Credentials List.
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param friendlyName New friendly name for this list.
     * @return The updated Credentials List
     * @throws ZangException
     */
    public CredentialsList updateCredentialsList(String accountSid, String credentialsListSid, String friendlyName) throws ZangException {
        return returnThrows(proxy.updateCredentialsList(accountSid, credentialsListSid, friendlyName), CredentialsList.class);
    }

    /**
     * Updates information for a Credentials List.
     * @param credentialsListSid Credentials List SID
     * @param friendlyName New friendly name for this list.
     * @return The updated Credentials List
     * @throws ZangException
     */
    public CredentialsList updateCredentialsList(String credentialsListSid, String friendlyName) throws ZangException {
        return updateCredentialsList(conf.getSid(), credentialsListSid, friendlyName);
    }


    /**
     * Deletes a Credentials List
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @return The deleted Credentials List
     * @throws ZangException
     */
    public CredentialsList deleteCredentialsList(String accountSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.deleteCredentialsList(accountSid, credentialsListSid), CredentialsList.class);
    }

    /**
     * Deletes a Credentials List
     * @param credentialsListSid Credentials List SID
     * @return The deleted Credentials List
     * @throws ZangException
     */
    public CredentialsList deleteCredentialsList(String credentialsListSid) throws ZangException {
        return deleteCredentialsList(conf.getSid(), credentialsListSid);
    }


    /**
     * Gets information about a SIP domain credential
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @return Information about the requested Credential
     * @throws ZangException
     */
    public Credential viewCredential(String accountSid, String credentialsListSid, String credentialSid) throws ZangException {
        return returnThrows(proxy.viewCredential(accountSid, credentialsListSid, credentialSid), Credential.class);
    }

    /**
     * Gets information about a SIP domain credential
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @return Information about the requested Credential
     * @throws ZangException
     */
    public Credential viewCredential(String credentialsListSid, String credentialSid) throws ZangException {
        return viewCredential(conf.getSid(), credentialsListSid, credentialSid);
    }


    /**
     * Lists Credentials attached to a particular Credentials List
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credentials
     * @throws ZangException
     */
    public com.zang.api.domain.list.CredentialsList listCredentials(String accountSid, String credentialsListSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCredentials(accountSid, credentialsListSid, page, pageSize), com.zang.api.domain.list.CredentialsList.class);
    }

    /**
     * Lists Credentials attached to a particular Credentials List
     * @param credentialsListSid Credentials List SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Credentials
     * @throws ZangException
     */
    public com.zang.api.domain.list.CredentialsList listCredentials(String credentialsListSid, Integer page, Integer pageSize) throws ZangException {
        return listCredentials(conf.getSid(), credentialsListSid, page, pageSize);
    }


    /**
     * Creates SIP Domain credentials
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param username The username used to identify this credential.
     * @param password The password used to authenticate this credential.
     * @return The created credential.
     * @throws ZangException
     */
    public Credential createCredential(String accountSid, String credentialsListSid, String username, String password) throws ZangException {
        return returnThrows(proxy.createCredential(accountSid, credentialsListSid, username, password), Credential.class);
    }

    /**
     * Creates SIP Domain credentials
     * @param credentialsListSid Credentials List SID
     * @param username The username used to identify this credential.
     * @param password The password used to authenticate this credential.
     * @return The created credential.
     * @throws ZangException
     */
    public Credential createCredential(String credentialsListSid, String username, String password) throws ZangException {
        return createCredential(conf.getSid(), credentialsListSid, username, password);
    }


    /**
     * Updates SIP Domain Credentials
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @param password The password used to authenticate this credential.
     * @return The updated credential.
     * @throws ZangException
     */
    public Credential updateCredential(String accountSid, String credentialsListSid, String credentialSid, String password) throws ZangException {
        return returnThrows(proxy.updateCredential(accountSid, credentialsListSid, credentialSid, password), Credential.class);
    }

    /**
     * Updates SIP Domain Credentials
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @param password The password used to authenticate this credential.
     * @return The updated credential.
     * @throws ZangException
     */
    public Credential updateCredential(String credentialsListSid, String credentialSid, String password) throws ZangException {
        return updateCredential(conf.getSid(), credentialsListSid, credentialSid, password);
    }


    /**
     * Deletes a specific SIP Domain Credential.
     * @param accountSid Account SID
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @return The deleted Credential.
     * @throws ZangException
     */
    public Credential deleteCredential(String accountSid, String credentialsListSid, String credentialSid) throws ZangException {
        return returnThrows(proxy.deleteCredential(accountSid, credentialsListSid, credentialSid), Credential.class);
    }

    /**
     * Deletes a specific SIP Domain Credential.
     * @param credentialsListSid Credentials List SID
     * @param credentialSid Credential SID
     * @return The deleted Credential.
     * @throws ZangException
     */
    public Credential deleteCredential(String credentialsListSid, String credentialSid) throws ZangException {
        return deleteCredential(conf.getSid(), credentialsListSid, credentialSid);
    }
}
