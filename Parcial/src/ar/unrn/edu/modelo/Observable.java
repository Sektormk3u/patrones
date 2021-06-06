package ar.unrn.edu.modelo;

import java.util.ArrayList;

public abstract class Observable {
	
	private ArrayList<Observer> observers;
	
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}

	public void notificar (String destinatario) {
		for (Observer observer : observers) {
			observer.enviarEmail(destinatario);
		}
	}
}
