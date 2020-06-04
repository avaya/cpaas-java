package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessControlList extends BaseZangObject {

    @JsonProperty(value = "ip_addresses_count")
    private Integer ipAddressesCount;
    @JsonProperty(value = "friendly_name")
    private String friendlyName;

    @JsonProperty("subresource_uris")
    private CredentialsSubresourceUris subresourceUris;

    public Integer getIpAddressesCount() {
        return ipAddressesCount;
    }

    public void setIpAddressesCount(Integer ipAddressesCount) {
        this.ipAddressesCount = ipAddressesCount;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public CredentialsSubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

    public void setSubresourceUris(CredentialsSubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }
}
