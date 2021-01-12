package presentacion.especiales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import dominio.Oferta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class panelEspecial extends JPanel {
	private JPanel panelSuperior;
	private JScrollPane scrollPaneOfertas;
	private JButton btnNuevo;
	private JLabel lblOfertas;
	private JPanel panelOfertasPrincipal;
	private JPanel panelDesplegableOfertas;
	private JPanel panelNuevo;
	private JPanel panelEditar;
	private JLabel lblOfertaN;
	private JButton btnSubirFotoN;
	private JLabel lblTituloN;
	private JTextField txtTituloN;
	private JScrollPane scrollPaneDescripcionN;
	private JTextArea taDescripcionN;
	private JButton btnGuardarN;
	private JButton btnCancelarN;
	private JLabel lblOfertaE;
	private JButton btnSubirFotoE;
	private JLabel lblTituloE;
	private JTextField txtTituloE;
	private JScrollPane scrollPaneDescripcionE;
	private JButton btnGuardarE;
	private JTextArea taDescripcionE;
	private JButton btnCancelarE;
	private JLabel lblFotoN;
	private JLabel lblFotoE;
	
	/***********************************PARAMETROS************************************/
	private Vector<Oferta> vOfer = new Vector<Oferta>();
	private panelOfertasPrincipal principal;
	private Oferta oferta;
	private File file;
	private Component frame;
	private int globalId = -1;
	private Vector<Integer> vID = new Vector<Integer>();
	private int editingId = -1;
	private boolean imagenSustitutaEditar = false;
	
	/***********************************CONSTRUCTOR***********************************/
	public panelEspecial() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(31,34,40));
		add(panelSuperior, BorderLayout.NORTH);
		GridBagLayout gbl_panelSuperior = new GridBagLayout();
		gbl_panelSuperior.columnWidths = new int[]{50, 0, 0, 80, 50, 0};
		gbl_panelSuperior.rowHeights = new int[]{30, 15, 30, 0};
		gbl_panelSuperior.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSuperior.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelSuperior.setLayout(gbl_panelSuperior);
		
		lblOfertas = new JLabel("PROMOCIONES Y OFERTAS");
		lblOfertas.setForeground(Color.WHITE);
		lblOfertas.setFont(new Font("Verdana", Font.BOLD, 46));
		GridBagConstraints gbc_lblOfertas = new GridBagConstraints();
		gbc_lblOfertas.fill = GridBagConstraints.VERTICAL;
		gbc_lblOfertas.anchor = GridBagConstraints.WEST;
		gbc_lblOfertas.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfertas.gridx = 1;
		gbc_lblOfertas.gridy = 1;
		panelSuperior.add(lblOfertas, gbc_lblOfertas);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(new BtnNuevoMouseListener());
		btnNuevo.setBorder(null);
		btnNuevo.setPreferredSize(new Dimension(80, 20));
		btnNuevo.setBackground(new Color(47,198,152));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 3;
		gbc_btnNuevo.gridy = 1;
		panelSuperior.add(btnNuevo, gbc_btnNuevo);
		
		scrollPaneOfertas = new JScrollPane();
//		scrollPaneOfertas.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneOfertas.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPaneOfertas.setBorder(null);
		add(scrollPaneOfertas, BorderLayout.CENTER);
		
		panelOfertasPrincipal = new JPanel();
		panelOfertasPrincipal.setBackground(new Color(31,34,40));
		panelOfertasPrincipal.setBorder(null);
		scrollPaneOfertas.setViewportView(panelOfertasPrincipal);
		panelOfertasPrincipal.setLayout(new BoxLayout(panelOfertasPrincipal, BoxLayout.Y_AXIS));
		
		panelDesplegableOfertas = new JPanel();
		panelDesplegableOfertas.setVisible(false);
		panelDesplegableOfertas.setBackground(new Color(31,34,40));
		panelDesplegableOfertas.setBackground(Color.BLACK);
		add(panelDesplegableOfertas, BorderLayout.EAST);
		panelDesplegableOfertas.setLayout(new CardLayout(0, 0));
		
		panelNuevo = new JPanel();
		panelNuevo.setBackground(new Color(42,46,49));
		panelDesplegableOfertas.add(panelNuevo, "panelNuevo");
		GridBagLayout gbl_panelNuevo = new GridBagLayout();
		gbl_panelNuevo.columnWidths = new int[]{70, 70, 70, 70, 70, 70, 70};
		gbl_panelNuevo.rowHeights = new int[]{70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panelNuevo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panelNuevo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		panelNuevo.setLayout(gbl_panelNuevo);
		
		lblOfertaN = new JLabel("Nueva Oferta");
		lblOfertaN.setFont(new Font("Verdana", Font.BOLD, 30));
		lblOfertaN.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOfertaN = new GridBagConstraints();
		gbc_lblOfertaN.gridwidth = 3;
		gbc_lblOfertaN.insets = new Insets(0, 0, 5, 0);
		gbc_lblOfertaN.gridx = 2;
		gbc_lblOfertaN.gridy = 0;
		panelNuevo.add(lblOfertaN, gbc_lblOfertaN);
		
		lblFotoN = new JLabel("");
		lblFotoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoN.setForeground(Color.WHITE);
		lblFotoN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoN = new GridBagConstraints();
		gbc_lblFotoN.fill = GridBagConstraints.BOTH;
		gbc_lblFotoN.gridheight = 3;
		gbc_lblFotoN.gridwidth = 3;
		gbc_lblFotoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoN.gridx = 2;
		gbc_lblFotoN.gridy = 1;
		panelNuevo.add(lblFotoN, gbc_lblFotoN);
		
		btnSubirFotoN = new JButton("Subir foto...");
		btnSubirFotoN.setBorder(null);
		btnSubirFotoN.setPreferredSize(new Dimension(95, 33));
		btnSubirFotoN.addMouseListener(new BtnSubirFotoNMouseListener());
		btnSubirFotoN.addActionListener(new BtnSubirFotoNActionListener());
		btnSubirFotoN.setBackground(new Color(0,120,210));
		btnSubirFotoN.setForeground(Color.WHITE);
		btnSubirFotoN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoN = new GridBagConstraints();
		gbc_btnSubirFotoN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubirFotoN.gridwidth = 3;
		gbc_btnSubirFotoN.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoN.gridx = 2;
		gbc_btnSubirFotoN.gridy = 4;
		panelNuevo.add(btnSubirFotoN, gbc_btnSubirFotoN);
		
		lblTituloN = new JLabel("Titulo: ");
		lblTituloN.setForeground(Color.WHITE);
		lblTituloN.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTituloN = new GridBagConstraints();
		gbc_lblTituloN.anchor = GridBagConstraints.EAST;
		gbc_lblTituloN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloN.gridx = 1;
		gbc_lblTituloN.gridy = 6;
		panelNuevo.add(lblTituloN, gbc_lblTituloN);
		
		txtTituloN = new JTextField();
		txtTituloN.setFont(new Font("Verdana", Font.PLAIN, 10));
		txtTituloN.setForeground(Color.WHITE);
		txtTituloN.setCaretColor(Color.WHITE);
		txtTituloN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtTituloN = new GridBagConstraints();
		gbc_txtTituloN.gridwidth = 4;
		gbc_txtTituloN.insets = new Insets(0, 0, 5, 5);
		gbc_txtTituloN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTituloN.gridx = 2;
		gbc_txtTituloN.gridy = 6;
		panelNuevo.add(txtTituloN, gbc_txtTituloN);
		txtTituloN.setColumns(10);
		
		scrollPaneDescripcionN = new JScrollPane();
//		scrollPaneDescripcionN.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneDescripcionN.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPaneDescripcionN.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcionN.setForeground(Color.WHITE);
		scrollPaneDescripcionN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrollPaneDescripcionN = new GridBagConstraints();
		gbc_scrollPaneDescripcionN.gridwidth = 5;
		gbc_scrollPaneDescripcionN.gridheight = 4;
		gbc_scrollPaneDescripcionN.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneDescripcionN.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDescripcionN.gridx = 1;
		gbc_scrollPaneDescripcionN.gridy = 8;
		panelNuevo.add(scrollPaneDescripcionN, gbc_scrollPaneDescripcionN);
		
		taDescripcionN = new JTextArea();
		taDescripcionN.setForeground(Color.WHITE);
		taDescripcionN.setCaretColor(Color.WHITE);
		taDescripcionN.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcionN.setViewportView(taDescripcionN);
		
		btnGuardarN = new JButton("Guardar");
		btnGuardarN.setBorder(null);
		btnGuardarN.setPreferredSize(new Dimension(95, 33));
		btnGuardarN.addMouseListener(new BtnGuardarNMouseListener());
		btnGuardarN.addActionListener(new BtnGuardarNActionListener());
		
		btnCancelarN = new JButton("Cancelar");
		btnCancelarN.setBorder(null);
		btnCancelarN.setPreferredSize(new Dimension(95, 33));
		btnCancelarN.addMouseListener(new BtnCancelarNMouseListener());
		btnCancelarN.addActionListener(new BtnCancelarNActionListener());
		btnCancelarN.setBackground(new Color(255,71,71));
		btnCancelarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarN.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnCancelarN = new GridBagConstraints();
		gbc_btnCancelarN.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarN.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelarN.gridx = 4;
		gbc_btnCancelarN.gridy = 13;
		panelNuevo.add(btnCancelarN, gbc_btnCancelarN);
		btnGuardarN.setBackground(new Color(47,198,152));
		btnGuardarN.setForeground(Color.WHITE);
		btnGuardarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarN = new GridBagConstraints();
		gbc_btnGuardarN.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarN.gridx = 5;
		gbc_btnGuardarN.gridy = 13;
		panelNuevo.add(btnGuardarN, gbc_btnGuardarN);
		
		panelEditar = new JPanel();
		panelEditar.setBackground(new Color(42,46,49));
		panelDesplegableOfertas.add(panelEditar, "panelEditar");
		GridBagLayout gbl_panelEditar = new GridBagLayout();
		gbl_panelEditar.columnWidths = new int[]{70, 70, 70, 70, 70, 70, 70};
		gbl_panelEditar.rowHeights = new int[]{70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panelEditar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panelEditar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		panelEditar.setLayout(gbl_panelEditar);
		
		lblOfertaE = new JLabel("Editar Oferta");
		lblOfertaE.setForeground(Color.WHITE);
		lblOfertaE.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lblOfertaE = new GridBagConstraints();
		gbc_lblOfertaE.gridwidth = 3;
		gbc_lblOfertaE.insets = new Insets(0, 0, 5, 0);
		gbc_lblOfertaE.gridx = 2;
		gbc_lblOfertaE.gridy = 0;
		panelEditar.add(lblOfertaE, gbc_lblOfertaE);
		
		lblFotoE = new JLabel("");
		lblFotoE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		lblFotoE.setForeground(Color.WHITE);
		lblFotoE.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblFotoE = new GridBagConstraints();
		gbc_lblFotoE.fill = GridBagConstraints.BOTH;
		gbc_lblFotoE.gridheight = 3;
		gbc_lblFotoE.gridwidth = 3;
		gbc_lblFotoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoE.gridx = 2;
		gbc_lblFotoE.gridy = 1;
		panelEditar.add(lblFotoE, gbc_lblFotoE);
		
		btnSubirFotoE = new JButton("Cambiar Foto...");
		btnSubirFotoE.setBorder(null);
		btnSubirFotoE.setPreferredSize(new Dimension(95, 33));
		btnSubirFotoE.addMouseListener(new BtnSubirFotoEMouseListener());
		btnSubirFotoE.addActionListener(new BtnSubirFotoEActionListener());
		btnSubirFotoE.setBackground(new Color(0,120,210));
		btnSubirFotoE.setForeground(Color.WHITE);
		btnSubirFotoE.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoE = new GridBagConstraints();
		gbc_btnSubirFotoE.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubirFotoE.gridwidth = 3;
		gbc_btnSubirFotoE.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoE.gridx = 2;
		gbc_btnSubirFotoE.gridy = 4;
		panelEditar.add(btnSubirFotoE, gbc_btnSubirFotoE);
		
		lblTituloE = new JLabel("Título: ");
		lblTituloE.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTituloE.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTituloE = new GridBagConstraints();
		gbc_lblTituloE.anchor = GridBagConstraints.EAST;
		gbc_lblTituloE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloE.gridx = 1;
		gbc_lblTituloE.gridy = 6;
		panelEditar.add(lblTituloE, gbc_lblTituloE);
		
		txtTituloE = new JTextField();
		txtTituloE.setFont(new Font("Verdana", Font.PLAIN, 10));
		txtTituloE.setForeground(Color.WHITE);
		txtTituloE.setCaretColor(Color.WHITE);
		txtTituloE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtTituloE = new GridBagConstraints();
		gbc_txtTituloE.gridwidth = 4;
		gbc_txtTituloE.insets = new Insets(0, 0, 5, 5);
		gbc_txtTituloE.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTituloE.gridx = 2;
		gbc_txtTituloE.gridy = 6;
		panelEditar.add(txtTituloE, gbc_txtTituloE);
		txtTituloE.setColumns(10);
		
		scrollPaneDescripcionE = new JScrollPane();
//		scrollPaneDescripcionE.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneDescripcionE.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPaneDescripcionE.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcionE.setForeground(Color.WHITE);
		scrollPaneDescripcionE.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrollPaneDescripcionE = new GridBagConstraints();
		gbc_scrollPaneDescripcionE.gridheight = 4;
		gbc_scrollPaneDescripcionE.gridwidth = 5;
		gbc_scrollPaneDescripcionE.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneDescripcionE.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDescripcionE.gridx = 1;
		gbc_scrollPaneDescripcionE.gridy = 8;
		panelEditar.add(scrollPaneDescripcionE, gbc_scrollPaneDescripcionE);
		
		taDescripcionE = new JTextArea();
		taDescripcionE.setForeground(Color.WHITE);
		taDescripcionE.setCaretColor(Color.WHITE);
		taDescripcionE.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcionE.setViewportView(taDescripcionE);
		
		btnGuardarE = new JButton("Guardar");
		btnGuardarE.setBorder(null);
		btnGuardarE.setPreferredSize(new Dimension(95, 33));
		btnGuardarE.addMouseListener(new BtnGuardarEMouseListener());
		btnGuardarE.addActionListener(new BtnGuardarEActionListener());
		
		btnCancelarE = new JButton("Cancelar");
		btnCancelarE.setBorder(null);
		btnCancelarE.setPreferredSize(new Dimension(95, 33));
		btnCancelarE.addMouseListener(new BtnCancelarEMouseListener());
		btnCancelarE.addActionListener(new BtnCancelarEActionListener());
		btnCancelarE.setBackground(new Color(255,71,71));
		btnCancelarE.setForeground(Color.WHITE);
		btnCancelarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCancelarE = new GridBagConstraints();
		gbc_btnCancelarE.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarE.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelarE.gridx = 4;
		gbc_btnCancelarE.gridy = 13;
		panelEditar.add(btnCancelarE, gbc_btnCancelarE);
		btnGuardarE.setBackground(new Color(47,198,152));
		btnGuardarE.setForeground(Color.WHITE);
		btnGuardarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarE = new GridBagConstraints();
		gbc_btnGuardarE.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarE.gridx = 5;
		gbc_btnGuardarE.gridy = 13;
		panelEditar.add(btnGuardarE, gbc_btnGuardarE);
	}

	/***********************************LISTENERS***********************************/
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			limpiarElementos();
			panelDesplegableOfertas.setVisible(true);
			((CardLayout) panelDesplegableOfertas.getLayout()).show(panelDesplegableOfertas, "panelNuevo");
		}
	}
	
	public class DarDeBaja implements ActionListener {
		int auxID;
		
		public void actionPerformed(ActionEvent arg0) {
			if (panelOfertasPrincipal.getComponentCount()>=1)
			{
				int position = vID.indexOf(getAuxID());
				panelOfertasPrincipal.remove(panelOfertasPrincipal.getComponent(position));
				vOfer.remove(position);
				vID.remove(position);
				panelOfertasPrincipal.repaint();
				panelOfertasPrincipal.revalidate();
			}
		}
		
		public int getAuxID() {
			return this.auxID;
		}
		
		public void setAuxID(int id) {
			this.auxID = id;
		}
	}
	
	public class EditarOferta implements ActionListener {
		Oferta auxOferta;
		int auxID;
		
		public void actionPerformed(ActionEvent arg0) {
			setEditingId(getAuxID());
			llenarElementos(getOferta());
			panelDesplegableOfertas.setVisible(true);
			((CardLayout) panelDesplegableOfertas.getLayout()).show(panelDesplegableOfertas, "panelEditar");
		}

		public Oferta getOferta() {
			return this.auxOferta;
		}
		
		public void setOferta(String titulo, String foto, String descripcion) {
			this.auxOferta = new Oferta(titulo, foto, descripcion);
		}
		
		public int getAuxID() {
			return this.auxID;
		}
		
		public void setAuxID(int id) {
			this.auxID = id;
		}
	}
	
	/***********************************LISTENERS OFERTAS NUEVO***********************************/
	private class BtnGuardarNActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				
				if(comprobarCamposLlenosNuevo()) {
					oferta = new Oferta(txtTituloN.getText(), file.getPath() , taDescripcionN.getText());
					vOfer.add(oferta);
					crearPanel();
					panelDesplegableOfertas.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(frame, "Algún campo no se ha rellenado.", "Campos", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(frame, "Seleccione una imagen válida.", "Custom Error", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}
	
	private class BtnCancelarNActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			panelDesplegableOfertas.setVisible(false);
		}
	}
	
	private class BtnSubirFotoNActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			cargarFoto(lblFotoN);
		}
	}
	
	/***********************************LISTENERS OFERTAS EDITAR***********************************/
	private class BtnSubirFotoEActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			cargarFoto(lblFotoE);
			setImagenSustitutaEditar(true);
		}
	}
	
	private class BtnGuardarEActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				int option = JOptionPane.showConfirmDialog(frame, "¿Estás seguro que quieres sobreescribir esta oferta?", 
						"Dar de baja", JOptionPane.OK_CANCEL_OPTION);
				
				if (0 == option) {
					
					if(comprobarCamposLlenosEditar()) {
						/*borrar el panel k modificamos para crear uno nuevo con la info nueva*/
						int position = vID.indexOf(getEditingId());
						
						if (!isImagenSustitutaEditar()) {
							/*sino se ha subido una nueva img, pilla el ultimo path que haya (ej. el de una creada anteriormente) 
							 * y pone otra img que no es la que deberia salir*/
							file = new File(vOfer.get(position).getFoto());
						}else {
							setImagenSustitutaEditar(false);//se vuelve a poner falso para futuras iteraciones
						}
						
						panelOfertasPrincipal.remove(panelOfertasPrincipal.getComponent(position));
						vOfer.remove(position);
						vID.remove(position);
						panelOfertasPrincipal.repaint();
						panelOfertasPrincipal.revalidate();
						
						oferta = new Oferta(txtTituloE.getText(), file.getPath() , taDescripcionE.getText());
						vOfer.add(oferta);
						crearPanel();
						panelDesplegableOfertas.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame, "Algún campo no se ha rellenado.", "Campos", JOptionPane.ERROR_MESSAGE);
					}
					
				}			
			}catch(Exception e) {
				JOptionPane.showMessageDialog(frame, "Seleccione una imagen válida.", "Imagen no válida", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class BtnCancelarEActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			panelDesplegableOfertas.setVisible(false);
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	private class BtnNuevoMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNuevo.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnNuevo.setBackground(new Color (47,198,152));
		}
	}
	
	private class BtnSubirFotoNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSubirFotoN.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSubirFotoN.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnCancelarNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarN.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarN.setBackground(new Color(255,71,71));
		}
	}
	
	private class BtnGuardarNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnGuardarN.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnGuardarN.setBackground(new Color (47,198,152));
		}
	}
	
	private class BtnSubirFotoEMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSubirFotoE.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSubirFotoE.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnCancelarEMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarE.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarE.setBackground(new Color(255,71,71));
		}
	}
	
	private class BtnGuardarEMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnGuardarE.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnGuardarE.setBackground(new Color (47,198,152));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	public void limpiarElementos() {
		lblFotoN.setIcon(null);
		file = null;
		txtTituloN.setText(null);
		taDescripcionN.setText(null);
	}
	
	public void crearPanel() {
		panelOfertasPrincipal.add(new panelOfertasPrincipal(new DarDeBaja(), new EditarOferta()));
		panelOfertasPrincipal.repaint();
		panelOfertasPrincipal.revalidate();
		
		principal = (panelOfertasPrincipal) panelOfertasPrincipal.getComponent(panelOfertasPrincipal.getComponentCount()-1);
		principal.setAuxPath(vOfer.elementAt(panelOfertasPrincipal.getComponentCount()-1).getFoto());
		
		/*configurar el id para despues poder dar de baja el panel correspondiente*/
		setGlobalId(globalId+1);
		principal.setParticularId(getGlobalId());
		vID.add(principal.getParticularId());
		
		File file = new File(vOfer.elementAt(panelOfertasPrincipal.getComponentCount()-1).getFoto());
		try {
			Image imagenOriginal = ImageIO.read(file);
			Image imagenEscalada = imagenOriginal.getScaledInstance(principal.getLblImage().getWidth(), 
					principal.getLblImage().getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			principal.getLblImage().setIcon(iconoLabel);
			principal.getLblTitle().setText(vOfer.elementAt(panelOfertasPrincipal.getComponentCount()-1).getTitulo());
			principal.getTaDescripcion().setText(vOfer.elementAt(panelOfertasPrincipal.getComponentCount()-1).getDescripcion());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarFoto(JLabel lblFoto) {
		JFileChooser fcAbrir = new JFileChooser();
		int valorDevuelto = fcAbrir.showOpenDialog(frame);
		
		if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			file = fcAbrir.getSelectedFile();
			System.out.println("Fichero seleccionado: " + file.getName());
			//imagen escalada
			Image imagenOriginal;
			try {
				imagenOriginal = ImageIO.read(file);
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblFoto.getWidth()-12,
				lblFoto.getHeight()-24, java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblFoto.setIcon(iconoLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void llenarElementos(Oferta oferta) {
		File file = new File(oferta.getFoto());
		try {
			Image imagenOriginal = ImageIO.read(file);
			Image imagenEscalada = imagenOriginal.getScaledInstance(principal.getLblImage().getWidth()+23, 
					principal.getLblImage().getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblFotoE.setIcon(iconoLabel);
			txtTituloE.setText(oferta.getTitulo());
			taDescripcionE.setText(oferta.getDescripcion());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean comprobarCamposLlenosEditar() {
		if (txtTituloE.getText() == null || 
			taDescripcionE.getText() == null)
			{
				return false;
			}
		
		return true;
	}
	
	private boolean comprobarCamposLlenosNuevo() {
		if (txtTituloN.getText() == null || 
			taDescripcionN.getText() == null)
			{
				return false;
			}
		if (txtTituloN.getText() == null) {
			System.out.println("true");
		}
		if (taDescripcionN.getText() == null) {
			System.out.println("true");
		}
		
		
		
		return true;
	}

	/*******************************GETTERS & SETTERS********************************/
	public JLabel getLblFotoN() {
		return lblFotoN;
	}

	public void setLblFotoN(JLabel lblFotoN) {
		this.lblFotoN = lblFotoN;
	}

	public JButton getBtnSubirFotoN() {
		return btnSubirFotoN;
	}

	public void setBtnSubirFotoN(JButton btnSubirFotoN) {
		this.btnSubirFotoN = btnSubirFotoN;
	}

	public JLabel getLblTituloN() {
		return lblTituloN;
	}

	public void setLblTituloN(JLabel lblTituloN) {
		this.lblTituloN = lblTituloN;
	}

	public JTextField getTxtTituloN() {
		return txtTituloN;
	}

	public void setTxtTituloN(JTextField txtTituloN) {
		this.txtTituloN = txtTituloN;
	}

	public JTextArea getTaDescripcionN() {
		return taDescripcionN;
	}

	public void setTaDescripcionN(JTextArea taDescripcionN) {
		this.taDescripcionN = taDescripcionN;
	}

	public JButton getBtnGuardarN() {
		return btnGuardarN;
	}

	public void setBtnGuardarN(JButton btnGuardarN) {
		this.btnGuardarN = btnGuardarN;
	}

	public JButton getBtnCancelarN() {
		return btnCancelarN;
	}

	public void setBtnCancelarN(JButton btnCancelarN) {
		this.btnCancelarN = btnCancelarN;
	}

	public JButton getBtnSubirFotoE() {
		return btnSubirFotoE;
	}

	public void setBtnSubirFotoE(JButton btnSubirFotoE) {
		this.btnSubirFotoE = btnSubirFotoE;
	}

	public JLabel getLblTituloE() {
		return lblTituloE;
	}

	public void setLblTituloE(JLabel lblTituloE) {
		this.lblTituloE = lblTituloE;
	}

	public JTextField getTxtTituloE() {
		return txtTituloE;
	}

	public void setTxtTituloE(JTextField txtTituloE) {
		this.txtTituloE = txtTituloE;
	}

	public JButton getBtnGuardarE() {
		return btnGuardarE;
	}

	public void setBtnGuardarE(JButton btnGuardarE) {
		this.btnGuardarE = btnGuardarE;
	}

	public JLabel getLblFotoE() {
		return lblFotoE;
	}

	public void setLblFotoE(JLabel lblFotoE) {
		this.lblFotoE = lblFotoE;
	}

	public JTextArea getTaDescripcionE() {
		return taDescripcionE;
	}

	public void setTaDescripcionE(JTextArea taDescripcionE) {
		this.taDescripcionE = taDescripcionE;
	}

	public JButton getBtnCancelarE() {
		return btnCancelarE;
	}

	public void setBtnCancelarE(JButton btnCancelarE) {
		this.btnCancelarE = btnCancelarE;
	}

	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int generarId) {
		this.globalId = generarId;
	}

	public int getEditingId() {
		return editingId;
	}

	public void setEditingId(int editingId) {
		this.editingId = editingId;
	}

	public boolean isImagenSustitutaEditar() {
		return imagenSustitutaEditar;
	}

	public void setImagenSustitutaEditar(boolean imagenSustitutaEditar) {
		this.imagenSustitutaEditar = imagenSustitutaEditar;
	}
	
}
