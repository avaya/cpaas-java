package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.BCPLanguage;
import com.zang.api.inboundxml.elements.enums.GatherInput;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "content" })
@XmlRootElement(name = "Gather")
public class Gather implements ResponseElement {

	@XmlElementRefs({ @XmlElementRef(name = "Pause", type = Pause.class, required = false),
			@XmlElementRef(name = "Say", type = Say.class, required = false),
			@XmlElementRef(name = "Play", type = Play.class, required = false),
			@XmlElementRef(name = "PlayLastRecording", type = JAXBElement.class, required = false) })
	@XmlMixed
	protected List<GatherElement> content;
	@XmlAttribute(name = "action")
	@XmlSchemaType(name = "anyURI")
	protected String action;
	@XmlAttribute(name = "method")
	protected HttpMethod method;
	@XmlAttribute(name = "timeout")
	protected Integer timeout;
	@XmlAttribute(name = "finishOnKey")
	protected String finishOnKey;
	@XmlAttribute(name = "numDigits")
	protected Integer numDigits;
	@XmlAttribute(name = "input")
	protected GatherInput input;
	@XmlAttribute(name = "hints")
	protected String hints;
	@XmlAttribute(name = "language")
	protected BCPLanguage language;

	public static GatherBuilder builder() {
		return new GatherBuilder();
	}

	public Gather() {
	}

	public Gather(List<GatherElement> content, String action, HttpMethod method, Integer timeout, String finishOnKey,
			Integer numDigits, GatherInput input, String hints, BCPLanguage language) {
		this.content = content;
		this.action = action;
		this.method = method;
		this.timeout = timeout;
		this.finishOnKey = finishOnKey;
		this.numDigits = numDigits;
		this.input = input;
		this.hints = hints;
		this.language = language;
	}

	public List<GatherElement> getContent() {
		if (content == null) {
			content = new ArrayList<GatherElement>();
		}
		return this.content;
	}

	public void setContent(List<GatherElement> content) {
		this.content = content;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String value) {
		this.action = value;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod value) {
		this.method = value;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer value) {
		this.timeout = value;
	}

	public String getFinishOnKey() {
		return finishOnKey;
	}

	public void setFinishOnKey(String value) {
		this.finishOnKey = value;
	}

	public Integer getNumDigits() {
		return numDigits;
	}

	public void setNumDigits(Integer value) {
		this.numDigits = value;
	}

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

	public GatherInput getInput() {
		return input;
	}

	public void setInput(GatherInput input) {
		this.input = input;
	}

	public BCPLanguage getLanguage() {
		return language;
	}

	public void setLanguage(BCPLanguage language) {
		this.language = language;
	}

}
