package ar.unrn.edu.ejercicio1;

import java.util.ArrayList;

public class LiderDeProyecto implements Empleado {

	private ArrayList<EmpleadoRegular> listaEmpleados;
	private int salario;

	public LiderDeProyecto() {
		this.salario = 40;
		this.listaEmpleados = new ArrayList<EmpleadoRegular>();
	}

	@Override
	public int montoTotalSalarial() {
		int montoTotal = this.salario;
		for (EmpleadoRegular empleadoRegular : listaEmpleados) {
			montoTotal = montoTotal + empleadoRegular.montoTotalSalarial();
		}
		return montoTotal;
	}

	@Override
	public void añadirEmpleado(Empleado e) {
		try {
			this.listaEmpleados.add((EmpleadoRegular) e);
		} catch (Exception e2) {
			System.out.println("No es Empleado Regular");
		}
	}
}
