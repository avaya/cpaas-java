package com.zang.api.domain.list;

import com.zang.api.domain.Call;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CallsList extends ZangList<Call> {

    @Override
    @JsonProperty("calls")
    protected void mapElements(List<Call> elements) {
        setElements(elements);
    }

}
