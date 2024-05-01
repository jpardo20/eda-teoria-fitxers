package exercicis.ex_01_Majuscules_Consola;

import classes.Teclat;

import java.io.*;

public class ToUpper_Console_sol {

    public static void main (String [] args) {
        String filename;
        File file;
        BufferedReader entrada = null;
        String linia;

        System.out.print("Nom de l'arxiu (sense extensió): ");
        filename = Teclat.llegirCadena();
        filename = filename + ".txt";

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
            do{
                linia = entrada.readLine();
                // processar linia
                if (linia!=null){
                    if(linia == "")
                        System.out.printf("------------------");
                    else{
                        System.out.print(linia);
                        System.out.print(" ==> ");
                        System.out.println(linia.toUpperCase());
                    }
                }

                // passar a la línia següent
            } while(linia!=null);
            // Arxiu exhaurit. Totes les línies processades
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
