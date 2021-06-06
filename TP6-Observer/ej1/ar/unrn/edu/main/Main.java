package ar.unrn.edu.main;

import ar.unrn.edu.model.Medidor;
import ar.unrn.edu.model.WeatherChannelService;
import ar.unrn.edu.persistencia.TemperaturaEnConsola;
import ar.unrn.edu.persistencia.TemperaturaEnDisco;

public class Main {

	public static void main(String[] args) {
		WeatherChannelService wc = new WeatherChannelService();
		Medidor m = new Medidor(wc);
		TemperaturaEnConsola t1 = new TemperaturaEnConsola();
		TemperaturaEnDisco t2 = new TemperaturaEnDisco("C:\\Users\\Sektor\\Desktop\\prueba.txt");
		m.agregarObservador(t1);
		m.agregarObservador(t2);
		m.leerTemperatura();
	}

}
