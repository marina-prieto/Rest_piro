package dominio;

public class Cliente {

	private String nombre;
	private int telefono;
	private boolean pagado;
	private String inscripcion;
	private String foto;
	
	public Cliente(String nombre, int telefono, boolean pagado, String inscripcion, String foto) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.pagado = pagado;
		this.inscripcion = inscripcion;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public String getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}