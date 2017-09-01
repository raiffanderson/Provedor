package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCriacaoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private Provedor provedor = new Provedor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCriacaoCliente frame = new FrameCriacaoCliente();
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
	public FrameCriacaoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(49, 53, 220, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(49, 84, 104, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(49, 115, 104, 20);
		contentPane.add(textFieldRG);
		textFieldRG.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setModel(new DefaultComboBoxModel(Sexo.values()));
		comboBox.setBounds(49, 145, 86, 20);
		contentPane.add(comboBox);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 53, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 87, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(10, 115, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 148, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeCliente.setBounds(59, 11, 225, 31);
		contentPane.add(lblCadastroDeCliente);
		
		JButton btnCadastrat = new JButton("Cadastrar");
		btnCadastrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				provedor.cadastraCliente(lblNome,lblCpf,lblRg,lblSexo);
			}
		});
		btnCadastrat.setBounds(232, 170, 89, 23);
		contentPane.add(btnCadastrat);
	}
}
