package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.*;
import persistence.ReadFiles;
import persistence.WriteFiles;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class FrameCriacaoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private Provedor provedor = new Provedor();
	private WriteFiles writer;
	private ReadFiles reader;

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
		setTitle("PROVEDOR - Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		comboBox.setBackground(SystemColor.control);
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
		lblRg.setBounds(10, 118, 46, 14);
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
		btnCadastrat.setIcon(new ImageIcon(FrameCriacaoOS.class.getResource("/save.png")));
		btnCadastrat.setIconTextGap(5);
		btnCadastrat.setBackground(SystemColor.control);
		btnCadastrat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameCriacaoOS frameCriaOS = new FrameCriacaoOS();
				provedor.cadastraCliente(textFieldNome.getText(), Integer.parseInt(textFieldCPF.getText()),
						Integer.parseInt(textFieldRG.getText()), (Sexo) comboBox.getSelectedItem(), new Date(),
						"Basico");
				frameCriaOS.setProvedor(provedor);
				frameCriaOS.updateListClientes();
				frameCriaOS.setVisible(true);
				dispose();
				//gravaClientes();
			}
		});
		btnCadastrat.setBounds(267, 170, 117, 30);
		contentPane.add(btnCadastrat);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setIcon(new ImageIcon((this.getClass().getResource("/back-icon.png"))));
		btnNewButton.setIconTextGap(10);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCriacaoOS frameCriaOS = new FrameCriacaoOS();
				frameCriaOS.setProvedor(provedor);
				frameCriaOS.updateListClientes();
				frameCriaOS.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(174, 170, 86, 30);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(FrameCriacaoOS.class.getResource("/addUser4.png")));
		label.setBounds(198, 30, 210, 159);
		contentPane.add(label);
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}

	private void gravaClientes() {
		try {
			writer = new WriteFiles();
			writer.setClientes(provedor.getClientes());
			writer.gravaClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
