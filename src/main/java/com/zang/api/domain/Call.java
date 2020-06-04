package com.zang.api.domain;

import com.zang.api.domain.enums.AnsweredBy;
import com.zang.api.domain.enums.CallDirection;
import com.zang.api.domain.enums.CallStatus;
import com.zang.api.json.JsonBooleanParser;
import com.zang.api.json.JsonDateParser;
import com.zang.api.json.JsonDurationParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A call resource provides information about an individual call that has
 * occurred through Zang. Both inbound and outbound voice communication
 * through Zang are categorized as calls.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Call extends BaseZangObject{


    @JsonProperty(value="parent_call_sid")
    private String parentCallSid;
    private String to;
    private String from;
    @JsonProperty(value="phone_number_sid")
    private String phoneNumberSid;
    private CallStatus status;
    @JsonDeserialize(using = JsonDateParser.class)
    @JsonProperty(value="start_time")
    private Date startTime;
    @JsonDeserialize(using = JsonDateParser.class)
    @JsonProperty(value="end_time")
    private Date endTime;
    @JsonDeserialize(using = JsonDurationParser.class)
    private Integer duration;
    private BigDecimal price;
    private CallDirection direction;
    @JsonProperty(value="answered_by")
    private AnsweredBy answeredBy;
    @JsonProperty(value="forwarded_from")
    private String forwardedFrom;
    @JsonDeserialize(using = JsonBooleanParser.class)
    @JsonProperty(value="caller_id_blocked")
    private Boolean callerIdBlocked;
    @JsonProperty(value="subresource_uris")
    private CallSubresourceUris subresourceUris;
    @JsonProperty("recordings_count")
    private Integer recordingsCount;
    @JsonProperty("duration_billed")
    private int durationBilled;

    /**
     *
     * @return If the call was created during a different call using InboundXML, this is the sid of that initiating call.
     */
    public String getParentCallSid() {
        return parentCallSid;
    }
    public void setParentCallSid(String parentCallSid) {
        this.parentCallSid = parentCallSid;
    }

    /**
     *
     * @return The number that was called.
     */
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    /**
     *
     * @return The number that initiated the call.
     */
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     *
     * @return The sid of the Zang number calling, or being called. If no Zang phone number is involved in the call, this property is empty.
     */
    public String getPhoneNumberSid() {
        return phoneNumberSid;
    }
    public void setPhoneNumberSid(String phoneNumberSid) {
        this.phoneNumberSid = phoneNumberSid;
    }

    /**
     *
     * @return The status of the call: queued, ringing, in-progress, completed, failed, busy, no-answer.
     */
    public CallStatus getStatus() {
        return status;
    }
    public void setStatus(CallStatus status) {
        this.status = status;
    }

    /**
     *
     * @return The date the call started.
     */
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return The date the call ended.
     */
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return The length of the call in seconds.
     */
    public Integer getDuration() {
        return duration;
    }
    @JsonDeserialize(using = JsonDurationParser.class)
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return The cost of the call, if availible.
     */
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * @return The direction of the call from the perspective of Zang. Inbound for calls to Zang, outbound-api for calls from the Zang via REST request or outbound-dial for calls from Zang via InboundXML.
     */
    public CallDirection getDirection() {
        return direction;
    }
    public void setDirection(CallDirection direction) {
        this.direction = direction;
    }

    /**
     *
     * @return If the initiated call has answering machine detection, this specifies whether the machine answered. Can be human or machine.
     */
    public AnsweredBy getAnsweredBy() {
        return answeredBy;
    }
    public void setAnsweredBy(AnsweredBy answeredBy) {
        this.answeredBy = answeredBy;
    }

    /**
     *
     * @return The number that forwared the call, if any.
     */
    public String getForwardedFrom() {
        return forwardedFrom;
    }
    public void setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
    }


    /**
     *
     * @return Specifies whether the caller ID of the inbound phone number was blocked.
     */
    public Integer getRecordingsCount() {
        return recordingsCount;
    }
    public void setRecordingsCount(Integer recordingsCount) {
        this.recordingsCount = recordingsCount;
    }

    /**
     *
     * @return Specifies the count of the number of recordings
     */
    public Boolean getCallerIdBlocked() {
        return callerIdBlocked;
    }
    public void setCallerIdBlocked(Boolean callerIdBlocked) {
        this.callerIdBlocked = callerIdBlocked;
    }

    /**
     *
     * @return Specifies the count of the number of recordings
     */
    public int getDurationBilled() {
        return durationBilled;
    }
    public void setDurationBilled(int durationBilled) {
        this.durationBilled = durationBilled;
    }

    /**
     *
     * @return List of a calls various subresources and their URI path. Examples of call subresources are notifications, recordings, etc.
     */
    public CallSubresourceUris getSubresourceUris() {
        return subresourceUris;
    }
    public void setSubresourceUris(CallSubresourceUris subresourceUris) {
        this.subresourceUris = subresourceUris;
    }


}
