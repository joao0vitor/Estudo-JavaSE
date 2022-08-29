package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtPesquisarCliente;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTable tblCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente dialog = new Cliente();
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
	public Cliente() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/cliente.png")));
		setResizable(false);
		setTitle("Clientes");
		setBounds(100, 100, 780, 456);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 208, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(34, 202, 46, 28);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 30, 46, 14);
		getContentPane().add(lblNome);
		
		txtPesquisarCliente = new JTextField();
		txtPesquisarCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarClienteTabela();
			}
		});
		txtPesquisarCliente.setColumns(10);
		txtPesquisarCliente.setBounds(48, 28, 220, 20);
		getContentPane().add(txtPesquisarCliente);
		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(222, 208, 46, 14);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(251, 206, 171, 20);
		getContentPane().add(txtCpf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCep.setBounds(365, 164, 46, 14);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setEditable(false);
		txtCep.setColumns(10);
		txtCep.setBounds(391, 162, 153, 20);
		getContentPane().add(txtCep);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Cliente.class.getResource("/img/search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(281, 11, 48, 48);
		getContentPane().add(btnNewButton);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFone.setBounds(222, 337, 46, 14);
		getContentPane().add(lblFone);
		
		txtFone = new JTextField();
		txtFone.setEditable(false);
		txtFone.setColumns(10);
		txtFone.setBounds(265, 335, 171, 20);
		getContentPane().add(txtFone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 258, 46, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(48, 256, 262, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblMarketing = new JLabel("Deseja receber promo\u00E7\u00F5es por email ?");
		lblMarketing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarketing.setBounds(10, 367, 230, 18);
		getContentPane().add(lblMarketing);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereo.setBounds(10, 293, 70, 14);
		getContentPane().add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(73, 291, 220, 20);
		getContentPane().add(txtEndereco);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmero.setBounds(320, 257, 70, 14);
		getContentPane().add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(377, 255, 111, 20);
		getContentPane().add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComplemento.setBounds(457, 208, 84, 14);
		getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setEditable(false);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(551, 206, 161, 20);
		getContentPane().add(txtComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBairro.setBounds(321, 293, 48, 14);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(366, 291, 220, 20);
		getContentPane().add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidade.setBounds(10, 337, 57, 14);
		getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(58, 335, 154, 20);
		getContentPane().add(txtCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUf.setBounds(498, 257, 46, 14);
		getContentPane().add(lblUf);
		
		cboUfCli = new JComboBox();
		cboUfCli.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUfCli.setBounds(523, 254, 57, 22);
		getContentPane().add(cboUfCli);
		
		cboEmail = new JComboBox();
		cboEmail.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cboEmail.setBounds(251, 366, 57, 22);
		getContentPane().add(cboEmail);
		
		btnAdicionarCli = new JButton("");
		btnAdicionarCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionarCli.setEnabled(false);
		btnAdicionarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarCli.setIcon(new ImageIcon(Cliente.class.getResource("/img/add.png")));
		btnAdicionarCli.setToolTipText("Adicionar");
		btnAdicionarCli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarCli.setContentAreaFilled(false);
		btnAdicionarCli.setBorderPainted(false);
		btnAdicionarCli.setBounds(538, 367, 48, 48);
		getContentPane().add(btnAdicionarCli);
		
		btnAlterarCli = new JButton("");
		btnAlterarCli.setEnabled(false);
		btnAlterarCli.setIcon(new ImageIcon(Cliente.class.getResource("/img/edit.png")));
		btnAlterarCli.setToolTipText("Alterar");
		btnAlterarCli.setContentAreaFilled(false);
		btnAlterarCli.setBorderPainted(false);
		btnAlterarCli.setBounds(596, 367, 48, 48);
		getContentPane().add(btnAlterarCli);
		
		btnExcluirCli = new JButton("");
		btnExcluirCli.setEnabled(false);
		btnExcluirCli.setToolTipText("Remover");
		btnExcluirCli.setIcon(new ImageIcon(Cliente.class.getResource("/img/remove.png")));
		btnExcluirCli.setContentAreaFilled(false);
		btnExcluirCli.setBorderPainted(false);
		getContentPane().add(btnExcluirCli);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 57, 744, 90);
		getContentPane().add(scrollPane);
		
		
		tblCliente = new JTable();
		tblCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblCliente);
		btnExcluirCli.setBounds(664, 367, 48, 48);
		getContentPane().add(btnExcluirCli);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnBuscar.setBounds(90, 205, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnBuscarCep = new JButton("Buscar Cep");
		btnBuscarCep.setBounds(554, 161, 103, 23);
		getContentPane().add(btnBuscarCep);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 165, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNomeCli = new JTextField();
		txtNomeCli.setEditable(false);
		txtNomeCli.setColumns(10);
		txtNomeCli.setBounds(48, 162, 294, 20);
		getContentPane().add(txtNomeCli);

	} // fim do construtor
	
	DAO dao = new DAO();
	private JComboBox cboEmail;
	private JComboBox cboUfCli;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JButton btnAlterarCli;
	private JButton btnAdicionarCli;
	private JButton btnExcluirCli;
	private JTextField txtNomeCli;
	
	/**
	 * Método responsavel pela pesquisa avançada do fornecedor usando o nome de
	 * fantasia e a biblioteca rs2xml
	 */

	private void pesquisarClienteTabela() {
		String readT = "select idcli as ID ,nome, fone,  cpf, email,  marketing, cep,  endereco,  numero,  complemento,  bairro, cidade, uf from clientes where nome like ?";
		try {
			// estabelecer conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Substituir os ???? pelo conteudo das caixas de texto
			pst.setString(1, txtPesquisarCliente.getText() + "%");
			ResultSet rs = pst.executeQuery();
			// uso da biblioteca ts2xml para "popular" a tabela
			tblCliente.setModel(DbUtils.resultSetToTableModel(rs));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void setarCaixasTexto() {
		// criar uma variavel apra receber a linha da tabela
		int setar = tblCliente.getSelectedRow();
		txtId.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
	}


	private void pesquisarUsuario() {
		// validação
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuário inexistente");
			txtId.requestFocus();
			txtNomeCli.setEditable(true);
			txtFone.setEditable(true);
			txtCpf.setEditable(true);
			txtEmail.setEditable(true);
			cboEmail.setEditable(true);
			txtCep.setEditable(true);
			txtEndereco.setEditable(true);
			txtNumero.setEditable(true);
			txtComplemento.setEditable(true);
			txtBairro.setEditable(true);
			txtCidade.setEditable(true);
			cboUfCli.setEditable(true);
			btnAdicionarCli.setEnabled(true);
			btnBuscar.setEnabled(false);
			limparCampos();
		} else {
			String read = "select * from clientes where idcli = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtId.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtNomeCli.setText(rs.getString(2));
					txtFone.setText(rs.getString(3));
					txtCpf.setText(rs.getString(4));
					txtEmail.setText(rs.getString(5));
					cboEmail.setSelectedItem(rs.getString(6));
					txtCep.setText(rs.getString(7));
					txtEndereco.setText(rs.getString(8));
					txtNumero.setText(rs.getString(9));
					txtComplemento.setText(rs.getString(10));
					txtBairro.setText(rs.getString(11));
					txtCidade.setText(rs.getString(12));
					cboUfCli.setSelectedItem(rs.getString(13));
					btnAlterarCli.setEnabled(true);
					btnExcluirCli.setEnabled(true);
					btnAdicionarCli.setEnabled(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usúario inexistente");
					txtId.requestFocus();
					txtNomeCli.setEditable(true);
					txtFone.setEditable(true);
					txtCpf.setEditable(true);
					txtEmail.setEditable(true);
					cboEmail.setEditable(true);
					txtCep.setEditable(true);
					txtEndereco.setEditable(true);
					txtNumero.setEditable(true);
					txtComplemento.setEditable(true);
					txtBairro.setEditable(true);
					txtCidade.setEditable(true);
					cboUfCli.setEditable(true);
					btnAdicionarCli.setEnabled(true);
					btnBuscar.setEnabled(false);
					limparCampos();
				}
				// Nunca esquecer de encerrar a conexão
				con.close();
				
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Dado já em uso, por favor coloque outro");
				txtCpf.setText(null);
				txtCpf.requestFocus();
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Método responsavel por adicionar um novo cliente no banco
	 */
	private void adicionarUsuario() {
		// Validação
		if (txtNomeCli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtNomeCli.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone");
			txtFone.requestFocus();
		} else if (cboEmail.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha sim ou não");
			cboEmail.requestFocus();
		} else {
			// lógica principal
			String create = "insert into clientes (nome,fone,marketing)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				
				pst.setString(2, txtNomeCli.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtCpf.getText());
				pst.setString(5, txtEmail.getText());
				pst.setString(6, cboEmail.getSelectedItem().toString());
				pst.setString(7, txtCep.getText());
				pst.setString(8, txtEndereco.getText());
				pst.setString(9, txtNumero.getText());
				pst.setString(10, txtComplemento.getText());
				pst.setString(11, txtBairro.getText());
				pst.setString(12, txtCidade.getText());
				pst.setString(13, cboUfCli.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "CPF em uso. \nEscolha outro cpf.");
				txtCpf.requestFocus();
				txtCpf.setText(null);
			
				JOptionPane.showMessageDialog(null, "Telefone em uso. \nEscolha outro telefone.");
				txtFone.requestFocus();
				txtFone.setText(null);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	 /**
		 * Metodo usado para limpar e validar os campos e objetos do formulario
		 */
		private void limparCampos() {
			txtId.setText(null);
			txtNomeCli.setText(null);
			txtPesquisarCliente.setText(null);
			txtFone.setText(null);
			txtCpf.setText(null);
			txtEmail.setText(null);
			cboEmail.setSelectedItem(null);
			txtCep.setText(null);
			txtEndereco.setText(null);
			txtNumero.setText(null);
			txtComplemento.setText(null);
			txtBairro.setText(null);
			txtCidade.setText(null);
			cboUfCli.setSelectedItem(null);
			btnAlterarCli.setEnabled(false);
			btnExcluirCli.setEnabled(false);
		}
}
