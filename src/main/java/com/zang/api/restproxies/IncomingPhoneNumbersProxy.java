package com.zang.api.restproxies;

import com.zang.api.domain.enums.HttpMethod;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface IncomingPhoneNumbersProxy {
    @GET
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
    @Produces("application/json")
    Response viewIncomingNumber(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid
    );

    @GET
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers.json")
    @Produces("application/json")
    Response listIncomingNumbers(
            @PathParam("AccountSid") String accountSid,
            @QueryParam("Contains") String contains,
            @QueryParam("FriendlyName") String friendlyName,
            @QueryParam("Page") Integer page,
            @QueryParam("PageSize") Integer pageSize

    );

    @POST
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers.json")
    @Produces("application/json")
    Response purchaseIncomingNumber(
            @PathParam("AccountSid") String accountSid,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("PhoneNumber") String phoneNumber,
            @FormParam("AreaCode") String areaCode,
            @FormParam("VoiceCallerIdLookup") Boolean voiceCallerIdLookup,
            @FormParam("VoiceApplicationSid") String voiceApplicationSid,
            @FormParam("SmsApplicationSid") String smsApplicationSid,
            @FormParam("VoiceUrl") String voiceUrl,
            @FormParam("VoiceMethod") HttpMethod voiceMethod,
            @FormParam("VoiceFallbackUrl") String voiceFallbackUrl,
            @FormParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
            @FormParam("SmsUrl") String smsUrl,
            @FormParam("SmsMethod") HttpMethod smsMethod,
            @FormParam("SmsFallbackUrl") String smsFallbackUrl,
            @FormParam("SmsFallbackMethod") HttpMethod smsFallbackMethod,
            @FormParam("HeartbeatUrl") String heartbeatUrl,
            @FormParam("HeartbeatMethod") HttpMethod heartbeatMethod,
            @FormParam("StatusCallback") String statusCallback,
            @FormParam("StatusCallbackMethod") HttpMethod statusCallbackMethod,
            @FormParam("HangupCallback") String hangupCallback,
            @FormParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod
    );

    @POST
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
    @Produces("application/json")
    Response updateIncomingNumber(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid,
            @FormParam("FriendlyName") String friendlyName,
            @FormParam("VoiceCallerIdLookup") Boolean voiceCallerIdLookup,
            @FormParam("VoiceUrl") String voiceUrl,
            @FormParam("VoiceMethod") HttpMethod voiceMethod,
            @FormParam("VoiceFallbackUrl") String voiceFallbackUrl,
            @FormParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
            @FormParam("SmsUrl") String smsUrl,
            @FormParam("SmsMethod") HttpMethod smsMethod,
            @FormParam("SmsFallbackUrl") String smsFallbackUrl,
            @FormParam("SmsFallbackMethod") HttpMethod smsFallbackMethod,
            @FormParam("HeartbeatUrl") String heartbeatUrl,
            @FormParam("HeartbeatMethod") HttpMethod heartbeatMethod,
            @FormParam("StatusCallback") String statusCallback,
            @FormParam("StatusCallbackMethod") HttpMethod statusCallbackMethod,
            @FormParam("HangupCallback") String hangupCallback,
            @FormParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod
    );

    @DELETE
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
    @Produces("application/json")
    Response deleteIncomingNumber(
            @PathParam("AccountSid") String accountSid,
            @PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid
    );
}

