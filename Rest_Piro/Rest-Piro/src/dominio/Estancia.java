package dominio;

import java.io.File;

public abstract class Estancia {

	private String nombre;
	private File foto;
	private double tamano;
	private double precioPorNoche;
	private boolean disponibilidad;
	private String razon;
	private String descripcion;
	private boolean[] extras;
	
	public Estancia(String nombre, File foto, double tamano, double precioPorNoche, boolean disponibilidad, String razon, String descripcion, boolean[] extras) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		this.tamano = tamano;
		this.precioPorNoche = precioPorNoche;
		this.disponibilidad = disponibilidad;
		this.razon = razon;
		this.descripcion = descripcion;
		this.extras = extras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public double getTamano() {
		return tamano;
	}

	public void setTamano(double tamano) {
		this.tamano = tamano;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean[] getExtras() {
		return extras;
	}

	public void setExtras(boolean[] extras) {
		this.extras = extras;
	}
	
}