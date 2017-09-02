package entity;

import java.util.Date;

public class Tecnico extends Pessoa{

	public Tecnico(String nome, int rg, int cpf, Sexo sexo, Date nascimento) {
		super(nome, rg, cpf, sexo, nascimento);
		// TODO Auto-generated constructor stub
	}
	String cargo;
	

	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
	}


	public void criarOrdem(){
		
	}

	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
	public void auterarOrdem(){
		
	}
	
}
