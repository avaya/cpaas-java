package com.zang.api.domain;

import com.zang.api.json.JsonBooleanParser;
import com.zang.api.json.JsonDurationParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant extends BaseZangObject{

    @JsonProperty("call_sid")
    private String callSid;
    @JsonProperty("conference_sid")
    private String conferenceSid;
    @JsonDeserialize(using = JsonBooleanParser.class)
    private Boolean muted;
    @JsonDeserialize(using = JsonBooleanParser.class)
    private Boolean deaf;
    @JsonProperty("caller_name")
    private String callerName;
    @JsonProperty("caller_number")
    private String callerNumber;
    @JsonDeserialize(using = JsonDurationParser.class)
    private Integer duration;

    /**
	 * @return The sid of the call of the participant
	 */
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
    /**
     * @return The sid of the conference the participant is a part of
     */
    public String getConferenceSid() {
        return conferenceSid;
    }
    public void setConferenceSid(String conferenceSid) {
        this.conferenceSid = conferenceSid;
    }
    /**
     * @return Returns true if the participant is muted.
     */
    public Boolean getMuted() {
        return muted;
    }
    @JsonDeserialize(using = JsonBooleanParser.class)
    public void setMuted(Boolean muted) {
        this.muted = muted;
    }
    /**
     * @return Returns true if the participant is deafened.
     */
    public Boolean getDeaf() {
        return deaf;
    }
    @JsonDeserialize(using = JsonBooleanParser.class)
    public void setDeaf(Boolean deaf) {
        this.deaf = deaf;
    }

    /**
     * @return The participant name available on the caller id.
     */
    public String getCallerName() {
        return callerName;
    }
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }
    /**
     * @return The number this participant used to enter the conference.
     */
    public String getCallerNumber() {
        return callerNumber;
    }
    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }
    /**
     * @return The duration in seconds a participant has been in a conference.
     */
    public Integer getDuration() {
        return duration;
    }
    @JsonDeserialize(using = JsonDurationParser.class)
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
