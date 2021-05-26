import java.util.ArrayList;

public class ComboBasico implements Item {

	private ArrayList<Item> listaCombo;
	private int precio;

	public ComboBasico() {
		listaCombo.add(new Carne(20));
		listaCombo.add(new PapasFritas(10));
		this.precio = 30;
	}

	public int precioTotal() {
		return this.precioTotal();
	}

	@Override
	public String detallePedido() {
		String s = "";
		for (Item items : listaCombo) {
			s = s + "  "+items.detallePedido();
		}
		return s;
	}

}
