package net.connectix.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	


	public boolean sendEmail(String subject, String message, String to) {
		boolean f = false;

		String from = "payroll@connectix.net";
		
//		final String username = "YourMailId";
//        final String password = "password";
		// variable for gmail
		String host = "mailsrvr.connectix.net";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		// setting important information to properties object

		// host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		
		//Step1. get the Session object
		
		Session session = Session.getInstance(properties, new Authenticator() {
		     @Override
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("payroll@connectix.net", "P!8fDxL21");
		      }
		   });
		session.setDebug(true);
		
		//compose the message [test,multi,media]
		MimeMessage m=new MimeMessage(session);
		try {
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			
			//step3. send message using transport class
			
			Transport.send(m);
			System.out.println("Send Success..........");
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return f;

	}
	
	
}
