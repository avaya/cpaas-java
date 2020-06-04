package com.zang.api;

import com.zang.api.it.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CallsIT.class,
        CarrierServicesIT.class,
        NotificationsIT.class,
        PhoneNumbersIT.class,
        RecordingsIT.class,
        SipIT.class,
        TranscriptionIT.class,
        UsageIT.class
})
public class IntegrationTestSuite {


}
