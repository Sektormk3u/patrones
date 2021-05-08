package ar.unrn.edu.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import ar.unrn.edu.modelo.RepositorioDeVentas;
import ar.unrn.edu.modelo.Venta;

public class PersistenciaBaseDeDatos implements RepositorioDeVentas {
	private Connection dbConn;

	private void setupBaseDeDatos() {
		String url = "jdbc:mysql://localhost:3306/parcial";
		String user = "root";
		String password = "root";
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void realizarVenta(double litros, double precio, LocalDateTime fecha) {
		setupBaseDeDatos();
		try {
			PreparedStatement st = dbConn
					.prepareStatement("insert   into   ventas(litros,   monto,   fecha)values(?,?,?)");
			st.setDouble(1, litros);
			st.setDouble(2, precio);
			st.setDate(3, convertirDateParaBaseDeDatos(fecha));
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Venta> listadoVentas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		ArrayList<Venta> lista = new ArrayList<>();
		setupBaseDeDatos();
		ResultSet rs;
		try {
			Statement st = dbConn.createStatement();
			String query = "select monto, litros, fecha FROM ventas where fecha < '" + convertirParaConsulta(fechaFin)
					+ "' and fecha > '" + convertirParaConsulta(fechaInicio) + "'";
			rs = st.executeQuery(query);

			while (rs.next()) {
				lista.add(new Venta(rs.getDouble("monto"), rs.getDouble("litros"),
						convertirDateALocalDateTime(rs.getDate("fecha"))));
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Date convertirDateParaBaseDeDatos(LocalDateTime l) {
		return Date.valueOf(LocalDate.of(l.getYear(), l.getMonthValue(), l.getDayOfMonth()));
	}

	private LocalDateTime convertirDateALocalDateTime(Date d) {
		LocalDate l = d.toLocalDate();
		return LocalDateTime.of(l.getYear(), l.getMonthValue(), l.getDayOfMonth(), 1, 1);
	}

	private String convertirParaConsulta(LocalDateTime l) {
		return l.getYear() + "-" + l.getMonthValue() + "-" + l.getDayOfMonth();
	}
}