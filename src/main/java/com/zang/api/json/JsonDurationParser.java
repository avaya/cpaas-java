package com.zang.api.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class JsonDurationParser extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException,
            JsonProcessingException {
        String text = jsonparser.getText();
        if (text == null)
            return null;
        try {
            Integer retVal = new Integer(text);
            return retVal;
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
