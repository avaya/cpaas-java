package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.SmsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Used for all forms of communication with the Sms endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SmsConnector extends BaseConnector {

    private SmsProxy proxy;

    SmsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SmsProxy.class);
    }


    /**
     * Shows info on an SMS message.
     * @param accountSid Account SID
     * @param smsMessageSid SMS Message SID
     * @return The requested SMS Message
     * @throws ZangException
     */
    public SmsMessage viewSmsMessage(String accountSid, String smsMessageSid)
            throws ZangException {
        Response response = proxy.getSmsMessage(accountSid,
                smsMessageSid);
        return returnThrows(response, SmsMessage.class);
    }


    /**
     * Shows info on an SMS message.
     * @param smsMessageSid SMS Message SID
     * @return The requested SMS Message
     * @throws ZangException
     */
    public SmsMessage viewSmsMessage(String smsMessageSid)
            throws ZangException {
        return viewSmsMessage(conf.getSid(), smsMessageSid);
    }


    /**
     * Shows info on all SMS messages associated with an account.
     * @param accountSid Account SID
     * @param to Filter by receiving number.
     * @param from Filter by sending number.
     * @param dateSentGte Filter by date sent greater or equal then.
     * @param dateSentLt Filter by date sent less than.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of SMS Messages
     * @throws ZangException
     */
    public SmsMessageList listSmsMessages(String accountSid, String to,
                                          String from, Date dateSentGte, Date dateSentLt, Integer page,
                                          Integer pageSize) throws ZangException {

        Response response = proxy.getSmsMessageList(
                accountSid, to, from, getDateString(dateSentGte),
                getDateString(dateSentLt), page, pageSize);
        return returnThrows(response, SmsMessageList.class);
    }


    /**
     * Shows info on all SMS messages associated with an account.
     * @param to Filter by receiving number.
     * @param from Filter by sending number.
     * @param dateSentGte Filter by date sent greater or equal then.
     * @param dateSentLt Filter by date sent less than.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of SMS Messages
     * @throws ZangException
     */
    public SmsMessageList listSmsMessages(String to, String from,
                                          Date dateSentGte, Date dateSentLt, Integer page, Integer pageSize)
            throws ZangException {
        return listSmsMessages(conf.getSid(), to, from, dateSentGte,
                dateSentLt, page, pageSize);
    }


    /**
     * Returns info on up to 50 SMS messages associated with an account.
     * @return A list of SMS Messages
     * @throws ZangException
     */
    public SmsMessageList listSmsMessages() throws ZangException {
        return listSmsMessages(conf.getSid(), null, null, null, null, null,
                null);
    }

    /**
     * Sends an SMS Message.
     * @param accountSid Account SID
     * @param to Must be an SMS capable number. The value does not have to be in any specific format.
     * @param from Must be a Zang number associated with your account. The value does not have to be in any specific
     *             format.
     * @param body Text of the SMS to be sent.
     * @param statusCallback The URL that will be sent information about the SMS. Url length is limited to 200 characters.
     * @param statusCallbackMethod The HTTP method used to request the StatusCallback.
     * @param allowMultiple If the Body length is greater than 160 characters, the SMS will be sent as a multi-part SMS.
     * @return The sent SMS message.
     * @throws ZangException
     */
    public SmsMessage sendSmsMessage(String accountSid, String to, String from,
                                     String body, String statusCallback, HttpMethod statusCallbackMethod,
                                     Boolean allowMultiple) throws ZangException {
        Response response = proxy.sendSmsMessage(
                accountSid, to, from, body, statusCallback, statusCallbackMethod, allowMultiple);
        return returnThrows(response, SmsMessage.class);
    }


    /**
     * Sends an SMS Message.
     * @param to Must be an SMS capable number. The value does not have to be in any specific format.
     * @param from Must be a Zang number associated with your account. The value does not have to be in any specific
     *             format.
     * @param body Text of the SMS to be sent.
     * @param statusCallback The URL that will be sent information about the SMS. Url length is limited to 200 characters.
     * @param statusCallbackMethod The HTTP method used to request the StatusCallback.
     * @param allowMultiple If the Body length is greater than 160 characters, the SMS will be sent as a multi-part SMS.
     * @return The sent SMS message.
     * @throws ZangException
     */
    public SmsMessage sendSmsMessage(String to, String from, String body,
                                     String statusCallback, HttpMethod statusCallbackMethod,
                                     Boolean allowMultiple) throws ZangException {
        return sendSmsMessage(conf.getSid(), to, from, body, statusCallback, statusCallbackMethod, allowMultiple);
    }

}
