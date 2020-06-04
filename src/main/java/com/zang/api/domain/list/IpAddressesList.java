package com.zang.api.domain.list;

import com.zang.api.domain.IpAddress;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class IpAddressesList extends ZangList<IpAddress> {

    @Override
    @JsonProperty("ip_addresses")
    protected void mapElements(List<IpAddress> elements) {
        setElements(elements);
    }

}
