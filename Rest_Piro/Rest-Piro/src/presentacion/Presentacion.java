package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Presentacion extends JPanel {
	private JLabel infoEstancias;
	private JLabel infoReservas;
	private JLabel infoEmpleados;
	private JLabel infoActividades;
	private JLabel infoRutas;
	private JLabel infoOfertas;

	public Presentacion() {
		
		setBackground(new Color(31,34,40));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		infoEstancias = new JLabel("  Consulte las estancias actuales y estado");
		infoEstancias.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoEstancias.setBorder(new EmptyBorder(25, 30, 25, 0));
		infoEstancias.setForeground(Color.WHITE);
		infoEstancias.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_infoEstancias = new GridBagConstraints();
		gbc_infoEstancias.anchor = GridBagConstraints.WEST;
		gbc_infoEstancias.insets = new Insets(0, 0, 5, 0);
		gbc_infoEstancias.gridx = 0;
		gbc_infoEstancias.gridy = 0;
		add(infoEstancias, gbc_infoEstancias);
		
		infoReservas = new JLabel("  Vea las reservas realizadas e historial");
		infoReservas.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoReservas.setForeground(Color.WHITE);
		infoReservas.setFont(new Font("Verdana", Font.BOLD, 20));
		infoReservas.setBorder(new EmptyBorder(20, 30, 25, 0));
		GridBagConstraints gbc_infoReservas = new GridBagConstraints();
		gbc_infoReservas.anchor = GridBagConstraints.WEST;
		gbc_infoReservas.insets = new Insets(0, 0, 5, 0);
		gbc_infoReservas.gridx = 0;
		gbc_infoReservas.gridy = 1;
		add(infoReservas, gbc_infoReservas);
		
		infoEmpleados = new JLabel("  Consulte y actualice información de empleados");
		infoEmpleados.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoEmpleados.setForeground(Color.WHITE);
		infoEmpleados.setFont(new Font("Verdana", Font.BOLD, 20));
		infoEmpleados.setBorder(new EmptyBorder(25, 30, 25, 0));
		GridBagConstraints gbc_infoEmpleados = new GridBagConstraints();
		gbc_infoEmpleados.anchor = GridBagConstraints.WEST;
		gbc_infoEmpleados.insets = new Insets(0, 0, 5, 0);
		gbc_infoEmpleados.gridx = 0;
		gbc_infoEmpleados.gridy = 2;
		add(infoEmpleados, gbc_infoEmpleados);
		
		infoActividades = new JLabel("  Compruebe las actividades de temporada");
		infoActividades.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoActividades.setForeground(Color.WHITE);
		infoActividades.setFont(new Font("Verdana", Font.BOLD, 20));
		infoActividades.setBorder(new EmptyBorder(20, 30, 25, 0));
		GridBagConstraints gbc_infoActividades = new GridBagConstraints();
		gbc_infoActividades.anchor = GridBagConstraints.WEST;
		gbc_infoActividades.insets = new Insets(0, 0, 5, 0);
		gbc_infoActividades.gridx = 0;
		gbc_infoActividades.gridy = 3;
		add(infoActividades, gbc_infoActividades);
		
		infoRutas = new JLabel("  Organice y edite rutas de senderismo");
		infoRutas.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoRutas.setForeground(Color.WHITE);
		infoRutas.setFont(new Font("Verdana", Font.BOLD, 20));
		infoRutas.setBorder(new EmptyBorder(20, 30, 25, 0));
		GridBagConstraints gbc_infoRutas = new GridBagConstraints();
		gbc_infoRutas.anchor = GridBagConstraints.WEST;
		gbc_infoRutas.insets = new Insets(0, 0, 5, 0);
		gbc_infoRutas.gridx = 0;
		gbc_infoRutas.gridy = 4;
		add(infoRutas, gbc_infoRutas);
		
		infoOfertas = new JLabel("  Consulte ofertas actuales del recinto");
		infoOfertas.setIcon(new ImageIcon(Presentacion.class.getResource("/presentacion/recursos/flecha.png")));
		infoOfertas.setForeground(Color.WHITE);
		infoOfertas.setFont(new Font("Verdana", Font.BOLD, 20));
		infoOfertas.setBorder(new EmptyBorder(25, 30, 0, 0));
		GridBagConstraints gbc_infoOfertas = new GridBagConstraints();
		gbc_infoOfertas.anchor = GridBagConstraints.WEST;
		gbc_infoOfertas.gridx = 0;
		gbc_infoOfertas.gridy = 5;
		add(infoOfertas, gbc_infoOfertas);

	}

}
