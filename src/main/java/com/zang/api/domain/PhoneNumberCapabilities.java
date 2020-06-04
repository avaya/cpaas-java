package com.zang.api.domain;

import com.zang.api.json.JsonBooleanParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The features available with this incoming phone number. The voice and sms properties are either True or False depending on what the number is capable of.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneNumberCapabilities {
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("voice")
	private Boolean voice;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("sms")
	private Boolean sms;
	
	public Boolean getVoice() {
		return voice;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setVoice(Boolean voice) {
		this.voice = voice;
	}
	public Boolean getSms() {
		return sms;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setSms(Boolean sms) {
		this.sms = sms;
	}
	
}
