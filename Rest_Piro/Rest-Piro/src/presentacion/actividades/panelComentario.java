package presentacion.actividades;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial" })
public class panelComentario extends JPanel {
	private JLabel lblFotoUsuario;
	private JPanel pnlInfoComentario;
	private JPanel pnlSuperior;
	private JLabel lblNombreUsuario;
	private JLabel lblPuntuacion;
	private JLabel lblDescripcion;	
	
	/***********************************CONSTRUCTOR***********************************/
	
	public panelComentario() {
		setPreferredSize(new Dimension(400, 79));
		setMinimumSize(new Dimension(400, 79));
		setBackground(new Color(56,62,66));
		setBounds(new Rectangle(0, 0, 0, 144));
		setMaximumSize(new Dimension(400, 79));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		lblFotoUsuario = new JLabel("");
		lblFotoUsuario.setPreferredSize(new Dimension(60, 0));
		lblFotoUsuario.setForeground(Color.WHITE);
		lblFotoUsuario.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblFotoUsuario.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		lblFotoUsuario.setIcon(new ImageIcon(panelComentario.class.getResource("/presentacion/Recursos/FotoComentario.png")));
		lblFotoUsuario.setSize(new Dimension(60, 60));
		add(lblFotoUsuario, BorderLayout.WEST);
		
		pnlInfoComentario = new JPanel();
		pnlInfoComentario.setBackground(new Color(56,62,66));
		add(pnlInfoComentario, BorderLayout.CENTER);
		pnlInfoComentario.setLayout(new BorderLayout(0, 0));
		
		pnlSuperior = new JPanel();
		pnlSuperior.setBackground(new Color(56,62,66));
		pnlInfoComentario.add(pnlSuperior, BorderLayout.NORTH);
		pnlSuperior.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNombreUsuario = new JLabel("@usuarioejemplo");
		lblNombreUsuario.setForeground(new Color(47,198,152));
		lblNombreUsuario.setFont(new Font("Verdana", Font.BOLD, 13));
		pnlSuperior.add(lblNombreUsuario);
		
		lblPuntuacion = new JLabel("");
		lblPuntuacion.setIcon(new ImageIcon(panelComentario.class.getResource("/presentacion/recursos/PuntuacionEstrellas.png")));
		lblPuntuacion.setForeground(Color.WHITE);
		lblPuntuacion.setFont(new Font("Verdana", Font.PLAIN, 13));
		pnlSuperior.add(lblPuntuacion);
		
		lblDescripcion = new JLabel("Increible aplicación, todo fantástico");
		lblDescripcion.setVerticalTextPosition(SwingConstants.TOP);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDescripcion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Comentario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnlInfoComentario.add(lblDescripcion, BorderLayout.CENTER);
	}
}
