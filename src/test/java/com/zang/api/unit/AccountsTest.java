package com.zang.api.unit;

import com.zang.api.connectors.AccountsConnector;
import com.zang.api.domain.Account;
import com.zang.api.exceptions.ZangException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AccountsTest extends BaseUnitTest {

    @Test
    public void viewAccount() throws ZangException, IOException {
        createExpectation("AccountsTest", "viewAccount");
        AccountsConnector connector = connectorFactory.getAccountsConnector();
        Account account = connector.viewAccount(conf.getSid());
        Assert.assertEquals("friendlyname1", account.getFriendlyName());
    }

    @Test
    public void updateAccount() throws ZangException, IOException {
        createExpectation("AccountsTest", "updateAccount");
        AccountsConnector connector = connectorFactory.getAccountsConnector();
        connector.updateAccount("friendlyname1");
    }

}
