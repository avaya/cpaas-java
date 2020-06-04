package com.zang.api.domain.list;

import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class SmsMessageList extends ZangList<SmsMessage> {

    @Override
    @JsonProperty(value = "sms_messages")
    protected void mapElements(List<SmsMessage> elements) {
        setElements(elements);
    }

}
