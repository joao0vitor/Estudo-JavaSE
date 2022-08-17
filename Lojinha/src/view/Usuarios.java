package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JTextField txtUsuLogin;
	private JPasswordField txtUsuSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		setModal(true);
		setTitle("Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/usuarios.png")));
		setBounds(100, 100, 515, 359);
		getContentPane().setLayout(null);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setSelectedIcon(new ImageIcon(Usuarios.class.getResource("/img/add.png")));
		btnAdicionar.setBounds(297, 261, 48, 48);
		getContentPane().add(btnAdicionar);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (chkSenha.isSelected()) {
					alterarUsuarioSenha();
				}
				
				else {
					AtualizarUsuarios();
				}
				
			}
		});
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/edit.png")));
		btnAlterar.setBounds(355, 261, 48, 48);
		getContentPane().add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/remove.png")));
		btnExcluir.setBounds(428, 261, 48, 48);
		getContentPane().add(btnExcluir);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});

		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
		btnPesquisar.setBounds(266, 130, 48, 48);
		getContentPane().add(btnPesquisar);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 37, 46, 25);
		getContentPane().add(lblNewLabel);

		txtUsuId = new JTextField();
		txtUsuId.setEditable(false);
		txtUsuId.setBounds(32, 41, 86, 20);
		getContentPane().add(txtUsuId);
		txtUsuId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 86, 74, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 142, 46, 32);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 201, 46, 20);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(332, 81, 46, 25);
		getContentPane().add(lblNewLabel_4);

		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setEnabled(false);
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "user" }));
		cboUsuPerfil.setBounds(388, 83, 67, 25);
		getContentPane().add(cboUsuPerfil);

		txtUsuNome = new JTextField();
		txtUsuNome.setEditable(false);
		txtUsuNome.setColumns(10);
		txtUsuNome.setBounds(64, 83, 250, 20);
		getContentPane().add(txtUsuNome);

		txtUsuLogin = new JTextField();
		txtUsuLogin.setColumns(10);
		txtUsuLogin.setBounds(44, 150, 212, 20);
		getContentPane().add(txtUsuLogin);

		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setEditable(false);
		txtUsuSenha.setBounds(66, 203, 279, 20);
		getContentPane().add(txtUsuSenha);

		// Valida��o com o uso da biblioteca atxy2k
		// txtUsuId
		RestrictedTextField ValidarId = new RestrictedTextField(txtUsuId);
		ValidarId.setOnlyNums(true); // aceitar somente numeros
		ValidarId.setLimit(4); // maximo de caracteres

		// txtUsuNome
		RestrictedTextField ValidarNome = new RestrictedTextField(txtUsuNome);
		ValidarNome.setLimit(255);

		// txtUsuLogin
		RestrictedTextField ValidarLogin = new RestrictedTextField(txtUsuLogin);
		ValidarLogin.setLimit(255);

		// txtUsuSenha
		RestrictedTextField ValidarSenha = new RestrictedTextField(txtUsuSenha);
		
		chkSenha = new JCheckBox("Alterar senha");
		chkSenha.setVisible(false);
		chkSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuSenha.setBackground(Color.WHITE);
				txtUsuSenha.setText(null);
				txtUsuSenha.requestFocus();
				txtUsuSenha.setEditable(true);
			}
		});
		chkSenha.setBounds(332, 149, 113, 23);
		getContentPane().add(chkSenha);
		ValidarSenha.setLimit(255);


	} // fim do construtor

	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JCheckBox chkSenha;

	/**
	 * M�todo responsavel pela pesquisa de usu�rios pelo login
	 */
	private void pesquisarUsuario() {
		// valida��o
		if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o login do us�ario");
			txtUsuId.requestFocus();
		} else {
			// L�gica principal
			// query (instru��o SQL)
			String read = "select * from usuarios where login = ?";
			// tratar exce��es sempre que lidar com o banco
			try {
				// Estabelecer a conex�o
				Connection con = dao.conectar();
				// Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conte�do da caixa de texto
				pst.setString(1, txtUsuLogin.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// Valida��o (existencia de usuario)
				// rs.next() -> existencia de usuario
				if (rs.next()) {
					// preencher(setar) os campos do formulario
					txtUsuId.setText(rs.getString(1));
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(5));
					txtUsuSenha.setText(rs.getString(4));
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEditable(true);
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					chkSenha.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usu�rio inexistente");
					//txtUsuLogin.setEditable(false);
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
					

				}
				// Nunca esquecer de encerrar a conex�o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * M�todo responsavel por adicionar um novo usuario no banco
	 */
	private void adicionarUsuario() {
		// valida��o da senha (captura segura)
		String capturaSenha = new String(txtUsuSenha.getPassword());

		// Valida��o
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o us�ario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usu�rio");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// l�gica principal
			String create = "insert into usuarios (usuario,login,senha,perfil) values (?,?,md5(?),?);";
			try {
				// estabelecer conex�o
				Connection con = dao.conectar();
				// Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conex�o
				JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso");

				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso. \nEscolha outro login.");
				txtUsuLogin.requestFocus();
				txtUsuLogin.setText(null);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Metodo alterar usuario no banco exceto a senha
	 */

	private void AtualizarUsuarios() {


		// Valida��o
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o us�ario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usu�rio");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// l�gica principal
			String update = "update usuarios set usuario=?, login=?,perfil=? where iduser=?;";
			try {
				// estabelecer conex�o
				Connection con = dao.conectar();
				// Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(4, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conex�o
				JOptionPane.showMessageDialog(null, "Dados do usu�rio, exceto senha, alterados com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso. \nEscolha outro login.");
				txtUsuLogin.requestFocus();
				txtUsuLogin.setText(null);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Metodo alterar senha do usu�rio no banco
	 */

	private void alterarUsuarioSenha() {
		// valida��o da senha (captura segura)
		String capturaSenha = new String(txtUsuSenha.getPassword());
		// valida��o
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usu�rio");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usu�rio");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// logica principal
			String update2 = "update usuarios set usuario=?, login=?,senha=md5(?), perfil=? where iduser=?";
			try {
				// Estabelecer a conex�o
				Connection con = dao.conectar();
				// Preparar a execu��oo da query
				PreparedStatement pst = con.prepareStatement(update2);
				// Substituir os ????? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(5, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conex�o
				JOptionPane.showMessageDialog(null, "Dados do usu�rio alterados com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * M�todo excluir usuario do banco
	 */
	
	private void excluirUsuario() {
		// valida��o (confirma��o de exclus�o)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a exclus�o do usu�rio?","Aten��o!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// Logica principal
			String delete = "Delete from usuarios where iduser=?;";
			
			try {
				// Estabelecer a conex�o
				Connection con = dao.conectar();

				// Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(delete);

				// Substituir o ? pelo conte�do da caixa de texto
				pst.setString(1, txtUsuId.getText());

				// Executar a query e inserir o usu�rio no banco
				pst.executeUpdate();

				limparCampos();

				// Exibir mensagem ao inserir usu�rio excluido
				JOptionPane.showMessageDialog(null, "Usu�rio excluido com sucesso!");

				// NUNCA esquecer de encerrar a conex�o
				con.close();

			}

			catch (Exception e) {
				System.out.println(e);
			}

		}
   }
	
	 /**
	 * Metodo usado para limpar e validar os campos e objetos do formulario
	 */
	private void limparCampos() {
		txtUsuId.setText(null);
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		txtUsuSenha.setBackground(Color.WHITE);
		cboUsuPerfil.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		chkSenha.setVisible(false);
		chkSenha.setSelected(false);
		txtUsuSenha.setEditable(true);
	}
}
