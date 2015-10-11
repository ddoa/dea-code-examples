package nl.oose.dea.orderservice.withdip;

import com.google.inject.Inject;

public class POSCreditOrder extends Order {
    private final PaymentDetails paymentDetails;
    private final PaymentProcessor paymentProcessor;

    @Inject
    public POSCreditOrder(Cart cart, PaymentDetails paymentDetails, PaymentProcessor paymentProcessor) {
        super(cart);
        this.paymentDetails = paymentDetails;
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void checkout() {
        paymentProcessor.chargeCard(paymentDetails, cart);
        super.checkout();
    }

}
