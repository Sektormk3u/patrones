package ar.unrn.edu.ejercicio1;

import java.util.ArrayList;

public class MandosMedios implements Empleado {
	private ArrayList<LiderDeProyecto> listaEmpleados;
	private int salario;

	public MandosMedios() {
		this.salario = 50;
		this.listaEmpleados = new ArrayList<LiderDeProyecto>();
	}

	@Override
	public int montoTotalSalarial() {
		int montoTotal = this.salario;
		for (LiderDeProyecto LiderDeProyecto : listaEmpleados) {
			montoTotal = montoTotal + LiderDeProyecto.montoTotalSalarial();
		}
		return montoTotal;
	}

	@Override
	public void añadirEmpleado(Empleado e) {
		try {
			this.listaEmpleados.add((LiderDeProyecto) e);
		} catch (Exception e2) {
			System.out.println("No es Lider de Proyecto");
		}
	}
}
