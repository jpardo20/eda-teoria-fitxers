package ex_04_Censurar;

import java.io.*;
import javax.swing.JFileChooser;

import classes.Teclat;
import classes.Teclat.*;

public class Censurar {

	public static void main (String [] args) throws IOException {
		BufferedReader bur = null;
		BufferedWriter buw = null;
		File arxiuEntrada;
		File arxiuSortida;

		System.out.println();
		System.out.print("Nom de l'arxiu d'entrada (amb extensió, si la té): ");
		arxiuEntrada = new File(Teclat.llegirCadena());
		System.out.print("Nom de l'arxiu de sortida (amb extensió si la té): ");
		arxiuSortida = new File(Teclat.llegirCadena());
		
		/* COMPLETE */
	
		
		bur.close();
		buw.close();
	}
	
}
