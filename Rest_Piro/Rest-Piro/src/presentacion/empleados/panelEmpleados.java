package presentacion.empleados;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

import dominio.Empleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "rawtypes", "unchecked"})
public class panelEmpleados extends JPanel {
	private JPanel pnlBarraSuperior;
	private JPanel pnlBotonesBarraSuperior;
	private JButton btnNuevoEmpleado;
	private JPanel pnlPrincipalEmpleados;
	private JPanel pnlDesplegableEmpleado;
	private JScrollPane scrollPane;
	private JPanel pnlListaEmpleados;
	private JPanel pnlNuevoEmpleado;
	private JPanel pnlEditarEmpleado;
	private JLabel lblFotoEmpleadoN;
	private JButton btnSubirFotoEmpleadoN;
	private JLabel lblNombreN;
	private JLabel lblApellidosN;
	private JLabel lblTelefonoN;
	private JLabel lblCorreoN;
	private JLabel lblFormacionN;
	private JLabel lblPrimerIdiomaN;
	private JButton btnGuardarN;
	private JLabel lblHorarioN;
	private JLabel lblSegundoIdiomaN;
	private JLabel lblTercerIdiomaN;
	private JTextField txtNombreN;
	private JTextField txtApellidosN;
	private JTextField txtTelefonoN;
	private JTextField txtCorreoN;
	private JComboBox comboFormacionN;
	private JComboBox comboHorarioN;
	private JComboBox comboPrimerIdiomaN;
	private JComboBox comboSegundoIdiomaN;
	private JComboBox comboTercerIdiomaN;
	private JLabel lblTituloEmpleadoN;
	private JLabel lblTituloE;
	private JLabel lblFotoEmpleadoE;
	private JButton btnSubirFotoEmpleadoE;
	private JLabel lblNombreE;
	private JTextField txtNombreE;
	private JLabel lblApellidosE;
	private JTextField txtApellidosE;
	private JLabel lblTelefonoE;
	private JTextField txtTelefonoE;
	private JLabel lblCorreoE;
	private JTextField txtCorreoE;
	private JLabel lblFormacionE;
	private JComboBox comboFormacionE;
	private JLabel lblHorarioE;
	private JComboBox comboHorarioE;
	private JLabel lblPrimerIdiomaE;
	private JComboBox comboPrimerIdiomaE;
	private JLabel lblSegundoIdiomaE;
	private JComboBox comboSegundoIdiomaE;
	private JLabel lblTercerIdiomaE;
	private JComboBox comboTercerIdiomaE;
	private JButton btnGuardarE;
	private JButton btnCancelarN;
	private JButton btnCancelarE;
	
	/***********************************PARAMETERS************************************/
	
	private File fileFotoNuevoEmpleado;
	private JLabel lblTitulo;
	private Vector<Integer> identifiers = new Vector<Integer>();
	private int globalId = -1;
	private int editingId = -1;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelEmpleados() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(20, 0));
		
		pnlBarraSuperior = new JPanel();
		pnlBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.setBorder(null);
		add(pnlBarraSuperior, BorderLayout.NORTH);
		pnlBarraSuperior.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblTitulo = new JLabel("    EMPLEADOS");
		lblTitulo.setBorder(new EmptyBorder(30, 0, 40, 0));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 46));
		pnlBarraSuperior.add(lblTitulo);
		
		pnlBotonesBarraSuperior = new JPanel();
		pnlBotonesBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.add(pnlBotonesBarraSuperior);
		GridBagLayout gbl_pnlBotonesBarraSuperior = new GridBagLayout();
		gbl_pnlBotonesBarraSuperior.columnWidths = new int[] {30, 80, 50, 0};
		gbl_pnlBotonesBarraSuperior.rowHeights = new int[] {0, 15, 0};
		gbl_pnlBotonesBarraSuperior.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotonesBarraSuperior.rowWeights = new double[]{1.0, 1.0, 1.0};
		pnlBotonesBarraSuperior.setLayout(gbl_pnlBotonesBarraSuperior);
		
		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.setBorder(null);
		btnNuevoEmpleado.setBackground(new Color (47,198,152));
		btnNuevoEmpleado.setForeground(Color.WHITE);
		btnNuevoEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNuevoEmpleado.addMouseListener(new BtnNuevoEmpleadoMouseListener());
		btnNuevoEmpleado.addActionListener(new BtnNuevoEmpleadoActionListener());
		GridBagConstraints gbc_btnNuevoEmpleado = new GridBagConstraints();
		gbc_btnNuevoEmpleado.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoEmpleado.gridx = 1;
		gbc_btnNuevoEmpleado.gridy = 1;
		pnlBotonesBarraSuperior.add(btnNuevoEmpleado, gbc_btnNuevoEmpleado);
		
		pnlPrincipalEmpleados = new JPanel();
		pnlPrincipalEmpleados.setBackground(new Color(31,34,40));
		add(pnlPrincipalEmpleados, BorderLayout.CENTER);
		pnlPrincipalEmpleados.setLayout(new BorderLayout(0, 0));
		
		pnlDesplegableEmpleado = new JPanel();
		pnlDesplegableEmpleado.setBorder(null);
		pnlDesplegableEmpleado.setVisible(false);
		pnlPrincipalEmpleados.add(pnlDesplegableEmpleado, BorderLayout.EAST);
		pnlDesplegableEmpleado.setLayout(new CardLayout(0, 0));
		
		pnlNuevoEmpleado = new JPanel();
		pnlNuevoEmpleado.setBackground(new Color(42,46,49));
		pnlNuevoEmpleado.setAlignmentY(Component.TOP_ALIGNMENT);
		pnlNuevoEmpleado.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlNuevoEmpleado.setBorder(null);
		pnlDesplegableEmpleado.add(pnlNuevoEmpleado, "Nuevo Empleado");
		GridBagLayout gbl_pnlNuevoEmpleado = new GridBagLayout();
		gbl_pnlNuevoEmpleado.columnWidths = new int[] {70, 70, 70, 70, 70, 70, 70};
		gbl_pnlNuevoEmpleado.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_pnlNuevoEmpleado.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
		gbl_pnlNuevoEmpleado.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		pnlNuevoEmpleado.setLayout(gbl_pnlNuevoEmpleado);
		
		lblTituloEmpleadoN = new JLabel("Nuevo Empleado");
		lblTituloEmpleadoN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEmpleadoN.setOpaque(true);
		lblTituloEmpleadoN.setBackground(new Color(42,46,49));
		lblTituloEmpleadoN.setForeground(Color.WHITE);
		lblTituloEmpleadoN.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lblTituloEmpleadoN = new GridBagConstraints();
		gbc_lblTituloEmpleadoN.fill = GridBagConstraints.BOTH;
		gbc_lblTituloEmpleadoN.gridwidth = 7;
		gbc_lblTituloEmpleadoN.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloEmpleadoN.gridx = 0;
		gbc_lblTituloEmpleadoN.gridy = 0;
		pnlNuevoEmpleado.add(lblTituloEmpleadoN, gbc_lblTituloEmpleadoN);
		
		lblFotoEmpleadoN = new JLabel("");
		lblFotoEmpleadoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoEmpleadoN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoEmpleadoN = new GridBagConstraints();
		gbc_lblFotoEmpleadoN.fill = GridBagConstraints.BOTH;
		gbc_lblFotoEmpleadoN.gridwidth = 3;
		gbc_lblFotoEmpleadoN.gridheight = 3;
		gbc_lblFotoEmpleadoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoEmpleadoN.gridx = 2;
		gbc_lblFotoEmpleadoN.gridy = 1;
		pnlNuevoEmpleado.add(lblFotoEmpleadoN, gbc_lblFotoEmpleadoN);
		
		btnSubirFotoEmpleadoN = new JButton("Subir foto...");
		btnSubirFotoEmpleadoN.addMouseListener(new BtnSubirFotoEmpleadoNMouseListener());
		btnSubirFotoEmpleadoN.setPreferredSize(new Dimension(91, 28));
		btnSubirFotoEmpleadoN.setBackground(new Color(0,120,210));
		btnSubirFotoEmpleadoN.setForeground(Color.WHITE);
		btnSubirFotoEmpleadoN.setBorder(null);
		btnSubirFotoEmpleadoN.addActionListener(new BtnSubirFotoEmpleadoNActionListener());
		btnSubirFotoEmpleadoN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoEmpleadoN = new GridBagConstraints();
		gbc_btnSubirFotoEmpleadoN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubirFotoEmpleadoN.gridwidth = 3;
		gbc_btnSubirFotoEmpleadoN.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoEmpleadoN.gridx = 2;
		gbc_btnSubirFotoEmpleadoN.gridy = 4;
		pnlNuevoEmpleado.add(btnSubirFotoEmpleadoN, gbc_btnSubirFotoEmpleadoN);
		
		lblNombreN = new JLabel("Nombre:");
		lblNombreN.setForeground(Color.WHITE);
		lblNombreN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombreN = new GridBagConstraints();
		gbc_lblNombreN.gridwidth = 2;
		gbc_lblNombreN.anchor = GridBagConstraints.EAST;
		gbc_lblNombreN.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreN.gridx = 0;
		gbc_lblNombreN.gridy = 5;
		pnlNuevoEmpleado.add(lblNombreN, gbc_lblNombreN);
		
		txtNombreN = new JTextField();
		txtNombreN.setCaretColor(Color.WHITE);
		txtNombreN.setForeground(Color.WHITE);
		txtNombreN.setBackground(Color.DARK_GRAY);
		txtNombreN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtNombreN = new GridBagConstraints();
		gbc_txtNombreN.gridwidth = 3;
		gbc_txtNombreN.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreN.gridx = 2;
		gbc_txtNombreN.gridy = 5;
		pnlNuevoEmpleado.add(txtNombreN, gbc_txtNombreN);
		txtNombreN.setColumns(10);
		
		lblApellidosN = new JLabel("Apellidos:");
		lblApellidosN.setForeground(Color.WHITE);
		lblApellidosN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblApellidosN = new GridBagConstraints();
		gbc_lblApellidosN.gridwidth = 2;
		gbc_lblApellidosN.anchor = GridBagConstraints.EAST;
		gbc_lblApellidosN.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidosN.gridx = 0;
		gbc_lblApellidosN.gridy = 6;
		pnlNuevoEmpleado.add(lblApellidosN, gbc_lblApellidosN);
		
		txtApellidosN = new JTextField();
		txtApellidosN.setCaretColor(Color.WHITE);
		txtApellidosN.setForeground(Color.WHITE);
		txtApellidosN.setBackground(Color.DARK_GRAY);
		txtApellidosN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtApellidosN = new GridBagConstraints();
		gbc_txtApellidosN.gridwidth = 3;
		gbc_txtApellidosN.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidosN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidosN.gridx = 2;
		gbc_txtApellidosN.gridy = 6;
		pnlNuevoEmpleado.add(txtApellidosN, gbc_txtApellidosN);
		txtApellidosN.setColumns(10);
		
		lblCorreoN = new JLabel("E-Mail:");
		lblCorreoN.setForeground(Color.WHITE);
		lblCorreoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCorreoN = new GridBagConstraints();
		gbc_lblCorreoN.gridwidth = 2;
		gbc_lblCorreoN.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoN.gridx = 0;
		gbc_lblCorreoN.gridy = 7;
		pnlNuevoEmpleado.add(lblCorreoN, gbc_lblCorreoN);
		
		txtCorreoN = new JTextField();
		txtCorreoN.setCaretColor(Color.WHITE);
		txtCorreoN.setForeground(Color.WHITE);
		txtCorreoN.setBackground(Color.DARK_GRAY);
		txtCorreoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtCorreoN = new GridBagConstraints();
		gbc_txtCorreoN.gridwidth = 3;
		gbc_txtCorreoN.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreoN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreoN.gridx = 2;
		gbc_txtCorreoN.gridy = 7;
		pnlNuevoEmpleado.add(txtCorreoN, gbc_txtCorreoN);
		txtCorreoN.setColumns(10);
		
		lblTelefonoN = new JLabel("Teléfono:");
		lblTelefonoN.setForeground(Color.WHITE);
		lblTelefonoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelefonoN = new GridBagConstraints();
		gbc_lblTelefonoN.gridwidth = 2;
		gbc_lblTelefonoN.anchor = GridBagConstraints.EAST;
		gbc_lblTelefonoN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonoN.gridx = 0;
		gbc_lblTelefonoN.gridy = 8;
		pnlNuevoEmpleado.add(lblTelefonoN, gbc_lblTelefonoN);
		
		txtTelefonoN = new JTextField();
		txtTelefonoN.setCaretColor(Color.WHITE);
		txtTelefonoN.setForeground(Color.WHITE);
		txtTelefonoN.setBackground(Color.DARK_GRAY);
		txtTelefonoN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_txtTelefonoN = new GridBagConstraints();
		gbc_txtTelefonoN.gridwidth = 2;
		gbc_txtTelefonoN.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefonoN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefonoN.gridx = 2;
		gbc_txtTelefonoN.gridy = 8;
		pnlNuevoEmpleado.add(txtTelefonoN, gbc_txtTelefonoN);
		txtTelefonoN.setColumns(10);
		
		lblFormacionN = new JLabel("Formación:");
		lblFormacionN.setForeground(Color.WHITE);
		lblFormacionN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFormacionN = new GridBagConstraints();
		gbc_lblFormacionN.gridwidth = 2;
		gbc_lblFormacionN.anchor = GridBagConstraints.EAST;
		gbc_lblFormacionN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacionN.gridx = 0;
		gbc_lblFormacionN.gridy = 9;
		pnlNuevoEmpleado.add(lblFormacionN, gbc_lblFormacionN);
		
		comboFormacionN = new JComboBox();
		comboFormacionN.setForeground(Color.WHITE);
		comboFormacionN.setBackground(Color.DARK_GRAY);
		comboFormacionN.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboFormacionN.setModel(new DefaultComboBoxModel(new String[] {"Educación Infantil", "Educación Primaria", "E.S.O.", "F. P.", "Universitaria"}));
		GridBagConstraints gbc_comboFormacionN = new GridBagConstraints();
		gbc_comboFormacionN.gridwidth = 2;
		gbc_comboFormacionN.insets = new Insets(0, 0, 5, 5);
		gbc_comboFormacionN.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboFormacionN.gridx = 2;
		gbc_comboFormacionN.gridy = 9;
		pnlNuevoEmpleado.add(comboFormacionN, gbc_comboFormacionN);
		
		lblHorarioN = new JLabel("Horario:");
		lblHorarioN.setForeground(Color.WHITE);
		lblHorarioN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHorarioN = new GridBagConstraints();
		gbc_lblHorarioN.gridwidth = 2;
		gbc_lblHorarioN.anchor = GridBagConstraints.EAST;
		gbc_lblHorarioN.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarioN.gridx = 0;
		gbc_lblHorarioN.gridy = 10;
		pnlNuevoEmpleado.add(lblHorarioN, gbc_lblHorarioN);
		
		comboHorarioN = new JComboBox();
		comboHorarioN.setForeground(Color.WHITE);
		comboHorarioN.setBackground(Color.DARK_GRAY);
		comboHorarioN.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboHorarioN.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde", "Noche"}));
		GridBagConstraints gbc_comboHorarioN = new GridBagConstraints();
		gbc_comboHorarioN.gridwidth = 2;
		gbc_comboHorarioN.insets = new Insets(0, 0, 5, 5);
		gbc_comboHorarioN.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboHorarioN.gridx = 2;
		gbc_comboHorarioN.gridy = 10;
		pnlNuevoEmpleado.add(comboHorarioN, gbc_comboHorarioN);
		
		lblPrimerIdiomaN = new JLabel("1º Idioma:");
		lblPrimerIdiomaN.setForeground(Color.WHITE);
		lblPrimerIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrimerIdiomaN = new GridBagConstraints();
		gbc_lblPrimerIdiomaN.gridwidth = 2;
		gbc_lblPrimerIdiomaN.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerIdiomaN.gridx = 0;
		gbc_lblPrimerIdiomaN.gridy = 11;
		pnlNuevoEmpleado.add(lblPrimerIdiomaN, gbc_lblPrimerIdiomaN);
		
		comboPrimerIdiomaN = new JComboBox();
		comboPrimerIdiomaN.setForeground(Color.WHITE);
		comboPrimerIdiomaN.setBackground(Color.DARK_GRAY);
		comboPrimerIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboPrimerIdiomaN.setModel(new DefaultComboBoxModel(new String[] {"Alemán", "Árabe", "Chino", "Español", "Francés", "Hindi", "Inglés", "Italiano", "Japonés", "Portugués", "Ruso"}));
		GridBagConstraints gbc_comboPrimerIdiomaN = new GridBagConstraints();
		gbc_comboPrimerIdiomaN.gridwidth = 2;
		gbc_comboPrimerIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_comboPrimerIdiomaN.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPrimerIdiomaN.gridx = 2;
		gbc_comboPrimerIdiomaN.gridy = 11;
		pnlNuevoEmpleado.add(comboPrimerIdiomaN, gbc_comboPrimerIdiomaN);
		
		lblSegundoIdiomaN = new JLabel("2º Idioma:");
		lblSegundoIdiomaN.setForeground(Color.WHITE);
		lblSegundoIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSegundoIdiomaN = new GridBagConstraints();
		gbc_lblSegundoIdiomaN.gridwidth = 2;
		gbc_lblSegundoIdiomaN.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoIdiomaN.gridx = 0;
		gbc_lblSegundoIdiomaN.gridy = 12;
		pnlNuevoEmpleado.add(lblSegundoIdiomaN, gbc_lblSegundoIdiomaN);
		
		comboSegundoIdiomaN = new JComboBox();
		comboSegundoIdiomaN.setForeground(Color.WHITE);
		comboSegundoIdiomaN.setBackground(Color.DARK_GRAY);
		comboSegundoIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboSegundoIdiomaN.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Alemán", "Árabe", "Chino", "Español", "Francés", "Hindi", "Inglés", "Italiano", "Japonés", "Portugués", "Ruso"}));
		GridBagConstraints gbc_comboSegundoIdiomaN = new GridBagConstraints();
		gbc_comboSegundoIdiomaN.gridwidth = 2;
		gbc_comboSegundoIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_comboSegundoIdiomaN.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSegundoIdiomaN.gridx = 2;
		gbc_comboSegundoIdiomaN.gridy = 12;
		pnlNuevoEmpleado.add(comboSegundoIdiomaN, gbc_comboSegundoIdiomaN);
		
		lblTercerIdiomaN = new JLabel("3º Iidoma:");
		lblTercerIdiomaN.setForeground(Color.WHITE);
		lblTercerIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTercerIdiomaN = new GridBagConstraints();
		gbc_lblTercerIdiomaN.gridwidth = 2;
		gbc_lblTercerIdiomaN.anchor = GridBagConstraints.EAST;
		gbc_lblTercerIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTercerIdiomaN.gridx = 0;
		gbc_lblTercerIdiomaN.gridy = 13;
		pnlNuevoEmpleado.add(lblTercerIdiomaN, gbc_lblTercerIdiomaN);
		
		comboTercerIdiomaN = new JComboBox();
		comboTercerIdiomaN.setForeground(Color.WHITE);
		comboTercerIdiomaN.setBackground(Color.DARK_GRAY);
		comboTercerIdiomaN.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboTercerIdiomaN.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Alemán", "Árabe", "Chino", "Español", "Francés", "Hindi", "Inglés", "Italiano", "Japonés", "Portugués", "Ruso"}));
		GridBagConstraints gbc_comboTercerIdiomaN = new GridBagConstraints();
		gbc_comboTercerIdiomaN.gridwidth = 2;
		gbc_comboTercerIdiomaN.insets = new Insets(0, 0, 5, 5);
		gbc_comboTercerIdiomaN.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTercerIdiomaN.gridx = 2;
		gbc_comboTercerIdiomaN.gridy = 13;
		pnlNuevoEmpleado.add(comboTercerIdiomaN, gbc_comboTercerIdiomaN);
		
		btnGuardarN = new JButton("Guardar");
		btnGuardarN.addMouseListener(new BtnGuardarNMouseListener());
		btnGuardarN.setPreferredSize(new Dimension(71, 33));
		btnGuardarN.setForeground(Color.WHITE);
		btnGuardarN.setBorder(null);
		btnGuardarN.setBackground(new Color(47,198,152));
		btnGuardarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardarN.addActionListener(new BtnGuardarNActionListener());
		
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
		gbc_btnCancelarN.gridwidth = 2;
		gbc_btnCancelarN.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarN.gridx = 2;
		gbc_btnCancelarN.gridy = 15;
		pnlNuevoEmpleado.add(btnCancelarN, gbc_btnCancelarN);
		btnGuardarN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarN = new GridBagConstraints();
		gbc_btnGuardarN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarN.gridwidth = 2;
		gbc_btnGuardarN.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarN.gridx = 4;
		gbc_btnGuardarN.gridy = 15;
		pnlNuevoEmpleado.add(btnGuardarN, gbc_btnGuardarN);
		
		pnlEditarEmpleado = new JPanel();
		pnlEditarEmpleado.setForeground(Color.WHITE);
		pnlEditarEmpleado.setBackground(new Color(42,46,49));
		pnlDesplegableEmpleado.add(pnlEditarEmpleado, "Editar Empleado");
		GridBagLayout gbl_pnlEditarEmpleado = new GridBagLayout();
		gbl_pnlEditarEmpleado.columnWidths = new int[] {70, 70, 70, 70, 70, 70, 70};
		gbl_pnlEditarEmpleado.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_pnlEditarEmpleado.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
		gbl_pnlEditarEmpleado.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		pnlEditarEmpleado.setLayout(gbl_pnlEditarEmpleado);
		
		lblTituloE = new JLabel("Editar Empleado");
		lblTituloE.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloE.setForeground(Color.WHITE);
		lblTituloE.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloE.setBorder(null);
		GridBagConstraints gbc_lblTituloE = new GridBagConstraints();
		gbc_lblTituloE.fill = GridBagConstraints.BOTH;
		gbc_lblTituloE.gridwidth = 7;
		gbc_lblTituloE.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloE.gridx = 0;
		gbc_lblTituloE.gridy = 0;
		pnlEditarEmpleado.add(lblTituloE, gbc_lblTituloE);
		
		lblFotoEmpleadoE = new JLabel("");
		lblFotoEmpleadoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoEmpleadoE.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoEmpleadoE = new GridBagConstraints();
		gbc_lblFotoEmpleadoE.fill = GridBagConstraints.BOTH;
		gbc_lblFotoEmpleadoE.gridheight = 3;
		gbc_lblFotoEmpleadoE.gridwidth = 3;
		gbc_lblFotoEmpleadoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoEmpleadoE.gridx = 2;
		gbc_lblFotoEmpleadoE.gridy = 1;
		pnlEditarEmpleado.add(lblFotoEmpleadoE, gbc_lblFotoEmpleadoE);
		
		btnSubirFotoEmpleadoE = new JButton("Cambiar foto...");
		btnSubirFotoEmpleadoE.addMouseListener(new BtnSubirFotoEmpleadoEMouseListener());
		btnSubirFotoEmpleadoE.setPreferredSize(new Dimension(91, 28));
		btnSubirFotoEmpleadoE.setBackground(new Color(0,120,210));
		btnSubirFotoEmpleadoE.setForeground(Color.WHITE);
		btnSubirFotoEmpleadoE.setBorder(null);
		btnSubirFotoEmpleadoE.addActionListener(new BtnSubirFotoEmpleadoEActionListener());
		btnSubirFotoEmpleadoE.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoEmpleadoE = new GridBagConstraints();
		gbc_btnSubirFotoEmpleadoE.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubirFotoEmpleadoE.gridwidth = 3;
		gbc_btnSubirFotoEmpleadoE.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoEmpleadoE.gridx = 2;
		gbc_btnSubirFotoEmpleadoE.gridy = 4;
		pnlEditarEmpleado.add(btnSubirFotoEmpleadoE, gbc_btnSubirFotoEmpleadoE);
		
		lblNombreE = new JLabel("Nombre:");
		lblNombreE.setForeground(Color.WHITE);
		lblNombreE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombreE = new GridBagConstraints();
		gbc_lblNombreE.gridwidth = 2;
		gbc_lblNombreE.anchor = GridBagConstraints.EAST;
		gbc_lblNombreE.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreE.gridx = 0;
		gbc_lblNombreE.gridy = 5;
		pnlEditarEmpleado.add(lblNombreE, gbc_lblNombreE);
		
		txtNombreE = new JTextField();
		txtNombreE.setCaretColor(Color.WHITE);
		txtNombreE.setForeground(Color.WHITE);
		txtNombreE.setBackground(Color.DARK_GRAY);
		txtNombreE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombreE.setColumns(10);
		GridBagConstraints gbc_txtNombreE = new GridBagConstraints();
		gbc_txtNombreE.gridwidth = 3;
		gbc_txtNombreE.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreE.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreE.gridx = 2;
		gbc_txtNombreE.gridy = 5;
		pnlEditarEmpleado.add(txtNombreE, gbc_txtNombreE);
		
		lblApellidosE = new JLabel("Apellidos:");
		lblApellidosE.setForeground(Color.WHITE);
		lblApellidosE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblApellidosE = new GridBagConstraints();
		gbc_lblApellidosE.gridwidth = 2;
		gbc_lblApellidosE.anchor = GridBagConstraints.EAST;
		gbc_lblApellidosE.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidosE.gridx = 0;
		gbc_lblApellidosE.gridy = 6;
		pnlEditarEmpleado.add(lblApellidosE, gbc_lblApellidosE);
		
		txtApellidosE = new JTextField();
		txtApellidosE.setCaretColor(Color.WHITE);
		txtApellidosE.setForeground(Color.WHITE);
		txtApellidosE.setBackground(Color.DARK_GRAY);
		txtApellidosE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtApellidosE.setColumns(10);
		GridBagConstraints gbc_txtApellidosE = new GridBagConstraints();
		gbc_txtApellidosE.gridwidth = 3;
		gbc_txtApellidosE.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidosE.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidosE.gridx = 2;
		gbc_txtApellidosE.gridy = 6;
		pnlEditarEmpleado.add(txtApellidosE, gbc_txtApellidosE);
		
		lblCorreoE = new JLabel("E-Mail:");
		lblCorreoE.setForeground(Color.WHITE);
		lblCorreoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCorreoE = new GridBagConstraints();
		gbc_lblCorreoE.gridwidth = 2;
		gbc_lblCorreoE.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoE.gridx = 0;
		gbc_lblCorreoE.gridy = 7;
		pnlEditarEmpleado.add(lblCorreoE, gbc_lblCorreoE);
		
		txtCorreoE = new JTextField();
		txtCorreoE.setCaretColor(Color.WHITE);
		txtCorreoE.setForeground(Color.WHITE);
		txtCorreoE.setBackground(Color.DARK_GRAY);
		txtCorreoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCorreoE.setColumns(10);
		GridBagConstraints gbc_txtCorreoE = new GridBagConstraints();
		gbc_txtCorreoE.gridwidth = 3;
		gbc_txtCorreoE.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreoE.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreoE.gridx = 2;
		gbc_txtCorreoE.gridy = 7;
		pnlEditarEmpleado.add(txtCorreoE, gbc_txtCorreoE);
		
		lblTelefonoE = new JLabel("Teléfono:");
		lblTelefonoE.setForeground(Color.WHITE);
		lblTelefonoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelefonoE = new GridBagConstraints();
		gbc_lblTelefonoE.gridwidth = 2;
		gbc_lblTelefonoE.anchor = GridBagConstraints.EAST;
		gbc_lblTelefonoE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonoE.gridx = 0;
		gbc_lblTelefonoE.gridy = 8;
		pnlEditarEmpleado.add(lblTelefonoE, gbc_lblTelefonoE);
		
		txtTelefonoE = new JTextField();
		txtTelefonoE.setCaretColor(Color.WHITE);
		txtTelefonoE.setForeground(Color.WHITE);
		txtTelefonoE.setBackground(Color.DARK_GRAY);
		txtTelefonoE.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtTelefonoE.setColumns(10);
		GridBagConstraints gbc_txtTelefonoE = new GridBagConstraints();
		gbc_txtTelefonoE.gridwidth = 2;
		gbc_txtTelefonoE.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefonoE.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefonoE.gridx = 2;
		gbc_txtTelefonoE.gridy = 8;
		pnlEditarEmpleado.add(txtTelefonoE, gbc_txtTelefonoE);
		
		lblFormacionE = new JLabel("Formación:");
		lblFormacionE.setForeground(Color.WHITE);
		lblFormacionE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFormacionE = new GridBagConstraints();
		gbc_lblFormacionE.gridwidth = 2;
		gbc_lblFormacionE.anchor = GridBagConstraints.EAST;
		gbc_lblFormacionE.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacionE.gridx = 0;
		gbc_lblFormacionE.gridy = 9;
		pnlEditarEmpleado.add(lblFormacionE, gbc_lblFormacionE);
		
		comboFormacionE = new JComboBox();
		comboFormacionE.setForeground(Color.WHITE);
		comboFormacionE.setBackground(Color.DARK_GRAY);
		comboFormacionE.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboFormacionE.setModel(new DefaultComboBoxModel(new String[] {"Educación Infantil", "Educación Primaria", "E.S.O.", "F. P.", "Universitaria"}));
		GridBagConstraints gbc_comboFormacionE = new GridBagConstraints();
		gbc_comboFormacionE.gridwidth = 2;
		gbc_comboFormacionE.insets = new Insets(0, 0, 5, 5);
		gbc_comboFormacionE.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboFormacionE.gridx = 2;
		gbc_comboFormacionE.gridy = 9;
		pnlEditarEmpleado.add(comboFormacionE, gbc_comboFormacionE);
		
		lblHorarioE = new JLabel("Horario:");
		lblHorarioE.setForeground(Color.WHITE);
		lblHorarioE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHorarioE = new GridBagConstraints();
		gbc_lblHorarioE.gridwidth = 2;
		gbc_lblHorarioE.anchor = GridBagConstraints.EAST;
		gbc_lblHorarioE.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarioE.gridx = 0;
		gbc_lblHorarioE.gridy = 10;
		pnlEditarEmpleado.add(lblHorarioE, gbc_lblHorarioE);
		
		comboHorarioE = new JComboBox();
		comboHorarioE.setBackground(Color.DARK_GRAY);
		comboHorarioE.setForeground(Color.WHITE);
		comboHorarioE.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboHorarioE.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde", "Noche"}));
		GridBagConstraints gbc_comboHorarioE = new GridBagConstraints();
		gbc_comboHorarioE.gridwidth = 2;
		gbc_comboHorarioE.insets = new Insets(0, 0, 5, 5);
		gbc_comboHorarioE.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboHorarioE.gridx = 2;
		gbc_comboHorarioE.gridy = 10;
		pnlEditarEmpleado.add(comboHorarioE, gbc_comboHorarioE);
		
		lblPrimerIdiomaE = new JLabel("1º Idioma:");
		lblPrimerIdiomaE.setForeground(Color.WHITE);
		lblPrimerIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrimerIdiomaE = new GridBagConstraints();
		gbc_lblPrimerIdiomaE.gridwidth = 2;
		gbc_lblPrimerIdiomaE.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerIdiomaE.gridx = 0;
		gbc_lblPrimerIdiomaE.gridy = 11;
		pnlEditarEmpleado.add(lblPrimerIdiomaE, gbc_lblPrimerIdiomaE);
		
		comboPrimerIdiomaE = new JComboBox();
		comboPrimerIdiomaE.setBackground(Color.DARK_GRAY);
		comboPrimerIdiomaE.setForeground(Color.WHITE);
		comboPrimerIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboPrimerIdiomaE.setModel(new DefaultComboBoxModel(new String[] {"Inglés", "Chino", "Español", "Árabe", "Alemán", "Portugués", "Ruso", "Japonés", "Hindi"}));
		GridBagConstraints gbc_comboPrimerIdiomaE = new GridBagConstraints();
		gbc_comboPrimerIdiomaE.gridwidth = 2;
		gbc_comboPrimerIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_comboPrimerIdiomaE.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPrimerIdiomaE.gridx = 2;
		gbc_comboPrimerIdiomaE.gridy = 11;
		pnlEditarEmpleado.add(comboPrimerIdiomaE, gbc_comboPrimerIdiomaE);
		
		lblSegundoIdiomaE = new JLabel("2º Idioma:");
		lblSegundoIdiomaE.setForeground(Color.WHITE);
		lblSegundoIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSegundoIdiomaE = new GridBagConstraints();
		gbc_lblSegundoIdiomaE.gridwidth = 2;
		gbc_lblSegundoIdiomaE.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoIdiomaE.gridx = 0;
		gbc_lblSegundoIdiomaE.gridy = 12;
		pnlEditarEmpleado.add(lblSegundoIdiomaE, gbc_lblSegundoIdiomaE);
		
		comboSegundoIdiomaE = new JComboBox();
		comboSegundoIdiomaE.setBackground(Color.DARK_GRAY);
		comboSegundoIdiomaE.setForeground(Color.WHITE);
		comboSegundoIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboSegundoIdiomaE.setModel(new DefaultComboBoxModel(new String[] {"Inglés", "Chino", "Español", "Árabe", "Alemán", "Portugués", "Ruso", "Japonés", "Hindi"}));
		GridBagConstraints gbc_comboSegundoIdiomaE = new GridBagConstraints();
		gbc_comboSegundoIdiomaE.gridwidth = 2;
		gbc_comboSegundoIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_comboSegundoIdiomaE.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSegundoIdiomaE.gridx = 2;
		gbc_comboSegundoIdiomaE.gridy = 12;
		pnlEditarEmpleado.add(comboSegundoIdiomaE, gbc_comboSegundoIdiomaE);
		
		lblTercerIdiomaE = new JLabel("3º Iidoma:");
		lblTercerIdiomaE.setForeground(Color.WHITE);
		lblTercerIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTercerIdiomaE = new GridBagConstraints();
		gbc_lblTercerIdiomaE.gridwidth = 2;
		gbc_lblTercerIdiomaE.anchor = GridBagConstraints.EAST;
		gbc_lblTercerIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_lblTercerIdiomaE.gridx = 0;
		gbc_lblTercerIdiomaE.gridy = 13;
		pnlEditarEmpleado.add(lblTercerIdiomaE, gbc_lblTercerIdiomaE);
		
		comboTercerIdiomaE = new JComboBox();
		comboTercerIdiomaE.setBackground(Color.DARK_GRAY);
		comboTercerIdiomaE.setForeground(Color.WHITE);
		comboTercerIdiomaE.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboTercerIdiomaE.setModel(new DefaultComboBoxModel(new String[] {"Inglés", "Chino", "Español", "Árabe", "Alemán", "Portugués", "Ruso", "Japonés", "Hindi"}));
		GridBagConstraints gbc_comboTercerIdiomaE = new GridBagConstraints();
		gbc_comboTercerIdiomaE.gridwidth = 2;
		gbc_comboTercerIdiomaE.insets = new Insets(0, 0, 5, 5);
		gbc_comboTercerIdiomaE.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTercerIdiomaE.gridx = 2;
		gbc_comboTercerIdiomaE.gridy = 13;
		pnlEditarEmpleado.add(comboTercerIdiomaE, gbc_comboTercerIdiomaE);
		
		btnCancelarE = new JButton("Cancelar");
		btnCancelarE.addMouseListener(new BtnCancelarEMouseListener());
		btnCancelarE.setPreferredSize(new Dimension(75, 33));
		btnCancelarE.setBorder(null);
		btnCancelarE.setForeground(Color.WHITE);
		btnCancelarE.setBackground(new Color(255,71,71));
		btnCancelarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarE.addActionListener(new BtnCancelarActionListener());
		GridBagConstraints gbc_btnCancelarE = new GridBagConstraints();
		gbc_btnCancelarE.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarE.gridwidth = 2;
		gbc_btnCancelarE.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarE.gridx = 2;
		gbc_btnCancelarE.gridy = 15;
		pnlEditarEmpleado.add(btnCancelarE, gbc_btnCancelarE);
		
		btnGuardarE = new JButton("Guardar");
		btnGuardarE.addActionListener(new BtnGuardarEActionListener());
		btnGuardarE.addMouseListener(new BtnGuardarEMouseListener());
		btnGuardarE.setPreferredSize(new Dimension(71, 33));
		btnGuardarE.setForeground(Color.WHITE);
		btnGuardarE.setBorder(null);
		btnGuardarE.setBackground(new Color(47,198,152));
		btnGuardarE.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarE = new GridBagConstraints();
		gbc_btnGuardarE.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarE.gridwidth = 2;
		gbc_btnGuardarE.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarE.gridx = 4;
		gbc_btnGuardarE.gridy = 15;
		pnlEditarEmpleado.add(btnGuardarE, gbc_btnGuardarE);
		
		scrollPane = new JScrollPane();
		
//		scrollPane.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrollPane.setBorder(null);
		pnlPrincipalEmpleados.add(scrollPane, BorderLayout.CENTER);
		
		pnlListaEmpleados = new JPanel();
		pnlListaEmpleados.setBorder(null);
		pnlListaEmpleados.setBackground(new Color(31,34,40));
		scrollPane.setViewportView(pnlListaEmpleados);
		pnlListaEmpleados.setLayout(new BoxLayout(pnlListaEmpleados, BoxLayout.Y_AXIS));
		
		
		//fillExamples();
	}

	/*********************************MAIN LISTENERS**********************************/
	
	private class BtnNuevoEmpleadoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			limpiarElementosN();
			
			if (!pnlDesplegableEmpleado.isVisible()) {
				pnlDesplegableEmpleado.setVisible(true);
			}
			
			CardLayout cl = (CardLayout)(pnlDesplegableEmpleado.getLayout());
			cl.show(pnlDesplegableEmpleado, "Nuevo Empleado");
		}
	}
	
	public class BtnEditarEmpleadoActionListener implements ActionListener{
		
		Empleado auxEmpleado;
		
		private int id;
		
		public void actionPerformed(ActionEvent arg0) {
			
			setEditingId(getId());
			llenarElementosE(getEmpleado());
			
			if (!pnlDesplegableEmpleado.isVisible()) {
				pnlDesplegableEmpleado.setVisible(true);
			}
			
			CardLayout cl = (CardLayout)(pnlDesplegableEmpleado.getLayout());
			cl.show(pnlDesplegableEmpleado, "Editar Empleado");
		}
		
		public void setEmpleado(String nombre, String apellidos, File foto, 
					String telefono, String correo, Vector<String> idiomas,
					String formacion, String horario) {
			
			this.auxEmpleado = new Empleado(nombre, apellidos, foto,
					telefono, correo, idiomas, formacion, horario);
		}
		
		public Empleado getEmpleado() {
			return this.auxEmpleado;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
	}
	
	public class BtnDarDeBajaEmpleadoListener implements ActionListener {
		
		private int id;
		
		public void actionPerformed(ActionEvent arg0) {
			
			int position = identifiers.indexOf(getId());
			pnlListaEmpleados.remove(pnlListaEmpleados.getComponent(position));
			identifiers.remove(position);
			pnlListaEmpleados.repaint();
			pnlListaEmpleados.revalidate();
		
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
	}
	
	/****************************NUEVO EMPLEADO LISTENERS*****************************/
	
	private class BtnSubirFotoEmpleadoNActionListener implements ActionListener {
		
		private Component frame;
		private File file;
	
		public void actionPerformed(ActionEvent arg0) {
			
			JFileChooser fcAbrir = new JFileChooser();
            int valorDevuelto = fcAbrir.showOpenDialog(frame);
            
            //Resizing the photo
            if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
                file = fcAbrir.getSelectedFile(); 
                setFotoEmpleadoN(file); //Setting the image in the corresponding label
                fileFotoNuevoEmpleado = file; //Saving the path to the file to send it to the Employee panel
            }
		}
	}
	
	private class BtnGuardarNActionListener implements ActionListener {
		private Component frame;
		public void actionPerformed(ActionEvent arg0) {
			
			if(comprobarCamposN()) {
				guardarEmpleadoN();
			}else {
				JOptionPane.showMessageDialog(frame, "Hay campos sin rellenar",
						"Custom error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
		
	/****************************EDITAR EMPLEADO LISTENERS****************************/
	
	private class BtnSubirFotoEmpleadoEActionListener implements ActionListener {
		
		private Component frame;
		private File file;
	
		public void actionPerformed(ActionEvent arg0) {
			
			JFileChooser fcAbrir = new JFileChooser();
            int valorDevuelto = fcAbrir.showOpenDialog(frame);
            
            //Resizing the photo
            if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
                file = fcAbrir.getSelectedFile(); 
                setFotoEmpleadoE(file); //Setting the image in the corresponding label
                fileFotoNuevoEmpleado = file; //Saving the path to the file to send it to the Employee panel
            }
		}
	}
	
	private class BtnGuardarEActionListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			int position = identifiers.indexOf(getEditingId());
			pnlListaEmpleados.remove(pnlListaEmpleados.getComponent(position));
			identifiers.remove(position);
			pnlListaEmpleados.repaint();
			pnlListaEmpleados.revalidate();
			
			guardarEmpleadoE();
			
		}
	}
	
	/******************************LISTENERS COMPARTIDOS******************************/
	
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pnlDesplegableEmpleado.setVisible(false);
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnNuevoEmpleadoMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNuevoEmpleado.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnNuevoEmpleado.setBackground(new Color (47,198,152));
		}
	}
	
	private class BtnSubirFotoEmpleadoNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSubirFotoEmpleadoN.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSubirFotoEmpleadoN.setBackground(new Color(0,120,210));
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
	
	private class BtnSubirFotoEmpleadoEMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSubirFotoEmpleadoE.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSubirFotoEmpleadoE.setBackground(new Color(0,120,210));
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

	
	/*******************************METODOS AUXILIARES********************************/
	
	private void limpiarElementosN () {
		lblFotoEmpleadoN.setIcon(null);
		fileFotoNuevoEmpleado = null;
		txtNombreN.setText(null);
		txtApellidosN.setText(null);
		txtTelefonoN.setText(null);
		txtCorreoN.setText(null);
		comboFormacionN.setSelectedIndex(0);
		comboHorarioN.setSelectedIndex(0);
		comboPrimerIdiomaN.setSelectedIndex(0);
		comboSegundoIdiomaN.setSelectedIndex(0);
		comboTercerIdiomaN.setSelectedIndex(0);
	}

	private void llenarElementosE (Empleado empleado) {
		fileFotoNuevoEmpleado = empleado.getFoto();
		setFotoEmpleadoE(empleado.getFoto());
		txtNombreE.setText(empleado.getNombre());
		txtApellidosE.setText(empleado.getApellidos());
		txtTelefonoE.setText(empleado.getTelefono());
		txtCorreoE.setText(empleado.getCorreo());
		comboFormacionE.setSelectedItem(empleado.getFormacion());
		comboHorarioE.setSelectedItem(empleado.getFormacion());
		comboPrimerIdiomaE.setSelectedItem(empleado.getIdiomas().elementAt(0));
		comboSegundoIdiomaE.setSelectedItem(empleado.getIdiomas().elementAt(1));
		comboTercerIdiomaE.setSelectedItem(empleado.getIdiomas().elementAt(2));
	}
	
	private void setFotoEmpleadoN (File file) {
        try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoEmpleadoN.getWidth() -35,
            lblFotoEmpleadoN.getHeight() -35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoEmpleadoN.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void setFotoEmpleadoE (File file) {
        try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoEmpleadoE.getWidth() -35,
            lblFotoEmpleadoE.getHeight() -35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoEmpleadoE.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private boolean comprobarCamposN () {
		if (fileFotoNuevoEmpleado == null ||
			txtNombreN.getText() == null ||
			txtApellidosN.getText() == null ||
			txtTelefonoN.getText() == null ||
			txtCorreoN.getText() == null)
		{
		
			return false;
			
		}
		return true;
	}
	
	private void guardarEmpleadoN () {
		BtnEditarEmpleadoActionListener editarListener = new BtnEditarEmpleadoActionListener();
		BtnDarDeBajaEmpleadoListener darDeBajaListener = new BtnDarDeBajaEmpleadoListener();
		
		Vector<String> auxIdiomas = new Vector<String>();
		auxIdiomas.add((String) comboPrimerIdiomaN.getSelectedItem());
		auxIdiomas.add((String) comboSegundoIdiomaN.getSelectedItem());
		auxIdiomas.add((String) comboTercerIdiomaN.getSelectedItem());
		
		editarListener.setEmpleado(
				txtNombreN.getText(), 
				txtApellidosN.getText(), 
				fileFotoNuevoEmpleado, 
				txtTelefonoN.getText(),
				txtCorreoN.getText(),
				auxIdiomas, 
				(String)comboFormacionN.getSelectedItem(),
				(String)comboHorarioN.getSelectedItem());
		
		globalId++;
		identifiers.add(globalId);
	
		darDeBajaListener.setId(globalId);
		editarListener.setId(globalId);
		 
		pnlListaEmpleados.add(new panelEmpleado(editarListener, darDeBajaListener, globalId));
		pnlListaEmpleados.repaint();
		pnlListaEmpleados.revalidate();
		
		pnlDesplegableEmpleado.setVisible(false);
	}

	private void guardarEmpleadoE () {
		BtnEditarEmpleadoActionListener editarListener = new BtnEditarEmpleadoActionListener();
		BtnDarDeBajaEmpleadoListener darDeBajaListener = new BtnDarDeBajaEmpleadoListener();
		
		Vector<String> auxIdiomas = new Vector<String>();
		auxIdiomas.add((String) comboPrimerIdiomaE.getSelectedItem());
		auxIdiomas.add((String) comboSegundoIdiomaE.getSelectedItem());
		auxIdiomas.add((String) comboTercerIdiomaE.getSelectedItem());
		
		editarListener.setEmpleado(
				txtNombreE.getText(), 
				txtApellidosE.getText(), 
				fileFotoNuevoEmpleado, 
				txtTelefonoE.getText(),
				txtCorreoE.getText(),
				auxIdiomas, 
				(String)comboFormacionE.getSelectedItem(),
				(String)comboHorarioE.getSelectedItem());
		
		globalId++;
		identifiers.add(globalId);
	
		darDeBajaListener.setId(globalId);
		editarListener.setId(globalId);
		 
		pnlListaEmpleados.add(new panelEmpleado(editarListener, darDeBajaListener, globalId));
		pnlListaEmpleados.repaint();
		pnlListaEmpleados.revalidate();
		
		pnlDesplegableEmpleado.setVisible(false);
	}
	
	public int getEditingId() {
		return this.editingId;
	}
	
	public void setEditingId(int id) {
		this.editingId = id;
	}

	private void fillExamples() {
		Vector<String> idiomas = new Vector<String>();
		idiomas.add("Inglés");
		idiomas.add("Español");
		idiomas.add("Alemán");
		
		Empleado exMarina = new Empleado(
				"Marina",
				"Prieto Pech",
				new File(this.getClass().getResource("/presentacion/recursos/Marina.png").getFile()),
				"644440991",
				"Marina.Prieto1@alu.uclm.es",
				idiomas,
				"Universitaria",
				"Mañana"
				);
		Empleado exJosue = new Empleado(
				"Josue Carlos",
				"Zenteno Yave",
				new File(this.getClass().getResource("/presentacion/recursos/Josue.png").getFile()),
				"609118724",
				"JosueCarlos.Zenteno@alu.uclm.es",
				idiomas,
				"Universitaria",
				"Noche"
				);
		Empleado exSergio = new Empleado(
				"Sergio",
				"Silvestre Pavón",
				new File(this.getClass().getResource("/presentacion/recursos/Sergio.png").getFile()),
				"617514128",
				"Sergio.Silvestre@alu.uclm.es",
				idiomas,
				"Universitaria",
				"Tarde"
				);
		
		generateExample(exMarina);
		generateExample(exJosue);
		generateExample(exSergio);
		
	}
	
	private void generateExample(Empleado auxEmpleado) {
		BtnEditarEmpleadoActionListener editarListener = new BtnEditarEmpleadoActionListener();
		BtnDarDeBajaEmpleadoListener darDeBajaListener = new BtnDarDeBajaEmpleadoListener();
		
		editarListener.setEmpleado(
				auxEmpleado.getNombre(), 
				auxEmpleado.getApellidos(), 
				auxEmpleado.getFoto(), 
				auxEmpleado.getTelefono(),
				auxEmpleado.getCorreo(),
				auxEmpleado.getIdiomas(), 
				auxEmpleado.getFormacion(),
				auxEmpleado.getHorario());
		
		globalId++;
		identifiers.add(globalId);
	
		darDeBajaListener.setId(globalId);
		editarListener.setId(globalId);
		 
		pnlListaEmpleados.add(new panelEmpleado(editarListener, darDeBajaListener, globalId));
		pnlListaEmpleados.repaint();
		pnlListaEmpleados.revalidate();
	}
}
