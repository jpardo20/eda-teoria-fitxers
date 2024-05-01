package exemples;
// eda-05-presentacio-arxius-conceptes

import javax.swing.*;
import java.io.File;

public class Ex_01_Fitxer {
    public static void main(String[] args) {
        JFileChooser navegaFitxer;
        File fitxer;

        navegaFitxer = new JFileChooser();
        navegaFitxer.setDialogTitle("Selecciona el fitxer per veure els detalls!");
        navegaFitxer.setFileSelectionMode(
                JFileChooser.FILES_AND_DIRECTORIES);
        navegaFitxer.showOpenDialog(null);
        fitxer = navegaFitxer.getSelectedFile();

        // Mostra informació del fitxer
        if (fitxer != null) {
            System.out.format("Nom del fitxer escollit: %s\n", fitxer.getName());
            System.out.format("Ruta del fitxer escollit: %s\n", fitxer.getPath());
            System.out.format("És pot llegir  : %s\n", ((fitxer.canRead()) ? "SI" : "NO"));
            System.out.format("És pot escriure: %s\n", ((fitxer.canWrite()) ? "SI" : "NO"));
            System.out.format("És pot executar: %s\n", ((fitxer.canExecute()) ? "SI" : "NO"));
            System.out.format("La mida del fitxer escollit: %s\n", fitxer.length());
            System.out.format("És un directori: %s\n", ((fitxer.isDirectory()) ? "SI" : "NO"));
            if (fitxer.isDirectory()) {
                System.out.printf("Contingut del directori\n");
                for (File file : fitxer.listFiles()) {
                    System.out.format("\t%s\n", file);
                }
            }
        }
    }
}
