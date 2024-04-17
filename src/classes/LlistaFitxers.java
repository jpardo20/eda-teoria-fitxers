package classes;

import java.io.File;
public class LlistaFitxers {
    public static void main(String[] args) {
        try {
            File ruta = new File("C:/Programming");
            File[] elements = ruta.listFiles();
            for (int i=0; i< elements.length; i++) {
                if (elements[i].isDirectory()) {
                    System.out.println("Directori " + elements[i].getName());
                } else{
                    System.out.println("classes.Fitxer    " + elements[i].getName());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
