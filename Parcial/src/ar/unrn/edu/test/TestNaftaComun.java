package ar.unrn.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.modelo.NaftaComun;

class TestNaftaComun {

	@Test
	void cargarNaftaSinDescuento() {
		// setup
		NaftaComun n = new NaftaComun();
		// execute
		double resultado = n.calcularDescuento(10, LocalDateTime.of(2000, 5, 5, 10, 1));
		// verify
		assertEquals(700, resultado);
	}

	@Test
	void cargarNaftaConDescuento() {
		// setup
		NaftaComun n = new NaftaComun();
		// execute
		double resultado = n.calcularDescuento(10, LocalDateTime.of(2000, 5, 5, 8, 1));
		// verify
		assertEquals(665, resultado);
	}

}
