package com.zang.api.domain.list;

import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class ApplicationClientsList extends ZangList<ApplicationClient> {

    @Override
    @JsonProperty("clients")
    protected void mapElements(List<ApplicationClient> elements) {
        setElements(elements);
    }

}
