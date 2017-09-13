package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import entity.OrdemDeServico;
import entity.Status;
import persistence.ReadFiles;

public class RelatorioOSsPorMes extends Relatorio {

	Map<String, Integer> mapaMeses = new HashMap<String, Integer>();

	String pathRelatorioOSsPorMes = "files/RelatorioOSsPorMes.txt";

	// Map<integer, string=""> mapaNomes = new HashMap<integer, string="">();
	// mapaNomes.put(1, "Jo�o Delfino");
	// mapaNomes.put(2, "Maria do Carmo");
	// mapaNomes.put(3, "Claudinei Silva");

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

		File fileClientes = new File(pathRelatorioOSsPorMes);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioOSsPorMes));

		for (OrdemDeServico os : OSs) {
			String mes = formatDate.format(os.getDataCriacao());
			mes = mes.substring(3, 5);

			Integer quantidade = mapaMeses.get(mes);
			//System.out.println(mapaMeses.get(mes));
			if (quantidade == null) {
				mapaMeses.put(mes, new Integer(1));
			} else {
				quantidade++;
				mapaMeses.remove(mes);
				mapaMeses.put(mes, new Integer(quantidade));
			}

		}

		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("------------------RELAT�RIO DE ORDENS DE SERVI�O (POR M�S)-------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Map.Entry<String, Integer> o : mapaMeses.entrySet()) {
			writer.write("Mes: " + o.getKey() + " - N� OSs: " + o.getValue());
			writer.newLine();
		}

		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVI�OS ABERTAS: %02d",
		// abertas.size()));
		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVI�OS FECHADAS: %02d",
		// fechadas.size()));
		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVI�OS CANCELADAS: %02d",
		// canceladas.size()));
		// writer.newLine();
		// writer.write(String.format("TOTAL DE ORDEM DE SERVI�OS PROCESSADAS:
		// %02d", OSs.size()));
		// writer.newLine();
		// writer.newLine();
		// writer.newLine();

		// Criando o conte�do do arquivo
		writer.flush();
		// Fechando conex�o e escrita do arquivo.
		writer.close();
		System.out.println(
				formatDate.format(new Date()) + " - Relatorio de OSs padr�o gerado: " + pathRelatorioOSsPorMes);

	}
}