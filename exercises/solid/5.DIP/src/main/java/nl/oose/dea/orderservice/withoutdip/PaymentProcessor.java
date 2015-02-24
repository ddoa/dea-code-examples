package nl.oose.dea.orderservice.withoutdip;

public interface PaymentProcessor {
    boolean chargeCard(PaymentDetails paymentDetails, Cart cart);
}
