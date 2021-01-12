package presentacion.actividades;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import presentacion.actividades.panelActividades.BtnCerrarDespComentariosActionListener;
import presentacion.actividades.panelActividades.BtnComentariosActionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings({ "serial" })
public class panelActividadPasada extends JPanel {
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JButton btnComentarios;
	private JLabel lblNombreActividad;
	private JLabel lblMonitorOut;
	private JLabel lblPuntuacion;
	private JLabel lblPuntuacionOut;
	private JLabel lblMonitor;
	private JPanel pnlFotoActividad;
	private JLabel lblFotoActividad;
	private JLabel lblDestinatario;
	private JLabel lblPrecioPorMes;
	private JButton btnCerrarComentarios;
		
	/***********************************CONSTRUCTOR***********************************/
	
	public panelActividadPasada(BtnComentariosActionListener btnComentariosActionListener, 
			BtnCerrarDespComentariosActionListener btnCerrarComentariosActionListener) {
		setPreferredSize(new Dimension(10, 230));
		setMinimumSize(new Dimension(10, 230));
		setBackground(new Color(42,46,49));
		setBounds(new Rectangle(0, 0, 0, 144));
		setMaximumSize(new Dimension(32767, 230));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{189, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{144, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		pnlFotoActividad = new JPanel();
		pnlFotoActividad.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlFotoActividad = new GridBagConstraints();
		gbc_pnlFotoActividad.insets = new Insets(0, 0, 0, 5);
		gbc_pnlFotoActividad.fill = GridBagConstraints.BOTH;
		gbc_pnlFotoActividad.gridx = 0;
		gbc_pnlFotoActividad.gridy = 0;
		add(pnlFotoActividad, gbc_pnlFotoActividad);
		GridBagLayout gbl_pnlFotoActividad = new GridBagLayout();
		gbl_pnlFotoActividad.columnWidths = new int[] {150};
		gbl_pnlFotoActividad.rowHeights = new int[] {5, 130, 5, 0};
		gbl_pnlFotoActividad.columnWeights = new double[]{0.0};
		gbl_pnlFotoActividad.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlFotoActividad.setLayout(gbl_pnlFotoActividad);
		
		lblDestinatario = new JLabel(btnComentariosActionListener.getActividad().getDestinatario());
		lblDestinatario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDestinatario.setForeground(Color.WHITE);
		lblDestinatario.setBorder(new EmptyBorder(7, 20, 0, 30));
		GridBagConstraints gbc_lblDestinatario = new GridBagConstraints();
		gbc_lblDestinatario.anchor = GridBagConstraints.WEST;
		gbc_lblDestinatario.insets = new Insets(0, 0, 5, 0);
		gbc_lblDestinatario.gridx = 0;
		gbc_lblDestinatario.gridy = 0;
		pnlFotoActividad.add(lblDestinatario, gbc_lblDestinatario);
		
		lblFotoActividad = new JLabel("");
		lblFotoActividad.setForeground(Color.WHITE);
		lblFotoActividad.setBorder(new EmptyBorder(7, 20, 0, 30));
		lblFotoActividad.setSize(new Dimension(150, 150));
		
		File file = btnComentariosActionListener.getActividad().getFoto();
		setFotoActividad(file);
		
		GridBagConstraints gbc_lblFotoActividad = new GridBagConstraints();
		gbc_lblFotoActividad.insets = new Insets(0, 0, 5, 0);
		gbc_lblFotoActividad.gridx = 0;
		gbc_lblFotoActividad.gridy = 1;
		pnlFotoActividad.add(lblFotoActividad, gbc_lblFotoActividad);
		
		lblPrecioPorMes = new JLabel(btnComentariosActionListener.getActividad().getPrecioPorMes()+"€ / Mes");
		lblPrecioPorMes.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPrecioPorMes.setForeground(Color.WHITE);
		lblPrecioPorMes.setBorder(new EmptyBorder(7, 20, 0, 30));
		GridBagConstraints gbc_lblPrecioPorMes = new GridBagConstraints();
		gbc_lblPrecioPorMes.gridx = 0;
		gbc_lblPrecioPorMes.gridy = 2;
		pnlFotoActividad.add(lblPrecioPorMes, gbc_lblPrecioPorMes);
		
		pnlInformacion = new JPanel();
		pnlInformacion.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlInformacion = new GridBagConstraints();
		gbc_pnlInformacion.anchor = GridBagConstraints.WEST;
		gbc_pnlInformacion.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInformacion.fill = GridBagConstraints.VERTICAL;
		gbc_pnlInformacion.gridx = 1;
		gbc_pnlInformacion.gridy = 0;
		add(pnlInformacion, gbc_pnlInformacion);
		GridBagLayout gbl_pnlInformacion = new GridBagLayout();
		gbl_pnlInformacion.columnWidths = new int[]{0, 108, 0, 0, 0, 0, 0, 0};
		gbl_pnlInformacion.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlInformacion.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInformacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlInformacion.setLayout(gbl_pnlInformacion);
		
		lblNombreActividad = new JLabel(btnComentariosActionListener.getActividad().getNombre());
		lblNombreActividad.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblNombreActividad.setForeground(Color.WHITE);
		lblNombreActividad.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreActividad.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombreActividad = new GridBagConstraints();
		gbc_lblNombreActividad.anchor = GridBagConstraints.WEST;
		gbc_lblNombreActividad.gridwidth = 5;
		gbc_lblNombreActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreActividad.gridx = 1;
		gbc_lblNombreActividad.gridy = 0;
		pnlInformacion.add(lblNombreActividad, gbc_lblNombreActividad);
		
		lblMonitor = new JLabel("Monitor:");
		lblMonitor.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblMonitor.setForeground(Color.WHITE);
		lblMonitor.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 1;
		gbc_lblMonitor.gridy = 2;
		pnlInformacion.add(lblMonitor, gbc_lblMonitor);
		
		lblMonitorOut = new JLabel(btnComentariosActionListener.getActividad().getMonitor());
		lblMonitorOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblMonitorOut.setForeground(Color.WHITE);
		lblMonitorOut.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMonitorOut = new GridBagConstraints();
		gbc_lblMonitorOut.anchor = GridBagConstraints.WEST;
		gbc_lblMonitorOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorOut.gridx = 2;
		gbc_lblMonitorOut.gridy = 2;
		pnlInformacion.add(lblMonitorOut, gbc_lblMonitorOut);
		
		lblPuntuacion = new JLabel("Puntuacion:");
		lblPuntuacion.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblPuntuacion.setForeground(Color.WHITE);
		lblPuntuacion.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPuntuacion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPuntuacion = new GridBagConstraints();
		gbc_lblPuntuacion.anchor = GridBagConstraints.EAST;
		gbc_lblPuntuacion.insets = new Insets(0, 0, 0, 5);
		gbc_lblPuntuacion.gridx = 1;
		gbc_lblPuntuacion.gridy = 3;
		pnlInformacion.add(lblPuntuacion, gbc_lblPuntuacion);
		
		lblPuntuacionOut = new JLabel("");
		lblPuntuacionOut.setIcon(new ImageIcon(panelActividadPasada.class.getResource("/presentacion/recursos/PuntuacionEstrellas.png")));
		lblPuntuacionOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblPuntuacionOut.setForeground(Color.WHITE);
		lblPuntuacionOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPuntuacionOut = new GridBagConstraints();
		gbc_lblPuntuacionOut.anchor = GridBagConstraints.WEST;
		gbc_lblPuntuacionOut.insets = new Insets(0, 0, 0, 5);
		gbc_lblPuntuacionOut.gridx = 2;
		gbc_lblPuntuacionOut.gridy = 3;
		pnlInformacion.add(lblPuntuacionOut, gbc_lblPuntuacionOut);
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 2;
		gbc_pnlBotones.gridy = 0;
		add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] {0, 0, 20};
		gbl_pnlBotones.rowHeights = new int[] {0, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		btnComentarios = new JButton("Comentarios");
		btnComentarios.addMouseListener(new BtnComentariosMouseListener());
		btnComentarios.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnComentarios.setPreferredSize(new Dimension(100, 33));
		btnComentarios.setForeground(Color.WHITE);
		btnComentarios.setBorder(null);
		btnComentarios.setBackground(new Color(189,90,249));
		btnComentarios.addActionListener(btnComentariosActionListener);
		btnComentarios.addActionListener(new btnMostrarCerrarComentarios());
		
		GridBagConstraints gbc_btnComentarios = new GridBagConstraints();
		gbc_btnComentarios.insets = new Insets(0, 0, 0, 5);
		gbc_btnComentarios.gridx = 0;
		gbc_btnComentarios.gridy = 1;
		pnlBotones.add(btnComentarios, gbc_btnComentarios);
		
		btnCerrarComentarios = new JButton("Cerrar Comentarios");
		btnCerrarComentarios.addMouseListener(new BtnCerrarComentariosMouseListener());
		btnCerrarComentarios.setVisible(false);
		btnCerrarComentarios.setPreferredSize(new Dimension(140, 33));
		btnCerrarComentarios.setForeground(Color.WHITE);
		btnCerrarComentarios.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCerrarComentarios.setBorder(null);
		btnCerrarComentarios.setBackground(new Color(255,71,71));
		btnCerrarComentarios.addActionListener(btnCerrarComentariosActionListener);
		btnCerrarComentarios.addActionListener(new btnMostrarComentarios());
		GridBagConstraints gbc_btnCerrarComentarios = new GridBagConstraints();
		gbc_btnCerrarComentarios.gridx = 1;
		gbc_btnCerrarComentarios.gridy = 1;
		pnlBotones.add(btnCerrarComentarios, gbc_btnCerrarComentarios);

	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnComentariosMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnComentarios.setBackground(new Color(185,81,249));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnComentarios.setBackground(new Color(189,90,249));
		}
	}
	
	private class BtnCerrarComentariosMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCerrarComentarios.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCerrarComentarios.setBackground(new Color(255,71,71));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	
	private void setFotoActividad (File file) {
		try {
            Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoActividad.getWidth(),
            lblFotoActividad.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoActividad.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private class btnMostrarCerrarComentarios implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnCerrarComentarios.setVisible(true);
			btnComentarios.setVisible(false);
		}
	}
	
	private class btnMostrarComentarios implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnCerrarComentarios.setVisible(false);
			btnComentarios.setVisible(true);
		}
	}
	
	
}
