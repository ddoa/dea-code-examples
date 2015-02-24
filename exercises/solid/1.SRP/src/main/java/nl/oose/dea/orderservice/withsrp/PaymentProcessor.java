package nl.oose.dea.orderservice.withsrp;

public interface PaymentProcessor {
    boolean chargeCard(PaymentDetails paymentDetails, Cart cart);
}
