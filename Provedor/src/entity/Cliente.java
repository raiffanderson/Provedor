package entity;

import java.util.Date;

public class Cliente extends Pessoa{
	
	//bloco responsavel por atribuir o id do cliente
	private static int nextIdCliente = 1;
	private static int getNextIdCliente() {return nextIdCliente++;}
	private int IdCliente = getNextIdCliente();
	public int getIdCliente() {return IdCliente;}
	
	String tipoPlano;

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

	@Override
	public String toString() {
		return "Cliente [tipoPlano:" + tipoPlano + " | IdCliente:" + IdCliente + " | getRg():" + getRg()
				+ " | getCpf():" + getCpf() + " | getSexo():" + getSexo() + " | getNome():" + getNome() + "]";
	}

}
