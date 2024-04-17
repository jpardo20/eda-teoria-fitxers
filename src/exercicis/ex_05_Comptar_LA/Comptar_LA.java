package ex_05_Comptar_LA;

import java.io.*;
import Keyboard.*;

public class Comptar_LA {

    public static void main (String [] args) throws IOException {
    // en aquest exercici no caldrà capturar excepcions perquè si aquestes
    // es produissin deixariem que fossin propagades fins a la màquina 
    // virtual.

       File file;
       String filename;
       BufferedReader entrada;
       String linia;
       int aparicions;

       System.out.println();
       System.out.print("nom de l'arxiu TXT (sense extensió): ");
       filename = Keyboard.readString();
       filename = filename + ".txt";


       /* COMPLETAR */

       System.out.println("la cadena LA apareix "+aparicions+" vegades");

    }

    private static int processarLinia (String linia) {
        // aquest procediment compta el número de vegades que apareix 
        // la cadena LA, en qualsevol de les seves variants, a la línia de
        // text donada com a paràmetre
        int pos, resultat;

        linia = linia.toUpperCase();
        
        resultat = 0;
        pos = linia.indexOf("LA");

        /* COMPLETAR */
        // us pot ser útil una iteració en què es fa ús del mètode
        // indexOf en la seva versió de dos paràmetres...

        return resultat;
    }
}
