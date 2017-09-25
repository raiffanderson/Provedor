package Controller;

import java.io.IOException;

public class GeradoraDeRelatorios {

	private static Relatorio relatorioClientesPadrao;
	private static Relatorio relatorioClientesPorSexo;
	private static Relatorio relatorioOSsPadrao;
	private static Relatorio relatorioPorAno;
	private static Relatorio relatorioPorMes;
	private static Relatorio relatorioOSsPorSexo;
	private static Relatorio relatorioPorMotivo;

	public static void main(String[] args) {

		try {
			geraRelatorios();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void geraRelatorios() throws IOException{
		
		relatorioClientesPadrao = new RelatorioClientesPadrao();
		relatorioClientesPorSexo = new RelatorioClientesPorSexo();
		relatorioOSsPadrao = new RelatorioOSsPadrao();
		relatorioPorAno = new RelatorioOSsPorAno();
		relatorioPorMes = new RelatorioOSsPorMes();
		relatorioOSsPorSexo = new RelatorioOSsPorSexo();
		relatorioPorMotivo = new RelatorioOsPorMotivo();

		relatorioClientesPadrao.geraRelatorio();
		relatorioClientesPorSexo.geraRelatorio();
		relatorioOSsPadrao.geraRelatorio();
		relatorioOSsPorSexo.geraRelatorio();
		relatorioPorMes.geraRelatorio();
		relatorioPorAno.geraRelatorio();
		relatorioPorMotivo.geraRelatorio();
	}

}
