package exercicis.ex_02_Majuscules_Arxiu;

import java.io.*;
import classes.Teclat;


public class    ToUpper_OutputFile {

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
        try {
            entrada = new BufferedReader(new FileReader(inputFile));
            sortida = new BufferedWriter(new FileWriter(outputFile));
        } catch (FileNotFoundException ex2){
            System.out.printf("No existeix l'arxiu!");
            System.exit(1);
        } catch (IOException e) {
            System.out.printf("Problemes amb algun dels fitxers!");
            System.exit(1);
        }


        // llegir en un i escriure en l'altre
        try {
           /* COMPLETAR */
            linia = entrada.readLine();
            while (linia != null) {
                sortida.write(linia.toUpperCase());
                sortida.newLine(); // sortida.write("\n");
                linia = entrada.readLine();
            }
            entrada.close();
        	sortida.close();
        }
        catch (IOException ex) {
           /* COMPLETAR */
            System.out.printf("Problemes amb el tractament del fitxer!");
            System.exit(1);
        }
        System.out.println(">>>Arxiu processat. Resultat a " + outputFile.getName());
    }
}
