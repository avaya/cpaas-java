package com.zang.api.domain.list;

import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CarrierLookupsList extends ZangList<CarrierLookup> {

    @Override
    @JsonProperty("carrier_lookups")
    protected void mapElements(List<CarrierLookup> elements) {
        setElements(elements);
    }

}
