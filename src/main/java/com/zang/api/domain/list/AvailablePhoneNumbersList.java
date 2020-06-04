package com.zang.api.domain.list;

import com.zang.api.domain.AvailablePhoneNumber;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class AvailablePhoneNumbersList extends ZangList<AvailablePhoneNumber> {

    @Override
    @JsonProperty("available_phone_numbers")
    protected void mapElements(List<AvailablePhoneNumber> elements) {
        setElements(elements);
    }

}
