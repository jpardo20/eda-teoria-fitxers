package exercicis.ex_04_Censurar;

import java.io.*;
import classes.Teclat;

public class Censurar {

	public static void main (String [] args) throws IOException {
		BufferedReader bur = null;
		BufferedWriter buw = null;;
		File arxiuEntrada;
		File arxiuSortida;
		String liniaLlegida;

		System.out.println();
		System.out.print("Nom de l'arxiu d'entrada (amb extensió, si la té): ");
		arxiuEntrada = new File(Teclat.llegirCadena());
		System.out.print("Nom de l'arxiu de sortida (amb extensió, si la té): ");
		arxiuSortida = new File(Teclat.llegirCadena());

		/* COMPLETE */
		try{
			bur = new BufferedReader(new FileReader(arxiuEntrada));
			buw = new BufferedWriter(new FileWriter(arxiuSortida));
		} catch(IOException e){
			System.out.println("Problemes amb els canals!");
			System.exit(1);
		}
		System.out.println("Línies censurades:");
		liniaLlegida = bur.readLine();
		while (liniaLlegida != null){
			if(!liniaLlegida.startsWith("CENSURAR")){
				buw.write(liniaLlegida);
				buw.newLine();
			} else{
				System.out.format("%s%n", liniaLlegida);
			}
			liniaLlegida = bur.readLine();
		}

		bur.close();
		buw.close();
	}

}
