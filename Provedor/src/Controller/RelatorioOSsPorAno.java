package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.OrdemDeServico;
import persistence.ReadFiles;

public class RelatorioOSsPorAno extends Relatorio {

	Map<String, ArrayList<OrdemDeServico>> mapaAnos = new HashMap<String, ArrayList<OrdemDeServico>>();

	String pathRelatorioOSsPorAno = "files/RelatorioOSsPorAno.txt";

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

		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioOSsPorAno));

		for (OrdemDeServico os : OSs) {
			String mes = formatDate.format(os.getDataCriacao());
			mes = mes.substring(6, 10);

			ArrayList<OrdemDeServico> ordens = mapaAnos.get(mes);
			// System.out.println(mapaMeses.get(mes));
			if (ordens == null) {
				ArrayList<OrdemDeServico> novaLista = new ArrayList<OrdemDeServico>();
				novaLista.add(os);
				mapaAnos.put(mes, novaLista);
			} else {
				ordens.add(os);
				mapaAnos.remove(mes);
				mapaAnos.put(mes, ordens);
			}

		}

		writer.write("-----------------------------------------------------------------------------------\n");
		writer.write("------------------RELATÓRIO DE ORDENS DE SERVIÇO (POR ANO)-------------------------\n");
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();

		for (Entry<String, ArrayList<OrdemDeServico>> o : mapaAnos.entrySet()) {
			writer.write("Ano: " + o.getKey() + " - Nº OSs: " + o.getValue().size());
			writer.newLine();
		}

		writer.newLine();
		writer.newLine();
		for (Entry<String, ArrayList<OrdemDeServico>> o : mapaAnos.entrySet()) {
			writer.write("-----------------------------------------------------------------------------------\n");
			writer.write(String.format("ANO: %s", o.getKey().toString()));
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
		System.out.println(formatDate.format(new Date()) + " - Relatorio gerado: " + pathRelatorioOSsPorAno);

	}
}
