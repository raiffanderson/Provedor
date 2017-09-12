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
import persistence.ReadFiles;
import persistence.WriteFiles;

public abstract class Relatorio {

	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<OrdemDeServico> OSs = new ArrayList<OrdemDeServico>();
	ReadFiles leitor = new ReadFiles();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");// formatador_da_data
	
	public void geraRelatorio() throws IOException{
		
	}

}
