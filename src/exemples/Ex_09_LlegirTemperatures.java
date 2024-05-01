package exemples;

import java.io.*;

import classes.Teclat;

public class Ex_09_LlegirTemperatures {
    public static void main (String [] args) throws IOException {
        File arxiuEntrada;
        DataInputStream disCanal;
        String nomArxiu;

        System.out.print("Entra el nom de l'arxiu a llegir: ");
        nomArxiu = Teclat.llegirCadena();

        arxiuEntrada = new File(nomArxiu);

        disCanal = new DataInputStream (new BufferedInputStream
                (new FileInputStream(arxiuEntrada)));
        int quantes = 1;
        String nom;
        int altitud;
        double tempDiurna, tempNocturna;
        try {
            while(true) { // Anar llegint fins que salti una EOFExcepion
                nom = disCanal.readUTF();
                altitud = disCanal.readInt();
                tempDiurna = disCanal.readDouble();
                tempNocturna = disCanal.readDouble();

                System.out.println("Ciutat " + quantes);
                System.out.println("  nom: " + nom);
                System.out.println("  altitud: " + altitud);
                System.out.println("  temp. diurna: " + tempDiurna);
                System.out.println("  temp. nocturna: " + tempNocturna);
                quantes++;
            }
        }
        catch(EOFException e) {/*detecció de l'EOF */}
        disCanal.close();
    }
}

