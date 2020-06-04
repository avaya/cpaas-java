package com.zang.api.inboundxml.elements;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _Answer_QNAME = new QName("", "Answer");
    private final static QName _PlayLastRecording_QNAME = new QName("", "PlayLastRecording");


    public ObjectFactory() {
    }


    public User createUser() {
        return new User();
    }


    public Pause createPause() {
        return new Pause();
    }


    public Hangup createHangup() {
        return new Hangup();
    }


    public Say createSay() {
        return new Say();
    }


    public Redirect createRedirect() {
        return new Redirect();
    }


    public Conference createConference() {
        return new Conference();
    }


    public Gather createGather() {
        return new Gather();
    }


    public Play createPlay() {
        return new Play();
    }


    public Dial createDial() {
        return new Dial();
    }


    public Number createNumber() {
        return new Number();
    }


    public Sip createSip() {
        return new Sip();
    }


    public Response createResponse() {
        return new Response();
    }


    public Record createRecord() {
        return new Record();
    }


    public Ping createPing() {
        return new Ping();
    }


    public Reject createReject() {
        return new Reject();
    }


    public Sms createSms() {
        return new Sms();
    }


    public GetSpeech createGetSpeech() {
        return new GetSpeech();
    }

    public PlayLastRecording createPlayLastRecording() {
        return new PlayLastRecording();
    }


    @XmlElementDecl(namespace = "", name = "Answer")
    public JAXBElement<Object> createAnswer(Object value) {
        return new JAXBElement<Object>(_Answer_QNAME, Object.class, null, value);
    }


    @XmlElementDecl(namespace = "", name = "PlayLastRecording")
    public JAXBElement<Object> createPlayLastRecording(Object value) {
        return new JAXBElement<Object>(_PlayLastRecording_QNAME, Object.class, null, value);
    }

}
