import java.util.ArrayList;
import java.util.Date;

public class OrdemDeServico extends Pessoa{

	private int num;
	private String motivo;
	private Date data;
	private Status status;
	private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
	
	public OrdemDeServico(int idade, int rg, int cpf, String sexo, int num,
			String motivo, Date data) {
		super(idade, rg, cpf, sexo);
		this.num = num;
		this.motivo = motivo;
		this.data = data;
		this.status = Status.ABERTO;
	}
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}

	public String toString() {
		return "OrdemDeServico [num=" + num + ", motivo=" + motivo + ", data="
				+ data + "]";
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


	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
}
