package com.zang.api.params;

import com.zang.api.domain.enums.AvailableNumberType;

/**
 * Utility class for executing the List Available Numbers request.
 * @see com.zang.api.connectors.AvailablePhoneNumbersConnector
 * @see ListAvailableNumbersParams
 */
public class ListAvailableNumbersParamsBuilder {
    private String accountSid;
    private String country;
    private AvailableNumberType type;
    private String contains;
    private String areaCode;
    private String inRegion;
    private String inPostalCode;
    private Integer page;
    private Integer pageSize;

    ListAvailableNumbersParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public ListAvailableNumbersParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Two letter country code
     * @param country
     * @return
     */
    public ListAvailableNumbersParamsBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Type of phone number
     * @param type
     * @return
     */
    public ListAvailableNumbersParamsBuilder setType(AvailableNumberType type) {
        this.type = type;
        return this;
    }

    /**
     * Filter by numbers
     * @param contains
     * @return
     */
    public ListAvailableNumbersParamsBuilder setContains(String contains) {
        this.contains = contains;
        return this;
    }

    /**
     * Filter by area code (only available for NA numbers).
     * @param areaCode
     * @return
     */
    public ListAvailableNumbersParamsBuilder setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * Filter by region
     * @param inRegion
     * @return
     */
    public ListAvailableNumbersParamsBuilder setInRegion(String inRegion) {
        this.inRegion = inRegion;
        return this;
    }

    /**
     * Filter by postal code
     * @param inPostalCode
     * @return
     */
    public ListAvailableNumbersParamsBuilder setInPostalCode(String inPostalCode) {
        this.inPostalCode = inPostalCode;
        return this;
    }

    /**
     * Page to return
     * @param page
     * @return
     */
    public ListAvailableNumbersParamsBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Number of items to return per page
     * @param pageSize
     * @return
     */
    public ListAvailableNumbersParamsBuilder setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ListAvailableNumbersParams build() {
        return new ListAvailableNumbersParams(accountSid, country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize);
    }
}