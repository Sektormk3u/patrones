package ar.unrn.edu.ejercicio1;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Empleado> listaEmpleados;

	public Empresa() {
		this.listaEmpleados = new ArrayList<Empleado>();
	}

	public int calcularMonto() {
		int montoFinal = 0;
		for (Empleado Empleado : listaEmpleados) {
			montoFinal = montoFinal + Empleado.montoTotalSalarial();
		}
		return montoFinal;
	}

	public void agregarEmpleado(Empleado e) {
		this.listaEmpleados.add(e);
	}
}
