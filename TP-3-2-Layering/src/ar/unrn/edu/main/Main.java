package ar.unrn.edu.main;

import ar.unrn.edu.modelo.Cumpleanos;
import ar.unrn.edu.persistencia.ArchivoEnDisco;
import ar.unrn.edu.serviciomail.Email;
import ar.unrn.edu.serviciomail.ManejadorEmail;

public class Main {

	public static void main(String[] args) {
		Cumpleanos c = new Cumpleanos(new ManejadorEmail(),
				new ArchivoEnDisco("C:\\Users\\Sektor\\Desktop\\archivo.txt"));
		c.enviarEmailSiEsSuCumpleaños("Feliz cumpleaños", "Te desea la empresa");
	}
}
