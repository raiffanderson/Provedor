package entity;

import java.util.Date;

public class Funcionario extends Pessoa{

	private String cargo;
	
	//responsavel por atribuir o id da OS
	private static int nextId = 1;
	private static int getNextId() {return nextId++;}
	private int id = getNextId();
	public int getId() {return id;}
		
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
