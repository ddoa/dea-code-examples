package nl.oose.dea.orderservice.withdip;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailClient {
    // This MailClient actually works when you have a valid GMail user
    private final static String USERNAME = "";
    private final static String PASSWORD = "";

    public void send(String message, String customerEmail) throws MessagingException {
        Transport.send(prepareMessage(message, customerEmail));
    }

    private Message prepareMessage(String messageBody, String customerEmail) throws MessagingException {
        Message message = new MimeMessage(setGoogleSession(prepareSMTPProperties()));
        message.setFrom(new InternetAddress(USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
        message.setSubject(messageBody);
        message.setText(messageBody);
        return message;
    }

    private Properties prepareSMTPProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    private Session setGoogleSession(Properties props) {
        return Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
    }
}
