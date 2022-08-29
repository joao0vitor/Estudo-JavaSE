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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Evento de digitação
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(85, 24, 199, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 125, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtForId = new JTextField();
		txtForId.setEditable(false);
		txtForId.setBounds(33, 123, 46, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CNPJ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(183, 125, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtForIE = new JTextField();
		txtForIE.setEditable(false);
		txtForIE.setBounds(511, 164, 148, 20);
		getContentPane().add(txtForIE);
		txtForIE.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("IE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(493, 166, 39, 14);
		getContentPane().add(lblNewLabel_3);

		txtForCNPJ = new JTextField();
		txtForCNPJ.setEditable(false);
		txtForCNPJ.setColumns(10);
		txtForCNPJ.setBounds(212, 123, 119, 20);
		getContentPane().add(txtForCNPJ);

		JLabel lblNewLabel_3_1 = new JLabel("IM");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(319, 166, 46, 14);
		getContentPane().add(lblNewLabel_3_1);

		txtForIM = new JTextField();
		txtForIM.setEditable(false);
		txtForIM.setColumns(10);
		txtForIM.setBounds(343, 164, 140, 20);
		getContentPane().add(txtForIM);

		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 166, 79, 14);
		getContentPane().add(lblNewLabel_5);

		txtForRazao = new JTextField();
		txtForRazao.setEditable(false);
		txtForRazao.setColumns(10);
		txtForRazao.setBounds(85, 164, 224, 20);
		getContentPane().add(txtForRazao);

		JLabel lblNewLabel_5_1 = new JLabel("Nome de Fant\u00E1sia");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(334, 125, 108, 14);
		getContentPane().add(lblNewLabel_5_1);

		txtForFantasia = new JTextField();
		txtForFantasia.setEditable(false);
		txtForFantasia.setColumns(10);
		txtForFantasia.setBounds(444, 123, 215, 20);
		getContentPane().add(txtForFantasia);

		JLabel lblNewLabel_2_1 = new JLabel("Site");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_1);

		txtForSite = new JTextField();
		txtForSite.setEditable(false);
		txtForSite.setColumns(10);
		txtForSite.setBounds(34, 211, 224, 20);
		getContentPane().add(txtForSite);

		JLabel lblNewLabel_2_2 = new JLabel("Fone");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(263, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Contato");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(286, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_3);

		txtForContato = new JTextField();
		txtForContato.setEditable(false);
		txtForContato.setColumns(10);
		txtForContato.setBounds(334, 249, 148, 20);
		getContentPane().add(txtForContato);

		JLabel lblNewLabel_2_1_1 = new JLabel("E-mail");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(10, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_1_1);

		txtForEmail = new JTextField();
		txtForEmail.setEditable(false);
		txtForEmail.setColumns(10);
		txtForEmail.setBounds(47, 249, 229, 20);
		getContentPane().add(txtForEmail);

		JLabel lblNewLabel_2_2_1 = new JLabel("CEP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(319, 287, 46, 14);
		getContentPane().add(lblNewLabel_2_2_1);

		btnBuscarCep = new JButton("Buscar Cep");
		btnBuscarCep.setEnabled(false);
		btnBuscarCep.setBounds(511, 284, 106, 23);
		getContentPane().add(btnBuscarCep);

		JLabel lblNewLabel_5_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(10, 287, 79, 14);
		getContentPane().add(lblNewLabel_5_2);

		JLabel lblNewLabel_2_3_1 = new JLabel("N\u00FAmero");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(511, 333, 46, 14);
		getContentPane().add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_5_3 = new JLabel("Complemento");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(453, 213, 79, 14);
		getContentPane().add(lblNewLabel_5_3);

		txtForEndereco = new JTextField();
		txtForEndereco.setEditable(false);
		txtForEndereco.setColumns(10);
		txtForEndereco.setBounds(65, 285, 241, 20);
		getContentPane().add(txtForEndereco);

		txtForNumero = new JTextField();
		txtForNumero.setEditable(false);
		txtForNumero.setColumns(10);
		txtForNumero.setBounds(559, 331, 73, 20);
		getContentPane().add(txtForNumero);

		txtForFone = new JTextField();
		txtForFone.setEditable(false);
		txtForFone.setColumns(10);
		txtForFone.setBounds(302, 211, 140, 20);
		getContentPane().add(txtForFone);

		txtForComplemento = new JTextField();
		txtForComplemento.setEditable(false);
		txtForComplemento.setColumns(10);
		txtForComplemento.setBounds(540, 211, 119, 20);
		getContentPane().add(txtForComplemento);

		JLabel lblNewLabel_2_3_2 = new JLabel("Bairro");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(10, 333, 46, 14);
		getContentPane().add(lblNewLabel_2_3_2);

		txtForBairro = new JTextField();
		txtForBairro.setEditable(false);
		txtForBairro.setColumns(10);
		txtForBairro.setBounds(47, 331, 186, 20);
		getContentPane().add(txtForBairro);

		JLabel lblNewLabel_5_2_1 = new JLabel("Cidade");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2_1.setBounds(250, 333, 56, 14);
		getContentPane().add(lblNewLabel_5_2_1);

		txtForCidade = new JTextField();
		txtForCidade.setEditable(false);
		txtForCidade.setColumns(10);
		txtForCidade.setBounds(291, 331, 186, 20);
		getContentPane().add(txtForCidade);

		JLabel lblNewLabel_2_1_2 = new JLabel("UF");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(511, 251, 34, 14);
		getContentPane().add(lblNewLabel_2_1_2);

		cboForUf = new JComboBox();
		cboForUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboForUf.setBounds(531, 248, 56, 22);
		getContentPane().add(cboForUf);

		txtForObs = new JTextArea();
		txtForObs.setEditable(false);
		txtForObs.setBounds(85, 378, 325, 56);
		getContentPane().add(txtForObs);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1.setBounds(10, 402, 73, 14);
		getContentPane().add(lblNewLabel_2_1_2_1);

		btnAdicionarFor = new JButton("");
		btnAdicionarFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdicionarFornecedor();
			}
		});
		btnAdicionarFor.setEnabled(false);
		btnAdicionarFor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarFor.setContentAreaFilled(false);
		btnAdicionarFor.setBorderPainted(false);
		btnAdicionarFor.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/add.png")));
		btnAdicionarFor.setToolTipText("Adicionar");
		btnAdicionarFor.setBounds(434, 386, 48, 48);
		getContentPane().add(btnAdicionarFor);

		btnAlterarFor = new JButton("");
		btnAlterarFor.setEnabled(false);
		btnAlterarFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarFornecedor();
			}
		});
		btnAlterarFor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterarFor.setContentAreaFilled(false);
		btnAlterarFor.setBorderPainted(false);
		btnAlterarFor.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/edit.png")));
		btnAlterarFor.setToolTipText("Alterar");
		btnAlterarFor.setBounds(509, 386, 48, 48);
		getContentPane().add(btnAlterarFor);

		btnExcluirFor = new JButton("");
		btnExcluirFor.setEnabled(false);
		btnExcluirFor.setContentAreaFilled(false);
		btnExcluirFor.setBorderPainted(false);
		btnExcluirFor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirFor.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/remove.png")));
		btnExcluirFor.setToolTipText("Remover");
		btnExcluirFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluirFor.setBounds(584, 386, 48, 48);
		getContentPane().add(btnExcluirFor);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 54, 591, 56);
		getContentPane().add(scrollPane);

		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

		btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFornecedores();
			}
		});
		btnPesquisar.setBounds(85, 122, 88, 23);
		getContentPane().add(btnPesquisar);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/search.png")));
		lblNewLabel_4.setBounds(294, 11, 48, 48);
		getContentPane().add(lblNewLabel_4);
		
		txtForCep = new JTextField();
		txtForCep.setEditable(false);
		txtForCep.setColumns(10);
		txtForCep.setBounds(344, 285, 148, 20);
		getContentPane().add(txtForCep);

	} // fim do construtor

	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnBuscarCep;
	private JTable tblFornecedores;
	private JScrollPane scrollPane;
	private JButton btnPesquisar;
	private JTextArea txtForObs;
	private JButton btnAlterarFor;
	private JButton btnExcluirFor;
	private JButton btnAdicionarFor;
	private JTextField txtForCep;

	/**
	 * Método responsavel pela pesquisa avançada do fornecedor usando o nome de
	 * fantasia e a biblioteca rs2xml
	 */

	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID ,fantasia as fornecedor,fone, contato from fornecedores where fantasia like ?";
		try {
			// estabelecer conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Substituir os ???? pelo conteudo das caixas de texto
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			// uso da biblioteca ts2xml para "popular" a tabela
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void setarCaixasTexto() {
		// criar uma variavel apra receber a linha da tabela
		int setar = tblFornecedores.getSelectedRow();
		txtForId.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
	}
	

	private void pesquisarFornecedores() {
		// validação
		if (txtForId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usúario inexistente");
			txtForCNPJ.setEditable(true);
			txtForIM.setEditable(true);
			txtForIE.setEditable(true);
			txtForSite.setEditable(true);
			txtForContato.setEditable(true);
			txtForEmail.setEditable(true);
			txtForObs.setEditable(true);
			txtForRazao.setEditable(true);
			txtForFantasia.setEditable(true);
			txtForFone.setEditable(true);
			btnBuscarCep.setEnabled(true);
			txtForEndereco.setEditable(true);
			txtForNumero.setEditable(true);
			txtForComplemento.setEditable(true);
			txtForCidade.setEditable(true);
			txtForBairro.setEditable(true);
			cboForUf.setSelectedItem(true);
			txtForObs.setEditable(true);
			btnAdicionarFor.setEnabled(true);
			btnPesquisar.setEnabled(false);
			limparCampos();
		} else {
			String read = "select * from fornecedores where idfor = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtForId.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					txtForCNPJ.setText(rs.getString(2));
					txtForIE.setText(rs.getString(3));
					txtForIM.setText(rs.getString(4));
					txtForRazao.setText(rs.getString(5));
					txtForFantasia.setText(rs.getString(6));
					txtForSite.setText(rs.getString(7));
					txtForFone.setText(rs.getString(8));
					txtForContato.setText(rs.getString(9));
					txtForEmail.setText(rs.getString(10));
					txtForCep.setText(rs.getString(11));
					txtForEndereco.setText(rs.getString(12));
					txtForNumero.setText(rs.getString(13));
					txtForComplemento.setText(rs.getString(14));
					txtForBairro.setText(rs.getString(15));
					txtForCidade.setText(rs.getString(16));
					cboForUf.setSelectedItem(rs.getString(17));
					txtForObs.setText(rs.getString(18));
					btnAlterarFor.setEnabled(true);
					btnExcluirFor.setEnabled(true);
					btnAdicionarFor.setEnabled(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usúario inexistente");
					txtForCNPJ.setEditable(true);
					txtForIM.setEditable(true);
					txtForIE.setEditable(true);
					txtForSite.setEditable(true);
					txtForContato.setEditable(true);
					txtForEmail.setEditable(true);
					txtForObs.setEditable(true);
					txtForRazao.setEditable(true);
					txtForFantasia.setEditable(true);
					txtForFone.setEditable(true);
					btnBuscarCep.setEnabled(true);
					txtForEndereco.setEditable(true);
					txtForNumero.setEditable(true);
					txtForComplemento.setEditable(true);
					txtForCidade.setEditable(true);
					txtForBairro.setEditable(true);
					cboForUf.setSelectedItem(true);
					txtForObs.setEditable(true);
					btnAdicionarFor.setEnabled(true);
					btnPesquisar.setEnabled(false);
					limparCampos();
				}

				// Nunca esquecer de encerrar a conexão
				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtForId.setText(null);
				txtForId.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
	
	/**
	 * Método responsavel por adicionar um novo cliente no banco
	 */
	private void AdicionarFornecedor() {
		// Validação
		if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtForFone.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone");
			txtForFone.requestFocus();
		} else if (txtForEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha seu email");
			txtForEmail.requestFocus();
		} else {
			// lógica principal
			String create = "insert into fornecedores (idfor, cnpj, ie, im, razao, fantasia, site, fone, contato, email, cep, endereco, numero, complemento, bairro, cidade, uf, obs) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				
				pst.setString(2, txtForCNPJ.getText());
				pst.setString(3, txtForIE.getText());
				pst.setString(4, txtForIM.getText());
				pst.setString(5, txtForRazao.getText());
				pst.setString(6, txtForFantasia.getText());
				pst.setString(7, txtForSite.getText());
				pst.setString(8, txtForFone.getText());
				pst.setString(9, txtForContato.getText());
				pst.setString(10, txtForEmail.getText());
				pst.setString(11, txtForCep.getText());
				pst.setString(12, txtForEndereco.getText());
				pst.setString(13, txtForNumero.getText());
				pst.setString(14, txtForComplemento.getText());
				pst.setString(15, txtForBairro.getText());
				pst.setString(16, txtForCidade.getText());
				pst.setString(13, cboForUf.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "CPF em uso. \nEscolha outro cpf.");
				txtForCNPJ.requestFocus();
				txtForCNPJ.setText(null);
			
				JOptionPane.showMessageDialog(null, "Esse Site em uso. \nEscolha outro link");
				txtForSite.requestFocus();
				txtForSite.setText(null);
				
				JOptionPane.showMessageDialog(null, "Telefone em uso. \nEscolha outro telefone.");
				txtForFone.requestFocus();
				txtForFone.setText(null);
				
				JOptionPane.showMessageDialog(null, "Email em uso. \nEscolha outro email.");
				txtForEmail.requestFocus();
				txtForEmail.setText(null);
				
				JOptionPane.showMessageDialog(null, "Numero em uso. \nEscolha outro numero.");
				txtForNumero.requestFocus();
				txtForNumero.setText(null);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		  }
		}
	
	/**
	 * Metodo alterar fornecedor no banco
	 */

	private void AtualizarFornecedor() {


		// Validação
		if (txtForCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome");
			txtForCNPJ.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a razão");
			txtForRazao.requestFocus();
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome fantasia");
			txtForFantasia.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone");
			txtForFone.requestFocus();
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Cep");
			txtForCep.requestFocus();
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o endereço");
			txtForEndereco.requestFocus();
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o numero da residencia");
			txtForNumero.requestFocus();
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o bairro");
			txtForBairro.requestFocus();
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a cidade");
			txtForCidade.requestFocus();
		} else if (cboForUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboForUf.requestFocus();
		} else {
			// lógica principal
			String update = "update fornecedores set fornecedores=?, cnpj=?, ie=?, im=?, razao=?, fantasia=?, site=?, fone=?, contato=?, email=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, uf=?, obs=?;";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(2, txtForCNPJ.getText());
				pst.setString(3, txtForIE.getText());
				pst.setString(4, txtForIM.getText());
				pst.setString(5, txtForRazao.getText());
				pst.setString(6, txtForFantasia.getText());
				pst.setString(7, txtForSite.getText());
				pst.setString(8, txtForFone.getText());
				pst.setString(9, txtForContato.getText());
				pst.setString(10, txtForEmail.getText());
				pst.setString(11, txtForCep.getText());
				pst.setString(12, txtForEndereco.getText());
				pst.setString(13, txtForNumero.getText());
				pst.setString(14, txtForComplemento.getText());
				pst.setString(15, txtForBairro.getText());
				pst.setString(16, txtForCidade.getText());
				pst.setString(17, cboForUf.getSelectedItem().toString());
				pst.setString(18, txtForObs.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Dados do fornecedor alterados com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Nome fantasia em uso. \nEscolha outro nome.");
				txtForFantasia.requestFocus();
				txtForFantasia.setText(null);
				
				JOptionPane.showMessageDialog(null, "Cnpj em uso. \nEscolha outro cnpj.");
				txtForCNPJ.requestFocus();
				txtForCNPJ.setText(null);
				
				JOptionPane.showMessageDialog(null, "Site em uso. \nEscolha outro site.");
				txtForSite.requestFocus();
				txtForSite.setText(null);
				
				JOptionPane.showMessageDialog(null, "Telefone em uso. \nEscolha outro telefone.");
				txtForFone.requestFocus();
				txtForFone.setText(null);
				
				JOptionPane.showMessageDialog(null, "Email em uso. \nEscolha outro email.");
				txtForEmail.requestFocus();
				txtForEmail.setText(null);
				
				JOptionPane.showMessageDialog(null, "Numero em uso. \nEscolha outro numero da residencia.");
				txtForNumero.requestFocus();
				txtForNumero.setText(null);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Método excluir usuario do banco
	 */
	
	private void excluirFornecedor() {
		// validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a exclusão do usuário?","Atenção!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// Logica principal
			String delete = "Delete from Fornecedores where iduser=?;";
			
			try {
				// Estabelecer a conexão
				Connection con = dao.conectar();

				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(delete);

				// Substituir o ? pelo conteúdo da caixa de texto
				pst.setString(1, txtForId.getText());

				// Executar a query e inserir o usuário no banco
				pst.executeUpdate();

				limparCampos();

				// Exibir mensagem ao inserir usuário excluido
				JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");

				// NUNCA esquecer de encerrar a conexão
				con.close();

			  } catch (Exception e) {
					System.out.println(e);
				}
		      }
			}
	
	
	 /**
	 * Metodo usado para limpar e validar os campos e objetos do formulario
	 */
	private void limparCampos() {
		txtForId.setText(null);
		txtForCNPJ.setText(null);
		txtPesquisarFornecedor.setText(null);
		txtForFone.setText(null);
		txtForRazao.setText(null);
		txtForFantasia.setText(null);
		cboForUf.setSelectedItem(null);
		txtForCidade.setText(null);
		txtForEndereco.setText(null);
		txtForNumero.setText(null);
		txtForBairro.setText(null);
		
	}
}
