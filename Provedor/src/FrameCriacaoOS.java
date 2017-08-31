import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCriacaoOS extends JFrame {

	private JPanel contentPane;
	protected static Provedor provedor = new Provedor();
	private JTextField textFieldComentario;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 230, 89);
		contentPane.add(scrollPane);
		
		JList list = new JList(provedor.getListaClientesModel());
		
		scrollPane.setViewportView(list);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setBounds(281, 54, 113, 23);
		contentPane.add(btnNovoCliente);
		
		JButton btnNewButton = new JButton("Criar OS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provedor.criaOS((Cliente) list.getSelectedValue(),textFieldComentario.getText());
			}
		});
		btnNewButton.setBounds(281, 88, 113, 23);
		contentPane.add(btnNewButton);
		
		textFieldComentario = new JTextField();
		textFieldComentario.setBounds(10, 178, 384, 51);
		contentPane.add(textFieldComentario);
		textFieldComentario.setColumns(10);
		
		JLabel lblComentrio = new JLabel("Coment\u00E1rio");
		lblComentrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComentrio.setBounds(10, 156, 120, 14);
		contentPane.add(lblComentrio);
	}
}
