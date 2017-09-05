package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import entity.*;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import java.awt.Window.Type;

public class FramePrincipal {

	private JFrame framePrincipal;
	DefaultListModel listModelOSs = new DefaultListModel();			//Model que vai ser consumido pela Jlist de OSs
	JList jListOSs = new JList();													//jList responsavel por exibir as OSs
	JScrollPane scrollPaneOSs;										//scroolpanel que circunda a Jlist das OSs

	private Provedor provedor = new Provedor();
	private FrameCriacaoOS frameCriaOS = new FrameCriacaoOS();
	protected boolean onlyOpen = false;							//Flag responsavel por setar se as OS mostradas vão ser todas ou apenas as em status aberto
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
		getFramePrincipal().setBounds(100, 100, 748, 320);
		getFramePrincipal().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFramePrincipal().getContentPane().setLayout(null);

		JLabel lblOrdensDeServio = new JLabel("Ordens De Servi\u00E7o");
		lblOrdensDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdensDeServio.setFont(new Font("Courier New", Font.BOLD, 24));
		lblOrdensDeServio.setBounds(273, 0, 261, 53);
		getFramePrincipal().getContentPane().add(lblOrdensDeServio);

		scrollPaneOSs = new JScrollPane();
		scrollPaneOSs.setBounds(119, 63, 609, 200);
		getFramePrincipal().getContentPane().add(scrollPaneOSs);

		this.frameCriaOS.setProvedor(provedor);
		
		updateListOS();

		JButton btnNewButton = new JButton("CRIAR");
		btnNewButton.setToolTipText("Cria uma novo OS.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrameCriaOS().setVisible(true);
				getFrameCriaOS().setProvedor(provedor);
				getFrameCriaOS().updateListClientes();
				getFramePrincipal().dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(11, 97, 96, 23);
		getFramePrincipal().getContentPane().add(btnNewButton);

		JButton btnDeletar = new JButton("CANCELAR");
		btnDeletar.setToolTipText("Cancela um OS.");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provedor.atualizarStatusOS((OrdemDeServico) jListOSs.getSelectedValue(),Status.CANCELADO);
				updateListOS();
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDeletar.setBounds(10, 132, 96, 23);
		getFramePrincipal().getContentPane().add(btnDeletar);

		JButton btnAtualizar_1 = new JButton("FECHAR");
		btnAtualizar_1.setToolTipText("Fecha um SO. (Procedimento realizado para informar que a resolu\u00E7\u00E3o do problema foi conclu\u00EDda)");
		btnAtualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				provedor.atualizarStatusOS((OrdemDeServico) jListOSs.getSelectedValue(),Status.FECHADO);
				updateListOS();
			}
		});
		btnAtualizar_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtualizar_1.setBounds(10, 167, 96, 23);
		getFramePrincipal().getContentPane().add(btnAtualizar_1);
		
		JRadioButton rdbtnMostrarApenasEm = new JRadioButton("Mostrar apenas em \"Aberto\"");
		rdbtnMostrarApenasEm.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnMostrarApenasEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMostrarApenasEm.isSelected()){
					onlyOpen = true;
				}
				else{
					onlyOpen = false;
				}
				updateListOS();
			}
		});
		rdbtnMostrarApenasEm.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnMostrarApenasEm.setBounds(554, 264, 174, 23);
		framePrincipal.getContentPane().add(rdbtnMostrarApenasEm);

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
		jListOSs.setModel(provedor.getListaOSsModel(onlyOpen));
		scrollPaneOSs.setViewportView(jListOSs);
	}
}
