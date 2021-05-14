package ar.unrn.edu.ejercicio2;

import java.util.ArrayList;

public class Proyecto {

	private ArrayList<ItemDeProyecto> listaItems;
	
	public Proyecto() {
		this.listaItems = new ArrayList<ItemDeProyecto>();
	}
	
	public void agregarItem (ItemDeProyecto item) {
		this.listaItems.add(item);
	}
	
	public int tiempoTotal () {
		int total = 0;
		for (ItemDeProyecto itemDeProyecto : listaItems) {
			total = total + itemDeProyecto.tiempoParcialTarea();
		}
		return total;
	}
}
