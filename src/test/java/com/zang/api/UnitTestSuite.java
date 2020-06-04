package com.zang.api;

import com.zang.api.unit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InboundXmlTest.class,
        CallsTest.class,
        SmsTest.class,
        MmsTest.class,
        UsagesTest.class,
        AccountsTest.class,
        ConferencesTest.class,
        ApplicationsTest.class,
        ApplicationClientsTest.class,
        SipDomainsTest.class,
        SipCredentialsTest.class,
        SipAclTest.class,
        IncomingPhoneNumbersTest.class,
        RecordingsTest.class,
        NotificationsTest.class,
        AvailablePhoneNumbersTest.class,
        TranscriptionsTest.class,
        CarrierServicesTest.class,
        FraudControlTest.class,
        UtilsTest.class,
        ErrorTest.class,
        PojoTest.class
})
public class UnitTestSuite {


}
