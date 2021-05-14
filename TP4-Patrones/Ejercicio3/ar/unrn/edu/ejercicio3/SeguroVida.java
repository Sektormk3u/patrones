package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;

public class SeguroVida implements Seguro {

	private int costoSeguro;

	public SeguroVida() {
		this.costoSeguro = 40;
	}

	@Override
	public double calcularSeguro() {
		// TODO Auto-generated method stub
		return this.costoSeguro;
	}

}
