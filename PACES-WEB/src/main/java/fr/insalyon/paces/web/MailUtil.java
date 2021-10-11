/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web;

/**
 *
 * @author zihao
 */
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

	public static String account = "paces_114514@yahoo.com";
	public static String password = "gjvyugfjlkzwpgqe";
	public static String myEmailSMTPHost = "smtp.mail.yahoo.com";

	public void sendMail(String to, String code) {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);					
		props.setProperty("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                final String smtpPort = "465";
                props.setProperty("mail.smtp.port", smtpPort);
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.socketFactory.port", smtpPort);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(account, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(account));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("Code PACES");
			message.setContent("<h1>Votre code de vérification : " 
                                + code + ", ce code sera expiré dans 10 minutes.",
                                "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
