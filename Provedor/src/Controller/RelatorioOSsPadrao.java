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
import entity.Sexo;
import entity.Status;
import persistence.ReadFiles;

public class RelatorioOSsPadrao extends Relatorio {

	ArrayList<OrdemDeServico> abertas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> fechadas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> canceladas = new ArrayList<OrdemDeServico>();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");// formatador_da_data
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

		File fileClientes = new File(pathRelatorioOSsPadrao);
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
		writer.write("------------------RELAT�RIO DE ORDENS DE SERVI�O (PADR�O)--------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVI�OS ABERTAS:              %02d",abertas.size()));
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVI�OS FECHADAS:             %02d",fechadas.size()));
		writer.newLine();
		writer.write(String.format("ORDEM DE SERVI�OS CANCELADAS:           %02d",canceladas.size()));
		writer.newLine();
		writer.write(String.format("TOTAL DE ORDEM DE SERVI�OS PROCESSADAS: %02d",OSs.size()));
		writer.newLine();
		writer.newLine();
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("-----------------------------------DETALHAMENTO------------------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("ORDEM DE SERVI�OS ABERTAS: %02d",
						abertas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(abertas, writer);
		
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("ORDEM DE SERVI�OS FECHADAS: %02d",
						fechadas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(fechadas, writer);

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("ORDEM DE SERVI�OS CANCELADAS: %02d",
						canceladas.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		inserebloco(canceladas, writer);
		
		// Criando o conte�do do arquivo
		writer.flush();
		// Fechando conex�o e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio de OSs padr�o gerado: " + pathRelatorioOSsPadrao);

	}

	private void inserebloco(ArrayList<OrdemDeServico> ordens, BufferedWriter writer) throws IOException {
		for (OrdemDeServico os : abertas) {
			writer.write(os.toString());
			writer.newLine();
		}

	}
}
