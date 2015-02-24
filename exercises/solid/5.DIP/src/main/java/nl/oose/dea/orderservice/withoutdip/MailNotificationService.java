package nl.oose.dea.orderservice.withoutdip;

import javax.mail.MessagingException;
import java.util.logging.Logger;

public class MailNotificationService implements NotificationService {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void notifyCustomer(Cart cart) {
        MailClient mailClient = new MailClient();
        try {
            mailClient.send("Your order is processed.", cart.getCustomerEmail());
        } catch (MessagingException e) {
            logger.severe(e.getMessage());
            throw new OrderException("Cannot send mail to " + cart.getCustomerEmail(), e);
        }
    }
}
