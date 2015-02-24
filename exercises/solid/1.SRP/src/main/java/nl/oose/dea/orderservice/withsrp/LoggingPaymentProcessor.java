package nl.oose.dea.orderservice.withsrp;

import nl.oose.dea.orderservice.withoutsrp.PaymentGateway;

public class LoggingPaymentProcessor implements PaymentProcessor {
    private PaymentGateway paymentGateway = new PaymentGateway();

    @Override
    public boolean chargeCard(PaymentDetails paymentDetails, Cart cart) {
        return paymentGateway.charge(cart.getBillingTotal(), cart.getCustomerName(), paymentDetails.cardNumber);
    }
}
