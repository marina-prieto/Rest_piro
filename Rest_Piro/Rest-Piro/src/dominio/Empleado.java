package dominio;

import java.io.File;
import java.util.Vector;

public class Empleado {

	private String nombre;
	private String apellidos;
	private File foto;
	private String telefono;
	private String correo;
	private Vector<String> idiomas;
	private String formacion;
	private String horario;
	
	public Empleado(String nombre, String apellidos, File foto, String telefono, String correo, Vector<String> idiomas,
			String formacion, String horario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
		this.telefono = telefono;
		this.correo = correo;
		this.idiomas = idiomas;
		this.formacion = formacion;
		this.horario = horario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Vector<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(Vector<String> idiomas) {
		this.idiomas = idiomas;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
}