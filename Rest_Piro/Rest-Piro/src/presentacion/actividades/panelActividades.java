package presentacion.actividades;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.text.MaskFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;  
import dominio.Actividad;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings({"serial", "deprecation"})
public class panelActividades extends JPanel {
	private JPanel pnlBarraSuperior;
	private JLabel lblTitle;
	private JPanel pnlBotonesBarraSuperior;
	private JButton btnNuevaActividad;
	private JButton btnHistorial;
	private JPanel principalCardLayout;
	private JButton btnAtras;
	private JPanel pnlPrincipalActividadesActivas;
	private JPanel pnlPrincipalActividadesPasadas;
	private JPanel pnlDesplegableActividadesActivas;
	private JPanel pnlNuevaActividad;
	private JPanel pnlVerMasActividad;
	private JScrollPane scrlActividadesActivas;
	private JPanel pnlListaActividadesActivas;
	private JPanel pnlDesplegableComentarios;
	private JScrollPane scrlActividadesPasadas;
	private JPanel pnlListaActividadesPasadas;
	private JLabel lblFotoActividadN;
	private JButton btnSubirFotoActividadN;
	private JLabel lblNombreActividadN;
	private JTextField txtNombreActividadN;
	private JLabel lblMonitorActividadN;
	private JTextField txtMonitorActividadN;
	private JLabel lblDestinatarioActividadN;
	private JTextField txtDestinatarioActividadN;
	private JLabel lblPrecioPorMesActividadN;
	private JLabel lblCupoMinimoActividadN;
	private JLabel lblCupoMaximoActividadN;
	private JLabel lblHoraInicioActividadN;
	private JSpinner spinCupoMinimoActividadN;
	private JSpinner spinCupoMaximoActividadN;
	private JLabel lblHoraFinActividadN;
	private JSpinner spinHoraInicioActividadN;
	private JSpinner spinHoraFinActividadN;
	private JLabel lblFechaActividadN;
	private JButton btnGuardarActividadN;
	private JButton btnCancelarActividadN;
	private JScrollPane scrlDescripcionActividadN;
	private JTextArea txtaDescripcionActividadN;
	private JLabel lblTituloActividadN;
	private JLabel lblTituloNombreActividadVM;
	private JLabel lblFotoActividadVM;
	private JLabel lblMonitorActividadVM;
	private JLabel lblDestinatarioActividadVM;
	private JLabel lblPrecioPorMesActividadVM;
	private JLabel lblFechaActividadVM;
	private JLabel lblCupoMinimoActividadVM;
	private JLabel lblCupoMaximoActividadVM;
	private JLabel lblHoraInicioActividadVM;
	private JLabel lblHoraFinActividadVM;
	private JLabel lblDescripcionActividadOutVM;
	private JButton btnSalirActividadVM;
	private JLabel lblMonitorActividadOutVM;
	private JLabel lblDestinatarioActividadOutVM;
	private JLabel lblPrecioPorMesActividadOutVM;
	private JLabel lblFechaActividadOutVM;
	private JLabel lblCupoMinimoActividadOutVM;
	private JLabel lblCupoMaximoActividadOutVM;
	private JLabel lblHoraInicioActividadOutVM;
	private JLabel lblHoraFinActividadOutVM;
	private JScrollPane scrollPane;
	private JPanel pnlListaComentarios;
	private JDateChooser dateChooser;
	private JFormattedTextField txtPrecioPorMesActividadN;
	private JLabel lblNewLabel;
	
	/***********************************PARAMETROS************************************/
	private File fileFotoNuevaActividad;
	private Vector<Integer> identifiers = new Vector<Integer>();
	private int globalId = -1;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelActividades() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		pnlBarraSuperior = new JPanel();
		pnlBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.setBorder(null);
		add(pnlBarraSuperior, BorderLayout.NORTH);
		pnlBarraSuperior.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblTitle = new JLabel("ACTIVIDADES");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBorder(new EmptyBorder(30, 50, 40, 0));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 46));
		pnlBarraSuperior.add(lblTitle);
		
		pnlBotonesBarraSuperior = new JPanel();
		pnlBotonesBarraSuperior.setBorder(null);
		pnlBotonesBarraSuperior.setBackground(new Color(31,34,40));
		pnlBarraSuperior.add(pnlBotonesBarraSuperior);
		GridBagLayout gbl_pnlBotonesBarraSuperior = new GridBagLayout();
		gbl_pnlBotonesBarraSuperior.columnWidths = new int[] {0, 80, 80, 80, 50, 0};
		gbl_pnlBotonesBarraSuperior.rowHeights = new int[] {0, 20, 0};
		gbl_pnlBotonesBarraSuperior.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlBotonesBarraSuperior.rowWeights = new double[]{1.0, 1.0, 1.0};
		pnlBotonesBarraSuperior.setLayout(gbl_pnlBotonesBarraSuperior);
		
		btnNuevaActividad = new JButton("Nuevo");
		btnNuevaActividad.addMouseListener(new BtnNuevaActividadMouseListener());
		btnNuevaActividad.setBorder(null);
		btnNuevaActividad.setBackground(new Color (47,198,152));
		btnNuevaActividad.setForeground(Color.WHITE);
		btnNuevaActividad.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNuevaActividad.addActionListener(new BtnNuevaActividadActionListener());
		
		btnHistorial = new JButton("Historial");
		btnHistorial.addMouseListener(new BtnHistorialMouseListener());
		btnHistorial.setBorder(null);
		btnHistorial.setBackground(new Color(0,120,210));
		btnHistorial.setForeground(Color.WHITE);
		btnHistorial.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnHistorial.addActionListener(new BtnHistorialActionListener());
		
		btnAtras = new JButton("Atrás");
		btnAtras.addMouseListener(new BtnAtrasMouseListener());
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(0,120,210));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setVisible(false);
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.fill = GridBagConstraints.BOTH;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 1;
		pnlBotonesBarraSuperior.add(btnAtras, gbc_btnAtras);
		GridBagConstraints gbc_btnHistorial = new GridBagConstraints();
		gbc_btnHistorial.fill = GridBagConstraints.BOTH;
		gbc_btnHistorial.insets = new Insets(0, 0, 5, 5);
		gbc_btnHistorial.gridx = 2;
		gbc_btnHistorial.gridy = 1;
		pnlBotonesBarraSuperior.add(btnHistorial, gbc_btnHistorial);
		GridBagConstraints gbc_btnNuevaActividad = new GridBagConstraints();
		gbc_btnNuevaActividad.fill = GridBagConstraints.BOTH;
		gbc_btnNuevaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevaActividad.gridx = 3;
		gbc_btnNuevaActividad.gridy = 1;
		pnlBotonesBarraSuperior.add(btnNuevaActividad, gbc_btnNuevaActividad);
		
		principalCardLayout = new JPanel();
		principalCardLayout.setBorder(null);
		principalCardLayout.setBackground(Color.BLACK);
		add(principalCardLayout, BorderLayout.CENTER);
		principalCardLayout.setLayout(new CardLayout(0, 0));
		
		pnlPrincipalActividadesActivas = new JPanel();
		pnlPrincipalActividadesActivas.setBorder(null);
		pnlPrincipalActividadesActivas.setBackground(new Color(31,34,40));
		principalCardLayout.add(pnlPrincipalActividadesActivas, "Principal Actividades Activas");
		pnlPrincipalActividadesActivas.setLayout(new BorderLayout(0, 0));
		
		pnlDesplegableActividadesActivas = new JPanel();
		pnlDesplegableActividadesActivas.setBorder(null);
		pnlDesplegableActividadesActivas.setBackground(new Color(42,46,49));
		pnlDesplegableActividadesActivas.setVisible(false);
		pnlPrincipalActividadesActivas.add(pnlDesplegableActividadesActivas, BorderLayout.EAST);
		pnlDesplegableActividadesActivas.setLayout(new CardLayout(0, 0));
		
		pnlNuevaActividad = new JPanel();
		pnlNuevaActividad.setBorder(null);
		pnlNuevaActividad.setBackground(new Color(42,46,49));
		pnlDesplegableActividadesActivas.add(pnlNuevaActividad, "Nueva Actividad");
		GridBagLayout gbl_pnlNuevaActividad = new GridBagLayout();
		gbl_pnlNuevaActividad.columnWidths = new int[] {70, 70, 70, 70, 70, 70, 70};
		gbl_pnlNuevaActividad.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_pnlNuevaActividad.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlNuevaActividad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		pnlNuevaActividad.setLayout(gbl_pnlNuevaActividad);
		
		lblTituloActividadN = new JLabel("Nueva Actividad");
		lblTituloActividadN.setForeground(Color.WHITE);
		lblTituloActividadN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloActividadN.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloActividadN.setBorder(null);
		GridBagConstraints gbc_lblTituloActividadN = new GridBagConstraints();
		gbc_lblTituloActividadN.fill = GridBagConstraints.BOTH;
		gbc_lblTituloActividadN.gridwidth = 7;
		gbc_lblTituloActividadN.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloActividadN.gridx = 0;
		gbc_lblTituloActividadN.gridy = 0;
		pnlNuevaActividad.add(lblTituloActividadN, gbc_lblTituloActividadN);
		
		lblFotoActividadN = new JLabel("");
		lblFotoActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoActividadN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoActividadN = new GridBagConstraints();
		gbc_lblFotoActividadN.fill = GridBagConstraints.BOTH;
		gbc_lblFotoActividadN.gridwidth = 3;
		gbc_lblFotoActividadN.gridheight = 3;
		gbc_lblFotoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoActividadN.gridx = 2;
		gbc_lblFotoActividadN.gridy = 1;
		pnlNuevaActividad.add(lblFotoActividadN, gbc_lblFotoActividadN);
		
		btnSubirFotoActividadN = new JButton("Subir foto...");
		btnSubirFotoActividadN.addMouseListener(new BtnSubirFotoActividadNMouseListener());
		btnSubirFotoActividadN.setPreferredSize(new Dimension(91, 28));
		btnSubirFotoActividadN.setBackground(new Color(0,120,210));
		btnSubirFotoActividadN.setForeground(Color.WHITE);
		btnSubirFotoActividadN.setBorder(null);
		btnSubirFotoActividadN.addActionListener(new BtnSubirFotoActividadNActionListener());
		btnSubirFotoActividadN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSubirFotoActividadN = new GridBagConstraints();
		gbc_btnSubirFotoActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubirFotoActividadN.gridwidth = 3;
		gbc_btnSubirFotoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubirFotoActividadN.gridx = 2;
		gbc_btnSubirFotoActividadN.gridy = 4;
		pnlNuevaActividad.add(btnSubirFotoActividadN, gbc_btnSubirFotoActividadN);
		
		lblNombreActividadN = new JLabel("Nombre:");
		lblNombreActividadN.setForeground(Color.WHITE);
		lblNombreActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNombreActividadN = new GridBagConstraints();
		gbc_lblNombreActividadN.gridwidth = 2;
		gbc_lblNombreActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblNombreActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreActividadN.gridx = 0;
		gbc_lblNombreActividadN.gridy = 5;
		pnlNuevaActividad.add(lblNombreActividadN, gbc_lblNombreActividadN);
		
		txtNombreActividadN = new JTextField();
		txtNombreActividadN.setForeground(Color.WHITE);
		txtNombreActividadN.setCaretColor(Color.WHITE);
		txtNombreActividadN.setBackground(Color.DARK_GRAY);
		txtNombreActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombreActividadN.setColumns(10);
		GridBagConstraints gbc_txtNombreActividadN = new GridBagConstraints();
		gbc_txtNombreActividadN.gridwidth = 3;
		gbc_txtNombreActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreActividadN.gridx = 2;
		gbc_txtNombreActividadN.gridy = 5;
		pnlNuevaActividad.add(txtNombreActividadN, gbc_txtNombreActividadN);
		
		lblMonitorActividadN = new JLabel("Monitor:");
		lblMonitorActividadN.setForeground(Color.WHITE);
		lblMonitorActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMonitorActividadN = new GridBagConstraints();
		gbc_lblMonitorActividadN.gridwidth = 2;
		gbc_lblMonitorActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblMonitorActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorActividadN.gridx = 0;
		gbc_lblMonitorActividadN.gridy = 6;
		pnlNuevaActividad.add(lblMonitorActividadN, gbc_lblMonitorActividadN);
		
		txtMonitorActividadN = new JTextField();
		txtMonitorActividadN.setForeground(Color.WHITE);
		txtMonitorActividadN.setCaretColor(Color.WHITE);
		txtMonitorActividadN.setBackground(Color.DARK_GRAY);
		txtMonitorActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtMonitorActividadN.setColumns(10);
		GridBagConstraints gbc_txtMonitorActividadN = new GridBagConstraints();
		gbc_txtMonitorActividadN.gridwidth = 3;
		gbc_txtMonitorActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_txtMonitorActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonitorActividadN.gridx = 2;
		gbc_txtMonitorActividadN.gridy = 6;
		pnlNuevaActividad.add(txtMonitorActividadN, gbc_txtMonitorActividadN);
		
		lblDestinatarioActividadN = new JLabel("Destinatario:");
		lblDestinatarioActividadN.setForeground(Color.WHITE);
		lblDestinatarioActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDestinatarioActividadN = new GridBagConstraints();
		gbc_lblDestinatarioActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatarioActividadN.gridwidth = 2;
		gbc_lblDestinatarioActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarioActividadN.gridx = 0;
		gbc_lblDestinatarioActividadN.gridy = 7;
		pnlNuevaActividad.add(lblDestinatarioActividadN, gbc_lblDestinatarioActividadN);
		
		txtDestinatarioActividadN = new JTextField();
		txtDestinatarioActividadN.setForeground(Color.WHITE);
		txtDestinatarioActividadN.setCaretColor(Color.WHITE);
		txtDestinatarioActividadN.setBackground(Color.DARK_GRAY);
		txtDestinatarioActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDestinatarioActividadN.setColumns(10);
		GridBagConstraints gbc_txtDestinatarioActividadN = new GridBagConstraints();
		gbc_txtDestinatarioActividadN.gridwidth = 3;
		gbc_txtDestinatarioActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_txtDestinatarioActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDestinatarioActividadN.gridx = 2;
		gbc_txtDestinatarioActividadN.gridy = 7;
		pnlNuevaActividad.add(txtDestinatarioActividadN, gbc_txtDestinatarioActividadN);
		
		lblPrecioPorMesActividadN = new JLabel("Precio/Mes:");
		lblPrecioPorMesActividadN.setForeground(Color.WHITE);
		lblPrecioPorMesActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioPorMesActividadN = new GridBagConstraints();
		gbc_lblPrecioPorMesActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioPorMesActividadN.gridwidth = 2;
		gbc_lblPrecioPorMesActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioPorMesActividadN.gridx = 0;
		gbc_lblPrecioPorMesActividadN.gridy = 8;
		pnlNuevaActividad.add(lblPrecioPorMesActividadN, gbc_lblPrecioPorMesActividadN);
		
		MaskFormatter formater;
		try {
			formater = new MaskFormatter("##");
			formater.setPlaceholderCharacter('X');
			txtPrecioPorMesActividadN = new JFormattedTextField(formater);
			txtPrecioPorMesActividadN.setForeground(Color.WHITE);
			txtPrecioPorMesActividadN.setCaretColor(Color.WHITE);
			txtPrecioPorMesActividadN.setBackground(Color.DARK_GRAY);
			txtPrecioPorMesActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
			GridBagConstraints gbc_txtPrecioPorMesActividadN = new GridBagConstraints();
			gbc_txtPrecioPorMesActividadN.gridwidth = 2;
			gbc_txtPrecioPorMesActividadN.insets = new Insets(0, 0, 5, 5);
			gbc_txtPrecioPorMesActividadN.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPrecioPorMesActividadN.gridx = 2;
			gbc_txtPrecioPorMesActividadN.gridy = 8;
			pnlNuevaActividad.add(txtPrecioPorMesActividadN, gbc_txtPrecioPorMesActividadN);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lblNewLabel = new JLabel("€");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 8;
		pnlNuevaActividad.add(lblNewLabel, gbc_lblNewLabel);
		
		lblFechaActividadN = new JLabel("Fecha:");
		lblFechaActividadN.setForeground(Color.WHITE);
		lblFechaActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaActividadN = new GridBagConstraints();
		gbc_lblFechaActividadN.gridwidth = 2;
		gbc_lblFechaActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblFechaActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaActividadN.gridx = 0;
		gbc_lblFechaActividadN.gridy = 9;
		pnlNuevaActividad.add(lblFechaActividadN, gbc_lblFechaActividadN);
		
		dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
//		JTextFieldDateEditor dateChooserEditor = ((JTextFieldDateEditor)dateChooser.getDateEditor());
//		dateChooserEditor.setBackground(Color.DARK_GRAY);
//		dateChooserEditor.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.anchor = GridBagConstraints.WEST;
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 9;
		pnlNuevaActividad.add(dateChooser, gbc_dateChooser);
		
		lblCupoMinimoActividadN = new JLabel("Cupo Mínimo:");
		lblCupoMinimoActividadN.setForeground(Color.WHITE);
		lblCupoMinimoActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMinimoActividadN = new GridBagConstraints();
		gbc_lblCupoMinimoActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMinimoActividadN.gridwidth = 2;
		gbc_lblCupoMinimoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMinimoActividadN.gridx = 0;
		gbc_lblCupoMinimoActividadN.gridy = 10;
		pnlNuevaActividad.add(lblCupoMinimoActividadN, gbc_lblCupoMinimoActividadN);
		
		spinCupoMinimoActividadN = new JSpinner();
		spinCupoMinimoActividadN.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinCupoMinimoActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinCupoMinimoActividadN.setForeground(Color.WHITE);
		spinCupoMinimoActividadN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_spinCupoMinimoActividadN = new GridBagConstraints();
		gbc_spinCupoMinimoActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinCupoMinimoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupoMinimoActividadN.gridx = 2;
		gbc_spinCupoMinimoActividadN.gridy = 10;
		pnlNuevaActividad.add(spinCupoMinimoActividadN, gbc_spinCupoMinimoActividadN);
		
		lblCupoMaximoActividadN = new JLabel("Cupo Máximo:");
		lblCupoMaximoActividadN.setForeground(Color.WHITE);
		lblCupoMaximoActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMaximoActividadN = new GridBagConstraints();
		gbc_lblCupoMaximoActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMaximoActividadN.gridwidth = 2;
		gbc_lblCupoMaximoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMaximoActividadN.gridx = 3;
		gbc_lblCupoMaximoActividadN.gridy = 10;
		pnlNuevaActividad.add(lblCupoMaximoActividadN, gbc_lblCupoMaximoActividadN);
		
		spinCupoMaximoActividadN = new JSpinner();
		spinCupoMaximoActividadN.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinCupoMaximoActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinCupoMaximoActividadN.setForeground(Color.WHITE);
		spinCupoMaximoActividadN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_spinCupoMaximoActividadN = new GridBagConstraints();
		gbc_spinCupoMaximoActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinCupoMaximoActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupoMaximoActividadN.gridx = 5;
		gbc_spinCupoMaximoActividadN.gridy = 10;
		pnlNuevaActividad.add(spinCupoMaximoActividadN, gbc_spinCupoMaximoActividadN);
		
		lblHoraInicioActividadN = new JLabel("Hora Inicio:");
		lblHoraInicioActividadN.setForeground(Color.WHITE);
		lblHoraInicioActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraInicioActividadN = new GridBagConstraints();
		gbc_lblHoraInicioActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblHoraInicioActividadN.gridwidth = 2;
		gbc_lblHoraInicioActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicioActividadN.gridx = 0;
		gbc_lblHoraInicioActividadN.gridy = 11;
		pnlNuevaActividad.add(lblHoraInicioActividadN, gbc_lblHoraInicioActividadN);
		
		spinHoraInicioActividadN = new JSpinner();
		spinHoraInicioActividadN.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinHoraInicioActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinHoraInicioActividadN.setForeground(Color.WHITE);
		spinHoraInicioActividadN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_spinHoraInicioActividadN = new GridBagConstraints();
		gbc_spinHoraInicioActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinHoraInicioActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_spinHoraInicioActividadN.gridx = 2;
		gbc_spinHoraInicioActividadN.gridy = 11;
		pnlNuevaActividad.add(spinHoraInicioActividadN, gbc_spinHoraInicioActividadN);
		
		lblHoraFinActividadN = new JLabel("Hora Fin:");
		lblHoraFinActividadN.setForeground(Color.WHITE);
		lblHoraFinActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraFinActividadN = new GridBagConstraints();
		gbc_lblHoraFinActividadN.anchor = GridBagConstraints.EAST;
		gbc_lblHoraFinActividadN.gridwidth = 2;
		gbc_lblHoraFinActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFinActividadN.gridx = 3;
		gbc_lblHoraFinActividadN.gridy = 11;
		pnlNuevaActividad.add(lblHoraFinActividadN, gbc_lblHoraFinActividadN);
		
		spinHoraFinActividadN = new JSpinner();
		spinHoraFinActividadN.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinHoraFinActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinHoraFinActividadN.setForeground(Color.WHITE);
		spinHoraFinActividadN.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_spinHoraFinActividadN = new GridBagConstraints();
		gbc_spinHoraFinActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinHoraFinActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_spinHoraFinActividadN.gridx = 5;
		gbc_spinHoraFinActividadN.gridy = 11;
		pnlNuevaActividad.add(spinHoraFinActividadN, gbc_spinHoraFinActividadN);
		
		scrlDescripcionActividadN = new JScrollPane();
		
//		scrlDescripcionActividadN.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrlDescripcionActividadN.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrlDescripcionActividadN.setBackground(Color.DARK_GRAY);
		scrlDescripcionActividadN.setForeground(Color.WHITE);
		scrlDescripcionActividadN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrlDescripcionActividadN = new GridBagConstraints();
		gbc_scrlDescripcionActividadN.gridheight = 4;
		gbc_scrlDescripcionActividadN.gridwidth = 5;
		gbc_scrlDescripcionActividadN.insets = new Insets(0, 0, 5, 5);
		gbc_scrlDescripcionActividadN.fill = GridBagConstraints.BOTH;
		gbc_scrlDescripcionActividadN.gridx = 1;
		gbc_scrlDescripcionActividadN.gridy = 12;
		pnlNuevaActividad.add(scrlDescripcionActividadN, gbc_scrlDescripcionActividadN);
		
		txtaDescripcionActividadN = new JTextArea();
		txtaDescripcionActividadN.setForeground(Color.WHITE);
		txtaDescripcionActividadN.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtaDescripcionActividadN.setCaretColor(Color.WHITE);
		txtaDescripcionActividadN.setBackground(Color.DARK_GRAY);
		txtaDescripcionActividadN.setBorder(null);
		scrlDescripcionActividadN.setViewportView(txtaDescripcionActividadN);
		
		btnCancelarActividadN = new JButton("Cancelar");
		btnCancelarActividadN.addMouseListener(new BtnCancelarActividadNMouseListener());
		btnCancelarActividadN.setPreferredSize(new Dimension(75, 33));
		btnCancelarActividadN.setBorder(null);
		btnCancelarActividadN.setForeground(Color.WHITE);
		btnCancelarActividadN.setBackground(new Color(255,71,71));
		btnCancelarActividadN.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarActividadN.addActionListener(new BtnCerrarDespActividadesActivasActionListener());
		GridBagConstraints gbc_btnCancelarActividadN = new GridBagConstraints();
		gbc_btnCancelarActividadN.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarActividadN.gridwidth = 2;
		gbc_btnCancelarActividadN.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarActividadN.gridx = 2;
		gbc_btnCancelarActividadN.gridy = 16;
		pnlNuevaActividad.add(btnCancelarActividadN, gbc_btnCancelarActividadN);
		
		btnGuardarActividadN = new JButton("Guardar");
		btnGuardarActividadN.addMouseListener(new BtnGuardarActividadNMouseListener());
		btnGuardarActividadN.setPreferredSize(new Dimension(71, 33));
		btnGuardarActividadN.setForeground(Color.WHITE);
		btnGuardarActividadN.setBorder(null);
		btnGuardarActividadN.setBackground(new Color(47,198,152));
		btnGuardarActividadN.addActionListener(new BtnGuardarActividadNActionListener());
		btnGuardarActividadN.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnGuardarActividadN = new GridBagConstraints();
		gbc_btnGuardarActividadN.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarActividadN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarActividadN.gridwidth = 2;
		gbc_btnGuardarActividadN.gridx = 4;
		gbc_btnGuardarActividadN.gridy = 16;
		pnlNuevaActividad.add(btnGuardarActividadN, gbc_btnGuardarActividadN);
		
		pnlVerMasActividad = new JPanel();
		pnlVerMasActividad.setBorder(null);
		pnlVerMasActividad.setBackground(new Color(42,46,49));
		pnlDesplegableActividadesActivas.add(pnlVerMasActividad, "Ver Mas");
		GridBagLayout gbl_pnlVerMasActividad = new GridBagLayout();
		gbl_pnlVerMasActividad.columnWidths = new int[] {70, 70, 70, 70, 70, 70, 70};
		gbl_pnlVerMasActividad.rowHeights = new int[] {70, 70, 70, 70, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_pnlVerMasActividad.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_pnlVerMasActividad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlVerMasActividad.setLayout(gbl_pnlVerMasActividad);
		
		lblTituloNombreActividadVM = new JLabel("<Dynamic>");
		lblTituloNombreActividadVM.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloNombreActividadVM.setForeground(Color.WHITE);
		lblTituloNombreActividadVM.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTituloNombreActividadVM.setBorder(null);
		GridBagConstraints gbc_lblTituloNombreActividadVM = new GridBagConstraints();
		gbc_lblTituloNombreActividadVM.fill = GridBagConstraints.BOTH;
		gbc_lblTituloNombreActividadVM.gridwidth = 7;
		gbc_lblTituloNombreActividadVM.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloNombreActividadVM.gridx = 0;
		gbc_lblTituloNombreActividadVM.gridy = 0;
		pnlVerMasActividad.add(lblTituloNombreActividadVM, gbc_lblTituloNombreActividadVM);
		
		lblFotoActividadVM = new JLabel("");
		lblFotoActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFotoActividadVM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_lblFotoActividadVM = new GridBagConstraints();
		gbc_lblFotoActividadVM.fill = GridBagConstraints.BOTH;
		gbc_lblFotoActividadVM.gridwidth = 3;
		gbc_lblFotoActividadVM.gridheight = 3;
		gbc_lblFotoActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoActividadVM.gridx = 2;
		gbc_lblFotoActividadVM.gridy = 1;
		pnlVerMasActividad.add(lblFotoActividadVM, gbc_lblFotoActividadVM);
		
		lblMonitorActividadVM = new JLabel("Monitor:");
		lblMonitorActividadVM.setForeground(Color.WHITE);
		lblMonitorActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMonitorActividadVM = new GridBagConstraints();
		gbc_lblMonitorActividadVM.gridwidth = 2;
		gbc_lblMonitorActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblMonitorActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorActividadVM.gridx = 0;
		gbc_lblMonitorActividadVM.gridy = 4;
		pnlVerMasActividad.add(lblMonitorActividadVM, gbc_lblMonitorActividadVM);
		
		lblMonitorActividadOutVM = new JLabel("");
		lblMonitorActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonitorActividadOutVM.setForeground(Color.WHITE);
		lblMonitorActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMonitorActividadOutVM = new GridBagConstraints();
		gbc_lblMonitorActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorActividadOutVM.gridx = 2;
		gbc_lblMonitorActividadOutVM.gridy = 4;
		pnlVerMasActividad.add(lblMonitorActividadOutVM, gbc_lblMonitorActividadOutVM);
		
		lblDestinatarioActividadVM = new JLabel("Destinatario:");
		lblDestinatarioActividadVM.setForeground(Color.WHITE);
		lblDestinatarioActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDestinatarioActividadVM = new GridBagConstraints();
		gbc_lblDestinatarioActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatarioActividadVM.gridwidth = 2;
		gbc_lblDestinatarioActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarioActividadVM.gridx = 0;
		gbc_lblDestinatarioActividadVM.gridy = 5;
		pnlVerMasActividad.add(lblDestinatarioActividadVM, gbc_lblDestinatarioActividadVM);
		
		lblDestinatarioActividadOutVM = new JLabel("");
		lblDestinatarioActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestinatarioActividadOutVM.setForeground(Color.WHITE);
		lblDestinatarioActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDestinatarioActividadOutVM = new GridBagConstraints();
		gbc_lblDestinatarioActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarioActividadOutVM.gridx = 2;
		gbc_lblDestinatarioActividadOutVM.gridy = 5;
		pnlVerMasActividad.add(lblDestinatarioActividadOutVM, gbc_lblDestinatarioActividadOutVM);
		
		lblPrecioPorMesActividadVM = new JLabel("Precio/Mes:");
		lblPrecioPorMesActividadVM.setForeground(Color.WHITE);
		lblPrecioPorMesActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioPorMesActividadVM = new GridBagConstraints();
		gbc_lblPrecioPorMesActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioPorMesActividadVM.gridwidth = 2;
		gbc_lblPrecioPorMesActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioPorMesActividadVM.gridx = 0;
		gbc_lblPrecioPorMesActividadVM.gridy = 6;
		pnlVerMasActividad.add(lblPrecioPorMesActividadVM, gbc_lblPrecioPorMesActividadVM);
		
		lblPrecioPorMesActividadOutVM = new JLabel("");
		lblPrecioPorMesActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioPorMesActividadOutVM.setForeground(Color.WHITE);
		lblPrecioPorMesActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioPorMesActividadOutVM = new GridBagConstraints();
		gbc_lblPrecioPorMesActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioPorMesActividadOutVM.gridx = 2;
		gbc_lblPrecioPorMesActividadOutVM.gridy = 6;
		pnlVerMasActividad.add(lblPrecioPorMesActividadOutVM, gbc_lblPrecioPorMesActividadOutVM);
		
		lblFechaActividadVM = new JLabel("Fecha:");
		lblFechaActividadVM.setForeground(Color.WHITE);
		lblFechaActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaActividadVM = new GridBagConstraints();
		gbc_lblFechaActividadVM.gridwidth = 2;
		gbc_lblFechaActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblFechaActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaActividadVM.gridx = 0;
		gbc_lblFechaActividadVM.gridy = 7;
		pnlVerMasActividad.add(lblFechaActividadVM, gbc_lblFechaActividadVM);
		
		lblFechaActividadOutVM = new JLabel("");
		lblFechaActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaActividadOutVM.setForeground(Color.WHITE);
		lblFechaActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaActividadOutVM = new GridBagConstraints();
		gbc_lblFechaActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaActividadOutVM.gridx = 2;
		gbc_lblFechaActividadOutVM.gridy = 7;
		pnlVerMasActividad.add(lblFechaActividadOutVM, gbc_lblFechaActividadOutVM);
		
		lblCupoMinimoActividadVM = new JLabel("Cupo Minimo:");
		lblCupoMinimoActividadVM.setForeground(Color.WHITE);
		lblCupoMinimoActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMinimoActividadVM = new GridBagConstraints();
		gbc_lblCupoMinimoActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMinimoActividadVM.gridwidth = 2;
		gbc_lblCupoMinimoActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMinimoActividadVM.gridx = 0;
		gbc_lblCupoMinimoActividadVM.gridy = 8;
		pnlVerMasActividad.add(lblCupoMinimoActividadVM, gbc_lblCupoMinimoActividadVM);
		
		lblCupoMinimoActividadOutVM = new JLabel("");
		lblCupoMinimoActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblCupoMinimoActividadOutVM.setForeground(Color.WHITE);
		lblCupoMinimoActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMinimoActividadOutVM = new GridBagConstraints();
		gbc_lblCupoMinimoActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMinimoActividadOutVM.gridx = 2;
		gbc_lblCupoMinimoActividadOutVM.gridy = 8;
		pnlVerMasActividad.add(lblCupoMinimoActividadOutVM, gbc_lblCupoMinimoActividadOutVM);
		
		lblCupoMaximoActividadVM = new JLabel("Cupo Maximo:");
		lblCupoMaximoActividadVM.setForeground(Color.WHITE);
		lblCupoMaximoActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMaximoActividadVM = new GridBagConstraints();
		gbc_lblCupoMaximoActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMaximoActividadVM.gridwidth = 2;
		gbc_lblCupoMaximoActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMaximoActividadVM.gridx = 3;
		gbc_lblCupoMaximoActividadVM.gridy = 8;
		pnlVerMasActividad.add(lblCupoMaximoActividadVM, gbc_lblCupoMaximoActividadVM);
		
		lblCupoMaximoActividadOutVM = new JLabel("");
		lblCupoMaximoActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblCupoMaximoActividadOutVM.setForeground(Color.WHITE);
		lblCupoMaximoActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCupoMaximoActividadOutVM = new GridBagConstraints();
		gbc_lblCupoMaximoActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMaximoActividadOutVM.gridx = 5;
		gbc_lblCupoMaximoActividadOutVM.gridy = 8;
		pnlVerMasActividad.add(lblCupoMaximoActividadOutVM, gbc_lblCupoMaximoActividadOutVM);
		
		lblHoraInicioActividadVM = new JLabel("Hora Inicio:");
		lblHoraInicioActividadVM.setForeground(Color.WHITE);
		lblHoraInicioActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraInicioActividadVM = new GridBagConstraints();
		gbc_lblHoraInicioActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblHoraInicioActividadVM.gridwidth = 2;
		gbc_lblHoraInicioActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicioActividadVM.gridx = 0;
		gbc_lblHoraInicioActividadVM.gridy = 9;
		pnlVerMasActividad.add(lblHoraInicioActividadVM, gbc_lblHoraInicioActividadVM);
		
		lblHoraInicioActividadOutVM = new JLabel("");
		lblHoraInicioActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraInicioActividadOutVM.setForeground(Color.WHITE);
		lblHoraInicioActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraInicioActividadOutVM = new GridBagConstraints();
		gbc_lblHoraInicioActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicioActividadOutVM.gridx = 2;
		gbc_lblHoraInicioActividadOutVM.gridy = 9;
		pnlVerMasActividad.add(lblHoraInicioActividadOutVM, gbc_lblHoraInicioActividadOutVM);
		
		lblHoraFinActividadVM = new JLabel("Hora Fin:");
		lblHoraFinActividadVM.setForeground(Color.WHITE);
		lblHoraFinActividadVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraFinActividadVM = new GridBagConstraints();
		gbc_lblHoraFinActividadVM.gridwidth = 2;
		gbc_lblHoraFinActividadVM.anchor = GridBagConstraints.EAST;
		gbc_lblHoraFinActividadVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFinActividadVM.gridx = 3;
		gbc_lblHoraFinActividadVM.gridy = 9;
		pnlVerMasActividad.add(lblHoraFinActividadVM, gbc_lblHoraFinActividadVM);
		
		lblHoraFinActividadOutVM = new JLabel("");
		lblHoraFinActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraFinActividadOutVM.setForeground(Color.WHITE);
		lblHoraFinActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHoraFinActividadOutVM = new GridBagConstraints();
		gbc_lblHoraFinActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFinActividadOutVM.gridx = 5;
		gbc_lblHoraFinActividadOutVM.gridy = 9;
		pnlVerMasActividad.add(lblHoraFinActividadOutVM, gbc_lblHoraFinActividadOutVM);
		
		lblDescripcionActividadOutVM = new JLabel("");
		lblDescripcionActividadOutVM.setVerticalTextPosition(SwingConstants.TOP);
		lblDescripcionActividadOutVM.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcionActividadOutVM.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcionActividadOutVM.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDescripcionActividadOutVM.setForeground(Color.WHITE);
		lblDescripcionActividadOutVM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		lblDescripcionActividadOutVM.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDescripcionActividadOutVM = new GridBagConstraints();
		gbc_lblDescripcionActividadOutVM.fill = GridBagConstraints.BOTH;
		gbc_lblDescripcionActividadOutVM.gridheight = 3;
		gbc_lblDescripcionActividadOutVM.gridwidth = 5;
		gbc_lblDescripcionActividadOutVM.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionActividadOutVM.gridx = 1;
		gbc_lblDescripcionActividadOutVM.gridy = 11;
		pnlVerMasActividad.add(lblDescripcionActividadOutVM, gbc_lblDescripcionActividadOutVM);
		
		btnSalirActividadVM = new JButton("Salir");
		btnSalirActividadVM.addMouseListener(new BtnSalirActividadVMMouseListener());
		btnSalirActividadVM.setPreferredSize(new Dimension(75, 33));
		btnSalirActividadVM.setBorder(null);
		btnSalirActividadVM.setForeground(Color.WHITE);
		btnSalirActividadVM.setBackground(new Color(255,71,71));
		btnSalirActividadVM.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSalirActividadVM.addActionListener(new BtnCerrarDespActividadesActivasActionListener());
		GridBagConstraints gbc_btnSalirActividadVM = new GridBagConstraints();
		gbc_btnSalirActividadVM.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalirActividadVM.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalirActividadVM.gridwidth = 2;
		gbc_btnSalirActividadVM.gridx = 4;
		gbc_btnSalirActividadVM.gridy = 15;
		pnlVerMasActividad.add(btnSalirActividadVM, gbc_btnSalirActividadVM);
		
		scrlActividadesActivas = new JScrollPane();
		
//		scrlActividadesActivas.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrlActividadesActivas.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrlActividadesActivas.setBorder(null);
		scrlActividadesActivas.setBackground(new Color(31,34,40));
		pnlPrincipalActividadesActivas.add(scrlActividadesActivas, BorderLayout.CENTER);
		
		pnlListaActividadesActivas = new JPanel();
		pnlListaActividadesActivas.setBorder(null);
		pnlListaActividadesActivas.setBackground(new Color(31,34,40));
		scrlActividadesActivas.setViewportView(pnlListaActividadesActivas);
		pnlListaActividadesActivas.setLayout(new BoxLayout(pnlListaActividadesActivas, BoxLayout.Y_AXIS));
		
		pnlPrincipalActividadesPasadas = new JPanel();
		pnlPrincipalActividadesPasadas.setBorder(null);
		pnlPrincipalActividadesPasadas.setBackground(new Color(31,34,40));
		principalCardLayout.add(pnlPrincipalActividadesPasadas, "Principal Actividades Pasadas");
		pnlPrincipalActividadesPasadas.setLayout(new BorderLayout(0, 0));
		
		pnlDesplegableComentarios = new JPanel();
		pnlDesplegableComentarios.setMaximumSize(new Dimension(100, 32767));
		pnlDesplegableComentarios.setBorder(null);
		pnlPrincipalActividadesPasadas.add(pnlDesplegableComentarios, BorderLayout.EAST);
		pnlDesplegableComentarios.setLayout(new BorderLayout(0, 0));
		pnlDesplegableComentarios.setVisible(false);
		
		scrollPane = new JScrollPane();
		
//		scrollPane.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrollPane.setMaximumSize(new Dimension(100, 32767));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(42,46,49));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlDesplegableComentarios.add(scrollPane, BorderLayout.CENTER);
		
		pnlListaComentarios = new JPanel();
		pnlListaComentarios.setMaximumSize(new Dimension(100, 32767));
		pnlListaComentarios.setBorder(null);
		pnlListaComentarios.setBackground(new Color(42,46,49));
		scrollPane.setViewportView(pnlListaComentarios);
		pnlListaComentarios.setLayout(new BoxLayout(pnlListaComentarios, BoxLayout.Y_AXIS));
		
		scrlActividadesPasadas = new JScrollPane();
		
//		scrlActividadesPasadas.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrlActividadesPasadas.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrlActividadesPasadas.setBorder(null);
		scrlActividadesPasadas.setBackground(new Color(31,34,40));
		pnlPrincipalActividadesPasadas.add(scrlActividadesPasadas, BorderLayout.CENTER);
		
		pnlListaActividadesPasadas = new JPanel();
		pnlListaActividadesPasadas.setBorder(null);
		pnlListaActividadesPasadas.setBackground(new Color(31,34,40));
		scrlActividadesPasadas.setViewportView(pnlListaActividadesPasadas);
		pnlListaActividadesPasadas.setLayout(new BoxLayout(pnlListaActividadesPasadas, BoxLayout.Y_AXIS));
		
		
		//fillExamples();
		
	}//End of the principal class
	
	/*********************************MAIN LISTENERS**********************************/
	
	private class BtnHistorialActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			cambiarBotones("ActividadesPasadas");
			
			if (pnlDesplegableActividadesActivas.isVisible()) {
				pnlDesplegableActividadesActivas.setVisible(false);
			}
			
			CardLayout cl = (CardLayout)(principalCardLayout.getLayout());
			cl.show(principalCardLayout, "Principal Actividades Pasadas");
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			cambiarBotones("ActividadesActivas");
			
			if (pnlDesplegableComentarios.isVisible()) {
				pnlDesplegableComentarios.setVisible(false);
			}
			
			CardLayout cl = (CardLayout)(principalCardLayout.getLayout());
			cl.show(principalCardLayout, "Principal Actividades Activas");
		}
	}
	
	/**************************ACTIVIDADES ACTIVAS LISTENERS**************************/
	
	private class BtnNuevaActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			limpiarElementosNuevaActividad();
			
			if (!pnlDesplegableActividadesActivas.isVisible()) {
				pnlDesplegableActividadesActivas.setVisible(true);
			}
			
			CardLayout cl = (CardLayout)(pnlDesplegableActividadesActivas.getLayout());
			cl.show(pnlDesplegableActividadesActivas, "Nueva Actividad");

		}
	}
	
	public class BtnDarDeBajaActividadActionListener implements ActionListener {
		
		private Actividad actividad;
		private int id;
		
		public void actionPerformed(ActionEvent arg0) {
			
			if (pnlListaActividadesActivas.getComponentCount() >= 1) {
				
				BtnComentariosActionListener comentariosListener = new BtnComentariosActionListener();
				BtnCerrarDespComentariosActionListener cerrarComentariosListener = new BtnCerrarDespComentariosActionListener();
				
				
				comentariosListener.setActividad(getActividad());
				
				pnlListaActividadesPasadas.add(new panelActividadPasada(comentariosListener, cerrarComentariosListener));
				pnlListaActividadesPasadas.repaint();
				pnlListaActividadesPasadas.revalidate();
				
				int position = identifiers.indexOf(getId());
				pnlListaActividadesActivas.remove(pnlListaActividadesActivas.getComponent(position));
				identifiers.remove(position);
				pnlListaActividadesActivas.repaint();
				pnlListaActividadesActivas.revalidate();
			}
			
		}
		
		public Actividad getActividad() {
			return actividad;
		}
		
		public void setActividad(Actividad actividad) {
			this.actividad = actividad;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
	}
	
	public class BtnVerMasActividadActionListener implements ActionListener {
		
		private Actividad actividad;
		
		public void actionPerformed(ActionEvent arg0) {
			
			llenarElementosVerMas(getActividad());
			
			if (!pnlDesplegableActividadesActivas.isVisible()) {
				pnlDesplegableActividadesActivas.setVisible(true);
			}
			
			CardLayout cl = (CardLayout)(pnlDesplegableActividadesActivas.getLayout());
			cl.show(pnlDesplegableActividadesActivas, "Ver Mas");
			
		}
		
		public Actividad getActividad() {
			return this.actividad;
		}
		
		public void setActividad(Actividad actividad) {
			this.actividad = actividad;
		}
		
	}
	
	private class BtnGuardarActividadNActionListener implements ActionListener {
		private Component frame;
		public void actionPerformed(ActionEvent arg0) {
			
			if(comprobarCamposN()) {
				guardarActividadN();
			}else {
				JOptionPane.showMessageDialog(frame, "Hay campos sin rellenar o contienen valores incorrectos",
						"Custom error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	private class BtnSubirFotoActividadNActionListener implements ActionListener {
		
		private Component frame;
		private File file;
		
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
            int valorDevuelto = fcAbrir.showOpenDialog(frame);
            
            //Resizing the photo
            if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
                file = fcAbrir.getSelectedFile(); 
                setFotoActividadN(file); //Setting the image in the corresponding label
                fileFotoNuevaActividad = file; //Saving the path to the file to send it to the Employee panel
            }
		}
	}
	
	private class BtnCerrarDespActividadesActivasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pnlDesplegableActividadesActivas.setVisible(false);
		}
	}
	
	/**************************ACTIVIDADES PASADAS LISTENERS**************************/
	
	public class BtnComentariosActionListener implements ActionListener {
		
		private Actividad actividad;
		
		public void actionPerformed(ActionEvent arg0) {
			
			llenarComentarios();
			
			if (!pnlDesplegableComentarios.isVisible()) {
				pnlDesplegableComentarios.setVisible(true);
			}
	
		}
		
		public Actividad getActividad() {
			return this.actividad;
		}
		
		public void setActividad(Actividad actividad) {
			this.actividad = actividad;
		}
		
	}
		
	public class BtnCerrarDespComentariosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pnlDesplegableComentarios.setVisible(false);
		}
	}
	
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnNuevaActividadMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNuevaActividad.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnNuevaActividad.setBackground(new Color (47,198,152));
		}
	}
	
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
	
	private class BtnAtrasMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnAtras.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnAtras.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnSubirFotoActividadNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSubirFotoActividadN.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSubirFotoActividadN.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnGuardarActividadNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnGuardarActividadN.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnGuardarActividadN.setBackground(new Color (47,198,152));
		}
	}
	
	private class BtnCancelarActividadNMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarActividadN.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarActividadN.setBackground(new Color(255,71,71));
		}
	}
	
	private class BtnSalirActividadVMMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSalirActividadVM.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSalirActividadVM.setBackground(new Color(255,71,71));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	
	private void cambiarBotones (String tipo) {
		
		if (tipo.equals("ActividadesActivas")) {
			btnHistorial.setVisible(true);
			btnNuevaActividad.setVisible(true);
			btnAtras.setVisible(false);
		}
		
		if (tipo.equals("ActividadesPasadas")) {
			btnHistorial.setVisible(false);
			btnNuevaActividad.setVisible(false);
			btnAtras.setVisible(true);
		}
		
	}
	
	private void limpiarElementosNuevaActividad () {
		fileFotoNuevaActividad = null;
		lblFotoActividadN.setIcon(null);
		txtNombreActividadN.setText(null);
		txtMonitorActividadN.setText(null);
		txtDestinatarioActividadN.setText(null);
		txtPrecioPorMesActividadN.setText(null);
		dateChooser.cleanup();
		spinCupoMinimoActividadN.setValue(Integer.valueOf(0));
		spinCupoMaximoActividadN.setValue(Integer.valueOf(0));
		spinHoraInicioActividadN.setValue(Integer.valueOf(0));
		spinHoraFinActividadN.setValue(Integer.valueOf(0));
		txtaDescripcionActividadN.setText(null);
	}

	private void setFotoActividadN (File file) {
		try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoActividadN.getWidth()-35,
            lblFotoActividadN.getHeight()-35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoActividadN.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void setFotoActividadVM (File file) {
		try {
        	Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoActividadVM.getWidth()-35,
            lblFotoActividadVM.getHeight()-35, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoActividadVM.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void llenarElementosVerMas (Actividad actividad) {
		
		lblTituloNombreActividadVM.setText(actividad.getNombre());
		setFotoActividadVM(actividad.getFoto());
		lblDescripcionActividadOutVM.setText(actividad.getDescripcion());
		lblMonitorActividadOutVM.setText(actividad.getMonitor());
		lblDestinatarioActividadOutVM.setText(actividad.getDestinatario());
		lblPrecioPorMesActividadOutVM.setText(Double.toString(actividad.getPrecioPorMes()));
		lblFechaActividadOutVM.setText(new SimpleDateFormat("dd/MM/yyyy").format(actividad.getFecha()));
		lblCupoMinimoActividadOutVM.setText(Integer.toString(actividad.getCupoMinimo()));
		lblCupoMaximoActividadOutVM.setText(Integer.toString(actividad.getCupoMaximo()));
		lblHoraInicioActividadOutVM.setText(actividad.getHoraInicio());
		lblHoraFinActividadOutVM.setText(actividad.getHoraFinal());
	
	}

	private void llenarComentarios () {
		pnlListaComentarios.add(new panelComentario());
		pnlListaComentarios.add(new panelComentario());
		pnlListaComentarios.add(new panelComentario());
		pnlListaComentarios.add(new panelComentario());
		pnlListaComentarios.add(new panelComentario());
	}

	private void guardarActividadN() {
		BtnDarDeBajaActividadActionListener darDeBajaListener = new BtnDarDeBajaActividadActionListener();
		BtnVerMasActividadActionListener verMasListener = new BtnVerMasActividadActionListener();
		
		Actividad auxActividad;

		auxActividad = new Actividad(
				txtNombreActividadN.getText(),
				(Integer)spinCupoMinimoActividadN.getValue(),
				txtMonitorActividadN.getText(),
				(Integer)spinCupoMaximoActividadN.getValue(),
				Integer.toString((Integer)spinHoraInicioActividadN.getValue()),
				Integer.toString((Integer)spinHoraFinActividadN.getValue()),

				dateChooser.getDate(),
				txtaDescripcionActividadN.getText(),
				new Vector<String>(),
				fileFotoNuevaActividad,
				txtDestinatarioActividadN.getText(),
				Integer.parseInt(txtPrecioPorMesActividadN.getText()) );
		
		
		globalId++;
		identifiers.add(globalId);
		
		darDeBajaListener.setId(globalId);
		darDeBajaListener.setActividad(auxActividad);
		verMasListener.setActividad(auxActividad);
		
		pnlListaActividadesActivas.add(new panelActividad(darDeBajaListener, verMasListener, globalId));
		pnlListaActividadesActivas.repaint();
		pnlListaActividadesActivas.revalidate();
		
		 
		
		pnlDesplegableActividadesActivas.setVisible(false);
	}

	private boolean comprobarCamposN() {
		
		if (fileFotoNuevaActividad == null ||
			txtNombreActividadN.getText() == null ||
			txtMonitorActividadN.getText() == null ||
			txtDestinatarioActividadN.getText() == null ||
			txtPrecioPorMesActividadN.getText() == null ||
			dateChooser.getDate() == null ||
			(Integer) spinCupoMinimoActividadN.getValue() < 1 ||
			(Integer) spinCupoMaximoActividadN.getValue() < (Integer) spinCupoMinimoActividadN.getValue()||
			(Integer) spinHoraInicioActividadN.getValue() == 0 ||
			(Integer) spinHoraFinActividadN.getValue() == 0 ||
			txtaDescripcionActividadN.getText() == null)
			{
			
				return false;
		
			}
		return true;
	}

	private void fillExamples() {
		
		Vector<String> equipment = new Vector<String>();
		equipment.add("Ropa Comoda");
		equipment.add("Bebidas");
		equipment.add("Felicidad");
		
		Actividad exAcroYoga = new Actividad(
				"Acro-Yoga",
				10,
				"Marina Prieto",
				25,
				"12",
				"23",
				new Date(),
				"Una sesion muy rica de acro-yoga que me encanta",
				equipment,
				new File(this.getClass().getResource("/presentacion/recursos/AcroYoga.jpg").getFile()),
				"INFANTIL",
				1000.0
				);
		Actividad exAquaGym = new Actividad(
				"Aqua-Gym",
				5,
				"Sergio Silvestre",
				100,
				"14",
				"16",
				new Date(),
				"Acro-Yoga versión veranito",
				equipment,
				new File(this.getClass().getResource("/presentacion/recursos/aquaGym.jpg").getFile()),
				"ADULTOS",
				10.0
				);
		Actividad exFutbol = new Actividad(
				"Fútbol",
				14,
				"Josue Zenteno",
				22,
				"7",
				"9",
				new Date(),
				"Un furbito con los chavales",
				equipment,
				new File(this.getClass().getResource("/presentacion/recursos/Futbol.jpg").getFile()),
				"SENIOR",
				100.0
				);
		
		generateExample(exAcroYoga);
		generateExample(exAquaGym);
		generateExample(exFutbol);
	}
	
	private void generateExample(Actividad auxActividad) {
		BtnDarDeBajaActividadActionListener darDeBajaListener = new BtnDarDeBajaActividadActionListener();
		BtnVerMasActividadActionListener verMasListener = new BtnVerMasActividadActionListener();
		
		globalId++;
		identifiers.add(globalId);
		
		darDeBajaListener.setId(globalId);
		darDeBajaListener.setActividad(auxActividad);
		verMasListener.setActividad(auxActividad);
		
		pnlListaActividadesActivas.add(new panelActividad(darDeBajaListener, verMasListener, globalId));
		pnlListaActividadesActivas.repaint();
		pnlListaActividadesActivas.revalidate();
	}
}
