package com.zang.api.connectors;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

/**
 * The class used for all forms of communication with the Zang REST API. It can
 * be used to create connectors based on a default configuration provided to
 * this factory, or to create connectors with explicit configurations.
 */
public class ZangConnectorFactory {

	private ZangConfiguration conf;
	private ClientHttpEngine executor;

	/**
	 * Creates a new ZangConnectorFactory based on the provided configuration.
	 *
	 * @param conf
	 *            The configuration based on which the ZangConnectorFactory will be
	 *            created. All connectors created by this factory will use this
	 *            configuration.
	 * @see BasicZangConfiguration
	 * @see com.zang.api.configuration.PropertiesFileZangConfiguration
	 * @see ZangConfiguration
	 */
	public ZangConnectorFactory(ZangConfiguration conf) {
		this.conf = conf;
	}

	/**
	 * Creates a new ZangConnectorFactory based on the provided configuration with
	 * an explicit http executor defined.
	 * 
	 * @param conf
	 *            The configuration based on which the ZangConnectorFactory will be
	 *            created. All connectors created by this factory will use this
	 *            configuration.
	 * @param executor
	 *            The http executor used for making API calls.
	 */
	public ZangConnectorFactory(ZangConfiguration conf, ClientHttpEngine executor) {
		this.conf = conf;
		this.executor = executor;
	}

	/**
	 * Creates a connector for communicating with the Accounts endpoint
	 * 
	 * @return AccountsConnector
	 */
	public AccountsConnector getAccountsConnector() {
		return new AccountsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Accounts endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return AccountsConnector
	 */
	public static AccountsConnector getAccountsConnector(ZangConfiguration conf) {
		return new AccountsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Accounts endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return AccountsConnector
	 */
	public static AccountsConnector getAccountsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new AccountsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Usages endpoint
	 * 
	 * @return UsagesConnector
	 */
	public UsagesConnector getUsagesConnector() {
		return new UsagesConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Usages endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return UsagesConnector
	 */
	public static UsagesConnector getUsagesConnector(ZangConfiguration conf) {
		return new UsagesConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Usages endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return UsagesConnector
	 */
	public static UsagesConnector getUsagesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new UsagesConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Sms endpoint
	 * 
	 * @return SmsConnector
	 */
	public SmsConnector getSmsConnector() {
		return new SmsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Sms endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return SmsConnector
	 */
	public static SmsConnector getSmsConnector(ZangConfiguration conf) {
		return new SmsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Sms endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return SmsConnector
	 */
	public static SmsConnector getSmsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new SmsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Mms endpoint
	 * 
	 * @return MmsConnector
	 */
	public MmsConnector getMmsConnector() {
		return new MmsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Mms endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return MmsConnector
	 */
	public static MmsConnector getMmsConnector(ZangConfiguration conf) {
		return new MmsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Mms endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return SmsConnector
	 */
	public static MmsConnector getMmsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new MmsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Calls endpoint
	 * 
	 * @return CallsConnector
	 */
	public CallsConnector getCallsConnector() {
		return new CallsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Calls endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return CallsConnector
	 */
	public static CallsConnector getCallsConnector(ZangConfiguration conf) {
		return new CallsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Calls endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return CallsConnector
	 */
	public static CallsConnector getCallsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new CallsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Conferences endpoint
	 * 
	 * @return ConferencesConnector
	 */
	public ConferencesConnector getConferencesConnector() {
		return new ConferencesConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Conferences endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return ConferencesConnector
	 */
	public static ConferencesConnector getConferencesConnector(ZangConfiguration conf) {
		return new ConferencesConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Conferences endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return ConferencesConnector
	 */
	public static ConferencesConnector getConferencesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new ConferencesConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Applications endpoint
	 * 
	 * @return ApplicationsConnector
	 */
	public ApplicationsConnector getApplicationsConnector() {
		return new ApplicationsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Applications endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return ApplicationsConnector
	 */
	public static ApplicationsConnector getApplicationsConnector(ZangConfiguration conf) {
		return new ApplicationsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Applications endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return ApplicationsConnector
	 */
	public static ApplicationsConnector getApplicationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new ApplicationsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the ApplicationClients endpoint
	 * 
	 * @return ApplicationClientsConnector
	 */
	public ApplicationClientsConnector getApplicationClientsConnector() {
		return new ApplicationClientsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the ApplicationClients endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return ApplicationClientsConnector
	 */
	public static ApplicationClientsConnector getApplicationClientsConnector(ZangConfiguration conf) {
		return new ApplicationClientsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the ApplicationClients endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return ApplicationClientsConnector
	 */
	public static ApplicationClientsConnector getApplicationClientsConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new ApplicationClientsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Sip Domains endpoint
	 * 
	 * @return SipDomainsConnector
	 */
	public SipDomainsConnector getSipDomainsConnector() {
		return new SipDomainsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Sip Domains endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return SipDomainsConnector
	 */
	public static SipDomainsConnector getSipDomainsConnector(ZangConfiguration conf) {
		return new SipDomainsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Sip Domains endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return SipDomainsConnector
	 */
	public static SipDomainsConnector getSipDomainsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new SipDomainsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Sip Credentials endpoint
	 * 
	 * @return SipCredentialsConnector
	 */
	public SipCredentialsConnector getSipCredentialsConnector() {
		return new SipCredentialsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Sip Credentials endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return SipCredentialsConnector
	 */
	public static SipCredentialsConnector getSipCredentialsConnector(ZangConfiguration conf) {
		return new SipCredentialsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Sip Credentials endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return SipCredentialsConnector
	 */
	public static SipCredentialsConnector getSipCredentialsConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new SipCredentialsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Sip IP Access Control Lists
	 * endpoint
	 * 
	 * @return SipIpAccessControlListsConnector
	 */
	public SipIpAccessControlListsConnector getSipIpAccessControlListsConnector() {
		return new SipIpAccessControlListsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Sip IP Access Control Lists
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return SipIpAccessControlListsConnector
	 */
	public static SipIpAccessControlListsConnector getSipIpAccessControlListsConnector(ZangConfiguration conf) {
		return new SipIpAccessControlListsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Sip IP Access Control Lists
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return SipIpAccessControlListsConnector
	 */
	public static SipIpAccessControlListsConnector getSipIpAccessControlListsConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new SipIpAccessControlListsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Incoming Phone Numbers
	 * endpoint
	 * 
	 * @return IncomingPhoneNumbersConnector
	 */
	public IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector() {
		return new IncomingPhoneNumbersConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Incoming Phone Numbers
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return IncomingPhoneNumbersConnector
	 */
	public static IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector(ZangConfiguration conf) {
		return new IncomingPhoneNumbersConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Incoming Phone Numbers
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return IncomingPhoneNumbersConnector
	 */
	public static IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new IncomingPhoneNumbersConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Recordings endpoint
	 * 
	 * @return RecordingsConnector
	 */
	public RecordingsConnector getRecordingsConnector() {
		return new RecordingsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Recordings endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return RecordingsConnector
	 */
	public static RecordingsConnector getRecordingsConnector(ZangConfiguration conf) {
		return new RecordingsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Recordings endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return RecordingsConnector
	 */
	public static RecordingsConnector getRecordingsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new RecordingsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Notifications endpoint
	 * 
	 * @return NotificationsConnector
	 */
	public NotificationsConnector getNotificationsConnector() {
		return new NotificationsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Notifications endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return NotificationsConnector
	 */
	public static NotificationsConnector getNotificationsConnector(ZangConfiguration conf) {
		return new NotificationsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Notifications endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return NotificationsConnector
	 */
	public static NotificationsConnector getNotificationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new NotificationsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Available Phone Numbers
	 * endpoint
	 * 
	 * @return AvailablePhoneNumbersConnector
	 */
	public AvailablePhoneNumbersConnector getAvailablePhoneNumbersConnector() {
		return new AvailablePhoneNumbersConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Available Phone Numbers
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return AvailablePhoneNumbersConnector
	 */
	public static AvailablePhoneNumbersConnector getAvailablePhoneNumbersConnector(ZangConfiguration conf) {
		return new AvailablePhoneNumbersConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Available Phone Numbers
	 * endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return AvailablePhoneNumbersConnector
	 */
	public static AvailablePhoneNumbersConnector getAvailablePhoneNumbersConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new AvailablePhoneNumbersConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Transcriptions endpoint
	 * 
	 * @return TranscriptionsConnector
	 */
	public TranscriptionsConnector getTranscriptionsConnector() {
		return new TranscriptionsConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Transcriptions endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return TranscriptionsConnector
	 */
	public static TranscriptionsConnector getTranscriptionsConnector(ZangConfiguration conf) {
		return new TranscriptionsConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Transcriptions endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return TranscriptionsConnector
	 */
	public static TranscriptionsConnector getTranscriptionsConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new TranscriptionsConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Carrier Services endpoint
	 * 
	 * @return CarrierServicesConnector
	 */
	public CarrierServicesConnector getCarrierServicesConnector() {
		return new CarrierServicesConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Carrier Services endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return CarrierServicesConnector
	 */
	public static CarrierServicesConnector getCarrierServicesConnector(ZangConfiguration conf) {
		return new CarrierServicesConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Carrier Services endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return CarrierServicesConnector
	 */
	public static CarrierServicesConnector getCarrierServicesConnector(ZangConfiguration conf,
			ClientHttpEngine executor) {
		return new CarrierServicesConnector(conf, executor);
	}

	/**
	 * Creates a connector for communicating with the Fraud Control endpoint
	 * 
	 * @return FraudControlConnector
	 */
	public FraudControlConnector getFraudControlConnector() {
		return new FraudControlConnector(this.conf, this.executor);
	}

	/**
	 * Creates a connector for communicating with the Fraud Control endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @return FraudControlConnector
	 */
	public static FraudControlConnector getFraudControlConnector(ZangConfiguration conf) {
		return new FraudControlConnector(conf, null);
	}

	/**
	 * Creates a connector for communicating with the Fraud Control endpoint
	 * 
	 * @param conf
	 *            Explicit configuration to use with this connector
	 * @param executor
	 *            Explicit http executor to use with this connector
	 * @return FraudControlConnector
	 */
	public static FraudControlConnector getFraudControlConnector(ZangConfiguration conf, ClientHttpEngine executor) {
		return new FraudControlConnector(conf, executor);
	}
}
