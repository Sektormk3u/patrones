package ar.unrn.edu.ejercicio3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.ejercicio3.Aseguradora;
import ar.unrn.edu.ejercicio3.Paquete;
import ar.unrn.edu.ejercicio3.Seguro;
import ar.unrn.edu.ejercicio3.SeguroAutomovil;
import ar.unrn.edu.ejercicio3.SeguroHogar;
import ar.unrn.edu.ejercicio3.SeguroMedico;
import ar.unrn.edu.ejercicio3.SeguroVida;

class TestSeguros {

	@Test
	void testCalculoSeguro() {
		//
		Paquete paquetePadre = new Paquete();
		Seguro automovil = new SeguroAutomovil();
		Seguro hogar = new SeguroHogar();
		Seguro vida = new SeguroVida();
		Seguro medico = new SeguroMedico();
		Paquete paqueteHijo = new Paquete();
		paquetePadre.agregarSeguro(automovil);
		paquetePadre.agregarSeguro(hogar);
		paqueteHijo.agregarSeguro(vida);
		paqueteHijo.agregarSeguro(medico);
		paquetePadre.agregarSeguro(paqueteHijo);
		//
		double total = paquetePadre.calcularSeguro();
		//
		assertEquals(85.7375, total);
	}

	@Test
	void testAseguradora() {
		//
		Aseguradora a = new Aseguradora();
		Paquete paquete1 = new Paquete();
		Seguro automovil = new SeguroAutomovil();
		Seguro hogar = new SeguroHogar();
		Seguro vida = new SeguroVida();
		Seguro medico = new SeguroMedico();
		Paquete paquete2 = new Paquete();
		paquete1.agregarSeguro(automovil);
		paquete1.agregarSeguro(hogar);
		paquete2.agregarSeguro(vida);
		paquete2.agregarSeguro(medico);
		paquete1.agregarSeguro(paquete2);
		a.agregarSeguro(new SeguroAutomovil());
		a.agregarSeguro(new SeguroHogar());
		a.agregarSeguro(new SeguroVida());
		a.agregarSeguro(new SeguroMedico());
		a.agregarSeguro(paquete1);
		a.agregarSeguro(paquete2);
		//
		ArrayList<Double> d = a.costosPaquetes();
		double total1 = d.get(0);
		double total2 = d.get(1);
		double total3 = d.get(2);
		double total4 = d.get(3);
		double total5 = d.get(4);
		double total6 = d.get(5);
		//
		assertEquals(5.0, total1);
		assertEquals(30, total2);
		assertEquals(40, total3);
		assertEquals(20, total4);
		assertEquals(85.7375, total5);
		assertEquals(57.0, total6);
	}

}
