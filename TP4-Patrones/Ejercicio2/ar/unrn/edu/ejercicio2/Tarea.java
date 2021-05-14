package ar.unrn.edu.ejercicio2;

public class Tarea implements ItemDeProyecto{

	private int tiempoEnMinutosAprox;
	
	public Tarea(int tiempo) {
		this.tiempoEnMinutosAprox = tiempo;
	}
	
	@Override
	public int tiempoParcialTarea() {
		// TODO Auto-generated method stub
		return this.tiempoEnMinutosAprox;
	}

	
}
