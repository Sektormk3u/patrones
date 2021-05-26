import java.util.ArrayList;

public class ComboEspecial implements Item {
	
	private ArrayList<Item> listaCombo;
	private int precio;

	public ComboEspecial() {
		listaCombo = new ArrayList<Item>();
		listaCombo.add(new Carne(20));
		listaCombo.add(new PapasFritas(10));
		listaCombo.add(new Queso(10));
		listaCombo.add(new Tomate(10));
		this.precio = 50;
		
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
