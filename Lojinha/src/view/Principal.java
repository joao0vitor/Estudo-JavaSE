package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			// Evento ativar janela
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador =
DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
			}
		});
		setResizable(false);
		setTitle("LhL cell");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/logolojinha.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBounds(479, 24, 64, 64);
		contentPane.add(btnSobre);
		
		JButton btnCliente = new JButton("");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Cliente client = new Cliente();
				client.setVisible(true);
			}
		});
		btnCliente.setToolTipText("Clientes");
		btnCliente.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente.png")));
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setBounds(148, 196, 128, 128);
		contentPane.add(btnCliente);
		
		JButton btnFornecedores = new JButton("");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor forne = new Fornecedor();
				forne.setVisible(true);
			}
		});
		btnFornecedores.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedor.png")));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setBounds(317, 24, 128, 128);
		contentPane.add(btnFornecedores);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto prod = new Produto();
				prod.setVisible(true);
			}
		});
		btnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/img/produtos.png")));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setBounds(162, 24, 128, 128);
		contentPane.add(btnProdutos);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 348, 582, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setForeground(SystemColor.window);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(290, 11, 271, 29);
		panel.add(lblData);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(311, 12, 0, 0);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setBackground(SystemColor.textHighlight);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Link para JDialog
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuarios.png")));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setBounds(10, 24, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnPdv = new JButton("");
		btnPdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pdv pdvs = new Pdv();
				pdvs.setVisible(true);
			}
		});
		btnPdv.setIcon(new ImageIcon(Principal.class.getResource("/img/pdv.png")));
		btnPdv.setToolTipText("Pedidos de venda");
		btnPdv.setBounds(10, 196, 128, 128);
		contentPane.add(btnPdv);
		
		JButton btnFerramenta = new JButton("");
		btnFerramenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramenta tool = new Ferramenta();
				tool.setVisible(true);
			}
		});
		btnFerramenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFerramenta.setIcon(new ImageIcon(Principal.class.getResource("/img/configura\u00E7\u00E3o.png")));
		btnFerramenta.setToolTipText("Ferramentas");
		btnFerramenta.setBounds(286, 196, 128, 128);
		contentPane.add(btnFerramenta);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/img/relatorio.png")));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio report = new Relatorio();
				report.setVisible(true);
			}
		});
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setToolTipText("Relatorio");
		btnRelatorio.setBounds(434, 196, 128, 128);
		contentPane.add(btnRelatorio);
	} // fim do construtor
}
