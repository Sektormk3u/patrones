package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;

public class SeguroHogar implements Seguro {

	private int costoSeguro;

	public SeguroHogar() {
		this.costoSeguro = 30;
	}

	@Override
	public double calcularSeguro() {
		// TODO Auto-generated method stub
		return this.costoSeguro;
	}

}
