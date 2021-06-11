package ar.unrn.edu.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import ar.unrn.edu.modelo.Persona;
import ar.unrn.edu.modelo.Telefono;
import ar.unrn.edu.proxy.Proxy;

public class PersonaDAO{
	
	protected Connection obtenerConexion() {
		String url = "jdbc:mysql://localhost:3306/tp7";
		String user = "root";
		String password = "15415260";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected Connection obtenerConexion(String url, String user, String pass) {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Persona personaPorId(int id) {
		String sql = "select p.nombre " + "from personas p "
				+ "where p.id = ?"; 
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new Proxy(id); //new de proxy
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
				//telefonos.add(new Telefono(result.getString(2)));
			}
			return new Persona(id, nombrePersona, telefonos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}