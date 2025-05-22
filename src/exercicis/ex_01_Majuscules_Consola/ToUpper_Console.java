package exercicis.ex_01_Majuscules_Consola;

import java.io.*;
import classes.Teclat;

public class ToUpper_Console {

    public static void main (String [] args) {
        String filename;
        File file;
        BufferedReader entrada = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensio): ");
        filename = Teclat.llegirCadena();
        filename = filename+".txt";

        // vincular i obrir
        file = new File(filename);
        try {
            /* COMPLETAR */

        }
        catch (FileNotFoundException e) {
            /* COMPLETAR */
            e.printStackTrace();

        }

        // llegir i mostrar en maj�scules
        System.out.println();
        System.out.println("--------------------------------------------------");
        try {
           /* COMPLETAR */
            // Versió amb un MENTRE (habitual)



           entrada.close();
        }
        catch (IOException e) {
           /* COMPLETAR */

        }
        System.out.println("--------------------------------------------------");
    }

}
