package exercicis.ex_03_InfoLinies;

import java.io.*;
import javax.swing.JFileChooser;

public class InfoLinies {

	public static void main(String[] args) throws IOException {

		BufferedReader bur;
		JFileChooser fileChooser = new JFileChooser(".");
		File arxiu;
		float mitjana = 0f;
		float comptaLinies = 0f;
		float mida = 0, suma = 0f;
		String linia;
		BufferedReader entrada = null;


		fileChooser.setDialogTitle("Seleccionar arxiu");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
		arxiu = fileChooser.getSelectedFile();
		try {
			entrada = new BufferedReader(
					new FileReader(arxiu));
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
			comptaLinies ++;
			mida = linia.length();
			System.out.format("Línia %.0f:" +
					" %s mida => %.0f\n",
					comptaLinies,
					linia,
					mida
					);
			suma += mida;
			linia = entrada.readLine();
		}
		System.out.format("L'arxiu %s té %.0f línies\n",
				arxiu.getName(),
				comptaLinies);
		mitjana = suma/comptaLinies;
		System.out.format("La mida mitjana de les" +
						"línies és %.2f caràcters\n",
				mitjana);
	}

}
