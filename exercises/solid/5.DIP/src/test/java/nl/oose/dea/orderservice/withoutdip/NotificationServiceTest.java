package nl.oose.dea.orderservice.withoutdip;

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