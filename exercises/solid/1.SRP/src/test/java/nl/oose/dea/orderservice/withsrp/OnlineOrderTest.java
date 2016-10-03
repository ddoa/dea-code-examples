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
         *
         * This test case cannot fully check of OnlineOrder is implemented correctly. It should check whether methods
         * are called on the required interfaces but implementations of these interfaces are declared and intitialized in
         * the class itself, so we can't put assertions on those dependencies. Well, we could, but not without applying
         * the dependency inversion principle together with dependency injection, but that's for another exercise.
         *
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
