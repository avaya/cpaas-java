package com.zang.api.unit;

import com.zang.api.connectors.SipDomainsConnector;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class SipDomainsTest extends BaseUnitTest {

    private SipDomainsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipDomainsConnector();
    }

    @Test
    public void viewDomain() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "viewDomain");
        Domain domain = connector.viewDomain("TestDomainSid");
        checkDomain(domain);
    }

    @Test
    public void listDomains() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "listDomains");

        DomainsList domains = connector.listDomains(0, 10);

        Assert.assertEquals(2, (int) domains.getTotal());
        checkDomain(domains.iterator().next());
    }

    @Test
    public void createDomain() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "createDomain");

        Domain domain = connector.createDomain(DomainParams.builder()
                .setAccountSid("TestAccountSid")
                .setDomainName("mydomain.com")
                .setFriendlyName("MyDomain")
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.POST)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setVoiceStatusCallback("VoiceStatusCallback")
                .setVoiceStatusCallbackMethod(HttpMethod.GET)
        .build());

        checkDomain(domain);
    }

    @Test
    public void updateDomain() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "updateDomain");

        Domain domain = connector.updateDomain(DomainParams.builder()
                .setAccountSid("TestAccountSid")
                .setDomainSid("TestDomainSid")
                .setFriendlyName("MyDomain")
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.POST)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setVoiceStatusCallback("VoiceStatusCallback")
                .setVoiceStatusCallbackMethod(HttpMethod.GET)
                .build());

        checkDomain(domain);
    }

    @Test
    public void deleteDomain() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "deleteDomain");
        Domain domain = connector.deleteDomain("TestDomainSid");
        checkDomain(domain);
    }

    @Test
    public void listMappedCredentialsList() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "listMappedCredentialsList");

        CredentialsListsList credentialsListsList = connector.listMappedCredentialsLists("TestDomainSid", 0, 10);

        Assert.assertEquals(1, (int) credentialsListsList.getTotal());
        checkCl(credentialsListsList.iterator().next());
    }

    @Test
    public void mapCredentialsList() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "mapCredentialsList");

        CredentialsList credentialsList = connector.mapCredentialsList("TestDomainSid", "TestCredentialsListSid");
        checkCl(credentialsList);
    }

    @Test
    public void deleteMappedCredentialsList() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "deleteMappedCredentialsList");

        CredentialsList credentialsList = connector.deleteMappedCredentialsList("TestDomainSid", "TestCredentialsListSid");
        checkCl(credentialsList);
    }

    @Test
    public void listMappedIpAcls() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "listMappedIpAcls");

        AccessControlListsList aclListList = connector.listMappedIpAccessControlLists("TestDomainSid", 0, 10);

        Assert.assertEquals(1, (int) aclListList.getTotal());
        checkIpAcl(aclListList.iterator().next());
    }

    @Test
    public void mapIpAcl() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "mapIpAcl");

        AccessControlList aclList = connector.mapIpAccessControlList("TestDomainSid", "TestIpAccessControlListSid");
        checkIpAcl(aclList);
    }

    @Test
    public void deleteIpAcl() throws ZangException, IOException {
        createExpectation("SipDomainsTest", "deleteIpAcl");

        AccessControlList aclList = connector.deleteMappedIpAccessControlList("TestDomainSid", "TestIpAccessControlListSid");
        checkIpAcl(aclList);
    }


    private void checkDomain(Domain domain) {

    }

    private void checkCl(CredentialsList list) {

    }

    private void checkIpAcl(AccessControlList list) {

    }

}
