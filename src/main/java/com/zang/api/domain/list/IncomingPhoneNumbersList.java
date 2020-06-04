package com.zang.api.domain.list;

import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class IncomingPhoneNumbersList extends ZangList<IncomingPhoneNumber> {

    @Override
    @JsonProperty("incoming_phone_numbers")
    protected void mapElements(List<IncomingPhoneNumber> elements) {
        setElements(elements);
    }

}
