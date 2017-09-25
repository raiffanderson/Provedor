package views;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Cliente;
import entity.Sexo;

import javax.swing.JScrollPane;

public class PanelDeRelatorio extends JPanel {

	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public PanelDeRelatorio(String pathfile) {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 662, 458);
		add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		FileReader fileReader;
		try {
			fileReader = new FileReader(pathfile);
			BufferedReader reader = new BufferedReader(fileReader);
			String data = null;
			while ((data = reader.readLine()) != null) {
				textArea.append(data);
				textArea.append("\n");
			}
			fileReader.close();
			reader.close();

		} catch (IOException e) {
			System.out.println("Arquivo não encontrado: "+ pathfile);
		}

	}

}
