package dominio;

public class Comentario {

	private String descripcion;
	private int puntuacion;
	
	public Comentario(String descripcion, int puntuacion) {
		super();
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	
}