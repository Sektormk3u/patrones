package ar.unrn.edu.serviciomail;

import ar.unrn.edu.modelo.ServicioEmailEmpleado;

public class ManejadorEmail implements ServicioEmailEmpleado {

	@Override
	public void enviarEmailEmpleado(String destinatarioEmail, String tituloEmail, String cuerpoEmail) {
		Email manejadorEmail = new Email(destinatarioEmail, tituloEmail, cuerpoEmail);
		try {
			manejadorEmail.enviar();
		} catch (SmtpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
