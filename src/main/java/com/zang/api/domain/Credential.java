package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Credential extends BaseZangObject {

    private String username;
    @JsonProperty(value = "friendly_name")
    private String friendlyName;
    @JsonProperty(value = "credential_list")
    private String credentialList;

    @JsonProperty("subresource_uris")
    private EmptySubresourceUris subresourceUris;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getCredentialList() {
        return credentialList;
    }

    public void setCredentialList(String credentialList) {
        this.credentialList = credentialList;
    }

    public EmptySubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

    public void setSubresourceUris(EmptySubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }
}
