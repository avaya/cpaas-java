package com.zang.api.examples;

import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.ZangInboundXml;
import com.zang.api.inboundxml.elements.Say;
import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

public class InboundXmlExample {

    public static void main(String[] args) {
        try {
            String result = ZangInboundXml.builder()
                    .say(Say.builder()
                            .setLanguage(Language.EN)
                            .setLoop(3)
                            .setText("Welcome to Zang!")
                            .setVoice(Voice.FEMALE)
                            .build())
                    .build()
                    .toXml();
            System.out.println(result);
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }

}
