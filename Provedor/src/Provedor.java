import java.util.ArrayList;
import java.util.Date;

public class Provedor {

	private ArrayList<OrdemDeServico> listaOSs = new ArrayList<OrdemDeServico>();
	
	public static void main(String[] args) {
		

	}

	private void criaOS(Cliente cliente, int num, String motivo, Date data){
		OrdemDeServico OS = new OrdemDeServico(	cliente.getIdade(), 
												cliente.getRg(), 
												cliente.getCpf(), 
												cliente.getSexo(), 
												num, motivo, data);
		listaOSs.add(OS);
	}
	
	private void removeOS(OrdemDeServico OS){
		listaOSs.remove(OS);
	}
}
