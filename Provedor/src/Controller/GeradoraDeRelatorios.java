package Controller;

import java.io.IOException;

public class GeradoraDeRelatorios {

	private static RelatorioClientesPadrao relatorioClientesDefault;
	private static RelatorioClientesPorSexo relatorioClientesPorSexo;
	private static RelatorioOSsPadrao relatorioOSsPadrao;
	private static RelatorioOSsPorSexo relatorioOSsPorSexo;
	private static RelatorioOSsPorData relatorioPorData;
	private static RelatorioPorMotivo relatorioPorMotivo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		relatorioClientesDefault = new RelatorioClientesPadrao(); 
		relatorioClientesPorSexo = new RelatorioClientesPorSexo();
		relatorioOSsPadrao = new RelatorioOSsPadrao();
		relatorioOSsPorSexo = new RelatorioOSsPorSexo();
		relatorioPorData = new RelatorioOSsPorData();
		
		relatorioClientesDefault.geraRelatorio();
		relatorioClientesPorSexo.geraRelatorio();
		relatorioOSsPadrao.geraRelatorio();
		relatorioOSsPorSexo.geraRelatorio();
		relatorioPorData.geraRelatorio();
//		relatorioPorMotivo.geraRelatorio();
		
	
	}
	
	

}
