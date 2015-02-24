package nl.oose.dea.orderservice.withdip;

public class LoggingPaymentProcessor implements PaymentProcessor {
    private PaymentGateway paymentGateway = new PaymentGateway();

    @Override
    public boolean chargeCard(PaymentDetails paymentDetails, Cart cart) {
        return paymentGateway.charge(cart.getBillingTotal(), cart.getCustomerName(), paymentDetails.cardNumber);
    }
}
