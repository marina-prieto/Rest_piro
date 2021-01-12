package dominio;

import java.io.File;
import java.util.Date;
import java.util.Vector;

public class Actividad extends Evento {

	private String destinatario;
	private double precioPorMes;
	private Vector<Cliente> inscritos;
	private int puntuacion;
	private Vector<Comentario> comentarios;

	public Actividad(String nombre, int cupoMinimo, String monitor, int cupoMaximo, String horaInicio,
			String horaFinal, Date fecha, String descripcion, Vector<String> equipamientoNecesario, File foto ,String destinatario,
			double precioPorMes) {
		super(nombre, cupoMinimo, monitor, cupoMaximo, horaInicio, horaFinal, fecha, descripcion,
				equipamientoNecesario, foto);
		this.destinatario = destinatario;
		this.precioPorMes = precioPorMes;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public double getPrecioPorMes() {
		return precioPorMes;
	}

	public void setPrecioPorMes(double precioPorMes) {
		this.precioPorMes = precioPorMes;
	}

	public Vector<Cliente> getInscritos() {
		return inscritos;
	}

	public void setInscritos(Vector<Cliente> inscritos) {
		this.inscritos = inscritos;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Vector<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Vector<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	

}