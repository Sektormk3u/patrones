package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class Aseguradora {

	private ArrayList<Seguro> listaSeguros;

	public Aseguradora() {
		this.listaSeguros = new ArrayList<>();
	}

	public void agregarSeguro(Seguro s) {
		listaSeguros.add(s);
	}

	public ArrayList<Double> costosPaquetes() {
		ArrayList<Double> listaPrecios = new ArrayList<Double>();
		for (Seguro seguro : listaSeguros) {
			listaPrecios.add(seguro.calcularSeguro());
		}
		return listaPrecios;
	}
}
