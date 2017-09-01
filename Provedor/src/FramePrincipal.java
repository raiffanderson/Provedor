
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
	private Provedor provedor = new Provedor();
	DefaultListModel listModel = new DefaultListModel();
	private FrameCriacaoOS frameCriaOS = new FrameCriacaoOS();
	JList list;
	JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.getFramePrincipal().setVisible(true);
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
		setFramePrincipal(new JFrame());
		getFramePrincipal().setResizable(false);
		getFramePrincipal().setFont(new Font("Bodoni MT Condensed", Font.BOLD, 14));
		getFramePrincipal().setTitle("PROVEDOR");
		getFramePrincipal().setBounds(100, 100, 767, 400);
		getFramePrincipal().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFramePrincipal().getContentPane().setLayout(null);

		JLabel lblOrdensDeServio = new JLabel("Ordem De Servi\u00E7o");
		lblOrdensDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdensDeServio.setFont(new Font("Courier New", Font.BOLD, 24));
		lblOrdensDeServio.setBounds(288, 37, 261, 53);
		getFramePrincipal().getContentPane().add(lblOrdensDeServio);

		// JButton btnAtualizar = new JButton("Alterar");
		// btnAtualizar.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {

		// }
		// });
		// btnAtualizar.setBounds(517, 57, 118, 23);
		// framePrincipal.getContentPane().add(btnAtualizar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(134, 100, 609, 200);
		getFramePrincipal().getContentPane().add(scrollPane_1);

		this.frameCriaOS.setProvedor(provedor);
		;
		listModel = getProvedor().getListaOSsModel();
		list = new JList(listModel);
		scrollPane_1.setViewportView(list);

		// provedor.criaOS(new Cliente(28, 654, 1894, Sexo.MASCULINO, 0,
		// null),"Inadimplencia");

		JButton btnNewButton = new JButton("CRIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrameCriaOS().setVisible(true);
				getFrameCriaOS().setProvedor(provedor);
				getFramePrincipal().dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(26, 134, 96, 23);
		getFramePrincipal().getContentPane().add(btnNewButton);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDeletar.setBounds(25, 169, 96, 23);
		getFramePrincipal().getContentPane().add(btnDeletar);

		JButton btnAtualizar_1 = new JButton("ALTERAR");
		btnAtualizar_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtualizar_1.setBounds(25, 204, 96, 23);
		getFramePrincipal().getContentPane().add(btnAtualizar_1);

	}

	public JFrame getFramePrincipal() {
		return framePrincipal;
	}

	public void setFramePrincipal(JFrame framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

	public FrameCriacaoOS getFrameCriaOS() {
		return frameCriaOS;
	}

	public void setFrameCriaOS(FrameCriacaoOS frameCriaOS) {
		this.frameCriaOS = frameCriaOS;
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;

	}

	public void updateListOS() {
		list.setModel(provedor.getListaOSsModel());
		scrollPane_1.updateUI();
	}
}
