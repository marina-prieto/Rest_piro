package dominio;

import java.io.File;
import java.util.Date;
import java.util.Vector;

public class Ruta extends Evento {

	private String puntoDeEncuentro;
	private int dificultad;

	public Ruta(String nombre, int cupoMinimo, String monitor, int cupoMaximo, String horaInicio, String horaFinal,
			Date fecha, String descripcion, Vector<String> equipamientoNecesario,File foto ,String puntoDeEncuentro,
			int dificultad) {
		super(nombre, cupoMinimo, monitor, cupoMaximo, horaInicio, horaFinal, fecha, descripcion,
				equipamientoNecesario, foto);
		this.puntoDeEncuentro = puntoDeEncuentro;
		this.dificultad = dificultad;
	}

	public String getPuntoDeEncuentro() {
		return puntoDeEncuentro;
	}

	public void setPuntoDeEncuentro(String puntoDeEncuentro) {
		this.puntoDeEncuentro = puntoDeEncuentro;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	
	
}