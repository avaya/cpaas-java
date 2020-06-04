package com.zang.api.unit;

import com.google.common.io.Resources;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.exceptions.ZangException;
import com.zang.api.json.JsonBooleanParser;
import com.zang.api.json.JsonDateParser;
import com.zang.api.json.JsonDurationParser;
import com.zang.api.testutil.MockJsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class UtilsTest {

    @Test
    public void testPropertiesFileZangConfiguration() throws ZangException, IOException {
        PropertiesFileZangConfiguration testConf = new PropertiesFileZangConfiguration("fortesting.properties");
        testProps(testConf);
        testConf = new PropertiesFileZangConfiguration(new FileInputStream(Resources.getResource("fortesting.properties").getFile()));
        testProps(testConf);
    }

    @Test(expected = ZangException.class)
    public void testMissingPropertyFile() throws ZangException {
        new PropertiesFileZangConfiguration("not_existing");
    }

    @Test
    public void testBasicConfiguration() throws ZangException, IOException {
        BasicZangConfiguration testConf = new BasicZangConfiguration("sid", "token");
        Assert.assertEquals("sid", testConf.getSid());
        Assert.assertEquals("token", testConf.getAuthToken());
    }


    private void testProps(PropertiesFileZangConfiguration testConf) {
        Assert.assertEquals("test", testConf.getAuthToken());
        Assert.assertEquals("test", testConf.getBaseUrl());
        Assert.assertEquals("test", testConf.getSid());
        Assert.assertEquals("test", testConf.getProxyHost());
        Assert.assertEquals("test", testConf.getProxyPort());
        Assert.assertEquals("test", testConf.getProxyProtocol());
    }

    @Test
    public void testParsers() throws IOException {
        Assert.assertTrue(new JsonBooleanParser().deserialize(new MockJsonParser("TRUE"), null));
        Assert.assertFalse(new JsonBooleanParser().deserialize(new MockJsonParser("FALSE"), null));
        Assert.assertNull(new JsonBooleanParser().deserialize(new MockJsonParser(null), null));
        Assert.assertNull(new JsonBooleanParser().deserialize(new MockJsonParser("unknown"), null));

        Assert.assertEquals(12, (int)new JsonDurationParser().deserialize(new MockJsonParser("12"), null));
        Assert.assertEquals(0, (int)new JsonDurationParser().deserialize(new MockJsonParser("nan"), null));
        Assert.assertNull(new JsonDurationParser().deserialize(new MockJsonParser(null), null));

        Date date = new JsonDateParser().deserialize(new MockJsonParser("Thu, 23 Mar 2017 14:57:36 -0000"), null);
        Assert.assertEquals(1490281056000L, date.getTime());
        Assert.assertNull(new JsonDateParser().deserialize(new MockJsonParser(null), null));
        Assert.assertNull(new JsonDateParser().deserialize(new MockJsonParser("invalid_date"), null));


    }


}
