package ar.unrn.edu.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Nafta {

	public double calcularDescuento(double litros, LocalDateTime fechaRecarga);
}
