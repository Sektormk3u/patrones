package ar.unrn.edu.ejercicio2;

import java.util.ArrayList;

public class HistoriaDeUsuario implements ItemDeProyecto{
	
	
	
	private ArrayList<ItemDeProyecto> listaTareas;
	
	public HistoriaDeUsuario() {
		this.listaTareas = new ArrayList<ItemDeProyecto>();
	}
	
	public void agregarTarea (ItemDeProyecto item) {
		listaTareas.add(item);
	}

	@Override
	public int tiempoParcialTarea() {
		int tiempoParcial = 0;
		for (ItemDeProyecto itemDeProyecto : listaTareas) {
			tiempoParcial = tiempoParcial + itemDeProyecto.tiempoParcialTarea();
		}
		return tiempoParcial;
	}
}
