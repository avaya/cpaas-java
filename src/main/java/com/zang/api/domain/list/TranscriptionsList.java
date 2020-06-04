package com.zang.api.domain.list;

import com.zang.api.domain.Transcription;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class TranscriptionsList extends ZangList<Transcription> {

    @Override
    @JsonProperty("transcriptions")
    protected void mapElements(List<Transcription> elements) {
        setElements(elements);
    }

}
