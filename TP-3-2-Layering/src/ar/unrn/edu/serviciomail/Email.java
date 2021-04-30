package ar.unrn.edu.serviciomail;

public class Email {
	public String destinatarioEmail;
	public String tituloEmail;
	public String cuerpoEmail;

	public Email(String destinatarioEmail, String tituloEmail, String cuerpoEmail) {
		this.destinatarioEmail = destinatarioEmail;
		this.tituloEmail = tituloEmail;
		this.cuerpoEmail = cuerpoEmail;
	}

	public void enviar() throws SmtpException {
		// logica envio de mail
		// conectar con el servidor SMTP para el envio
		// Si algo sale mal, se lanza una SmtpException
		// Si todo sale bien se imprime todo correcto
		System.out.println("Se envió el email correctamente");
	}
}