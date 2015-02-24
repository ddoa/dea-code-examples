package nl.oose.dea.orderservice.withsrp;

import org.junit.Test;

public class OnlineOrderTest {
    @Test(expected = OrderException.class)
    public void checkoutOnlineOrder()
    {
        /**
         * TIP: Re-create Order as an abstract base class which can hold the cart and defines an parameterless
         * method called checkout with an empty body. Instead of passing parameters to the method, pass required
         * parameters to the constructor.
         *
         * An OnlineOrder depends on three interfaces:
         * - NotificationService
         * - ReservationService
         * - PaymentProcessor
         */
        Order order = new OnlineOrder(createCart(), createPaymentDetails());
        order.checkout();
    }

    private Cart createCart() {
        return new Cart("Test", "oose@gmail.com", new Item[]{ new Item("Frikandel", 20)}, 100);
    }

    private PaymentDetails createPaymentDetails()
    {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.paymentMethod = PaymentMethod.CreditCard;
        paymentDetails.cardNumber = 1234;
        return paymentDetails;
    }
}
