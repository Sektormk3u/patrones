package ar.unrn.edu.ejercicio5.templated;

public class RemeraImportada extends CalculadorRemera {

	public RemeraImportada(double precio) {
		super(precio);
	}

	@Override
	protected double precioFinal(double precioUnitario) {
		return (precioUnitario * 0.03) +
				(precioUnitario * 0.05) + (precioUnitario * 0.25);
	}
}
