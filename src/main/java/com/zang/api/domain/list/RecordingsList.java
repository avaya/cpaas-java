package com.zang.api.domain.list;

import com.zang.api.domain.Recording;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class RecordingsList extends ZangList<Recording> {

    @Override
    @JsonProperty("recordings")
    protected void mapElements(List<Recording> elements) {
        setElements(elements);
    }

}
