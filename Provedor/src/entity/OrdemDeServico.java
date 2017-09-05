package entity;
import java.util.ArrayList;
import java.util.Date;

public class OrdemDeServico {

	//responsavel por atribuir o id da OS
	private static int nextId = 1;
	private static int getNextId() {return nextId++;}
	private int id = getNextId();
	public int getId() {return id;}
	

	private Cliente clienteDaOS;	//cliente que fez solicitou a abertura da OS
	private String motivo; 			//motivo/reclamacao do cliente
	private Date dataCriacao;		//data da cricao da OS
	private Status status;			//Status atual da OS
	private Funcionario responsavel;//funcionario que solucionou/fechou a OS 
	private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();	//comentarios feitos ao longo da 'vida' da OS

	public OrdemDeServico(Cliente cliente, String motivo) {
		super();
		this.clienteDaOS = cliente;
		this.motivo = motivo;
		this.status = Status.ABERTO;
		this.dataCriacao = new Date();
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date data) {
		this.dataCriacao = data;
	}

	@Override
	public String toString() {
		return "OrdemDeServico [id:" + id + " | status:" + status + " | clienteDaOS:" + clienteDaOS + " | motivo:"
				+ motivo + " | dataCriacao:" + dataCriacao + " | responsavel:" + responsavel + "]";
	}

	public Status getStatus() {
		return status;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void insereComentario(String comentarioStr, Pessoa resposanvel) {
		Comentario comentario = new Comentario(comentarioStr, resposanvel);
		this.comentarios.add(comentario);
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void fecharOrdem() {
		status = status.FECHADO;
	}

	public void cancelarOrdem() {

	}
	public Cliente getClienteDaOS() {
		return clienteDaOS;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

}
