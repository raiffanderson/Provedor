
public enum Status {
	
	ABERTO(1,""),FECHADO(2,""), EM_ATENDIMENTO(3,""), AGUARDANDO_VISITA(4,"") ;
	
	private String comentario;
	public int status;

	private Status(int status, String comentario) {
		this.status = status;
		this.comentario = comentario;
	}
	
	
}
