
public class Funcionario extends Pessoa{

	String cargo;
	
	public Funcionario(int idade, int rg, int cpf, String sexo, String cargo) {
		super(idade, rg, cpf, sexo);
		this.cargo = cargo;
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


	public void criarOrdem(){
		
	}

	public void fecharOrdem(){
		
	}
	
	public void cancelarOrdem(){
		
	}
	public void auterarOrdem(){
		
	}
	
}
