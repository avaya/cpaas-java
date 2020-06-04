package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.IncomingPhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.PurchaseIncomingNumberParams;
import com.zang.api.params.UpdateIncomingNumberParams;
import com.zang.api.restproxies.IncomingPhoneNumbersProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Incoming Phone Numbers endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class IncomingPhoneNumbersConnector extends BaseConnector {

    private IncomingPhoneNumbersProxy proxy;

    IncomingPhoneNumbersConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(IncomingPhoneNumbersProxy.class);
    }


    /**
     * Shows info on an incoming phone number.
     * @param accountSid Account SID
     * @param incomingPhoneNumberSid Incoming Number SID
     * @return Information about Incoming Phone Number.
     * @throws ZangException
     */
    public IncomingPhoneNumber viewIncomingNumber(String accountSid, String incomingPhoneNumberSid) throws ZangException {
        return returnThrows(proxy.viewIncomingNumber(accountSid, incomingPhoneNumberSid), IncomingPhoneNumber.class);
    }

    /**
     * Shows info on an incoming phone number.
     * @param incomingPhoneNumberSid Incoming Number SID
     * @return Information about Incoming Phone Number.
     * @throws ZangException
     */
    public IncomingPhoneNumber viewIncomingNumber(String incomingPhoneNumberSid) throws ZangException {
        return viewIncomingNumber(conf.getSid(), incomingPhoneNumberSid);
    }


    /**
     * Shows info on all incoming numbers associated with an account
     * @param accountSid Account SID
     * @param contains List numbers containing certain digits.
     * @param friendlyName Specifies that only IncomingPhoneNumber resources matching the input FriendlyName should be
     *                     returned in the list request.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Incoming Phone Numbers
     * @throws ZangException
     */
    public IncomingPhoneNumbersList listIncomingNumbers(String accountSid, String contains, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listIncomingNumbers(accountSid, contains, friendlyName, page, pageSize), IncomingPhoneNumbersList.class);
    }

    /**
     * Shows info on all incoming numbers associated with your account
     * @param contains List numbers containing certain digits.
     * @param friendlyName Specifies that only IncomingPhoneNumber resources matching the input FriendlyName should be
     *                     returned in the list request.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Incoming Phone Numbers
     * @throws ZangException
     */
    public IncomingPhoneNumbersList listIncomingNumbers(String contains, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return listIncomingNumbers(conf.getSid(), contains, friendlyName, page, pageSize);
    }


    /**
     * Purchases a new Incoming Phone Number
     * @param accountSid Account SID
     * @param friendlyName User generated name for the incoming number.
     * @param phoneNumber A specific available phone number you wish to add.
     * @param areaCode The area code from which a random available number will be added.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param voiceApplicationSid The SID of the Voice Application you wish to associate with this incoming number.
     * @param smsApplicationSid The SID of the SMS Application you wish to associate with this incoming number.
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
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
     * @return A new Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber purchaseIncomingNumber(String accountSid, String friendlyName, String phoneNumber, String areaCode, Boolean voiceCallerIdLookup, String voiceApplicationSid, String smsApplicationSid, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.purchaseIncomingNumber(accountSid, friendlyName, phoneNumber, areaCode, voiceCallerIdLookup, voiceApplicationSid, smsApplicationSid, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), IncomingPhoneNumber.class);
    }

    /**
     * Purchases a new Incoming Phone Number
     * @param friendlyName User generated name for the incoming number.
     * @param phoneNumber A specific available phone number you wish to add.
     * @param areaCode The area code from which a random available number will be added.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param voiceApplicationSid The SID of the Voice Application you wish to associate with this incoming number.
     * @param smsApplicationSid The SID of the SMS Application you wish to associate with this incoming number.
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
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
     * @return The purchased Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber purchaseIncomingNumber(String friendlyName, String phoneNumber, String areaCode, Boolean voiceCallerIdLookup, String voiceApplicationSid, String smsApplicationSid, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return purchaseIncomingNumber(conf.getSid(), friendlyName, phoneNumber, areaCode, voiceCallerIdLookup, voiceApplicationSid, smsApplicationSid, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }

    /**
     * Purchases a new Incoming Phone Number.
     * @param params Parameters with which to purchase the incoming phone number.
     * @return The purchased Incoming Phone Number
     * @throws ZangException
     * @see PurchaseIncomingNumberParams
     * @see com.zang.api.params.PurchaseIncomingNumberParamsBuilder
     */
    public IncomingPhoneNumber purchaseIncomingNumber(PurchaseIncomingNumberParams params) throws ZangException {
        return purchaseIncomingNumber(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getFriendlyName(), params.getPhoneNumber(), params.getAreaCode(), params.getVoiceCallerIdLookup(), params.getVoiceApplicationSid(), params.getSmsApplicationSid(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getSmsUrl(), params.getSmsMethod(), params.getSmsFallbackUrl(), params.getSmsFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getStatusCallback(), params.getStatusCallbackMethod(), params.getHangupCallback(), params.getHangupCallbackMethod());
    }


    /**
     * Updates an existing Incoming Phone Number's data.
     * @param accountSid Account SID
     * @param incomingPhoneNumberSid Incoming Phone Number SID
     * @param friendlyName User generated name for the incoming number.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
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
     * @return The updated Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber updateIncomingNumber(String accountSid, String incomingPhoneNumberSid, String friendlyName, Boolean voiceCallerIdLookup, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.updateIncomingNumber(accountSid, incomingPhoneNumberSid, friendlyName, voiceCallerIdLookup, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), IncomingPhoneNumber.class);
    }

    /**
     * Updates an existing Incoming Phone Number's data.
     * @param incomingPhoneNumberSid Incoming Phone Number SID
     * @param friendlyName User generated name for the incoming number.
     * @param voiceCallerIdLookup Look up the caller’s caller-ID name from the CNAM database (additional charges apply).
     * @param voiceUrl The URL requested once the call connects. This URL must be valid and should return InboundXML
     *                 containing instructions on how to process your call. A badly formatted Url will NOT fallback to
     *                 the FallbackUrl but return an error without placing the call. Url length is limited
     *                 to 200 characters.
     * @param voiceMethod The HTTP method used to request the URL once the call connects.
     * @param voiceFallbackUrl URL used if the required URL is unavailable or if any errors occur during execution of
     *                         the InboundXML returned by the required URL. Url length is limited to 200 characters.
     * @param voiceFallbackMethod The HTTP method used to request the FallbackUrl once the call connects.
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
     * @return The updated Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber updateIncomingNumber(String incomingPhoneNumberSid, String friendlyName, Boolean voiceCallerIdLookup, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return updateIncomingNumber(conf.getSid(), incomingPhoneNumberSid, friendlyName, voiceCallerIdLookup, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }

    /**
     * Updates an existing Incoming Phone Number's data.
     * @param params Parameters with which to update the Incoming Phone Number.
     * @return The updated Incoming Phone Number.
     * @throws ZangException
     */
    public IncomingPhoneNumber updateIncomingNumber(UpdateIncomingNumberParams params) throws ZangException {
        return updateIncomingNumber(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getIncomingPhoneNumberSid(), params.getFriendlyName(), params.getVoiceCallerIdLookup(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getSmsUrl(), params.getSmsMethod(), params.getSmsFallbackUrl(), params.getSmsFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getStatusCallback(), params.getStatusCallbackMethod(), params.getHangupCallback(), params.getHangupCallbackMethod());
    }

    /**
     * Deletes an Incoming Phone Number
     * @param accountSid Account SID
     * @param incomingPhoneNumberSid Incoming Phone Number SID
     * @return The deleted Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber deleteIncomingNumber(String accountSid, String incomingPhoneNumberSid) throws ZangException {
        return returnThrows(proxy.deleteIncomingNumber(accountSid, incomingPhoneNumberSid), IncomingPhoneNumber.class);
    }

    /**
     * Deletes an Incoming Phone Number
     * @param incomingPhoneNumberSid Incoming Phone Number SID
     * @return The deleted Incoming Phone Number
     * @throws ZangException
     */
    public IncomingPhoneNumber deleteIncomingNumber(String incomingPhoneNumberSid) throws ZangException {
        return deleteIncomingNumber(conf.getSid(), incomingPhoneNumberSid);
    }
}
