package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import entity.OrdemDeServico;
import persistence.ReadFiles;

public class RelatorioOSsPorAno extends Relatorio{

	Map<String, Integer> mapaMeses = new HashMap<String, Integer>();

	ArrayList<OrdemDeServico> abertas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> fechadas = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> canceladas = new ArrayList<OrdemDeServico>();
	String pathRelatorioOSsPorAno = "files/RelatorioOSsPorAno.txt";

	// Map<integer, string=""> mapaNomes = new HashMap<integer, string="">();
	// mapaNomes.put(1, "João Delfino");
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

		File fileClientes = new File(pathRelatorioOSsPorAno);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioOSsPorAno));

		for (OrdemDeServico os : OSs) {
			String mes = formatDate.format(os.getDataCriacao());
			mes = mes.substring(6, 10);

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
		writer.write("------------------RELATÓRIO DE ORDENS DE SERVIÇO (POR ANO)-------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Map.Entry<String, Integer> o : mapaMeses.entrySet()) {
			writer.write("Ano: " + o.getKey() + " - Nº OSs: " + o.getValue());
			writer.newLine();
		}

		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVIÇOS ABERTAS: %02d",
		// abertas.size()));
		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVIÇOS FECHADAS: %02d",
		// fechadas.size()));
		// writer.newLine();
		// writer.write(String.format("ORDEM DE SERVIÇOS CANCELADAS: %02d",
		// canceladas.size()));
		// writer.newLine();
		// writer.write(String.format("TOTAL DE ORDEM DE SERVIÇOS PROCESSADAS:
		// %02d", OSs.size()));
		// writer.newLine();
		// writer.newLine();
		// writer.newLine();

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(
				formatDate.format(new Date()) + " - Relatorio de OSs padrão gerado: " + pathRelatorioOSsPorAno);

	}
}
