package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FrameCriacaoOS extends JFrame {

	private JPanel contentPane;
	private DefaultListModel listModel; 				//Model que vai ser consumido pela Jlist de clientes
	private JTextArea textAreaComentario;				//Comentario que vai inserido na OS
	private JList listClientes;							//jList responsavel por exibir os clientes
	private JScrollPane scrollPaneClientes;				//scroolpanel que circunda a Jlist dos clientes

	private Provedor provedor = new Provedor();
	FrameCriacaoCliente frameCriaCliente = new FrameCriacaoCliente();
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
	public FrameCriacaoOS( ) {
		setTitle("PROVEDOR - Criar Ordem De Servi\u00E7o");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientes.setBounds(10, 11, 84, 33);
		contentPane.add(lblClientes);
		
		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(10, 40, 230, 89);
		contentPane.add(scrollPaneClientes);
		
		listModel = provedor.getListaClientesModel();
		listClientes = new JList(listModel);
		scrollPaneClientes.setViewportView(listClientes);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCriaCliente.setVisible(true);
				frameCriaCliente.setProvedor(provedor);
				dispose();
			}
		});
		btnNovoCliente.setBounds(281, 40, 113, 23);
		contentPane.add(btnNovoCliente);

		JButton btnNewButton = new JButton("Criar OS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrincipal frmPrincipal = new FramePrincipal();
				provedor.criaOS((Cliente) listClientes.getSelectedValue(),textAreaComentario.getText());
				frmPrincipal.setProvedor(provedor);
				frmPrincipal.updateListOS();
				frmPrincipal.getFramePrincipal().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(281, 74, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblComentrio = new JLabel("Coment\u00E1rio");
		lblComentrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComentrio.setBounds(10, 156, 120, 14);
		contentPane.add(lblComentrio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 181, 384, 48);
		contentPane.add(scrollPane_1);
		
		textAreaComentario = new JTextArea();
		scrollPane_1.setViewportView(textAreaComentario);
		textAreaComentario.setLineWrap(true);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrincipal frmPrincipal = new FramePrincipal();
				frmPrincipal.setProvedor(provedor);
				frmPrincipal.updateListOS();
				frmPrincipal.getFramePrincipal().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(281, 108, 113, 23);
		contentPane.add(btnVoltar);
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}
	
	public void updateListClientes() {
		listClientes.setModel(provedor.getListaClientesModel());
		scrollPaneClientes.updateUI();
	}
}
