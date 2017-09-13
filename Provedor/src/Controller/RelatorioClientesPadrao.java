package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import entity.Cliente;
import persistence.ReadFiles;

public class RelatorioClientesPadrao extends Relatorio {

	String pathRelatorioDefault = "files/RelatorioDeClientesPadrao.txt";

	@Override
	public void geraRelatorio() throws IOException {

		try {
			leitor = new ReadFiles();
			leitor.setClientes(clientes);
			leitor.readClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fileClientes = new File(pathRelatorioDefault);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioDefault));

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write("----------------------------RELATÓRIO PADRÃO DE CLIENTES---------------------------");
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Cliente cliente : clientes) {
			writer.write(montaLinhaClientes(cliente));
			writer.newLine();
		}
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatório gerado: " + pathRelatorioDefault);

	}

	private String montaLinhaClientes(Cliente cliente) {
		return cliente.toString();
	}

}
