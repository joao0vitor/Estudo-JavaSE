package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fornecedor extends JDialog {

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
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_8;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

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
		
		textField = new JTextField();
		textField.setBounds(85, 24, 199, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 125, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 123, 79, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(122, 125, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(328, 123, 140, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(316, 125, 39, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(154, 123, 152, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("IM");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(478, 125, 46, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(501, 123, 148, 20);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 166, 79, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(85, 164, 224, 20);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nome de Fant\u00E1sia");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(326, 166, 108, 14);
		getContentPane().add(lblNewLabel_5_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(434, 160, 215, 20);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Site");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(34, 211, 224, 20);
		getContentPane().add(textField_7);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fone");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(268, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Contato");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(450, 213, 46, 14);
		getContentPane().add(lblNewLabel_2_3);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(501, 211, 148, 20);
		getContentPane().add(textField_9);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("E-mail");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(10, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(47, 249, 229, 20);
		getContentPane().add(textField_10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("CEP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(316, 251, 46, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JButton btnNewButton = new JButton("Buscar Cep");
		btnNewButton.setBounds(350, 248, 106, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(10, 287, 79, 14);
		getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("N\u00FAmero");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_1.setBounds(316, 287, 46, 14);
		getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Complemento");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(445, 287, 79, 14);
		getContentPane().add(lblNewLabel_5_3);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(65, 285, 241, 20);
		getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(362, 285, 73, 20);
		getContentPane().add(textField_12);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(300, 211, 140, 20);
		getContentPane().add(textField_8);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(530, 285, 119, 20);
		getContentPane().add(textField_13);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Bairro");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(10, 333, 46, 14);
		getContentPane().add(lblNewLabel_2_3_2);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(47, 331, 186, 20);
		getContentPane().add(textField_14);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Cidade");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2_1.setBounds(250, 333, 56, 14);
		getContentPane().add(lblNewLabel_5_2_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(291, 331, 186, 20);
		getContentPane().add(textField_15);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("UF");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2.setBounds(502, 333, 34, 14);
		getContentPane().add(lblNewLabel_2_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(520, 330, 56, 22);
		getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(85, 378, 325, 56);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_2_1.setBounds(10, 402, 73, 14);
		getContentPane().add(lblNewLabel_2_1_2_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/add.png")));
		btnNewButton_1.setToolTipText("Adicionar");
		btnNewButton_1.setBounds(434, 386, 48, 48);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/edit.png")));
		btnNewButton_1_1.setToolTipText("Alterar");
		btnNewButton_1_1.setBounds(509, 386, 48, 48);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/remove.png")));
		btnNewButton_1_2.setToolTipText("Remover");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setBounds(584, 386, 48, 48);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/search.png")));
		btnNewButton_2.setToolTipText("Pesquisar");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setAutoscrolls(true);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(294, 11, 48, 48);
		getContentPane().add(btnNewButton_2);

	}
}
