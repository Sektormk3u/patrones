import java.util.ArrayList;

public class ComboFamiliar implements Item {

	private int precio;
	private ArrayList<Item> listaCombo;

	public ComboFamiliar() {
		listaCombo = new ArrayList<Item>();
		listaCombo.add(new Carne(20));
		listaCombo.add(new PapasFritas(10));
		listaCombo.add(new Carne(20));
		listaCombo.add(new PapasFritas(10));
		this.precio = 60;
	}

	@Override
	public String detallePedido() {
		String s = "";
		for (Item items : listaCombo) {
			s = s + "  "+items.detallePedido();
		}
		return s;
	}

	@Override
	public int precioTotal() {
		// TODO Auto-generated method stub
		return this.precio;
	}

}
