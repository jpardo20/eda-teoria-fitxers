package exercicis.ex_08_09_Save_and_Restore;

import java.util.*;
import java.io.*;

public class SaveAndRestore_ONE {

    
    public static void saveONE (Collection<Producte> col, File file)
                            throws IOException {
    	// desa el contingut de la col·lecció donada en el primer parmetre
        // a l'arxiu especificat pel segon parmetre
    	
        BufferedWriter buw;
        buw = new BufferedWriter(new FileWriter(file));

        for(Producte prod : col) {
            buw.write(prod.getNom()); buw.newLine(); // desar nom
            buw.write(Double.toString(prod.getPreu())); buw.newLine(); // desar preu
            for (Part part : prod.getParts()){ // iterar sobre les parts
                buw.write(part.getId()); buw.newLine(); // desar id de la part
                buw.write(part.getDesc()); buw.newLine(); // desar desc de la part
            }
            buw.write(Part.MARCA); buw.newLine(); // desar marca de finalitzaci de la seqncia de parts
        }
        buw.close();
    }

    
    public static Collection<Producte> restoreONE (File file)
                  throws IOException {
    	 // recupera de l'arxiu especificat el contingut d'una col·lecció que
        // va ser desada amb el mtode save
        Collection<Producte> resultat = new ArrayList();
        Set<Part> parts;

        /* COMPLETAR */
        BufferedReader bur;
        String nom,  id, desc;
        double preu;
        
        bur = new BufferedReader(new FileReader(file));
        
        nom = bur.readLine();
        while (nom!=null) {
        	preu = Double.parseDouble(bur.readLine());
        	id = bur.readLine();
        	parts = new HashSet<Part>();
        	while (!id.equals(Part.MARCA)) {
        		desc = bur.readLine();
        		parts.add(new Part(id, desc));
        		
        		id = bur.readLine();
        	}
        	// no hi ha ms parts per aquest producte
        	resultat.add(new Producte(nom, preu, parts));
        	// finalitza aqu el processament d'un producte
        	
        	nom = bur.readLine();
        }
        // EOF
        
        bur.close();
        return resultat;
    }

}
