package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField pwdfPassword;
	private JButton btnStartup;
	private JLabel lblPassword;
	private JLabel lblUser;
	private JLabel lblLanguage;
	private JLabel lblFondo;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnCerrarAplicacion;
	private JButton btnInformacion;

	/***********************************PARAMETROS************************************/
	
	private String user = "admin";
	private String password = "admin";
	
	/***********************************METODO MAIN***********************************/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/***********************************CONSTRUCTOR***********************************/
	
	public Login() {
		initialize();	
	}

	/********************************METODO PRINCIPAL*********************************/
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RestPiro.class.getResource("recursos/RestPiroIcono.png")));
		frame.setForeground(Color.WHITE);
		frame.setUndecorated(true);
		frame.setBackground(new Color (0,0,0,0));
		frame.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setCaretColor(Color.WHITE);
		txtUser.setOpaque(false);
		txtUser.setForeground(new Color (255,255,255));
		txtUser.setBackground(new Color(0,0,0,0));
		txtUser.setBorder(null);
		
		btnCerrarAplicacion = new JButton("X");
		btnCerrarAplicacion.addMouseListener(new BtnCerrarAplicacionMouseListener());
		btnCerrarAplicacion.addActionListener(new BtnCerrarAplicacionActionListener());
		
		btnInformacion = new JButton("i");
		btnInformacion.addMouseListener(new BtnInformacionMouseListener());
		btnInformacion.addActionListener(new BtnInformacionActionListener());
		btnInformacion.setForeground(Color.WHITE);
		btnInformacion.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnInformacion.setBorder(null);
		btnInformacion.setBackground(new Color(72, 61, 139));
		btnInformacion.setBounds(898, 27, 37, 34);
		frame.getContentPane().add(btnInformacion);
		btnCerrarAplicacion.setBorder(null);
		btnCerrarAplicacion.setForeground(Color.WHITE);
		btnCerrarAplicacion.setBackground(new Color(72, 61, 139));
		btnCerrarAplicacion.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnCerrarAplicacion.setBounds(945, 27, 37, 34);
		frame.getContentPane().add(btnCerrarAplicacion);
		
		separator = new JSeparator();
		separator.setBounds(681, 178, 254, 7);
		frame.getContentPane().add(separator);
		txtUser.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		txtUser.setBounds(691, 146, 244, 34);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		pwdfPassword = new JPasswordField();
		pwdfPassword.setCaretColor(Color.WHITE);
		pwdfPassword.setOpaque(false);
		pwdfPassword.setToolTipText("");
		pwdfPassword.setForeground(Color.WHITE);
		pwdfPassword.setBackground(new Color(0,0,0,0));
		pwdfPassword.setBorder(null);
		pwdfPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		pwdfPassword.setBounds(691, 227, 244, 34);
		frame.getContentPane().add(pwdfPassword);
		
		btnStartup = new JButton("Date un rest-piro!");
		btnStartup.addMouseListener(new BtnStartupMouseListener());
		btnStartup.setForeground(Color.WHITE);
		btnStartup.setBackground(new Color(72, 61, 139));
		btnStartup.setBorder(null);
		btnStartup.addActionListener(new BtnStartupActionListener());
		btnStartup.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		btnStartup.setBounds(702, 325, 269, 53);
		frame.getContentPane().add(btnStartup);
		
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 35));
		lblPassword.setBounds(451, 211, 197, 68);
		frame.getContentPane().add(lblPassword);
		
		lblUser = new JLabel("Usuario:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tw Cen MT", Font.BOLD, 35));
		lblUser.setBounds(510, 126, 138, 76);
		frame.getContentPane().add(lblUser);
		
		lblLanguage = new JLabel("");
		lblLanguage.addMouseListener(new LblLanguageMouseListener());
		lblLanguage.setIcon(new ImageIcon(Login.class.getResource("/presentacion/recursos/language.png")));
		lblLanguage.setBounds(429, 314, 77, 86);
		frame.getContentPane().add(lblLanguage);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(681, 259, 254, 7);
		frame.getContentPane().add(separator_1);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/presentacion/recursos/FondoLogin.png")));
		lblFondo.setBounds(10, 0, 994, 419);
		frame.getContentPane().add(lblFondo);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1013, 429);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*****************************LISTENERS HOVER BUTTON******************************/
	
	private class BtnCerrarAplicacionMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCerrarAplicacion.setBackground(new Color(93,79,177));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCerrarAplicacion.setBackground(new Color(72, 61, 139));
		}
	}
	
	private class BtnInformacionMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnInformacion.setBackground(new Color(93,79,177));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnInformacion.setBackground(new Color(72, 61, 139));
		}
	}
	
	private class BtnStartupMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnStartup.setBackground(new Color(93,79,177));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnStartup.setBackground(new Color(72, 61, 139));
		}
	}
	
	private class LblLanguageMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblLanguage.setIcon(new ImageIcon(Login.class.getResource("/presentacion/recursos/languageBig.png")));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblLanguage.setIcon(new ImageIcon(Login.class.getResource("/presentacion/recursos/language.png")));
		}
	}
	
	/*******************************METODOS AUXILIARES********************************/
	
	private class BtnStartupActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (txtUser.getText().equals(user) & String.valueOf(pwdfPassword.getPassword()).equals(password)){
				frame.dispose();
				RestPiro main = new RestPiro();
				main.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(frame, "Usuario y/o contraseña no validos",
						"Custom error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class BtnCerrarAplicacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
		}
	}
	
	private class BtnInformacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame, "Josue Carlos Zenteno Yave\n"
					+ "Marina Prieto Pech\n"
					+ "Sergio Silvestre Pavón\n"
					+ "Gracias por usar nuestra aplicación", 
					"Autores", JOptionPane.PLAIN_MESSAGE);
		}
	}

	
	


}
