package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;
import entity.Sexo;
import persistence.ReadFiles;

public class RelatorioPorSexo extends Relatorio {

	ArrayList<Cliente> masculino = new ArrayList<Cliente>();
	ArrayList<Cliente> feminino = new ArrayList<Cliente>();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");// formatador_da_data
	String pathRelatorioPorSexo = "files/RelatorioPorSexo.txt";

	public RelatorioPorSexo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void geraRelatorio() throws IOException {

		try {
			leitor = new ReadFiles();
			leitor.setClientes(clientes);
			leitor.readClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fileClientes = new File(pathRelatorioPorSexo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioPorSexo));

		for (Cliente cliente : clientes) {
			if (cliente.getSexo().equals(Sexo.MASCULINO)) {
				masculino.add(cliente);
			} else {
				feminino.add(cliente);
			}
		}

		writer.write("---------------------------------------------------------");
		writer.write("-------------------CLIENTES SEXO: M----------------------");
		writer.write("---------------------------------------------------------");
		writer.newLine();
		for (Cliente clienteMasculino : masculino) {
			writer.write(clienteMasculino.toString());
			writer.newLine();
		}

		writer.write("---------------------------------------------------------");
		writer.write("-------------------CLIENTES SEXO: F----------------------");
		writer.write("---------------------------------------------------------");
		writer.newLine();
		for (Cliente clienteFeminino : feminino) {
			writer.write(clienteFeminino.toString());
			writer.newLine();
		}

		// Criando o conte�do do arquivo
		writer.flush();
		// Fechando conex�o e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio p/Sexo gerado: " + pathRelatorioPorSexo);

	}

}
