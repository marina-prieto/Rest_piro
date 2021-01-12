package presentacion.rutas;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import dominio.Ruta;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;


@SuppressWarnings("serial")
public class panelRutas extends JPanel {
	private JPanel pnlCard;
	private JPanel pnlMain;
	private JPanel pnlEditar;
	
	/***********************************PARAMETROS************************************/
	private Vector<Ruta> vRuta = new Vector<Ruta>();

	/***********************************CONSTRUCTOR***********************************/
	public panelRutas() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		pnlCard = new JPanel();
		pnlCard.setBackground(new Color(31,34,40));
		add(pnlCard, BorderLayout.CENTER);
		pnlCard.setLayout(new CardLayout(0, 0));
		
		pnlMain = new panelRutasMain(new MostrarEditar(), vRuta, new JPanel());
		pnlCard.add(pnlMain, "panelRutasMain");
		
		pnlEditar = new panelRutasEditar(new MostrarMain(), vRuta, null, null);
		pnlCard.add(pnlEditar, "panelRutasEditar");
		
		((CardLayout) pnlCard.getLayout()).show(pnlCard, "panelRutasMain");
		
		((panelRutasMain) pnlMain).setPnlEditar(pnlEditar);//para poder guardar

	}
	
	/***********************************LISTENERS***********************************/
	private class MostrarMain implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) pnlCard.getLayout()).show(pnlCard, "panelRutasMain");
		}
	}
	
	private class MostrarEditar implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) pnlCard.getLayout()).show(pnlCard, "panelRutasEditar");
		}
	}
}
