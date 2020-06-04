package com.zang.api.domain;

import com.zang.api.domain.enums.FraudControlType;
import com.zang.api.json.JsonDateParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FraudControlRule extends BaseZangObject {
    private FraudControlType type;
    @JsonProperty("is_lock")
    private Boolean isLock;
    @JsonProperty("mobile_enabled")
    private Boolean mobileEnabled;
    @JsonProperty("landline_enabled")
    private Boolean landlineEnabled;
    @JsonProperty("sms_enabled")
    private Boolean smsEnabled;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("country_prefix")
    private String countryPrefix;
    @JsonDeserialize(using = JsonDateParser.class)
    @JsonProperty("expiration_date")
    private Date expirationDate;

    public FraudControlType getType() {
        return type;
    }

    public void setType(FraudControlType type) {
        this.type = type;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean lock) {
        isLock = lock;
    }

    public Boolean getMobileEnabled() {
        return mobileEnabled;
    }

    public void setMobileEnabled(Boolean mobileEnabled) {
        this.mobileEnabled = mobileEnabled;
    }

    public Boolean getLandlineEnabled() {
        return landlineEnabled;
    }

    public void setLandlineEnabled(Boolean landlineEnabled) {
        this.landlineEnabled = landlineEnabled;
    }

    public Boolean getSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(Boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public void setCountryPrefix(String countryPrefix) {
        this.countryPrefix = countryPrefix;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
