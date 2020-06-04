package com.zang.api.it;

import com.zang.api.connectors.SipCredentialsConnector;
import com.zang.api.connectors.SipDomainsConnector;
import com.zang.api.connectors.SipIpAccessControlListsConnector;
import com.zang.api.domain.*;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.domain.list.IpAddressesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import junit.framework.Assert;
import org.junit.Test;

public class SipIT extends BaseIntegrationTest {


    public SipIT() throws ZangException {
    }

    private void deleteCredentials() throws ZangException {

        SipCredentialsConnector scc = connectorFactory.getSipCredentialsConnector();
        CredentialsListsList cls = scc.listCredentialsLists(0, 10);
        for(CredentialsList clist : cls) {
            if (clist.getFriendlyName().equals("MyCredentialsList") || clist.getFriendlyName().equals("MyCredentialsList2")) {
                scc.deleteCredentialsList(clist.getSid());
            }
        }
    }

    @Test
    public void testSipCredentials() throws ZangException {
        SipCredentialsConnector scc = connectorFactory.getSipCredentialsConnector();

        deleteCredentials();

        CredentialsList cl = scc.createCredentialsList("MyCredentialsList");
        Credential cr = scc.createCredential(cl.getSid(), "testuser123", "34AS3!#$asfe");
        sleep();
        CredentialsList cl2 = scc.viewCredentialsList(cl.getSid());
        Credential cr2 = scc.viewCredential(cl.getSid(), cr.getSid());

        Assert.assertEquals("testuser123", cr2.getUsername());
        Assert.assertEquals("testuser123", cr.getUsername());
        Assert.assertEquals("MyCredentialsList", cl.getFriendlyName());
        Assert.assertEquals("MyCredentialsList", cl2.getFriendlyName());

        scc.updateCredentialsList(cl.getSid(), "MyCredentialsList2");
        sleep();
        CredentialsList cl3 = scc.viewCredentialsList(cl.getSid());
        Assert.assertEquals("MyCredentialsList2", cl3.getFriendlyName());

        com.zang.api.domain.list.CredentialsList credentials = scc.listCredentials(cl.getSid(), 0, 10);
        Assert.assertEquals(1, (int)credentials.getTotal());
        for(Credential c : credentials) {
            Assert.assertEquals(c.getUsername(), "testuser123");
        }

        scc.updateCredential(cl.getSid(), cr.getSid(), "34AS3!#$asfa");

        deleteCredentials();
        CredentialsListsList cls = scc.listCredentialsLists(0, 10);
        for(CredentialsList clist : cls) {
            if (clist.getFriendlyName().equals("MyCredentialsList") || clist.getFriendlyName().equals("MyCredentialsList2")) {
                Assert.fail();
            }
        }

    }

    @Test
    public void testSipAcls() throws ZangException {
        SipIpAccessControlListsConnector conn = connectorFactory.getSipIpAccessControlListsConnector();

        deleteAcls();
        AccessControlList acl = conn.createIpAccessControlList("MyAclList");
        sleep();
        conn.updateIpAccessControlList(acl.getSid(), "MyAclList2");
        sleep();
        acl = conn.viewIpAccessControlList(acl.getSid());
        Assert.assertEquals("MyAclList2", acl.getFriendlyName());

        IpAddress ip = conn.addAccessControlListIp(acl.getSid(), "MyIpAddress", "192.168.12.12");
        conn.updateAccessControlListIp(acl.getSid(), ip.getSid(), "MyIpAddress2", null);
        sleep();
        ip = conn.viewAccessControlListIp(acl.getSid(), ip.getSid());
        Assert.assertEquals("MyIpAddress2", ip.getFriendlyName());
        Assert.assertEquals("192.168.12.12", ip.getIpAddress());

        IpAddressesList ipList = conn.listAccessControlListIps(acl.getSid(), 0, 10);
        Assert.assertEquals(1, (int)ipList.getTotal());
        Assert.assertEquals(ip.getSid(), ipList.iterator().next().getSid());

        deleteAcls();

    }

    private void deleteAcls() throws ZangException {
        SipIpAccessControlListsConnector conn = connectorFactory.getSipIpAccessControlListsConnector();
        AccessControlListsList acls = conn.listIpAccessControlLists(0, 100);
        for(AccessControlList acl : acls) {
            if (acl.getFriendlyName().startsWith("MyAclList")) {
                conn.deleteIpAccessControlList(acl.getSid());
            }
        }
    }

    private void deleteDomains() throws ZangException {
        SipDomainsConnector conn = connectorFactory.getSipDomainsConnector();
        DomainsList domains = conn.listDomains(0, 10);
        for(Domain domain : domains) {
            if (domain.getFriendlyName().startsWith("MyDomain")) {
                conn.deleteDomain(domain.getSid());
            }
        }
    }

    @Test
    public void testDomains() throws ZangException{
        SipDomainsConnector conn = connectorFactory.getSipDomainsConnector();

        deleteDomains();
        deleteAcls();
        deleteCredentials();

        Domain domain = conn.createDomain(DomainParams.builder()
                .setDomainName("mytestdomain.com")
                .setFriendlyName("MyDomain")
                .setHeartbeatUrl("http://heartbeat.com")
                .setHeartbeatMethod(HttpMethod.GET)
                .setVoiceStatusCallback("http://statuscallback.com")
                .setVoiceStatusCallbackMethod(HttpMethod.POST)
                .build());

        sleep();
        conn.updateDomain(DomainParams.builder()
                .setDomainSid(domain.getSid())
                .setFriendlyName("MyDomain2")
                .build());
        sleep();
        domain = conn.viewDomain(domain.getSid());
        sleep();
        Assert.assertEquals("MyDomain2", domain.getFriendlyName());
        SipCredentialsConnector scc = connectorFactory.getSipCredentialsConnector();

        CredentialsList cl = scc.createCredentialsList("MyCredentialsList");
        Credential cr = scc.createCredential(cl.getSid(), "testuser123", "34AS3!#$asfe");
        sleep();
        conn.mapCredentialsList(domain.getSid(), cl.getSid());

        SipIpAccessControlListsConnector sipc = connectorFactory.getSipIpAccessControlListsConnector();
        AccessControlList acl = sipc.createIpAccessControlList("MyAclList");
        IpAddress ip = sipc.addAccessControlListIp(acl.getSid(), "MyIpAddress", "192.168.12.12");
        conn.mapIpAccessControlList(domain.getSid(), acl.getSid());
        sleep();
        domain = conn.viewDomain(domain.getSid());
        CredentialsListsList mappedcls = conn.listMappedCredentialsLists(domain.getSid(), 0, 10);
        Assert.assertEquals(1, (int)mappedcls.getTotal());
        AccessControlListsList mappedacls = conn.listMappedIpAccessControlLists(domain.getSid(),0, 10);
        Assert.assertEquals(1, (int)mappedacls.getTotal());

        Assert.assertEquals(1, (int)mappedacls.iterator().next().getIpAddressesCount());
        Assert.assertEquals(1, (int)mappedcls.iterator().next().getCredentialsCount());

        deleteDomains();
        deleteAcls();
        deleteCredentials();

    }
}
