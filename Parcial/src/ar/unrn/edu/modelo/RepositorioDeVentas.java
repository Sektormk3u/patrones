package ar.unrn.edu.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface RepositorioDeVentas {

	public void realizarVenta(double litros, double precio, LocalDateTime fecha, String destinatario);
	public ArrayList<Venta> listadoVentas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	public void notificar (String destinatario);
}
