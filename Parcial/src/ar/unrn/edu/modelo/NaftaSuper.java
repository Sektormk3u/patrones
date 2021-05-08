package ar.unrn.edu.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NaftaSuper implements Nafta {

	private double precioNafta;

	public NaftaSuper() {
		this.precioNafta = 90;
	}

	public double calcularDescuento(double litros, LocalDateTime fechaRecarga) {
		double calculo = litros * this.precioNafta;
		if (fechaRecarga.getDayOfWeek() == DayOfWeek.SUNDAY) {
			calculo = calculo - (calculo * 0.1);
			return calculo;
		}
		if (fechaRecarga.getDayOfWeek() == DayOfWeek.SATURDAY && litros > 20) {
			calculo = calculo - (calculo * 0.12);
		}
		return calculo;
	}

}
