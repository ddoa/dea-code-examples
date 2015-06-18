package nl.oose.dea.orderservice.withdip;

public interface PaymentProcessor {
    boolean chargeCard(PaymentDetails paymentDetails, Cart cart);
}
