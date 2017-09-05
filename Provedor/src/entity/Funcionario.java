package entity;

import java.util.Date;

public class Funcionario extends Pessoa{

	String cargo;

	public Funcionario(String nome, int rg, int cpf, Sexo sexo, Date nascimento) {
		super(nome, rg, cpf, sexo, nascimento);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
	}
	
}
