package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.DAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JTable table;

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
		lblNewLabel.setBounds(10, 164, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(34, 158, 46, 28);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 30, 46, 14);
		getContentPane().add(lblNome);
		
		txtPesquisarCliente = new JTextField();
		txtPesquisarCliente.setColumns(10);
		txtPesquisarCliente.setBounds(48, 28, 220, 20);
		getContentPane().add(txtPesquisarCliente);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(119, 164, 46, 14);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(158, 162, 171, 20);
		getContentPane().add(txtCpf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCep.setBounds(358, 164, 46, 14);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
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
		lblFone.setBounds(10, 208, 46, 14);
		getContentPane().add(lblFone);
		
		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(48, 206, 171, 20);
		getContentPane().add(txtFone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(229, 208, 46, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(267, 206, 171, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblMarketing = new JLabel("Deseja receber promo\u00E7\u00F5es por email ?");
		lblMarketing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarketing.setBounds(10, 367, 230, 18);
		getContentPane().add(lblMarketing);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereo.setBounds(10, 257, 70, 14);
		getContentPane().add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(69, 255, 220, 20);
		getContentPane().add(txtEndereco);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmero.setBounds(320, 257, 70, 14);
		getContentPane().add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(377, 255, 111, 20);
		getContentPane().add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComplemento.setBounds(457, 208, 84, 14);
		getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(551, 206, 161, 20);
		getContentPane().add(txtComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBairro.setBounds(10, 316, 48, 14);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(48, 314, 220, 20);
		getContentPane().add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidade.setBounds(301, 316, 57, 14);
		getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(355, 314, 128, 20);
		getContentPane().add(txtCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUf.setBounds(498, 257, 46, 14);
		getContentPane().add(lblUf);
		
		cboUfCli = new JComboBox();
		cboUfCli.setEnabled(false);
		cboUfCli.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUfCli.setBounds(523, 254, 57, 22);
		getContentPane().add(cboUfCli);
		
		cboEmail = new JComboBox();
		cboEmail.setEnabled(false);
		cboEmail.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cboEmail.setBounds(251, 366, 57, 22);
		getContentPane().add(cboEmail);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Cliente.class.getResource("/img/add.png")));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(522, 345, 48, 48);
		getContentPane().add(btnAdicionar);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Cliente.class.getResource("/img/edit.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(597, 345, 48, 48);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setIcon(new ImageIcon(Cliente.class.getResource("/img/remove.png")));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(681, 345, 48, 48);
		getContentPane().add(btnExcluir);
		
		JScrollPane tblClientes = new JScrollPane();
		tblClientes.setBounds(10, 57, 648, 90);
		getContentPane().add(tblClientes);
		
		table = new JTable();
		tblClientes.setViewportView(table);

	} // fim do construtor
	
	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JComboBox cboEmail;
	private JComboBox cboUfCli;

	/**
	 * Método responsavel pela pesquisa de usuários pelo login
	 */
	
	private void pesquisarUsuario() {
		// validação
		if (txtPesquisarCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o nome do usúario");
			txtId.requestFocus();
		} else {
			// Lógica principal
			// query (instrução SQL)
			String read = "select idcli as ID ,nome as clientes,fone, marketing from clientes where nome like ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtPesquisarCliente.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// Validação (existencia de usuario)
				// rs.next() -> existencia de usuario
				if (rs.next()) {
					// preencher(setar) os campos do formulario
					txtId.setText(rs.getString(1));
					txtPesquisarCliente.setText(rs.getString(2));
					txtFone.setText(rs.getString(3));
					txtCpf.setText(rs.getString(4));
					txtEmail.setText(rs.getString(5));
					cboEmail.setEditable(true);
					txtCep.setText(rs.getString(6));
					txtEndereco.setText(rs.getString(7));
					txtNumero.setText(rs.getString(8));
					txtComplemento.setText(rs.getString(9));
					txtBairro.setText(rs.getString(10));
					txtCidade.setText(rs.getString(11));
					cboUfCli.setEditable(true);
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
					//txtUsuLogin.setEditable(false);
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
					

				}
				// Nunca esquecer de encerrar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
