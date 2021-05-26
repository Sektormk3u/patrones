package ar.unrn.edu.ejercicio5.templated;

public abstract class CalculadorRemera {

	private double precioUnitario;

	public CalculadorRemera(double precio) {
		this.precioUnitario = precio;
	}

	public double calcularPrecio() {
		// Si el dia de mañana existe mas logica, se agrega aca - logica templated
		return this.precioUnitario + (this.precioUnitario);
	}

	protected abstract double precioFinal(double precioUnitario);
}
