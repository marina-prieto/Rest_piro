package presentacion.rutas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import dominio.Ruta;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class panelRutasMain extends JPanel {
	private JPanel pnlTitulo;
	private JPanel pnlContent;
	private JLabel lblTitulo;
	private JButton btnNuevo;
	private JPanel pnlInfo;
	private JPanel pnlMapa;
	private JScrollPane scrollPaneMapa;
	private JLabel lblMapa;
	private JScrollPane scrollPaneInfo;
	
	/***********************************PARAMETROS************************************/
	private JPanel pnlRutasPrincipal;
	private ActionListener mostrar_editar;
	private Vector<Ruta> vector_ruta;
	private JPanel pnlEditar;
	private int globalId = -1;
	private Vector<Integer> vID = new Vector<Integer>();

	/***********************************CONSTRUCTOR***********************************/
	public panelRutasMain(ActionListener mostrarEditar, Vector<Ruta> vRuta, JPanel pnlEditar) {
		mostrar_editar = mostrarEditar;
		vector_ruta = vRuta;
		
		setLayout(new BorderLayout(0, 0));
		
		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(31,34,40));
		add(pnlTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_pnlTitulo = new GridBagLayout();
		gbl_pnlTitulo.columnWidths = new int[]{50, 0, 0, 0, 50, 0};
		gbl_pnlTitulo.rowHeights = new int[]{30, 0, 30, 0};
		gbl_pnlTitulo.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTitulo.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTitulo.setLayout(gbl_pnlTitulo);
		
		lblTitulo = new JLabel("RUTAS DE SENDERISMO");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 46));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 1;
		pnlTitulo.add(lblTitulo, gbc_lblTitulo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(new BtnNuevoMouseListener());
		btnNuevo.setBorder(null);
		btnNuevo.setPreferredSize(new Dimension(80, 20));
		btnNuevo.setBackground(new Color(47,198,152));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.anchor = GridBagConstraints.EAST;
		gbc_btnNuevo.fill = GridBagConstraints.VERTICAL;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 3;
		gbc_btnNuevo.gridy = 1;
		pnlTitulo.add(btnNuevo, gbc_btnNuevo);
		
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
		pnlInfo.setBorder(null);
		pnlInfo.setBackground(new Color(31,34,40));
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 0;
		gbc_pnlInfo.gridy = 0;
		pnlContent.add(pnlInfo, gbc_pnlInfo);
		pnlInfo.setLayout(new BorderLayout(0, 0));
		
		scrollPaneInfo = new JScrollPane();
//		scrollPaneInfo.getVerticalScrollBar().setBackground(new Color(31,34,40));
//		scrollPaneInfo.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//		    @Override
//		    protected void configureScrollBarColors() {
//		        this.thumbColor = new Color(76,83,88);
//		    }
//		});
		scrollPaneInfo.setBorder(null);
		scrollPaneInfo.setBackground(new Color(31,34,40));
		pnlInfo.add(scrollPaneInfo, BorderLayout.CENTER);
		
		pnlRutasPrincipal = new JPanel();
		pnlRutasPrincipal.setBorder(null);
		pnlRutasPrincipal.setBackground(new Color(31,34,40));
		scrollPaneInfo.setViewportView(pnlRutasPrincipal);
		pnlRutasPrincipal.setLayout(new BoxLayout(pnlRutasPrincipal, BoxLayout.Y_AXIS));
		
		pnlMapa = new JPanel();
		pnlMapa.setBorder(null);
		pnlMapa.setBackground(new Color(31,34,40));
		GridBagConstraints gbc_pnlMapa = new GridBagConstraints();
		gbc_pnlMapa.fill = GridBagConstraints.BOTH;
		gbc_pnlMapa.gridx = 1;
		gbc_pnlMapa.gridy = 0;
		pnlContent.add(pnlMapa, gbc_pnlMapa);
		pnlMapa.setLayout(new BorderLayout(0, 0));
		
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
		pnlMapa.add(scrollPaneMapa, BorderLayout.CENTER);
		
		lblMapa = new MiAreaDibujo();
		lblMapa.setBackground(new Color(31,34,40));
		lblMapa.setIcon(new ImageIcon(panelRutasEditar.class.getResource("/presentacion/recursos/mapa.png")));
		scrollPaneMapa.setViewportView(lblMapa);

	}

	/***********************************LISTENERS***********************************/
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((panelRutasEditar) pnlEditar).setGuardar_info(new GuardarInfo());
			
			((panelRutasEditar) pnlEditar).getTxtNombre().setText(null);
			((panelRutasEditar) pnlEditar).getTxtMonitor().setText(null);
			((panelRutasEditar) pnlEditar).getDateChooser().cleanup();
			((panelRutasEditar) pnlEditar).getSpinCupoMin().setValue(1);
			((panelRutasEditar) pnlEditar).getSpinCupoMax().setValue(1);
			((panelRutasEditar) pnlEditar).getTxtHoraInicio().setText(null);
			((panelRutasEditar) pnlEditar).getTxtHoraFinal().setText(null);
			((panelRutasEditar) pnlEditar).getSpinDificultad().setValue(0);
			((panelRutasEditar) pnlEditar).getTxtPuntoEncuentro().setText(null);
			((panelRutasEditar) pnlEditar).getTaDescripcion().setText(null);
			
			mostrar_editar.actionPerformed(arg0);
		}
	}
	
	public class GuardarInfo implements ActionListener {
		private MiAreaDibujo auxMapa;
		
		public MiAreaDibujo getAuxMapa() {
			return auxMapa;
		}

		public void setAuxMapa(MiAreaDibujo auxMapa) {
			this.auxMapa = auxMapa;
		}

		public void actionPerformed(ActionEvent arg0) {
			pnlRutasPrincipal.add(new panelRutasPrincipal(mostrar_editar, new GuardarInfo(), pnlEditar, new DarDeBaja()));
			pnlRutasPrincipal.repaint();
			pnlRutasPrincipal.revalidate();
			
			panelRutasPrincipal principal = (panelRutasPrincipal) pnlRutasPrincipal.getComponent(pnlRutasPrincipal.getComponentCount()-1);
			
			/*configurar el id para despues poder eliminar el panel correspondiente*/
			setGlobalId(globalId+1);
			principal.setParticularId(getGlobalId());
			vID.add(principal.getParticularId());
			
			principal.getLblNombre().setText(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getNombre());
			principal.getLblMonitorInfo().setText(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getMonitor());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        String fechaString = formato.format(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getFecha());
			principal.getLblDiaInfo().setText(fechaString);
			principal.getLblDificultadInfo().setText(String.valueOf(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getDificultad()));
			principal.getLblPuntoEncuentroInfo().setText(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getPuntoDeEncuentro());
			String horario = vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getHoraInicio() + " - " 
					+ vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getHoraFinal();
			principal.getLblDuracionInfo().setText(horario);
			String cupo = vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getCupoMinimo() + " - " 
					+ vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getCupoMaximo();
			principal.getLblCupoInfo().setText(cupo);
			principal.getTaDescripcion().setText(vector_ruta.elementAt(pnlRutasPrincipal.getComponentCount()-1).getDescripcion());
			
			//configurar contenido del mapa
			ArrayList<ObjetoGrafico> objetosGraficos = getAuxMapa().getObjetosGraficos();
			for (int i = 0; i < objetosGraficos.size(); i++) {
				ObjetoGrafico objg = objetosGraficos.get(i);
				((MiAreaDibujo) lblMapa).addObjetoGrafico(objg);
				lblMapa.repaint();
			}
		}
	}
	
	public class DarDeBaja implements ActionListener {
		int auxID;
		
		public void actionPerformed(ActionEvent arg0) {
			if (pnlRutasPrincipal.getComponentCount()>=1)
			{
				int position = vID.indexOf(getAuxID());
				pnlRutasPrincipal.remove(pnlRutasPrincipal.getComponent(position));
				vector_ruta.remove(position);
				vID.remove(position);
				pnlRutasPrincipal.repaint();
				pnlRutasPrincipal.revalidate();
			}
		}
		
		public int getAuxID() {
			return this.auxID;
		}
		
		public void setAuxID(int id) {
			this.auxID = id;
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
	
	/*******************************GETTERS & SETTERS********************************/
	public JPanel getPnlEditar() {
		return pnlEditar;
	}

	public void setPnlEditar(JPanel pnlEditar) {
		this.pnlEditar = pnlEditar;
	}

	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}

}
