package exercicis.ex_06_Substituir_LA;

import java.io.*;

import classes.Teclat;
import classes.Teclat.*;

public class Substituir_LA {

    public static void main (String [] args) throws IOException {

        File fileIn, fileOut;
        String filename, filenameIn, filenameOut;
        BufferedReader entrada;
        BufferedWriter sortida;
        String linia;

        System.out.println();
        System.out.print("nom de l'arxiu TXT (sense extensió): ");
        filename = Teclat.llegirCadena();
        filenameIn = filename + ".txt";
        filenameOut = filename + "_PROC.txt";

        /* COMPLETAR */

//        entrada.close();
//        sortida.close();
        System.out.println(">>>>Arxiu processat");

    }

    private static String processarLinia (String linia) {
        // Genera una versió de la línia en què la cadena 'LA'
        // ha estat substituïda per **

        int pos;
        String versioMaj;
        StringBuffer sb;

        versioMaj = linia.toUpperCase();
        sb = new StringBuffer(linia);

        pos = versioMaj.indexOf("LA");

        /* COMPLETAR */

        return sb.toString();
    }
}
