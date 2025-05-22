package exercicis.ex_03_InfoLinies;

import java.io.*;
import javax.swing.JFileChooser;

public class InfoLinies {

	public static void main(String[] args) throws IOException {
		BufferedReader bur;
		JFileChooser fileChooser = new JFileChooser(".");
		File arxiu;
		float mitjana = 0f;
		int comptaLinies = 0;
		float mida = 0, suma = 0f;

		String linia;
		BufferedReader entrada = null;

		fileChooser.setDialogTitle("Seleccionar arxiu");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
		arxiu = fileChooser.getSelectedFile();

        /* COMPLETE */
		linia = entrada.readLine();
		while(linia!=null) {

		}

		System.out.format("L'arxiu %s té %d línies\n",
				arxiu.getName(),
				comptaLinies);
		if(comptaLinies==0) {
			System.out.print("Amb zero línies no es pot calcular cap mitjana");
		} else {

		}
	}

}
