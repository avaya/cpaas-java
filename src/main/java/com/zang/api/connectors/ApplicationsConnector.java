package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Application;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.ApplicationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ApplicationParams;
import com.zang.api.restproxies.ApplicationsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Applications endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class ApplicationsConnector extends BaseConnector {

    private ApplicationsProxy proxy;

    ApplicationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(ApplicationsProxy.class);
    }

    /**
     * Shows information about an application
     * @param accountSid Account SID
     * @param applicationSid SID of the application for which the information should be retrieved
     * @return Information about the application
     * @throws ZangException
     */
    public Application viewApplication(String accountSid, String applicationSid)
            throws ZangException {
        return returnThrows(proxy.viewApplication(accountSid,
                applicationSid), Application.class);
    }

    /**
     * Shows information about an application
     * @param applicationSid SID of the application for which the information should be retrieved
     * @return Information about the application
     * @throws ZangException
     */
    public Application viewApplication(String applicationSid)
            throws ZangException {
        return viewApplication(conf.getSid(), applicationSid);
    }

    /**
     * Lists available applications
     * @param accountSid Account SID
     * @param friendlyName Filters by application friendly name
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of available applicatoins
     * @throws ZangException
     */
    public ApplicationsList listApplications(String accountSid, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listApplications(accountSid, friendlyName, page, pageSize), ApplicationsList.class);
    }

    /**
     * Lists available applications
     * @param friendlyName Filters by application friendly name
     * @param page Page to return
     * @param pageSize Number of applications to return
     * @return A list of available applicatoins
     * @throws ZangException
     */
    public ApplicationsList listApplications(String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return listApplications(conf.getSid(), friendlyName, page, pageSize);
    }

    /**
     * Lists up to 50 applications associated with your account
     * @return A list of available applicatoins
     * @throws ZangException
     */
    public ApplicationsList listApplications() throws ZangException {
        return listApplications(conf.getSid(), null, null);
    }

    /**
     * Creates a new application
     * @param accountSid Account SID
     * @param friendlyName Friendly name for the new application
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param smsUrl The URL requested when an SMS is received. This URL must be valid and should return InboundXML
     *               containing instructions on how to process the SMS. A badly formatted URL will NOT fallback to the
     *               FallbackUrl but return an error without placing the call. URL length is limited to 200 characters.
     * @param smsMethod The HTTP method used to request the URL when an SMS is received.
     * @param smsFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                       the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param smsFallbackMethod The HTTP method used to request the smsFallbackUrl when an SMS is received.
     * @param heartbeatUrl A URL that will be requested every 60 seconds during the call, sending information about
     *                     the call. The HeartbeatUrl will NOT be requested unless at least 60 seconds of call time
     *                     have elapsed. URL length is limited to 200 characters.
     * @param heartbeatMethod The HTTP method used to request the HeartbeatUrl.
     * @param statusCallback A URL that will be requested when the call connects and ends, sending information about
     *                       the call. URL length is limited to 200 characters.
     * @param statusCallbackMethod The HTTP method used to request the StatusCallback URL.
     * @param hangupCallback This is a StatusCallback clone that will be phased out in future versions.
     * @param hangupCallbackMethod This is a StatusCallbackMethod clone that will be phased out in future versions.
     * @return The created Application
     * @throws ZangException
     */
    public Application createApplication(String accountSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.createApplication(accountSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), Application.class);
    }

    /**
     * Creates a new application.
     * @param applicationParams Parameters for creating a new application
     * @return The created Appliction
     * @throws ZangException
     */
    public Application createApplication(ApplicationParams applicationParams) throws ZangException {
        return createApplication(applicationParams.getAccountSid() != null ? applicationParams.getAccountSid() : conf.getSid(), applicationParams.getFriendlyName(), applicationParams.getVoiceUrl(), applicationParams.getVoiceMethod(), applicationParams.getVoiceFallbackUrl(), applicationParams.getVoiceFallbackMethod(), applicationParams.getVoiceCallerIdLookup(), applicationParams.getSmsUrl(), applicationParams.getSmsMethod(), applicationParams.getSmsFallbackUrl(), applicationParams.getSmsFallbackMethod(), applicationParams.getHeartbeatUrl(), applicationParams.getHeartbeatMethod(), applicationParams.getStatusCallback(), applicationParams.getStatusCallbackMethod(), applicationParams.getHangupCallback(), applicationParams.getHangupCallbackMethod());
    }

    /**
     * Updates an existing application's data.
     * @param accountSid Account SID
     * @param applicationSid SID of the application you want to update.
     * @param friendlyName Friendly name for the new application
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param smsUrl The URL requested when an SMS is received. This URL must be valid and should return InboundXML
     *               containing instructions on how to process the SMS. A badly formatted URL will NOT fallback to the
     *               FallbackUrl but return an error without placing the call. URL length is limited to 200 characters.
     * @param smsMethod The HTTP method used to request the URL when an SMS is received.
     * @param smsFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                       the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param smsFallbackMethod The HTTP method used to request the smsFallbackUrl when an SMS is received.
     * @param heartbeatUrl A URL that will be requested every 60 seconds during the call, sending information about
     *                     the call. The HeartbeatUrl will NOT be requested unless at least 60 seconds of call time
     *                     have elapsed. URL length is limited to 200 characters.
     * @param heartbeatMethod The HTTP method used to request the HeartbeatUrl.
     * @param statusCallback A URL that will be requested when the call connects and ends, sending information about
     *                       the call. URL length is limited to 200 characters.
     * @param statusCallbackMethod The HTTP method used to request the StatusCallback URL.
     * @param hangupCallback This is a StatusCallback clone that will be phased out in future versions.
     * @param hangupCallbackMethod This is a StatusCallbackMethod clone that will be phased out in future versions.
     * @return The updated Application
     * @throws ZangException
     */
    public Application updateApplication(String accountSid, String applicationSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.updateApplication(accountSid, applicationSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), Application.class);
    }

    /**
     * Updates an existing application's data.
     * @param applicationSid SID of the application you want to update.
     * @param applicationParams New application parameters
     * @return The updates Application
     * @throws ZangException
     */
    public Application updateApplication(String applicationSid, ApplicationParams applicationParams) throws ZangException {
        return updateApplication(applicationParams.getAccountSid() != null ? applicationParams.getAccountSid() : conf.getSid(), applicationSid, applicationParams.getFriendlyName(), applicationParams.getVoiceUrl(), applicationParams.getVoiceMethod(), applicationParams.getVoiceFallbackUrl(), applicationParams.getVoiceFallbackMethod(), applicationParams.getVoiceCallerIdLookup(), applicationParams.getSmsUrl(), applicationParams.getSmsMethod(), applicationParams.getSmsFallbackUrl(), applicationParams.getSmsFallbackMethod(), applicationParams.getHeartbeatUrl(), applicationParams.getHeartbeatMethod(), applicationParams.getStatusCallback(), applicationParams.getStatusCallbackMethod(), applicationParams.getHangupCallback(), applicationParams.getHangupCallbackMethod());
    }


    /**
     * Deletes an existing application
     * @param accountSid Account SID
     * @param applicationSid SID of the application you want to delete
     * @return The deleted Application
     * @throws ZangException
     */
    public Application deleteApplication(String accountSid, String applicationSid) throws ZangException {
        return returnThrows(proxy.deleteApplication(accountSid, applicationSid), Application.class);
    }

    /**
     * Deletes an existing application
     * @param applicationSid SID of the application you want to delete
     * @return The deleted Application
     * @throws ZangException
     */
    public Application deleteApplication(String applicationSid) throws ZangException {
        return deleteApplication(conf.getSid(), applicationSid);
    }
}
