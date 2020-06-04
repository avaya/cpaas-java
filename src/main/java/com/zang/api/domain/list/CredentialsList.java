package com.zang.api.domain.list;

import com.zang.api.domain.Credential;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CredentialsList extends ZangList<Credential> {

    @Override
    @JsonProperty("credentials")
    protected void mapElements(List<Credential> elements) {
        setElements(elements);
    }

}
