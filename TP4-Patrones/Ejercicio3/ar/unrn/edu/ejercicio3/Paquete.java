package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;

public class Paquete implements Seguro {

	private ArrayList<Seguro> listaSeguros;

	public Paquete () {
		this.listaSeguros = new ArrayList<Seguro>();
	}
	@Override
	public double calcularSeguro() {
		double total = 0;
		for (Seguro seguro : listaSeguros) {
			total = total + seguro.calcularSeguro();
			if (total != seguro.calcularSeguro()) {
				total = total - (total * 0.05);
			}
		}
		return total;
	}

	public void agregarSeguro(Seguro s) {
		listaSeguros.add(s);
	}

}
