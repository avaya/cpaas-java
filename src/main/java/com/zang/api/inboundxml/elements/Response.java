package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * When Zang receives an InboundXML document, the "instructions" are contained
 * within the <Response> </Response> elements. Zang begins reading at <Response>
 * and behaves accordingly as it encounters each new instruction element until
 * the end of the </Response>. All InboundXML elements are camelCased and are
 * categorized as either Verbs or Nouns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "content" })
@XmlRootElement(name = "Response")
public class Response {

	private static Marshaller jaxbMarshaller;
	private static Unmarshaller jaxbUnmarshaller;
	private static Schema schema;

	static {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Response.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schema = schemaFactory.newSchema(new StreamSource(
					new BufferedReader(new InputStreamReader(Response.class.getResourceAsStream("/inboundxml.xsd")))));
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setSchema(schema);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	@XmlElementRefs({ @XmlElementRef(name = "Answer", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "Record", type = Record.class, required = false),
			@XmlElementRef(name = "Pause", type = Pause.class, required = false),
			@XmlElementRef(name = "Redirect", type = Redirect.class, required = false),
			@XmlElementRef(name = "Ping", type = Ping.class, required = false),
			@XmlElementRef(name = "Sms", type = Sms.class, required = false),
			@XmlElementRef(name = "Mms", type = Mms.class, required = false),
			@XmlElementRef(name = "GetSpeech", type = GetSpeech.class, required = false),
			@XmlElementRef(name = "PlayLastRecording", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "Reject", type = Reject.class, required = false),
			@XmlElementRef(name = "Dial", type = Dial.class, required = false),
			@XmlElementRef(name = "Hangup", type = Hangup.class, required = false),
			@XmlElementRef(name = "Say", type = Say.class, required = false),
			@XmlElementRef(name = "Play", type = Play.class, required = false),
			@XmlElementRef(name = "Gather", type = Gather.class, required = false) })
	@XmlMixed
	protected List<ResponseElement> content;
	@XmlAttribute(name = "statusCallback")
	@XmlSchemaType(name = "anyURI")
	protected String statusCallback;
	@XmlAttribute(name = "statusMethod")
	protected HttpMethod statusMethod;
	@XmlAttribute(name = "heartbeatCallback")
	@XmlSchemaType(name = "anyURI")
	protected String heartbeatCallback;
	@XmlAttribute(name = "heartbeatMethod")
	protected HttpMethod heartbeatMethod;

	public static ResponseBuilder builder() {
		return new ResponseBuilder();
	}

	public Response() {
	}

	public Response(List<ResponseElement> content, String statusCallback, HttpMethod statusMethod,
			String heartbeatCallback, HttpMethod heartbeatMethod) {
		this.content = content;
		this.statusCallback = statusCallback;
		this.statusMethod = statusMethod;
		this.heartbeatCallback = heartbeatCallback;
		this.heartbeatMethod = heartbeatMethod;
	}

	public List<ResponseElement> getContent() {
		if (content == null) {
			content = new ArrayList<ResponseElement>();
		}
		return this.content;
	}

	public String getStatusCallback() {
		return statusCallback;
	}

	public void setStatusCallback(String value) {
		this.statusCallback = value;
	}

	public HttpMethod getStatusMethod() {
		return statusMethod;
	}

	public void setStatusMethod(HttpMethod value) {
		this.statusMethod = value;
	}

	public String getHeartbeatCallback() {
		return heartbeatCallback;
	}

	public void setHeartbeatCallback(String value) {
		this.heartbeatCallback = value;
	}

	public HttpMethod getHeartbeatMethod() {
		return heartbeatMethod;
	}

	public void setHeartbeatMethod(HttpMethod value) {
		this.heartbeatMethod = value;
	}

	public String toXml() throws ZangException {
		if (schema == null || jaxbMarshaller == null || jaxbUnmarshaller == null) {
			throw new ZangException("Couldn't initialize JAXB");
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(this, baos);
			String resultXml = baos.toString("UTF8");
			// test xml
			Response response = (Response) jaxbUnmarshaller.unmarshal(new StringReader(resultXml));
			return resultXml;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ZangException(ex.getMessage());
		}
	}

}
