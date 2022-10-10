package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import javax.swing.ImageIcon;

public class Relatorios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Relatorios dialog = new Relatorios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Relatorios() {
		setModal(true);
		setTitle("Relat\u00F3rios");
		setBounds(100, 100, 571, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnRelClientes = new JButton("");
		btnRelClientes.setIcon(new ImageIcon(Relatorios.class.getResource("/img/cliente (2).png")));
		btnRelClientes.setToolTipText("Cliente");
		btnRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnRelClientes.setBounds(65, 60, 64, 64);
		contentPanel.add(btnRelClientes);
		
		btnrelFornecedores = new JButton("");
		btnrelFornecedores.setIcon(new ImageIcon(Relatorios.class.getResource("/img/fornecedor (2).png")));
		btnrelFornecedores.setToolTipText("Fornecedores");
		btnrelFornecedores.setBounds(424, 227, 64, 64);
		contentPanel.add(btnrelFornecedores);
		
		JButton btnRelVencidos = new JButton("");
		btnRelVencidos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/vencido.png")));
		btnRelVencidos.setToolTipText("Produtos vencidos");
		btnRelVencidos.setBounds(65, 227, 64, 64);
		contentPanel.add(btnRelVencidos);
		
		btnRelReposicao = new JButton("");
		btnRelReposicao.setIcon(new ImageIcon(Relatorios.class.getResource("/img/repositorio.png")));
		btnRelReposicao.setToolTipText("Reposi\u00E7\u00E3o de estoque");
		btnRelReposicao.setBounds(242, 227, 64, 64);
		contentPanel.add(btnRelReposicao);
		
		btnRelInventario = new JButton("");
		btnRelInventario.setToolTipText("Invent\u00E1rio");
		btnRelInventario.setIcon(new ImageIcon(Relatorios.class.getResource("/img/inventario.png")));
		btnRelInventario.setBounds(424, 60, 64, 64);
		contentPanel.add(btnRelInventario);
		
		btnRelMarketing = new JButton("");
		btnRelMarketing.setToolTipText("E-mail marketing");
		btnRelMarketing.setIcon(new ImageIcon(Relatorios.class.getResource("/img/email.png")));
		btnRelMarketing.setBounds(242, 60, 64, 64);
		contentPanel.add(btnRelMarketing);
	}//fim do construtor
	
	//acesso ao banco de dados
	DAO dao = new DAO();
	private JButton btnRelInventario;
	private JButton btnrelFornecedores;
	private JButton btnRelMarketing;
	private JButton btnRelClientes;
	private JButton btnRelReposicao;
	
	//metodo responsavel pela impressao do relatorio de clientes
	private void relatorioClientes() {
		//criar objeto para construir a pagina pdf
		Document document = new Document();
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			//gerar o conteudo do documento
			document.add(new Paragraph("Clientes cadastrados"));
			//... Demais conteudos (imagem, tabela, grafico, etc)
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o codigo independente do resultado OK ou nao 
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padrao de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}