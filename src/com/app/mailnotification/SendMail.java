package com.app.mailnotification;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
//import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void sendToAll(String msg,String[] email1) {
		// create an instance of Properties Class
		Properties props = new Properties();

		/*
		 * gmail server as an email sever you will pass smtp.gmail.com
		 * as value of mail.smtp host.
		 */
		props.put("mail.smtp.host", "smtp.gmail.com");
		// below mentioned mail.smtp.port is optional
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		/*
		 * Pass Properties object(props) and Authenticator object for
		 * authentication to Session instance
		 */

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("recruitmentonline15@gmail.com", "websecurity");
			}
		});

		try {

			/*
			 * Create an instance of MimeMessage, it accept MIME types and
			 * headers
			 */
           String[] email= {"manvithareddyk@gmail.com","srikanthreddy.kmit@gmail.com","sasaank.sss@gmail.com"};
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("recruitmentonline15@gmail.com"));
			
            InternetAddress[] toAddress = new InternetAddress[email.length];

            // To get the array of addresses
            for( int i = 0; i < email.length; i++ ) {
                toAddress[i] = new InternetAddress(email[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

		//	message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			message.setSubject("Procubes");
			message.setText(msg);

			/*
			 * Transport class is used to deliver the message to the recipients
			 */

			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void send(String msg, String email) {
		// create an instance of Properties Class
		Properties props = new Properties();

		/*
		 * gmail server as an email sever you will pass smtp.gmail.com
		 * as value of mail.smtp host.
		 */
		props.put("mail.smtp.host", "smtp.gmail.com");
		// below mentioned mail.smtp.port is optional
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		/*
		 * Pass Properties object(props) and Authenticator object for
		 * authentication to Session instance
		 */

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("recruitmentonline15@gmail.com", "websecurity");
			}
		});

		try {

			/*
			 * Create an instance of MimeMessage, it accept MIME types and
			 * headers
			 */

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("recruitmentonline15@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Procubes");
			message.setText(msg);

			/*
			 * Transport class is used to deliver the message to the recipients
			 */

			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
