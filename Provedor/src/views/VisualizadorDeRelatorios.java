package views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Controller.GeradoraDeRelatorios;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizadorDeRelatorios {

	private JFrame frame;
	private PanelDeRelatorio relatorioClientesSimples = new views.PanelDeRelatorio(
			"files/RelatorioDeClientesPadrao.txt");
	private PanelDeRelatorio relatorioCLientesPorSexo = new views.PanelDeRelatorio(
			"files/RelatorioDeClientesPorSexo.txt");
	private PanelDeRelatorio relatorioOsSimples = new views.PanelDeRelatorio("files/RelatorioOSsPadrao.txt");
	private PanelDeRelatorio relatorioOSsPorSexo = new views.PanelDeRelatorio("files/RelatorioOSsPorSexo.txt");
	private PanelDeRelatorio relatorioOSsPorAno = new views.PanelDeRelatorio("files/RelatorioOSsPorAno.txt");
	private PanelDeRelatorio relatorioOSsPorMes = new views.PanelDeRelatorio("files/RelatorioOSsPorMes.txt");
	JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizadorDeRelatorios window = new VisualizadorDeRelatorios();
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
	public VisualizadorDeRelatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(10, 11, 724, 439);
		frame.getContentPane().add(tabbedPane);
		relatorioCLientesPorSexo.setAlignmentX(Component.LEFT_ALIGNMENT);
		relatorioOsSimples.setAlignmentX(Component.LEFT_ALIGNMENT);
		relatorioClientesSimples.setAlignmentX(Component.LEFT_ALIGNMENT);
		relatorioClientesSimples.setAlignmentX(0);

		tabbedPane.add(relatorioClientesSimples, "Relatorio De Clientes - Simples");
		tabbedPane.add(relatorioCLientesPorSexo, "Relatorio De Clientes - Sexo");
		tabbedPane.add(relatorioOsSimples, "Relatorio De OSs - Simples");
		tabbedPane.add(relatorioOSsPorSexo, "Relatorio De OSs - Sexo Cliente");
		tabbedPane.add(relatorioOSsPorAno, "Relatorio De OSs - Ano");
		tabbedPane.add(relatorioOSsPorMes, "Relatorio De OSs - Mes");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
