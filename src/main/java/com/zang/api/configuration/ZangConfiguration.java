package com.zang.api.configuration;

/**
 * The basic interface which must return the Zang configuration parameters.
 */
public interface ZangConfiguration {
    /**
     * @return The account Sid.
     */
    public String getSid();

    /**
     * @return The authorization token.
     */
    public String getAuthToken();

    /**
     * @return The base URL. This should be "https://api.zang.io/v2" by default.
     */
    public String getBaseUrl();

    /**
     * @return The proxy host (e.g. "192.168.0.1"). Leave null or empty if no proxy is to be used.
     */
    public String getProxyHost();

    /**
     * @return The proxy port (e.g. 8080). Ignored if no proxy host is set.
     */
    public String getProxyPort();

    /**
     * @return The proxy protocol (e.g. "http"). Ignored if no proxy host is set.
     */
    public String getProxyProtocol();
}
