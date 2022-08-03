package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class Cliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		setBounds(100, 100, 729, 402);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 133, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(36, 131, 114, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 30, 46, 14);
		getContentPane().add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 28, 202, 20);
		getContentPane().add(textField_1);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(222, 133, 46, 14);
		getContentPane().add(lblCpf);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 131, 171, 20);
		getContentPane().add(textField_2);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCep.setBounds(483, 170, 46, 14);
		getContentPane().add(lblCep);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(513, 168, 153, 20);
		getContentPane().add(textField_3);
		
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
		lblFone.setBounds(20, 170, 46, 14);
		getContentPane().add(lblFone);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(63, 168, 171, 20);
		getContentPane().add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(262, 170, 46, 14);
		getContentPane().add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 168, 171, 20);
		getContentPane().add(textField_5);
		
		JLabel lblMarketing = new JLabel("Deseja receber promo\u00E7\u00F5es por email ?");
		lblMarketing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarketing.setBounds(20, 315, 230, 18);
		getContentPane().add(lblMarketing);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereo.setBounds(10, 208, 70, 14);
		getContentPane().add(lblEndereo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(73, 206, 220, 20);
		getContentPane().add(textField_6);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmero.setBounds(315, 208, 70, 14);
		getContentPane().add(lblNmero);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(365, 206, 111, 20);
		getContentPane().add(textField_7);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComplemento.setBounds(486, 208, 84, 14);
		getContentPane().add(lblComplemento);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(567, 206, 111, 20);
		getContentPane().add(textField_8);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBairro.setBounds(10, 258, 48, 14);
		getContentPane().add(lblBairro);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(48, 256, 220, 20);
		getContentPane().add(textField_9);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidade.setBounds(294, 258, 57, 14);
		getContentPane().add(lblCidade);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(341, 256, 111, 20);
		getContentPane().add(textField_10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUf.setBounds(483, 258, 46, 14);
		getContentPane().add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(513, 255, 57, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		comboBox_1.setBounds(251, 314, 57, 22);
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Cliente.class.getResource("/img/add.png")));
		btnNewButton_1.setToolTipText("Adicionar");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(513, 304, 48, 48);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(Cliente.class.getResource("/img/edit.png")));
		btnNewButton_1_1.setToolTipText("Alterar");
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(584, 304, 48, 48);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setToolTipText("Remover");
		btnNewButton_1_2.setIcon(new ImageIcon(Cliente.class.getResource("/img/remove.png")));
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(655, 304, 48, 48);
		getContentPane().add(btnNewButton_1_2);

	}

}
