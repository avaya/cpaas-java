package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SipDomainsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;


public class SipDomainsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        SipDomainsConnector connector = ZangConnectorFactory.getSipDomainsConnector(conf);

        //view domain
        try {
            Domain domain = connector.viewDomain("TestDomainSid");
            System.out.println(domain.getFriendlyName());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list domains
        try {
            DomainsList domains = connector.listDomains(0, 10);
            System.out.println(domains.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //create domain
        try {
            Domain domain = connector.createDomain(DomainParams.builder()
                    .setAccountSid("TestAccountSid")
                    .setDomainName("mydomain.com")
                    .setFriendlyName("MyDomain")
                    .setVoiceUrl("VoiceUrl")
                    .setVoiceMethod(HttpMethod.POST)
                    .setVoiceFallbackUrl("VoiceFallbackUrl")
                    .setVoiceFallbackMethod(HttpMethod.GET)
                    .build());
            System.out.println(domain.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //update domain
        try {
            Domain domain = connector.updateDomain(DomainParams.builder()
                    .setAccountSid("TestAccountSid")
                    .setDomainSid("TestDomainSid")
                    .setFriendlyName("MyDomain2")
                    .setVoiceUrl("VoiceUrl2")
                    .setVoiceMethod(HttpMethod.POST)
                    .build());
            System.out.println(domain.getVoiceUrl());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete domain
        try {
            Domain domain = connector.deleteDomain("TestDomainSid");
            System.out.println(domain.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list mapped credentials lists
        try {
            CredentialsListsList credentialsListsList = connector.listMappedCredentialsLists("TestDomainSid", 0, 10);
            System.out.println(credentialsListsList.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //map credentials list
        try {
            CredentialsList credentialsList = connector.mapCredentialsList("TestDomainSid", "TestCredentialsListSid");
            System.out.println(credentialsList.getCredentialsCount());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete mapped credentials list
        try {
            CredentialsList credentialsList = connector.deleteMappedCredentialsList("TestDomainSid",
                    "TestCredentialsListSid");
            System.out.println(credentialsList.getCredentialsCount());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list mapped ip access control lists
        try {
            AccessControlListsList aclListList = connector.listMappedIpAccessControlLists("TestDomainSid", 0, 10);
            System.out.println(aclListList.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //map ip access control list
        try {
            AccessControlList aclList = connector.mapIpAccessControlList("TestDomainSid", "TestIpAccessControlListSid");
            System.out.println(aclList.getIpAddressesCount());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete mapped ip access control list
        try {
            AccessControlList aclList = connector.deleteMappedIpAccessControlList("TestDomainSid",
                    "TestIpAccessControlListSid");
            System.out.println(aclList.getFriendlyName());
        } catch (ZangException e) {
            e.printStackTrace();
        }


    }
}
