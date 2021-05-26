import java.util.ArrayList;
import java.util.TooManyListenersException;

public class MainCombos {

	public static void main(String[] args) {
	
		ArrayList<Item> listaItems1 = new ArrayList<Item>();
		listaItems1.add(new Tomate(10));
		listaItems1.add(new ComboEspecial());
		ComboLibre libre1 = new ComboLibre(listaItems1);
		ArrayList<Item> listaItems2 = new ArrayList<Item>();
		listaItems2.add(new Carne(30));
		listaItems2.add(new ComboFamiliar());
		ComboLibre libre2 = new ComboLibre(listaItems2);
		
		System.out.println(libre1.detallePedido());
		System.out.println(libre2.detallePedido());
		

	}

}
