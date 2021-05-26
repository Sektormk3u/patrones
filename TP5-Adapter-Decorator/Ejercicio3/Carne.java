
public class Carne implements Item{

	private int precio;
	
	public Carne(int precio) {
		this.precio = precio;
	}

	@Override
	public String detallePedido() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

	@Override
	public int precioTotal() {
		
		return this.precio;
	}

	

}
