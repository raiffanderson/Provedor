
public class Cliente extends Pessoa{

	int id_cliente;
	String tipoPlano;
	
	public Cliente(int idade, int rg, int cpf, String sexo, int id_cliente,
			String tipoPlano) {
		super(idade, rg, cpf, sexo);
		this.id_cliente = id_cliente;
		this.tipoPlano = tipoPlano;
	}
	
	

	public int getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}



	public String getTipoPlano() {
		return tipoPlano;
	}



	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}



	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", tipoPlano=" + tipoPlano
				+ "]";
	}



	public void criarOrdem(){
		
	}

	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
}
