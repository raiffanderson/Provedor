

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
		framePrincipal.setBounds(100, 100, 735, 400);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.getContentPane().setLayout(null);
		
		JLabel lblOrdensDeServio = new JLabel("Ordens De Servi\u00E7o");
		lblOrdensDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdensDeServio.setFont(new Font("Courier New", Font.BOLD, 24));
		lblOrdensDeServio.setBounds(102, 40, 261, 53);
		framePrincipal.getContentPane().add(lblOrdensDeServio);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnAtualizar.setBounds(517, 57, 89, 23);
		framePrincipal.getContentPane().add(btnAtualizar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(110, 100, 600, 200);
		framePrincipal.getContentPane().add(scrollPane_1);
		
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement(provedor.getListaOSs().get(0));
		listModel.addElement(provedor.getListaOSs().get(1));
		JList list = new JList(listModel);
		scrollPane_1.setViewportView(list);
		
		JButton btnNewButton = new JButton("CRIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				listModel.addElement(element);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(10, 104, 89, 23);
		framePrincipal.getContentPane().add(btnNewButton);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDeletar.setBounds(11, 138, 89, 23);
		framePrincipal.getContentPane().add(btnDeletar);
		
		JButton btnAtualizar_1 = new JButton("ATUALIZAR");
		btnAtualizar_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtualizar_1.setBounds(11, 172, 89, 23);
		framePrincipal.getContentPane().add(btnAtualizar_1);
				
	}
}
