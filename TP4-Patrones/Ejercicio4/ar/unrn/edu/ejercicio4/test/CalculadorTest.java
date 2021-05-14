package ar.unrn.edu.ejercicio4.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.ejercicio4.templated.CalculadorJubilado;
import ar.unrn.edu.ejercicio4.templated.CalculadorNoJubilado;
import ar.unrn.edu.ejercicio4.templated.Calculador;

class CalculadorTest {

	@Test
	public void testJubilidoSinPromocion() {
		Calculador calculador = new CalculadorJubilado(LocalDate.now().getMonthValue() - 1);
		double resultado = calculador.calcularPrecio(100);
		assertEquals(110d, resultado, 0.01f);
	}
	
	@Test
	public void testJubilidoConPromocion() {
		Calculador calculador = new CalculadorJubilado(LocalDate.now().getMonthValue());
		double resultado = calculador.calcularPrecio(100);
		assertEquals(100d, resultado, 0.01f);
	}

	@Test
	public void testNoJubilidoConPromocion() {
		Calculador calculador = new CalculadorNoJubilado(LocalDate.now().getMonthValue());
		double resultado = calculador.calcularPrecio(100);
		assertEquals(115d, resultado, 0.01f);
	}

	@Test
	public void testNoJubilidoSinPromocion() {
		Calculador calculador = new CalculadorNoJubilado(LocalDate.now().getMonthValue() - 1);
		double resultado = calculador.calcularPrecio(100);
		assertEquals(121d, resultado, 0.01f);
	}
}
