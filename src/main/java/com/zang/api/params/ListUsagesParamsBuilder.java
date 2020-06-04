package com.zang.api.params;

import com.zang.api.domain.enums.Product;

/**
 * Utility class for executing the List Usages request.
 * @see com.zang.api.connectors.UsagesConnector
 * @see ListUsagesParams
 */
public class ListUsagesParamsBuilder {
    private String accountSid;
    private Integer day;
    private Integer month;
    private Integer year;
    private Product product;
    private Integer page;
    private Integer pageSize;

    ListUsagesParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public ListUsagesParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Filters usage by day of month. If no month is specified then defaults to current month. Allowed
     * values are integers between 1 and 31 depending on the month.
     * @param day
     * @return
     */
    public ListUsagesParamsBuilder setDay(Integer day) {
        this.day = day;
        return this;
    }

    /**
     * Filters usage by month. Allowed values are integers between 1 and 12.
     * @param month
     * @return
     */
    public ListUsagesParamsBuilder setMonth(Integer month) {
        this.month = month;
        return this;
    }

    /**
     * Filters usage by year. Allowed values are valid years in integer form.
     * @param year
     * @return
     */
    public ListUsagesParamsBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    /**
     * Filters usage by a specific Zang product.
     * @param product
     * @return
     */
    public ListUsagesParamsBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    /**
     * Page to return
     * @param page
     * @return
     */
    public ListUsagesParamsBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Number of items to return per page
     * @param pageSize
     * @return
     */
    public ListUsagesParamsBuilder setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ListUsagesParams build() {
        return new ListUsagesParams(accountSid, day, month, year, product, page, pageSize);
    }
}