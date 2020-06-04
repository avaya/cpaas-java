package com.zang.api.domain;

import com.zang.api.domain.enums.SmsDirection;
import com.zang.api.json.JsonDateParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Text messages sent to and from Zang phone numbers are represented with the Sms resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsMessage extends BaseZangObject {
    @JsonDeserialize(using = JsonDateParser.class)
    @JsonProperty(value = "date_sent")
    private Date dateSent;
    private String to;
    private String from;
    private String body;
    private String status;
    private SmsDirection direction;
    private BigDecimal price;

    /**
     * @return Date the SMS was sent.
     */
    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    /**
     * @return The number that received the SMS message.
     */
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return The number that sent the SMS message.
     */
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return Text of the SMS message sent or received. May be up to 160 characters in length.
     */
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return Status of the SMS: sent, sending, queued, or failed.
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Specifies the direction of the SMS: messages from REST API are
     * "outbound-api", messages from incoming phone numbers to Zang
     * are "incoming", messages from InboundXML initiated during an
     * outbound call are "outbound-call", and messages from InboundXML
     * initiated via an sms reply are "outbound-reply".
     */
    public SmsDirection getDirection() {
        return direction;
    }

    public void setDirection(SmsDirection direction) {
        this.direction = direction;
    }

    /**
     * @return Cost of the SMS.
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
