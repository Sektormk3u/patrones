import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

class TestReporte {

	@Test
	void testSinSobreescribir() throws FileNotFoundException {
		File archivo = new File("C:\\Users\\Sektor\\Desktop\\prueba.txt");
		DecoratorReporteSinSobreescribir d = new DecoratorReporteSinSobreescribir(
				new ReporteConcreto("Este es un reporte"));
		assertThrows(IllegalArgumentException.class, () -> d.export(archivo));
	}

	@Test
	void testSobreescribir() {
		File archivo = new File("C:\\Users\\Sektor\\Desktop\\prueba.txt");
		ReporteConcreto r = new ReporteConcreto("Este es un reporte");
		assertDoesNotThrow(() -> r.export(archivo));
	}

}
