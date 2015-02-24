package nl.oose.dea.orderservice.withsrp;

import org.junit.Test;

public class POSCreditOrderTest {
    @Test
    public void checkoutOnlineOrder()
    {
        /**
         * TIP: Re-create Order as an abstract base class which can hold the cart and defines an parameterless
         * method called checkout with an empty body. Instead of passing parameters to the method, pass required
         * parameters to the constructor.
         *
         * An POSCreditOrder depends on one interface:
         * - PaymentProcessor
         *
         * It does not depend on the InventorySystem because we can get the items right out of the shop, we don't
         * have to access our inventory
         */
        Order order = new POSCreditOrder(createCart(), createPaymentDetails());
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
