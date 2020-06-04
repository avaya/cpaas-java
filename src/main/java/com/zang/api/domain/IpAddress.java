package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpAddress extends BaseZangObject {



    @JsonProperty(value = "ip_address")
    private String ipAddress;
    @JsonProperty(value = "friendly_name")
    private String friendlyName;

    @JsonProperty("subresource_uris")
    private EmptySubresourceUris subresourceUris;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public EmptySubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

    public void setSubresourceUris(EmptySubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }
}
