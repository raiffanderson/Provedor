
public class Endereco {

	private String rua, bairro, cidade, complemento, pontoRef;
	private int numCasa, cep, fone;
	
	public Endereco(String rua, String bairro, String cidade,
			String complemento, String pontoRef, int numCasa, int cep, int fone) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.pontoRef = pontoRef;
		this.numCasa = numCasa;
		this.cep = cep;
		this.fone = fone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoRef() {
		return pontoRef;
	}

	public void setPontoRef(String pontoRef) {
		this.pontoRef = pontoRef;
	}

	public int getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", cidade="
				+ cidade + ", complemento=" + complemento + ", pontoRef="
				+ pontoRef + ", numCasa=" + numCasa + ", cep=" + cep
				+ ", fone=" + fone + "]";
	}

	public void cadastrarEndereco(){
		
	}
	
	public void alterarEndereco(){
		
	}
	
	public void excluirEndereco(){
		
	}
}
