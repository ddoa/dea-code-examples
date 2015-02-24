package nl.oose.dea.orderservice.withoutsrp;

import org.junit.Test;

import javax.mail.MessagingException;

import static org.junit.Assert.*;

public class MailClientTest {

    @Test(expected = MessagingException.class)
    public void youCannotSendAMailUsingGmailWithAnEmptyUsernameAndPass() throws Exception {
        MailClient mailClient = new MailClient();
        mailClient.send("Test", "oose@gmail.com");
    }
}