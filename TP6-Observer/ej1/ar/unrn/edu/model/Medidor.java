package ar.unrn.edu.model;

public class Medidor extends Observable{
	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;
	}

	

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificar(temperatura);
		return this.temperatura;
	}
}