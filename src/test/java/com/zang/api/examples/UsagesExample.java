package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.UsagesConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListUsagesParams;

import java.math.BigDecimal;

public class UsagesExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        UsagesConnector conn = new ZangConnectorFactory(conf).getUsagesConnector();

        //view usage
        try {
            //get a specific usage
            Usage usage = conn.viewUsage("{UsageSid}");
            System.out.println(usage.getTotalCost());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //list usages
        try {
            ListUsagesParams usagesRequest = ListUsagesParams.builder()
                    .setProduct(Product.OUTBOUND_SMS)
                    .setYear(2017)
                    .setMonth(2)
                    .setPageSize(100)
                    .build();
            UsagesList usagesList = conn.listUsages(usagesRequest);
            BigDecimal total = BigDecimal.ZERO;
            for (Usage usage : usagesList) {
                total = total.add(usage.getTotalCost());
            }
            System.out.println(total);
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }

}
