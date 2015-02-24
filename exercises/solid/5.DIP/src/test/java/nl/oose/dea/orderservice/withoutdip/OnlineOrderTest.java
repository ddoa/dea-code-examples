package nl.oose.dea.orderservice.withoutdip;

import org.junit.Test;

public class OnlineOrderTest {
    @Test(expected = OrderException.class)
    public void checkoutOnlineOrder()
    {
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
