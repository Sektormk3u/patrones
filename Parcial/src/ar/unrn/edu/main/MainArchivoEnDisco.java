package ar.unrn.edu.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ar.unrn.edu.gui.VentanaCombustible;
import ar.unrn.edu.gui.VentanaPrincipal;
import ar.unrn.edu.persistencia.PersistenciaBaseDeDatos;
import ar.unrn.edu.persistencia.PersistenciaEnArchivoLocal;

public class MainArchivoEnDisco {

	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal(
				new PersistenciaEnArchivoLocal("C:\\\\Users\\\\Sektor\\\\Desktop\\\\prueba.txt"));
		v.mostrarVentana();
	}

}
