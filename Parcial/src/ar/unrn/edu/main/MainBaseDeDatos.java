package ar.unrn.edu.main;

import ar.unrn.edu.gui.VentanaPrincipal;
import ar.unrn.edu.persistencia.PersistenciaBaseDeDatos;
import ar.unrn.edu.persistencia.PersistenciaEnArchivoLocal;

public class MainBaseDeDatos {

	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal(new PersistenciaBaseDeDatos());
		v.mostrarVentana();
	}

}
