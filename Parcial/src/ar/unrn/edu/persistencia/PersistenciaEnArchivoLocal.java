package ar.unrn.edu.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.unrn.edu.modelo.RepositorioDeVentas;
import ar.unrn.edu.modelo.Venta;

public class PersistenciaEnArchivoLocal implements RepositorioDeVentas {

	private String path;

	public PersistenciaEnArchivoLocal(String path) {
		this.path = path;
	}

	@Override
	public void realizarVenta(double litros, double precio, LocalDateTime fecha) {
		try {
			String fechaString = litros + ", " + precio + ", " + fechaToString(fecha) + "\n";
			File file = new File(path);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			} else {
				// Si esta creado, e empieza en la siguiente linea
				fechaString = "\n" + fechaString;
			}
			Files.write(Paths.get(path), fechaString.getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Venta> listadoVentas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		ArrayList<Venta> listaVenta = new ArrayList<Venta>();
		try {
			String[] data = null;
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			String row = "";
			while ((row = bufferedReader.readLine()) != null) {
				data = row.split(", ");
				// Si la fecha obtenida del archivo, esta dentro del rango, lo agrego a la lista
				// a devolver
				if (fechaStringALocalDate(data[2]).isAfter(fechaInicio)
						&& fechaStringALocalDate(data[2]).isBefore(fechaFin)) {
					Venta venta = new Venta(Double.parseDouble(data[0]), Double.parseDouble(data[1]),
							fechaStringALocalDate(data[2]));
					listaVenta.add(venta);
				}
			}
			return listaVenta;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LocalDateTime fechaStringALocalDate(String s) {
		String[] fechaSeparada = s.split("/");
		int anio = Integer.parseInt(fechaSeparada[2]);
		int mes = Integer.parseInt(fechaSeparada[1]);
		int dia = Integer.parseInt(fechaSeparada[0]);
		LocalDateTime d = LocalDateTime.of(anio, mes, dia, 1, 1);
		return d;
	}

	private String fechaToString(LocalDateTime fecha) {
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
	}

}
