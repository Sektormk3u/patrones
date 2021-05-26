package ar.unrn.edu.ejercicio5.templated;

public class RemeraNacional extends CalculadorRemera {

	public RemeraNacional(double precio) {
		super(precio);
	}

	@Override
	protected double precioFinal(double precioUnitario) {
		return (precioUnitario * 0.015) - (precioUnitario * 0.2) // bonificacion
				+ (precioUnitario * 0.15); 
																												// por
																												// eso
																												// negativo
	}

}
