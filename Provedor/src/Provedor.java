import java.util.ArrayList;
import java.util.Date;

public class Provedor {

	private ArrayList<OrdemDeServico> listaOSs;
	
//	private OrdemDeServico newOS = new OrdemDeServico(25, 1234, 1234, "M", 1, "Queda de Sinal") ;
	
	
	public Provedor() {
		super();
		this.listaOSs = new ArrayList<OrdemDeServico>();
		listaOSs.add(new OrdemDeServico(25, 1234, 1234, "M", 1, "Queda de Sinal"));
	}

	private void criaOS(Cliente cliente, int num, String motivo, Date data){
		OrdemDeServico OS = new OrdemDeServico(	cliente.getIdade(), 
												cliente.getRg(), 
												cliente.getCpf(), 
												cliente.getSexo(), 
												num, motivo);
		listaOSs.add(OS);

	}
	
	private void removeOS(OrdemDeServico OS){
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
	
	
}
