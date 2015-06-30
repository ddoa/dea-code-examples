package nl.oose.dea.orderservice.withdip;

import javax.mail.MessagingException;
import java.util.logging.Logger;

public class MailNotificationService implements NotificationService {
    private Logger logger = Logger.getLogger(getClass().getName());
    private MailClient mailClient;

    public MailNotificationService(MailClient mailClient)
    {
        this.mailClient = mailClient;
    }

    public void notifyCustomer(Cart cart) {
        try {
            mailClient.send("Your order is processed.", cart.getCustomerEmail());
        } catch (MessagingException e) {
            logger.severe(e.getMessage());
            throw new OrderException("Cannot send mail to " + cart.getCustomerEmail(), e);
        }
    }
}
