package com.goldprice.goldprice;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class test {

	public static void main(String[] args) throws MessagingException {
	    Properties properties=new Properties();
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");

		String fromEmailUserName = "tamxa61@gmail.com";
		String fromEmailPassword = "czab tpok aapo gcus";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmailUserName, fromEmailPassword);
			}
		});

		Message message = new MimeMessage(session);
		try {
			Multipart multipart = new MimeMultipart();

			message.setFrom(new InternetAddress(fromEmailUserName));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("quocdunglxag123@gmail.com"));
			message.setSubject("Helloo Sub");

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent("Hello Content", "text/html; charset=utf-8");
			multipart.addBodyPart(mimeBodyPart);

			MimeBodyPart mimeBodyPartAttachFile = new MimeBodyPart();
			mimeBodyPartAttachFile.attachFile(new File(
					"D:\\Code\\Project\\Gold-Price-ReactJs-JavaSpring\\javaspring\\goldprice\\src\\main\\resources\\application.properties"));
			multipart.addBodyPart(mimeBodyPartAttachFile);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Message Sent successfully");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}