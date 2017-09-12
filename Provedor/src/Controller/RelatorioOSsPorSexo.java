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
import persistence.ReadFiles;

public class RelatorioOSsPorSexo extends Relatorio {
	

	ArrayList<OrdemDeServico> masculino = new ArrayList<OrdemDeServico>();
	ArrayList<OrdemDeServico> feminino = new ArrayList<OrdemDeServico>();
	String pathRelatorioOSsPorSexo = "files/RelatorioOSsPorSexo.txt";

	public RelatorioOSsPorSexo() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		File fileClientes = new File(pathRelatorioOSsPorSexo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathRelatorioOSsPorSexo));

		for (OrdemDeServico os : OSs) {
			if (os.getClienteDaOS().getSexo().equals(Sexo.MASCULINO)) {
				masculino.add(os);
			} else {
				feminino.add(os);
			}
		}

		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("----------------------------ORDEM DE SERVIÇOS ABERTAS POR HOMENS: %02d-------------------------",
						masculino.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		for (OrdemDeServico OSsHomens : masculino) {
			writer.write(OSsHomens.toString());
			writer.newLine();
		}

		writer.newLine();
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(
				String.format("----------------------------ORDEM DE SERVIÇOS ABERTAS POR MULHERES: %02d--------------------------",
						feminino.size()));
		writer.newLine();
		writer.write("-----------------------------------------------------------------------------------");
		writer.newLine();
		for (OrdemDeServico OSsMulheres : feminino) {
			writer.write(OSsMulheres.toString());
			writer.newLine();
		}

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println(formatDate.format(new Date()) + " - Relatorio p/Sexo gerado: " + pathRelatorioOSsPorSexo);

	}

}
