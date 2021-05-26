public class MainRestCall {
	public static void main(String[] args) {
		RestCall rest = new RestCall("https://jsonplaceholder.typicode.com/posts");
		System.out.println(rest.run());

		RestCallTextoDecorator t = new RestCallTextoDecorator(rest, "C:\\Users\\Sektor\\Desktop\\prueba.txt");
		t.guardarItemsATexto();

		RestCallBaseDeDatos rb = new RestCallBaseDeDatos(
				new RestCallTextoDecorator(rest, "https://jsonplaceholder.typicode.com/posts"), "root", "root",
				"jdbc:mysql://localhost:3306/ejercicio5");
	}
}