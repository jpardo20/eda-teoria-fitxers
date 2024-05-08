package exercicis.ex_08_09_Save_and_Restore;
import java.util.*;
import java.io.*;

public class SaveAndRestore_TWO {
	
	public static void main (String [] args)  {
		
		Object [] lesParts = {
			new LinkedHashSet<Part>(Arrays.asList(new Part("Pantalla", "molts pixels"), 
					                              new Part("bateria", "sempre buida"),
					                              new Part("carregador", "diferent a tot"))),
			new LinkedHashSet<Part>(Arrays.asList(new Part("Pota", "sustentador"), 
					                              new Part("esquena", "recolzador"))),
			new LinkedHashSet<Part>(Arrays.asList(new Part("bombeta", "fa llum")))
		};
		
		Collection<Producte> elsProductes = Arrays.asList(
			new Producte("Ipone", 750.25, (Set<Part>)lesParts[0]),
			new Producte("SenseParts", 100.3, new LinkedHashSet<Part>()),
			new Producte("Cadira", 50.12, (Set<Part>)lesParts[1]),
			new Producte("Lampada", 103.02, (Set<Part>)lesParts[2])
		);
		
		Collection<Producte> productesRecuperats;
		
		try {
			saveTWO(elsProductes, new File("prodBinTwo.bin"));
			productesRecuperats = restoreTWO(new File("prodBinTwo.bin"));
			System.out.println("Productes recuperats d'arxiu");
			System.out.println("----------------------------");
			System.out.println();
			for (Producte p : productesRecuperats) {
				System.out.println("PRODUCTE: "+p.getNom()+" "+p.getPreu());
				for (Part pa : p.getParts())
					System.out.println("\tPART: "+pa.getId()+", "+pa.getDesc());
				System.out.println();
			}
		}
		catch (IOException ioex) {
			System.out.println("Excepci� inesperada");
			ioex.printStackTrace(System.out);
		}
		
	}
	
	
	public static void saveTWO(Collection<Producte> col, File file) throws IOException {
		// desa el contingut de la col�lecci� donada en el primer par�metre
		// a l'arxiu especificat pel segon par�metre

		DataOutputStream dos = new DataOutputStream(
				  new BufferedOutputStream (new FileOutputStream (file)));

		for (Producte prod : col) {
			dos.writeUTF(prod.getNom());
			dos.writeDouble(prod.getPreu());
			dos.writeInt(prod.getParts().size());
			for (Part pa : prod.getParts()) {
				dos.writeUTF(pa.getId());
				dos.writeUTF(pa.getDesc());
			}
		} 
		// dos.writeUTF("END OF COLLECTION");
		dos.close();
	}

	public static Collection<Producte> restoreTWO(File file) throws IOException {
		// recupera de l'arxiu especificat el contingut d'una col�lecci� que
		// va ser desada amb el m�tode save
		Collection<Producte> resultat = new ArrayList<Producte>();
		Set<Part> parts;

		/* COMPLETAR */
		DataInputStream entrada = new DataInputStream(
				  new BufferedInputStream (new FileInputStream (file)));
		
		String nom, id, desc;
		double preu;
		int numParts;
		boolean acabar = false;
		
		while (!acabar) {
			try {
				nom = entrada.readUTF();
				preu = entrada.readDouble();
				numParts = entrada.readInt();
				parts = new HashSet<Part>();
				for (int i=1; i<=numParts; i++) {
					id = entrada.readUTF();
					desc = entrada.readUTF();
					parts.add(new Part(id, desc));
				}
				resultat.add(new Producte(nom, preu, parts));
			}
			catch(EOFException eofex) {
				acabar = true;
			}
		}
		
		entrada.close();
		return resultat;
	}

}
