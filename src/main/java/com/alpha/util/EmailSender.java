package com.alpha.util;

import com.alpha.common.SessionBean;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;

/**
 * Created by erwinschens on 10.10.15.
 */
public class EmailSender {

    private Properties properties;

    public EmailSender() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.host", Application.getConfig().getString("mail.host"));
        this.properties.put("mail.smtp.port", Application.getConfig().getString("mail.port"));
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls.enable", "true");
    }

    private Authenticator initAuthenticator() {
        return new Authenticator() {
            public javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(Application.getConfig().getString("mail.username"),
                        Application.getConfig().getString("mail.password"));
            }
        };
    }

    public void sendPlainMail(String toAddress, String subject, String message) throws MessagingException {
        Authenticator auth = initAuthenticator();
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Application.getConfig().getString("mail.username")));
        InternetAddress[] toAdresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAdresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
    }

}
