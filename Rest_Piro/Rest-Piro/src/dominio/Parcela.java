package dominio;

import java.io.File;

public class Parcela extends Estancia {

	private String categoria;
	//private String ubicacion;
	
	public Parcela (String nombre, File foto, double tamano, double precioPorNoche, boolean disponibilidad, String razon, String descripcion, boolean[] extras, String categoria) {
		super(nombre, foto, tamano, precioPorNoche, disponibilidad, razon, descripcion, extras);
		this.categoria = categoria;
		//this.ubicacion = ubicacion;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/*
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	*/
}