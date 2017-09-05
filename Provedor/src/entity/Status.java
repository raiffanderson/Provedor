package entity;

public enum Status {
	
	ABERTO(1), FECHADO(2), CANCELADO(3);
	
	public int status;

	private Status(int status) {
		this.status = status;
	}
	
}
