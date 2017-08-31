import java.util.ArrayList;
import java.util.Date;

public class OrdemDeServico {

	private String motivo;
	private Date data;
	private Status status;
	private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
	private static int nextId = 0;
	private static int getNextId() {return nextId++;}
	private int id = getNextId();
	public int getId() {return id;}

	public OrdemDeServico(Cliente cliente, String motivo) {
		super();
		this.motivo = motivo;
		this.status = Status.ABERTO;
		this.data = new Date();
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
		return "OrdemDeServico [num=" + id + ", motivo=" + motivo + ", data=" + data + "]";
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

	}

	public void cancelarOrdem() {

	}
}
