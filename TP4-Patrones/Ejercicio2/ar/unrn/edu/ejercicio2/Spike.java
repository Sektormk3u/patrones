package ar.unrn.edu.ejercicio2;

public class Spike implements ItemDeProyecto{

	private int tiempoEnMinutosAprox;

	public Spike(int tiempo) {
		this.tiempoEnMinutosAprox = tiempo;
	}
	
	@Override
	public int tiempoParcialTarea() {
		// TODO Auto-generated method stub
		return this.tiempoEnMinutosAprox;
	}
	
}
