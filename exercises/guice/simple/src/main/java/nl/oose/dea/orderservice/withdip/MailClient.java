package nl.oose.dea.orderservice.withdip;

import javax.mail.MessagingException;

public interface MailClient {
    void send(String message, String customerEmail) throws MessagingException;
}
