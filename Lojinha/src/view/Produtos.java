package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBarCode;
	private JTextField txtCodigo;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtIdFor;
	private JTextField txtProduto;
	private JTextArea txtAreaDescricao;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JTextField txtFabricante;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMinimo;
	private JComboBox cboUnidade;
	private JTextField txtLocal;
	private JLabel lblNewLabel_1_1_1_1_2;
	private JLabel lblNewLabel_1_1_1_1_3;
	private JTextField txtLucro;
	private JTextField txtCusto;
	private JDateChooser dcValidade;
	private JDateChooser dcEntrada;
	private JTable tblFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
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
	public Produtos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/lojinha.png")));
		setTitle("Produtos");
		setModal(true);
		setBounds(100, 100, 874, 516);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setBounds(10, 11, 80, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(24, 83, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtBarCode = new JTextField();
		txtBarCode.addKeyListener(new KeyAdapter() {
			@Override
			//evento usado no leitor de codigo de barras
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					pesquisarProdutoBarcode();
				}
				
			}
		});
		
		txtBarCode.setBounds(96, 27, 186, 20);
		getContentPane().add(txtBarCode);
		txtBarCode.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProdutoCodigo();
			}
		});
		
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(70, 80, 196, 20);
		getContentPane().add(txtCodigo);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(276, 79, 111, 23);
		getContentPane().add(btnPesquisar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(397, 45, 451, 189);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(10, 27, 166, 20);
		panel.add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(20);
		
		lblPesquisarFornecedor = new JLabel("");
		lblPesquisarFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisarFornecedores();
			}
		});
		lblPesquisarFornecedor.setBounds(186, 15, 32, 32);
		lblPesquisarFornecedor.setIcon(new ImageIcon(Produtos.class.getResource("/img/pesquisar.png")));
		panel.add(lblPesquisarFornecedor);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(274, 30, 11, 14);
		panel.add(lblNewLabel_3);
		
		txtIdFor = new JTextField();
		txtIdFor.setBounds(295, 27, 136, 20);
		txtIdFor.setEditable(false);
		txtIdFor.setColumns(15);
		panel.add(txtIdFor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 421, 120);
		panel.add(scrollPane);
		
		tblFornecedor = new JTable();
		tblFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedor);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(70, 119, 202, 20);
		getContentPane().add(txtProduto);
		
		JLabel lblNewLabel_1_1 = new JLabel("Produto");
		lblNewLabel_1_1.setBounds(24, 122, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1_1.setBounds(10, 164, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtAreaDescricao = new JTextArea();
		txtAreaDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtAreaDescricao.setBounds(70, 160, 297, 106);
		getContentPane().add(txtAreaDescricao);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/createF.png")));
		btnAdicionar.setSelectedIcon(new ImageIcon(Produtos.class.getResource("/img/createF.png")));
		btnAdicionar.setBounds(542, 391, 64, 64);
		getContentPane().add(btnAdicionar);
		
		btnEditar = new JButton("");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setIcon(new ImageIcon(Produtos.class.getResource("/img/updateF.png")));
		btnEditar.setBounds(651, 391, 64, 64);
		getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/deleteF.png")));
		btnExcluir.setBounds(757, 391, 64, 64);
		getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fabricante");
		lblNewLabel_1_1_1_1.setBounds(10, 280, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(70, 280, 297, 20);
		getContentPane().add(txtFabricante);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Estoque");
		lblNewLabel_1_1_1_1_1.setBounds(10, 327, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtEstoque = new JTextField();
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(57, 324, 66, 20);
		getContentPane().add(txtEstoque);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Estoque minimo");
		lblNewLabel_1_1_1_1_1_1.setBounds(134, 327, 109, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.setColumns(10);
		txtEstoqueMinimo.setBounds(233, 324, 66, 20);
		getContentPane().add(txtEstoqueMinimo);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Unidade");
		lblNewLabel_1_1_1_1_1_2.setBounds(10, 367, 64, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1_2);
		
		cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] {"", "UN", "CX", "PÇ", "KG", "PCT","M"}));
		cboUnidade.setBounds(57, 363, 55, 29);
		getContentPane().add(cboUnidade);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(168, 364, 167, 20);
		getContentPane().add(txtLocal);
		
		lblNewLabel_1_1_1_1_2 = new JLabel("Local");
		lblNewLabel_1_1_1_1_2.setBounds(134, 367, 55, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		lblNewLabel_1_1_1_1_3 = new JLabel("Entrada");
		lblNewLabel_1_1_1_1_3.setBounds(397, 252, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_3);
		
		dcEntrada = new JDateChooser();
		dcEntrada.setBounds(446, 246, 123, 20);
		getContentPane().add(dcEntrada);
		
		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("Validade");
		lblNewLabel_1_1_1_1_3_1.setBounds(593, 252, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_3_1);
		
		dcValidade = new JDateChooser();
		dcValidade.setBounds(649, 246, 123, 20);
		getContentPane().add(dcValidade);
		
		JLabel lblNewLabel_1_1_1_1_3_2 = new JLabel("Custo");
		lblNewLabel_1_1_1_1_3_2.setBounds(397, 308, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_3_2);
		
		JLabel lblNewLabel_1_1_1_1_3_2_1 = new JLabel("Lucro(%)");
		lblNewLabel_1_1_1_1_3_2_1.setBounds(593, 308, 66, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_3_2_1);
		
		txtLucro = new JTextField();
		txtLucro.setBounds(651, 305, 64, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(434, 305, 135, 20);
		getContentPane().add(txtCusto);

	} // Fim do construtor
	
	DAO dao = new DAO();
	private JButton btnPesquisar;
	private JLabel lblPesquisarFornecedor;
	
	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID,fantasia as fornecedor,fone,contato from fornecedores where fantasia like ?";
		try {
			Connection con = dao.conectar();
	
			PreparedStatement pst = con.prepareStatement(readT);
			
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();

			tblFornecedor.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void setarCaixasTexto() {
		int setar = tblFornecedor.getSelectedRow();
		txtIdFor.setText(tblFornecedor.getModel().getValueAt(setar, 0).toString());
	}
	
	private void pesquisarProdutoCodigo() {
		String read = "select * from produtos where codigo = ?";
		try {			
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtCodigo.getText());			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtBarCode.setText(rs.getString(1));
				txtCodigo.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				txtLocal.setText(rs.getString(11));
				txtFabricante.setText(rs.getString(5));
				// JCalendar - formatação para exibição
				String setarDataCad = rs.getString(6);
				String setarDataVal = rs.getString(7);
				txtEstoque.setText(rs.getString(8));
				txtEstoqueMinimo.setText(rs.getString(9));
				cboUnidade.setSelectedItem(rs.getString(10));
				txtLocal.setText(rs.getString(11));
				txtCusto.setText(rs.getString(12));
				txtLucro.setText(rs.getString(13));
				//apoio a logica
				//System.out.println(setarDataCad);
				Date dataEntrada = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
				dcEntrada.setDate(dataEntrada);
				
				Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
				dcValidade.setDate(dataVal);
				//...
			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

private void pesquisarProdutoBarcode() {
	
		String read2 = "select * from produtos where barcode = ?";
		try {			
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtBarCode.getText());			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtCodigo.setText(rs.getString(1));
				txtBarCode.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				txtLocal.setText(rs.getString(11));
				txtFabricante.setText(rs.getString(5));
				// JCalendar - formatação para exibição
				String setarDataCad = rs.getString(6);
				String setarDataVal = rs.getString(7);
				txtEstoque.setText(rs.getString(8));
				txtEstoqueMinimo.setText(rs.getString(9));
				cboUnidade.setSelectedItem(rs.getString(10));
				txtLocal.setText(rs.getString(11));
				txtCusto.setText(rs.getString(12));
				txtLucro.setText(rs.getString(13));
				
				//apoio a logica
				//System.out.println(setarDataCad);
				Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
				dcEntrada.setDate(dataVal);
				
				Date dataVali = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
				dcValidade.setDate(dataVali);
				//...
			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void pesquisarFornecedores() {
		
		String read = "select * from fornecedores where idfor = ?;";
		try {

			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, txtIdFor.getText());

			ResultSet rs = pst.executeQuery();
			
			
			if (rs.next()) {
				txtIdFor.setText(rs.getString(0));
				limparCamposFornecedor();
			}
			con.close();
		} 	catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void adicionarProduto() {
		// validação
		
			// lógica principal
			String create = "insert into produtos (barcode, produto, descricao, fabricante, estoque, estoquemin, unidade, localizacao, custo, lucro) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(2, txtBarCode.getText());
				pst.setString(3, txtProduto.getText());
				pst.setString(4, txtAreaDescricao.getText());
				pst.setString(5, txtFabricante.getText());
				pst.setString(8, txtEstoque.getText());
				pst.setString(9, txtEstoqueMinimo.getText());
				pst.setString(10, cboUnidade.getSelectedItem().toString());
				pst.setString(11, txtLocal.getText());
				pst.setString(12, txtCusto.getText());
				pst.setString(13, txtLucro.getText());
				
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				limparCamposProdutos();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso");	
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se o telefone está inserido em outro contato");
			} catch (Exception e) {
				System.out.println(e);
			}
		 }


	private void limparCamposFornecedor() {
		//limpar a tabela
		((DefaultTableModel) tblFornecedor.getModel()).setRowCount(0);
	}
	
	private void limparCamposProdutos() {
		//limpar a tabela
		((DefaultTableModel) tblFornecedor.getModel()).setRowCount(0);
	}
}