package ar.unrn.edu.ejercicio3;

import java.util.ArrayList;

public class SeguroMedico implements Seguro{

	private int costoSeguro;
	
	public SeguroMedico() {
		this.costoSeguro = 20;
	}

	@Override
	public double calcularSeguro() {
		// TODO Auto-generated method stub
		return this.costoSeguro;
	}
}
