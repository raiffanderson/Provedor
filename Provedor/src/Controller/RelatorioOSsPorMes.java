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
import java.util.Map.Entry;

import entity.OrdemDeServico;
import entity.Status;
import persistence.ReadFiles;

public class RelatorioOSsPorMes extends Relatorio {

	Map<String, ArrayList<OrdemDeServico>> mapaMeses = new HashMap<String, ArrayList<OrdemDeServico>>();

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

			ArrayList<OrdemDeServico> ordens = mapaMeses.get(mes);
			// System.out.println(mapaMeses.get(mes));
			if (ordens == null) {
				ArrayList<OrdemDeServico> novaLista = new ArrayList<OrdemDeServico>();
				novaLista.add(os);
				mapaMeses.put(mes, novaLista);
			} else {
				ordens.add(os);
				mapaMeses.remove(mes);
				mapaMeses.put(mes, ordens);
			}

		}

		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("------------------RELATÓRIO DE ORDENS DE SERVIÇO (POR MÊS)-------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Entry<String, ArrayList<OrdemDeServico>> o : mapaMeses.entrySet()) {
			writer.write("Mes: " + o.getKey() + " - Nº OSs: " + o.getValue().size());
			writer.newLine();
		}

		writer.newLine();
		writer.newLine();
		for (Entry<String, ArrayList<OrdemDeServico>> o : mapaMeses.entrySet()) {
			writer.write("-----------------------------------------------------------------------------------\n");
			writer.write(String.format("MES: %s", o.getKey().toString()));
			writer.newLine();
			writer.write("-----------------------------------------------------------------------------------");
			writer.newLine();
			for (OrdemDeServico os : o.getValue()) {
				writer.write(os.toString());
				writer.newLine();
			}
			writer.newLine();
		}
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio gerado: " + pathRelatorioOSsPorMes);

	}
}
