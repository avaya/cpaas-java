package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SipCredentialsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.exceptions.ZangException;

public class SipCredentialsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        SipCredentialsConnector connector = ZangConnectorFactory.getSipCredentialsConnector(conf);


        //view credentials list
        try {
            CredentialsList credentialsList = connector.viewCredentialsList("TestCredentialsListSid");
            System.out.println(credentialsList.getCredentialsCount());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list credentials lists
        try {
            CredentialsListsList credentialsLists = connector.listCredentialsLists(0, 10);
            System.out.println(credentialsLists.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //create credentials list
        try {
            CredentialsList credentialsList = connector.createCredentialsList("MyCredentialsList");
            System.out.println(credentialsList.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //update credentials list
        try {
            CredentialsList credentialsList = connector.updateCredentialsList("TestCredentialsListSid",
                    "NewCredentialsList");
            System.out.println(credentialsList.getFriendlyName());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete credentials list
        try {
            CredentialsList credentialsList = connector.deleteCredentialsList("TestCredentialsListSid");
            System.out.println(credentialsList.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //view credential
        try {
            Credential credential = connector.viewCredential("TestCredentialsListSid", "TestCredentialSid");
            System.out.println(credential.getUsername());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //list credentials
        try {
            com.zang.api.domain.list.CredentialsList credentials = connector.listCredentials("TestCredentialsListSid", 0, 10);
            for (Credential credential : credentials) {
                System.out.println(credential.getUsername());
            }
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //create credential
        try {
            Credential credential = connector.createCredential("TestCredentialsListSid", "username", "password");
            System.out.println(credential.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //update credential
        try {
            Credential credential = connector.updateCredential("TestCredentialsListSid", "TestCredentialSid",
                    "password");
            System.out.println(credential.getUsername());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //delete credential
        try {
            Credential credential = connector.deleteCredential("TestCredentialsListSid", "TestCredentialSid");
            System.out.println(credential.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }
}
