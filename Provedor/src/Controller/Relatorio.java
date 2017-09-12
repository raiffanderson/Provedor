package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;
import entity.OrdemDeServico;
import persistence.ReadFiles;
import persistence.WriteFiles;

public abstract class Relatorio {

	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ReadFiles leitor = new ReadFiles();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");// formatador_da_data
	String pathRelatorioDefault = "files/RelatorioPadrao.txt";

	public void geraRelatorio() throws IOException{
		
		try {
			leitor = new ReadFiles();
			leitor.setClientes(clientes);
			leitor.readClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File fileClientes = new File(pathRelatorioDefault);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioDefault));

		for (Cliente cliente : clientes) {
			writer.write(montaLinhaClientes(cliente));
			writer.newLine();
		}
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatório padrão gerado: " + pathRelatorioDefault);
	
	}
	private String montaLinhaClientes(Cliente cliente) {
		return cliente.toString();
	}
	
}
