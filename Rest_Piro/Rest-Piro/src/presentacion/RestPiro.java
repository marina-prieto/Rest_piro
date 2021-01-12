package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import presentacion.actividades.panelActividades;
import presentacion.empleados.panelEmpleados;
import presentacion.especiales.panelEspecial;
import presentacion.estancias.panelEstancias;
import presentacion.reservas.panelReservas;
import presentacion.rutas.panelRutas;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.CardLayout;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RestPiro extends JFrame {

	private JPanel pnlOpciones;
	private JButton btnCloseApp;
	private JButton btnMinimizeApp;
	private JSplitPane splitPane;
	private JPanel panelCategoria;
	private JPanel panelesMenu;
	private JPanel pnlEstancias;
	private JPanel pnlReservas;
	private JPanel pnlEmpleados;
	private JPanel pnlActividades;
	private JPanel pnlRutas;
	private JPanel pnlEspecial;
	private JTree tree;
	private JPanel pnlDefault;
	private JLabel lblPerfilUsuario;
	private JButton btnAyuda;
	private JLabel lblIconoApp;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public RestPiro() {
		setBackground(Color.BLACK);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //TOMA DE TAMAÑO DE PANTALLA PARA ADAPTAR
	
		setTitle("Rest-piro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RestPiro.class.getResource("recursos/RestPiroIcono.png"))); //SELECCION LOGO MINIMIZAR APP
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight()); //CAMBIAR TAMAÑO DEL FRAME A TAMAÑO DE PANTALLA
		setLocationRelativeTo(null); //CENTRAR EN PANTALLA
		setUndecorated(true); 
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnlOpciones = new JPanel();
		pnlOpciones.setBackground(new Color(42,46,49));
		pnlOpciones.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		getContentPane().add(pnlOpciones, BorderLayout.NORTH);
		GridBagLayout gbl_pnlOpciones = new GridBagLayout();
		gbl_pnlOpciones.columnWidths = new int[]{0, 1440, 43, 39, 0};
		gbl_pnlOpciones.rowHeights = new int[]{21, 0};
		gbl_pnlOpciones.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlOpciones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlOpciones.setLayout(gbl_pnlOpciones);
		
		btnMinimizeApp = new JButton("__");
		btnMinimizeApp.addMouseListener(new BtnMinimizeAppMouseListener());
		btnMinimizeApp.setPreferredSize(new Dimension(75, 33));
		btnMinimizeApp.setMinimumSize(new Dimension(75, 33));
		btnMinimizeApp.setMaximumSize(new Dimension(75, 33));
		btnMinimizeApp.setBorder(null);
		btnMinimizeApp.setForeground(Color.WHITE);
		btnMinimizeApp.setBackground(new Color(218,179,17));
		btnMinimizeApp.setFont(new Font("Verdana", Font.BOLD, 15));
		btnMinimizeApp.addActionListener(new BtnMinimizeAppActionListener());
		
		lblIconoApp = new JLabel("Rest-Piro");
		lblIconoApp.setForeground(Color.WHITE);
		lblIconoApp.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblIconoApp.setIcon(new ImageIcon(RestPiro.class.getResource("/presentacion/recursos/RestPiroIcono.png")));
		GridBagConstraints gbc_lblIconoApp = new GridBagConstraints();
		gbc_lblIconoApp.insets = new Insets(0, 0, 0, 5);
		gbc_lblIconoApp.gridx = 0;
		gbc_lblIconoApp.gridy = 0;
		pnlOpciones.add(lblIconoApp, gbc_lblIconoApp);
		GridBagConstraints gbc_btnMinimizeApp = new GridBagConstraints();
		gbc_btnMinimizeApp.anchor = GridBagConstraints.EAST;
		gbc_btnMinimizeApp.insets = new Insets(0, 0, 0, 5);
		gbc_btnMinimizeApp.gridx = 2;
		gbc_btnMinimizeApp.gridy = 0;
		pnlOpciones.add(btnMinimizeApp, gbc_btnMinimizeApp);
		
		btnCloseApp = new JButton("X");
		btnCloseApp.addMouseListener(new BtnCloseAppMouseListener());
		btnCloseApp.setPreferredSize(new Dimension(75, 33));
		btnCloseApp.setMinimumSize(new Dimension(75, 33));
		btnCloseApp.setMaximumSize(new Dimension(75, 33));
		btnCloseApp.setBorder(null);
		btnCloseApp.setForeground(Color.WHITE);
		btnCloseApp.setBackground(new Color(255,71,71));
		btnCloseApp.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCloseApp.addActionListener(new BtnCloseAppActionListener());
		GridBagConstraints gbc_btnCloseApp = new GridBagConstraints();
		gbc_btnCloseApp.gridx = 3;
		gbc_btnCloseApp.gridy = 0;
		pnlOpciones.add(btnCloseApp, gbc_btnCloseApp);
		
		splitPane = new JSplitPane();
		splitPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane.setEnabled(false);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		panelCategoria = new JPanel();
		panelCategoria.setBackground(new Color(42,46,49));
		splitPane.setLeftComponent(panelCategoria);
		GridBagLayout gbl_panelCategoria = new GridBagLayout();
		gbl_panelCategoria.columnWidths = new int[] {250, 0};
		gbl_panelCategoria.rowHeights = new int[] {70, 0, 70, 0};
		gbl_panelCategoria.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelCategoria.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCategoria.setLayout(gbl_panelCategoria);
		
		tree = new JTree();
		tree.setBackground(new Color(42,46,49));
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("opciones") {
				{
					add(new DefaultMutableTreeNode("Estancias"));
					add(new DefaultMutableTreeNode("Reservas"));
					add(new DefaultMutableTreeNode("Empleados"));
					add(new DefaultMutableTreeNode("Actividades"));
					add(new DefaultMutableTreeNode("Rutas"));
					add(new DefaultMutableTreeNode("Especial"));
				}
			}
		));
		
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(new MenuIzqRender());
		
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.insets = new Insets(0, 0, 5, 0);
		gbc_tree.anchor = GridBagConstraints.NORTHWEST;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		panelCategoria.add(tree, gbc_tree);
		
		btnAyuda = new JButton("Ayuda    ");
		btnAyuda.addActionListener(new BtnAyudaActionListener());
		btnAyuda.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setBackground(new Color(42,46,49));
		btnAyuda.setIcon(new ImageIcon(RestPiro.class.getResource("/presentacion/recursos/AyudaIconoLateral.png")));
		btnAyuda.setBorder(null);
		GridBagConstraints gbc_btnAyuda = new GridBagConstraints();
		gbc_btnAyuda.anchor = GridBagConstraints.EAST;
		gbc_btnAyuda.insets = new Insets(0, 0, 5, 0);
		gbc_btnAyuda.gridx = 0;
		gbc_btnAyuda.gridy = 1;
		panelCategoria.add(btnAyuda, gbc_btnAyuda);
		
		lblPerfilUsuario = new JLabel("");
		lblPerfilUsuario.setIcon(new ImageIcon(RestPiro.class.getResource("/presentacion/recursos/PerfilIconoLateral.png")));
		lblPerfilUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_lblPerfilUsuario = new GridBagConstraints();
		gbc_lblPerfilUsuario.fill = GridBagConstraints.BOTH;
		gbc_lblPerfilUsuario.gridx = 0;
		gbc_lblPerfilUsuario.gridy = 2;
		panelCategoria.add(lblPerfilUsuario, gbc_lblPerfilUsuario);
		
		panelesMenu = new JPanel();
		
		splitPane.setRightComponent(panelesMenu);
		panelesMenu.setLayout(new CardLayout(0, 0));
		
		pnlDefault = new Presentacion();
		panelesMenu.add(pnlDefault, "Presentacion");
		
		pnlEstancias = new panelEstancias();
		panelesMenu.add(pnlEstancias, "Estancias");
		
		pnlReservas = new panelReservas();
		panelesMenu.add(pnlReservas, "Reservas");
		
		pnlEmpleados = new panelEmpleados();
		panelesMenu.add(pnlEmpleados, "Empleados");
		
		pnlActividades = new panelActividades();
		panelesMenu.add(pnlActividades, "Actividades");
		
		pnlRutas = new panelRutas();
		panelesMenu.add(pnlRutas, "Rutas");
		
		pnlEspecial = new panelEspecial();
		panelesMenu.add(pnlEspecial, "Especial");
		
	}
	
	/*********************************MAIN LISTENERS**********************************/
	
	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent e) {
			
			String nodo = (e.getPath().getLastPathComponent()).toString();
					
			switch (nodo) {
				case "Estancias":
				case "Reservas":	
				case "Empleados":	
				case "Actividades":	
				case "Rutas":	
				case "Especial":
					((CardLayout) panelesMenu.getLayout()).show(panelesMenu, nodo);
			}
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnCloseAppMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCloseApp.setBackground(new Color(255,41,41));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCloseApp.setBackground(new Color(255,71,71));
		}
	}
	
	private class BtnMinimizeAppMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnMinimizeApp.setBackground(new Color(185,153,15));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnMinimizeApp.setBackground(new Color(218,179,17));
		}
	}
	/******************************LISTENERS AUXILIARES*******************************/
	
	private class BtnCloseAppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	private class BtnMinimizeAppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setState(Frame.ICONIFIED);
		}
	}
	
	private class BtnAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) panelesMenu.getLayout()).show(panelesMenu, "Presentacion");
		}
	}
		
}
