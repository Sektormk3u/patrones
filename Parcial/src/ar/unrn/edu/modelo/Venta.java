package ar.unrn.edu.modelo;

import java.time.LocalDateTime;

public class Venta {

	private double monto;
	private double litros;
	private LocalDateTime fecha;

	public Venta(double monto, double litros, LocalDateTime fecha) {
		this.monto = monto;
		this.litros = litros;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "$ " + monto + " - Litros: " + litros + " Fecha: " + fecha;
	}
}
