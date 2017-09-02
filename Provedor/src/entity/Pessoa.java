package entity;

import java.util.Date;

public class Pessoa {
	
	private String nome;
	private int rg, cpf;
	private Sexo sexo;
	private Date nascimento;
	
	public Pessoa(String nome, int rg, int cpf, Sexo sexo, Date nascimento) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nascimento = nascimento;
	}


	public int getRg() {
		return rg;
	}


	public void setRg(int rg) {
		this.rg = rg;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}





	@Override
	public String toString() {
		return "Pessoa [nome:" + nome + " | rg:" + rg + " | cpf:" + cpf + " | sexo:" + sexo + " | nascimento:"
				+ nascimento + "]";
	}


	public void criarOrdem(){
		
	}
	public void fecharOrdem(){
		
	}
	public void cancelarOrdem(){
		
	}
}
