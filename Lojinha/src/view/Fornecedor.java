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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fornecedor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField txtForIE;
	private JTextField txtForCNPJ;
	private JTextField txtForIM;
	private JTextField txtForRazao;
	private JTextField txtForFantasia;
	private JTextField txtForSite;
	private JTextField txtForContato;
	private JTextField txtForEmail;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForFone;
	private JTextField txtForComplemento;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTable tblFornecedores;
	private JComboBox cboForUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor dialog = new Fornecedor();
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
	public Fornecedor() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedor.class.getResource("/img/fornecedor.png")));
		setTitle("Fornecedores");
		setBounds(100, 100, 675, 484);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 23, 73, 20);
		getContentPane().add(lblNewLabel);
		
		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.setBounds(85, 24, 199, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 125, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtForId = new JTextField();
		txtForId.setBounds(33, 123, 46, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(183, 125, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtForIE = new JTextField();
		txtForIE.setBounds(511, 164, 148, 20);
		getContentPane().add(txtForIE);
		txtForIE.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(493, 166, 39, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtForCNPJ = new JTextField();
		txtForCNPJ.setColumns(10);
		txtForCNPJ.setBounds(212, 123, 119, 20);
		getContentPane().add(txtForCNPJ);
		
		JLabel lblNewLabel_3_1 = new JLabel("IM");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(319, 166, 46, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		txtForIM = new JTextField();
		txtForIM.setColumns(10);
		txtForIM.setBounds(343, 164, 140, 20);
		getContentPane().add(txtForIM);
		
		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 166, 79, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtForRazao = new JTextField();
		txtForRazao.setColumns(10);
		txtForRazao.setBounds(85, 164, 224, 20);
		getContentPane().add(txtForRazao);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nome de Fant\u00E1sia");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(334, 125, 108, 14);
		getContentPane().add(lblNewLabel_5_1);
		
		txtForFantasia = new JTextField();
		txtForFantasia.setColumns(10);
		txtForFantasia.setBounds(444, 123, 215, 20);
		getContentPane().add(txtForFantasia);
		
		JLabel lblNewLabel_2_1 = new JLabel("Site");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		txtForSite = new JTextField();
		txtForSite.setColumns(10);
		txtForSite.setBounds(34, 211, 224, 20);
		getContentPane().add(txtForSite);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fone");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(301, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Contato");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(268, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_3);
		
		txtForContato = new JTextField();
		txtForContato.setColumns(10);
		txtForContato.setBounds(319, 211, 148, 20);
		getContentPane().add(txtForContato);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("E-mail");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(10, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_1_1);
		
		txtForEmail = new JTextField();
		txtForEmail.setColumns(10);
		txtForEmail.setBounds(47, 249, 229, 20);
		getContentPane().add(txtForEmail);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("CEP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(501, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		btnBuscarCep = new JButton("Buscar Cep");
		btnBuscarCep.setBounds(543, 210, 106, 23);
		getContentPane().add(btnBuscarCep);
		
		JLabel lblNewLabel_5_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(10, 287, 79, 14);
		getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("N\u00FAmero");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(319, 287, 46, 14);
		getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Complemento");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(452, 287, 79, 14);
		getContentPane().add(lblNewLabel_5_3);
		
		txtForEndereco = new JTextField();
		txtForEndereco.setColumns(10);
		txtForEndereco.setBounds(65, 285, 241, 20);
		getContentPane().add(txtForEndereco);
		
		txtForNumero = new JTextField();
		txtForNumero.setColumns(10);
		txtForNumero.setBounds(369, 285, 73, 20);
		getContentPane().add(txtForNumero);
		
		txtForFone = new JTextField();
		txtForFone.setColumns(10);
		txtForFone.setBounds(334, 249, 140, 20);
		getContentPane().add(txtForFone);
		
		txtForComplemento = new JTextField();
		txtForComplemento.setColumns(10);
		txtForComplemento.setBounds(540, 285, 119, 20);
		getContentPane().add(txtForComplemento);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Bairro");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(10, 333, 46, 14);
		getContentPane().add(lblNewLabel_2_3_2);
		
		txtForBairro = new JTextField();
		txtForBairro.setColumns(10);
		txtForBairro.setBounds(47, 331, 186, 20);
		getContentPane().add(txtForBairro);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Cidade");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2_1.setBounds(250, 333, 56, 14);
		getContentPane().add(lblNewLabel_5_2_1);
		
		txtForCidade = new JTextField();
		txtForCidade.setColumns(10);
		txtForCidade.setBounds(291, 331, 186, 20);
		getContentPane().add(txtForCidade);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("UF");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(519, 333, 34, 14);
		getContentPane().add(lblNewLabel_2_1_2);
		
		cboForUf = new JComboBox();
		cboForUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboForUf.setBounds(543, 330, 56, 22);
		getContentPane().add(cboForUf);
		
		JTextArea txtForObs = new JTextArea();
		txtForObs.setBounds(85, 378, 325, 56);
		getContentPane().add(txtForObs);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1.setBounds(10, 402, 73, 14);
		getContentPane().add(lblNewLabel_2_1_2_1);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/add.png")));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(434, 386, 48, 48);
		getContentPane().add(btnAdicionar);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/edit.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setBounds(509, 386, 48, 48);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/remove.png")));
		btnExcluir.setToolTipText("Remover");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(584, 386, 48, 48);
		getContentPane().add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 422, 56);
		getContentPane().add(scrollPane);
		
		tblFornecedores = new JTable();
		scrollPane.setColumnHeaderView(tblFornecedores);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.setBounds(85, 122, 88, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/search.png")));
		lblNewLabel_4.setBounds(294, 11, 48, 48);
		getContentPane().add(lblNewLabel_4);

	} // fim do construtor
	
	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnBuscarCep;
	
	/**
	 * Método responsavel pela pesquisa de usuários pelo id
	 */
	private void txtPesquisarFornecedor() {
		// validação
		if (txtForId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o id do usuário");
			txtForId.requestFocus();
		} else {
			// Lógica principal
			// query (instrução SQL)
			String read = "select * from usuarios where idfor = ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o argumento (id)
				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtForId.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// Validação (existencia de usuario)
				// rs.next() -> existencia de usuario
				if (rs.next()) {
					// preencher(setar) os campos do formulario
					txtForId.setText(rs.getString(1));
					txtForCNPJ.setText(rs.getString(2));
					txtForFantasia.setText(rs.getString(3));
					txtForRazao.setText(rs.getString(4));
					txtForIM.setText(rs.getString(5));
					txtForIE.setText(rs.getString(6));
					txtForSite.setText(rs.getString(7));
					txtForContato.setText(rs.getString(8));
					txtForEmail.setText(rs.getString(9));
					txtForFone.setText(rs.getString(10));
					txtForEndereco.setText(rs.getString(11));
					txtForNumero.setText(rs.getString(12));
					txtForComplemento.setText(rs.getNString(13));
					txtForBairro.setText(rs.getString(14));
					txtForCidade.setText(rs.getString(15));
					cboForUf.setSelectedItem(16);
					
					btnAdicionar.setEnabled(true);
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnBuscarCep.setEnabled(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
					txtUsuLogin.setEditable(false);
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEditable(true);
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
