package presentacion.reservas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import dominio.Reserva;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;



@SuppressWarnings({ "serial" })
public class panelReserva extends JPanel {
	
	/***********************************PARAMETROS************************************/
	
	private int id;
	private JLabel lblNEstancia;
	private JLabel lblNCliente;
	private JLabel lblTelefono;
	private JLabel lblFechaIni;
	private JLabel lblFechaFin;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelReserva(int identifier,Reserva reserva) {
		setPreferredSize(new Dimension(1025, 100));
		
		setId(identifier);
		setMaximumSize(new Dimension(32767, 100));
		setMinimumSize(new Dimension(10, 100));
		setBackground(new Color(42,46,49));
		setVisible(true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 5, 0, 0));
		
		lblNEstancia = new JLabel(reserva.getnombreEstancia());
		lblNEstancia.setBorder(new EmptyBorder(0, 60, 0, 0));
		lblNEstancia.setForeground(Color.WHITE);
		lblNEstancia.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblNEstancia);
		
		lblNCliente = new JLabel(reserva.getNombreCliente());
		lblNCliente.setForeground(Color.WHITE);
		lblNCliente.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblNCliente);
		
		lblTelefono = new JLabel(reserva.getTelefono());
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblTelefono);
		
		lblFechaIni = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(reserva.getfechaEntrada()));
		lblFechaIni.setForeground(Color.WHITE);
		lblFechaIni.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblFechaIni);
		
		lblFechaFin = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(reserva.getfechaSalida()));
		lblFechaFin.setForeground(Color.WHITE);
		lblFechaFin.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblFechaFin);
		
		reserva.getfechaEntrada();

	}

	/*******************************METODOS AUXILIARES********************************/
	
	
	/*******************************GETTERS AND SETTERS*******************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
