package ar.unrn.edu.ejercicio5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.ejercicio5.templated.RemeraImportada;
import ar.unrn.edu.ejercicio5.templated.RemeraNacional;

class TestCalculoRemera {

	@Test
	void testCalculoRemeraImportada() {
		RemeraImportada r = new RemeraImportada(100);
		double total = r.calcularPrecio();
		assertEquals(133.0, total);
	}
	
	@Test
	void testCalculoRemeraNacional() {
		RemeraNacional r = new RemeraNacional(100);
		double total = r.calcularPrecio();
		assertEquals(96.5, total);
	}

}
