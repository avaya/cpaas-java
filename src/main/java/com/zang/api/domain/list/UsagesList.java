package com.zang.api.domain.list;

import com.zang.api.domain.Usage;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class UsagesList extends ZangList<Usage> {

    @Override
    @JsonProperty("usages")
    protected void mapElements(List<Usage> elements) {
        setElements(elements);
    }

}
