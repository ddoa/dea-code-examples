package nl.oose.dea.orderservice.withdip;

import javax.inject.Inject;

public class OnlineOrder extends Order {
    private final PaymentDetails paymentDetails;
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;
    private final ReservationService reservationService;

    @Inject
    public OnlineOrder(Cart cart, PaymentDetails paymentDetails, PaymentProcessor paymentProcessor, NotificationService notificationService, ReservationService reservationService) {
        super(cart);
        this.paymentDetails = paymentDetails;
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
        this.reservationService = reservationService;
    }

    public void checkout() {
        if (paymentProcessor.chargeCard(paymentDetails, cart)) {
            reservationService.reserveInventory(cart);
            notificationService.notifyCustomer(cart);
        }
        super.checkout();
    }

}
