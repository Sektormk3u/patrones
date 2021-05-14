package ar.unrn.edu.ejercicio1;

import java.util.ArrayList;

public class Gerente implements Empleado {

	public ArrayList<MandosMedios> listaEmpleados;
	private int salario;

	public Gerente() {
		this.listaEmpleados = new ArrayList<MandosMedios>();
		this.salario = 70;
	}

	@Override
	public int montoTotalSalarial() {
		int montoTotal = this.salario;
		for (MandosMedios MandosMedios : listaEmpleados) {
			montoTotal = montoTotal + MandosMedios.montoTotalSalarial();
		}
		return montoTotal;
	}

	@Override
	public void añadirEmpleado(Empleado e) {
		try {
			this.listaEmpleados.add((MandosMedios) e);
		} catch (Exception e2) {
			System.out.println("No es mando medio");
		}
	}

}
