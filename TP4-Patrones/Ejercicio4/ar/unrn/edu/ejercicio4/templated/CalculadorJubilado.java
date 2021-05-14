package ar.unrn.edu.ejercicio4.templated;


public class CalculadorJubilado extends Calculador { 
	
	private LogTransaction log; 
	private int mesEnPromocion; 
	
	public CalculadorJubilado (int mesPromocion) {
		super(mesPromocion);
	}

	@Override
	protected double mesSinPromocion(double precioProducto) {
		// TODO Auto-generated method stub
		return precioProducto * 0.1 + precioProducto;
	}

	@Override
	protected double mesEnPromocion(double precioProducto) {
		// TODO Auto-generated method stub
		return precioProducto *  1;
	}
	
	/*public double calcularPrecio(double precioProducto) {
		double precioTotal = precioProducto;
		if (!of(mesEnPromocion).equals(now().getMonth())) {
			precioTotal += precioProducto * 0.1; 
			} 
		log.log(CalculadorJubilado.class.getName());
		return precioTotal;
		}*/ 
	}

