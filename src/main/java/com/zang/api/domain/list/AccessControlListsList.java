package com.zang.api.domain.list;

import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class AccessControlListsList extends ZangList<AccessControlList> {

    @Override
    @JsonProperty("ip_access_control")
    protected void mapElements(List<AccessControlList> elements) {
        setElements(elements);
    }

}
