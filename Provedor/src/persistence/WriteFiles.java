package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;

public class WriteFiles {
	private static final String pathClientes = "files/clientes.txt";
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void gravaClientes() throws IOException {
		File file = new File(pathClientes);
//		long begin = System.currentTimeMillis();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		for(Cliente cliente: clientes){
			writer.write(montaLinha(cliente));
			writer.newLine();
		}
//		writer.write("Arquivo gravado em : " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
//		writer.newLine();
//		writer.write("Caminho da gravação: " + pathClientes);
//		writer.newLine();
//		long end = System.currentTimeMillis();
//		writer.write("Tempo de gravação: " + (end - begin) + "ms.");
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println("Arquivo gravado em: " + pathClientes);
	}

	private String montaLinha(Cliente cliente) {
		return cliente.getIdCliente() + "|" + cliente.getNome() + "|" + cliente.getCpf() + "|" + cliente.getRg() + "|"
				+ cliente.getTipoPlano() + "|" + cliente.getNascimento() + "|" + cliente.getSexo();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}