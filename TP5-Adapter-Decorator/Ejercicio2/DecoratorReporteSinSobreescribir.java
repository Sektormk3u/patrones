import java.io.File;

public class DecoratorReporteSinSobreescribir extends Reporte {

	private Reporte reporteDecorator;

	public DecoratorReporteSinSobreescribir(Reporte r) {
		this.reporteDecorator = r;
	}

	@Override
	void export(File file) {

		if (file.exists()) {
			throw new IllegalArgumentException("El archivo ya existe...");
		}
		reporteDecorator.export(file);
		// super.export(file); //Funcionalidad extendida - heredada
		// Exportar el reporte a un archivo. }}

	}

}
