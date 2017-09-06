package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;
import entity.OrdemDeServico;

public class WriteFiles {
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");// formatador_da_data
	private static final String pathClientes = "files/clientes.txt";
	private static final String pathOSs = "files/OSs.txt";
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<OrdemDeServico> OSs ; 

	public void gravaOSs() throws IOException {
		File fileOSs = new File(pathOSs);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOSs));

		for (OrdemDeServico os : OSs) {
			writer.write(montaLinhaOSs(os));
			writer.newLine();
		}
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - OS adicionada: " + pathOSs);
	}
	
	private String montaLinhaOSs(OrdemDeServico os) {
		return os.getId() + "," + os.getStatus() + "," + os.getClienteDaOS().getIdCliente() + ","
				+ os.getMotivo() + "," + formatDate.format(os.getDataCriacao()) + "," + os.getResponsavel().getId();
	}

	public void gravaClientes() throws IOException {
		File fileClientes = new File(pathClientes);
		// long begin = System.currentTimeMillis();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileClientes));

		for (Cliente cliente : clientes) {
			writer.write(montaLinhaClientes(cliente));
			writer.newLine();
		}
		// writer.write("Arquivo gravado em : " + new
		// SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		// writer.newLine();
		// writer.write("Caminho da gravação: " + pathClientes);
		// writer.newLine();
		// long end = System.currentTimeMillis();
		// writer.write("Tempo de gravação: " + (end - begin) + "ms.");
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Cliente adicionado: " + pathClientes);
	}

	private String montaLinhaClientes(Cliente cliente) {
		return cliente.getIdCliente() + "," + cliente.getNome() + "," + cliente.getCpf() + "," + cliente.getRg() + ","
				+ cliente.getSexo() + "," + formatDate.format(cliente.getNascimento()) + "," + cliente.getTipoPlano();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setOSs(ArrayList<OrdemDeServico> oSs) {
		this.OSs = oSs;
	}
	
}