package com.zang.api.testutil;

import com.zang.api.configuration.ZangConfiguration;

public class MockConfiguration implements ZangConfiguration {

    private int mockServerPort;

    public MockConfiguration(int mockServerPort) {

        this.mockServerPort = mockServerPort;
    }

    @Override
    public String getSid() {
        return "TestAccountSid";
    }

    @Override
    public String getAuthToken() {
        return "TestToken";
    }

    @Override
    public String getBaseUrl() {
        return "http://localhost:" + mockServerPort;
    }

    @Override
    public String getProxyHost() {
        return null;
    }

    @Override
    public String getProxyPort() {
        return null;
    }

    @Override
    public String getProxyProtocol() {
        return null;
    }

}
