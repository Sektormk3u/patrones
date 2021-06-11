package Facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class ConexionDB implements DBFacade{
	private Connection dbConn;

	@Override
	public void open() {
		String url = "jdbc:mysql://localhost:3306/tp7";
		String user = "root";
		String password = "root";
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {
		Map<String, String> l = null;
		ResultSet rs;
		try {
			PreparedStatement st = dbConn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				l.put(rs.getString("Columna"), rs.getString(0));
			}
		} catch (SQLException e) {
			new RuntimeException();
		};
		return null;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {
		List<String[]> l = null;
		ResultSet rs;
		try {
			PreparedStatement st = dbConn.prepareStatement(sql);
			rs = st.executeQuery();
			int i = 0;
			while (rs.next()) {
				String[] fila = null;
				fila[i] = rs.getString(0);
				l.add(fila);
				i++;
			}
			return l;
		} catch (SQLException e) {
			new RuntimeException();
		};
		return null;
	}

	@Override
	public void close() {
		try {
			this.dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
