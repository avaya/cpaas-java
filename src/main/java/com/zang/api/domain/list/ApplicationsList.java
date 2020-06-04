package com.zang.api.domain.list;

import com.zang.api.domain.Application;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class ApplicationsList extends ZangList<Application> {

    @Override
    @JsonProperty("applications")
    protected void mapElements(List<Application> elements) {
        setElements(elements);
    }

}
