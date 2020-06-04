package com.zang.api.testutil;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class TestParameters extends Properties {
    private static final long serialVersionUID = -7348144965758395514L;

    private static Date fromDate;
    private static Date toDate;

    static {
        Calendar from = Calendar.getInstance();
        from.set(2016, Calendar.DECEMBER, 12);
        fromDate = from.getTime();
        Calendar to = Calendar.getInstance();
        to.set(2017, Calendar.MARCH, 19);
        toDate = to.getTime();
    }

    public TestParameters() {
        this("zang.test.properties");
    }

    protected TestParameters(String propFileName) {
        URL url = ClassLoader.getSystemResource(propFileName);
        try {
            load(url.openStream());
        } catch (IOException e) {
            System.out.println("Error: Cannot load or find Zang test properties file on classpath: " + propFileName + e);
        }
    }

    public String getPhone1() {
        return getProperty("phone1");
    }

    public String getArea1() {
        return getProperty("area1");
    }

    public String getPhone2() {
        return getProperty("phone2");
    }

    public String getArea2() {
        return getProperty("area2");
    }

    public String getMp3Url() {
        return getProperty("mp3url");
    }

    public String getInboundXmlUrl() { return getProperty("inboundxmlurl"); }

    public static Date getFromDate() {
        return fromDate;
    }

    public static Date getToDate() {
        return toDate;
    }
}
