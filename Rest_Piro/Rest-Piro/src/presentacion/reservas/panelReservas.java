package presentacion.reservas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import dominio.Reserva;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({"serial","unused"})
public class panelReservas extends JPanel {
	private JPanel pnlBarraSuperior;
	private JLabel lblTitle;
	private JPanel pnlBotonesBarraSuperior;
	private JButton btnHistorial;
	private JPanel principalCardLayout;
	private JPanel pnlPrincipalReservasActivas;
	private JPanel pnlPrincipalReservasPasadas;
	private JScrollPane scrlReservasActivas;
	private JPanel pnlListaReservasActivas;
	private JScrollPane scrlReservasPasadas;
	private JPanel pnlListaReservasPasadas;
	
	/***********************************PARAMETROS************************************/
	private Vector<Integer> identifiers = new Vector<Integer>();
	private int globalId = -1;
	private JButton btnAtras;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelReservas() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		pnlBarraSuperior = new JPanel();
		pnlBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.setBorder(null);
		add(pnlBarraSuperior, BorderLayout.NORTH);
		pnlBarraSuperior.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblTitle = new JLabel("RESERVAS");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBorder(new EmptyBorder(30, 50, 40, 0));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 46));
		pnlBarraSuperior.add(lblTitle);
		
		pnlBotonesBarraSuperior = new JPanel();
		pnlBotonesBarraSuperior.setBorder(null);
		pnlBotonesBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.add(pnlBotonesBarraSuperior);
		GridBagLayout gbl_pnlBotonesBarraSuperior = new GridBagLayout();
		gbl_pnlBotonesBarraSuperior.columnWidths = new int[] {0, 80, 80, 80, 80, 50};
		gbl_pnlBotonesBarraSuperior.rowHeights = new int[] {0, 20, 0};
		gbl_pnlBotonesBarraSuperior.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlBotonesBarraSuperior.rowWeights = new double[]{1.0, 1.0, 1.0};
		pnlBotonesBarraSuperior.setLayout(gbl_pnlBotonesBarraSuperior);
		
		btnHistorial = new JButton();
		btnHistorial.setText("Historial");
		btnHistorial.addMouseListener(new BtnHistorialMouseListener());
		btnHistorial.setBorder(null);
		btnHistorial.setBackground(new Color(0,120,210));
		btnHistorial.setForeground(Color.WHITE);
		btnHistorial.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnHistorial.addActionListener(new BtnHistorialActionListener());
		
		btnAtras = new JButton();
		btnAtras.setVisible(false);
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setText("Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(0, 120, 210));
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.fill = GridBagConstraints.BOTH;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 3;
		gbc_btnAtras.gridy = 1;
		pnlBotonesBarraSuperior.add(btnAtras, gbc_btnAtras);
		GridBagConstraints gbc_btnHistorial = new GridBagConstraints();
		gbc_btnHistorial.fill = GridBagConstraints.BOTH;
		gbc_btnHistorial.insets = new Insets(0, 0, 5, 5);
		gbc_btnHistorial.gridx = 4;
		gbc_btnHistorial.gridy = 1;
		pnlBotonesBarraSuperior.add(btnHistorial, gbc_btnHistorial);
		
		principalCardLayout = new JPanel();
		principalCardLayout.setBorder(null);
		principalCardLayout.setBackground(Color.BLACK);
		add(principalCardLayout, BorderLayout.CENTER);
		principalCardLayout.setLayout(new CardLayout(0, 0));
		
		pnlPrincipalReservasActivas = new JPanel();
		pnlPrincipalReservasActivas.setBorder(null);
		pnlPrincipalReservasActivas.setBackground(new Color(31,34,40));
		principalCardLayout.add(pnlPrincipalReservasActivas, "Principal Reservas Activas");
		pnlPrincipalReservasActivas.setLayout(new BorderLayout(0, 0));
		
		
		scrlReservasActivas = new JScrollPane();
		
//		scrlReservasActivas.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrlReservasActivas.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrlReservasActivas.setBorder(null);
		scrlReservasActivas.setBackground(new Color(31,34,40));
		pnlPrincipalReservasActivas.add(scrlReservasActivas, BorderLayout.CENTER);
		
		pnlListaReservasActivas = new JPanel();
		pnlListaReservasActivas.setBorder(null);
		pnlListaReservasActivas.setBackground(new Color(31,34,40));
		scrlReservasActivas.setViewportView(pnlListaReservasActivas);
		pnlListaReservasActivas.setLayout(new BoxLayout(pnlListaReservasActivas, BoxLayout.Y_AXIS));
		
		pnlPrincipalReservasPasadas = new JPanel();
		pnlPrincipalReservasPasadas.setBorder(null);
		pnlPrincipalReservasPasadas.setBackground(new Color(31,34,40));
		principalCardLayout.add(pnlPrincipalReservasPasadas, "Principal Reservas Pasadas");
		pnlPrincipalReservasPasadas.setLayout(new BorderLayout(0, 0));
		
		scrlReservasPasadas = new JScrollPane();
		
//		scrlActividadesPasadas.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrlActividadesPasadas.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrlReservasPasadas.setBorder(null);
		scrlReservasPasadas.setBackground(new Color(31,34,40));
		pnlPrincipalReservasPasadas.add(scrlReservasPasadas, BorderLayout.CENTER);
		
		pnlListaReservasPasadas = new JPanel();
		pnlListaReservasPasadas.setBorder(null);
		pnlListaReservasPasadas.setBackground(new Color(31,34,40));
		scrlReservasPasadas.setViewportView(pnlListaReservasPasadas);
		pnlListaReservasPasadas.setLayout(new BoxLayout(pnlListaReservasPasadas, BoxLayout.Y_AXIS));
		
		llenarReservas();
	}//End of the principal class
	
	/*********************************MAIN LISTENERS**********************************/
	
	private class BtnHistorialActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			cambiarBoton("ReservasPasadas");
			
			CardLayout cl = (CardLayout)(principalCardLayout.getLayout());
			cl.show(principalCardLayout, "Principal Reservas Pasadas");
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			cambiarBoton("ReservasActivas");
			
			CardLayout cl = (CardLayout)(principalCardLayout.getLayout());
			cl.show(principalCardLayout, "Principal Reservas Activas");
		}
	}
	
	/**************************ACTIVIDADES ACTIVAS LISTENERS**************************/
	
	
	
	/**************************ACTIVIDADES PASADAS LISTENERS**************************/
	
	private class BtnHistorialMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnHistorial.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnHistorial.setBackground(new Color(0,120,210));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	
	private void cambiarBoton (String tipo) {
		
		if (tipo.equals("ReservasActivas")) {
			btnHistorial.setVisible(true);
			btnAtras.setVisible(false);
		}
		
		if (tipo.equals("ReservasPasadas")) {
			btnHistorial.setVisible(false);
			btnAtras.setVisible(true);
		}
		
	}
	
	private void llenarReservas () {
		
		Date date = new Date();
		
		Reserva reserva1 = new Reserva("Josue Carlos Zenteno Yave", "+34 - 612-34-56-78", 4, date, date," ", "Casita");
		pnlListaReservasPasadas.add(new panelReserva(0, reserva1));
		
		Reserva reserva2 = new Reserva("Sergio Silvestre Pavón", "+34 - 614-35-56-35", 2, date, date," ", "Parcelon");
		pnlListaReservasPasadas.add(new panelReserva(1, reserva2));
		
		Reserva reserva3 = new Reserva("Marina Prieto Pech", "+34 - 623-44-09-54", 3, date, date," ", "Marina d'or");
		pnlListaReservasPasadas.add(new panelReserva(2, reserva3));
		
		Reserva reserva4 = new Reserva("Ibai Llanos", "+34 - 612-34-56-78", 4, date, date," ", "Parcelita");
		pnlListaReservasActivas.add(new panelReserva(3, reserva4));
		
		Reserva reserva5 = new Reserva("Pablo Iglesias", "+34 - 614-33-33-35", 1, date, date," ", "El casoplón del coletas");
		pnlListaReservasActivas.add(new panelReserva(4, reserva5));
		
		Reserva reserva6 = new Reserva("Pedro Sánchez", "+34 - 623-44-09-54", 2, date, date," ", "La moncloa");
		pnlListaReservasActivas.add(new panelReserva(5, reserva6));
	}

}