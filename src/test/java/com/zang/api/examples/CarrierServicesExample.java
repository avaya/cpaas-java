package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.CarrierServicesConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.list.BnaLookupsList;
import com.zang.api.domain.list.CarrierLookupsList;
import com.zang.api.domain.list.CnamLookupsList;
import com.zang.api.exceptions.ZangException;


public class CarrierServicesExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        CarrierServicesConnector connector = ZangConnectorFactory.getCarrierServicesConnector(conf);

        //carrier lookup
        try {
            CarrierLookupsList data = connector.carrierLookup("+1234");
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list carrier lookups
        try {
            CarrierLookupsList data = connector.listCarrierLookups(0, 33);
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //cnam lookup
        try {
            CnamLookupsList data = connector.cnamLookup("+1234");
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list cnam lookups
        try {
            CnamLookupsList data = connector.listCnamLookups(0, 33);
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //bna lookup
        try {
            BnaLookupsList data = connector.bnaLookup("+1234");
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list bna lookups
        try {
            BnaLookupsList data = connector.listBnaLookups(0, 33);
            System.out.println(data.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }

}
