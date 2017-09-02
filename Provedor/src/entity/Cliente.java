package entity;

import java.util.Date;

public class Cliente extends Pessoa{

	String tipoPlano;
	private static int nextIdCliente = 1;
	private static int getNextIdCliente() {return nextIdCliente++;}
	private int IdCliente = getNextIdCliente();
	public int getIdCliente() {return IdCliente;}
	
	

	public Cliente(String nome, int rg, int cpf, Sexo sexo, Date nascimento, String tipoPlano) {
		super(nome, rg, cpf, sexo, nascimento);
		this.tipoPlano = tipoPlano;
	}



	public void setIdCliente(int id_cliente) {
		this.IdCliente = id_cliente;
	}



	public String getTipoPlano() {
		return tipoPlano;
	}



	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}



	public String toString() {
		return "Cliente [id_cliente=" + IdCliente + ", tipoPlano=" + tipoPlano
				+ "]";
	}



	public void criarOrdem(){
		
	}

	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
}
