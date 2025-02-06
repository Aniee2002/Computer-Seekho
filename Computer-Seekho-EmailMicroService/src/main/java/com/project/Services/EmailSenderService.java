package com.project.Services;


import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.springframework.stereotype.Service;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailSenderService {
    
	public void sendAdmissionEmail(String to, String studentName) {
		final String username = "computerseekho2025@gmail.com";
		final String password = "uqknkgmutwmxuxju";

        // Set up the mail server properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");


        // Create a session with an authenticator
        Session session = Session.getInstance(props,
      		  new jakarta.mail.Authenticator() {
      			protected PasswordAuthentication getPasswordAuthentication() {
      				return new PasswordAuthentication(username, password);
      			}
      		  });
        try {
        // Create a new email message
        	MimeMessage message1 = new MimeMessage(session);
			message1.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(to));
			message1.setSubject("Admission Confirmation");


        // Read the HTML template from a file
        String emailTemplate = new String(Files.readAllBytes(Paths.get("src/main/resources/emailTemplate.html")));

        // Replace placeholders with actual values
        emailTemplate = emailTemplate.replace("${studentName}", studentName);

        // Create the HTML part
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(emailTemplate, "text/html");

        // Create a multipart message
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(htmlPart);

        // Set the multipart content to the message
        message1.setContent(multipart);

        // Send the email
        Transport.send(message1);
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}
