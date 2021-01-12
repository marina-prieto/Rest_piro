package dominio;

import java.util.Date;

public class Reserva {
	
	private String nombreCliente;
	private String telefono;
	private int personas;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String mail;
	private String anotaciones;
	private String nombreEstancia;
	
	
	public Reserva(String nombreCliente, String telefono, int personas, Date fechaEntrada, Date fechaSalida, String anotaciones, String nombreEstancia) {
		super();
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
		this.personas = personas;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.mail = "";
		this.anotaciones = anotaciones;
		this.nombreEstancia = nombreEstancia;
	}
	
	public Reserva(String nombreCliente, String telefono, int personas, Date fechaEntrada, Date fechaSalida, String mail, String anotaciones, String nombreEstancia) {
		super();
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
		this.personas = personas;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.mail = mail;
		this.anotaciones = anotaciones;
		this.nombreEstancia = nombreEstancia;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getPersonas() {
		return personas;
	}
	
	public void setPersonas(int personas) {
		this.personas = personas;
	}
	
	public Date getfechaEntrada() {
		return fechaEntrada;
	}
	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	public Date getfechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getAnotaciones() {
		return anotaciones;
	}
	
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	
	public String getnombreEstancia() {
		return nombreEstancia;
	}
	
	public void setNombreEstancia(String nombreEstancia) {
		this.nombreEstancia = nombreEstancia;
	}
}