package ar.unrn.edu.email;

import java.util.Properties;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ar.unrn.edu.modelo.Observer;

public class ServicioEmail{


	public void enviarEmail(String destinatario) {
		// remitente
		String to = destinatario;
		// destinatario
		String from = "82777dd608-3ce6e4@inbox.mailtrap.io";
		// usuario y clave que se obtiene desde Mailtrapfinal
		String username = "51c596c4acaec0";
		final String password = "ce3cff61d570ee";
		String host = "smtp.mailtrap.io";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");// it’s optional in Mailtrap
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525"); // Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Usted ha cargado combustible en estacion Felipe");
			message.setText("Muchas gracias por su compra. Lo esperamos nuevamente");
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}
	}

}
