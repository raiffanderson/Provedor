
public class Pessoa {

	private int idade, rg, cpf;
	private Sexo sexo;
	
	public Pessoa(int idade, int rg, int cpf, Sexo sexo) {
		super();
		this.idade = idade;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
	}
	
	
	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
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


	public String toString() {
		return "Pessoa [idade=" + idade + ", rg=" + rg + ", cpf=" + cpf
				+ ", sexo=" + sexo + "]";
	}


	public void criarOrdem(){
		
	}
	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
	
}
