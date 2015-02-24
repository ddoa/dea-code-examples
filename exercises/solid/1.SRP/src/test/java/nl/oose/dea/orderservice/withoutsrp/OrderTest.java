package nl.oose.dea.orderservice.withoutsrp;

import org.junit.Before;
import org.junit.Test;

/**
 * You might have been missing an assertEquals-statement in this unit test, this is due to the fact that
 * we don't apply the Dependency Inversion Principle (DIP from SOLID) yet.
 */
public class OrderTest {
    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order();
    }

    @Test
    public void checkoutProductsWithoutNotification() throws Exception {
        // notification is always false when order created by a retail PoS
        order.checkout(createCartWithSufficientInventory(), createPaymentDetails(), false);
    }

    @Test(expected = OrderException.class)
    public void checkoutProductsWhenInsufficientInventoryWithoutNotification() throws Exception {
        // notification is always false when order created by a retail PoS
        order.checkout(createCartWithInsufficientInventory(), createPaymentDetails(), false);
    }

    @Test(expected = OrderException.class) // an exception is thrown because of the missing username/password
    public void checkoutProductsWithNotification() throws Exception {
        // notification is always true when order created by the web site
        order.checkout(createCartWithSufficientInventory(), createPaymentDetails(), true);
    }

    private PaymentDetails createPaymentDetails() {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.cardNumber = 1234;
        paymentDetails.paymentMethod = PaymentMethod.CreditCard;
        return paymentDetails;
    }

    private Cart createCartWithSufficientInventory() {
        Cart cart = new Cart("OOSE", "oose@gmail.com",
                new Item[]{
                        new Item("Frikandel", 10),
                        new Item("Bamihap", 5) }, 20);
        return cart;
    }

    private Cart createCartWithInsufficientInventory() {
        Cart cart = new Cart("OOSE", "oose@gmail.com",
                new Item[]{
                        new Item("Frikandel", 100),
                        new Item("Bamihap", 5) }, 200);
        return cart;
    }
}