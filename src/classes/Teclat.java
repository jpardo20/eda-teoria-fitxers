package classes;

import java.io.*;

public class Teclat {
    // Canal d'entrada construït a partir
    // de l'entrada Standard(System.in)
    private static BufferedReader canal =
            new BufferedReader(
                    new InputStreamReader(System.in));
    // Mètode per llegir una cadena String fins al
    // final de la línia CR/LF
    public static String llegirCadena() {
        try {
            // llegir del canal i retornar el
            // resultat sense processar perquè
            // readline() ja retorna un String
            return canal.readLine();
        } catch (IOException e) { // si hi ha
            // problemes amb la lectura o amb el canal...
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return String.valueOf((0)); // Línia inaccessible
        }
    }
    // Mètode per llegir un enter de mida int
    public int llegirEnter() {
        try {
            String cadena = canal.readLine();
            // Llegir una línia del canal
            if (cadena.length() == 0)   // si la línia és buida
                return llegirEnter();   // insistir
            else
                return Integer.parseInt(cadena); // convertir a int
        } catch (IOException e) { // si a la lectura ha anat malament
            // o ha fallat la conversió
            System.out.printf(e.getMessage()); // mostrar excepció
            System.exit(0); // aturar la màquina virtual
            return(0); // Línia de codi inaccessible
        }
    }
}

