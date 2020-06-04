package com.zang.api.domain.list;

import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CredentialsListsList extends ZangList<CredentialsList> {

    @Override
    @JsonProperty("credential_lists")
    protected void mapElements(List<CredentialsList> elements) {
        setElements(elements);
    }

}
