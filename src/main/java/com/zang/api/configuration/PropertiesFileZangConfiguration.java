package com.zang.api.configuration;

import com.zang.api.exceptions.ZangException;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * A ZangConfiguration implementation which loads the configuration from a file.
 *
 * @see ZangConfiguration
 */
public class PropertiesFileZangConfiguration extends Properties implements ZangConfiguration {
    private static final long serialVersionUID = -7348144965758395514L;

    /**
     * Creates a ZangConfiguration from a file called "zang.properties" which must be on the classpath.
     */
    public PropertiesFileZangConfiguration() throws ZangException {
        this("zang.properties");
    }

    /**
     * Creates a ZangConfiguration from a file which must be on the classpath.
     *
     * @param propFileName The fileName of the properties file.
     */
    public PropertiesFileZangConfiguration(String propFileName) throws ZangException {
        URL url = ClassLoader.getSystemResource(propFileName);
        if (url == null) throw new ZangException("Cannot find properties file");
        try {
            load(url.openStream());
        } catch (IOException e) {
            throw new ZangException("Properties file not found.", e);
        }
    }

    /**
     * Creates a ZangConfiguration by loading properties from the provided FileInputStream.
     *
     * @param is The FileInputStream from which to load the configuration.
     */
    public PropertiesFileZangConfiguration(FileInputStream is) throws ZangException {
        try {
            load(is);
        } catch (IOException e) {
            throw new ZangException("Cannot load the specified properties file.", e);
        }
    }

    @Override
    public String getSid() {
        return getProperty("sid");
    }

    @Override
    public String getAuthToken() {
        return getProperty("authToken");
    }

    @Override
    public String getBaseUrl() {
        return getProperty("baseUrl", ZangConstants.BASE_URL);
    }

    @Override
    public String getProxyHost() {
        return getProperty("proxyHost", null);
    }

    @Override
    public String getProxyPort() {
        return getProperty("proxyPort", null);
    }

    @Override
    public String getProxyProtocol() {
        return getProperty("proxyProtocol", null);
    }


}
