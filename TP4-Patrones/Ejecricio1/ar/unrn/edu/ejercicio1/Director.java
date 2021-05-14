package ar.unrn.edu.ejercicio1;

import java.util.ArrayList;

public class Director implements Empleado {

	private ArrayList<Gerente> listaEmpleados;
	private int salario;

	public Director() {
		this.salario = 90;
		this.listaEmpleados = new ArrayList<Gerente>();
	}

	@Override
	public int montoTotalSalarial() {
		int montoTotal = this.salario;
		for (Gerente Gerente : listaEmpleados) {
			montoTotal = montoTotal + Gerente.montoTotalSalarial();
		}
		return montoTotal;
	}

	@Override
	public void añadirEmpleado(Empleado e) {
		try {
			this.listaEmpleados.add((Gerente) e);
		} catch (Exception e2) {
			System.out.println("No es gerente");
		}
	}

}
