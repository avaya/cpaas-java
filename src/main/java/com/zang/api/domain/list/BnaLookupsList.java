package com.zang.api.domain.list;

import com.zang.api.domain.BnaLookup;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class BnaLookupsList extends ZangList<BnaLookup> {

    @Override
    @JsonProperty("bna_lookups")
    protected void mapElements(List<BnaLookup> elements) {
        setElements(elements);
    }

}
