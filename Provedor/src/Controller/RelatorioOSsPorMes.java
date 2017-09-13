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
			// System.out.println(mapaMeses.get(mes));
			if (quantidade == null) {
				mapaMeses.put(mes, new Integer(1));
			} else {
				quantidade++;
				mapaMeses.remove(mes);
				mapaMeses.put(mes, new Integer(quantidade));
			}

		}

		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("------------------RELATÓRIO DE ORDENS DE SERVIÇO (POR MÊS)-------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Map.Entry<String, Integer> o : mapaMeses.entrySet()) {
			writer.write("Mes: " + o.getKey() + " - Nº OSs: " + o.getValue());
			writer.newLine();
		}

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(
				formatDate.format(new Date()) + " - Relatorio de OSs padrão gerado: " + pathRelatorioOSsPorMes);

	}
}
