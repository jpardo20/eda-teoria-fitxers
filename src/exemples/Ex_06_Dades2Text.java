package exemples;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import classes.Empleat;

public class Ex_06_Dades2Text {

    public static void main (String [] args) throws IOException{
        Set<Empleat> empresa = new HashSet<Empleat>();
        BufferedWriter bwCanal;
        File fitxerSortida;
        JFileChooser escullFitxer = new JFileChooser(".");

        empresa.add(new Empleat("J34", "ANNA", "DIR", 2010, 3456.12));
        empresa.add(new Empleat("zp", "BRIAN", "COM", 2019, 1800.40));
        empresa.add(new Empleat("4P0", "CARLA", "COM", 2018, 1850.00));
        empresa.add(new Empleat("3r", "DUNIA", "SEC", 2015, 2115.20));
        empresa.add(new Empleat("5p9", "ERNEST", "SEC", 2015, 2115.20));
        empresa.add(new Empleat("gT9#", "FABIOLA", "REC", 2016, 2589.10));

        escullFitxer.setDialogTitle("Selecciona un fitxer de sortida");
        escullFitxer.setFileSelectionMode(JFileChooser.FILES_ONLY);
        escullFitxer.showOpenDialog(null);
        fitxerSortida = escullFitxer.getSelectedFile();

        if (fitxerSortida==null) {
            System.out.println("\nNo s'ha seleccionat cap fitxer!");
            System.exit(1);
        }

        bwCanal = new BufferedWriter(new FileWriter(fitxerSortida));

        // Escriure el contingut en forma de text. Observar l'ús de
        // Integer.toString, Double.toString i newLine
        for (Empleat e : empresa) {
            bwCanal.write(e.getId()); bwCanal.newLine();
            bwCanal.write(e.getNom()); bwCanal.newLine();
            bwCanal.write(e.getPosicio()); bwCanal.newLine();
            bwCanal.write(Integer.toString(e.getAnyIngres())); bwCanal.newLine();
            bwCanal.write(Double.toString(e.getSou())); bwCanal.newLine();
        }
        // tancar canal
        bwCanal.close();

        System.out.println("\nContingut enregistrat a " + fitxerSortida.getPath());

    }
}
