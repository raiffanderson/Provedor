package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import entity.OrdemDeServico;
import entity.Status;
import persistence.ReadFiles;

public class RelatorioOSsPadrao extends Relatorio {

	ArrayList<OrdemDeServico> abertas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> fechadas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> canceladas = new ArrayList<OrdemDeServico>();
	String pathRelatorioOSsPadrao = "files/RelatorioOSsPadrao.txt";

	@Override
	public void geraRelatorio() throws IOException {

		try {
			leitor = new ReadFiles();
			leitor.setClientes(clientes);
			leitor.setOSs(OSs);
			leitor.readClientes();
			leitor.readOSs();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioOSsPadrao));

		for (OrdemDeServico os : OSs) {
			if (os.getStatus().equals(Status.ABERTO)) {
				abertas.add(os);
			} else if (os.getStatus().equals(Status.FECHADO)) {
				fechadas.add(os);
			} else {
				canceladas.add(os);
			}
		}

		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("------------------RELATÓRIO DE ORDENS DE SERVIÇO (PADRÃO)--------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS ABERTAS:              %02d", abertas.size()));
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS FECHADAS:             %02d", fechadas.size()));
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS CANCELADAS:           %02d", canceladas.size()));
		writer.newLine();
		writer.write(String.format("TOTAL DE ORDEM DE SERVIÇOS PROCESSADAS: %02d", OSs.size()));
		writer.newLine();
		writer.newLine();
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("-----------------------------------DETALHAMENTO------------------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS ABERTAS: %02d", abertas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(abertas, writer);

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS FECHADAS: %02d", fechadas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(fechadas, writer);

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVIÇOS CANCELADAS: %02d", canceladas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(canceladas, writer);

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio gerado: " + pathRelatorioOSsPadrao);

	}

	private void inserebloco(ArrayList<OrdemDeServico> ordens, BufferedWriter writer) throws IOException {
		for (OrdemDeServico os : ordens) {
			writer.write(os.toString());
			writer.newLine();
		}

	}
}
