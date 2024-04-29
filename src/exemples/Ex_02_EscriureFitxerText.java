package exemples;

import classes.Teclat;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex_02_EscriureFitxerText {
    public static void main(String[] args) throws IOException {
        final String FI = "fi";
        File fitxerSortida;
        BufferedWriter canal = null;
        String nomFitxer, linia;
        System.out.print("Entra el nom de l'arxiu de sortida: ");
        nomFitxer = Teclat.llegirCadena();
        fitxerSortida = new File(nomFitxer);
        String cadena;
        try {
            canal = new BufferedWriter(new FileWriter(fitxerSortida));
        } catch (IOException e) {
            System.out.format("Problema en crear el fitxer de sortida!\n");
            e.printStackTrace();
            System.exit(1);
        }
        do{
            System.out.format("Entra una cadena (entra" +
                    " \"%s\" per acabar): ", FI);
            cadena = Teclat.llegirCadena();
            if (!(cadena.equalsIgnoreCase(FI))){
                System.out.format("S'escriurà al fitxer la cadena |%s|\n", cadena);
                canal.write(cadena);
                canal.newLine();  // Cat "registrar" els salts de línia
            } else
                System.out.print("\tFins la propera!\n");
        }while (!cadena.equals(FI));
        canal.close();
    }
}
