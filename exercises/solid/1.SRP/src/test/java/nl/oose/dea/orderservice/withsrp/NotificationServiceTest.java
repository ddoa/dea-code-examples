package nl.oose.dea.orderservice.withsrp;

import org.junit.Test;

public class NotificationServiceTest {

    @Test(expected = OrderException.class)
    public void youCannotSendAMailUsingGmailWithAnEmptyUsernameAndPass() throws Exception {
        /**
         * TIP:
         * - create a new class MailNotificationService that implements a new interface NotificationService
         * - implement a notifyCustomer method using the code from the 'old' Order class.
         */
        NotificationService notificationService = new MailNotificationService();
        notificationService.notifyCustomer(createCart());
    }

    private Cart createCart() {
        return new Cart("Test", "oose@gmail.com", new Item[]{}, 0);
    }
}