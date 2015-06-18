package nl.oose.dea.orderservice.withdip;

import javax.mail.MessagingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FakeMailClient implements MailClient {
    private Logger logger = Logger.getLogger(getClass().getName());

    public void send(String message, String customerEmail) throws MessagingException {
        logger.log(Level.INFO, message + " sent to " + customerEmail);
    }
}
