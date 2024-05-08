package exercicis.ex_05_Comptar_LA;

import classes.Teclat;

import java.io.*;

public class Comptar_LA {

    public static void main (String [] args) throws IOException {
        // En aquest exercici no caldrà capturar excepcions perquè
        // si aquestes es produïssin deixaríem que fossin propagades
        // fins a la màquina virtual.

        File file;
        String filename;
        BufferedReader entrada = null;
        String linia;
        int aparicions = 0;

        System.out.println();
        System.out.print("nom de l'arxiu TXT (sense extensió): ");
        filename = Teclat.llegirCadena();
        filename = filename + ".txt";

        /* COMPLETAR */

        try {
            entrada = new BufferedReader(new FileReader(filename));
        } catch(Exception ex) {
            System.err.println("Problemes en la creació dels canals");
            ex.printStackTrace();
            System.exit(0);
        }

        try {
            linia = entrada.readLine();
            while(linia!=null) {
                aparicions += processarLinia(linia);
                //aparicions = aparicions + processarLinia(linia);
                linia = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException ex) {
            System.err.println("Problemes durant el tractament de l'arxiu");
            ex.printStackTrace();
            System.exit(0);
        }
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
        /* COMPLETAR */
        // us pot ser útil una iteració en què es fa és del mètode
        // indexOf en la seva versió de dos paràmetres...
        pos = linia.indexOf("LA");
        while (pos != -1) {
            resultat += 1;
            pos = linia.indexOf("LA", pos+1);
        }
        return resultat;
    }
}