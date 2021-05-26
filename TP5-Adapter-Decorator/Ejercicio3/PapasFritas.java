
public class PapasFritas implements Item {

	private int precio;

	public PapasFritas(int precio) {
		this.precio = precio;
		// TODO Auto-generated constructor stub
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
