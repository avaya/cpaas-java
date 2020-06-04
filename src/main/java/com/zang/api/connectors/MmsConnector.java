package com.zang.api.connectors;

import java.net.URI;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.MmsMessage;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.MmsProxy;

/**
 * Used for all forms of communication with the Mms endpoint of the Zang REST
 * API.
 * 
 * @see ZangConnectorFactory
 */
public class MmsConnector extends BaseConnector {

	private MmsProxy proxy;

	MmsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		super(conf, executor);
		proxy = createProxy(MmsProxy.class);
	}

	/**
	 * Sends an MMS Message.
	 * 
	 * @param accountSid
	 *            Account SID
	 * @param to
	 *            Must be an MMS capable number. The value does not have to be in
	 *            any specific format.
	 * @param from
	 *            Must be a Zang number associated with your account. The value does
	 *            not have to be in any specific format.
	 * @param body
	 *            Text of the MMS to be sent.
	 * @param statusCallback
	 *            The URL that will be sent information about the MMS. Url length is
	 *            limited to 200 characters.
	 * @param mediaUrl
	 *            URL of an image to be sent in the message.
	 * @return The sent MMS message.
	 * @throws ZangException
	 */
	public MmsMessage sendMmsMessage(String accountSid, String to, String from, String body, String statusCallback,
			URI mediaUrl) throws ZangException {
		Response response = proxy.sendMmsMessage(accountSid, to, from, body, statusCallback, mediaUrl);
		return returnThrows(response, MmsMessage.class);
	}

	/**
	 * Sends an MMS Message.
	 * 
	 * @param to
	 *            Must be an MMS capable number. The value does not have to be in
	 *            any specific format.
	 * @param from
	 *            Must be a Zang number associated with your account. The value does
	 *            not have to be in any specific format.
	 * @param body
	 *            Text of the MMS to be sent.
	 * @param statusCallback
	 *            The URL that will be sent information about the MMS. Url length is
	 *            limited to 200 characters.
	 * @param mediaUrl
	 *            URL of an image to be sent in the message.
	 * @return The sent MMS message.
	 * @throws ZangException
	 */
	public MmsMessage sendMmsMessage(String to, String from, String body, String statusCallback, URI mediaUrl)
			throws ZangException {
		return sendMmsMessage(conf.getSid(), to, from, body, statusCallback, mediaUrl);
	}

}
