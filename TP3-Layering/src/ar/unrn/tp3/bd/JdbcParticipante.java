package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;
import ar.unrn.tp3.ui.UI;

public class JdbcParticipante implements RepositorioDeParticipantes {

	private Connection dbConn;

	private void setupBaseDeDatos() {
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void nuevoParticipante(Participante p) {
		try {
			setupBaseDeDatos();
			PreparedStatement st = dbConn
					.prepareStatement("insert   into   participantes(nombre,   telefono,   region)values(?,?,?)");
			st.setString(1, p.getNombre());
			st.setString(2, p.getTelefono());
			st.setString(3, p.getRegion());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
