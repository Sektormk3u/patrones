package ar.unrn.edu.persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.edu.modelo.Empleado;
import ar.unrn.edu.modelo.RepositorioArchivo;
import ar.unrn.edu.modelo.ServicioEmailEmpleado;

public class ArchivoEnDisco implements RepositorioArchivo {

	private String path;

	public ArchivoEnDisco(String path) {
		this.path = path; //"C:\\Users\\Sektor\\Desktop\\archivo.txt"
	}

	@Override
	public ArrayList<Empleado> devolverColeccionEmpleados() { // devolver coleccion empleado
		ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
		try {
			String[] data = null;
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader(path)); // recibir por constructor
			String row = "";
			while ((row = bufferedReader.readLine()) != null) {
				data = row.split(", ");
				Empleado e = new Empleado(data[0], data[1], convertirFecha(data[2]), data[3]);
				// if (esSuCumpleaños(e)) {
				// repo.enviarEmailEmpleado(e);
				listaEmpleado.add(e);
			}
			return listaEmpleado;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LocalDate convertirFecha(String s) {
		String[] fechaSeparada = s.split("/");
		int anio = Integer.parseInt(fechaSeparada[0]);
		int mes = Integer.parseInt(fechaSeparada[1]);
		int dia = Integer.parseInt(fechaSeparada[2]);
		LocalDate d = LocalDate.of(anio, mes, dia);
		return d;
	}
}
