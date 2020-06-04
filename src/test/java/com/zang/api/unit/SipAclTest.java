package com.zang.api.unit;

import com.zang.api.connectors.SipIpAccessControlListsConnector;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.IpAddress;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class SipAclTest extends BaseUnitTest {

    private SipIpAccessControlListsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipIpAccessControlListsConnector();
    }


    @Test
    public void viewIpAcl() throws ZangException, IOException {
        createExpectation("SipAclTest", "viewIpAcl");
        checkAcl(connector.viewIpAccessControlList("TestIpAccessControlListSid"));
    }

    @Test
    public void listIpAcls() throws ZangException, IOException {
        createExpectation("SipAclTest", "listIpAcls");
        connector.listIpAccessControlLists(0, 50);
    }


    @Test
    public void createIpAcl() throws ZangException, IOException {
        createExpectation("SipAclTest", "createIpAcl");
        checkAcl(connector.createIpAccessControlList("MyIpAclList"));
    }


    @Test
    public void updateIpAcl() throws ZangException, IOException {
        createExpectation("SipAclTest", "updateIpAcl");
        checkAcl(connector.updateIpAccessControlList("TestIpAccessControlListSid", "NewIpAclList"));
    }


    @Test
    public void deleteIpAcl() throws ZangException, IOException {
        createExpectation("SipAclTest", "deleteIpAcl");
        checkAcl(connector.deleteIpAccessControlList("TestIpAccessControlListSid"));
    }


    @Test
    public void viewAclIp() throws ZangException, IOException {
        createExpectation("SipAclTest", "viewAclIp");
        checkIp(connector.viewAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid"));
    }


    @Test
    public void listAclIps() throws ZangException, IOException {
        createExpectation("SipAclTest", "listAclIps");
        connector.listAccessControlListIps("TestIpAccessControlListSid", 0, 10);
    }


    @Test
    public void addAclIp() throws ZangException, IOException {
        createExpectation("SipAclTest", "addAclIp");
        checkIp(connector.addAccessControlListIp("TestIpAccessControlListSid", "MyIpAddress", "10.0.0.1"));
    }


    @Test
    public void updateAclIp() throws ZangException, IOException {
        createExpectation("SipAclTest", "updateAclIp");
        checkIp(connector.updateAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid", "NewIpAddress", "10.0.0.2"));
    }


    @Test
    public void deleteAclIp() throws ZangException, IOException {
        createExpectation("SipAclTest", "deleteAclIp");
        checkIp(connector.deleteAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid"));
    }

    private void checkAcl(AccessControlList acl) {

    }

    private void checkIp(IpAddress ip) {

    }

}
