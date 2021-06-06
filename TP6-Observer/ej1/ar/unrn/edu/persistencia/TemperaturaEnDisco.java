package ar.unrn.edu.persistencia;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import ar.unrn.edu.model.Observer;

public class TemperaturaEnDisco implements Observer {

	private String path;

	public TemperaturaEnDisco(String path) {
		this.path = path;
	}

	@Override
	public void actualizar(String valor) {
		try {
			String stringFinal = "";
			File file = new File(path);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
				stringFinal = valor + LocalDate.now();
			} else {
				stringFinal = "\n" + valor + " " + LocalDate.now();
			}
			Files.write(Paths.get(path), stringFinal.getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
