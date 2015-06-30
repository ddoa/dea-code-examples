package nl.oose.dea.orderservice.withdip;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    @Test
    public void testCharge() throws Exception {
        PaymentProcessor paymentProcessor = new LoggingPaymentProcessor();
        assertTrue(paymentProcessor.chargeCard(createPaymentDetails(),createCart()));
    }

    private Cart createCart() {
        return new CartFactory().create();
    }

    private PaymentDetails createPaymentDetails()
    {
        return new PaymentDetailsFactory().create();
    }
}