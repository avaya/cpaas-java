package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.FraudControlConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.FraudControlRule;
import com.zang.api.domain.list.FraudControlRulesList;
import com.zang.api.exceptions.ZangException;


public class FraudControlExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        FraudControlConnector connector = ZangConnectorFactory.getFraudControlConnector(conf);

        //list fraud control resources
        try {
            FraudControlRulesList result = connector.listFraudControlResources(0, 22);
            System.out.println(result.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //block destination
        try {
            FraudControlRule rule = connector.blockDestination("HR", false, true, false);
            System.out.println(rule.getExpirationDate());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //authorize destination
        try {
            FraudControlRule rule = connector.authorizeDestination("HR", false, true, false);
            System.out.println(rule.getExpirationDate());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //extend destination
        try {
            FraudControlRule rule = connector.extendDestinationAuthorization("HR");
            System.out.println(rule.getExpirationDate());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //whitelist destination
        try {
            FraudControlRule rule = connector.whitelistDestination("HR", false, true, false);
            System.out.println(rule.getExpirationDate());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }


}
