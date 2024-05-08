package exercicis.ex_06_Substituir_LA;

import classes.Teclat;

import java.io.*;

public class Substituir_LA {

    public static void main (String [] args) throws IOException {
        String filename, filenameIn, filenameOut;
        BufferedReader entrada = null;
        BufferedWriter sortida = null;
        String linia;

        System.out.println();
        System.out.print("nom de l'arxiu TXT (sense extensió): ");
        filename = Teclat.llegirCadena();

        // Vincular i obrir tant l'entrada com la sortida
        filenameIn = filename + ".txt";
        filenameOut = filename + "_PROC.txt";

        /* COMPLETAR */
        try {
            entrada = new BufferedReader(new FileReader(filenameIn));
            sortida = new BufferedWriter(new FileWriter(filenameOut));
        }
        catch(IOException ex) {
            System.err.println("Problemes en la creació dels canals");
            ex.printStackTrace();
            System.exit(0);
        }
        // Llegir en un fitxer i escriure a l'altre
        try {
            /* COMPLETAR */
            linia = entrada.readLine();
            while(linia!=null) {
                //La Maria, la Montse i les altres noies del barri
                linia = processarLinia(linia);
                //** Maria, ** Montse i les altres noies del barri
                sortida.write(linia); sortida.newLine();
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
        entrada.close();
        sortida.close();
        System.out.println(">>>>Arxiu processat");

    }

    private static String processarLinia (String linia) {
        // Genera una versió de la línia en què la cadena 'LA'
        // ha estat substituïda per **
        int pos;
        String versioMaj;
        StringBuffer sb;
        // sb => linia = La Maria, la Montse i les altres noies del barri
        /* COMPLETAR */
        versioMaj = linia.toUpperCase();
        // versioMaj = LA MARIA, LA MONTSE i LES ALTRES...
        // pos = 0
        sb = new StringBuffer(linia);
        pos = versioMaj.indexOf("LA");
        while(pos!=-1) {
            sb.replace(pos, pos+2, "**");
            pos = versioMaj.indexOf("LA", pos+1 );
        }
        return sb.toString();
    }
}
