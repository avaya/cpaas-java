package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainSubresourceUris {

    @JsonProperty("ip_access_control_list_mappings")
    private String ipAccessControlListMappings;
    @JsonProperty("credential_list_mappings")
    private String credentialListMappings;

    public String getIpAccessControlListMappings() {
        return ipAccessControlListMappings;
    }

    public void setIpAccessControlListMappings(String ipAccessControlListMappings) {
        this.ipAccessControlListMappings = ipAccessControlListMappings;
    }

    public String getCredentialListMappings() {
        return credentialListMappings;
    }

    public void setCredentialListMappings(String credentialListMappings) {
        this.credentialListMappings = credentialListMappings;
    }
}
