package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.FraudControlRule;
import com.zang.api.domain.FraudControlRuleElement;
import com.zang.api.domain.enums.FraudControlType;
import com.zang.api.domain.list.FraudControlRulesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.FraudControlProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.ArrayList;


/**
 * Used for all forms of communication with the Fraud Control endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class FraudControlConnector extends BaseConnector {

    private FraudControlProxy proxy;

    FraudControlConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(FraudControlProxy.class);
    }


    /**
     * Restricts outbound calls and sms messages to some destination.
     * @param accountSid Account SID
     * @param countryCode Country code of destination which you want to restrict.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule blockDestination(String accountSid, String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        FraudControlRuleElement element = returnThrows(proxy.blockDestination(accountSid, countryCode, mobileEnabled, landlineEnabled, smsEnabled), FraudControlRuleElement.class);
        if (element.getBlocked() == null) return null;
        element.getBlocked().setType(FraudControlType.BLOCKED);
        return element.getBlocked();
    }

    /**
     * Restricts outbound calls and sms messages to some destination.
     * @param countryCode Country code of destination which you want to restrict.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule blockDestination(String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        return blockDestination(conf.getSid(), countryCode, mobileEnabled, landlineEnabled, smsEnabled);
    }


    /**
     * Authorizes previously blocked destination for outbound calls and sms messages.
     * @param accountSid Account SID
     * @param countryCode Country code of destination which you want to authorize.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule authorizeDestination(String accountSid, String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        FraudControlRuleElement element = returnThrows(proxy.authorizeDestination(accountSid, countryCode, mobileEnabled, landlineEnabled, smsEnabled), FraudControlRuleElement.class);
        if (element.getAuthorized() == null) return null;
        element.getAuthorized().setType(FraudControlType.AUTHORIZED);
        return element.getAuthorized();
    }

    /**
     * Authorizes previously blocked destination for outbound calls and sms messages.
     * @param countryCode Country code of destination which you want to authorize.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule authorizeDestination(String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        return authorizeDestination(conf.getSid(), countryCode, mobileEnabled, landlineEnabled, smsEnabled);
    }


    /**
     * Extends a destinations authorization expiration by 30 days
     * @param accountSid Account SID
     * @param countryCode Country code of destination for which you want to extend authorization.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule extendDestinationAuthorization(String accountSid, String countryCode) throws ZangException {
        FraudControlRuleElement element = returnThrows(proxy.extendDestinationAuthorization(accountSid, countryCode), FraudControlRuleElement.class);
        if (element.getAuthorized() == null) return null;
        element.getAuthorized().setType(FraudControlType.AUTHORIZED);
        return element.getAuthorized();
    }

    /**
     * Extends a destinations authorization expiration by 30 days
     * @param countryCode Country code of destination for which you want to extend authorization.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule extendDestinationAuthorization(String countryCode) throws ZangException {
        return extendDestinationAuthorization(conf.getSid(), countryCode);
    }


    /**
     * Permanently authorizes destination that may have been blocked by the automated fraud detection system
     * @param accountSid Account SID
     * @param countryCode Country code of destination which you want to authorize.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule whitelistDestination(String accountSid, String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        FraudControlRuleElement element = returnThrows(proxy.whitelistDestination(accountSid, countryCode, mobileEnabled, landlineEnabled, smsEnabled), FraudControlRuleElement.class);
        if (element.getWhitelisted() == null) return null;
        element.getWhitelisted().setType(FraudControlType.WHITELISTED);
        return element.getWhitelisted();
    }

    /**
     * Permanently authorizes destination that may have been blocked by the automated fraud detection system
     * @param countryCode Country code of destination which you want to authorize.
     * @param mobileEnabled Mobile status for the destination. If false, all mobile call activity will be rejected
     *                      or disabled.
     * @param landlineEnabled Landline status for the destination. If false, all landline call activity will be
     *                        rejected or disabled.
     * @param smsEnabled SMS status for the destination. If false, all SMS activity will be rejected or disabled.
     * @return The created Fraud control rule
     * @throws ZangException
     */
    public FraudControlRule whitelistDestination(String countryCode, Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled) throws ZangException {
        return whitelistDestination(conf.getSid(), countryCode, mobileEnabled, landlineEnabled, smsEnabled);
    }


    /**
     * Shows information on all fraud control resources associated with an account.
     * @param accountSid Account SID
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Fraud Control rules.
     * @throws ZangException
     */
    public FraudControlRulesList listFraudControlResources(String accountSid, Integer page, Integer pageSize) throws ZangException {
        FraudControlRulesList rules = returnThrows(proxy.listFraudControlResources(accountSid, page, pageSize), FraudControlRulesList.class);
        if (rules == null) return null;
        rules.setAuthorized(new ArrayList<FraudControlRule>());
        rules.setBlocked(new ArrayList<FraudControlRule>());
        rules.setWhitelisted(new ArrayList<FraudControlRule>());
        for (FraudControlRuleElement element : rules) {
            FraudControlRule authorizedRule = element.getAuthorized();
            FraudControlRule blockedRule = element.getBlocked();
            FraudControlRule whitelistedRule = element.getWhitelisted();
            if (authorizedRule != null) {
                authorizedRule.setType(FraudControlType.AUTHORIZED);
                rules.getAuthorized().add(authorizedRule);
            } else if (blockedRule != null) {
                blockedRule.setType(FraudControlType.BLOCKED);
                rules.getBlocked().add(blockedRule);
            } else if (whitelistedRule != null) {
                whitelistedRule.setType(FraudControlType.WHITELISTED);
                rules.getWhitelisted().add(whitelistedRule);
            }
        }
        return rules;
    }

    /**
     * Shows information on all fraud control resources associated with your account.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return List of Fraud Control rules.
     * @throws ZangException
     */
    public FraudControlRulesList listFraudControlResources(Integer page, Integer pageSize) throws ZangException {
        return listFraudControlResources(conf.getSid(), page, pageSize);
    }
}
