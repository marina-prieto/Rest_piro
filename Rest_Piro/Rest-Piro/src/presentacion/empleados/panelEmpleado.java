package presentacion.empleados;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import presentacion.empleados.panelEmpleados.BtnDarDeBajaEmpleadoListener;
import presentacion.empleados.panelEmpleados.BtnEditarEmpleadoActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings({ "serial" })
public class panelEmpleado extends JPanel {
	private JPanel pnlInformacion;
	private JLabel lblFotoEmpleado;
	private JPanel pnlBotones;
	private JButton btnEditar;
	private JLabel lblNombreApellidos;
	private JLabel lblFormacionOut;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblIdiomas;
	private JLabel lblTelefonoOut;
	private JLabel lblCorreoOut;
	private JLabel lblIdiomasOut;
	private JLabel lblHorario;
	private JLabel lblHorarioOut;
	private JLabel lblFormacion;
	private JButton btnDarDeBaja;
	private JLabel lblAvisoDarDeBaja;
	private JButton btnConfirmarDarDeBaja;
	private JButton btnCancelarDarDeBaja;
	private JLabel lblSeparador;
	
	/***********************************PARAMETROS************************************/
	
	private int id;
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelEmpleado(BtnEditarEmpleadoActionListener EditarEmpleadoActionListener, 
			BtnDarDeBajaEmpleadoListener darDeBajaEmpleadoListener, int identifier) {
		setPreferredSize(new Dimension(10, 220));
		
		setId(identifier);
		setMaximumSize(new Dimension(32767, 220));
		setMinimumSize(new Dimension(10, 220));
		setBackground(new Color(42,46,49));
		setVisible(true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{144, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Edited by Hand
		lblFotoEmpleado = new JLabel("");
		lblFotoEmpleado.setBorder(new EmptyBorder(20, 20, 0, 30));
		lblFotoEmpleado.setSize(new Dimension(180, 180));

		File file = EditarEmpleadoActionListener.getEmpleado().getFoto(); //Resizing the photo
		setFotoEmpleado(file);
		
		GridBagConstraints gbc_lblFotoEmpleado = new GridBagConstraints();
		gbc_lblFotoEmpleado.insets = new Insets(0, 0, 0, 5);
		gbc_lblFotoEmpleado.gridx = 0;
		gbc_lblFotoEmpleado.gridy = 0;
		add(lblFotoEmpleado, gbc_lblFotoEmpleado);
		//End of edition by hand
		
		pnlInformacion = new JPanel();
		pnlInformacion.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlInformacion = new GridBagConstraints();
		gbc_pnlInformacion.anchor = GridBagConstraints.WEST;
		gbc_pnlInformacion.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInformacion.fill = GridBagConstraints.VERTICAL;
		gbc_pnlInformacion.gridx = 1;
		gbc_pnlInformacion.gridy = 0;
		add(pnlInformacion, gbc_pnlInformacion);
		GridBagLayout gbl_pnlInformacion = new GridBagLayout();
		gbl_pnlInformacion.columnWidths = new int[]{0, 108, 0, 0, 0};
		gbl_pnlInformacion.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlInformacion.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInformacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlInformacion.setLayout(gbl_pnlInformacion);
		
		//Edited by Hand
		lblNombreApellidos = new JLabel(
				EditarEmpleadoActionListener.getEmpleado().getNombre() +" "+ 
				EditarEmpleadoActionListener.getEmpleado().getApellidos()); //Using name and surname of the constructor
		lblNombreApellidos.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblNombreApellidos.setForeground(Color.WHITE);
		lblNombreApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreApellidos.setFont(new Font("Verdana", Font.BOLD, 24));
		GridBagConstraints gbc_lblNombreApellidos = new GridBagConstraints();
		gbc_lblNombreApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblNombreApellidos.gridwidth = 3;
		gbc_lblNombreApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreApellidos.gridx = 1;
		gbc_lblNombreApellidos.gridy = 0;
		pnlInformacion.add(lblNombreApellidos, gbc_lblNombreApellidos);
		//End of edition by hand
		
		lblFormacion = new JLabel("Formación:");
		lblFormacion.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblFormacion.setForeground(Color.WHITE);
		lblFormacion.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFormacion = new GridBagConstraints();
		gbc_lblFormacion.anchor = GridBagConstraints.EAST;
		gbc_lblFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacion.gridx = 1;
		gbc_lblFormacion.gridy = 1;
		pnlInformacion.add(lblFormacion, gbc_lblFormacion);
		
		//Edited by hand
		lblFormacionOut = new JLabel(EditarEmpleadoActionListener.getEmpleado().getFormacion()); //Using formation of the constructor
		lblFormacionOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblFormacionOut.setForeground(Color.WHITE);
		lblFormacionOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFormacionOut = new GridBagConstraints();
		gbc_lblFormacionOut.anchor = GridBagConstraints.WEST;
		gbc_lblFormacionOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacionOut.gridx = 2;
		gbc_lblFormacionOut.gridy = 1;
		pnlInformacion.add(lblFormacionOut, gbc_lblFormacionOut);
		//End of edition by hand
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 2;
		pnlInformacion.add(lblTelefono, gbc_lblTelefono);
		
		//Edited by hand
		lblTelefonoOut = new JLabel(EditarEmpleadoActionListener.getEmpleado().getTelefono());
		lblTelefonoOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblTelefonoOut.setForeground(Color.WHITE);
		lblTelefonoOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTelefonoOut = new GridBagConstraints();
		gbc_lblTelefonoOut.anchor = GridBagConstraints.WEST;
		gbc_lblTelefonoOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonoOut.gridx = 2;
		gbc_lblTelefonoOut.gridy = 2;
		pnlInformacion.add(lblTelefonoOut, gbc_lblTelefonoOut);
		//End of edition by hand
		
		lblCorreo = new JLabel("E-Mail:");
		lblCorreo.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 3;
		pnlInformacion.add(lblCorreo, gbc_lblCorreo);
		
		//Edited by hand
		lblCorreoOut = new JLabel(EditarEmpleadoActionListener.getEmpleado().getCorreo()); //Using email of constructor
		lblCorreoOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblCorreoOut.setForeground(Color.WHITE);
		lblCorreoOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCorreoOut = new GridBagConstraints();
		gbc_lblCorreoOut.anchor = GridBagConstraints.WEST;
		gbc_lblCorreoOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoOut.gridx = 2;
		gbc_lblCorreoOut.gridy = 3;
		pnlInformacion.add(lblCorreoOut, gbc_lblCorreoOut);
		//End of edition by hand
		
		
		lblIdiomas = new JLabel("Idiomas:");
		lblIdiomas.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblIdiomas.setForeground(Color.WHITE);
		lblIdiomas.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblIdiomas = new GridBagConstraints();
		gbc_lblIdiomas.anchor = GridBagConstraints.EAST;
		gbc_lblIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdiomas.gridx = 1;
		gbc_lblIdiomas.gridy = 4;
		pnlInformacion.add(lblIdiomas, gbc_lblIdiomas);
		
		//Edited by hand
		lblIdiomasOut = new JLabel(parsearIdiomas(EditarEmpleadoActionListener)); //Using Languages of constructor
		lblIdiomasOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblIdiomasOut.setForeground(Color.WHITE);
		lblIdiomasOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblIdiomasOut = new GridBagConstraints();
		gbc_lblIdiomasOut.anchor = GridBagConstraints.WEST;
		gbc_lblIdiomasOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdiomasOut.gridx = 2;
		gbc_lblIdiomasOut.gridy = 4;
		pnlInformacion.add(lblIdiomasOut, gbc_lblIdiomasOut);
		//End of edition by hand
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 5;
		pnlInformacion.add(lblHorario, gbc_lblHorario);
		
		//Edited by hand
		lblHorarioOut = new JLabel(EditarEmpleadoActionListener.getEmpleado().getHorario()); //Using Turn of the constructor
		lblHorarioOut.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblHorarioOut.setForeground(Color.WHITE);
		lblHorarioOut.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHorarioOut = new GridBagConstraints();
		gbc_lblHorarioOut.anchor = GridBagConstraints.WEST;
		gbc_lblHorarioOut.insets = new Insets(0, 0, 0, 5);
		gbc_lblHorarioOut.gridx = 2;
		gbc_lblHorarioOut.gridy = 5;
		pnlInformacion.add(lblHorarioOut, gbc_lblHorarioOut);
		//End of edition by hand
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(new Color(42,46,49));
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 2;
		gbc_pnlBotones.gridy = 0;
		add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] {0, 0, 0, 0, 20};
		gbl_pnlBotones.rowHeights = new int[]{0, 0, 0};
		gbl_pnlBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBotones.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlBotones.setLayout(gbl_pnlBotones);
		
		btnDarDeBaja = new JButton("Dar de baja...");
		btnDarDeBaja.addMouseListener(new BtnDarDeBajaMouseListener());
		btnDarDeBaja.addActionListener(new BtnDarDeBajaActionListener());
		btnDarDeBaja.setPreferredSize(new Dimension(105, 33));
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setBackground(Color.DARK_GRAY);
		btnDarDeBaja.addActionListener(new BtnDarDeBajaActionListener());
		
		
		lblAvisoDarDeBaja = new JLabel("¿Dar\r\n de baja a este empleado?");
		lblAvisoDarDeBaja.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAvisoDarDeBaja.setForeground(Color.WHITE);
		lblAvisoDarDeBaja.setVisible(false);
		
		lblSeparador = new JLabel("");
		lblSeparador.setVisible(false);
		
		btnEditar = new JButton("Editar...");
		btnEditar.addMouseListener(new BtnEditarMouseListener());
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEditar.setPreferredSize(new Dimension(105, 33));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(189,90,249));
		btnEditar.addActionListener(EditarEmpleadoActionListener);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 0;
		pnlBotones.add(btnEditar, gbc_btnEditar);
		lblSeparador.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblSeparador.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeparador.setIcon(new ImageIcon(panelEmpleado.class.getResource("/presentacion/recursos/SeparadorVertical.png")));
		GridBagConstraints gbc_lblSeparador = new GridBagConstraints();
		gbc_lblSeparador.gridheight = 2;
		gbc_lblSeparador.insets = new Insets(0, 0, 0, 5);
		gbc_lblSeparador.gridx = 1;
		gbc_lblSeparador.gridy = 0;
		pnlBotones.add(lblSeparador, gbc_lblSeparador);
		GridBagConstraints gbc_lblAvisoDarDeBaja = new GridBagConstraints();
		gbc_lblAvisoDarDeBaja.gridwidth = 2;
		gbc_lblAvisoDarDeBaja.insets = new Insets(0, 0, 5, 0);
		gbc_lblAvisoDarDeBaja.gridx = 2;
		gbc_lblAvisoDarDeBaja.gridy = 0;
		pnlBotones.add(lblAvisoDarDeBaja, gbc_lblAvisoDarDeBaja);
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnDarDeBaja.gridx = 0;
		gbc_btnDarDeBaja.gridy = 1;
		pnlBotones.add(btnDarDeBaja, gbc_btnDarDeBaja);
		
		btnCancelarDarDeBaja = new JButton("Cancelar");
		btnCancelarDarDeBaja.addMouseListener(new BtnCancelarDarDeBajaMouseListener());
		btnCancelarDarDeBaja.addActionListener(new BtnCancelarDarDeBajaActionListener());
		btnCancelarDarDeBaja.setVisible(false);
		btnCancelarDarDeBaja.setPreferredSize(new Dimension(95, 33));
		btnCancelarDarDeBaja.setForeground(Color.WHITE);
		btnCancelarDarDeBaja.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancelarDarDeBaja.setBorder(null);
		btnCancelarDarDeBaja.setBackground(new Color(0,120,210));
		GridBagConstraints gbc_btnCancelarDarDeBaja = new GridBagConstraints();
		gbc_btnCancelarDarDeBaja.anchor = GridBagConstraints.EAST;
		gbc_btnCancelarDarDeBaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarDarDeBaja.gridx = 2;
		gbc_btnCancelarDarDeBaja.gridy = 1;
		pnlBotones.add(btnCancelarDarDeBaja, gbc_btnCancelarDarDeBaja);
		
		btnConfirmarDarDeBaja = new JButton("Dar de baja");
		btnConfirmarDarDeBaja.addMouseListener(new BtnConfirmarDarDeBajaMouseListener());
		btnConfirmarDarDeBaja.setVisible(false);
		btnConfirmarDarDeBaja.setPreferredSize(new Dimension(95, 33));
		btnConfirmarDarDeBaja.setForeground(Color.WHITE);
		btnConfirmarDarDeBaja.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnConfirmarDarDeBaja.setBorder(null);
		btnConfirmarDarDeBaja.setBackground(new Color(255,71,71));
		btnConfirmarDarDeBaja.addActionListener(darDeBajaEmpleadoListener);
		GridBagConstraints gbc_btnConfirmarDarDeBaja = new GridBagConstraints();
		gbc_btnConfirmarDarDeBaja.gridx = 3;
		gbc_btnConfirmarDarDeBaja.gridy = 1;
		pnlBotones.add(btnConfirmarDarDeBaja, gbc_btnConfirmarDarDeBaja);

	}
		
	/*********************************MAIN LISTENERS**********************************/
	
	private class BtnDarDeBajaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblSeparador.setVisible(true);
			lblAvisoDarDeBaja.setVisible(true);
			btnCancelarDarDeBaja.setVisible(true);
			btnConfirmarDarDeBaja.setVisible(true);
		}
	}
	
	private class BtnCancelarDarDeBajaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblSeparador.setVisible(false);
			lblAvisoDarDeBaja.setVisible(false);
			btnCancelarDarDeBaja.setVisible(false);
			btnConfirmarDarDeBaja.setVisible(false);
		}
	}
	
	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnDarDeBajaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnDarDeBaja.setBackground(new Color(76,83,88));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnDarDeBaja.setBackground(new Color(64,64,64));
		}
	}
	
	private class BtnEditarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEditar.setBackground(new Color(185,81,249));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEditar.setBackground(new Color(189,90,249));
		}
	}
	
	private class BtnCancelarDarDeBajaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCancelarDarDeBaja.setBackground(new Color(0,107,188));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCancelarDarDeBaja.setBackground(new Color(0,120,210));
		}
	}
	
	private class BtnConfirmarDarDeBajaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnConfirmarDarDeBaja.setBackground(new Color(255,41,41));
		}
		public void mouseExited(MouseEvent e) {
			btnConfirmarDarDeBaja.setBackground(new Color(255,71,71));
		}
	}

	/*******************************METODOS AUXILIARES********************************/
	
	private void setFotoEmpleado(File file) {
		try {
            Image imagenOriginal = ImageIO.read(file);
            Image imagenEscalada = imagenOriginal.getScaledInstance(lblFotoEmpleado.getWidth(),
            lblFotoEmpleado.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
            lblFotoEmpleado.setIcon(iconoLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private String parsearIdiomas(BtnEditarEmpleadoActionListener EditarEmpleadoActionListener) {
		
		String listaIdiomas = EditarEmpleadoActionListener.getEmpleado().getIdiomas().elementAt(0);
		
		if (!EditarEmpleadoActionListener.getEmpleado().getIdiomas().elementAt(1).equals("Ninguno")) {
			listaIdiomas += "-"+EditarEmpleadoActionListener.getEmpleado().getIdiomas().elementAt(1);
		}
		
		if (!EditarEmpleadoActionListener.getEmpleado().getIdiomas().elementAt(2).equals("Ninguno")) {
			listaIdiomas += "-"+EditarEmpleadoActionListener.getEmpleado().getIdiomas().elementAt(2);
		}
		
		return listaIdiomas;
				
	}
	
	/*******************************GETTERS AND SETTERS*******************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
