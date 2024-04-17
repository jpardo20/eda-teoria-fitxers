package ex_04_Censurar;

import java.io.*;
import javax.swing.JFileChooser;
import Keyboard.*;

public class Censurar {

	public static void main (String [] args) throws IOException {
		BufferedReader bur;
		BufferedWriter buw;
		File arxiuEntrada;
		File arxiuSortida;

		System.out.println();
		System.out.print("Nom de l'arxiu d'entrada (amb extensió, si la té): ");
		arxiuEntrada = new File(Keyboard.readString());
		System.out.print("Nom de l'arxiu de sortida (amb extensió, si la té): ");
		arxiuSortida = new File(Keyboard.readString());
		
		/* COMPLETE */
	
		
		bur.close();
		buw.close();
	}
	
}
