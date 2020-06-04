package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.enums.AvailableNumberType;
import com.zang.api.domain.list.AvailablePhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListAvailableNumbersParams;
import com.zang.api.restproxies.AvailablePhoneNumbersProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Available Phone Numbers endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class AvailablePhoneNumbersConnector extends BaseConnector {

    private AvailablePhoneNumbersProxy proxy;

    AvailablePhoneNumbersConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(AvailablePhoneNumbersProxy.class);
    }

    /**
     * Shows information on all phone numbers available for purchasing
     * @param accountSid Account SID
     * @param country Required. Two letter country code
     * @param type Required. Type of phone number
     * @param contains Filter by numbers
     * @param areaCode Filter by area code (only available for NA numbers).
     * @param inRegion Filter by region
     * @param inPostalCode Filter by postal code
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of phone numbers available for purchasing
     * @throws ZangException
     */
    public AvailablePhoneNumbersList listAvailableNumbers(String accountSid, String country, AvailableNumberType type, String contains, String areaCode, String inRegion, String inPostalCode, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listAvailableNumbers(accountSid, country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize), AvailablePhoneNumbersList.class);
    }

    /**
     * Shows information on all phone numbers available for purchasing
     * @param country Required. Two letter country code
     * @param type Required. Type of phone number
     * @param contains Filter by numbers
     * @param areaCode Filter by area code (only available for NA numbers).
     * @param inRegion Filter by region
     * @param inPostalCode Filter by postal code
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of phone numbers available for purchasing
     * @throws ZangException
     */
    public AvailablePhoneNumbersList listAvailableNumbers(String country, AvailableNumberType type, String contains, String areaCode, String inRegion, String inPostalCode, Integer page, Integer pageSize) throws ZangException {
        return listAvailableNumbers(conf.getSid(), country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize);
    }

    /**
     * Shows information on all phone numbers available for purchasing
     * @param params Parameters by which to list available phone numbers.
     * @return List of phone numbers available for purchasing
     * @throws ZangException
     */
    public AvailablePhoneNumbersList listAvailableNumbers(ListAvailableNumbersParams params) throws ZangException {
        return listAvailableNumbers(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getCountry(), params.getType(), params.getContains(), params.getAreaCode(), params.getInRegion(), params.getInPostalCode(), params.getPage(), params.getPageSize());
    }

}


