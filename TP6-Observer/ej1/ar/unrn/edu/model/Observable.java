package ar.unrn.edu.model;

import java.util.ArrayList;

public abstract class Observable {

	private ArrayList<Observer> observadores;
	
	public Observable() {
		this.observadores = new ArrayList<Observer>();
	}

	public void agregarObservador(Observer obs) {
		this.observadores.add(obs);
	}

	public void notificar(String valor) {
		for (Observer observer : observadores) {
			observer.actualizar(valor);
		}

	}
}
