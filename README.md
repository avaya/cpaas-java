cpaas-java
==========

This java library is an open source tool built to simplify interaction with the [Avaya OneCloud CPaaS](https://www.avaya.com/en/products/cloud/cpaas/) telephony platform. Avaya CPaaS makes adding voice and SMS to applications fun and easy.

For more information about CPaaS, please visit: [Avaya OneCloud CPaaS](https://www.avaya.com/en/products/cloud/cpaas/)

To read the official documentation, please visit: [CPaaS Docs](https://docs.avayacloud.com/aspx/docs)

Your CPaaS account contains your AccountSid and AuthToken.

---


Installation
============

Clone the repo, and install via [maven](http://maven.apache.org/download.html):
```
$ git clone git@github.com:avaya/cpaas-java.git
$ cd cpaas-java
$ mvn install
```

If you are using JDK 11, you might need to include below in the pom.xml:
```
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.2.3</version>
</dependency>
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>2.3.2</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.2</version>
</dependency>
```

To use this library, include the following dependency within pom.xml:

```
<dependency>
  <groupId>com.zang.api</groupId>
  <artifactId>zang-java</artifactId>
  <version>1.1.0</version>
</dependency>
```


Usage
======

### REST

See the [CPaaS REST API documentation](https://docs.avayacloud.com/aspx/rest) for more information.

Some sample examples are given below. For more sample code, check the directory src/test/java/com/zang/api/examples

#### Send SMS Example

```java
package com.zang.api.examples;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;

public class SmsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        SmsConnector conn = ZangConnectorFactory.getSmsConnector(conf);

        //send sms message
        try {
            SmsMessage sentSmsMessage = conn
                    .sendSmsMessage(
                            "(XXX) XXX-XXXX",
                            "(XXX) XXX-XXXX",
                            "This is an SMS message sent from the CPaaS Java helper! Easy as 1, 2, 3!",
                            null, null, null);
            System.out.println(sentSmsMessage.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }
}
        
```
#### Configuration

First a configuration must be created by using one of the provided configuration classes (`BasicZangConfiguration`, `PropertiesFileZangConfiguration`) or by creating your own implementation with the `ZangConfiguration` interface.

Normally you'll want to just enter your CPaaS *AccountSid* and *AuthToken*, but you can also define a proxy server or change the base API URL.

Next you'll have to create a connector by using `ZangConnectorFactory`. This can be done in multiple ways. The usual way is to instantiate `ZangConnectorFactory`, pass the configuration object to the factory and have it instantiate `ZangConnector` objects:
```java
ZangConnectorFactory zangConnectorFactory = new ZangConnectorFactory(conf);
CallsConnector callsConnector = zangConnectorFactory.getCallsConnector();
callsConnector.makeCall(...);
```
Alternatively you can create a connector directly like this:
```java
CallsConnector callsConnector = ZangConnectorFactory.getCallsConnector(conf);
```
Besides the configuration parameter you can also specify a custom `ClientHttpEngine` both for the whole factory or for a specific connector. If a custom `ClientHttpEngine` is used, the proxy server configuration parameters aren't used. 

#### Request parameters
Request parameters are passed as parameters to connector object methods as shown previously. All methods have convenience overloads which use the `AccountSid` parameter specified in the configuration automatically:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
//explicit accountSid
Usage usage = connector.viewUsage("{accountSid}", "{UsageSid}");
//accountSid from configuration used automatically
Usage usage = connector.viewUsage("{UsageSid}");
```
Methods with a large number of possible parameters have convenience builder objects, e.g.:
```java
CallsConnector connector = connectorFactory.getCallsConnector();
Call call = connector.makeCall(MakeCallParams.builder()
	.setTo("+123456")
    .setFrom("+654321")
    .setUrl("{InboundXmlUrl}")
    .setRecord(true)
    .setRecordCallback("{RecordCallbackUrl}")
    .build()
);
```

#### Response data
The received data can be an object, e.g.:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
Usage usage = connector.viewUsage("{UsageSid}");
System.out.println(usage.getTotalCost());
```
Or a list of objects in which case the list is iterable, e.g.:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
ListUsagesParams params = ListUsagesParams.builder()
	.setPage(0)
    .setPageSize(25)
    .setProduct(Product.OUTBOUND_SMS)
    .setDay(12)
    .setMonth(12)
    .setYear(2016)
    .build();
    
UsagesList list = connector.listUsages(params);
for(Usage usage : list) {
	System.out.println(usage.getTotalCost());
}

```


### InboundXML

InboundXML is an XML dialect which enables you to control phone call flow. For more information please visit the [CPaaS InboundXML documentation](https://docs.avayacloud.com/aspx/inboundxml).

##### <Say> Example

```java
package com.zang.api.examples;

import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.ZangInboundXml;
import com.zang.api.inboundxml.elements.Say;
import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

public class InboundXmlExample {

    public static void main(String[] args) {
        try {
            String result = ZangInboundXml.builder()
                    .say(Say.builder()
                            .setLanguage(Language.EN)
                            .setLoop(3)
                            .setText("Welcome to Avaya CPaaS!")
                            .setVoice(Voice.FEMALE)
                            .build())
                    .build()
                    .toXml();
            System.out.println(result);
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }

}
 
```

will render

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Response>
    <Say loop="3" voice="female" language="en">Welcome to Zang!</Say>
</Response>
```

#### Calls Example

```java
package com.zang.api.examples;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;

package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.CallsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.*;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.MakeCallParams;
import com.zang.api.testutil.TestParameters;

public class CallsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        CallsConnector connector = ZangConnectorFactory.getCallsConnector(conf);

        // list calls
        try {
            CallsList callsList = connector.listCalls(
                    "+123456",
                    "+654321",
                    CallStatus.COMPLETED,
                    TestParameters.getFromDate(),
                    TestParameters.getToDate(),
                    0,
                    10);
            System.out.println(callsList.getTotal());
        } catch (ZangException e) {
            e.printStackTrace();
        }

        //make call
        try {
            MakeCallParams makeCallParams = MakeCallParams.builder()
                    .setTo("+123456")
                    .setFrom("+654321")
                    .setUrl("TestUrl")
                    .setMethod(HttpMethod.GET)
                    .setFallbackUrl("FallbackUrl")
                    .setFallbackMethod(HttpMethod.POST)
                    .setStatusCallback("StatusCallback")
                    .setStatusCallbackMethod(HttpMethod.GET)
                    .setHeartbeatUrl("HeartbeatUrl")
                    .setHeartbeatMethod(HttpMethod.GET)
                    .setForwardedFrom("1234")
                    .setPlayDtmf("123#")
                    .setTimeout(122)
                    .setHideCallerId(true)
                    .setRecord(true)
                    .setRecordCallback("RecordCallback")
                    .setRecordCallbackMethod(HttpMethod.GET)
                    .setTranscribe(true)
                    .setTranscribeCallback("TranscribeCallback")
                    .setStraightToVoicemail(true)
                    .setIfMachine(IfMachine.REDIRECT)
                    .setIfMachineUrl("IfMachineUrl")
                    .setIfMachineMethod(HttpMethod.GET)
                    .setSipAuthUsername("username")
                    .setSipAuthPassword("password")
                    .build();
            Call call = connector.makeCall(makeCallParams);
            System.out.println(call.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }
        //play audio to live call
        try {
            Call call = connector.playAudioToLiveCall("TestCallSid", "AudioUrl", RecordingAudioDirection.BOTH, true);
            System.out.println(call.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }


        //apply voice effects : specify the value of the effects to change.
        // Use Doube.NaN for not changed effects.

        // Set Pitch to 1.3
        try {
            Call call = connector.applyVoiceEffect("TestCallSid", AudioDirection.OUT, 1.3, Double.NaN, Double.NaN, Double.NaN, Double.NaN);
            System.out.println(call.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }
        // Set tempo to 10
        try {
            Call call = connector.applyVoiceEffect("TestCallSid", AudioDirection.OUT, Double.NaN, Double.NaN, Double.NaN, Double.NaN, 10.0);
            System.out.println(call.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }
        // Set all effects at once
        try {
            Call call = connector.applyVoiceEffect("TestCallSid", AudioDirection.OUT, 5.0, 4.2, -0.5, 2.0, 10.0);
            System.out.println(call.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
        
```
