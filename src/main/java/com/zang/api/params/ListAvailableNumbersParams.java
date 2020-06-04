package com.zang.api.params;

import com.zang.api.domain.enums.AvailableNumberType;

/**
 * Utility class for executing the List Available Numbers request.
 * @see com.zang.api.connectors.AvailablePhoneNumbersConnector
 * @see ListAvailableNumbersParamsBuilder
 */
public class ListAvailableNumbersParams {
    private String accountSid;
    private String country;
    private AvailableNumberType type;
    private String contains;
    private String areaCode;
    private String inRegion;
    private String inPostalCode;
    private Integer page;
    private Integer pageSize;

    public static ListAvailableNumbersParamsBuilder builder() {
        return new ListAvailableNumbersParamsBuilder();
    }

    /**
     * @see ListAvailableNumbersParamsBuilder
     */
    public ListAvailableNumbersParams() {
    }

    /**
     * @see ListAvailableNumbersParamsBuilder
     */
    public ListAvailableNumbersParams(String accountSid, String country, AvailableNumberType type, String contains, String areaCode, String inRegion, String inPostalCode, Integer page, Integer pageSize) {
        this.accountSid = accountSid;
        this.country = country;
        this.type = type;
        this.contains = contains;
        this.areaCode = areaCode;
        this.inRegion = inRegion;
        this.inPostalCode = inPostalCode;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AvailableNumberType getType() {
        return type;
    }

    public void setType(AvailableNumberType type) {
        this.type = type;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getInRegion() {
        return inRegion;
    }

    public void setInRegion(String inRegion) {
        this.inRegion = inRegion;
    }

    public String getInPostalCode() {
        return inPostalCode;
    }

    public void setInPostalCode(String inPostalCode) {
        this.inPostalCode = inPostalCode;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
