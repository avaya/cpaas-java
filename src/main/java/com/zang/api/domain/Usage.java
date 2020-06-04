package com.zang.api.domain;

import com.zang.api.domain.enums.Product;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * A usage resource provides information about the usage of an item returned by List Usages.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usage extends BaseZangObject {

    private Product product;
    @JsonProperty(value = "product_id")
    private Integer productId;
    private Integer total;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer quantity;
    @JsonProperty(value = "average_cost")
    private BigDecimal averageCost;
    @JsonProperty(value = "total_cost")
    private BigDecimal totalCost;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

}
