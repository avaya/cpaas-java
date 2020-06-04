package com.zang.api.domain;

import java.net.URI;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.zang.api.domain.enums.MmsDirection;
import com.zang.api.json.JsonDateParser;

/**
 * Text messages sent to and from Zang phone numbers are represented with the
 * Mms resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MmsMessage extends BaseZangObject {
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value = "date_created")
	private Date dateCreated;
	@JsonProperty(value = "mms_sid")
	private String mmsSid;
	private String to;
	private String from;
	private String body;
	private String status;
	private MmsDirection direction;
	@JsonProperty(value = "media_url")
	private URI mediaUrl;
	private String apiVersion;

	/**
	 * @return Date the MMS was sent.
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return The number that received the MMS message.
	 */
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return The number that sent the MMS message.
	 */
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return Text of the MMS message sent or received. May be up to 160 characters
	 *         in length.
	 */
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return Status of the MMS: sent, sending, queued, or failed.
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return Specifies the direction of the MMS: messages from REST API are
	 *         "outbound-api", messages from incoming phone numbers to Zang are
	 *         "incoming", messages from InboundXML initiated during an outbound
	 *         call are "outbound-call", and messages from InboundXML initiated via
	 *         an mms reply are "outbound-reply".
	 */
	public MmsDirection getDirection() {
		return direction;
	}

	public void setDirection(MmsDirection direction) {
		this.direction = direction;
	}

	/**
	 * @return The URL of an image.
	 */
	public URI getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(URI mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	/**
	 * @return The SID of MMS.
	 */
	public String getMmsSid() {
		return mmsSid;
	}

	public void setMmsSid(String mmsSid) {
		this.mmsSid = mmsSid;
	}

	/**
	 * @return API Version
	 */
	@Override
	public String getApiVersion() {
		return apiVersion;
	}

	@Override
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

}
