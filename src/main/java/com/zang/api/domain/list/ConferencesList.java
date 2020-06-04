package com.zang.api.domain.list;

import com.zang.api.domain.Conference;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class ConferencesList extends ZangList<Conference> {

    @Override
    @JsonProperty("conferences")
    protected void mapElements(List<Conference> elements) {
        setElements(elements);
    }

}
