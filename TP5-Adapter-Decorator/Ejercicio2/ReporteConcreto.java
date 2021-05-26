import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

class ReporteConcreto extends Reporte {
	private String reporte;

	public ReporteConcreto(String reporte) {
		this.reporte = reporte;
	}

	@Override
	void export(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("C:\\\\Users\\\\Sektor\\\\Desktop\\\\prueba.txt");
			pw = new PrintWriter(fichero);
			pw.println(this.reporte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}