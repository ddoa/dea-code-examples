package nl.oose.dea.orderservice.withdip;

import nl.oose.dea.orderservice.withoutdip.Cart;
import nl.oose.dea.orderservice.withoutdip.Item;
import nl.oose.dea.orderservice.withoutdip.MailNotificationService;
import nl.oose.dea.orderservice.withoutdip.NotificationService;
import nl.oose.dea.orderservice.withoutdip.OrderException;
import org.junit.Test;

public class NotificationServiceTest {

    @Test(expected = OrderException.class)
    public void youCannotSendAMailUsingGmailWithAnEmptyUsernameAndPass() throws Exception {
        NotificationService notificationService = new MailNotificationService();
        notificationService.notifyCustomer(createCart());
    }

    private Cart createCart() {
        return new Cart("Test", "oose@gmail.com", new Item[]{}, 0);
    }
}