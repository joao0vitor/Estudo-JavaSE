package view;

import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextLogin;

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

		TextLogin = new JTextField();
		TextLogin.setBounds(89, 57, 158, 20);
		contentPane.add(TextLogin);
		TextLogin.setColumns(10);

		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setBounds(40, 112, 46, 14);
		contentPane.add(txtSenha);

		TextSenha = new JPasswordField();
		TextSenha.setBounds(89, 109, 158, 20);
		contentPane.add(TextSenha);

		JButton btnLogar = new JButton("Acessar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnLogar.setBounds(234, 177, 89, 23);
		contentPane.add(btnLogar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(10, 163, 48, 48);
		contentPane.add(lblStatus);

		// Validação com o uso da biblioteca Atxy2k

		// txtLogin
		RestrictedTextField validarLogin = new RestrictedTextField(TextLogin);

		// Restringir a caracteres alfanuméricos no campo login
		validarLogin.setOnlyAlphaNumeric(true);
		// Limitar a somente 15 caracteres no campo login
		validarLogin.setLimit(15);

		// txtUsuSenha
		RestrictedTextField validarSenha = new RestrictedTextField(TextSenha);

		// Limitar a somente 10 caracteres no campo senha
		validarSenha.setLimit(10);

		// Usar o Enter ao invés de "clicar" no botão para logar
		getRootPane().setDefaultButton(btnLogar);

	}// fim do construtor

	// Criação de um objeto para acessar a camada model

	DAO dao = new DAO();
	private JLabel lblStatus;
	private JPasswordField TextSenha;

	/**
	 * Método para verificar o status do servidor
	 */
	private void status() {
		try {
			// Abrir a conexão
			Connection con = dao.conectar();
			if (con == null) {
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

	/**
	 * Método usado para autenticar um usuário
	 */
	private void logar() {
		// validação da senha (captura segura)
		String capturaSenha = new String(TextSenha.getPassword());
		// validação
		if (TextLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			TextLogin.requestFocus();
		} else if (TextSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua senha");
			TextSenha.requestFocus();
		} else {
			// lógica principal
			String read = "select * from usuarios where login=? and senha = md5(?)";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar os argumentos (login e senha)
				// Substituir os ?(argumentos) pelo conteúdo das caixas de texto
				pst.setString(1, TextLogin.getText());
				pst.setString(2, capturaSenha);
				// Executar a query e de acordo com o resultado liberar os recursos da tela
				// principal
				ResultSet rs = pst.executeQuery();
				// Validação (autenticação de usuário)
				// rs.next() -> existência de login e senha correspondente
				if (rs.next()) {
					// verificar o peril do usuario
					String perfil = rs.getString(5);

					if (perfil.equals("admin")) {
						Principal principalA = new Principal();
						// abrir a tela principal
						principalA.setVisible(true);

						// habilitar recursos
						principalA.btnRelatorio.setEnabled(true);
						principalA.btnUsuarios.setEnabled(true);
						// personalizar
						principalA.panelUsuario.setBackground(Color.RED);

						// setar o nome do usuario na tela principal
						principalA.lblUsuario.setText("Usuario: " + rs.getString(2));
					}

					if (perfil.equals("user")) {
						Principal principalU = new Principal();
						// abrir a tela principal
						principalU.setVisible(true);

						// habilitar recursos
						principalU.btnRelatorio.setEnabled(false);
						principalU.btnUsuarios.setEnabled(false);

						// personalizar
						principalU.panelUsuario.setBackground(Color.BLUE);

						// setar o nome do usuario na tela principal
						principalU.lblUsuario.setText("Usuario: " + rs.getString(2));

						// encerrrar a conexão
						con.close();
						// fechar a tela de login
						this.dispose();

					} else {

					}

				} else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválido(s)");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

} // fim do código
