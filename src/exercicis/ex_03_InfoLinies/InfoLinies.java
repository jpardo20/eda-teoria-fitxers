package exercicis.ex_03_InfoLinies;

import java.io.*;
import javax.swing.JFileChooser;
import classes.Fitxer;

public class InfoLinies {

	public static void main(String[] args) throws IOException {

		BufferedReader bur;
		JFileChooser fileChooser = new JFileChooser(".");
		File arxiu;

		fileChooser.setDialogTitle("Seleccionar arxiu");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
		arxiu = fileChooser.getSelectedFile();
		
		/* COMPLETE */
		
		
	}

}
