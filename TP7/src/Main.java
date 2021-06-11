
public class Main {
	public static void main(String args[]) {
		PersonaDAO dao = new PersonaDAO();
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
			/*
			 * con DAOProxy
			 * PersonaDAO dao = new PersonaDAO();
			 * Persona p = dao.personaPorId(1); //PersonaDAOProxy extiende de persona
			 * System.out.println(p.nombre());
			 * for (Telefono telefono : * p.telefonos()) {
			 * System.out.println(telefono);
			 */
		}
	}
}