package exercicis.ex_04_Censurar;

import java.io.*;
import javax.swing.JFileChooser;

import classes.Teclat;

public class Censurar {

	public static void main (String [] args) throws IOException {
		BufferedReader bur = null;
		BufferedWriter buw = null;
		File arxiuEntrada;
		File arxiuSortida;
		String liniaLlegida;

		System.out.println();
		System.out.print("Nom de l'arxiu d'entrada (amb extensió, si la té): ");
		arxiuEntrada = new File(Teclat.llegirCadena());
		System.out.print("Nom de l'arxiu de sortida (amb extensió si la té): ");
		arxiuSortida = new File(Teclat.llegirCadena());

		/* COMPLETE */
		try {
			bur = new BufferedReader(
			new FileReader(arxiuEntrada));
			buw = new BufferedWriter(
			new FileWriter(arxiuSortida));
		}
		catch(IOException ex) {
			System.err.println("Problemes en la" +
					"creació dels canals");
			ex.printStackTrace();
			System.exit(0);
		}
		System.out.println("Linies censurades:");
		liniaLlegida = bur.readLine();

		while(liniaLlegida!=null) {
			if (!liniaLlegida.contains("CENSURAR")) {
				//System.out.printf("linia = " + liniaLlegida + "\n");
				buw.write(liniaLlegida);
			} else
				System.out.format("\t%s\n",liniaLlegida);
				// System.out.println("\t" + liniaLlegida);

			liniaLlegida = bur.readLine();
		}


		bur.close();
		buw.close();
	}
	
}
