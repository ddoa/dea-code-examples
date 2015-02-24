package nl.oose.dea.orderservice.withoutdip;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    @Test
    public void testCharge() throws Exception {
        PaymentProcessor paymentProcessor = new LoggingPaymentProcessor();
        assertTrue(paymentProcessor.chargeCard(createPaymentDetails(),createCart()));
    }

    private Cart createCart() {
        return new Cart("OOSE", "oose@gmail.com", new Item[]{}, 0);
    }

    private PaymentDetails createPaymentDetails() {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.cardNumber = 1234;
        paymentDetails.paymentMethod = PaymentMethod.CreditCard;
        return paymentDetails;
    }
}