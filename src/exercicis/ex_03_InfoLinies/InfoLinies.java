package exercicis.ex_03_InfoLinies;

import java.io.*;
import javax.swing.JFileChooser;
import classes.Fitxer;

public class InfoLinies {

	public static void main(String[] args) throws IOException {

		BufferedReader bur;
		JFileChooser fileChooser = new JFileChooser(".");
		File arxiu;
		float mitjana = 0f;
		int comptaLinies = 0;
		int mida = 0, suma = 0;
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
			System.out.format("Línia %d:" +
					" %s mida => %d\n",
					comptaLinies,
					linia,
					mida
					);
			linia = entrada.readLine();
		}
		System.out.format("L'arxiu %s té %d línies\n",
				arxiu.getName(),
				comptaLinies);
		mitjana = suma/comptaLinies;
//		System.out.format("La mida mitjana de les" +
//						"línies és %.1f caràcters\n",
//				mitjana);
		System.out.printf("La mida mitjana de les" +
						"línies és " + suma/comptaLinies +" caràcters");
	}

}
