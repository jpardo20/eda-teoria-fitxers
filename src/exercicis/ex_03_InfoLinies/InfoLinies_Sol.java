package exercicis.ex_03_InfoLinies;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InfoLinies_Sol {

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
		try {
			entrada = new BufferedReader(new FileReader(arxiu));

		}
		catch(IOException ex) {
			System.err.println("Problemes en la" +
					"creació dels canals");
			ex.printStackTrace();
			System.exit(0);
		}
		/* COMPLETE */
		linia = entrada.readLine();
		while(linia!=null) {
			mida = linia.length();
			suma += mida;
			System.out.format("Linia %d: %s té %.0f \n",
					comptaLinies, linia, mida);
			comptaLinies++;
			linia = entrada.readLine();
		}

		System.out.format("L'arxiu %s té %d línies\n",
				arxiu.getName(),
				comptaLinies);
		if(comptaLinies==0) {
			System.out.print("Amb zero línies no es pot calcular cap mitjana");
		} else {
			System.out.format("La mida mitjana de les " +
							"línies és %.2f caràcters\n",
					suma/comptaLinies);
		}
	}
}
