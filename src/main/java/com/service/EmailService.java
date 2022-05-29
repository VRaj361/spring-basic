package com.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
//import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;



@Service
public class EmailService {
	public void welcomeEmail(String email,String otp) {
		final String from = "vrajnpatel3333@gmail.com";
		final String appPassword = "yewsmbwrxnqryvpv"; 

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom("James Bond");
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Your OTP For Reset Password");
			message.setContent("Your OTP is : " + otp, "text/html");
			
			
			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}

	
}
