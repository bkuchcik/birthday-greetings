package com.accenture;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mail {
    public Properties configMail() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");
        //prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        prop.put("mail.smtp.ssl.trust", "*");
        return prop;
    }

    Properties prop = configMail();

    Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("blabla", "blabla");
        }



    });

    public void sendMail(Person person) throws MessagingException {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("auriane.gregoire@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(person.getMail()));
        message.setSubject("Happy birthday!");

        String msg = "Happy birthday, dear !" + person.getFirstname();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg,"text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
