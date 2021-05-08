package ar.unrn.edu.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NaftaComun implements Nafta {

	private double precioNafta;

	public NaftaComun() {
		this.precioNafta = 70;
	}

	@Override
	public double calcularDescuento(double litros, LocalDateTime fechaRecarga) {
		double calculo = litros * this.precioNafta;
		if (fechaRecarga.getHour() <= 9 && fechaRecarga.getMinute() <= 59) {
			if ((fechaRecarga.getHour() >= 8)) {
				calculo = calculo - (calculo * 0.05);
			}
		}
		return calculo;
	}

}
