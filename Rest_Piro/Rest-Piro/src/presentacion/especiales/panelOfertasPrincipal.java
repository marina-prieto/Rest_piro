package presentacion.especiales;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import presentacion.especiales.panelEspecial.DarDeBaja;
import presentacion.especiales.panelEspecial.EditarOferta;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class panelOfertasPrincipal extends JPanel {
	private JLabel lblImage;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JButton btnDarDeBaja;
	private JTextArea taDescripcion;
	
	/***********************************PARAMETROS************************************/
	private DarDeBaja dar_de_baja_listen;
	private int particularId;
	private EditarOferta editar_oferta_listen;
	private String auxPath;
	private JLabel lblSeparador;
	private JLabel lblAviso;
	private JButton btnCancelar;
	private JButton btnEliminarConfirmar;

	/***********************************CONSTRUCTOR***********************************/
	public panelOfertasPrincipal(DarDeBaja darDeBaja, EditarOferta editarOferta) {
		dar_de_baja_listen = darDeBaja;
		editar_oferta_listen = editarOferta;
		
		setMaximumSize(new Dimension(32767, 250));
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(42,46,49));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 200, 15, 50, 0, 100, 0, 0, 0, 15};
		gridBagLayout.rowHeights = new int[]{15, 35, 33, 33, 33, 33, 33, 15};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		lblImage = new JLabel("");
		lblImage.setSize(new Dimension(200, 200));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridheight = 6;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 1;
		add(lblImage, gbc_lblImage);
		
		lblTitle = new JLabel("Título");
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitle.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 3;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);
		
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
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		taDescripcion = new JTextArea();
		taDescripcion.setForeground(Color.WHITE);
		taDescripcion.setCaretColor(Color.WHITE);
		taDescripcion.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(taDescripcion);
		
		lblSeparador = new JLabel("");
		lblSeparador.setIcon(new ImageIcon(panelOfertasPrincipal.class.getResource("/presentacion/recursos/SeparadorVertical.png")));
		lblSeparador.setVisible(false);
		lblSeparador.setBorder(new EmptyBorder(0, 15, 0, 15));
		GridBagConstraints gbc_lblSeparador = new GridBagConstraints();
		gbc_lblSeparador.gridheight = 4;
		gbc_lblSeparador.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeparador.gridx = 6;
		gbc_lblSeparador.gridy = 3;
		add(lblSeparador, gbc_lblSeparador);
		
		btnEditar = new JButton("Editar...");
		btnEditar.addMouseListener(new BtnEditarMouseListener());
		btnEditar.setBorder(null);
		btnEditar.setPreferredSize(new Dimension(75, 33));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(189,90,249));
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEditar.addActionListener(new BtnEditarActionListener());
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 5;
		gbc_btnEditar.gridy = 5;
		add(btnEditar, gbc_btnEditar);
		
		lblAviso = new JLabel("¿Eliminar esta actividad?");
		lblAviso.setVisible(false);
		lblAviso.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAviso.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.gridwidth = 2;
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridx = 7;
		gbc_lblAviso.gridy = 5;
		add(lblAviso, gbc_lblAviso);
		
		btnDarDeBaja = new JButton("Eliminar...");
		btnDarDeBaja.addMouseListener(new BtnDarDeBajaMouseListener());
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setPreferredSize(new Dimension(75, 33));
		btnDarDeBaja.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDarDeBaja.addActionListener(new BtnDarDeBajaActionListener());
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.anchor = GridBagConstraints.SOUTH;
		gbc_btnDarDeBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarDeBaja.gridx = 5;
		gbc_btnDarDeBaja.gridy = 6;
		add(btnDarDeBaja, gbc_btnDarDeBaja);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new BtnCancelarMouseListener());
		btnCancelar.setBorder(null);
		btnCancelar.setPreferredSize(new Dimension(95, 33));
		btnCancelar.setBackground(new Color(0,120,210));
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 6;
		add(btnCancelar, gbc_btnCancelar);
		
		btnEliminarConfirmar = new JButton("Eliminar");
		btnEliminarConfirmar.addMouseListener(new BtnEliminarConfirmarMouseListener());
		btnEliminarConfirmar.setBorder(null);
		btnEliminarConfirmar.setPreferredSize(new Dimension(95, 33));
		btnEliminarConfirmar.setBackground(new Color(255, 71, 71));
		btnEliminarConfirmar.setVisible(false);
		btnEliminarConfirmar.addActionListener(new BtnEliminarConfirmarActionListener());
		btnEliminarConfirmar.setForeground(Color.WHITE);
		btnEliminarConfirmar.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnEliminarConfirmar = new GridBagConstraints();
		gbc_btnEliminarConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarConfirmar.gridx = 8;
		gbc_btnEliminarConfirmar.gridy = 6;
		add(btnEliminarConfirmar, gbc_btnEliminarConfirmar);
	}
	
	/***********************************LISTENERS***********************************/
	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			editar_oferta_listen.setAuxID(getParticularId());
			editar_oferta_listen.setOferta(lblTitle.getText(), auxPath, taDescripcion.getText());
			editar_oferta_listen.actionPerformed(arg0);
		}
	}
	
	private class BtnDarDeBajaActionListener implements ActionListener {
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
	
	private class BtnDarDeBajaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnDarDeBaja.setBackground(new Color(76,83,88));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnDarDeBaja.setBackground(new Color(64,64,64));
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
	
	/*******************************GETTERS & SETTERS********************************/
	public JLabel getLblImage() {
		return lblImage;
	}
	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}
	public JLabel getLblTitle() {
		return lblTitle;
	}
	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}
	public JTextArea getTaDescripcion() {
		return taDescripcion;
	}
	public void setTaDescripcion(JTextArea taDescripcion) {
		this.taDescripcion = taDescripcion;
	}

	public int getParticularId() {
		return particularId;
	}

	public void setParticularId(int id) {
		this.particularId = id;
	}
	public String getAuxPath() {
		return auxPath;
	}
	public void setAuxPath(String auxPath) {
		this.auxPath = auxPath;
	}
}
