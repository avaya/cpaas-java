package com.zang.api.unit;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.zang.api.connectors.FraudControlConnector;
import com.zang.api.domain.list.FraudControlRulesList;
import com.zang.api.exceptions.ZangException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.io.IOException;

public class ErrorTest extends BaseUnitTest {

    private FraudControlConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getFraudControlConnector();
    }

    @Test
    public void shouldThrowException() throws ZangException, IOException {
        String responseBody = Resources.toString(BaseUnitTest.class.getResource("/error/error.json"), Charsets.UTF_8);
        mockServer.when(HttpRequest.request())
                .respond(HttpResponse.response()
                        .withHeaders(
                                new Header("Content-Type", "application/json")
                        )
                        .withStatusCode(400)
                        .withBody(responseBody));
        try {
            FraudControlRulesList result = connector.listFraudControlResources(0, 22);
            Assert.fail();
        } catch (ZangException ex) {
            Assert.assertEquals(400, (int)ex.getStatus());
            Assert.assertEquals("Country could not be authorized", ex.getMessage());
            Assert.assertEquals(70001, (int)ex.getCode());
            Assert.assertEquals("http://www.telapi.com/docs/api/rest/overview/errors/70001", ex.getMoreInfo());
        }

    }

}
