package com.zang.api.domain.list;

import com.zang.api.domain.Domain;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class DomainsList extends ZangList<Domain> {

    @Override
    @JsonProperty("domains")
    protected void mapElements(List<Domain> elements) {
        setElements(elements);
    }

}
