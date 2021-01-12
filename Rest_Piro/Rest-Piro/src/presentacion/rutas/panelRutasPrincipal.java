package presentacion.rutas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import presentacion.rutas.panelRutasMain.DarDeBaja;
import presentacion.rutas.panelRutasMain.GuardarInfo;

import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class panelRutasPrincipal extends JPanel {
	private JLabel lblNombre;
	private JLabel lblMonitor;
	private JLabel lblDia;
	private JLabel lblDificultad;
	private JLabel lblCupo;
	private JLabel lblDuracion;
	private JLabel lblPuntoEncuentro;
	private JButton btnEditar;
	private JScrollPane scrollPane;
	private JTextArea taDescripcion;
	private JLabel lblMonitorInfo;
	private JLabel lblDiaInfo;
	private JLabel lblDificultadInfo;
	private JLabel lblCupoInfo;
	private JLabel lblDuracionInfo;
	private JLabel lblPuntoEncuentroInfo;
	private JButton btnEliminar;
	private JLabel lblSeparador;
	private JButton btnCancelar;
	private JButton btnEliminarConfirmar;
	private JLabel lblAviso;
	
	/***********************************PARAMETROS************************************/
	private ActionListener mostrar_editar_listen;
	private GuardarInfo guardar_info_listen;
	private JPanel panel_editar;
	private int particularId;
	private DarDeBaja dar_de_baja_listen;
	private Component frame;

	/***********************************CONSTRUCTOR***********************************/
	public panelRutasPrincipal(ActionListener mostrarEditar, GuardarInfo guardarInfo, JPanel pnlEditar, DarDeBaja darDeBaja) {
		mostrar_editar_listen = mostrarEditar;
		guardar_info_listen = guardarInfo;
		panel_editar = pnlEditar;
		dar_de_baja_listen = darDeBaja;
		
		setMaximumSize(new Dimension(32767, 350));
		setBackground(new Color(42,46,49));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 50, 50, 15, 50, 50, 15, 100, 0, 0, 0, 15};
		gridBagLayout.rowHeights = new int[]{15, 35, 15, 33, 33, 33, 15, 33, 33, 33, 33, 15};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		lblNombre = new JLabel("Ruta chikita");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		lblMonitor = new JLabel("Monitor: ");
		lblMonitor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMonitor.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 1;
		gbc_lblMonitor.gridy = 3;
		add(lblMonitor, gbc_lblMonitor);
		
		lblMonitorInfo = new JLabel("");
		lblMonitorInfo.setForeground(Color.WHITE);
		lblMonitorInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblMonitorInfo = new GridBagConstraints();
		gbc_lblMonitorInfo.anchor = GridBagConstraints.WEST;
		gbc_lblMonitorInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorInfo.gridx = 2;
		gbc_lblMonitorInfo.gridy = 3;
		add(lblMonitorInfo, gbc_lblMonitorInfo);
		
		lblCupo = new JLabel("Cupo: ");
		lblCupo.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCupo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 4;
		gbc_lblCupo.gridy = 3;
		add(lblCupo, gbc_lblCupo);
		
		lblCupoInfo = new JLabel("");
		lblCupoInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblCupoInfo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCupoInfo = new GridBagConstraints();
		gbc_lblCupoInfo.anchor = GridBagConstraints.WEST;
		gbc_lblCupoInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoInfo.gridx = 5;
		gbc_lblCupoInfo.gridy = 3;
		add(lblCupoInfo, gbc_lblCupoInfo);
		
		lblDificultad = new JLabel("Dificultad: ");
		lblDificultad.setForeground(Color.WHITE);
		lblDificultad.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 4;
		add(lblDificultad, gbc_lblDificultad);
		
		lblDificultadInfo = new JLabel("");
		lblDificultadInfo.setForeground(Color.WHITE);
		lblDificultadInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblDificultadInfo = new GridBagConstraints();
		gbc_lblDificultadInfo.anchor = GridBagConstraints.WEST;
		gbc_lblDificultadInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultadInfo.gridx = 2;
		gbc_lblDificultadInfo.gridy = 4;
		add(lblDificultadInfo, gbc_lblDificultadInfo);
		
		lblDia = new JLabel("Dia: ");
		lblDia.setForeground(Color.WHITE);
		lblDia.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 4;
		gbc_lblDia.gridy = 4;
		add(lblDia, gbc_lblDia);
		
		lblDiaInfo = new JLabel("");
		lblDiaInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblDiaInfo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDiaInfo = new GridBagConstraints();
		gbc_lblDiaInfo.anchor = GridBagConstraints.WEST;
		gbc_lblDiaInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaInfo.gridx = 5;
		gbc_lblDiaInfo.gridy = 4;
		add(lblDiaInfo, gbc_lblDiaInfo);
		
		lblPuntoEncuentro = new JLabel("Punto de encuentro: ");
		lblPuntoEncuentro.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPuntoEncuentro.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPuntoEncuentro = new GridBagConstraints();
		gbc_lblPuntoEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblPuntoEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntoEncuentro.gridx = 1;
		gbc_lblPuntoEncuentro.gridy = 5;
		add(lblPuntoEncuentro, gbc_lblPuntoEncuentro);
		
		lblPuntoEncuentroInfo = new JLabel("");
		lblPuntoEncuentroInfo.setForeground(Color.WHITE);
		lblPuntoEncuentroInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblPuntoEncuentroInfo = new GridBagConstraints();
		gbc_lblPuntoEncuentroInfo.anchor = GridBagConstraints.WEST;
		gbc_lblPuntoEncuentroInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntoEncuentroInfo.gridx = 2;
		gbc_lblPuntoEncuentroInfo.gridy = 5;
		add(lblPuntoEncuentroInfo, gbc_lblPuntoEncuentroInfo);
		
		lblDuracion = new JLabel("Duración: ");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.EAST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 4;
		gbc_lblDuracion.gridy = 5;
		add(lblDuracion, gbc_lblDuracion);
		
		lblDuracionInfo = new JLabel("");
		lblDuracionInfo.setForeground(Color.WHITE);
		lblDuracionInfo.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblDuracionInfo = new GridBagConstraints();
		gbc_lblDuracionInfo.anchor = GridBagConstraints.WEST;
		gbc_lblDuracionInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracionInfo.gridx = 5;
		gbc_lblDuracionInfo.gridy = 5;
		add(lblDuracionInfo, gbc_lblDuracionInfo);
		
		scrollPane = new JScrollPane();
//		scrollPane.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		taDescripcion = new JTextArea();
		taDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		taDescripcion.setBackground(Color.DARK_GRAY);
		taDescripcion.setForeground(Color.WHITE);
		scrollPane.setViewportView(taDescripcion);
		
		btnEditar = new JButton("Editar...");
		btnEditar.addMouseListener(new BtnEditarMouseListener());
		btnEditar.setBorder(null);
		btnEditar.setPreferredSize(new Dimension(75, 33));
		btnEditar.setBackground(new Color(189,90,249));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEditar.addActionListener(new BtnEditarActionListener());
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 7;
		gbc_btnEditar.gridy = 9;
		add(btnEditar, gbc_btnEditar);
		
		lblSeparador = new JLabel("");
		lblSeparador.setIcon(new ImageIcon(panelRutasPrincipal.class.getResource("/presentacion/recursos/SeparadorVertical.png")));
		lblSeparador.setVisible(false);
		lblSeparador.setBorder(new EmptyBorder(0, 10, 0, 10));
		GridBagConstraints gbc_lblSeparador = new GridBagConstraints();
		gbc_lblSeparador.gridheight = 4;
		gbc_lblSeparador.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeparador.gridx = 8;
		gbc_lblSeparador.gridy = 7;
		add(lblSeparador, gbc_lblSeparador);
		
		lblAviso = new JLabel("¿Eliminar esta actividad?");
		lblAviso.setVisible(false);
		lblAviso.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAviso.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.gridwidth = 2;
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridx = 9;
		gbc_lblAviso.gridy = 9;
		add(lblAviso, gbc_lblAviso);
		
		btnEliminar = new JButton("Eliminar...");
		btnEliminar.addMouseListener(new BtnEliminarMouseListener());
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBorder(null);
		btnEliminar.setPreferredSize(new Dimension(75, 33));
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 7;
		gbc_btnEliminar.gridy = 10;
		add(btnEliminar, gbc_btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.addMouseListener(new BtnCancelarMouseListener());
		btnCancelar.setBackground(new Color(0,120,210));
		btnCancelar.setBorder(null);
		btnCancelar.setPreferredSize(new Dimension(95, 33));
		btnCancelar.setVisible(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.SOUTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 9;
		gbc_btnCancelar.gridy = 10;
		add(btnCancelar, gbc_btnCancelar);
		
		btnEliminarConfirmar = new JButton("Eliminar");
		btnEliminarConfirmar.addActionListener(new BtnEliminarConfirmarActionListener());
		btnEliminarConfirmar.addMouseListener(new BtnEliminarConfirmarMouseListener());
		btnEliminarConfirmar.setBackground(new Color(255,71,71));
		btnEliminarConfirmar.setBorder(null);
		btnEliminarConfirmar.setPreferredSize(new Dimension(95, 33));
		btnEliminarConfirmar.setVisible(false);
		btnEliminarConfirmar.setForeground(Color.WHITE);
		btnEliminarConfirmar.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnEliminarConfirmar = new GridBagConstraints();
		gbc_btnEliminarConfirmar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEliminarConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarConfirmar.gridx = 10;
		gbc_btnEliminarConfirmar.gridy = 10;
		add(btnEliminarConfirmar, gbc_btnEliminarConfirmar);

	}

	/***********************************LISTENERS***********************************/
	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//configurar los listener y el id
			((panelRutasEditar) panel_editar).setGuardar_info(guardar_info_listen);
			((panelRutasEditar) panel_editar).setDar_de_baja_listen(dar_de_baja_listen);
			((panelRutasEditar) panel_editar).setEditingId(getParticularId());
			((panelRutasEditar) panel_editar).setEditar(true);
			
			//añadir contenido
			((panelRutasEditar) panel_editar).getTxtNombre().setText(lblNombre.getText());
			((panelRutasEditar) panel_editar).getTxtMonitor().setText(lblMonitorInfo.getText());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaDate = null;
	        try {
				fechaDate = formato.parse(lblDiaInfo.getText());
				((panelRutasEditar) panel_editar).getDateChooser().setDate(fechaDate);
				String[] cupo = lblCupoInfo.getText().split(" - ");
				((panelRutasEditar) panel_editar).getSpinCupoMin().setValue(Integer.parseInt(cupo[0]));
				((panelRutasEditar) panel_editar).getSpinCupoMax().setValue(Integer.parseInt(cupo[1]));
				String[] horario = lblDuracionInfo.getText().split(" - ");
				((panelRutasEditar) panel_editar).getTxtHoraInicio().setText(horario[0]);
				((panelRutasEditar) panel_editar).getTxtHoraFinal().setText(horario[1]);
				((panelRutasEditar) panel_editar).getSpinDificultad().setValue(Integer.parseInt(lblDificultadInfo.getText()));
				((panelRutasEditar) panel_editar).getTxtPuntoEncuentro().setText(lblPuntoEncuentroInfo.getText());
				((panelRutasEditar) panel_editar).getTaDescripcion().setText(taDescripcion.getText());
				
				mostrar_editar_listen.actionPerformed(arg0);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(frame, "Error con la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
			}		
		}
	}
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblSeparador.setVisible(true);
			lblAviso.setVisible(true);
			btnCancelar.setVisible(true);
			btnEliminarConfirmar.setVisible(true);
		}
	}
	
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblSeparador.setVisible(false);
			lblAviso.setVisible(false);
			btnCancelar.setVisible(false);
			btnEliminarConfirmar.setVisible(false);
		}
	}
	
	private class BtnEliminarConfirmarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dar_de_baja_listen.setAuxID(getParticularId());
			dar_de_baja_listen.actionPerformed(arg0);
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	private class BtnEditarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEditar.setBackground(new Color(185,81,249));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEditar.setBackground(new Color(189,90,249));
		}
	}
	
	private class BtnEliminarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEliminar.setBackground(new Color(76,83,88));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEliminar.setBackground(new Color(64,64,64));
		}
	}
	
	private class BtnCancelarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelar.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelar.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnEliminarConfirmarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEliminarConfirmar.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEliminarConfirmar.setBackground(new Color(255,71,71));
		}
	}
	
	/*******************************GETTERS & SETTERS********************************/
	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JTextArea getTaDescripcion() {
		return taDescripcion;
	}

	public void setTaDescripcion(JTextArea taDescripcion) {
		this.taDescripcion = taDescripcion;
	}

	public GuardarInfo getGuardar_info() {
		return guardar_info_listen;
	}

	public void setGuardar_info(GuardarInfo guardar_info) {
		this.guardar_info_listen = guardar_info;
	}

	public JLabel getLblMonitorInfo() {
		return lblMonitorInfo;
	}

	public void setLblMonitorInfo(JLabel lblMonitorInfo) {
		this.lblMonitorInfo = lblMonitorInfo;
	}

	public JLabel getLblDiaInfo() {
		return lblDiaInfo;
	}

	public void setLblDiaInfo(JLabel lblDiaInfo) {
		this.lblDiaInfo = lblDiaInfo;
	}

	public JLabel getLblDificultadInfo() {
		return lblDificultadInfo;
	}

	public void setLblDificultadInfo(JLabel lblDificultadInfo) {
		this.lblDificultadInfo = lblDificultadInfo;
	}

	public JLabel getLblCupoInfo() {
		return lblCupoInfo;
	}

	public void setLblCupoInfo(JLabel lblCupoInfo) {
		this.lblCupoInfo = lblCupoInfo;
	}

	public JLabel getLblDuracionInfo() {
		return lblDuracionInfo;
	}

	public void setLblDuracionInfo(JLabel lblDuracionInfo) {
		this.lblDuracionInfo = lblDuracionInfo;
	}

	public JLabel getLblPuntoEncuentroInfo() {
		return lblPuntoEncuentroInfo;
	}

	public void setLblPuntoEncuentroInfo(JLabel lblPuntoEncuentroInfo) {
		this.lblPuntoEncuentroInfo = lblPuntoEncuentroInfo;
	}

	public int getParticularId() {
		return particularId;
	}

	public void setParticularId(int particularId) {
		this.particularId = particularId;
	}
	
}
