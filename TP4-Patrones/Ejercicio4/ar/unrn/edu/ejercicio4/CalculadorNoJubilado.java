package ar.unrn.edu.ejercicio4;
import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorNoJubilado implements Calculador {
	
	private LogTransaction log;
	private int mesEnPromocion;
	
	public CalculadorNoJubilado (int mesPromocion) {
		this.mesEnPromocion = mesPromocion;
		this.log = new LogTransaction();
	}
	

	public double calcularPrecio(double precioProducto) {
		double precioTotal = precioProducto;
		if (of(mesEnPromocion).equals(now().getMonth())) {
			precioTotal += precioProducto * 0.15;
		} else {
			precioTotal += precioProducto * 0.21;
		}
		log.log(CalculadorNoJubilado.class.getName());
		return precioTotal;
	}
}
