package presentacion.estancias;

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

import dominio.*;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import presentacion.estancias.panelEstancias.BtnReservarActionListener;
import presentacion.estancias.panelEstancias.BtnVermasActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings({ "serial" })
public class panelEstancia extends JPanel {
	private JPanel pnlInformacion;
	private JLabel lblFoto;
	private JPanel pnlBotones;
	private JButton btnVermas;
	private JLabel lblNombreOut;
	private JLabel lblTamanoOut;
	private JLabel lblPrecio;
	private JLabel lblOpcExtra;
	private JLabel lblPrecioOut;
	private JLabel lblTamano;
	private JButton btnReservar;
	
	/***********************************PARAMETROS************************************/
	
	private int id;
	private JLabel lblDisponibilidadOut;
	private JLabel lblExtras;
	private JLabel lblOpcExtraOut;
	private JPanel panel;
	private JLabel lblOpcion3;
	private JLabel lblOpcion1;
	private JLabel lblOpcion2;
	private JLabel lblOpcion4;
	private JLabel lblOpcion5;
	private JLabel lblOpcion6;
	private Parcela parcelaAux = null;
	private Bungalow bungalowAux  = null;
	private File file;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelEstancia(BtnReservarActionListener ReservarActionListener, BtnVermasActionListener VermasListener, int identifier) {
		setMaximumSize(new Dimension(32767, 230));
		setPreferredSize(new Dimension(10, 230));
		
		setId(identifier);
		setMinimumSize(new Dimension(10, 230));
		setBackground(new Color(42,46,49));
		setVisible(true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{144, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(new EmptyBorder(20, 20, 0, 30));
		lblFoto.setSize(new Dimension(180, 180));

		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblFoto.gridx = 0;
		gbc_lblFoto.gridy = 0;
		add(lblFoto, gbc_lblFoto);
		
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
		gbl_pnlInformacion.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlInformacion.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInformacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlInformacion.setLayout(gbl_pnlInformacion);
		
		lblNombreOut = new JLabel("");
		lblNombreOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblNombreOut.setForeground(Color.WHITE);
		lblNombreOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreOut.setFont(new Font("Verdana", Font.BOLD, 24));
		GridBagConstraints gbc_lblNombreOut = new GridBagConstraints();
		gbc_lblNombreOut.anchor = GridBagConstraints.WEST;
		gbc_lblNombreOut.gridwidth = 3;
		gbc_lblNombreOut.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreOut.gridx = 1;
		gbc_lblNombreOut.gridy = 0;
		pnlInformacion.add(lblNombreOut, gbc_lblNombreOut);
		
		lblTamano = new JLabel("Tamaño: ");
		lblTamano.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblTamano.setForeground(Color.WHITE);
		lblTamano.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTamano = new GridBagConstraints();
		gbc_lblTamano.anchor = GridBagConstraints.EAST;
		gbc_lblTamano.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamano.gridx = 1;
		gbc_lblTamano.gridy = 1;
		pnlInformacion.add(lblTamano, gbc_lblTamano);
		
		
		lblTamanoOut = new JLabel("");
		lblTamanoOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblTamanoOut.setForeground(Color.WHITE);
		lblTamanoOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTamanoOut = new GridBagConstraints();
		gbc_lblTamanoOut.anchor = GridBagConstraints.WEST;
		gbc_lblTamanoOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamanoOut.gridx = 2;
		gbc_lblTamanoOut.gridy = 1;
		pnlInformacion.add(lblTamanoOut, gbc_lblTamanoOut);
		
		lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 2;
		pnlInformacion.add(lblPrecio, gbc_lblPrecio);
		
		lblPrecioOut = new JLabel("");
		lblPrecioOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblPrecioOut.setForeground(Color.WHITE);
		lblPrecioOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrecioOut = new GridBagConstraints();
		gbc_lblPrecioOut.anchor = GridBagConstraints.WEST;
		gbc_lblPrecioOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioOut.gridx = 2;
		gbc_lblPrecioOut.gridy = 2;
		pnlInformacion.add(lblPrecioOut, gbc_lblPrecioOut);
		
		lblOpcExtra = new JLabel("");
		lblOpcExtraOut = new JLabel("");
		
		lblOpcExtra.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblOpcExtra.setForeground(Color.WHITE);
		lblOpcExtra.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOpcExtra = new GridBagConstraints();
		gbc_lblOpcExtra.anchor = GridBagConstraints.EAST;
		gbc_lblOpcExtra.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcExtra.gridx = 1;
		gbc_lblOpcExtra.gridy = 3;
		pnlInformacion.add(lblOpcExtra, gbc_lblOpcExtra);
		
		lblOpcExtraOut.setForeground(Color.WHITE);
		lblOpcExtraOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblOpcExtraOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		GridBagConstraints gbc_lblOpcExtraOut = new GridBagConstraints();
		gbc_lblOpcExtraOut.anchor = GridBagConstraints.WEST;
		gbc_lblOpcExtraOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcExtraOut.gridx = 2;
		gbc_lblOpcExtraOut.gridy = 3;
		pnlInformacion.add(lblOpcExtraOut, gbc_lblOpcExtraOut);
		
		lblExtras = new JLabel("Incluye: ");
		lblExtras.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblExtras.setForeground(Color.WHITE);
		lblExtras.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblExtras = new GridBagConstraints();
		gbc_lblExtras.anchor = GridBagConstraints.EAST;
		gbc_lblExtras.insets = new Insets(0, 0, 0, 5);
		gbc_lblExtras.gridx = 1;
		gbc_lblExtras.gridy = 4;
		pnlInformacion.add(lblExtras, gbc_lblExtras);
		
		panel = new JPanel();
		panel.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		pnlInformacion.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 5};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblOpcion1 = new JLabel("");
		GridBagConstraints gbc_lblOpcion1 = new GridBagConstraints();
		gbc_lblOpcion1.anchor = GridBagConstraints.WEST;
		gbc_lblOpcion1.fill = GridBagConstraints.VERTICAL;
		gbc_lblOpcion1.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcion1.gridx = 0;
		gbc_lblOpcion1.gridy = 0;
		panel.add(lblOpcion1, gbc_lblOpcion1);
		
		lblOpcion2 = new JLabel("");
		GridBagConstraints gbc_lblOpcion2 = new GridBagConstraints();
		gbc_lblOpcion2.fill = GridBagConstraints.VERTICAL;
		gbc_lblOpcion2.anchor = GridBagConstraints.WEST;
		gbc_lblOpcion2.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcion2.gridx = 1;
		gbc_lblOpcion2.gridy = 0;
		panel.add(lblOpcion2, gbc_lblOpcion2);
		
		lblOpcion3 = new JLabel("");
		GridBagConstraints gbc_lblOpcion3 = new GridBagConstraints();
		gbc_lblOpcion3.fill = GridBagConstraints.VERTICAL;
		gbc_lblOpcion3.anchor = GridBagConstraints.WEST;
		gbc_lblOpcion3.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcion3.gridx = 2;
		gbc_lblOpcion3.gridy = 0;
		panel.add(lblOpcion3, gbc_lblOpcion3);
		
		lblOpcion4 = new JLabel("");
		GridBagConstraints gbc_lblOpcion4 = new GridBagConstraints();
		gbc_lblOpcion4.fill = GridBagConstraints.VERTICAL;
		gbc_lblOpcion4.anchor = GridBagConstraints.WEST;
		gbc_lblOpcion4.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcion4.gridx = 3;
		gbc_lblOpcion4.gridy = 0;
		panel.add(lblOpcion4, gbc_lblOpcion4);
		
		lblOpcion5 = new JLabel("");
		GridBagConstraints gbc_lblOpcion5 = new GridBagConstraints();
		gbc_lblOpcion5.fill = GridBagConstraints.VERTICAL;
		gbc_lblOpcion5.anchor = GridBagConstraints.WEST;
		gbc_lblOpcion5.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcion5.gridx = 4;
		gbc_lblOpcion5.gridy = 0;
		panel.add(lblOpcion5, gbc_lblOpcion5);
		
		lblOpcion6 = new JLabel("");
		GridBagConstraints gbc_lblOpcion6 = new GridBagConstraints();
		gbc_lblOpcion6.gridx = 5;
		gbc_lblOpcion6.gridy = 0;
		panel.add(lblOpcion6, gbc_lblOpcion6);
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.anchor = GridBagConstraints.WEST;
		gbc_pnlBotones.fill = GridBagConstraints.VERTICAL;
		gbc_pnlBotones.gridx = 2;
		gbc_pnlBotones.gridy = 0;
		add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] {0, 30, 0, 20};
		gbl_pnlBotones.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		btnVermas = new JButton("Ver más...");
		btnVermas.addMouseListener(new BtnVermasMouseListener());
		btnVermas.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnVermas.setPreferredSize(new Dimension(71, 33));
		btnVermas.setForeground(Color.WHITE);
		btnVermas.setBorder(null);
		btnVermas.setBackground(Color.DARK_GRAY);
		btnVermas.addActionListener(VermasListener);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setEnabled(false);
		btnReservar.addMouseListener(new BtnReservarMouseListener());
		btnReservar.addActionListener(ReservarActionListener);
		
		lblDisponibilidadOut = new JLabel("");
		lblDisponibilidadOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDisponibilidadOut.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDisponibilidadOut = new GridBagConstraints();
		gbc_lblDisponibilidadOut.gridwidth = 2;
		gbc_lblDisponibilidadOut.insets = new Insets(0, 0, 5, 0);
		gbc_lblDisponibilidadOut.gridx = 1;
		gbc_lblDisponibilidadOut.gridy = 2;
		pnlBotones.add(lblDisponibilidadOut, gbc_lblDisponibilidadOut);
		
		btnReservar.setPreferredSize(new Dimension(105, 33));
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnReservar.setBorder(null);
		btnReservar.setBackground(new Color(189,90,249));
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.gridwidth = 2;
		gbc_btnReservar.insets = new Insets(0, 0, 5, 0);
		gbc_btnReservar.gridx = 1;
		gbc_btnReservar.gridy = 3;
		pnlBotones.add(btnReservar, gbc_btnReservar);
		
		GridBagConstraints gbc_btnVermas = new GridBagConstraints();
		gbc_btnVermas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVermas.gridwidth = 2;
		gbc_btnVermas.gridx = 1;
		gbc_btnVermas.gridy = 4;
		pnlBotones.add(btnVermas, gbc_btnVermas);
		
		setInfoPanel(VermasListener);

	}
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnReservarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnReservar.setBackground(new Color(76,83,88));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnReservar.setBackground(new Color(64,64,64));
		}
	}
	
	private class BtnVermasMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnVermas.setBackground(new Color(185,81,249));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnVermas.setBackground(new Color(189,90,249));
		}
	}

	/*******************************METODOS AUXILIARES********************************/

	private void setFoto(File file) {
		try {
            Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFoto.getWidth(),
            lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFoto.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void setExtrasParcela(Parcela parcela) {
		
		boolean[] auxExtras = parcela.getExtras();
			
		if (auxExtras[0] == true) {	
			lblOpcion1.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/noFumar.png")));
		}
		
		if (auxExtras[1] == true) {	
			lblOpcion2.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/parking.png")));
		}
		
		if (auxExtras[2] == true) {	
			lblOpcion3.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/wifi.png")));
		}
		
		if (auxExtras[3] == true) {	
			lblOpcion4.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/spa.png")));
		}
		
		if (auxExtras[4] == true) {	
			lblOpcion5.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/desayuno.png")));
		}
		
		if (auxExtras[5] == true) {	
			lblOpcion6.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/mascotas.png")));
		}
	}	
		
	private void setExtrasBungalow(Bungalow bungalow) {
			
		boolean[] auxExtras = bungalow.getExtras();
			
		if (auxExtras[0] == true) {	
			lblOpcion1.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/lavadora.png")));
		}
		
		if (auxExtras[1] == true) {	
			lblOpcion2.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/toalla.png")));
		}
		
		if (auxExtras[2] == true) {	
			lblOpcion3.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/botones.png")));
		}
		
		if (auxExtras[3] == true) {	
			lblOpcion4.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/transporte.png")));
		}
		
		if (auxExtras[4] == true) {	
			lblOpcion5.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/piscina.png")));
		}
		
		if (auxExtras[5] == true) {	
			lblOpcion6.setIcon(new ImageIcon(panelEstancia.class.getResource("/presentacion/recursos/aire.png")));
		}

	}
	
	private void disponibilidad(String dispo) {
		lblDisponibilidadOut.setText(dispo);
		
		if (dispo == "Disponible") {
			btnReservar.setEnabled(true);
		}
	}
	
	/*******************************GETTERS AND SETTERS*******************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setInfoPanel(BtnVermasActionListener VermasListener) {
		
		if (VermasListener.getParcela() == parcelaAux) {
			
			bungalowAux = VermasListener.getBungalow();
			file = bungalowAux.getFoto();
			setFoto(file);
			lblNombreOut.setText(bungalowAux.getNombre());
			lblTamanoOut.setText(Double.toString(bungalowAux.getTamano()) + " m²");
			lblPrecioOut.setText(Double.toString(bungalowAux.getPrecioPorNoche()) + " €");
			lblOpcExtra.setText("Capacidad: ");
			lblOpcExtraOut.setText(Integer.toString(bungalowAux.getCapacidad()) + " personas");
			disponibilidad(bungalowAux.getRazon());
			setExtrasBungalow(bungalowAux);
			
		} else {
			parcelaAux = VermasListener.getParcela();
			file = parcelaAux.getFoto();
			setFoto(file);
			lblNombreOut.setText(parcelaAux.getNombre());
			lblTamanoOut.setText(Double.toString(parcelaAux.getTamano()) + " m²");
			lblPrecioOut.setText(Double.toString(parcelaAux.getPrecioPorNoche()) + " €");
			lblOpcExtra.setText("Categoría: ");
			lblOpcExtraOut.setText(parcelaAux.getCategoria());
			disponibilidad(parcelaAux.getRazon());
			setExtrasParcela(parcelaAux);
		}
	}
	
}
