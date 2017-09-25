package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import entity.Cliente;
import entity.Sexo;
import persistence.ReadFiles;

public class RelatorioClientesPorSexo extends Relatorio {

	ArrayList<Cliente> masculino = new ArrayList<Cliente>();
	ArrayList<Cliente> feminino = new ArrayList<Cliente>();
	String pathRelatorioClientesPorSexo = "files/RelatorioDeClientesPorSexo.txt";

	public RelatorioClientesPorSexo() {
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

		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioClientesPorSexo));

		for (Cliente cliente : clientes) {
			if (cliente.getSexo().equals(Sexo.MASCULINO)) {
				masculino.add(cliente);
			} else {
				feminino.add(cliente);
			}
		}

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("----------------------------CLIENTES DO SEXO MASCULINO: %02d-------------------------",
						masculino.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		for (Cliente clienteMasculino : masculino) {
			writer.write(clienteMasculino.toString());
			writer.newLine();
		}

		writer.newLine();
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("----------------------------CLIENTES DO SEXO FEMININO: %02d--------------------------",
						feminino.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		for (Cliente clienteFeminino : feminino) {
			writer.write(clienteFeminino.toString());
			writer.newLine();
		}

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio gerado: " + pathRelatorioClientesPorSexo);

	}

}
