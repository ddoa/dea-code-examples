package nl.oose.dea.orderservice.withdip;

import org.junit.Test;

public class NotificationServiceTest {

    @Test(expected = OrderException.class)
    public void youCannotSendAMailUsingGmailWithAnEmptyUsernameAndPass() throws Exception {
        NotificationService notificationService = new MailNotificationService();
        notificationService.notifyCustomer(createCart());
    }

    private Cart createCart() {
        return new CartFactory().create();
    }
}