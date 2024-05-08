package exercicis.ex_05_Comptar_LA;

import java.io.*;

import classes.Teclat;
import classes.Teclat.*;

public class Comptar_LA {

    public static void main (String [] args) throws IOException {
    // En aquest exercici no caldrà capturar excepcions perquè
    // si aquestes es produïssin deixaríem que fossin propagades
    // fins a la màquina virtual.

       File file;
       String filename;
       BufferedReader entrada;
       String linia;
       int aparicions = 0;

       System.out.println();
       System.out.print("nom de l'arxiu TXT (sense extensió): ");
       filename = Teclat.llegirCadena();
       filename = filename + ".txt";

       /* COMPLETAR */

       System.out.println("la cadena LA apareix " + aparicions + " vegades");
    }

    private static int processarLinia (String linia) {
        // Aquest procediment compta la quantitat de vegades que apareix
        // la cadena LA, en qualsevol de les seves variants, a la línia de
        // text donada com a paràmetre.
        int pos, resultat;

        linia = linia.toUpperCase();
        
        resultat = 0;
        pos = linia.indexOf("LA");

        /* COMPLETAR */
        // us pot ser útil una iteració en què es fa és del mètode
        // indexOf en la seva versió de dos paràmetres...

        return resultat;
    }
}
