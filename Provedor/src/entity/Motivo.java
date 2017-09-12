package entity;

public enum Motivo {
	
	SemSinal("SS"), SinalLento("SL"), Outros("O");
	
	public String motivo;

	private Motivo(String motivo) {
		this.motivo = motivo;
	}
}
