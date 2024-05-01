package exemples;

import java.io.File;
import java.util.Scanner;

public class Ex_03_LlistaFitxersV2 {
        public static void explorarDirectori(File directoriAMostrar,
                                     int nivell) {
            if (directoriAMostrar.isDirectory()) {
                System.out.println(getCadNivell(nivell + 1) +
                        "d: " + directoriAMostrar.getName());
                File[] elements = directoriAMostrar.listFiles();
                if (elements != null) {
                    for (File element : elements) {
                        if (element.isDirectory())
                            explorarDirectori(element, nivell + 1);
                        else System.out.println(getCadNivell(nivell + 1)
                                + "   f: " + element.getName());
                    }
                }
            } else System.out.println("La ruta especificada no" +
                    " és un directori vàlid.");
        }
    public static String getCadNivell(int nivell) {
        String cadena = "";
        for (int i = 0; i < nivell; i++)
            // Fem servir dos guions per cada nivell
            cadena += "--";
        return cadena;
    }
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.print("Entra la ruta del " +
                "directori a explorar: ");
        String ruta = teclat.nextLine();
        File directori = new File(ruta);
        System.out.format("\nMostrar els elements" +
                "del directori %s\n", directori);
        explorarDirectori(directori,0);
    }
}