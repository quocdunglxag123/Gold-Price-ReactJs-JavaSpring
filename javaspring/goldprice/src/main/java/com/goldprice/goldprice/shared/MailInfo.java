package com.goldprice.goldprice.shared;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MailInfo {

	private String fromEmailUserName = "tamxa61@gmail.com";
    private String fromEmailPassword = "YouAppPasswordGmail";	
    
    /*
	 * Send Email
	 * 
	 * @param toEmail receive mail
	 * 
	 * @param subject subject mail
	 * 
	 * @param content content mail
	 * 
	 * @param multiFileNameAttach  multiple file name of multi file need to attach mail (Ex: fileName1,fileName1,fileName1,...)
	 * 
	 * @return date Date Format By Type
	 */
	public void sendMail(String toEmail, String subject, String content, String multiFileNameAttach)
			throws Exception {
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(fromEmailUserName, fromEmailPassword);
//			}
//		});
//
//		Message message = new MimeMessage(session);
//		try {
//			Multipart multipart = new MimeMultipart();
//
//			message.setFrom(new InternetAddress(fromEmailUserName));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			message.setSubject(subject);
//
//			MimeBodyPart mimeBodyPart = new MimeBodyPart();
//			mimeBodyPart.setContent(content, "text/html; charset=utf-8");
//			multipart.addBodyPart(mimeBodyPart);
//
//			if (multiFileNameAttach != null && multiFileNameAttach != "") {
//				String[] fileNames = multiFileNameAttach.split(",");
//				for (String fileName : fileNames) {
//					MimeBodyPart mimeBodyPartAttachFile = new MimeBodyPart();
//					mimeBodyPartAttachFile.attachFile(new File("src/main/java/com/goldprice/goldprice/shared/image/"+fileName).getAbsolutePath());
//					multipart.addBodyPart(mimeBodyPartAttachFile);
//				}
//			}
//
//			message.setContent(multipart);
//
//			Transport.send(message);
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}