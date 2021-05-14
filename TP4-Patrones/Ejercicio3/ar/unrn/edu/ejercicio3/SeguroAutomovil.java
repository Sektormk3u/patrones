package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;

public class SeguroAutomovil implements Seguro {

	private int costoSeguro;

	public SeguroAutomovil() {
		this.costoSeguro = 5;
	}

	@Override
	public double calcularSeguro() {
		// TODO Auto-generated method stub
		return this.costoSeguro;
	}

}
