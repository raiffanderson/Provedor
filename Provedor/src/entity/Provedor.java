package entity;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ListModel;

public class Provedor {

	private ArrayList<OrdemDeServico> listaOSs;
	private ArrayList<Cliente> clientes;
	
//	private OrdemDeServico newOS = new OrdemDeServico(25, 1234, 1234, "M", 1, "Queda de Sinal") ;
	
	
	public Provedor() {
		super();
		this.listaOSs = new ArrayList<OrdemDeServico>();
		this.clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente(20, 464897, 68141, Sexo.MASCULINO, 1, "Basico");
		Cliente cliente2 = new Cliente(38, 684165, 58721, Sexo.MASCULINO, 2, "Completo");
		Cliente cliente3 = new Cliente(29, 353425, 35322, Sexo.FEMININO, 3, "Intermediario");
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
//		listaOSs.add(new OrdemDeServico(new Cliente(26, 456, 1234, Sexo.FEMININO, 0, null), "Queda de Sinal"));
//		listaOSs.add(new OrdemDeServico(new Cliente(28, 654, 1894, Sexo.MASCULINO, 0, null),"Inadimplencia"));
//		this.criaOS(cliente3, "Teste");
//		this.criaOS(cliente2, "Teste");
	}

	public void criaOS(Cliente cliente, String motivo){
		OrdemDeServico OS = new OrdemDeServico(cliente,motivo);
		listaOSs.add(OS);
	}
	
	public void removeOS(OrdemDeServico OS){
		listaOSs.remove(OS);
	}
	
	private void atualizarStatusOS(OrdemDeServico OS, Status status){
		OS.setStatus(status);
	}
	
	private void inserirComentarioOS(OrdemDeServico OS, String str, Pessoa pessoa) {
		OS.insereComentario(str, pessoa);
	}

	public ArrayList<OrdemDeServico> getListaOSs() {
		return listaOSs;
	}

	public void setListaOSs(ArrayList<OrdemDeServico> listaOSs) {
		this.listaOSs = listaOSs;
	}

	public DefaultListModel getListaOSsModel() {
		DefaultListModel listModel = new DefaultListModel();
		for(OrdemDeServico os: this.getListaOSs()){
			listModel.addElement(os);
		}
		return listModel;
	}
	public DefaultListModel getListaClientesModel() {
		DefaultListModel clientesModel = new DefaultListModel();
		for(Cliente cliente: this.getClientes()){
			clientesModel.addElement(cliente);
		}
		return clientesModel;
	}

	private ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void cadastraCliente(JLabel lblNome, JLabel lblCpf, JLabel lblRg, JLabel lblSexo) {
//		Cliente novoCliente = new Cliente(lblNome,lblCpf,lblRg,lblSexo);
	}
	
}
