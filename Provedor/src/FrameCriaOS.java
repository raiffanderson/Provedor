import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCriaOS {

	private JFrame frame;
	private Provedor provedor = new Provedor(); 
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCriaOS window = new FrameCriaOS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCriaOS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(10, 33, 46, 14);
		frame.getContentPane().add(lblClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 208, 77);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList(provedor.getListaClientesModel());
		scrollPane.setViewportView(list);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setBounds(290, 56, 89, 23);
		frame.getContentPane().add(btnNovoCliente);
		
		JButton btnCriarOs = new JButton("Criar OS");
		btnCriarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente clienteSelecionado = (Cliente) list.getSelectedValue();
				provedor.criaOS(clienteSelecionado, textArea.getText());
				
				frame.setVisible(false);;
			}
		});
		btnCriarOs.setBounds(290, 109, 89, 23);
		frame.getContentPane().add(btnCriarOs);
		
		JLabel lblComentrio = new JLabel("Coment\u00E1rio");
		lblComentrio.setBounds(10, 161, 75, 14);
		frame.getContentPane().add(lblComentrio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 186, 414, 64);
		frame.getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
	}
}
