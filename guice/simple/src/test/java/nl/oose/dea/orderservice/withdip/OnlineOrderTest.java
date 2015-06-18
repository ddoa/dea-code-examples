package nl.oose.dea.orderservice.withdip;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class OnlineOrderTest {
    private PaymentProcessor paymentProcessor = mock(PaymentProcessor.class);
    private NotificationService notificationService = mock(NotificationService.class);
    private ReservationService reservationService = mock(ReservationService.class);

    @Test
    public void checkoutOnlineOrder()
    {
        // Create an order and pass all its dependencies. For unit tesing purposes we inject mock objects for the dependencies
        Cart cart = createCart();
        PaymentDetails paymentDetails = createPaymentDetails();
        Order order = new OnlineOrder(cart, paymentDetails, setupPaymentProcessor(), setupNotificationService(), setupReservationService());
        order.checkout();

        InOrder inOrder = inOrder(paymentProcessor, reservationService, notificationService);
        inOrder.verify(paymentProcessor, times(1)).chargeCard(paymentDetails, cart);
        inOrder.verify(reservationService, times(1)).reserveInventory(cart);
        inOrder.verify(reservationService, never()).isOnStock(anyString(), anyInt());
        inOrder.verify(notificationService, times(1)).notifyCustomer(cart);
    }

    private ReservationService setupReservationService() {
        return reservationService;
    }

    private NotificationService setupNotificationService() {
        return notificationService;
    }

    private PaymentProcessor setupPaymentProcessor() {
        // always return true, enough for now
        when(paymentProcessor.chargeCard(any(PaymentDetails.class), any(Cart.class))).thenReturn(true);
        return paymentProcessor;
    }


    private Cart createCart() {
        return new CartFactory().create();
    }

    private PaymentDetails createPaymentDetails()
    {
        return new PaymentDetailsFactory().create();
    }
}
