package com.zang.api.it;

import com.zang.api.connectors.CarrierServicesConnector;
import com.zang.api.exceptions.ZangException;
import org.junit.Test;

public class CarrierServicesIT extends BaseIntegrationTest {


    private final CarrierServicesConnector conn;

    public CarrierServicesIT() throws ZangException {
        conn = connectorFactory.getCarrierServicesConnector();
    }

    @Test
    public void carrierLookup() throws ZangException {
        conn.carrierLookup("1-408-647-4636");
        conn.listCarrierLookups(0, 50);
    }

    @Test
    public void bnaLookup() throws ZangException {
        conn.bnaLookup("1-408-647-4636");
        conn.listBnaLookups(0, 50);
    }

    @Test
    public void cnamLookup() throws ZangException {
        //conn.cnamLookup("+14086474636");
        conn.listCnamLookups(0, 50);
    }

}
