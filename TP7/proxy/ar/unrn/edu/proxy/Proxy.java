package ar.unrn.edu.proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ar.unrn.edu.modelo.Telefono;

public class Proxy<E> implements Set<Telefono> {

	private int id;
	private transient HashMap<E, Object> map;

	public Proxy(int id) {
		this.id = id;
	}

	@Override
	public int size() {
		String url = "jdbc:mysql://localhost:3306/tp7";
		String user = "root";
		String password = "15415260";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "select count(numero) " + "from personas p, telefonos t " + "where p.id = t.idpersona and p.id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int tamaño = 0;
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				tamaño =Integer.parseInt(result.getString(1));
			}
			return tamaño;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Telefono> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		String url = "jdbc:mysql://localhost:3306/tp7";
		String user = "root";
		String password = "15415260";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "select t.numero " + "from personas p, telefonos t " + "where p.id = t.idpersona and p.id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			while (result.next()) {
				telefonos.add(new Telefono(result.getString(1)));
			}
			return (T[]) telefonos.toArray(new Telefono[telefonos.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Telefono e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Telefono> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
