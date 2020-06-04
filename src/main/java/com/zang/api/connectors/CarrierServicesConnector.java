package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.list.BnaLookupsList;
import com.zang.api.domain.list.CarrierLookupsList;
import com.zang.api.domain.list.CnamLookupsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.CarrierServicesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Arrays;
import java.util.List;


/**
 * Used for all forms of communication with the Carrier Services endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class CarrierServicesConnector extends BaseConnector {

    private CarrierServicesProxy proxy;

    CarrierServicesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(CarrierServicesProxy.class);
    }

    /**
     * The Carrier Lookup API allows you to retrieve additional information about a phone number.
     * @param accountSid Account SID
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CarrierLookup information objects.
     * @throws ZangException
     */
    public CarrierLookupsList carrierLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.carrierLookup(accountSid, phoneNumbers), CarrierLookupsList.class);
    }

    /**
     * The Carrier Lookup API allows you to retrieve additional information about a phone number.
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CarrierLookup information objects.
     * @throws ZangException
     */
    public CarrierLookupsList carrierLookup(String...phoneNumbers) throws ZangException {
        return carrierLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    /**
     * List all Carrier Lookups associated with an account.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Carrier Lookups
     * @throws ZangException
     */
    public CarrierLookupsList listCarrierLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCarrierLookups(accountSid, page, pageSize), CarrierLookupsList.class);
    }

    /**
     * List all Carrier Lookups associated with your account.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Carrier Lookups
     * @throws ZangException
     */
    public CarrierLookupsList listCarrierLookups(Integer page, Integer pageSize) throws ZangException {
        return listCarrierLookups(conf.getSid(), page, pageSize);
    }

    /**
     * The CNAM Lookup API allows you to retrieve additional information about a phone number.
     * @param accountSid Account SID
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CnamLookup information objects.
     * @throws ZangException
     */
    public CnamLookupsList cnamLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.cnamLookup(accountSid, phoneNumbers), CnamLookupsList.class);
    }

    /**
     * The CNAM Lookup API allows you to retrieve additional information about a phone number.
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CnamLookup information objects.
     * @throws ZangException
     */
    public CnamLookupsList cnamLookup(String... phoneNumbers) throws ZangException {
        return cnamLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    /**
     * List all CNAM Lookups associated with an account.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of CNAM Lookups
     * @throws ZangException
     */
    public CnamLookupsList listCnamLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCnamLookups(accountSid, page, pageSize), CnamLookupsList.class);
    }

    /**
     * List all CNAM Lookups associated with an account.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of CNAM Lookups
     * @throws ZangException
     */
    public CnamLookupsList listCnamLookups(Integer page, Integer pageSize) throws ZangException {
        return listCnamLookups(conf.getSid(), page, pageSize);
    }

    /**
     * The BNA Lookup API allows you to retrieve additional information about a phone number.
     * @param accountSid Account SID
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CnamLookup information objects.
     * @throws ZangException
     */
    public BnaLookupsList bnaLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.bnaLookup(accountSid, phoneNumbers), BnaLookupsList.class);
    }

    /**
     * The BNA Lookup API allows you to retrieve additional information about a phone number.
     * @param phoneNumbers Phone numbers to do a lookup for.
     * @return List of CnamLookup information objects.
     * @throws ZangException
     */
    public BnaLookupsList bnaLookup(String... phoneNumbers) throws ZangException {
        return bnaLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    /**
     * List all BNA Lookups associated with an account.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of BNA Lookups
     * @throws ZangException
     */
    public BnaLookupsList listBnaLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listBnaLookups(accountSid, page, pageSize), BnaLookupsList.class);
    }

    /**
     * List all BNA Lookups associated with an account.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of BNA Lookups
     * @throws ZangException
     */
    public BnaLookupsList listBnaLookups(Integer page, Integer pageSize) throws ZangException {
        return listBnaLookups(conf.getSid(), page, pageSize);
    }
}


