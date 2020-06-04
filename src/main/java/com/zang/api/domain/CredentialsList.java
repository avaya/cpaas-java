package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialsList extends BaseZangObject {

    @JsonProperty(value = "credentials_count")
    private Integer credentialsCount;
    @JsonProperty(value = "friendly_name")
    private String friendlyName;

    @JsonProperty("subresource_uris")
    private CredentialsSubresourceUris subresourceUris;

    public Integer getCredentialsCount() {
        return credentialsCount;
    }

    public void setCredentialsCount(Integer credentialsCount) {
        this.credentialsCount = credentialsCount;
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
