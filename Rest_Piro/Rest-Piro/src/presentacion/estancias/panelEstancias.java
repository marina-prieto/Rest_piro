package presentacion.estancias;

//import presentacion.reservas.*;
import dominio.*;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings({ "serial", "rawtypes", "unchecked"})
public class panelEstancias extends JPanel {
	
	private Vector<Integer> identifiers = new Vector<Integer>();
	private int globalId = -1;
	private int editingId = -1;
	private JPanel pnlBarraSuperior;
	private JPanel pnlBotonesBarraSuperior;
	private JButton btnNuevo;
	private JPanel pnlPrincipalEstancias;
	private JPanel pnlDesplegable;
	private JScrollPane scrollPane;
	private JPanel pnlListaEstancias;
	private JPanel pnlNuevo;
	private JPanel pnlEditar;
	private JLabel lblFotoN;
	private JButton btnSubirFotoN;
	private JLabel lblTipoN;
	private JLabel lblTamanoN;
	private JLabel lblOpcExtraN;
	private JLabel lblPrecioN;
	private JButton btnGuardarN;
	private JTextField txtTamanoN;
	private JTextField txtPrecioN;
	private JButton btnCancelarN;
	private File fileFoto;
	private JLabel lblTitulo;
	private JLabel lblPrecio;
	private JComboBox cbPrecioFiltro;
	private JLabel lblTipo;
	private JComboBox cbTipoFiltro;
	private JTextField txtNombreN;
	private JComboBox cbTipo;
	private JComboBox txtOpcExtraN;
	private JButton btnOpcion1N;
	private JButton btnOpcion2N;
	private JButton btnOpcion3N;
	private JButton btnOpcion4N;
	private JButton btnOpcion5N;
	private JButton btnOpcion6N;
	private JScrollPane scrollComentN;
	private JTextArea txtComentariosN;
	private JButton btnServiciosSelected;
	private JLabel lblTipoE;
	private JLabel lblTamanoE;
	private JTextField txtTamanoE;
	private JTextField txtPrecioE;
	private JLabel lblPrecioE;
	private JLabel lblOpcExtraE;
	private JComboBox txtOpcExtraE;
	private JLabel txtTipoE;
	private JPanel pnlReservar;
	private JLabel lblTituloR;
	private JLabel lblNombreR;
	private JTextField txtNombreR;
	private JLabel lblTelefonoR;
	private JFormattedTextField ftxtTelefonoR;
	private JDateChooser dateIniR;
	private JLabel lblFechaIniR;
	private JDateChooser dateFinR;
	private JLabel lblFechaFinR;
	private JLabel lblPersonasR;
	private JLabel lblCorreoR;
	private JComboBox txtPersonasR;
	private JTextField txtCorreoR;
	private JScrollPane scrollAnotacionesR;
	private JTextArea txtAnotacionesR;
	private JButton btnCancelarR;
	private JButton btnGuardarR;
	private JLabel lblAnotacionR;
	private JLabel lblNombre;
	private JLabel lblTituloEstanciaN;
	private JLabel lblTituloEstanciaE;
	private JLabel lblFotoE;
	private JButton btnSubirFotoE;
	private JTextField txtNombreE;
	private JLabel lblNombreE;
	private JButton btnOpcion1E;
	private JButton btnOpcion2E;
	private JButton btnOpcion3E;
	private JLabel lblDisponibilidadE;
	private JButton btnOpcion4E;
	private JButton btnOpcion5E;
	private JButton btnOpcion6E;
	private JScrollPane scrollComentE;
	private JTextArea txtComentariosE;
	private JComboBox cbDisponibilidadE;
	private JButton btnGuardarE;
	private JButton btnCancelarE;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelEstancias() {
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(20, 0));
		
		pnlBarraSuperior = new JPanel();
		pnlBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.setBorder(null);
		add(pnlBarraSuperior, BorderLayout.NORTH);
		pnlBarraSuperior.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblTitulo = new JLabel("    ESTANCIAS");
		lblTitulo.setBorder(new EmptyBorder(30, 0, 40, 0));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 46));
		pnlBarraSuperior.add(lblTitulo);
		
		pnlBotonesBarraSuperior = new JPanel();
		pnlBotonesBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.add(pnlBotonesBarraSuperior);
		GridBagLayout gbl_pnlBotonesBarraSuperior = new GridBagLayout();
		gbl_pnlBotonesBarraSuperior.columnWidths = new int[] {30, 0, 0, 0, 0, 0, 0, 80, 50, 0};
		gbl_pnlBotonesBarraSuperior.rowHeights = new int[] {0, 15, 0};
		gbl_pnlBotonesBarraSuperior.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotonesBarraSuperior.rowWeights = new double[]{1.0, 1.0, 1.0};
		pnlBotonesBarraSuperior.setLayout(gbl_pnlBotonesBarraSuperior);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color (47,198,152));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNuevo.addMouseListener(new BtnNuevoMouseListener());
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		
		lblPrecio = new JLabel("Precio: ");
		lblPrecio.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 1;
		pnlBotonesBarraSuperior.add(lblPrecio, gbc_lblPrecio);
		
		cbPrecioFiltro = new JComboBox();
		cbPrecioFiltro.setForeground(Color.WHITE);
		cbPrecioFiltro.setBackground(Color.DARK_GRAY);
		cbPrecioFiltro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Ascendente", "Descendente", "Funcionalidad", "Sin Uso"}));
		GridBagConstraints gbc_cbPrecioFiltro = new GridBagConstraints();
		gbc_cbPrecioFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_cbPrecioFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPrecioFiltro.gridx = 2;
		gbc_cbPrecioFiltro.gridy = 1;
		pnlBotonesBarraSuperior.add(cbPrecioFiltro, gbc_cbPrecioFiltro);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 4;
		gbc_lblTipo.gridy = 1;
		pnlBotonesBarraSuperior.add(lblTipo, gbc_lblTipo);
		
		cbTipoFiltro = new JComboBox();
		cbTipoFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todo", "Parcelas", "Bungalows", "Filtro", "No funcional"}));
		cbTipoFiltro.setBackground(Color.DARK_GRAY);
		cbTipoFiltro.setForeground(Color.WHITE);
		GridBagConstraints gbc_cbTipoFiltro = new GridBagConstraints();
		gbc_cbTipoFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipoFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipoFiltro.gridx = 5;
		gbc_cbTipoFiltro.gridy = 1;
		pnlBotonesBarraSuperior.add(cbTipoFiltro, gbc_cbTipoFiltro);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 7;
		gbc_btnNuevo.gridy = 1;
		pnlBotonesBarraSuperior.add(btnNuevo, gbc_btnNuevo);
		
		pnlPrincipalEstancias = new JPanel();
		pnlPrincipalEstancias.setBackground(new Color(31,34,40));
		add(pnlPrincipalEstancias, BorderLayout.CENTER);
		pnlPrincipalEstancias.setLayout(new BorderLayout(0, 0));
		
		pnlDesplegable = new JPanel();
		pnlDesplegable.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDesplegable.setVisible(false);
		pnlPrincipalEstancias.add(pnlDesplegable, BorderLayout.EAST);
		pnlDesplegable.setLayout(new CardLayout(0, 0));
		
		pnlNuevo = new JPanel();
		pnlNuevo.setName("nuevo");
		pnlNuevo.setBackground(new Color(42,46,49));
		pnlNuevo.setAlignmentY(Component.TOP_ALIGNMENT);
		pnlNuevo.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlNuevo.setBorder(null);
		pnlDesplegable.add(pnlNuevo);
		GridBagLayout gbl_pnlNuevo = new GridBagLayout();
		gbl_pnlNuevo.columnWidths = new int[] {70, 70, 1, 70, 70, 70};
		gbl_pnlNuevo.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_pnlNuevo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlNuevo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0};
		pnlNuevo.setLayout(gbl_pnlNuevo);
		
		lblTituloEstanciaN = new JLabel("Nueva Estancia");
		lblTituloEstanciaN.setOpaque(true);
		lblTituloEstanciaN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEstanciaN.setForeground(Color.WHITE);
		lblTituloEstanciaN.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloEstanciaN.setBackground(new Color(42, 46, 49));
		GridBagConstraints gbc_lblTituloEstanciaN = new GridBagConstraints();
		gbc_lblTituloEstanciaN.gridwidth = 6;
		gbc_lblTituloEstanciaN.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloEstanciaN.gridx = 0;
		gbc_lblTituloEstanciaN.gridy = 0;
		pnlNuevo.add(lblTituloEstanciaN, gbc_lblTituloEstanciaN);
		
		lblFotoN = new JLabel("");
		lblFotoN.setPreferredSize(new Dimension(230, 230));
		lblFotoN.setMaximumSize(new Dimension(230, 230));
		lblFotoN.setMinimumSize(new Dimension(230, 230));
		lblFotoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoN = new GridBagConstraints();
		gbc_lblFotoN.gridwidth = 4;
		gbc_lblFotoN.gridheight = 3;
		gbc_lblFotoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoN.gridx = 1;
		gbc_lblFotoN.gridy = 1;
		pnlNuevo.add(lblFotoN, gbc_lblFotoN);
		
		btnSubirFotoN = new JButton("Subir foto...");
		btnSubirFotoN.setMinimumSize(new Dimension(230, 23));
		btnSubirFotoN.setMaximumSize(new Dimension(230, 23));
		btnSubirFotoN.addMouseListener(new BtnSubirFotoNMouseListener());
		btnSubirFotoN.setPreferredSize(new Dimension(230, 28));
		btnSubirFotoN.setBackground(new Color(0,120,210));
		btnSubirFotoN.setForeground(Color.WHITE);
		btnSubirFotoN.setBorder(null);
		btnSubirFotoN.addActionListener(new BtnSubirFotoNActionListener());
		btnSubirFotoN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoN = new GridBagConstraints();
		gbc_btnSubirFotoN.gridwidth = 4;
		gbc_btnSubirFotoN.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoN.gridx = 1;
		gbc_btnSubirFotoN.gridy = 4;
		pnlNuevo.add(btnSubirFotoN, gbc_btnSubirFotoN);
		
		txtNombreN = new JTextField();
		txtNombreN.setPreferredSize(new Dimension(210, 20));
		txtNombreN.setMinimumSize(new Dimension(210, 20));
		txtNombreN.setMaximumSize(new Dimension(210, 2147483647));
		txtNombreN.addMouseListener(new clearText());
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 5;
		pnlNuevo.add(lblNombre, gbc_lblNombre);
		txtNombreN.setForeground(Color.WHITE);
		txtNombreN.setBackground(Color.DARK_GRAY);
		txtNombreN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtNombreN = new GridBagConstraints();
		gbc_txtNombreN.anchor = GridBagConstraints.WEST;
		gbc_txtNombreN.gridwidth = 3;
		gbc_txtNombreN.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreN.gridx = 2;
		gbc_txtNombreN.gridy = 5;
		pnlNuevo.add(txtNombreN, gbc_txtNombreN);
		txtNombreN.setColumns(10);
		
		lblTamanoN = new JLabel("Tamaño: ");
		lblTamanoN.setForeground(Color.WHITE);
		lblTamanoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTamanoN = new GridBagConstraints();
		gbc_lblTamanoN.anchor = GridBagConstraints.EAST;
		gbc_lblTamanoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamanoN.gridx = 1;
		gbc_lblTamanoN.gridy = 6;
		pnlNuevo.add(lblTamanoN, gbc_lblTamanoN);
		
		txtTamanoN = new JTextField();
		txtTamanoN.setMinimumSize(new Dimension(210, 20));
		txtTamanoN.setMaximumSize(new Dimension(210, 2147483647));
		txtTamanoN.setPreferredSize(new Dimension(210, 20));
		txtTamanoN.setCaretColor(Color.WHITE);
		txtTamanoN.setForeground(Color.WHITE);
		txtTamanoN.setBackground(Color.DARK_GRAY);
		txtTamanoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtTamanoN = new GridBagConstraints();
		gbc_txtTamanoN.anchor = GridBagConstraints.WEST;
		gbc_txtTamanoN.gridwidth = 3;
		gbc_txtTamanoN.insets = new Insets(0, 0, 5, 5);
		gbc_txtTamanoN.gridx = 2;
		gbc_txtTamanoN.gridy = 6;
		pnlNuevo.add(txtTamanoN, gbc_txtTamanoN);
		txtTamanoN.setColumns(10);
		
		lblPrecioN = new JLabel("Precio/noche: ");
		lblPrecioN.setForeground(Color.WHITE);
		lblPrecioN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioN = new GridBagConstraints();
		gbc_lblPrecioN.gridwidth = 2;
		gbc_lblPrecioN.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioN.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioN.gridx = 0;
		gbc_lblPrecioN.gridy = 7;
		pnlNuevo.add(lblPrecioN, gbc_lblPrecioN);
		
		txtPrecioN = new JTextField();
		txtPrecioN.setPreferredSize(new Dimension(210, 20));
		txtPrecioN.setMaximumSize(new Dimension(210, 2147483647));
		txtPrecioN.setMinimumSize(new Dimension(210, 20));
		txtPrecioN.setCaretColor(Color.WHITE);
		txtPrecioN.setForeground(Color.WHITE);
		txtPrecioN.setBackground(Color.DARK_GRAY);
		txtPrecioN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtPrecioN = new GridBagConstraints();
		gbc_txtPrecioN.anchor = GridBagConstraints.WEST;
		gbc_txtPrecioN.gridwidth = 3;
		gbc_txtPrecioN.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioN.gridx = 2;
		gbc_txtPrecioN.gridy = 7;
		pnlNuevo.add(txtPrecioN, gbc_txtPrecioN);
		txtPrecioN.setColumns(10);
		
		btnOpcion1N = new JButton("");
		btnOpcion1N.setEnabled(false);
		btnOpcion1N.setMinimumSize(new Dimension(120, 9));
		btnOpcion1N.setMaximumSize(new Dimension(120, 9));
		btnOpcion1N.setPreferredSize(new Dimension(120, 9));
		btnOpcion1N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion1N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion1N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion1N.setForeground(Color.WHITE);
		btnOpcion1N.setBackground(Color.DARK_GRAY);
		btnOpcion1N.addMouseListener(new buttonSelected());
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbTipo.addActionListener(new changeButtons());
		
		lblTipoN = new JLabel("Tipo: ");
		lblTipoN.setForeground(Color.WHITE);
		lblTipoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTipoN = new GridBagConstraints();
		gbc_lblTipoN.anchor = GridBagConstraints.EAST;
		gbc_lblTipoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoN.gridx = 1;
		gbc_lblTipoN.gridy = 8;
		pnlNuevo.add(lblTipoN, gbc_lblTipoN);
		cbTipo.setForeground(Color.WHITE);
		cbTipo.setBackground(Color.DARK_GRAY);
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Parcela", "Bungalow"}));
		GridBagConstraints gbc_cbTipo = new GridBagConstraints();
		gbc_cbTipo.anchor = GridBagConstraints.WEST;
		gbc_cbTipo.gridwidth = 3;
		gbc_cbTipo.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipo.gridx = 2;
		gbc_cbTipo.gridy = 8;
		pnlNuevo.add(cbTipo, gbc_cbTipo);
		
		txtOpcExtraN = new JComboBox();
		txtOpcExtraN.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtOpcExtraN.setVisible(false);
		
		lblOpcExtraN = new JLabel("editable");
		lblOpcExtraN.setForeground(Color.WHITE);
		lblOpcExtraN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblOpcExtraN = new GridBagConstraints();
		gbc_lblOpcExtraN.anchor = GridBagConstraints.EAST;
		gbc_lblOpcExtraN.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcExtraN.gridx = 1;
		gbc_lblOpcExtraN.gridy = 9;
		pnlNuevo.add(lblOpcExtraN, gbc_lblOpcExtraN);
		txtOpcExtraN.setForeground(Color.WHITE);
		txtOpcExtraN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtOpcExtraN = new GridBagConstraints();
		gbc_txtOpcExtraN.anchor = GridBagConstraints.WEST;
		gbc_txtOpcExtraN.gridwidth = 3;
		gbc_txtOpcExtraN.insets = new Insets(0, 0, 5, 5);
		gbc_txtOpcExtraN.gridx = 2;
		gbc_txtOpcExtraN.gridy = 9;
		pnlNuevo.add(txtOpcExtraN, gbc_txtOpcExtraN);
		GridBagConstraints gbc_btnOpcion1N = new GridBagConstraints();
		gbc_btnOpcion1N.anchor = GridBagConstraints.EAST;
		gbc_btnOpcion1N.gridwidth = 2;
		gbc_btnOpcion1N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion1N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion1N.gridx = 1;
		gbc_btnOpcion1N.gridy = 11;
		pnlNuevo.add(btnOpcion1N, gbc_btnOpcion1N);
		
		btnOpcion2N = new JButton("");
		btnOpcion2N.setEnabled(false);
		btnOpcion2N.setPreferredSize(new Dimension(120, 9));
		btnOpcion2N.setMaximumSize(new Dimension(120, 9));
		btnOpcion2N.setMinimumSize(new Dimension(120, 9));
		btnOpcion2N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion2N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion2N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion2N.setBackground(Color.DARK_GRAY);
		btnOpcion2N.setForeground(Color.WHITE);
		btnOpcion2N.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion2N = new GridBagConstraints();
		gbc_btnOpcion2N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion2N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion2N.gridx = 3;
		gbc_btnOpcion2N.gridy = 11;
		pnlNuevo.add(btnOpcion2N, gbc_btnOpcion2N);
		
		btnOpcion3N = new JButton("");
		btnOpcion3N.setEnabled(false);
		btnOpcion3N.setMinimumSize(new Dimension(120, 9));
		btnOpcion3N.setMaximumSize(new Dimension(120, 9));
		btnOpcion3N.setPreferredSize(new Dimension(120, 9));
		btnOpcion3N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion3N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion3N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion3N.setForeground(Color.WHITE);
		btnOpcion3N.setBackground(Color.DARK_GRAY);
		btnOpcion3N.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion3N = new GridBagConstraints();
		gbc_btnOpcion3N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion3N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion3N.gridx = 4;
		gbc_btnOpcion3N.gridy = 11;
		pnlNuevo.add(btnOpcion3N, gbc_btnOpcion3N);
		
		btnOpcion4N = new JButton("");
		btnOpcion4N.setEnabled(false);
		btnOpcion4N.setMaximumSize(new Dimension(120, 9));
		btnOpcion4N.setMinimumSize(new Dimension(120, 9));
		btnOpcion4N.setPreferredSize(new Dimension(120, 9));
		btnOpcion4N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion4N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion4N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion4N.setBackground(Color.DARK_GRAY);
		btnOpcion4N.setForeground(Color.WHITE);
		btnOpcion4N.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion4N = new GridBagConstraints();
		gbc_btnOpcion4N.anchor = GridBagConstraints.EAST;
		gbc_btnOpcion4N.gridwidth = 2;
		gbc_btnOpcion4N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion4N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion4N.gridx = 1;
		gbc_btnOpcion4N.gridy = 12;
		pnlNuevo.add(btnOpcion4N, gbc_btnOpcion4N);
		
		btnOpcion5N = new JButton("");
		btnOpcion5N.setEnabled(false);
		btnOpcion5N.setPreferredSize(new Dimension(120, 9));
		btnOpcion5N.setMinimumSize(new Dimension(120, 9));
		btnOpcion5N.setMaximumSize(new Dimension(120, 9));
		btnOpcion5N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion5N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion5N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion5N.setBackground(Color.DARK_GRAY);
		btnOpcion5N.setForeground(Color.WHITE);
		btnOpcion5N.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion5N = new GridBagConstraints();
		gbc_btnOpcion5N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion5N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion5N.gridx = 3;
		gbc_btnOpcion5N.gridy = 12;
		pnlNuevo.add(btnOpcion5N, gbc_btnOpcion5N);
		
		btnOpcion6N = new JButton("");
		btnOpcion6N.setEnabled(false);
		btnOpcion6N.setMaximumSize(new Dimension(120, 9));
		btnOpcion6N.setMinimumSize(new Dimension(120, 9));
		btnOpcion6N.setPreferredSize(new Dimension(120, 9));
		btnOpcion6N.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion6N.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion6N.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion6N.setBackground(Color.DARK_GRAY);
		btnOpcion6N.setForeground(Color.WHITE);
		btnOpcion6N.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion6N = new GridBagConstraints();
		gbc_btnOpcion6N.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion6N.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion6N.gridx = 4;
		gbc_btnOpcion6N.gridy = 12;
		pnlNuevo.add(btnOpcion6N, gbc_btnOpcion6N);
		
		scrollComentN = new JScrollPane();
		scrollComentN.setBackground(Color.DARK_GRAY);
		scrollComentN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Comentarios...", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrollComentN = new GridBagConstraints();
		gbc_scrollComentN.gridheight = 3;
		gbc_scrollComentN.gridwidth = 4;
		gbc_scrollComentN.insets = new Insets(0, 0, 5, 5);
		gbc_scrollComentN.fill = GridBagConstraints.BOTH;
		gbc_scrollComentN.gridx = 1;
		gbc_scrollComentN.gridy = 14;
		pnlNuevo.add(scrollComentN, gbc_scrollComentN);
		
		txtComentariosN = new JTextArea();
		txtComentariosN.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtComentariosN.setForeground(Color.WHITE);
		txtComentariosN.setBackground(Color.DARK_GRAY);
		scrollComentN.setViewportView(txtComentariosN);
		
		btnCancelarN = new JButton("Cancelar");
		btnCancelarN.addMouseListener(new BtnCancelarNMouseListener());
		btnCancelarN.setPreferredSize(new Dimension(75, 33));
		btnCancelarN.setBorder(null);
		btnCancelarN.setForeground(Color.WHITE);
		btnCancelarN.setBackground(new Color(255,71,71));
		btnCancelarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarN.addActionListener(new BtnCancelarActionListener());
		GridBagConstraints gbc_btnCancelarN = new GridBagConstraints();
		gbc_btnCancelarN.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarN.gridwidth = 3;
		gbc_btnCancelarN.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarN.gridx = 1;
		gbc_btnCancelarN.gridy = 18;
		pnlNuevo.add(btnCancelarN, gbc_btnCancelarN);
		
		btnGuardarN = new JButton("Guardar");
		btnGuardarN.addMouseListener(new BtnGuardarNMouseListener());
		btnGuardarN.setPreferredSize(new Dimension(71, 33));
		btnGuardarN.setForeground(Color.WHITE);
		btnGuardarN.setBorder(null);
		btnGuardarN.setBackground(new Color(47,198,152));
		btnGuardarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardarN.addActionListener(new BtnGuardarNActionListener());
		btnGuardarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarN = new GridBagConstraints();
		gbc_btnGuardarN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarN.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarN.gridx = 4;
		gbc_btnGuardarN.gridy = 18;
		pnlNuevo.add(btnGuardarN, gbc_btnGuardarN);
		
		pnlEditar = new JPanel();
		pnlEditar.setName("editar");
		pnlEditar.setForeground(Color.WHITE);
		pnlEditar.setBackground(new Color(42,46,49));
		pnlDesplegable.add(pnlEditar,"editar");
		GridBagLayout gbl_pnlEditar = new GridBagLayout();
		gbl_pnlEditar.columnWidths = new int[] {70, 70, 1, 70, 70, 70};
		gbl_pnlEditar.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 0, 0, 0};
		gbl_pnlEditar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlEditar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0};
		pnlEditar.setLayout(gbl_pnlEditar);
		
		lblTituloEstanciaE = new JLabel("Editar Estancia");
		lblTituloEstanciaE.setOpaque(true);
		lblTituloEstanciaE.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEstanciaE.setForeground(Color.WHITE);
		lblTituloEstanciaE.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloEstanciaE.setBackground(new Color(42, 46, 49));
		GridBagConstraints gbc_lblTituloEstanciaE = new GridBagConstraints();
		gbc_lblTituloEstanciaE.gridwidth = 6;
		gbc_lblTituloEstanciaE.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloEstanciaE.gridx = 0;
		gbc_lblTituloEstanciaE.gridy = 0;
		pnlEditar.add(lblTituloEstanciaE, gbc_lblTituloEstanciaE);
		
		lblFotoE = new JLabel("");
		lblFotoE.setPreferredSize(new Dimension(230, 230));
		lblFotoE.setMinimumSize(new Dimension(230, 230));
		lblFotoE.setMaximumSize(new Dimension(230, 230));
		lblFotoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoE = new GridBagConstraints();
		gbc_lblFotoE.gridheight = 3;
		gbc_lblFotoE.gridwidth = 4;
		gbc_lblFotoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoE.gridx = 1;
		gbc_lblFotoE.gridy = 1;
		pnlEditar.add(lblFotoE, gbc_lblFotoE);
		
		btnSubirFotoE = new JButton("Cambiar foto...");
		btnSubirFotoE.addMouseListener(new BtnSubirFotoEMouseListener());
		btnSubirFotoE.setPreferredSize(new Dimension(230, 28));
		btnSubirFotoE.setMinimumSize(new Dimension(230, 23));
		btnSubirFotoE.setMaximumSize(new Dimension(230, 23));
		btnSubirFotoE.setForeground(Color.WHITE);
		btnSubirFotoE.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSubirFotoE.setBorder(null);
		btnSubirFotoE.addActionListener(new BtnSubirFotoEActionListener());
		btnSubirFotoE.setBackground(new Color(0, 120, 210));
		GridBagConstraints gbc_btnSubirFotoE = new GridBagConstraints();
		gbc_btnSubirFotoE.gridwidth = 4;
		gbc_btnSubirFotoE.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoE.gridx = 1;
		gbc_btnSubirFotoE.gridy = 4;
		pnlEditar.add(btnSubirFotoE, gbc_btnSubirFotoE);
		
		lblDisponibilidadE = new JLabel("Disponibilidad: ");
		lblDisponibilidadE.setForeground(Color.WHITE);
		lblDisponibilidadE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDisponibilidadE = new GridBagConstraints();
		gbc_lblDisponibilidadE.anchor = GridBagConstraints.EAST;
		gbc_lblDisponibilidadE.gridwidth = 2;
		gbc_lblDisponibilidadE.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidadE.gridx = 0;
		gbc_lblDisponibilidadE.gridy = 5;
		pnlEditar.add(lblDisponibilidadE, gbc_lblDisponibilidadE);
		
		cbDisponibilidadE = new JComboBox();
		cbDisponibilidadE.setModel(new DefaultComboBoxModel(new String[] {"Disponible", "Reservado", "En Mantenimiento", "En Reparación"}));
		cbDisponibilidadE.setForeground(Color.WHITE);
		cbDisponibilidadE.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbDisponibilidadE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_cbDisponibilidadE = new GridBagConstraints();
		gbc_cbDisponibilidadE.anchor = GridBagConstraints.WEST;
		gbc_cbDisponibilidadE.gridwidth = 3;
		gbc_cbDisponibilidadE.insets = new Insets(0, 0, 5, 5);
		gbc_cbDisponibilidadE.gridx = 2;
		gbc_cbDisponibilidadE.gridy = 5;
		pnlEditar.add(cbDisponibilidadE, gbc_cbDisponibilidadE);
		
		lblNombreE = new JLabel("Nombre: ");
		lblNombreE.setForeground(Color.WHITE);
		lblNombreE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombreE = new GridBagConstraints();
		gbc_lblNombreE.anchor = GridBagConstraints.EAST;
		gbc_lblNombreE.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreE.gridx = 1;
		gbc_lblNombreE.gridy = 6;
		pnlEditar.add(lblNombreE, gbc_lblNombreE);
		
		txtNombreE = new JTextField();
		txtNombreE.setPreferredSize(new Dimension(210, 20));
		txtNombreE.setMinimumSize(new Dimension(210, 20));
		txtNombreE.setMaximumSize(new Dimension(210, 2147483647));
		txtNombreE.setForeground(Color.WHITE);
		txtNombreE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombreE.setColumns(10);
		txtNombreE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtNombreE = new GridBagConstraints();
		gbc_txtNombreE.anchor = GridBagConstraints.WEST;
		gbc_txtNombreE.gridwidth = 3;
		gbc_txtNombreE.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreE.gridx = 2;
		gbc_txtNombreE.gridy = 6;
		pnlEditar.add(txtNombreE, gbc_txtNombreE);
		
		lblTamanoE = new JLabel("Tamaño: ");
		lblTamanoE.setForeground(Color.WHITE);
		lblTamanoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTamanoE = new GridBagConstraints();
		gbc_lblTamanoE.anchor = GridBagConstraints.EAST;
		gbc_lblTamanoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamanoE.gridx = 1;
		gbc_lblTamanoE.gridy = 7;
		pnlEditar.add(lblTamanoE, gbc_lblTamanoE);
		
		txtTamanoE = new JTextField();
		txtTamanoE.setForeground(Color.WHITE);
		txtTamanoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtTamanoE.setColumns(10);
		txtTamanoE.setCaretColor(Color.WHITE);
		txtTamanoE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtTamanoE = new GridBagConstraints();
		gbc_txtTamanoE.anchor = GridBagConstraints.WEST;
		gbc_txtTamanoE.gridwidth = 3;
		gbc_txtTamanoE.insets = new Insets(0, 0, 5, 5);
		gbc_txtTamanoE.gridx = 2;
		gbc_txtTamanoE.gridy = 7;
		pnlEditar.add(txtTamanoE, gbc_txtTamanoE);
		
		lblPrecioE = new JLabel("Precio/noche: ");
		lblPrecioE.setForeground(Color.WHITE);
		lblPrecioE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioE = new GridBagConstraints();
		gbc_lblPrecioE.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioE.gridwidth = 2;
		gbc_lblPrecioE.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioE.gridx = 0;
		gbc_lblPrecioE.gridy = 8;
		pnlEditar.add(lblPrecioE, gbc_lblPrecioE);
		
		txtPrecioE = new JTextField();
		txtPrecioE.setForeground(Color.WHITE);
		txtPrecioE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPrecioE.setColumns(10);
		txtPrecioE.setCaretColor(Color.WHITE);
		txtPrecioE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtPrecioE = new GridBagConstraints();
		gbc_txtPrecioE.anchor = GridBagConstraints.WEST;
		gbc_txtPrecioE.gridwidth = 3;
		gbc_txtPrecioE.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioE.gridx = 2;
		gbc_txtPrecioE.gridy = 8;
		pnlEditar.add(txtPrecioE, gbc_txtPrecioE);
		
		lblTipoE = new JLabel("Tipo: ");
		lblTipoE.setForeground(Color.WHITE);
		lblTipoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTipoE = new GridBagConstraints();
		gbc_lblTipoE.anchor = GridBagConstraints.EAST;
		gbc_lblTipoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoE.gridx = 1;
		gbc_lblTipoE.gridy = 9;
		pnlEditar.add(lblTipoE, gbc_lblTipoE);
		
		txtTipoE = new JLabel("");
		txtTipoE.setForeground(Color.WHITE);
		txtTipoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtTipoE = new GridBagConstraints();
		gbc_txtTipoE.anchor = GridBagConstraints.WEST;
		gbc_txtTipoE.gridwidth = 3;
		gbc_txtTipoE.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoE.gridx = 2;
		gbc_txtTipoE.gridy = 9;
		pnlEditar.add(txtTipoE, gbc_txtTipoE);
		
		lblOpcExtraE = new JLabel("Editable");
		lblOpcExtraE.setForeground(Color.WHITE);
		lblOpcExtraE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblOpcExtraE = new GridBagConstraints();
		gbc_lblOpcExtraE.anchor = GridBagConstraints.EAST;
		gbc_lblOpcExtraE.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcExtraE.gridx = 1;
		gbc_lblOpcExtraE.gridy = 10;
		pnlEditar.add(lblOpcExtraE, gbc_lblOpcExtraE);
		
		txtOpcExtraE = new JComboBox();
		txtOpcExtraE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtOpcExtraE.setForeground(Color.WHITE);
		txtOpcExtraE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtOpcExtraE = new GridBagConstraints();
		gbc_txtOpcExtraE.anchor = GridBagConstraints.WEST;
		gbc_txtOpcExtraE.gridwidth = 3;
		gbc_txtOpcExtraE.insets = new Insets(0, 0, 5, 5);
		gbc_txtOpcExtraE.gridx = 2;
		gbc_txtOpcExtraE.gridy = 10;
		pnlEditar.add(txtOpcExtraE, gbc_txtOpcExtraE);
		
		btnOpcion1E = new JButton("");
		btnOpcion1E.setPreferredSize(new Dimension(120, 9));
		btnOpcion1E.setMinimumSize(new Dimension(120, 9));
		btnOpcion1E.setMaximumSize(new Dimension(120, 9));
		btnOpcion1E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion1E.setForeground(Color.WHITE);
		btnOpcion1E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion1E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion1E.setBackground(Color.DARK_GRAY);
		btnOpcion1E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion1E = new GridBagConstraints();
		gbc_btnOpcion1E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion1E.gridwidth = 2;
		gbc_btnOpcion1E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion1E.gridx = 1;
		gbc_btnOpcion1E.gridy = 12;
		pnlEditar.add(btnOpcion1E, gbc_btnOpcion1E);
		
		btnOpcion2E = new JButton("");
		btnOpcion2E.setPreferredSize(new Dimension(120, 9));
		btnOpcion2E.setMinimumSize(new Dimension(120, 9));
		btnOpcion2E.setMaximumSize(new Dimension(120, 9));
		btnOpcion2E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion2E.setForeground(Color.WHITE);
		btnOpcion2E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion2E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion2E.setBackground(Color.DARK_GRAY);
		btnOpcion2E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion2E = new GridBagConstraints();
		gbc_btnOpcion2E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion2E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion2E.gridx = 3;
		gbc_btnOpcion2E.gridy = 12;
		pnlEditar.add(btnOpcion2E, gbc_btnOpcion2E);
		
		btnOpcion3E = new JButton("");
		btnOpcion3E.setPreferredSize(new Dimension(120, 9));
		btnOpcion3E.setMinimumSize(new Dimension(120, 9));
		btnOpcion3E.setMaximumSize(new Dimension(120, 9));
		btnOpcion3E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion3E.setForeground(Color.WHITE);
		btnOpcion3E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion3E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion3E.setBackground(Color.DARK_GRAY);
		btnOpcion3E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion3E = new GridBagConstraints();
		gbc_btnOpcion3E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion3E.anchor = GridBagConstraints.WEST;
		gbc_btnOpcion3E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion3E.gridx = 4;
		gbc_btnOpcion3E.gridy = 12;
		pnlEditar.add(btnOpcion3E, gbc_btnOpcion3E);
		
		btnOpcion4E = new JButton("");
		btnOpcion4E.setPreferredSize(new Dimension(120, 9));
		btnOpcion4E.setMinimumSize(new Dimension(120, 9));
		btnOpcion4E.setMaximumSize(new Dimension(120, 9));
		btnOpcion4E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion4E.setForeground(Color.WHITE);
		btnOpcion4E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion4E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion4E.setBackground(Color.DARK_GRAY);
		btnOpcion4E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion4E = new GridBagConstraints();
		gbc_btnOpcion4E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion4E.gridwidth = 2;
		gbc_btnOpcion4E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion4E.gridx = 1;
		gbc_btnOpcion4E.gridy = 13;
		pnlEditar.add(btnOpcion4E, gbc_btnOpcion4E);
		
		btnOpcion5E = new JButton("");
		btnOpcion5E.setPreferredSize(new Dimension(120, 9));
		btnOpcion5E.setMinimumSize(new Dimension(120, 9));
		btnOpcion5E.setMaximumSize(new Dimension(120, 9));
		btnOpcion5E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion5E.setForeground(Color.WHITE);
		btnOpcion5E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion5E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion5E.setBackground(Color.DARK_GRAY);
		btnOpcion5E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion5E = new GridBagConstraints();
		gbc_btnOpcion5E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion5E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion5E.gridx = 3;
		gbc_btnOpcion5E.gridy = 13;
		pnlEditar.add(btnOpcion5E, gbc_btnOpcion5E);
		
		btnOpcion6E = new JButton("");
		btnOpcion6E.setPreferredSize(new Dimension(120, 9));
		btnOpcion6E.setMinimumSize(new Dimension(120, 9));
		btnOpcion6E.setMaximumSize(new Dimension(120, 9));
		btnOpcion6E.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpcion6E.setForeground(Color.WHITE);
		btnOpcion6E.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnOpcion6E.setBorder(new EmptyBorder(6, 6, 6, 6));
		btnOpcion6E.setBackground(Color.DARK_GRAY);
		btnOpcion6E.addMouseListener(new buttonSelected());
		GridBagConstraints gbc_btnOpcion6E = new GridBagConstraints();
		gbc_btnOpcion6E.fill = GridBagConstraints.VERTICAL;
		gbc_btnOpcion6E.anchor = GridBagConstraints.WEST;
		gbc_btnOpcion6E.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpcion6E.gridx = 4;
		gbc_btnOpcion6E.gridy = 13;
		pnlEditar.add(btnOpcion6E, gbc_btnOpcion6E);
		
		scrollComentE = new JScrollPane();
		scrollComentE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Comentarios...", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.WHITE));
		scrollComentE.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_scrollComentE = new GridBagConstraints();
		gbc_scrollComentE.gridheight = 3;
		gbc_scrollComentE.gridwidth = 4;
		gbc_scrollComentE.insets = new Insets(0, 0, 5, 5);
		gbc_scrollComentE.fill = GridBagConstraints.BOTH;
		gbc_scrollComentE.gridx = 1;
		gbc_scrollComentE.gridy = 15;
		pnlEditar.add(scrollComentE, gbc_scrollComentE);
		
		txtComentariosE = new JTextArea();
		txtComentariosE.setForeground(Color.WHITE);
		txtComentariosE.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtComentariosE.setBackground(Color.DARK_GRAY);
		scrollComentE.setViewportView(txtComentariosE);
		
		btnCancelarE = new JButton("Cancelar");
		btnCancelarE.addMouseListener(new BtnCancelarEMouseListener());
		btnCancelarE.setPreferredSize(new Dimension(75, 33));
		btnCancelarE.setForeground(Color.WHITE);
		btnCancelarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarE.setBorder(null);
		btnCancelarE.setBackground(new Color(255, 71, 71));
		btnCancelarE.addActionListener(new BtnCancelarActionListener());
		GridBagConstraints gbc_btnCancelarE = new GridBagConstraints();
		gbc_btnCancelarE.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarE.gridwidth = 3;
		gbc_btnCancelarE.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarE.gridx = 1;
		gbc_btnCancelarE.gridy = 19;
		pnlEditar.add(btnCancelarE, gbc_btnCancelarE);
		
		btnGuardarE = new JButton("Guardar");
		btnGuardarE.addActionListener(new BtnGuardarEActionListener());
		btnGuardarE.addMouseListener(new BtnGuardarEMouseListener());
		btnGuardarE.setPreferredSize(new Dimension(71, 33));
		btnGuardarE.setForeground(Color.WHITE);
		btnGuardarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardarE.setBorder(null);
		btnGuardarE.setBackground(new Color(47, 198, 152));
		GridBagConstraints gbc_btnGuardarE = new GridBagConstraints();
		gbc_btnGuardarE.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarE.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarE.gridx = 4;
		gbc_btnGuardarE.gridy = 19;
		pnlEditar.add(btnGuardarE, gbc_btnGuardarE);
		
		pnlReservar = new JPanel();
		pnlReservar.setName("reservar");
		pnlReservar.setBackground(new Color(42,46,49));
		pnlReservar.setForeground(Color.WHITE);
		pnlDesplegable.add(pnlReservar, "reservar");
		GridBagLayout gbl_pnlReservar = new GridBagLayout();
		gbl_pnlReservar.columnWidths = new int[] {70, 70, 70, 70, 70};
		gbl_pnlReservar.rowHeights = new int[] {30, 30, 30, 50, 30, 30, 0, 0, 0, 30, 80, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_pnlReservar.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0};
		gbl_pnlReservar.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		pnlReservar.setLayout(gbl_pnlReservar);
		
		lblTituloR = new JLabel("Realizar Reserva");
		lblTituloR.setOpaque(true);
		lblTituloR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloR.setForeground(Color.WHITE);
		lblTituloR.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloR.setBackground(new Color(42, 46, 49));
		GridBagConstraints gbc_lblTituloR = new GridBagConstraints();
		gbc_lblTituloR.fill = GridBagConstraints.BOTH;
		gbc_lblTituloR.gridwidth = 3;
		gbc_lblTituloR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTituloR.gridx = 1;
		gbc_lblTituloR.gridy = 1;
		pnlReservar.add(lblTituloR, gbc_lblTituloR);
		
		lblAnotacionR = new JLabel("    (*) Campo Obligatorio");
		lblAnotacionR.setForeground(Color.WHITE);
		lblAnotacionR.setFont(new Font("Verdana", Font.BOLD, 11));
		GridBagConstraints gbc_lblAnotacionR = new GridBagConstraints();
		gbc_lblAnotacionR.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnotacionR.gridwidth = 3;
		gbc_lblAnotacionR.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnotacionR.gridx = 1;
		gbc_lblAnotacionR.gridy = 2;
		pnlReservar.add(lblAnotacionR, gbc_lblAnotacionR);
		
		lblNombreR = new JLabel("(*) Nombre Completo: ");
		lblNombreR.setForeground(Color.WHITE);
		lblNombreR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombreR = new GridBagConstraints();
		gbc_lblNombreR.anchor = GridBagConstraints.EAST;
		gbc_lblNombreR.gridwidth = 2;
		gbc_lblNombreR.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreR.gridx = 0;
		gbc_lblNombreR.gridy = 4;
		pnlReservar.add(lblNombreR, gbc_lblNombreR);
		
		txtNombreR = new JTextField();
		txtNombreR.setForeground(Color.WHITE);
		txtNombreR.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombreR.setColumns(10);
		txtNombreR.setCaretColor(Color.WHITE);
		txtNombreR.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtNombreR = new GridBagConstraints();
		gbc_txtNombreR.gridwidth = 2;
		gbc_txtNombreR.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreR.gridx = 2;
		gbc_txtNombreR.gridy = 4;
		pnlReservar.add(txtNombreR, gbc_txtNombreR);
		
		lblTelefonoR = new JLabel("(*) Teléfono: ");
		lblTelefonoR.setForeground(Color.WHITE);
		lblTelefonoR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelefonoR = new GridBagConstraints();
		gbc_lblTelefonoR.anchor = GridBagConstraints.EAST;
		gbc_lblTelefonoR.gridwidth = 2;
		gbc_lblTelefonoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonoR.gridx = 0;
		gbc_lblTelefonoR.gridy = 5;
		pnlReservar.add(lblTelefonoR, gbc_lblTelefonoR);
		
		MaskFormatter formater;
		try {
			formater = new MaskFormatter("+## - ###-##-##-##");
			formater.setPlaceholderCharacter('X');
			ftxtTelefonoR = new JFormattedTextField(formater);
			ftxtTelefonoR.setForeground(Color.WHITE);
			ftxtTelefonoR.setCaretColor(Color.WHITE);
			ftxtTelefonoR.setBackground(Color.DARK_GRAY);
			ftxtTelefonoR.setFont(new Font("Verdana", Font.PLAIN, 11));
			GridBagConstraints gbc_ftxtTelefonoR = new GridBagConstraints();
			gbc_ftxtTelefonoR.gridwidth = 2;
			gbc_ftxtTelefonoR.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtTelefonoR.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtTelefonoR.gridx = 2;
			gbc_ftxtTelefonoR.gridy = 5;
			pnlReservar.add(ftxtTelefonoR, gbc_ftxtTelefonoR);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lblCorreoR = new JLabel("Correo Electrónico: ");
		lblCorreoR.setForeground(Color.WHITE);
		lblCorreoR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCorreoR = new GridBagConstraints();
		gbc_lblCorreoR.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoR.gridwidth = 2;
		gbc_lblCorreoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoR.gridx = 0;
		gbc_lblCorreoR.gridy = 6;
		pnlReservar.add(lblCorreoR, gbc_lblCorreoR);
		
		txtCorreoR = new JTextField();
		txtCorreoR.setForeground(Color.WHITE);
		txtCorreoR.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCorreoR.setColumns(10);
		txtCorreoR.setCaretColor(Color.WHITE);
		txtCorreoR.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtCorreoR = new GridBagConstraints();
		gbc_txtCorreoR.gridwidth = 2;
		gbc_txtCorreoR.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreoR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreoR.gridx = 2;
		gbc_txtCorreoR.gridy = 6;
		pnlReservar.add(txtCorreoR, gbc_txtCorreoR);
		
		lblFechaIniR = new JLabel("(*) Fecha de inicio: ");
		lblFechaIniR.setForeground(Color.WHITE);
		lblFechaIniR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaIniR = new GridBagConstraints();
		gbc_lblFechaIniR.anchor = GridBagConstraints.EAST;
		gbc_lblFechaIniR.gridwidth = 2;
		gbc_lblFechaIniR.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaIniR.gridx = 0;
		gbc_lblFechaIniR.gridy = 7;
		pnlReservar.add(lblFechaIniR, gbc_lblFechaIniR);
		
		dateIniR = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
		GridBagConstraints gbc_dateIniR = new GridBagConstraints();
		gbc_dateIniR.gridwidth = 2;
		gbc_dateIniR.insets = new Insets(0, 0, 5, 5);
		gbc_dateIniR.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateIniR.gridx = 2;
		gbc_dateIniR.gridy = 7;
		pnlReservar.add(dateIniR, gbc_dateIniR);
		
		lblFechaFinR = new JLabel("(*) Fecha de fin:  ");
		lblFechaFinR.setForeground(Color.WHITE);
		lblFechaFinR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaFinR = new GridBagConstraints();
		gbc_lblFechaFinR.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinR.gridwidth = 2;
		gbc_lblFechaFinR.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinR.gridx = 0;
		gbc_lblFechaFinR.gridy = 8;
		pnlReservar.add(lblFechaFinR, gbc_lblFechaFinR);
		
		dateFinR = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
		GridBagConstraints gbc_dateFinR = new GridBagConstraints();
		gbc_dateFinR.gridwidth = 2;
		gbc_dateFinR.insets = new Insets(0, 0, 5, 5);
		gbc_dateFinR.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateFinR.gridx = 2;
		gbc_dateFinR.gridy = 8;
		pnlReservar.add(dateFinR, gbc_dateFinR);
		
		lblPersonasR = new JLabel("(*) Personas: ");
		lblPersonasR.setForeground(Color.WHITE);
		lblPersonasR.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPersonasR = new GridBagConstraints();
		gbc_lblPersonasR.anchor = GridBagConstraints.EAST;
		gbc_lblPersonasR.gridwidth = 2;
		gbc_lblPersonasR.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonasR.gridx = 0;
		gbc_lblPersonasR.gridy = 9;
		pnlReservar.add(lblPersonasR, gbc_lblPersonasR);
		
		txtPersonasR = new JComboBox();
		txtPersonasR.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		txtPersonasR.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPersonasR.setForeground(Color.WHITE);
		txtPersonasR.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_txtPersonasR = new GridBagConstraints();
		gbc_txtPersonasR.gridwidth = 2;
		gbc_txtPersonasR.insets = new Insets(0, 0, 5, 5);
		gbc_txtPersonasR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPersonasR.gridx = 2;
		gbc_txtPersonasR.gridy = 9;
		pnlReservar.add(txtPersonasR, gbc_txtPersonasR);
		
		scrollAnotacionesR = new JScrollPane();
		scrollAnotacionesR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Anotaciones...", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(255, 255, 255)));
		scrollAnotacionesR.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_scrollAnotacionesR = new GridBagConstraints();
		gbc_scrollAnotacionesR.gridheight = 5;
		gbc_scrollAnotacionesR.gridwidth = 3;
		gbc_scrollAnotacionesR.insets = new Insets(0, 0, 5, 5);
		gbc_scrollAnotacionesR.fill = GridBagConstraints.BOTH;
		gbc_scrollAnotacionesR.gridx = 1;
		gbc_scrollAnotacionesR.gridy = 11;
		pnlReservar.add(scrollAnotacionesR, gbc_scrollAnotacionesR);
		
		txtAnotacionesR = new JTextArea();
		txtAnotacionesR.setForeground(Color.WHITE);
		txtAnotacionesR.setBackground(Color.DARK_GRAY);
		scrollAnotacionesR.setViewportView(txtAnotacionesR);
		
		btnCancelarR = new JButton("Cancelar");
		btnCancelarR.addMouseListener(new BtnCancelarRMouseListener());
		btnCancelarR.addActionListener(new BtnCancelarActionListener());
		btnCancelarR.setPreferredSize(new Dimension(75, 33));
		btnCancelarR.setForeground(Color.WHITE);
		btnCancelarR.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarR.setBorder(null);
		btnCancelarR.setBackground(new Color(255, 71, 71));
		GridBagConstraints gbc_btnCancelarR = new GridBagConstraints();
		gbc_btnCancelarR.gridwidth = 2;
		gbc_btnCancelarR.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarR.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelarR.gridx = 1;
		gbc_btnCancelarR.gridy = 17;
		pnlReservar.add(btnCancelarR, gbc_btnCancelarR);
		
		btnGuardarR = new JButton("Reservar");
		btnGuardarR.addMouseListener(new BtnReservarRMouseListener());
		btnGuardarR.addActionListener(new BtnGuardarRActionListener());
		btnGuardarR.setPreferredSize(new Dimension(71, 33));
		btnGuardarR.setForeground(Color.WHITE);
		btnGuardarR.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardarR.setBorder(null);
		btnGuardarR.setBackground(new Color(47, 198, 152));
		GridBagConstraints gbc_btnGuardarR = new GridBagConstraints();
		gbc_btnGuardarR.fill = GridBagConstraints.BOTH;
		gbc_btnGuardarR.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarR.gridx = 3;
		gbc_btnGuardarR.gridy = 17;
		pnlReservar.add(btnGuardarR, gbc_btnGuardarR);
		
		scrollPane = new JScrollPane();
		
//		scrollPane.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrollPane.setBorder(null);
		pnlPrincipalEstancias.add(scrollPane, BorderLayout.CENTER);
		
		pnlListaEstancias = new JPanel();
		pnlListaEstancias.setBorder(null);
		pnlListaEstancias.setBackground(new Color(31,34,40));
		scrollPane.setViewportView(pnlListaEstancias);
		pnlListaEstancias.setLayout(new BoxLayout(pnlListaEstancias, BoxLayout.Y_AXIS));
		
		changeTipo();
		//Ejemplos();
	}

	/*********************************MAIN LISTENERS**********************************/
	
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			limpiarElementosN();
			
			txtNombreN.setText("Nombre...");
			lblFotoN.setIcon(null);
			CardLayout cl = (CardLayout)(pnlDesplegable.getLayout());
			cl.first(pnlDesplegable);
			pnlDesplegable.setVisible(true);
		}
	}
	
	public class BtnVermasActionListener implements ActionListener{
		
		Parcela auxParcela = null;
		Bungalow auxBungalow = null;
		private int id;
		
		public void actionPerformed(ActionEvent arg0) {
			
			setEditingId(getId());
			
			if (getParcela() == null) {
				llenarElementosBungalowE(getBungalow());
			} else {
				llenarElementosParcelaE(getParcela());
				
			}
			
			CardLayout cl = (CardLayout)(pnlDesplegable.getLayout());
			cl.show(pnlDesplegable, "editar");
			
			if (!pnlDesplegable.isVisible()) {
				pnlDesplegable.setVisible(true);
			}
		}
		
		public void crearElementoN() {
			
			boolean disponibilidad = true;
			String razon = "Disponible";
			boolean[] extras = getSelectedButtons();
			switch(cbTipo.getSelectedItem().toString()) {
			
				case "Parcela":
					String categoria = (String) txtOpcExtraN.getItemAt(txtOpcExtraN.getSelectedIndex());
					auxParcela = new Parcela(
							txtNombreN.getText(),
							fileFoto, 
							Double.parseDouble(txtTamanoN.getText()), 
							Double.parseDouble(txtPrecioN.getText()), 
							disponibilidad, 
							razon, 
							txtComentariosN.getText(), 
							extras,
							categoria);
					break;
					
				case "Bungalow":
					String auxCapacidad = (String) txtOpcExtraN.getItemAt(txtOpcExtraN.getSelectedIndex());
					int capacidad = Integer.parseInt(auxCapacidad);
					auxBungalow = new Bungalow(
							txtNombreN.getText(),
							fileFoto, 
							Double.parseDouble(txtTamanoN.getText()), 
							Double.parseDouble(txtPrecioN.getText()), 
							disponibilidad, 
							razon, 
							txtComentariosN.getText(), 
							extras, 
							capacidad);
					break;
			}
		}
		
		public void crearElementoE() {
			
			boolean disponibilidad;
			String razon = (String) cbDisponibilidadE.getItemAt(cbDisponibilidadE.getSelectedIndex());
			boolean[] extras = getSelectedButtons();
			
			if (razon.equals("Disponible")) {
				disponibilidad = true;
			} else {
				disponibilidad = false;
			}
			
			switch(txtTipoE.getText()) {
			
				case "Parcela":
					String categoria = (String) txtOpcExtraE.getItemAt(txtOpcExtraE.getSelectedIndex());
					auxParcela = new Parcela(
							txtNombreE.getText(),
							fileFoto, 
							Double.parseDouble(txtTamanoE.getText()), 
							Double.parseDouble(txtPrecioE.getText()), 
							disponibilidad, 
							razon, 
							txtComentariosE.getText(), 
							extras,
							categoria);
					break;
					
				case "Bungalow":
					String auxCapacidad = (String) txtOpcExtraE.getItemAt(txtOpcExtraE.getSelectedIndex());
					int capacidad = Integer.parseInt(auxCapacidad);
					auxBungalow = new Bungalow(
							txtNombreE.getText(),
							fileFoto, 
							Double.parseDouble(txtTamanoE.getText()), 
							Double.parseDouble(txtPrecioE.getText()), 
							disponibilidad, 
							razon, 
							txtComentariosE.getText(), 
							extras, 
							capacidad);
					break;
			}
		}
		
		public Parcela getParcela() {
			return this.auxParcela;
		}
		
		public Bungalow getBungalow() {
			return this.auxBungalow;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setParcela(Parcela parcela) {
			this.auxParcela = parcela;
		}
		
		public void setBungalow(Bungalow bungalow) {
			this.auxBungalow = bungalow;
		}
	}
	
	public class BtnReservarActionListener implements ActionListener {
		
		private int id;
		
		public void actionPerformed(ActionEvent arg0) {
			
			//int position = identifiers.indexOf(getId());
			
			CardLayout cl = (CardLayout)(pnlDesplegable.getLayout());
			cl.show(pnlDesplegable, "reservar");
			
			if (!pnlDesplegable.isVisible()) {
				pnlDesplegable.setVisible(true);
			}
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
	}
	
	/****************************NUEVA ESTANCIA LISTENERS*****************************/
	
	private class BtnSubirFotoNActionListener implements ActionListener {
		
		private Component frame;
		private File file;
	
		public void actionPerformed(ActionEvent arg0) {
			
			JFileChooser fcAbrir = new JFileChooser();
            int valorDevuelto = fcAbrir.showOpenDialog(frame);
            
            //Resizing the photo
            if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
                file = fcAbrir.getSelectedFile(); 
                setFotoN(file); //Setting the image in the corresponding label
                fileFoto = file; //Saving the path to the file to send it to the Employee panel
            }
		}
	}
	
	private class BtnGuardarNActionListener implements ActionListener {
		private Component frame;
		public void actionPerformed(ActionEvent arg0) {
			
			if(comprobarCamposN()) {
				guardarEstanciaN();
			} else {
				JOptionPane.showMessageDialog(frame, "Hay campos incorrectos", "Custom error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/****************************EDITAR ESTANCIA LISTENERS****************************/
	
	private class BtnSubirFotoEActionListener implements ActionListener {
		
		private Component frame;
		private File file;
	
		public void actionPerformed(ActionEvent arg0) {
			
			JFileChooser fcAbrir = new JFileChooser();
            int valorDevuelto = fcAbrir.showOpenDialog(frame);
            
            //Resizing the photo
            if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
                file = fcAbrir.getSelectedFile(); 
                setFotoE(file); //Setting the image in the corresponding label
                fileFoto = file; //Saving the path to the file to send it to the Employee panel
            }
		}
	}
	
	private class BtnGuardarEActionListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			int position = identifiers.indexOf(getEditingId());
			pnlListaEstancias.remove(pnlListaEstancias.getComponent(position));
			identifiers.remove(position);
			pnlListaEstancias.repaint();
			pnlListaEstancias.revalidate();
			
			guardarEstanciaE();
			
		}
	}
	
	/*************************RESERVAR ESTANCIA LISTENERS*****************************/

	private class BtnGuardarRActionListener implements ActionListener {
		private Component frame;
		public void actionPerformed(ActionEvent e) {
			
			if(comprobarCamposR()) {
				JOptionPane.showMessageDialog(frame, "Esta funcionalidad no se encuentra habilitada", "Custom error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Hay campos incorrectos", "Custom error", JOptionPane.ERROR_MESSAGE);
			}
			
			//int position = identifiers.indexOf(getEditingId());
			//Component estancia = pnlListaEstancias.getComponent(position);
			//identifiers.remove(position);
			//pnlListaEstancias.repaint();
			//pnlListaEstancias.revalidate();
			
			//pnlListaEstancias.add(new panelReserva(globalId));
		}
	}
	
	/******************************CLASES COMPARTIDAS*********************************/
	
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnNuevo.setText("Nuevo");
			pnlDesplegable.setVisible(false);	
		}
	}
	
	private class clearText extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtNombreN.setText("");
		}
	}
	
	private class changeButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeTipo();
		}
	}
	
	private class buttonSelected extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnServiciosSelected = (JButton) e.getSource();
			if (btnServiciosSelected.isEnabled()) {
				btnServiciosSelected.setEnabled(false);
			} else {
				btnServiciosSelected.setEnabled(true);
			}
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
	
	private class BtnReservarRMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnGuardarR.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnGuardarR.setBackground(new Color (47,198,152));
		}
	}
	
	private class BtnCancelarRMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarR.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarR.setBackground(new Color(255,71,71));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	
	private void limpiarElementosN () {
		
		lblFotoN.setIcon(null);
		fileFoto = null;
		txtNombreN.setText(null);
		cbTipo.setSelectedIndex(0);
		txtTamanoN.setText(null);
		txtPrecioN.setText(null);
		txtOpcExtraN.setSelectedIndex(0);
		btnOpcion1N.setEnabled(false);
		btnOpcion2N.setEnabled(false);
		btnOpcion3N.setEnabled(false);
		btnOpcion4N.setEnabled(false);
		btnOpcion5N.setEnabled(false);
		btnOpcion6N.setEnabled(false);
		txtComentariosN.setText(null);
	}

	private void llenarElementosParcelaE (Parcela parcela) {
			
		boolean[] extrasAux = parcela.getExtras();
		fileFoto = parcela.getFoto();
		setFotoE(parcela.getFoto());
		txtNombreE.setText(parcela.getNombre());
		txtTamanoE.setText(Double.toString(parcela.getTamano()));
		txtPrecioE.setText(Double.toString(parcela.getPrecioPorNoche()));
		cbDisponibilidadE.setSelectedItem(parcela.getRazon());
		txtComentariosE.setText(parcela.getDescripcion());
		lblOpcExtraE.setText("Categoría: ");
		changeTipo();
		txtOpcExtraE.setSelectedItem(parcela.getCategoria());
		btnOpcion1E.setEnabled(extrasAux[0]);
		btnOpcion2E.setEnabled(extrasAux[1]);
		btnOpcion3E.setEnabled(extrasAux[2]);
		btnOpcion4E.setEnabled(extrasAux[3]);
		btnOpcion5E.setEnabled(extrasAux[4]);
		btnOpcion6E.setEnabled(extrasAux[5]);
		txtTipoE.setText("Parcela");
		txtOpcExtraE.setSelectedItem(parcela.getCategoria());
	}
	
	private void llenarElementosBungalowE (Bungalow bungalow) {
		
		boolean[] extrasAux = bungalow.getExtras();
		fileFoto = bungalow.getFoto();
		setFotoE(bungalow.getFoto());
		txtNombreE.setText(bungalow.getNombre());
		txtTamanoE.setText(Double.toString(bungalow.getTamano()));
		txtPrecioE.setText(Double.toString(bungalow.getPrecioPorNoche()));
		cbDisponibilidadE.setSelectedItem(bungalow.getRazon());
		txtComentariosE.setText(bungalow.getDescripcion());
		lblOpcExtraE.setText("Aforo: ");
		changeTipo();
		txtOpcExtraE.setSelectedItem(bungalow.getCapacidad());
		btnOpcion1E.setEnabled(extrasAux[0]);
		btnOpcion2E.setEnabled(extrasAux[1]);
		btnOpcion3E.setEnabled(extrasAux[2]);
		btnOpcion4E.setEnabled(extrasAux[3]);
		btnOpcion5E.setEnabled(extrasAux[4]);
		btnOpcion6E.setEnabled(extrasAux[5]);
		txtTipoE.setText("Bungalow");
		txtOpcExtraE.setSelectedItem(String.valueOf(bungalow.getCapacidad()));
	}
	
	private void setFotoN (File file) {
        try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoN.getWidth() -35,
            lblFotoN.getHeight() -35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoN.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void setFotoE (File file) {
        try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoE.getWidth() -35,
            lblFotoE.getHeight() -35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoE.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private boolean comprobarCamposN () {
		if (txtNombreN.getText() == null ||
			fileFoto == null ||
			isDouble(txtTamanoN.getText()) == false ||
			isDouble(txtPrecioN.getText()) == false) {
		return false;}
		return true;
	}
	
	private boolean comprobarCamposR () {
		Date hoy = new Date();
		if (txtNombreR.getText() == null ||
				ftxtTelefonoR.getText() == "+XX - XXX-XX-XX-XX" ||
				dateIniR.getDate() == null ||
				dateFinR.getDate() == null ||
				dateIniR.getDate().compareTo(hoy) <= 0 ||
				dateFinR.getDate().compareTo(dateIniR.getDate()) <= 0) {
			return false;}
			return true;
	}
	
	private boolean[] getSelectedButtons() {
		
		boolean[] selected = new boolean[6];
		JPanel card = null;
		
		//obtenemos informacion de que panel esta visible
		for (Component comp : pnlDesplegable.getComponents()) {
			if (comp.isVisible() == true) {
				card = (JPanel) comp;
			}
		}
		
		//segun el panel seleccionado pilla la informacion correspondiente
		if(card.getName().equals("nuevo")) {
			selected[0] = btnOpcion1N.isEnabled();
			selected[1] = btnOpcion2N.isEnabled();
			selected[2] = btnOpcion3N.isEnabled();
			selected[3] = btnOpcion4N.isEnabled();
			selected[4] = btnOpcion5N.isEnabled();
			selected[5] = btnOpcion6N.isEnabled();
			
		} else if (card.getName().equals("editar")) {
			selected[0] = btnOpcion1E.isEnabled();
			selected[1] = btnOpcion2E.isEnabled();
			selected[2] = btnOpcion3E.isEnabled();
			selected[3] = btnOpcion4E.isEnabled();
			selected[4] = btnOpcion5E.isEnabled();
			selected[5] = btnOpcion6E.isEnabled();
		}
		return selected;
	}
	
	private boolean isDouble(String texto) {
		try {
			Double.parseDouble(texto);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	private void guardarEstanciaN () {
		
		BtnReservarActionListener reservarListener = new BtnReservarActionListener();
		BtnVermasActionListener vermasListener = new BtnVermasActionListener();
		
		vermasListener.crearElementoN();
		
		globalId++;
		identifiers.add(globalId);
		
		reservarListener.setId(globalId);
		vermasListener.setId(globalId);
		 
		pnlListaEstancias.add(new panelEstancia(reservarListener, vermasListener, globalId));
		pnlListaEstancias.repaint();
		pnlListaEstancias.revalidate();
		
		pnlDesplegable.setVisible(false);
		btnNuevo.setText("Nuevo");
	}
	
	private void guardarEstanciaE () {
		
		BtnReservarActionListener reservarListener = new BtnReservarActionListener();
		BtnVermasActionListener vermasListener = new BtnVermasActionListener();
		
		vermasListener.crearElementoE();
		
		globalId++;
		identifiers.add(globalId);
	
		reservarListener.setId(globalId);
		vermasListener.setId(globalId);
		 
		pnlListaEstancias.add(new panelEstancia(reservarListener, vermasListener, globalId));
		pnlListaEstancias.repaint();
		pnlListaEstancias.revalidate();
		
		pnlDesplegable.setVisible(false);
	}

	public int getEditingId() {
		return this.editingId;
	}
	
	public void setEditingId(int id) {
		this.editingId = id;
	}
	
	private void changeTipo() {
		
		JPanel card = null;
		String tipo = "";
		
		//obtenemos informacion de que panel esta visible
		for (Component comp : pnlDesplegable.getComponents()) {
			if (comp.isVisible() == true) {
				card = (JPanel) comp;
			}
		}
		
		//segun el panel seleccionado pilla la informacion correspondiente
		if(card.getName().equals("nuevo")) {
			tipo = (String) cbTipo.getItemAt(cbTipo.getSelectedIndex());
		} else if (card.getName().equals("editar")) {
			tipo = txtTipoE.getText();
		}
		
		//segun el tipo, modificamos botones
		if (tipo == "Parcela" && card.getName().equals("nuevo")) {
			
			lblOpcExtraN.setText("Categoría");
			txtOpcExtraN.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Caravana", "Deluxe"}));
			txtOpcExtraN.setVisible(true);
			
			btnOpcion1N.setText("No Fumar"); btnOpcion2N.setText("Parking");
			btnOpcion3N.setText("Wi Fi"); btnOpcion4N.setText("Spa");
			btnOpcion5N.setText("Desayuno"); btnOpcion6N.setText("Animales");
			
			btnOpcion1N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/noFumar.png")));
			btnOpcion2N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/parking.png")));
			btnOpcion3N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/wifi.png")));
			btnOpcion4N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/spa.png")));
			btnOpcion5N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/desayuno.png")));
			btnOpcion6N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/mascotas.png")));
			
		} else if (tipo == "Bungalow" && card.getName().equals("editar")) {
			
			lblOpcExtraE.setText("Aforo");
			txtOpcExtraE.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
			txtOpcExtraE.setVisible(true);
			
			btnOpcion1E.setText("Lavadora"); btnOpcion2E.setText("Toallas");
			btnOpcion3E.setText("Botones"); btnOpcion4E.setText("Transporte");
			btnOpcion5E.setText("Piscina"); btnOpcion6E.setText("Aire");
			
			btnOpcion1E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/lavadora.png")));
			btnOpcion2E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/toalla.png")));
			btnOpcion3E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/botones.png")));
			btnOpcion4E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/transporte.png")));
			btnOpcion5E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/piscina.png")));
			btnOpcion6E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/aire.png")));
			
		} else if (tipo == "Bungalow" && card.getName().equals("nuevo")) {
			
			lblOpcExtraN.setText("Aforo");
			txtOpcExtraN.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
			txtOpcExtraN.setVisible(true);
			
			btnOpcion1N.setText("Lavadora"); btnOpcion2N.setText("Toallas");
			btnOpcion3N.setText("Botones"); btnOpcion4N.setText("Transporte");
			btnOpcion5N.setText("Piscina"); btnOpcion6N.setText("Aire");
			
			btnOpcion1N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/lavadora.png")));
			btnOpcion2N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/toalla.png")));
			btnOpcion3N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/botones.png")));
			btnOpcion4N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/transporte.png")));
			btnOpcion5N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/piscina.png")));
			btnOpcion6N.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/aire.png")));
			
		} else {
			
			lblOpcExtraE.setText("Categoría");
			txtOpcExtraE.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Caravana", "Deluxe"}));
			txtOpcExtraE.setVisible(true);
			
			btnOpcion1E.setText("No Fumar"); btnOpcion2E.setText("Parking");
			btnOpcion3E.setText("Wi Fi"); btnOpcion4E.setText("Spa");
			btnOpcion5E.setText("Desayuno"); btnOpcion6E.setText("Animales");
			
			btnOpcion1E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/noFumar.png")));
			btnOpcion2E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/parking.png")));
			btnOpcion3E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/wifi.png")));
			btnOpcion4E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/spa.png")));
			btnOpcion5E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/desayuno.png")));
			btnOpcion6E.setIcon(new ImageIcon(panelEstancias.class.getResource("/presentacion/recursos/mascotas.png")));
		}
		
	}
	
	private void Ejemplos() {
		
		generateExampleParcela("Casoplón del coletas",
								new File(this.getClass().getResource("/presentacion/recursos/estancia.png").getFile()),
								69, 
								1000,
								true,
								"Disponible",
								"Sin comentarios",
								new boolean[] {true, true, true, true, true, true},
								"Deluxe");
		
		generateExampleBungalow("Kawa-Bungalow",
				new File(this.getClass().getResource("/presentacion/recursos/estancia.png").getFile()),
				142, 
				1250,
				false,
				"Reservado",
				"Sin comentarios",
				new boolean[] {true, true, true, true, false, false},
				5);
		
		generateExampleParcela("Barata-Vana",
				new File(this.getClass().getResource("/presentacion/recursos/estancia.png").getFile()),
				80, 
				50.5,
				false,
				"En Reparación",
				"Sin comentarios",
				new boolean[] {true, false, true, true, true, false},
				"Caravana");
		
	}
	
	private void generateExampleParcela(String nombre,File foto, double tamano, double precio, boolean disponibilidad, String razon, String comentario, boolean[] extras, String categoria) {

		BtnVermasActionListener vermasListener = new BtnVermasActionListener();
		BtnReservarActionListener reservarListener = new BtnReservarActionListener();
		
		Parcela auxParcela = new Parcela(nombre, foto, tamano, precio, disponibilidad, razon, comentario, extras, categoria);
		
		vermasListener.setParcela(auxParcela);
		
		globalId++;
		identifiers.add(globalId);
	
		reservarListener.setId(globalId);
		vermasListener.setId(globalId);
		 
		pnlListaEstancias.add(new panelEstancia(reservarListener, vermasListener, globalId));
		pnlListaEstancias.repaint();
		pnlListaEstancias.revalidate();
	}
	
	private void generateExampleBungalow(String nombre,File foto, double tamano, double precio, boolean disponibilidad, String razon, String comentario, boolean[] extras, int capacidad) {
		
		BtnVermasActionListener vermasListener = new BtnVermasActionListener();
		BtnReservarActionListener reservarListener = new BtnReservarActionListener();
		
		Bungalow auxBungalow = new Bungalow(nombre, foto, tamano, precio, disponibilidad, razon, comentario, extras, capacidad);
		
		vermasListener.setBungalow(auxBungalow);
		
		globalId++;
		identifiers.add(globalId);
	
		reservarListener.setId(globalId);
		vermasListener.setId(globalId);
		 
		pnlListaEstancias.add(new panelEstancia(reservarListener, vermasListener, globalId));
		pnlListaEstancias.repaint();
		pnlListaEstancias.revalidate();
	}
}