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

public class ReadFiles {

	private static File fileClientes = new File("files\\clientes.txt");
	private int idCliente;
	private int cpf;
	private int rg;
	private String nome;
	private String plano;
	private Sexo sexo;
	private Date dtNascimento;
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<OrdemDeServico> OSs = new ArrayList<OrdemDeServico>();

	public void read() throws IOException {
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
		this.clientes = arrayClientes; 		
	}

}