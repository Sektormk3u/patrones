package ar.unrn.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.modelo.NaftaSuper;

class TestNaftaSuper {

	@Test
	void cargarNaftaSinDescuento() {
		// setup
		NaftaSuper n = new NaftaSuper();
		// execute
		double resultado = n.calcularDescuento(30, LocalDateTime.of(2021, 5, 7, 10, 1));
		// verify
		assertEquals(2700, resultado);
	}

	@Test
	void cargarNaftaDomingo() {
		// setup
		NaftaSuper n = new NaftaSuper();
		// execute
		double resultado = n.calcularDescuento(10, LocalDateTime.of(2021, 5, 9, 10, 1));// domingo
		// verify
		assertEquals(810, resultado);
	}

	@Test
	void cargarNaftaMasDe20LitrosLosSabados() {
		// setup
		NaftaSuper n = new NaftaSuper();
		// execute
		double resultado = n.calcularDescuento(30, LocalDateTime.of(2021, 5, 8, 10, 1)); // sabado
		// verify
		assertEquals(2376, resultado);
	}
}
