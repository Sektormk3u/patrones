package ar.unrn.edu.ejercicio2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.unrn.edu.ejercicio2.HistoriaDeUsuario;
import ar.unrn.edu.ejercicio2.Proyecto;
import ar.unrn.edu.ejercicio2.Spike;
import ar.unrn.edu.ejercicio2.Tarea;

class TestDeTiempos {

	@Test
	void TestDeTiempoParcial() {
		HistoriaDeUsuario h1 = new HistoriaDeUsuario();
		HistoriaDeUsuario h2 = new HistoriaDeUsuario();
		Spike s1 = new Spike(10);
		Spike s2 = new Spike(20);
		Tarea t1 = new Tarea(30);
		Tarea t2 = new Tarea(40);
		Tarea t3 = new Tarea(50);
		h2.agregarTarea(s1);
		h2.agregarTarea(s2);
		h2.agregarTarea(t1);
		h2.agregarTarea(t2);
		h1.agregarTarea(t3);
		h1.agregarTarea(h2);
		int total = h1.tiempoParcialTarea();
		assertEquals(150, total);
	}
	
	@Test
	void TiempoTotalProyecto() {
		Proyecto p = new Proyecto();
		HistoriaDeUsuario h1 = new HistoriaDeUsuario();
		HistoriaDeUsuario h2 = new HistoriaDeUsuario();
		Spike s1 = new Spike(10);
		Spike s2 = new Spike(20);
		Tarea t1 = new Tarea(30);
		Tarea t2 = new Tarea(40);
		Tarea t3 = new Tarea(50);
		Spike s3 = new Spike(100);
		Spike s4 = new Spike(100);
		Tarea t4 = new Tarea(100);
		Tarea t5 = new Tarea(100);
		Tarea t6 = new Tarea(100);
		h2.agregarTarea(s1);
		h2.agregarTarea(s2);
		h2.agregarTarea(t1);
		h2.agregarTarea(t2);
		h1.agregarTarea(t3);
		p.agregarItem(h1);
		p.agregarItem(h2);
		p.agregarItem(s3);
		p.agregarItem(s4);
		p.agregarItem(t4);
		p.agregarItem(t5);
		p.agregarItem(t6);
		int total = p.tiempoTotal();
		assertEquals(650, total);
	}

}
