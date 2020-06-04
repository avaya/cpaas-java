package com.zang.api.domain.enums;

import com.zang.api.domain.enums.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum Product {
    OUTBOUND_CALL, INBOUND_CALL, OUTBOUND_SMS, INBOUND_SMS, OUTBOUND_SIP, INBOUND_SIP, RECORDING,
    RECURRING_DID, RECURRING_DID_PREMIUM, TRANSCRIPTION_AUTO, TRANSCRIPTION_HYBRID, RECURRING_INBOUND_CHANNEL,
    INBOUND_CALL_CHANNEL, CNAM_DIP, CARRIER_LOOKUP, OUTBOUND_CALL_SPOOFED, INBOUND_CALL_CHANNEL_OVERAGE,
    RECURRING_DID_UNBLOCK, INBOUND_CALL_UNBLOCKED, INBOUND_CALL_FORWARDED_FROM, UNKNOWN;

    private static Map<Product, String> map;
    private static Map<Product, String> reverseMap;

    static {
        map = new HashMap<Product, String>();
        map.put(OUTBOUND_CALL, "1");
        map.put(INBOUND_CALL, "2");
        map.put(OUTBOUND_SMS, "3");
        map.put(INBOUND_SMS, "4");
        map.put(OUTBOUND_SIP, "5");
        map.put(INBOUND_SIP, "6");
        map.put(RECORDING, "7");
        map.put(RECURRING_DID, "8");
        map.put(RECURRING_DID_PREMIUM, "9");
        map.put(TRANSCRIPTION_AUTO, "12");
        map.put(TRANSCRIPTION_HYBRID, "14");
        map.put(RECURRING_INBOUND_CHANNEL, "17");
        map.put(INBOUND_CALL_CHANNEL, "18");
        map.put(CNAM_DIP, "19");
        map.put(CARRIER_LOOKUP, "20");
        map.put(OUTBOUND_CALL_SPOOFED, "21");
        map.put(INBOUND_CALL_CHANNEL_OVERAGE, "22");
        map.put(RECURRING_DID_UNBLOCK, "23");
        map.put(INBOUND_CALL_UNBLOCKED, "24");
        map.put(INBOUND_CALL_FORWARDED_FROM, "25");

        reverseMap = new HashMap<Product, String>();
        reverseMap.put(OUTBOUND_CALL, "Outbound Call");
        reverseMap.put(INBOUND_CALL, "Inbound Call");
        reverseMap.put(OUTBOUND_SMS, "Outbound SMS");
        reverseMap.put(INBOUND_SMS, "Inbound SMS");
        reverseMap.put(OUTBOUND_SIP, "Outbound SIP");
        reverseMap.put(INBOUND_SIP, "Inbound SIP");
        reverseMap.put(RECORDING, "Recording");
        reverseMap.put(RECURRING_DID, "Recurring DID");
        reverseMap.put(RECURRING_DID_PREMIUM, "Recurring DID (Premium)");
        reverseMap.put(TRANSCRIPTION_AUTO, "Transcription (Auto)");
        reverseMap.put(TRANSCRIPTION_HYBRID, "Transcription (Hybrid)");
        reverseMap.put(RECURRING_INBOUND_CHANNEL, "Recurring Inbound Channel");
        reverseMap.put(INBOUND_CALL_CHANNEL, "Inbound Call (Channel)");
        reverseMap.put(CNAM_DIP, "CNAM Dip");
        reverseMap.put(CARRIER_LOOKUP, "Carrier Lookup");
        reverseMap.put(OUTBOUND_CALL_SPOOFED, "Outbound Call (Spoofed)");
        reverseMap.put(INBOUND_CALL_CHANNEL_OVERAGE, "Inbound Call (Channel Overage)");
        reverseMap.put(RECURRING_DID_UNBLOCK, "Recurring DID Unblock");
        reverseMap.put(INBOUND_CALL_UNBLOCKED, "Inbound Call Unblocked");
        reverseMap.put(INBOUND_CALL_FORWARDED_FROM, "Inbound Call Forwarded From");
    }

    @JsonCreator
    public static Product forValue(String s) {
        return EnumUtil.getValue(s, reverseMap, UNKNOWN);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}