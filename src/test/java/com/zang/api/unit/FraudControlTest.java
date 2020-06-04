package com.zang.api.unit;

import com.zang.api.connectors.FraudControlConnector;
import com.zang.api.domain.FraudControlRule;
import com.zang.api.domain.list.FraudControlRulesList;
import com.zang.api.exceptions.ZangException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class FraudControlTest extends BaseUnitTest {

    private FraudControlConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getFraudControlConnector();
    }

    @Test
    public void listFraudControlResources() throws ZangException, IOException {
        createExpectation("FraudControlTest", "listFraudControlResources");
        FraudControlRulesList result = connector.listFraudControlResources(0, 22);
        Assert.assertEquals(2, result.getAuthorized().size());
        Assert.assertEquals("FR", result.getAuthorized().get(1).getCountryCode());
    }

    @Test
    public void blockDestination() throws ZangException, IOException {
        createExpectation("FraudControlTest", "blockDestination");
        FraudControlRule rule = connector.blockDestination("HR", false, true, false);
        checkRule(rule);
    }

    @Test
    public void authorizeDestination() throws ZangException, IOException {
        createExpectation("FraudControlTest", "authorizeDestination");
        FraudControlRule rule = connector.authorizeDestination("HR", false, true, false);
        checkRule(rule);
    }

    @Test
    public void extendDestinationAuthorization() throws ZangException, IOException {
        createExpectation("FraudControlTest", "extendDestinationAuthorization");
        FraudControlRule rule = connector.extendDestinationAuthorization("HR");
        checkRule(rule);
    }

    @Test
    public void whitelistDestination() throws ZangException, IOException {
        createExpectation("FraudControlTest", "whitelistDestination");
        FraudControlRule rule = connector.whitelistDestination("HR", false, true, false);
        checkRule(rule);
    }


    private void checkRule(FraudControlRule rule) {
        Assert.assertEquals("TestFraudControlRuleSid", rule.getSid());
    }

}
