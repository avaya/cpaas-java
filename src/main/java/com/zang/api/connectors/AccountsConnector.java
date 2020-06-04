package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Account;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.AccountsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;

/**
 * Used for all forms of communication with the Accounts endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class AccountsConnector extends BaseConnector {

    private AccountsProxy proxy;

    AccountsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(AccountsProxy.class);
    }


    /**
     * See all the information associated with an account
     *
     * @param accountSid The sid for the account to be retrieved.
     * @return Account object
     * @throws ZangException
     */
    public Account viewAccount(String accountSid) throws ZangException {
        Response response = proxy.getAccount(accountSid);
        return returnThrows(response, Account.class);
    }

    /**
     * See all the information associated with your account
     *
     * @return Account object
     * @throws ZangException
     */
    public Account viewAccount() throws ZangException {
        return viewAccount(conf.getSid());
    }

    /**
     * Updates a specific account's information.
     *
     * @param accountSid   Sid of account to update
     * @param friendlyName The new friendly name for this account
     * @return Updated account
     * @throws ZangException
     */
    public Account updateAccount(String accountSid, String friendlyName) throws ZangException {
        Response response = proxy.updateAccount(accountSid, friendlyName);
        return returnThrows(response, Account.class);
    }

    /**
     * Updates account information.
     *
     * @param friendlyName The new friendly name for this account
     * @return Updated account
     * @throws ZangException
     */
    public Account updateAccount(String friendlyName) throws ZangException {
        return updateAccount(conf.getSid(), friendlyName);
    }

}
