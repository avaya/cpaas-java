package com.zang.api.unit;

import com.zang.api.connectors.CarrierServicesConnector;
import com.zang.api.domain.BnaLookup;
import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.CnamLookup;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class CarrierServicesTest extends BaseUnitTest {

    private CarrierServicesConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getCarrierServicesConnector();
    }

    @Test
    public void carrierLookup() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "carrierLookup");
        checkCarrierLookup(connector.carrierLookup("+1234").iterator().next());
    }

    @Test
    public void listCarrierLookups() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "listCarrierLookups");
        checkCarrierLookup(connector.listCarrierLookups(0, 33).iterator().next());
    }

    @Test
    public void cnamLookup() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "cnamLookup");
        checkCnamLookup(connector.cnamLookup("+1234").iterator().next());
    }

    @Test
    public void listCnamLookups() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "listCnamLookups");
        checkCnamLookup(connector.listCnamLookups(0, 33).iterator().next());
    }

    @Test
    public void bnaLookup() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "bnaLookup");
        checkBnaLookup(connector.bnaLookup("+1234").iterator().next());
    }

    @Test
    public void listBnaLookups() throws ZangException, IOException {
        createExpectation("CarrierServicesTest", "listBnaLookups");
        checkBnaLookup(connector.listBnaLookups(0, 33).iterator().next());
    }


    private void checkCarrierLookup(CarrierLookup carrierLookup) {

    }

    private void checkCnamLookup(CnamLookup cnamLookup) {

    }

    private void checkBnaLookup(BnaLookup bnaLookup) {

    }

}
