package ar.unrn.edu.main;

import ar.unrn.edu.dao.PersonaDAO;
import ar.unrn.edu.modelo.Persona;
import ar.unrn.edu.modelo.Telefono;

public class Main {
	public static void main(String args[]) {
		PersonaDAO dao = new PersonaDAO();
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
			
		}
	}
}