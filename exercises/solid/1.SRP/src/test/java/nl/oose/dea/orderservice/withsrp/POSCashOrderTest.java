package nl.oose.dea.orderservice.withsrp;

import org.junit.Test;

public class POSCashOrderTest {
    @Test
    public void checkoutOnlineOrder()
    {
        /**
         * TIP: Re-create Order as an abstract base class which can hold the cart and defines an parameterless
         * method called checkout with an empty body. Instead of passing parameters to the method, pass required
         * parameters to the constructor.
         *
         * An POSCashOrder depends on none of the given interfaces. It does not depend on the ReservationService because we can get the items right out of the shop, we don't
         * have to access our inventory, and we get paid cash.

         */
        Order order = new POSCashOrder(createCart());
        order.checkout();
    }

    private Cart createCart() {
        return new Cart("Test", "oose@gmail.com", new Item[]{ new Item("Frikandel", 20)}, 100);
    }
}
