package apps;

import classes.Teclat;

public class TeclatApp {
    public static void main(String[] args) {
        Teclat teclat = new Teclat();
        String cadenaLlegida;
        int enterLlegit;
        System.out.format("Entra una cadena: ");
        cadenaLlegida = teclat.llegirCadena();
        System.out.format("La cadena llegida" +
                        " ha estat %s.\n",
                cadenaLlegida);
        System.out.format("Entra un enter: ");
        enterLlegit = teclat.llegirEnter();
        System.out.format("L'enter llegit" +
                        " ha estat %d.\n",
                enterLlegit);
    }
}
