package com.zang.api.unit;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.testutil.MockConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.*;
import org.mockserver.socket.PortFactory;

import java.io.IOException;

public abstract class BaseUnitTest {

    ZangConfiguration conf;
    ZangConnectorFactory connectorFactory;

    static ClientAndProxy proxy;
    ClientAndServer mockServer;

    private int serverPort = 41123;

    protected static JSONObject testData;

    static {
        try {
            String tests = Resources.toString(BaseUnitTest.class.getResource("/unittests.json"), Charsets.UTF_8);
            JSONParser parser = new JSONParser();
            testData = (JSONObject) parser.parse(tests);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public BaseUnitTest() {
        conf = new MockConfiguration(serverPort);
        connectorFactory = new ZangConnectorFactory(conf);

    }

    @BeforeClass
    public static void startProxy() {
        proxy = ClientAndProxy.startClientAndProxy(PortFactory.findFreePort());
    }

    @AfterClass
    public static void stopProxy() {
        proxy.stop();
    }

    @Before
    public void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(serverPort);
        proxy.reset();
    }

    @After
    public void stopMockServer() {
        mockServer.stop();
    }

    protected void createExpectation(String group, String test) throws IOException {
        JSONObject groupData = (JSONObject) testData.get(group);
        JSONObject testData = (JSONObject)groupData.get(test);
        String method = (String)testData.get("method");
        String path = (String)testData.get("path");
        Parameter[] queryParams = parseParams((JSONArray)testData.get("queryParams"));
        Parameter[] bodyParams = parseParams((JSONArray)testData.get("bodyParams"));
        String responseFile = (String)testData.get("response");
        createExpectation(method, path, bodyParams, queryParams, responseFile);
    }
    private Parameter[] parseParams(JSONArray jsonParams) {
        if (jsonParams == null) return null;
        Parameter[] params = new Parameter[jsonParams.size()];
        for(int i = 0; i < jsonParams.size(); i++) {
            params[i] = new Parameter((String) ((JSONObject)jsonParams.get(i)).get("name"),
                    (String) ((JSONObject)jsonParams.get(i)).get("value"));
        }
        return params;
    }
    protected void createExpectation(String method, String path,
                                     Parameter[] bodyParams, Parameter[] queryParams,
                                     String responseFile) throws IOException {
        if (path.equals("Accounts")) {
            path = "Accounts/" + conf.getSid() + ".json";
        } else {
            path = "Accounts/" + conf.getSid() + "/" + path;
        }
        if (bodyParams == null) bodyParams = new Parameter[]{};
        if (queryParams == null) queryParams = new Parameter[]{};
        String responseBody = Resources.toString(BaseUnitTest.class.getResource(responseFile), Charsets.UTF_8);
        mockServer.when(HttpRequest
                .request()
                .withMethod(method)
                .withPath("/" + path)
                .withQueryStringParameters(queryParams)
                .withBody(
                        new ParameterBody(bodyParams)
                )
        )
                .respond(HttpResponse.response()
                        .withHeaders(
                                new Header("Content-Type", "application/json")
                        )
                        .withBody(responseBody));
    }

}
