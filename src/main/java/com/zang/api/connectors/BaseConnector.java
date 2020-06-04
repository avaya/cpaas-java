package com.zang.api.connectors;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.configuration.ZangConstants;
import com.zang.api.exceptions.ZangException;
import com.zang.api.http.DefaultExecutor;

/**
 * The class used for all forms of communication with the Zang REST API.
 */
class BaseConnector {

	private ClientHttpEngine executor;
	protected ZangConfiguration conf;
	private String fullBaseUrl;

	/**
	 * Creates a new ZangConnector based on the provided configuration.
	 *
	 * @param conf
	 *            The configuration based on which the ZangConnector will be
	 *            created.
	 * @param executor
	 *            The executor used for REST calls, a default executor will be
	 *            created if left null.
	 * @see BasicZangConfiguration , PropertiesFileZangConfiguration,
	 *      ZangConfiguration
	 */

	BaseConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		this.conf = conf;
		this.executor = executor;

		if (this.executor == null) {
			try {

				this.executor = DefaultExecutor.createExecutor(conf);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl()).build();
		this.fullBaseUrl = baseUrl.toString();
	}

	<T> T createProxy(Class<T> clazz) {
		return new ResteasyClientBuilder().httpEngine(this.executor).build().target(fullBaseUrl).proxy(clazz);
	}

	<T> T returnThrows(Response response, Class<T> clazz) throws ZangException {
		int status = response.getStatus();
		if (status > 399) {
			try {
				throw response.readEntity(ZangException.class);
			} catch (ProcessingException ex) {
				throw new ZangException(ex.getMessage(), ex);
			}
		}
		return response.readEntity(clazz);
	}

	protected static String getDateString(Date date) {
		if (date == null)
			return null;
		return ZangConstants.queryDateFormat.format(date);
	}

}
