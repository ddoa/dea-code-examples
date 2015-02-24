package nl.oose.dea.orderservice.withdip;

import org.junit.Test;

public class POSCashOrderTest {
    @Test
    public void checkoutOnlineOrder()
    {
        // Hah, still works, POSCashOrder has no other dependencies
        Order order = new POSCashOrder(createCart());
        order.checkout();
    }

    private Cart createCart() {
        return new Cart("Test", "oose@gmail.com", new Item[]{ new Item("Frikandel", 20)}, 100);
    }
}
