package nl.oose.dea.orderservice.withdip;

import com.google.inject.AbstractModule;

public class OrderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NotificationService.class).to(MailNotificationService.class);
        bind(PaymentProcessor.class).to(LoggingPaymentProcessor.class);
        bind(ReservationService.class).to(CafetariaReservationService.class);
        bind(Cart.class).toProvider(CartFactory.class);
    }
}
