package exercicis.ex_07_IO_DiccionariSinonims.solucions;

import classes.Teclat;

import java.util.*;
import java.io.*;


public class PexProva {

  // opcions del menú que es presentarà a l'usuari del programa
  private static final int FINAL = 0;
  private static final int BUSCAR = 1;
  private static final int AFEGIR= 2;
  private static final int AFEGIR_CJT = 3;
  private static final int LLISTAR = 4;

  // els tres formats de càrrega/descàrrega
  private static final int TEXT = 0; // format de text
  private static final int BIN_NUM = 1; // format binari amb nombre de sinònims
  private static final int BIN_MAR = 2; // format binari amb marca

  // canviar el valor d'aquests atributs per a canviar
  // el format de càrrega/descarrega
  private static int modeCarrega = BIN_NUM;
  private static int modeDescarrega = BIN_MAR;

  private static DiccioAmbMap elMeuDiccionari;

  public static void main (String [] args) {

    int opcio; // opció del menú i triada

    // crear el diccionari
    elMeuDiccionari = new DiccioAmbMap();

    // donem l'opció de carregar el diccionari
    carregarDiccionari(elMeuDiccionari);

    // iterar mentre l'opció seleccionada no sigui la d'abandonar el programa
    opcio = menu();
    while (opcio!=FINAL)  {
      // processar l'opció seleccionada
      switch (opcio) {
        case BUSCAR: buscarSinonims(); break;
        case AFEGIR: afegirSinonim(); break;
        case AFEGIR_CJT: afegirConjunt(); break;
        case LLISTAR: llistarParaules(); break;
      }
      opcio = menu();
    }

    // donem l'opció de descarregar el diccionari
    descarregarDiccionari(elMeuDiccionari);
  } // final de main

  // procediment que presenta el menú i llegeix (i retorna) l'opció escollida
  private static int menu ()  {

    System.out.println("(0) FINALITZAR");
    System.out.println("(1) BUSCAR ELS SINÒNIMS D'UNA PARAULA");
    System.out.println("(2) AFEGIR UN SINÒNIM A UNA PARAULA");
    System.out.println("(3) AFEGIR UN CONJUNT DE SINÒNIMS A UNA PARAULA");
    System.out.println("(4) LLISTAR TOTES LES PARAULES");
    System.out.println();

    // iterar mentre l'opció no sigui una de les permeses
    String cadOpcio; // l'opció, tal com la llegim
    int opcio; // l'opció convertida en un número
    do {
      System.out.print("opció? ");
      cadOpcio = Teclat.llegirCadena();
      try {
        opcio = Integer.parseInt(cadOpcio);
      }
      catch(NumberFormatException e) {
          opcio = -1;
      }
    }
    while (opcio<FINAL || opcio>LLISTAR);

    return opcio;
  }

  private static void premerPerContinuar() {
    System.out.print("Prem return per continuar...");
    Teclat.llegirCadena();
  }


  private static void buscarSinonims ()  {
    String paraula;
    String [] sinonims;


    // demanar la paraula (cadena)
    System.out.print("Paraula: ");
    paraula = Teclat.llegirCadena();

    // interrogar al diccionari
    sinonims = elMeuDiccionari.recuperar(paraula);

    if (sinonims.length==0) {
      // una taula de mida zero indica que la paraula no es coneix
      System.out.println("La paraula no apareix al diccionari");
    }
    else {
      // iterar sobre la taula i anar escrivint els sinònims
      for (String s: sinonims) System.out.println("  "+s);
    }
    premerPerContinuar();
  }

  private static void afegirSinonim ()  {
    String paraula;
    String sinonim;

    // Cal demanar la paraula
    System.out.print("Paraula: ");
    paraula = Teclat.llegirCadena();
    // Cal demanar el sinònim
    System.out.print("Sinonim: ");
    sinonim = Teclat.llegirCadena();

    // afegir i dir com ha anat
    if (elMeuDiccionari.afegir(paraula, sinonim))
        System.out.println("  Sinònim afegit");
    else
        System.out.println("  Sinònim NO afegit. Possible repetició");


    premerPerContinuar();
  }
  
  private static void afegirConjunt ()  {
    String paraula;
    String sinonims;
    boolean resultat = false;

    // Cal demanar la paraula
    System.out.print("Paraula: ");
    paraula = Teclat.llegirCadena();
    // Cal demanar tots els sinònims
    System.out.print("Sinònims (separats per espai(s)): ");
    sinonims = Teclat.llegirCadena();

    // passar-ho a un Set
    String [] taulaSinonims = sinonims.split(" ");
    Set<String> cjtSinonims = new HashSet<String>();
    for (String sin : taulaSinonims) cjtSinonims.add(sin);

    
    // afegir i dir com ha anat
    if (elMeuDiccionari.afegir(paraula, cjtSinonims))
        System.out.println("  Sinònims afegit");
    else
        System.out.println("  Sinònims NO afegits. Possible repetició");

    premerPerContinuar();
  }


   private static void llistarParaules ()  {
    String [] paraules;

    paraules = elMeuDiccionari.paraulesConegudes();

    if (paraules.length==0) {
      // una taula de mida zero indica que la paraula no es coneix
      System.out.println("El diccionari és buit");
    }
    else {
      // iterar sobre la taula i anar escrivint les paraules
      for (String s: paraules) System.out.println("  "+s);
    }
    premerPerContinuar();
  }

    private static void carregarDiccionari(DiccionariSinonims dic) {
        String filename;
        char resposta;

        System.out.println();
        do {
          System.out.print("Vols carregar el diccionari des d'un arxiu(S/N)? ");
          resposta = Teclat.llegirCadena().toUpperCase().charAt(0);
        }
        while(resposta!='N' && resposta!='S');

        if (resposta=='S') {
            System.out.print("nom arxiu que conté el diccionari: ");
            filename = Teclat.llegirCadena();

            // triar format de càrrega
            switch(modeCarrega) {
                case TEXT: carregarText (filename, dic); break;
                case BIN_NUM: carregarBinari_num (filename, dic);break;
                case BIN_MAR: carregarBinari_marca (filename, dic); break;
            }
        }
    }

    private static void descarregarDiccionari(DiccionariSinonims dic) {
        String filename;
        char resposta;

        System.out.println();
        do {
          System.out.print("Vols descarregar el diccionari en d'un arxiu(S/N)? ");
          resposta = Teclat.llegirCadena().toUpperCase().charAt(0);
        }
        while(resposta!='N' && resposta!='S');

        if (resposta=='S') {
            System.out.print("nom de l'arxiu per desar diccionari: ");
            filename = Teclat.llegirCadena();

           // triar format de descàrrega
            switch(modeDescarrega) {
                case TEXT: descarregarText (filename, dic); break;
                case BIN_NUM: descarregarBinari_num (filename, dic);break;
                case BIN_MAR: descarregarBinari_marca (filename, dic); break;
            }
        }
    }

    private static void descarregarText(String filename,
                                        DiccionariSinonims dic) {
        BufferedWriter out;
        String [] paraules;
        String [] sinonims;

        try {
            out = new BufferedWriter(new FileWriter(filename));

            paraules = dic.paraulesConegudes();
            for (String paraula : paraules) {
                // guardar la paraula
                out.write(paraula); out.newLine();
                // Cal recuperar els seus sinònims
                sinonims = dic.recuperar(paraula);
                // Cal escriure el nombre de sinònims i anar-los guardant
                out.write(String.valueOf(sinonims.length)); out.newLine();
                for (String sinonim : sinonims) {
                    out.write(sinonim); out.newLine();
                }
            }
            // tancar stream
            out.close();
        }
        catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    private static void carregarText(String filename, DiccionariSinonims dic) {

        BufferedReader in;
        String paraula;
        int numSinonims;
        HashSet<String> elsSinonims = new HashSet<String>();
        
        try {
        	in = new BufferedReader(new FileReader(filename));
        	
        	paraula = in.readLine();
        	while (paraula!=null) {
        		// Tenim una paraula vàlida. Mirem quants sinònims té
        		numSinonims = Integer.parseInt(in.readLine());
        		// llegim tots els seus sinònims i els guardem en el set
        		elsSinonims.clear();
        		for (int i=0; i<numSinonims; i++) {
        			elsSinonims.add(in.readLine());
        		}
        		// entrem en el diccionari la paraula i els seus sinònims
        		dic.afegir(paraula, elsSinonims);
        		
        		// passem a la següent paraula
        		paraula = in.readLine();
        	}
        	// tancar
        	in.close();
        	
        }
        catch (IOException ioex) {
        	System.out.println(ioex);
            System.exit(0);
        }

    }
    
    private static void descarregarBinari_marca(String filename,
                                                DiccionariSinonims dic) {

        DataOutputStream out;
        
        try {
        	out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        	
        	for (String paraula : dic.paraulesConegudes()) {
        		// Cal escriure la paraula
        		out.writeUTF(paraula);
        		// i cal escriure tots els seus sinònims
        		for (String sinonim : dic.recuperar(paraula)) {
        			out.writeUTF(sinonim);
        		}
        		// i finalment la marca de finalització de la seqüència de sinònims
        		out.writeUTF("***");
        	}
        	
        	out.close();
        	
        }
        catch (IOException ioex) {
        	System.out.println(ioex);
            System.exit(0);
        }
    }

    private static void carregarBinari_marca(String filename,
                                             DiccionariSinonims dic) {
        DataInputStream in;
        String paraula;
        String sinonim;
        String marca = "***";

        try {
            in = new DataInputStream(
                     new BufferedInputStream(
                         new FileInputStream(filename)));
            try {
                while (true) {
                    paraula = in.readUTF();
                    // llegir el primer sinònim i iterar
                    sinonim = in.readUTF();
                    while(!sinonim.equals(marca)) {
                        dic.afegir(paraula, sinonim);
                        sinonim = in.readUTF();
                    }
                }
            }
            catch(EOFException e) {
                // arribats a aquest punt podem tancar el canal
                in.close();
            }
        }
        catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    private static void descarregarBinari_num(String filename,
                                              DiccionariSinonims dic) {
        DataOutputStream out;
        String [] paraules;
        String [] sinonims;
        try {
            out = new DataOutputStream(new BufferedOutputStream
                  (new FileOutputStream(filename)));

            paraules = dic.paraulesConegudes();
            for (String paraula : paraules) {
                // Cal guardar la paraula
                out.writeUTF(paraula);
                // Cal recurperar els seus sinònims
                sinonims = dic.recuperar(paraula);
                // escriure el nombre de sinònims que hi ha
                out.writeInt(sinonims.length);
                // anar escrivint els sinònims
                for (String sinonim : sinonims) {
                    out.writeUTF(sinonim);
                }
            }

            // tancar stream
            out.close();
        }
        catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    /*private static void carregarBinari_num(String filename, 
                                           DiccionariSinonims dic) {
        DataInputStream in;
        String paraula;
        int numSinonims;
        HashSet<String> elsSinonims = new HashSet<String>();
        
        try {
        	in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        	
        	try {
        		while (true) {
        			// llegir la paraula 
        			paraula = in.readUTF();
        			// llegir el número de sinònims que té
        			numSinonims = in.readInt();
        			// llegir tots els sinònims
        			elsSinonims.clear();
        			for (int i=0; i<numSinonims; i++) {
        				elsSinonims.add(in.readUTF());
        			}
        			// vincular la paraula amb els seus sinònims
        			dic.afegir(paraula, elsSinonims);
        		}
        	}
        	catch(EOFException eofe) {}        		
        	in.close();
        	
        }
        catch (IOException ioex) {
        	System.out.println(ioex);
            System.exit(0);
        }

    }*/

  
	private static void carregarBinari_num(String filename,
			                               DiccionariSinonims dic) {
		DataInputStream in;
		String paraula;
		int numSinonims;
		HashSet<String> elsSinonims = new HashSet<String>();
		boolean acabar = false;

		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filename)));
			
			while (!acabar) {
				try {
					paraula = in.readUTF(); // llegir la paraula
					numSinonims = in.readInt(); // llegir el nombre de sinònims que té
					// llegir tots els sinònims
					elsSinonims.clear();
					for (int i = 0; i < numSinonims; i++) {
						elsSinonims.add(in.readUTF());
					}
					// vincular la paraula amb els seus sinònims
					dic.afegir(paraula, elsSinonims);
				} catch (EOFException eofe) {
					acabar = true;
				}
			}

			in.close();

		} catch (IOException ioex) {
			System.out.println(ioex);
			System.exit(0);
		}

	}
    
}

