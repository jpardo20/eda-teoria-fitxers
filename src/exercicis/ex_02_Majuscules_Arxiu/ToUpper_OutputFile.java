package exercicis.ex_02_Majuscules_Arxiu;

import java.io.*;
import classes.Teclat;


public class ToUpper_OutputFile {

    public static void main (String [] args) throws IOException {
        String filename;
        File inputFile, outputFile; // un fitxer per l'entrada i un per la sortida
        BufferedReader entrada = null;
        BufferedWriter sortida = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensió): ");
        filename = Teclat.llegirCadena();

        // Vincular i obrir tant l'entrada com la sortida
        inputFile = new File(filename+".txt");
        outputFile = new File(filename+"_UPPER.txt");

        /* COMPLETAR */


        // llegir en un i escriure en l'altre
        try {
           /* COMPLETAR */
        	sortida.close();
        }
        catch (IOException ex) {
           /* COMPLETAR */

        }
        System.out.println(">>>Arxiu processat. Resultat a " + outputFile.getName());
    }
}
