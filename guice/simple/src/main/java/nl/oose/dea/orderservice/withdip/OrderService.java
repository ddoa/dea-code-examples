package nl.oose.dea.orderservice.withdip;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;

public class OrderService {
    public static void main(String[] args) {
        Module module = new AbstractModule() {
            @Override
            protected void configure() {
                bind(NotificationService.class).to(MailNotificationService.class);
                bind(PaymentProcessor.class).to(LoggingPaymentProcessor.class);
                bind(ReservationService.class).to(CafetariaReservationService.class);
                bind(Cart.class).toInstance(new CartFactory().create());
                bind(MailClient.class).to(FakeMailClient.class);
            }
        };
        OnlineOrder onlineOrder = Guice.createInjector(module).getInstance(OnlineOrder.class);
        onlineOrder.checkout();
    }
}
