package nl.oose.dea.orderservice.withoutdip;

public class OnlineOrder extends Order {
    private final PaymentDetails paymentDetails;

    private PaymentProcessor paymentProcessor = new LoggingPaymentProcessor();
    private NotificationService notificationService = new MailNotificationService();
    private ReservationService reservationService = new CafetariaReservationService();

    public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        this.paymentDetails = paymentDetails;
    }

    @Override
    public void checkout() {
        paymentProcessor.chargeCard(paymentDetails, cart);
        reservationService.reserveInventory(cart);
        notificationService.notifyCustomer(cart);
        super.checkout();
    }
}
