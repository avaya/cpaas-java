package com.zang.api.it;

import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.exceptions.ZangException;
import com.zang.api.testutil.IntegrationTest;
import com.zang.api.testutil.TestParameters;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public abstract class BaseIntegrationTest {

    ZangConfiguration conf;
    TestParameters testParameters;
    ZangConnectorFactory connectorFactory;

    public BaseIntegrationTest() throws ZangException {
        this.testParameters = new TestParameters();
        conf = new PropertiesFileZangConfiguration();
        connectorFactory = new ZangConnectorFactory(conf);

    }

    protected void sleep() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}
