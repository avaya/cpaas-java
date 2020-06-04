package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.list.ApplicationClientsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.ApplicationClientsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Application Clients endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class ApplicationClientsConnector extends BaseConnector {

    private ApplicationClientsProxy proxy;

    ApplicationClientsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(ApplicationClientsProxy.class);
    }

    /**
     * View all information about an application client.
     * @param accountSid Account SID
     * @param applicationSid Application SID of the client
     * @param clientSid SID of the client for which the information should be retrieved
     * @return Information about the Application Client
     * @throws ZangException
     */
    public ApplicationClient viewApplicationClient(String accountSid, String applicationSid, String clientSid) throws ZangException {
        return returnThrows(proxy.viewApplicationClient(accountSid, applicationSid, clientSid), ApplicationClient.class);
    }

    /**
     * View all information about an application client.
     * @param applicationSid Application SID of the client
     * @param clientSid SID of the client for which the information should be retrieved
     * @return Information about the Application Client
     * @throws ZangException
     */
    public ApplicationClient viewApplicationClient(String applicationSid, String clientSid) throws ZangException {
        return viewApplicationClient(conf.getSid(), applicationSid, clientSid);
    }

    /**
     * Lists available application clients.
     * @param accountSid Account SID
     * @param applicationSid Application SID of the client
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of available Application Clients
     * @throws ZangException
     */
    public ApplicationClientsList listApplicationClients(String accountSid, String applicationSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listApplicationClients(accountSid, applicationSid, page, pageSize), ApplicationClientsList.class);
    }

    /**
     * Lists available application clients.
     * @param applicationSid Application SID of the client
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of available Application Clients
     * @throws ZangException
     */
    public ApplicationClientsList listApplicationClients(String applicationSid, Integer page, Integer pageSize) throws ZangException {
        return listApplicationClients(conf.getSid(), applicationSid, page, pageSize);
    }

    /**
     * Creates a new application client for your application
     * @param accountSid Account SID
     * @param applicationSid Application for which to create a new client
     * @param nickname Nickname for the new cliend
     * @return The created ApplicationClient
     * @throws ZangException
     */
    public ApplicationClient createApplicationClient(String accountSid, String applicationSid, String nickname) throws ZangException {
        return returnThrows(proxy.createApplicationClient(accountSid, applicationSid, nickname), ApplicationClient.class);
    }

    /**
     * Creates a new application client for your application
     * @param applicationSid Application for which to create a new client
     * @param nickname Nickname for the new cliend
     * @return The created ApplicationClient
     * @throws ZangException
     */
    public ApplicationClient createApplicationClient(String applicationSid, String nickname) throws ZangException {
        return createApplicationClient(conf.getSid(), applicationSid, nickname);
    }
}
