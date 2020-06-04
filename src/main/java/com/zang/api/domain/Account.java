package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * An account resource provides information about a single Zang account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends BaseZangObject {

    @JsonProperty(value = "friendly_name")
    private String friendlyName;

    private String status;

    @JsonProperty(value = "account_balance")
    private BigDecimal accountBalance;


    @JsonProperty(value = "max_outbound_limit")
    private String maxOutboundLimit;

    private String type;

    @JsonProperty(value = "time_zone")
    private String timeZone;

    @JsonProperty(value = "subresource_uris")
    private SubresourceUris subresourceUris;

    /**
     * @return This is an alias that can be created for Zang accounts. By
     * default, it is the email used to create the account but a custom
     * name can be used as long as it is shorter than 64 characters.
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * @return This is the status of the Zang account being requested. The
     * state of the status can be either active, suspended, or closed.
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The current balance of an account.
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * @return
     */
    public String getMaxOutboundLimit() {
        return maxOutboundLimit;
    }

    public void setMaxOutboundLimit(String maxOutboundLimit) {
        this.maxOutboundLimit = maxOutboundLimit;
    }

    /**
     * @return The type of account being requested. If the account is not yet
     * funded Type is Trial. Otherwise, Type for upgraded accounts is
     * Full.
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The name of an accounts timezone.
     */
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * @return List of an accounts various subresources and their URI path.
     * Examples of subresources are things like calls that occurred
     * through the account, sms messages, purchased phone numbers, etc.
     */
    public SubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

    public void setSubresourceUris(SubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }

}
