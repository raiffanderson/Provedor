package Controller;

import java.io.IOException;

public class GeradoraDeRelatorios {

	private static RelatorioPadrao relatorioDefault;
	private static RelatorioPorSexo relatorioPorSexo;
	private static RelatorioPorMotivo relatorioPorMotivo;
	private static RelatorioPorData relatorioPorData;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		relatorioDefault = new RelatorioPadrao(); 
		relatorioPorSexo = new RelatorioPorSexo();
		relatorioPorData = new RelatorioPorData();
		relatorioPorMotivo = new RelatorioPorMotivo();
		
		relatorioDefault.geraRelatorio();
		relatorioPorSexo.geraRelatorio();
//		relatorioPorData.geraRelatorio();
//		relatorioPorMotivo.geraRelatorio();
	
	}
	
	

}
