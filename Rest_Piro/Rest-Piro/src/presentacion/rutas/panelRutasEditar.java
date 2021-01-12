package presentacion.rutas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dominio.Ruta;
import presentacion.rutas.panelRutasMain.DarDeBaja;
import presentacion.rutas.panelRutasMain.GuardarInfo;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings({"serial","unused"})
public class panelRutasEditar extends JPanel {
	private JPanel pnlTitulo;
	private JPanel pnlContent;
	private JPanel pnlInfo;
	private JPanel pnlMapa;
	private JPanel pnlMenu;
	private JPanel pnlMapaDibujo;
	private JButton btnAtras;
	private JLabel lblRutas;
	private JScrollPane scrollPaneMapa;
	private JLabel lblMapa;
	private JLabel lblNombre;
	private JLabel lblMonitor;
	private JLabel lblDia;
	private JLabel lblCupoMin;
	private JLabel lblcupoMax;
	private JLabel lblHoraInicio;
	private JLabel lblDificultad;
	private JLabel lblPuntoEncuentro;
	private JTextField txtPuntoEncuentro;
	private JScrollPane scrollPaneDescripcion;
	private JTextArea taDescripcion;
	private JButton btnGuardar;
	private JTextField txtMonitor;
	private JSpinner spinCupoMin;
	private JSpinner spinCupoMax;
	private JSpinner spinDificultad;
	private JTextField txtHoraInicio;
	private JTextField txtNombre;
	private JLabel lblHoraFinal;
	private JTextField txtHoraFinal;
	private JToolBar tbBarraHerramientas;
	private JButton btnEscribir;
	private JButton btnDescanso;
	private JButton btnPunto;
	private JDateChooser dateChooser;
	
	/***********************************PARAMETROS************************************/
	private ActionListener mostrar_main_listen;
	private GuardarInfo guardar_info_listen;
	private Component frame;
	private Ruta ruta;
	private Vector<Ruta> vector_ruta;
	private DarDeBaja dar_de_baja_listen;
	private int editingId;
	private boolean editar;

	private MiAreaDibujo miAreaDibujo;
	int modo = -1;
	private final int TEXTO = 1;
	private final int DESCANSO = 2;
	private final int PUNTO= 3;
	private Toolkit toolkit;
	private Image imagTexto;
	private Image imagDescanso;
	private Image imagPunto;
	private int x;
	private int y;
	private JTextField txtTexto = new JTextField();

	/***********************************CONSTRUCTOR***********************************/
	public panelRutasEditar(ActionListener mostrarMain, Vector<Ruta> vRuta, GuardarInfo guardarInfo, DarDeBaja darDeBaja) {
		mostrar_main_listen = mostrarMain;
		vector_ruta = vRuta;
		guardar_info_listen = guardarInfo;
		dar_de_baja_listen = darDeBaja;
		
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(31,34,40));
		
		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(31,34,40));
		add(pnlTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_pnlTitulo = new GridBagLayout();
		gbl_pnlTitulo.columnWidths = new int[]{50, 0, 0, 0, 50, 0};
		gbl_pnlTitulo.rowHeights = new int[]{30, 0, 30, 0};
		gbl_pnlTitulo.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTitulo.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTitulo.setLayout(gbl_pnlTitulo);
		
		lblRutas = new JLabel("RUTAS DE SENDERISMO");
		lblRutas.setForeground(Color.WHITE);
		lblRutas.setFont(new Font("Verdana", Font.BOLD, 46));
		GridBagConstraints gbc_lblRutas = new GridBagConstraints();
		gbc_lblRutas.insets = new Insets(0, 0, 5, 5);
		gbc_lblRutas.gridx = 1;
		gbc_lblRutas.gridy = 1;
		pnlTitulo.add(lblRutas, gbc_lblRutas);
		
		btnAtras = new JButton("Atrás");
		btnAtras.addMouseListener(new BtnAtrasMouseListener());
		btnAtras.setPreferredSize(new Dimension(80, 20));
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(0,120,210));
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.addActionListener(new BtnAtrasActionListener());
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.anchor = GridBagConstraints.EAST;
		gbc_btnAtras.fill = GridBagConstraints.VERTICAL;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 3;
		gbc_btnAtras.gridy = 1;
		pnlTitulo.add(btnAtras, gbc_btnAtras);
		
		pnlContent = new JPanel();
		pnlContent.setBorder(null);
		pnlContent.setBackground(new Color(31,34,40));
		add(pnlContent, BorderLayout.CENTER);
		GridBagLayout gbl_pnlContent = new GridBagLayout();
		gbl_pnlContent.columnWidths = new int[]{775, 0};
		gbl_pnlContent.rowHeights = new int[]{0, 0};
		gbl_pnlContent.columnWeights = new double[]{0.0, 1.0};
		gbl_pnlContent.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlContent.setLayout(gbl_pnlContent);
		
		pnlInfo = new JPanel();
		pnlInfo.setBackground(new Color(31,34,40));
		pnlInfo.setBorder(null);
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 0;
		gbc_pnlInfo.gridy = 0;
		pnlContent.add(pnlInfo, gbc_pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[]{15, 0, 100, 0, 0, 0, 0, 0, 15};
		gbl_pnlInfo.rowHeights = new int[]{15, 40, 30, 30, 30, 30, 0, 30, 30, 30, 15, 100, 100, 15, 33, 15};
		gbl_pnlInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0};
		gbl_pnlInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pnlInfo.setLayout(gbl_pnlInfo);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		pnlInfo.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setCaretColor(Color.WHITE);
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 10));
		txtNombre.setBackground(Color.DARK_GRAY);
		txtNombre.setForeground(Color.WHITE);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		pnlInfo.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblMonitor = new JLabel("Monitor: ");
		lblMonitor.setForeground(Color.WHITE);
		lblMonitor.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 1;
		gbc_lblMonitor.gridy = 2;
		pnlInfo.add(lblMonitor, gbc_lblMonitor);
		
		txtMonitor = new JTextField();
		txtMonitor.setCaretColor(Color.WHITE);
		txtMonitor.setBackground(Color.DARK_GRAY);
		txtMonitor.setForeground(Color.WHITE);
		txtMonitor.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_txtMonitor = new GridBagConstraints();
		gbc_txtMonitor.gridwidth = 3;
		gbc_txtMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_txtMonitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonitor.gridx = 2;
		gbc_txtMonitor.gridy = 2;
		pnlInfo.add(txtMonitor, gbc_txtMonitor);
		txtMonitor.setColumns(10);
		
		lblPuntoEncuentro = new JLabel("Punto de encuentro: ");
		lblPuntoEncuentro.setForeground(Color.WHITE);
		lblPuntoEncuentro.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPuntoEncuentro = new GridBagConstraints();
		gbc_lblPuntoEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblPuntoEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntoEncuentro.gridx = 1;
		gbc_lblPuntoEncuentro.gridy = 3;
		pnlInfo.add(lblPuntoEncuentro, gbc_lblPuntoEncuentro);
		
		txtPuntoEncuentro = new JTextField();
		txtPuntoEncuentro.setCaretColor(Color.WHITE);
		txtPuntoEncuentro.setFont(new Font("Verdana", Font.PLAIN, 10));
		txtPuntoEncuentro.setBackground(Color.DARK_GRAY);
		txtPuntoEncuentro.setForeground(Color.WHITE);
		GridBagConstraints gbc_txtPuntoEncuentro = new GridBagConstraints();
		gbc_txtPuntoEncuentro.gridwidth = 3;
		gbc_txtPuntoEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_txtPuntoEncuentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPuntoEncuentro.gridx = 2;
		gbc_txtPuntoEncuentro.gridy = 3;
		pnlInfo.add(txtPuntoEncuentro, gbc_txtPuntoEncuentro);
		txtPuntoEncuentro.setColumns(10);
		
		lblHoraInicio = new JLabel("Hora de inicio: ");
		lblHoraInicio.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblHoraInicio.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHoraInicio = new GridBagConstraints();
		gbc_lblHoraInicio.anchor = GridBagConstraints.EAST;
		gbc_lblHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicio.gridx = 1;
		gbc_lblHoraInicio.gridy = 4;
		pnlInfo.add(lblHoraInicio, gbc_lblHoraInicio);
		
		MaskFormatter formatoHoraInicio;
		try {
			formatoHoraInicio = new MaskFormatter("##':##");
			formatoHoraInicio.setPlaceholderCharacter('X');
			txtHoraInicio = new JFormattedTextField(formatoHoraInicio);
			txtHoraInicio.setCaretColor(Color.WHITE);
			txtHoraInicio.setBackground(Color.DARK_GRAY);
			txtHoraInicio.setFont(new Font("Verdana", Font.PLAIN, 10));
			txtHoraInicio.setForeground(Color.WHITE);
			txtHoraInicio.setText("HH:MM");
			GridBagConstraints gbc_txtHoraInicio = new GridBagConstraints();
			gbc_txtHoraInicio.insets = new Insets(0, 0, 5, 5);
			gbc_txtHoraInicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHoraInicio.gridx = 2;
			gbc_txtHoraInicio.gridy = 4;
			pnlInfo.add(txtHoraInicio, gbc_txtHoraInicio);
			txtHoraInicio.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lblHoraFinal = new JLabel("Hora de finalización: ");
		lblHoraFinal.setForeground(Color.WHITE);
		lblHoraFinal.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHoraFinal = new GridBagConstraints();
		gbc_lblHoraFinal.anchor = GridBagConstraints.EAST;
		gbc_lblHoraFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFinal.gridx = 1;
		gbc_lblHoraFinal.gridy = 5;
		pnlInfo.add(lblHoraFinal, gbc_lblHoraFinal);
		
		MaskFormatter formatoHoraFinal;
		try {
			formatoHoraFinal = new MaskFormatter("##':##");
			formatoHoraFinal.setPlaceholderCharacter('X');
			txtHoraFinal = new JFormattedTextField(formatoHoraFinal);
			txtHoraFinal.setCaretColor(Color.WHITE);
			txtHoraFinal.setForeground(Color.WHITE);
			txtHoraFinal.setFont(new Font("Verdana", Font.PLAIN, 10));
			txtHoraFinal.setBackground(Color.DARK_GRAY);
			txtHoraFinal.setText("HH:MM");
			GridBagConstraints gbc_txtHoraFinal = new GridBagConstraints();
			gbc_txtHoraFinal.insets = new Insets(0, 0, 5, 5);
			gbc_txtHoraFinal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHoraFinal.gridx = 2;
			gbc_txtHoraFinal.gridy = 5;
			pnlInfo.add(txtHoraFinal, gbc_txtHoraFinal);
			txtHoraFinal.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		lblDia = new JLabel("Día: ");
		lblDia.setForeground(Color.WHITE);
		lblDia.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 1;
		gbc_lblDia.gridy = 6;
		pnlInfo.add(lblDia, gbc_lblDia);
		
		dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.anchor = GridBagConstraints.WEST;
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 6;
		pnlInfo.add(dateChooser, gbc_dateChooser);
		
		lblCupoMin = new JLabel("Cupo mínimo: ");
		lblCupoMin.setForeground(Color.WHITE);
		lblCupoMin.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCupoMin = new GridBagConstraints();
		gbc_lblCupoMin.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMin.gridx = 1;
		gbc_lblCupoMin.gridy = 7;
		pnlInfo.add(lblCupoMin, gbc_lblCupoMin);
		
		spinCupoMin = new JSpinner();
		spinCupoMin.setForeground(Color.WHITE);
		spinCupoMin.setBackground(Color.DARK_GRAY);
		spinCupoMin.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		GridBagConstraints gbc_spinCupoMin = new GridBagConstraints();
		gbc_spinCupoMin.anchor = GridBagConstraints.WEST;
		gbc_spinCupoMin.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupoMin.gridx = 2;
		gbc_spinCupoMin.gridy = 7;
		pnlInfo.add(spinCupoMin, gbc_spinCupoMin);
		
		lblcupoMax = new JLabel("Cupo máximo: ");
		lblcupoMax.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblcupoMax.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblcupoMax = new GridBagConstraints();
		gbc_lblcupoMax.anchor = GridBagConstraints.EAST;
		gbc_lblcupoMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblcupoMax.gridx = 1;
		gbc_lblcupoMax.gridy = 8;
		pnlInfo.add(lblcupoMax, gbc_lblcupoMax);
		
		spinCupoMax = new JSpinner();
		spinCupoMax.setForeground(Color.WHITE);
		spinCupoMax.setBackground(Color.DARK_GRAY);
		spinCupoMax.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		GridBagConstraints gbc_spinCupoMax = new GridBagConstraints();
		gbc_spinCupoMax.anchor = GridBagConstraints.WEST;
		gbc_spinCupoMax.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupoMax.gridx = 2;
		gbc_spinCupoMax.gridy = 8;
		pnlInfo.add(spinCupoMax, gbc_spinCupoMax);
		
		lblDificultad = new JLabel("Dificultad: ");
		lblDificultad.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDificultad.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 9;
		pnlInfo.add(lblDificultad, gbc_lblDificultad);
		
		spinDificultad = new JSpinner();
		spinDificultad.setForeground(Color.WHITE);
		spinDificultad.setBackground(Color.DARK_GRAY);
		spinDificultad.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spinDificultad = new GridBagConstraints();
		gbc_spinDificultad.anchor = GridBagConstraints.WEST;
		gbc_spinDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_spinDificultad.gridx = 2;
		gbc_spinDificultad.gridy = 9;
		pnlInfo.add(spinDificultad, gbc_spinDificultad);
		
		scrollPaneDescripcion = new JScrollPane();
//		scrollPaneDescripcion.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneDescripcion.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPaneDescripcion.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcion.setForeground(Color.WHITE);
		scrollPaneDescripcion.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GridBagConstraints gbc_scrollPaneDescripcion = new GridBagConstraints();
		gbc_scrollPaneDescripcion.gridheight = 3;
		gbc_scrollPaneDescripcion.gridwidth = 7;
		gbc_scrollPaneDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneDescripcion.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDescripcion.gridx = 1;
		gbc_scrollPaneDescripcion.gridy = 11;
		pnlInfo.add(scrollPaneDescripcion, gbc_scrollPaneDescripcion);
		
		taDescripcion = new JTextArea();
		taDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		taDescripcion.setCaretColor(Color.WHITE);
		taDescripcion.setForeground(Color.WHITE);
		taDescripcion.setBackground(Color.DARK_GRAY);
		scrollPaneDescripcion.setViewportView(taDescripcion);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new BtnGuardarMouseListener());
		btnGuardar.setBackground(new Color(47,198,152));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setPreferredSize(new Dimension(71, 33));
		btnGuardar.setBorder(null);
		btnGuardar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.VERTICAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 15;
		pnlInfo.add(btnGuardar, gbc_btnGuardar);
		
		pnlMapa = new JPanel();
		pnlMapa.setBackground(new Color(31,34,40));
		pnlMapa.setBorder(null);
		GridBagConstraints gbc_pnlMapa = new GridBagConstraints();
		gbc_pnlMapa.fill = GridBagConstraints.BOTH;
		gbc_pnlMapa.gridx = 1;
		gbc_pnlMapa.gridy = 0;
		pnlContent.add(pnlMapa, gbc_pnlMapa);
		pnlMapa.setLayout(new BorderLayout(0, 0));
		
		pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(31,34,40));
		pnlMenu.setForeground(Color.WHITE);
		pnlMenu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Herramientas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnlMapa.add(pnlMenu, BorderLayout.NORTH);
		pnlMenu.setLayout(new BorderLayout(0, 0));
		
		tbBarraHerramientas = new JToolBar();
		tbBarraHerramientas.setBackground(new Color(31,34,40));
		pnlMenu.add(tbBarraHerramientas, BorderLayout.CENTER);
		
		toolkit = Toolkit.getDefaultToolkit();
		imagTexto =
		toolkit.getImage(getClass().getClassLoader().getResource("presentacion/recursos/leter-a-inside-a-black-circle.png"));
		imagDescanso =
		toolkit.getImage(getClass().getClassLoader().getResource("presentacion/recursos/shop.png"));
		imagPunto =
		toolkit.getImage(getClass().getClassLoader().getResource("presentacion/recursos/placeholder.png"));
		
		btnEscribir = new JButton("");
		btnEscribir.setForeground(Color.WHITE);
		btnEscribir.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnEscribir.addMouseListener(new BtnEscribirMouseListener());
		btnEscribir.setBackground(Color.GRAY);
		btnEscribir.addActionListener(new BtnEscribirActionListener());
		btnEscribir.setIcon(new ImageIcon(panelRutasEditar.class.getResource("/presentacion/recursos/leter-a-inside-a-black-circle.png")));
		tbBarraHerramientas.add(btnEscribir);
		
		btnDescanso = new JButton("");
		btnDescanso.setForeground(Color.WHITE);
		btnDescanso.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnDescanso.addMouseListener(new BtnDescansoMouseListener());
		btnDescanso.setBackground(Color.GRAY);
		btnDescanso.addActionListener(new BtnDescansoActionListener());
		btnDescanso.setIcon(new ImageIcon(panelRutasEditar.class.getResource("/presentacion/recursos/shop.png")));
		tbBarraHerramientas.add(btnDescanso);
		
		btnPunto = new JButton("");
		btnPunto.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnPunto.setForeground(Color.WHITE);
		btnPunto.addMouseListener(new BtnPuntoMouseListener());
		btnPunto.setBackground(Color.GRAY);
		btnPunto.addActionListener(new BtnPuntoActionListener());
		btnPunto.setIcon(new ImageIcon(panelRutasEditar.class.getResource("/presentacion/recursos/placeholder.png")));
		tbBarraHerramientas.add(btnPunto);
		
		pnlMapaDibujo = new JPanel();
		pnlMapaDibujo.setBackground(new Color(31,34,40));
		pnlMapa.add(pnlMapaDibujo, BorderLayout.CENTER);
		pnlMapaDibujo.setLayout(new BorderLayout(0, 0));
		
		scrollPaneMapa = new JScrollPane();
//		scrollPaneMapa.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneMapa.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
//		scrollPaneMapa.getHorizontalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneMapa.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		
		scrollPaneMapa.setBackground(new Color(31,34,40));
		pnlMapaDibujo.add(scrollPaneMapa, BorderLayout.CENTER);
		
		lblMapa = new MiAreaDibujo();
		lblMapa.setBackground(new Color(31,34,40));
		lblMapa.addMouseListener(new LblMapaMouseListener());
		lblMapa.setIcon(new ImageIcon(panelRutasEditar.class.getResource("/presentacion/recursos/mapa.png")));
		scrollPaneMapa.setViewportView(lblMapa);
	}
	
	/***********************************LISTENERS***********************************/
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			setEditar(false);
			mostrar_main_listen.actionPerformed(arg0);
		}
	}
	
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if((Integer)spinCupoMin.getValue() <= (Integer)spinCupoMax.getValue()) {					
				if(isEditar()) {//si estamos editando un panel
					
					dar_de_baja_listen.setAuxID(getEditingId());
					int option = JOptionPane.showConfirmDialog(frame, "¿Estás seguro que quieres sobreescribir esta ruta?", 
							"Editar Ruta", JOptionPane.OK_CANCEL_OPTION);
					if (0 == option) {
						if(comprobarCamposLlenos()) {
							setEditar(false);
							crearPanel(arg0);
							dar_de_baja_listen.actionPerformed(arg0);
						}else {
							JOptionPane.showMessageDialog(frame, "Algún campo no se ha rellenado.", "Campos", JOptionPane.ERROR_MESSAGE);
						}	
					}
					
				}else {
					if(comprobarCamposLlenos()) {
						crearPanel(arg0);
					}else {
						JOptionPane.showMessageDialog(frame, "Algún campo no se ha rellenado.", "Campos", JOptionPane.ERROR_MESSAGE);
					}
				}
				
	        }else {
	        	JOptionPane.showMessageDialog(frame, "El cupo máximo debe ser mayor que el cupo mínimo.", "Cupos", JOptionPane.ERROR_MESSAGE);
	        }
		}
	}
	
	/***********************************LISTENERS MAPA***********************************/
	private class BtnEscribirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = TEXTO;
		}
	}
	
	private class BtnDescansoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = DESCANSO;
		}
	}
	
	private class BtnPuntoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = PUNTO;
		}
	}
	
	private class LblMapaMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			switch (modo)
			{
				case TEXTO:
					txtTexto.setBounds(x, y, 200,30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg) {
							if(!txtTexto.getText().equals(""))
							((MiAreaDibujo) lblMapa).addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(),Color.WHITE));
							txtTexto.setText("");
							txtTexto.setVisible(false);
							lblMapa.repaint();
						}
					});
					lblMapa.add(txtTexto);
					break;
				case DESCANSO:
					((MiAreaDibujo) lblMapa).addObjetoGrafico(new ImagenGrafico(x,y,imagDescanso));
					lblMapa.repaint();
					break;
				case PUNTO:
					((MiAreaDibujo) lblMapa).addObjetoGrafico(new ImagenGrafico(x,y,imagPunto));
					lblMapa.repaint();
					break;
			}
		}
	}
	
	private class BtnEscribirMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEscribir.setText("Escribir un comentario");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEscribir.setText(null);
		}
	}
	
	private class BtnDescansoMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnDescanso.setText("Añadir punto de descanso");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnDescanso.setText(null);
		}
	}
	
	private class BtnPuntoMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnPunto.setText("Añadir punto de interés");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnPunto.setText(null);
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	private class BtnGuardarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnGuardar.setBackground(new Color (41,173,132));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnGuardar.setBackground(new Color (47,198,152));
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
	
	/*******************************METODOS AUXILIARES********************************/
	public void crearPanel(ActionEvent arg0) {
		ruta = new Ruta(txtNombre.getText(), (Integer)spinCupoMin.getValue(), txtMonitor.getText(), 
				(Integer)spinCupoMax.getValue(), txtHoraInicio.getText(), txtHoraFinal.getText(), dateChooser.getDate(), taDescripcion.getText(),
				null, null, txtPuntoEncuentro.getText(), (Integer)spinDificultad.getValue());
		vector_ruta.add(ruta);
		
		guardar_info_listen.setAuxMapa((MiAreaDibujo) lblMapa);
		guardar_info_listen.actionPerformed(arg0);
		mostrar_main_listen.actionPerformed(arg0);
	}
	
	private boolean comprobarCamposLlenos() {
		if (txtNombre.getText() == null ||
			txtMonitor.getText() == null ||
			txtHoraInicio.getText() == null ||
			txtHoraInicio.getText() == "XX:XX" ||
			txtHoraFinal.getText() == null ||
			txtHoraFinal.getText() == "XX:XX" ||
			dateChooser.getDate() == null ||
			taDescripcion.getText() == null ||
			txtPuntoEncuentro.getText() == null ||
			taDescripcion.getText() == null)
			{
				return false;
			}
		
		return true;
	}
	
	/*******************************GETTERS & SETTERS********************************/
	public JTextField getTxtPuntoEncuentro() {
		return txtPuntoEncuentro;
	}

	public void setTxtPuntoEncuentro(JTextField txtPuntoEncuentro) {
		this.txtPuntoEncuentro = txtPuntoEncuentro;
	}

	public JTextArea getTaDescripcion() {
		return taDescripcion;
	}

	public void setTaDescripcion(JTextArea taDescripcion) {
		this.taDescripcion = taDescripcion;
	}

	public JTextField getTxtMonitor() {
		return txtMonitor;
	}

	public void setTxtMonitor(JTextField txtMonitor) {
		this.txtMonitor = txtMonitor;
	}

	public JSpinner getSpinCupoMin() {
		return spinCupoMin;
	}

	public void setSpinCupoMin(JSpinner spinCupoMin) {
		this.spinCupoMin = spinCupoMin;
	}

	public JSpinner getSpinCupoMax() {
		return spinCupoMax;
	}

	public void setSpinCupoMax(JSpinner spinCupoMax) {
		this.spinCupoMax = spinCupoMax;
	}

	public JSpinner getSpinDificultad() {
		return spinDificultad;
	}

	public void setSpinDificultad(JSpinner spinDificultad) {
		this.spinDificultad = spinDificultad;
	}

	public JTextField getTxtHoraInicio() {
		return txtHoraInicio;
	}

	public void setTxtHoraInicio(JTextField txtHoraInicio) {
		this.txtHoraInicio = txtHoraInicio;
	}

	public JTextField getTxtHoraFinal() {
		return txtHoraFinal;
	}

	public void setTxtHoraFinal(JTextField txtHoraFinal) {
		this.txtHoraFinal = txtHoraFinal;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public GuardarInfo getGuardar_info() {
		return guardar_info_listen;
	}
	
	public void setGuardar_info(GuardarInfo guardar_info) {
		this.guardar_info_listen = guardar_info;
	}

	public DarDeBaja getDar_de_baja_listen() {
		return dar_de_baja_listen;
	}

	public void setDar_de_baja_listen(DarDeBaja dar_de_baja_listen) {
		this.dar_de_baja_listen = dar_de_baja_listen;
	}
	
	public int getEditingId() {
		return editingId;
	}

	public void setEditingId(int editingId) {
		this.editingId = editingId;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public JLabel getLblMapa() {
		return lblMapa;
	}

	public void setLblMapa(JLabel lblMapa) {
		this.lblMapa = lblMapa;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
		
}
