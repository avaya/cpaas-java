package com.zang.api.domain.list;

import com.zang.api.domain.Participant;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class ParticipantsList extends ZangList<Participant> {

    @Override
    @JsonProperty("participants")
    protected void mapElements(List<Participant> elements) {
        setElements(elements);
    }

}
