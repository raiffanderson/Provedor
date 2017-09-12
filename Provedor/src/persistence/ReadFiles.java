package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;
import entity.OrdemDeServico;
import entity.Sexo;
import entity.Status;

public class ReadFiles {

	private static File fileClientes = new File("files\\clientes.txt");
	private static File fileOSs = new File("files\\OSs.txt");
	private int idCliente;
	private int cpf;
	private int rg;
	private String nome;
	private String plano;
	private Sexo sexo;
	private Date dtNascimento;
	private Status status;
	private String motivo;
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<OrdemDeServico> OSs = new ArrayList<OrdemDeServico>();
	private int idOS;
	private Date dtCriacao;
	
	public void readClientes() throws IOException {
		FileReader fileReader = new FileReader(fileClientes);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
		while ((data = reader.readLine()) != null) {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");// formatador  da data
			formatDate.format(new Date());
			String[] arrayLinha = data.split(",");
			idCliente = Integer.parseInt(arrayLinha[0]);
			nome = arrayLinha[1];
			cpf = Integer.parseInt(arrayLinha[2]);
			rg = Integer.parseInt(arrayLinha[3]);
			sexo = Sexo.valueOf(arrayLinha[4]);
			plano = arrayLinha[6];

			try {
				dtNascimento = formatDate.parse(arrayLinha[5]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			clientes.add(new Cliente(nome, cpf, rg, sexo, dtNascimento, plano));
		}
		fileReader.close();
		reader.close();
	}

	public void setClientes(ArrayList<Cliente> arrayClientes) {
		(new Cliente(nome, cpf, rg, sexo, dtNascimento, plano)).setNextIdCliente(1);
		this.clientes = arrayClientes;
		this.clientes.clear();	
	}
	
	//para ler as OSs e armazena-las
	public void readOSs() throws IOException {
		FileReader fileReader = new FileReader(fileOSs);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
		while ((data = reader.readLine()) != null) {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");// formatador  da data
			formatDate.format(new Date());
			String[] arrayLinha = data.split(",");
			idOS = Integer.parseInt(arrayLinha[0]);
			status = Status.valueOf(arrayLinha[1]);
			idCliente = Integer.parseInt(arrayLinha[2]);
			motivo = arrayLinha[3];
			
			try {
				dtCriacao = formatDate.parse(arrayLinha[4]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			OrdemDeServico os = new OrdemDeServico(buscaCliente(idCliente),status, motivo);
			os.setDataCriacao(dtCriacao);
			OSs.add(os);
			
		}
		fileReader.close();
		reader.close();
	}

	private Cliente buscaCliente(int idCliente2) {
		Cliente cliente = null;
		
		for (Cliente cust: clientes){
			if (cust.getIdCliente() == idCliente2){
				cliente = cust;
			}
		}
		
		return cliente;
	}

	public void setOSs(ArrayList<OrdemDeServico> listaOSs) {
		(new OrdemDeServico(null,null, null)).setNextIdOS(1);
		this.OSs = listaOSs;
		this.OSs.clear();			
	}
	
}