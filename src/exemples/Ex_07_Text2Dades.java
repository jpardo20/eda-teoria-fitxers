package exemples;

import classes.Empleat;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class Ex_07_Text2Dades {
    public static void main (String [] args) throws IOException {
        BufferedReader brCanal;
        Empleat empleat;
        String id, nom, pos, any, sou;
        JFileChooser escullFitxer = new JFileChooser(".");
        File fitxerEntrada;
        Set<Empleat> empresa = new LinkedHashSet<Empleat>();

        escullFitxer.setDialogTitle("Seleccionar arxiu");
        escullFitxer.setFileSelectionMode(JFileChooser.FILES_ONLY);
        escullFitxer.showOpenDialog(null);
        fitxerEntrada = escullFitxer.getSelectedFile();

        if (fitxerEntrada==null) {
            System.out.println("\nNo s'ha seleccionat cap fitxer!");
            System.exit(1);
        }
        brCanal = new  BufferedReader(new FileReader(fitxerEntrada));
        // Llegir primer el codi (id)
        id = brCanal.readLine();
        while (id!=null) {
            // Assumim que després del codi hi ha totes les dades que calen
            nom = brCanal.readLine();
            pos = brCanal.readLine();
            any = brCanal.readLine();
            sou = brCanal.readLine();
            // Crear un empleat
            empleat = new Empleat(id);
            // Omplir la resta de la informació
            // Cal observar els parseXXX
            empleat.setNom(nom);
            empleat.setPosicio(pos);
            empleat.setAnyIngres(Integer.parseInt(any));
            empleat.setSou(Double.parseDouble(sou));
            // Afegir al conjunt
            empresa.add(empleat);
            // Obtenir el següent codi (id)
            id = brCanal.readLine();
        }
        // Un cop s'han llegit totes les dades. Tancar el canal.
        brCanal.close();

        // Mostrar el contingut recuperat
        System.out.println("\nDades recuperades\n");
        for (Empleat e : empresa) {
            System.out.println(e);
        }
    }
}