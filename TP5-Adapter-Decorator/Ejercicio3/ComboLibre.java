import java.util.ArrayList;

public class ComboLibre implements Item {

	private ArrayList<Item> items;

	public ComboLibre(ArrayList<Item> adicionales) {
		this.items = adicionales;
	}

	@Override
	public String detallePedido() {
		String s = "";
		for (Item items : items) {
			s = s + "  " + items.detallePedido();
		}
		return s;
	}

	public int precioTotal() {
		int precioTotal = 0;
		for (Item items : items) {
			precioTotal = items.precioTotal() + precioTotal;
		}
		return precioTotal;
	}

	public void agregarItemAdicional(Item item) {
		this.items.add(item);
	}

}
