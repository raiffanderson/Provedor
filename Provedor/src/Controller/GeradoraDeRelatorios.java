package Controller;

import java.io.IOException;

public class GeradoraDeRelatorios {

	private static RelatorioClientesPadrao relatorioClientesDefault;
	private static RelatorioClientesPorSexo relatorioClientesPorSexo;
	private static RelatorioOSsPadrao relatorioOSsPadrao;
	private static RelatorioOSsPorSexo relatorioOSsPorSexo;
	private static RelatorioOSsPorMes relatorioPorData;
	private static RelatorioOSsPorAno relatorioPorAno;
	private static RelatorioPorMotivo relatorioPorMotivo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		relatorioClientesDefault = new RelatorioClientesPadrao(); 
		relatorioClientesPorSexo = new RelatorioClientesPorSexo();
		relatorioOSsPadrao = new RelatorioOSsPadrao();
		relatorioOSsPorSexo = new RelatorioOSsPorSexo();
		relatorioPorData = new RelatorioOSsPorMes();
		relatorioPorAno = new RelatorioOSsPorAno();
		
		relatorioClientesDefault.geraRelatorio();
		relatorioClientesPorSexo.geraRelatorio();
		relatorioOSsPadrao.geraRelatorio();
		relatorioOSsPorSexo.geraRelatorio();
		relatorioPorData.geraRelatorio();
		relatorioPorAno.geraRelatorio();
//		relatorioPorMotivo.geraRelatorio();
		
	
	}
	
	

}
