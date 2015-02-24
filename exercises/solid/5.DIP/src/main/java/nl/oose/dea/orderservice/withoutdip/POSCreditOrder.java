package nl.oose.dea.orderservice.withoutdip;

public class POSCreditOrder extends Order {
    private final PaymentDetails paymentDetails;
    private PaymentProcessor paymentProcessor = new LoggingPaymentProcessor();

    public POSCreditOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        this.paymentDetails = paymentDetails;
    }

    @Override
    public void checkout() {
        paymentProcessor.chargeCard(paymentDetails, cart);
        super.checkout();
    }
}
