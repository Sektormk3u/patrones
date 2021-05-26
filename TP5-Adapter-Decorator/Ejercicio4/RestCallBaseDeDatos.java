import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestCallBaseDeDatos implements RestCallInterface {

	private RestCallInterface restCall;
	private Connection dbConn;
	private String usuario;
	private String contraseña;
	private String jdbc; //"jdbc:mysql://localhost:3306/ejercicio5"

	public RestCallBaseDeDatos(RestCallInterface restCall, String usuario, String contraseña, String jdbc) {
		this.restCall = restCall;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.jdbc = jdbc;
	}
	
	private void setupBaseDeDatos() {
		try {
			this.dbConn = DriverManager.getConnection(this.jdbc, this.usuario, this.contraseña);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String run() {
		return restCall.run();
	}
	
	public void guardarItemsEnBaseDeDatos(String url, String pass, String jdbc) {
		setupBaseDeDatos();
		int i = 19;//31- 47/
		try {
			String datos = run(); //Guardo los datos en String
			PreparedStatement st = dbConn
					.prepareStatement("insert   into   datos(id,   userId,   title, body)values(?,?,?,?)");
			//Logica de recorrido de String
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
