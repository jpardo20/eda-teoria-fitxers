package exercicis.ex_02_Majuscules_Arxiu;

import java.io.*;

import classes.Teclat;
import classes.Teclat.*;

public class    ToUpper_OutputFile {

    public static void main (String [] args) {
        String filename;
        File inputFile, outputFile; // un fitxer per l'entrada i un per la sortida
        BufferedReader entrada = null;
        BufferedWriter sortida = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensio): ");
        filename = Teclat.llegirCadena();

        // vincular i obrir tant l'entrada com la sortida
        inputFile = new File(filename+".txt");
        outputFile = new File(filename+"_UPPER.txt");

        /* COMPLETAR */
        try {
        	entrada = new BufferedReader(new FileReader(inputFile));
        	sortida = new BufferedWriter(new FileWriter(outputFile));
        }
        catch(IOException ex) {
            System.err.println("Problemes en la creació dels canals");
        	ex.printStackTrace();
        	System.exit(0);
        }

        // llegir en un i escriure en l'altre
        try {
           /* COMPLETAR */
        	linia = entrada.readLine();
        	while(linia!=null) {
        		sortida.write(linia.toUpperCase());
        		sortida.newLine();
        		System.out.println(linia);
        		linia = entrada.readLine();
        	}
        	entrada.close();
        	sortida.close();
        	
        }
        catch (IOException ex) {
           /* COMPLETAR */
        	System.err.println("Problemes durant el tractament de l'arxiu");
        	ex.printStackTrace();
        	System.exit(0);
        }
        System.out.println(">>>Arxiu processat. Resultat a "+outputFile.getName());
    }
}
