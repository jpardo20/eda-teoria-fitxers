package exemples;

import classes.Teclat;

import java.io.*;

public class Ex_08_EscriureTemperatures {
    public static void main (String [] args) throws IOException {
        File arxiuSortida;
        DataOutputStream dosCanal;
        String nomArxiu;

        System.out.print("Entra el nom de l'arxiu de sortida: ");
        nomArxiu = Teclat.llegirCadena();

        arxiuSortida = new File(nomArxiu);

        dosCanal = new DataOutputStream(new BufferedOutputStream
                (new FileOutputStream(arxiuSortida)));
        int quantes, altitud;
        String nom;
        double tempDiurna, tempNocturna;
        System.out.println();
        System.out.print("Quantitat de ciutats: ");
        quantes = Teclat.llegirEnter();
        for (int i = 1; i <= quantes; i++) {
            System.out.println("Ciutat " + i);
            System.out.print("  Nom: "); nom = Teclat.llegirCadena();
            System.out.print("  Altitud: "); altitud = Teclat.llegirEnter();
            System.out.print("  Temp. diürna: "); tempDiurna = Teclat.llegirDouble();
            System.out.print("  Temp. nocturna: "); tempNocturna = Teclat.llegirDouble();
            dosCanal.writeUTF(nom);
            dosCanal.writeInt(altitud);
            dosCanal.writeDouble(tempDiurna);
            dosCanal.writeDouble(tempNocturna);
        }
        dosCanal.close();
    }

}
