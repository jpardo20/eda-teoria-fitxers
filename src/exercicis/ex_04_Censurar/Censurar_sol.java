package exercicis.ex_04_Censurar;

import classes.Teclat;

import java.io.*;

public class Censurar_sol {

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
			if (!liniaLlegida.startsWith("CENSURAR ")) {
				buw.write(liniaLlegida + "\n");
//				buw.write(liniaLlegida); buw.newLine();
			} else
				System.out.format("\t%s\n",liniaLlegida);
				// System.out.println("\t" + liniaLlegida);
			liniaLlegida = bur.readLine();
		}


		bur.close();
		buw.close();
	}
	
}
