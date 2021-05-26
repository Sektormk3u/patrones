
public class Combo implements Item {

	private Item item;

	public Combo(Item item) {
		this.item = item;
	}

	@Override
	public String detallePedido() {

		//
		return item.detallePedido();
	}

	@Override
	public int precioTotal() {
		// TODO Auto-generated method stub
		return this.precioTotal();
	}

}
