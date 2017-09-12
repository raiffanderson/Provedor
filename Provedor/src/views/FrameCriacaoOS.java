package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.*;
import persistence.ReadFiles;
import persistence.WriteFiles;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import java.awt.Panel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;

public class FrameCriacaoOS extends JFrame {

	private JPanel contentPane;
	private DefaultListModel listModel; // Model que vai ser consumido pela
										// Jlist de clientes
	private JTextArea textAreaComentario; // Comentario que vai inserido na OS
	private JList listClientes; // jList responsavel por exibir os clientes
	private JScrollPane scrollPaneClientes; // scroolpanel que circunda a Jlist
											// dos clientes

	private Provedor provedor = new Provedor();
	FrameCriacaoCliente frameCriaCliente = new FrameCriacaoCliente();
	private ReadFiles reader;
	private WriteFiles writer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FrameCriacaoOS frame = new FrameCriacaoOS();
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
	public FrameCriacaoOS() {
		setTitle("PROVEDOR - Criar Ordem De Servi\u00E7o");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientes.setBounds(10, 11, 84, 33);
		contentPane.add(lblClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(10, 40, 541, 101);
		contentPane.add(scrollPaneClientes);

//		carregaClientes();
		updateListClientes();

		JButton btnNovoCliente = new JButton(" Novo Cliente");
		btnNovoCliente.setIcon(new ImageIcon((this.getClass().getResource("/newUser2.png"))));
		btnNovoCliente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNovoCliente.setBackground(SystemColor.control);
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCriaCliente.setVisible(true);
				frameCriaCliente.setProvedor(provedor);
				dispose();
			}
		});
		btnNovoCliente.setBounds(431, 152, 120, 38);
		contentPane.add(btnNovoCliente);

		JButton btnNewButton = new JButton("     Criar OS");
		btnNewButton.setIcon(new ImageIcon((this.getClass().getResource("/newTask.png"))));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrincipal frmPrincipal = new FramePrincipal();
				provedor.criaOS((Cliente) listClientes.getSelectedValue(), textAreaComentario.getText());
				frmPrincipal.setProvedor(provedor);
				frmPrincipal.updateListOS();
				frmPrincipal.getFramePrincipal().setVisible(true);
				dispose();
//				gravaOS();
			}
		});
		btnNewButton.setBounds(431, 192, 120, 38);
		contentPane.add(btnNewButton);

		JLabel lblComentrio = new JLabel("Coment\u00E1rio");
		lblComentrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComentrio.setBounds(10, 156, 120, 14);
		contentPane.add(lblComentrio);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 181, 384, 89);
		contentPane.add(scrollPane_1);

		textAreaComentario = new JTextArea();
		scrollPane_1.setViewportView(textAreaComentario);
		textAreaComentario.setLineWrap(true);

		JButton btnVoltar = new JButton("           Voltar");
		btnVoltar.setIcon(
				new ImageIcon(FrameCriacaoOS.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVoltar.setBackground(SystemColor.control);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrincipal frmPrincipal = new FramePrincipal();
				frmPrincipal.setProvedor(provedor);
				frmPrincipal.updateListOS();
				frmPrincipal.getFramePrincipal().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(431, 232, 120, 38);
		contentPane.add(btnVoltar);
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}

	public void updateListClientes() {
		listModel = provedor.getListaClientesModel();
		listClientes = new JList(listModel);
		scrollPaneClientes.setViewportView(listClientes);
	}

	void carregaClientes() {
		reader = new ReadFiles();
		reader.setClientes(provedor.getClientes());
		try {
			reader.readClientes();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updateListClientes();
	}
	
	private void gravaOS() {
		try {
			writer = new WriteFiles();
			writer.setOSs(provedor.getListaOSs());
			writer.gravaOSs();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
