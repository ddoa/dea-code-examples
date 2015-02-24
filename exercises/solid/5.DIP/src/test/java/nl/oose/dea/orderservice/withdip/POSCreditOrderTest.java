package nl.oose.dea.orderservice.withdip;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class POSCreditOrderTest {

    private PaymentProcessor paymentProcessor = mock(PaymentProcessor.class);

    @Test
    public void checkoutOnlineOrder()
    {
        // Create an order and pass all its dependencies. For unit tesing purposes we inject mock objects for the dependencies
        Order order = new POSCreditOrder(createCart(), createPaymentDetails(), setupPaymentProcessor());
        order.checkout();

        verify(paymentProcessor, times(1)).chargeCard(any(PaymentDetails.class), any(Cart.class));
    }

    private PaymentProcessor setupPaymentProcessor() {
        // always return true, enough for now
        when(paymentProcessor.chargeCard(any(PaymentDetails.class), any(Cart.class))).thenReturn(true);
        return paymentProcessor;
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
