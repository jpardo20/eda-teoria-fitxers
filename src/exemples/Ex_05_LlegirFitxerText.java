package exemples;

import classes.Teclat;

import java.io.*;

public class Ex_05_LlegirFitxerText {
    public static void main(String[] args) throws IOException {
        File fitxerLlegir;
        BufferedReader canal = null;
        String nomFitxer, linia;
        System.out.print("Entra el nom de l'arxiu a llegir: ");
        nomFitxer = Teclat.llegirCadena();
        fitxerLlegir = new File(nomFitxer);

        try {
            canal = new BufferedReader(new FileReader(fitxerLlegir));
        } catch (IOException e) {
            System.out.format("Problema en obrir el fitxer a llegir!\n");
            e.printStackTrace();
            System.exit(1);
        }
        try{
            linia = canal.readLine();
            // El mètode readLine() retorna null
            // quan arriba a EOF
            if (linia!=null){
                System.out.println(linia);
                linia = canal.readLine();
            }
        } catch (IOException e) {
            System.out.format("Alguna cosa ha anat malament" +
                    " en llegir el fitxer!\n");
            e.printStackTrace();
            System.exit(1);
        }
        canal.close();
    }
}
