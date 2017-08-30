
public enum Status {
	
	ABERTO(1),FECHADO(2), EM_ATENDIMENTO(3), AGUARDANDO_VISITA(4) ;
	
	public int status;

	private Status(int status) {
		this.status = status;
	}
	
	
}
