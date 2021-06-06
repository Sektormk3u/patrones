package ar.unrn.edu.persistencia;

import java.time.LocalDate;

import ar.unrn.edu.model.Observer;

public class TemperaturaEnConsola implements Observer {

	@Override
	public void actualizar(String valor) {
		System.out.println(valor + " " + LocalDate.now());
	}

}
