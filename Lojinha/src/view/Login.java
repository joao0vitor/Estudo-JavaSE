package view;

import javax.swing.border.EmptyBorder;

import model.DAO;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logolojinha.png")));
		setTitle("LhL cell - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtLogin = new JLabel("Login");
		txtLogin.setBounds(42, 51, 76, 33);
		contentPane.add(txtLogin);
		
		textField = new JTextField();
		textField.setBounds(89, 57, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setBounds(40, 112, 46, 14);
		contentPane.add(txtSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 109, 158, 20);
		contentPane.add(passwordField);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(234, 177, 89, 23);
		contentPane.add(btnAcessar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(10, 163, 48, 48);
		contentPane.add(lblStatus);
	}// fim do construtor
	
	// Criação de um objeto para acessar a camada model
	
	DAO dao = new DAO();
	private JLabel lblStatus;
	
	/**
	 * Método para verificar o status do servidor
	 */
	private void status() {
		try {
			// Abrir a conexão
			Connection con = dao.conectar();
			if (con == null ) {
				// Escolher a imagem dboff
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));	
			} else {
				// Escolher a imagem dbon
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
			// não esquecer de fechar a conxão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
} // fim do código
