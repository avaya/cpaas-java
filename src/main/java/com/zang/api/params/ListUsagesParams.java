package com.zang.api.params;

import com.zang.api.domain.enums.Product;

/**
 * Utility class for executing the List Usages request.
 * @see com.zang.api.connectors.UsagesConnector
 * @see ListUsagesParamsBuilder
 */
public class ListUsagesParams {
    private String accountSid;
    private Integer day;
    private Integer month;
    private Integer year;
    private Product product;
    private Integer page;
    private Integer pageSize;

    public static ListUsagesParamsBuilder builder() {
        return new ListUsagesParamsBuilder();
    }

    /**
     * @see ListUsagesParamsBuilder
     */
    public ListUsagesParams() {
    }

    /**
     * @see ListUsagesParamsBuilder
     */
    public ListUsagesParams(String accountSid, Integer day, Integer month, Integer year, Product product, Integer page, Integer pageSize) {
        this.accountSid = accountSid;
        this.day = day;
        this.month = month;
        this.year = year;
        this.product = product;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
