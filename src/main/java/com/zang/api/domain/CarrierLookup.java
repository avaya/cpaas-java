package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierLookup extends BaseZangObject {

    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    private String network;
    @JsonProperty(value = "sponsor_network")
    private String sponsorNetwork;
    private Boolean mobile;
    @JsonProperty(value = "sponsor_mobile")
    private Boolean sponsorMobile;
    @JsonProperty(value = "carrier_id")
    private Integer carrierId;
    @JsonProperty(value = "sponsor_carrier_id")
    private Integer sponsorCarrierId;
    @JsonProperty(value = "country_code")
    private String countryCode;
    @JsonProperty(value = "sponsor_country_code")
    private String sponsorCountryCode;
    private String mnc;
    private String mcc;
    private BigDecimal price;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSponsorNetwork() {
        return sponsorNetwork;
    }

    public void setSponsorNetwork(String sponsorNetwork) {
        this.sponsorNetwork = sponsorNetwork;
    }

    public Boolean getSponsorMobile() {
        return sponsorMobile;
    }

    public void setSponsorMobile(Boolean sponsorMobile) {
        this.sponsorMobile = sponsorMobile;
    }

    public Integer getSponsorCarrierId() {
        return sponsorCarrierId;
    }

    public void setSponsorCarrierId(Integer sponsorCarrierId) {
        this.sponsorCarrierId = sponsorCarrierId;
    }

    public String getSponsorCountryCode() {
        return sponsorCountryCode;
    }

    public void setSponsorCountryCode(String sponsorCountryCode) {
        this.sponsorCountryCode = sponsorCountryCode;
    }
}
