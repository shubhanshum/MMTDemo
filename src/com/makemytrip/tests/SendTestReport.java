package com.makemytrip.tests;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;

public class SendTestReport {

	public static void SendAttachmentMail(String username, String password, String toMails) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					// InternetAddress.parse(toMail));
					InternetAddress.parse("shubhanshu.mishra@xebia.com"));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(toMails));
			message.setSubject("Automation Report");

			// create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();

			// fill message
			messageBodyPart.setText(
					"Hi,\n\nPlease find attached automation report of the test run. \n\n Regards, \n Automation Team. \n\n PS: This is a system-generated email. Please do not respond. ");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(Reports.getReportPath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("NoonTestReport.html");
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			Log.info("Pass:Mail Sent");

		} catch (MessagingException e) {
			Log.info("Fail:Mail NOT sent:" + e);
		}
	}

	@Test(groups= {"Regression","Sanity"})
	public void callSendReportMailMethod() {
		Reports.setTestName("Email report");
		String uname=WebActions.getPropFileData("config", "config", "email");
		String pwd=WebActions.getPropFileData("config", "config", "pass");
		SendAttachmentMail(uname, pwd, WebActions.loadEmailForSuiteResult());
	}
}
