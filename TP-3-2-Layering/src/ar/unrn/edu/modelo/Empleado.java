package ar.unrn.edu.modelo;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;

	public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String devolverEmail() {
		return email;
	}

	public boolean esSuCumpleaños() {
		if (LocalDate.now().isEqual(this.fechaNacimiento)) {
			return true;
		}
		return false;
	}
}
