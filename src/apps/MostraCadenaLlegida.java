package apps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostraCadenaLlegida {
    public static void main(String[] args) throws IOException {
        final String FI = "fi";
        BufferedReader buReTeclat =
            new BufferedReader(new InputStreamReader(System.in));
        String cadenaLlegida;
        do{
            System.out.format("Entra una cadena (entra" +
                    " \"%s\" per acabar): ", FI);
            cadenaLlegida = buReTeclat.readLine();
            if (!(cadenaLlegida.equalsIgnoreCase(FI))){
                System.out.format("Has entrat la cadena |%s|\n", cadenaLlegida );
                System.out.format("\tque té un mida de" +
                        " %s caràcters.\n", cadenaLlegida.length());
            } else
                System.out.print("\tFins la propera!\n");
        }while (!cadenaLlegida.equalsIgnoreCase(FI));
    }
}
