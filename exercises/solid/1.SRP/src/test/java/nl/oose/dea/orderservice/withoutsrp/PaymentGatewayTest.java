package nl.oose.dea.orderservice.withoutsrp;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentGatewayTest {

    @Test
    public void testCharge() throws Exception {
        PaymentGateway paymentGateway = new PaymentGateway();
        assertTrue(paymentGateway.charge(20,"OOSE", 1234));
    }
}