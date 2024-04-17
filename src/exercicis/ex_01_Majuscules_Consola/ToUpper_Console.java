package ex_01_Majuscules_Consola;

import java.io.*;
import Keyboard.*;

public class ToUpper_Console {

    public static void main (String [] args) {
        String filename;
        File file;
        BufferedReader entrada = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensio): ");
        filename = Keyboard.readString();
        filename = filename+".txt";

        // vincular i obrir
        file = new File(filename);
        try {
            /* COMPLETAR */
        	entrada = new BufferedReader(new FileReader(file));
        	
        }
        catch (FileNotFoundException e) {
            /* COMPLETAR */
        	System.out.println("Arxiu no trobat");
        	System.exit(0);
        	
        }

        // llegir i mostrar en majúscules
        System.out.println();
        System.out.println("--------------------------------------------------");
        try {
           /* COMPLETAR */
           linia = entrada.readLine();
           while(linia!=null) {
        	   // processar linia
        	   System.out.print(linia);
        	   System.out.print(" ==> ");
        	   System.out.println(linia.toUpperCase());
        	   // passar a la línia següent
        	   linia = entrada.readLine();
           }
           // arxiu exhaurit. Totes les línies processades
           
           entrada.close();
        }
        catch (IOException e) {
           /* COMPLETAR */
        	System.err.println("Problemes greus durant el processament de l'arxiu");
        	System.exit(0);
        }
        System.out.println("--------------------------------------------------");
    }

}
