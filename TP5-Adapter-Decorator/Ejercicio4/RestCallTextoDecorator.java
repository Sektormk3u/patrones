import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RestCallTextoDecorator implements RestCallInterface {

	private RestCallInterface restCall;
	private String path;

	public RestCallTextoDecorator(RestCallInterface restCall, String path) {
		this.restCall = restCall;
		this.path = path;
	}

	@Override
	public String run() {

		return restCall.run();
	}
	
	public void guardarItemsATexto () {
		try {
			String texto = "";
			File file = new File(path);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			texto = run();
			Files.write(Paths.get(path), texto.getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
