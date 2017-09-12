package entity;

public enum Status {
	
	ABERTO("A"), FECHADO("F"), CANCELADO("C");
	
	public String status;

	private Status(String status) {
		this.status = status;
	}
	
}
