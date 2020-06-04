package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListUsagesParams;
import com.zang.api.restproxies.UsagesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;

/**
 * Used for all forms of communication with the Usages endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class UsagesConnector extends BaseConnector {

    private UsagesProxy proxy;

     UsagesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(UsagesProxy.class);
    }

    /**
     * View the usage of an item returned by List Usages
     * @param accountSid Account SID
     * @param usageSid Usages SID
     * @return Information about the Usage.
     * @throws ZangException
     */
    public Usage viewUsage(String accountSid, String usageSid) throws ZangException {
        Response response = proxy.getUsage(accountSid, usageSid);
        return returnThrows(response, Usage.class);
    }

    /**
     * View the usage of an item returned by List Usages
     * @param usageSid Usages SID
     * @return Information about the Usage.
     * @throws ZangException
     */
    public Usage viewUsage(String usageSid) throws ZangException {
        return viewUsage(conf.getSid(), usageSid);
    }

    /**
     * Lists usages associated with an account.
     * @param accountSid Account SID
     * @param day Filters usage by day of month. If no month is specified then defaults to current month. Allowed
     *            values are integers between 1 and 31 depending on the month.
     * @param month Filters usage by month. Allowed values are integers between 1 and 12.
     * @param year Filters usage by year. Allowed values are valid years in integer form.
     * @param product Filters usage by a specific Zang product.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Usages
     * @throws ZangException
     */
    public UsagesList listUsages(String accountSid, Integer day, Integer month, Integer year,
                                 Product product, Integer page, Integer pageSize) throws ZangException {
        Integer productCode = null;
        if (product != null && product != Product.UNKNOWN) {
            productCode = Integer.parseInt(product.toString());
        }
        Response usages = proxy.listUsages(accountSid, day, month, year,
                productCode, page, pageSize);
        return returnThrows(usages, UsagesList.class);
    }

    /**
     * Lists usages associated with your account.
     * @param day Filters usage by day of month. If no month is specified then defaults to current month. Allowed
     *            values are integers between 1 and 31 depending on the month.
     * @param month Filters usage by month. Allowed values are integers between 1 and 12.
     * @param year Filters usage by year. Allowed values are valid years in integer form.
     * @param product Filters usage by a specific Zang product.
     * @param page Page to return
     * @param pageSize Number of items to return per page
     * @return A list of Usages
     * @throws ZangException
     */
    public UsagesList listUsages(Integer day, Integer month, Integer year,
                                 Product product, Integer page, Integer pageSize) throws ZangException {
        return listUsages(conf.getSid(), day, month, year, product, page, pageSize);
    }

    /**
     * Returns up to 50 usages associated with your account.
     * @return A list of Usages
     * @throws ZangException
     */
    public UsagesList listUsages() throws ZangException {
        return listUsages(conf.getSid(), null, null, null, null, null, null);
    }

    /**
     * Lists usages associated with your account.
     * @param listUsagesParams Parameters by which to list usages.
     * @return A List of Usages.
     * @throws ZangException
     */
    public UsagesList listUsages(ListUsagesParams listUsagesParams) throws ZangException {
        return listUsages(listUsagesParams.getAccountSid() != null ? listUsagesParams.getAccountSid() : conf.getSid(), listUsagesParams.getDay(), listUsagesParams.getMonth(), listUsagesParams.getYear(),
                listUsagesParams.getProduct(), listUsagesParams.getPage(), listUsagesParams.getPageSize());
    }

}
