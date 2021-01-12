package dominio;
import java.io.File;
import java.util.Date;
import java.util.Vector;
public abstract class Evento {

	private String nombre;
	private int cupoMinimo;
	private String monitor;
	private int cupoMaximo;
	private String horaInicio;
	private String horaFinal;
	private Date fecha;
	private String descripcion;
	private Vector<String> equipamientoNecesario;
	private File foto;
	
	public Evento(String nombre, int cupoMinimo, String monitor, int cupoMaximo, String horaInicio, String horaFinal,
			Date fecha, String descripcion, Vector<String> equipamientoNecesario, File foto) {
		super();
		this.nombre = nombre;
		this.cupoMinimo = cupoMinimo;
		this.monitor = monitor;
		this.cupoMaximo = cupoMaximo;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.equipamientoNecesario = equipamientoNecesario;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupoMinimo() {
		return cupoMinimo;
	}

	public void setCupoMinimo(int cupoMinimo) {
		this.cupoMinimo = cupoMinimo;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Vector<String> getEquipamientoNecesario() {
		return equipamientoNecesario;
	}

	public void setEquipamientoNecesario(Vector<String> equipamientoNecesario) {
		this.equipamientoNecesario = equipamientoNecesario;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}
	
}