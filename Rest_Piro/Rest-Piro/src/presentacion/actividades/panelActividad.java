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

import presentacion.actividades.panelActividades.BtnDarDeBajaActividadActionListener;
import presentacion.actividades.panelActividades.BtnVerMasActividadActionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings({ "serial" })
public class panelActividad extends JPanel {
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JButton btnFinalizarActividad;
	private JButton btnVerMas;
	private JLabel lblNombreActividad;
	private JLabel lblMonitorOut;
	private JLabel lblEquipamiento;
	private JLabel lblCupo;
	private JLabel lblHorario;
	private JLabel lblEquipamientoOut;
	private JLabel lblCupoOut;
	private JLabel lblHorarioOut;
	private JLabel lblMonitor;
	private JPanel pnlFotoActividad;
	private JLabel lblFotoActividad;
	private JLabel lblDestinatario;
	private JLabel lblPrecioPorMes;
	private JLabel lblSeparador;
	private JLabel lblAvisoFinalizarActividad;
	private JButton btnCancelarFinalizarActividad;
	private JButton btnConfirmarFinalizarActividad;
	
	/***********************************PARAMETROS************************************/
	
	private int id;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelActividad(BtnDarDeBajaActividadActionListener btnDarDeBajaActividadActionListener, 
			BtnVerMasActividadActionListener btnVerMasActividadActionListener, int identifier) {
		setPreferredSize(new Dimension(10, 230));
		
		setId(identifier);
		setBackground(new Color(42,46,49));
		setMinimumSize(new Dimension(10, 230));
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
		gbl_pnlFotoActividad.columnWidths = new int[] {150, 0};
		gbl_pnlFotoActividad.rowHeights = new int[] {5, 130, 5, 0};
		gbl_pnlFotoActividad.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlFotoActividad.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlFotoActividad.setLayout(gbl_pnlFotoActividad);
		
		lblDestinatario = new JLabel(btnVerMasActividadActionListener.getActividad().getDestinatario());
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
		lblFotoActividad.setBorder(new EmptyBorder(7, 20, 0, 30));
		lblFotoActividad.setSize(new Dimension(150, 150));
		
		File file = btnVerMasActividadActionListener.getActividad().getFoto();
		setFotoActividad(file);
		
		GridBagConstraints gbc_lblFotoActividad = new GridBagConstraints();
		gbc_lblFotoActividad.insets = new Insets(0, 0, 5, 0);
		gbc_lblFotoActividad.gridx = 0;
		gbc_lblFotoActividad.gridy = 1;
		pnlFotoActividad.add(lblFotoActividad, gbc_lblFotoActividad);
		
		lblPrecioPorMes = new JLabel(btnVerMasActividadActionListener.getActividad().getPrecioPorMes()+"€ / Mes");
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
		gbl_pnlInformacion.columnWidths = new int[]{0, 108, 0, 0, 0};
		gbl_pnlInformacion.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlInformacion.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInformacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlInformacion.setLayout(gbl_pnlInformacion);
		
		lblNombreActividad = new JLabel(btnVerMasActividadActionListener.getActividad().getNombre());
		lblNombreActividad.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblNombreActividad.setForeground(Color.WHITE);
		lblNombreActividad.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreActividad.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombreActividad = new GridBagConstraints();
		gbc_lblNombreActividad.anchor = GridBagConstraints.WEST;
		gbc_lblNombreActividad.gridwidth = 2;
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
		
		lblMonitorOut = new JLabel(btnVerMasActividadActionListener.getActividad().getMonitor());
		lblMonitorOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblMonitorOut.setForeground(Color.WHITE);
		lblMonitorOut.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMonitorOut = new GridBagConstraints();
		gbc_lblMonitorOut.anchor = GridBagConstraints.WEST;
		gbc_lblMonitorOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorOut.gridx = 2;
		gbc_lblMonitorOut.gridy = 2;
		pnlInformacion.add(lblMonitorOut, gbc_lblMonitorOut);
		
		lblEquipamiento = new JLabel("Equipamiento:");
		lblEquipamiento.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblEquipamiento.setForeground(Color.WHITE);
		lblEquipamiento.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEquipamiento.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEquipamiento = new GridBagConstraints();
		gbc_lblEquipamiento.anchor = GridBagConstraints.EAST;
		gbc_lblEquipamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipamiento.gridx = 1;
		gbc_lblEquipamiento.gridy = 3;
		pnlInformacion.add(lblEquipamiento, gbc_lblEquipamiento);
		
		lblEquipamientoOut = new JLabel("Ropa Comoda - Algo para beber");
		lblEquipamientoOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblEquipamientoOut.setForeground(Color.WHITE);
		lblEquipamientoOut.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEquipamientoOut = new GridBagConstraints();
		gbc_lblEquipamientoOut.anchor = GridBagConstraints.WEST;
		gbc_lblEquipamientoOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipamientoOut.gridx = 2;
		gbc_lblEquipamientoOut.gridy = 3;
		pnlInformacion.add(lblEquipamientoOut, gbc_lblEquipamientoOut);
		
		lblCupo = new JLabel("Cupo:");
		lblCupo.setBorder(new EmptyBorder(0, 30, 0, 0));
		lblCupo.setForeground(Color.WHITE);
		lblCupo.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 1;
		gbc_lblCupo.gridy = 4;
		pnlInformacion.add(lblCupo, gbc_lblCupo);
		
		lblCupoOut = new JLabel(Integer.toString(btnVerMasActividadActionListener.getActividad().getCupoMinimo())+" - "+
								  Integer.toString(btnVerMasActividadActionListener.getActividad().getCupoMaximo()));
		lblCupoOut.setVerticalTextPosition(SwingConstants.TOP);
		lblCupoOut.setVerticalAlignment(SwingConstants.TOP);
		lblCupoOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblCupoOut.setForeground(Color.WHITE);
		lblCupoOut.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCupoOut = new GridBagConstraints();
		gbc_lblCupoOut.anchor = GridBagConstraints.WEST;
		gbc_lblCupoOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoOut.gridx = 2;
		gbc_lblCupoOut.gridy = 4;
		pnlInformacion.add(lblCupoOut, gbc_lblCupoOut);
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setBorder(new EmptyBorder(0, 30, 0, 0));
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 5;
		pnlInformacion.add(lblHorario, gbc_lblHorario);
		
		lblHorarioOut = new JLabel(btnVerMasActividadActionListener.getActividad().getHoraInicio()+"h - "+
									btnVerMasActividadActionListener.getActividad().getHoraFinal()+"h");
		lblHorarioOut.setVerticalTextPosition(SwingConstants.TOP);
		lblHorarioOut.setVerticalAlignment(SwingConstants.TOP);
		lblHorarioOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblHorarioOut.setForeground(Color.WHITE);
		lblHorarioOut.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHorarioOut = new GridBagConstraints();
		gbc_lblHorarioOut.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorarioOut.anchor = GridBagConstraints.WEST;
		gbc_lblHorarioOut.gridx = 2;
		gbc_lblHorarioOut.gridy = 5;
		pnlInformacion.add(lblHorarioOut, gbc_lblHorarioOut);
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 2;
		gbc_pnlBotones.gridy = 0;
		add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] {0, 0, 0, 0, 20};
		gbl_pnlBotones.rowHeights = new int[] {0, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		btnFinalizarActividad = new JButton("Finalizar...");
		btnFinalizarActividad.addMouseListener(new BtnFinalizarActividadMouseListener());
		btnFinalizarActividad.addActionListener(new BtnFinalizarActividadActionListener());
		btnFinalizarActividad.setPreferredSize(new Dimension(95, 33));
		btnFinalizarActividad.setForeground(Color.WHITE);
		btnFinalizarActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnFinalizarActividad.setBorder(null);
		btnFinalizarActividad.setBackground(Color.DARK_GRAY);
		
		lblAvisoFinalizarActividad = new JLabel("¿Finalizar esta actividad?");
		lblAvisoFinalizarActividad.setVisible(false);
		
		btnVerMas = new JButton("Ver mas...");
		btnVerMas.addMouseListener(new BtnVerMasMouseListener());
		btnVerMas.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnVerMas.setPreferredSize(new Dimension(95, 33));
		btnVerMas.setForeground(Color.WHITE);
		btnVerMas.setBorder(null);
		btnVerMas.setBackground(new Color(189,90,249));
		btnVerMas.addActionListener(btnVerMasActividadActionListener);
		GridBagConstraints gbc_btnVerMas = new GridBagConstraints();
		gbc_btnVerMas.anchor = GridBagConstraints.SOUTH;
		gbc_btnVerMas.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerMas.gridx = 0;
		gbc_btnVerMas.gridy = 0;
		pnlBotones.add(btnVerMas, gbc_btnVerMas);
		lblAvisoFinalizarActividad.setForeground(Color.WHITE);
		lblAvisoFinalizarActividad.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAvisoFinalizarActividad = new GridBagConstraints();
		gbc_lblAvisoFinalizarActividad.gridwidth = 2;
		gbc_lblAvisoFinalizarActividad.insets = new Insets(0, 0, 5, 0);
		gbc_lblAvisoFinalizarActividad.gridx = 2;
		gbc_lblAvisoFinalizarActividad.gridy = 0;
		pnlBotones.add(lblAvisoFinalizarActividad, gbc_lblAvisoFinalizarActividad);
		GridBagConstraints gbc_btnFinalizarActividad = new GridBagConstraints();
		gbc_btnFinalizarActividad.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizarActividad.gridx = 0;
		gbc_btnFinalizarActividad.gridy = 1;
		pnlBotones.add(btnFinalizarActividad, gbc_btnFinalizarActividad);
		
		lblSeparador = new JLabel("");
		lblSeparador.setVisible(false);
		lblSeparador.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblSeparador.setIcon(new ImageIcon(panelActividad.class.getResource("/presentacion/recursos/SeparadorVertical.png")));
		GridBagConstraints gbc_lblSeparador = new GridBagConstraints();
		gbc_lblSeparador.gridheight = 2;
		gbc_lblSeparador.insets = new Insets(0, 0, 0, 5);
		gbc_lblSeparador.gridx = 1;
		gbc_lblSeparador.gridy = 0;
		pnlBotones.add(lblSeparador, gbc_lblSeparador);
		
		btnCancelarFinalizarActividad = new JButton("Cancelar");
		btnCancelarFinalizarActividad.addMouseListener(new BtnCancelarFinalizarActividadMouseListener());
		btnCancelarFinalizarActividad.setVisible(false);
		btnCancelarFinalizarActividad.addActionListener(new BtnCancelarFinalizarActividadActionListener());
		btnCancelarFinalizarActividad.setPreferredSize(new Dimension(95, 33));
		btnCancelarFinalizarActividad.setForeground(Color.WHITE);
		btnCancelarFinalizarActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarFinalizarActividad.setBorder(null);
		btnCancelarFinalizarActividad.setBackground(new Color(0,120,210));
		GridBagConstraints gbc_btnCancelarFinalizarActividad = new GridBagConstraints();
		gbc_btnCancelarFinalizarActividad.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarFinalizarActividad.gridx = 2;
		gbc_btnCancelarFinalizarActividad.gridy = 1;
		pnlBotones.add(btnCancelarFinalizarActividad, gbc_btnCancelarFinalizarActividad);
		
		btnConfirmarFinalizarActividad = new JButton("Finalizar");
		btnConfirmarFinalizarActividad.addMouseListener(new BtnConfirmarFinalizarActividadMouseListener());
		btnConfirmarFinalizarActividad.setVisible(false);
		btnConfirmarFinalizarActividad.setPreferredSize(new Dimension(95, 33));
		btnConfirmarFinalizarActividad.setForeground(Color.WHITE);
		btnConfirmarFinalizarActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnConfirmarFinalizarActividad.setBorder(null);
		btnConfirmarFinalizarActividad.setBackground(new Color(255,71,71));
		btnConfirmarFinalizarActividad.addActionListener(btnDarDeBajaActividadActionListener);
		GridBagConstraints gbc_btnConfirmarFinalizarActividad = new GridBagConstraints();
		gbc_btnConfirmarFinalizarActividad.gridx = 3;
		gbc_btnConfirmarFinalizarActividad.gridy = 1;
		pnlBotones.add(btnConfirmarFinalizarActividad, gbc_btnConfirmarFinalizarActividad);

	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnConfirmarFinalizarActividadMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnConfirmarFinalizarActividad.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnConfirmarFinalizarActividad.setBackground(new Color(255,71,71));
		}
	}
	
	private class BtnCancelarFinalizarActividadMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarFinalizarActividad.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarFinalizarActividad.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnVerMasMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnVerMas.setBackground(new Color(185,81,249));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnVerMas.setBackground(new Color(189,90,249));
		}
	}
	
	private class BtnFinalizarActividadMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnFinalizarActividad.setBackground(new Color(76,83,88));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnFinalizarActividad.setBackground(new Color(64,64,64));
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
	
	private class BtnFinalizarActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblAvisoFinalizarActividad.setVisible(true);
			lblSeparador.setVisible(true);
			btnCancelarFinalizarActividad.setVisible(true);
			btnConfirmarFinalizarActividad.setVisible(true);
		}
	}
	
	private class BtnCancelarFinalizarActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblAvisoFinalizarActividad.setVisible(false);
			lblSeparador.setVisible(false);
			btnCancelarFinalizarActividad.setVisible(false);
			btnConfirmarFinalizarActividad.setVisible(false);
		}
	}

	/*******************************GETTERS AND SETTERS*******************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
