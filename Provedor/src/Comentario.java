import java.util.Date;

public class Comentario {
	private Date data;
	private String comentario;
	private Pessoa responsavel;
	
	public Comentario(String comentario, Pessoa responsavel) {
		super();
		this.data = new Date();
		this.comentario = comentario;
		this.responsavel = responsavel;
	}
	
	
}
