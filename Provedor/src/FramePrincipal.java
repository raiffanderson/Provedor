

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class FramePrincipal {

	private JFrame framePrincipal;
	Provedor provedor = new Provedor();
	DefaultListModel listModel = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePrincipal = new JFrame();
		framePrincipal.setResizable(false);
		framePrincipal.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 14));
		framePrincipal.setTitle("PROVEDOR");
		framePrincipal.setBounds(100, 100, 767, 400);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.getContentPane().setLayout(null);
		
		JLabel lblOrdensDeServio = new JLabel("Ordem De Servi\u00E7o");
		lblOrdensDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdensDeServio.setFont(new Font("Courier New", Font.BOLD, 24));
		lblOrdensDeServio.setBounds(288, 37, 261, 53);
		framePrincipal.getContentPane().add(lblOrdensDeServio);
		
		//JButton btnAtualizar = new JButton("Alterar");
		//btnAtualizar.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {

			//}
		//});
		//btnAtualizar.setBounds(517, 57, 118, 23);
		//framePrincipal.getContentPane().add(btnAtualizar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(134, 100, 609, 200);
		framePrincipal.getContentPane().add(scrollPane_1);
		
		
		listModel = provedor.getListaOSsModel();
		JList list = new JList(listModel);
		scrollPane_1.setViewportView(list);
		
		JButton btnNewButton = new JButton("CRIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCriacaoOS frameCriaOS = new FrameCriacaoOS();
				frameCriaOS.setVisible(true);
//				DefaultListModel listModelClientes = new DefaultListModel<>()
//				listModel.addElement(element);
				provedor.criaOS(new Cliente(20, 464897, 68141, Sexo.MASCULINO, 1, "Basico"),"");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(26, 134, 96, 23);
		framePrincipal.getContentPane().add(btnNewButton);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDeletar.setBounds(25, 169, 96, 23);
		framePrincipal.getContentPane().add(btnDeletar);
		
		JButton btnAtualizar_1 = new JButton("ALTERAR");
		btnAtualizar_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtualizar_1.setBounds(25, 204, 96, 23);
		framePrincipal.getContentPane().add(btnAtualizar_1);
				
	}
}
