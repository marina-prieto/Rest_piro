package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.*;

@SuppressWarnings("serial")
public class MenuIzqRender extends DefaultTreeCellRenderer{
	public MenuIzqRender() {
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		setFont(new Font("Verdana", Font.BOLD, 20));
		setBorder(new EmptyBorder(20, 0, 20, 0));
		setBackground(new Color(42,46,49));
		setForeground(Color.WHITE);
		setTextSelectionColor(Color.ORANGE);
		setOpaque(true);
		String c = (String)(nodo.getUserObject());
	
		switch (c) {
			
			case "Estancias":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/EstanciasIconoLateral.png")));
				break;
			case "Reservas":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/ReservasIconoLateral.png")));
				break;
			case "Empleados":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/EmpleadosIconoLateral.png")));
				break;
			case "Actividades":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/ActividadesIconoLateral.png")));
				break;
			case "Rutas":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/RutasIconoLateral.png")));
				break;
			case "Especial":
				setIcon(new ImageIcon(MenuIzqRender.class.getResource("/presentacion/recursos/EspecialIconoLateral.png")));
				break;
		}
		return this;
	}
}