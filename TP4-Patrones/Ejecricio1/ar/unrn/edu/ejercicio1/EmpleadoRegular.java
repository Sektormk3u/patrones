package ar.unrn.edu.ejercicio1;

public class EmpleadoRegular implements Empleado {

	private int salario;

	public EmpleadoRegular() {
		this.salario = 30;
	}

	@Override
	public int montoTotalSalarial() {
		return this.salario;
	}

	@Override
	public void añadirEmpleado(Empleado e) {
		// TODO Auto-generated method stub
		
	}

}
