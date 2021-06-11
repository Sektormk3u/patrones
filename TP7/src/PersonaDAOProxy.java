import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class PersonaDAOProxy extends Persona {

	private int id;

	public PersonaDAOProxy(int id, String nombre, Set<Telefono> telefonos) {
		super(id, nombre, telefonos);
		this.id = id;
	}

	protected Connection obtenerConexion() {
		String url = "jdbc:mysql://localhost:3306/tp7";
		String user = "root";
		String password = "root";
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
		String sql = "select p.nombre,t.numero " + "from personas p, telefonos t "
				+ "where p.id = t.idpersona and p.id = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			// Set<Telefono> telefonos = new HashSet<Telefono>();
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
				// telefonos.add(new Telefono(result.getString(2)));
			}
			return new Persona(id, nombrePersona, null);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Telefono[] telefonos() {
		String sql = "select t.numero " + "from personas p, telefonos t " + "where p.id = t.idpersona and p.id = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, this.id); // ?
			ResultSet result = statement.executeQuery();
			Telefono[] telefonos = new Telefono[99]; // de prueba
			String nombrePersona = "";
			int i = 0;
			while (result.next()) {
				telefonos[i] = (new Telefono(result.getString(0))); // de prueba
			}
			return telefonos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
