package com.zang.api.unit;

import com.zang.api.connectors.SipCredentialsConnector;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class SipCredentialsTest extends BaseUnitTest {

    private SipCredentialsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipCredentialsConnector();
    }


    @Test
    public void viewCredentialsList() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "viewCredentialsList");
        checkCredentialsList(connector.viewCredentialsList("TestCredentialsListSid"));
    }

    @Test
    public void listCredentialsLists() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "listCredentialsLists");
        connector.listCredentialsLists(0, 10);
    }


    @Test
    public void createCredentialsList() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "createCredentialsList");
        checkCredentialsList(connector.createCredentialsList("MyCredentialsList"));
    }


    @Test
    public void updateCredentialsList() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "updateCredentialsList");
        checkCredentialsList(connector.updateCredentialsList("TestCredentialsListSid", "NewCredentialsList"));
    }


    @Test
    public void deleteCredentialsList() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "deleteCredentialsList");
        checkCredentialsList(connector.deleteCredentialsList("TestCredentialsListSid"));
    }


    @Test
    public void viewCredential() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "viewCredential");
        checkCredential(connector.viewCredential("TestCredentialsListSid", "TestCredentialSid"));
    }


    @Test
    public void listCredentials() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "listCredentials");
        connector.listCredentials("TestCredentialsListSid", 0, 10);
    }


    @Test
    public void createCredential() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "createCredential");
        checkCredential(connector.createCredential("TestCredentialsListSid", "username", "password"));
    }


    @Test
    public void updateCredential() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "updateCredential");
        checkCredential(connector.updateCredential("TestCredentialsListSid", "TestCredentialSid", "password"));
    }


    @Test
    public void deleteCredential() throws ZangException, IOException {
        createExpectation("SipCredentialsTest", "deleteCredential");
        checkCredential(connector.deleteCredential("TestCredentialsListSid", "TestCredentialSid"));
    }

    private void checkCredentialsList(CredentialsList cl) {

    }

    private void checkCredential(Credential credential) {

    }

}
