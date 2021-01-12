package dominio;

import java.io.File;

public class Bungalow extends Estancia {

	private int capacidad;

	public Bungalow (String nombre, File foto, double tamano, double precioPorNoche, boolean disponibilidad, String razon, String descripcion, boolean[] extras, int capacidad) {
		super(nombre, foto, tamano, precioPorNoche, disponibilidad, razon, descripcion, extras);
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}