package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.Cliente;

public class ReadFiles {

	private static File file = new File("files\\clientes.txt");
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	private static final void read(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
		while ((data = reader.readLine()) != null) {
			System.out.println(data);
		}
		fileReader.close();
		reader.close();
	}

	public static void main(String[] args) {
		try {
			ReadFiles.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}