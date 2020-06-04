package com.zang.api.domain.list;

import com.zang.api.domain.Notification;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class NotificationsList extends ZangList<Notification> {

    @Override
    @JsonProperty("notifications")
    protected void mapElements(List<Notification> elements) {
        setElements(elements);
    }

}
