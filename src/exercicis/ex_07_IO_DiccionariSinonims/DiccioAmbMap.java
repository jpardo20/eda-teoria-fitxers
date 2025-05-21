package exercicis.ex_07_IO_DiccionariSinonims;

import java.util.*;


public class DiccioAmbMap implements ex_07_IO_DiccionariSinonims.DiccionariSinonims {

    private Map<String, Set<String>> infrastructura;

    /* constructor */
    public DiccioAmbMap () {
        // nom�s cal crear la infrastructura
        this.infrastructura=new TreeMap<String, Set<String>>();
    }

    public boolean afegir(String paraula, String sinonim) {
        String pMaj = paraula.toUpperCase();
        String sMaj = sinonim.toUpperCase();
        // si la paraula existeix, en recuperem el conjunt de
        // sin�nims i provem d'afegir-hi el que ens han donat
        if (this.infrastructura.containsKey(pMaj)) {
            Set<String> sinonims = this.infrastructura.get(pMaj);
            return sinonims.add(sMaj);
        }
        else {
            // si no existeix li vinculem un nou conjunt de sin�nims que
            // de moment nom�s cont� el sin�nim donat
            Set<String> nou = new TreeSet<String>();
            this.infrastructura.put(pMaj, nou);
            return nou.add(sMaj);
        }
    }

    public boolean afegir(String paraula, Set<String> sinonims) {
        // Proveu d'implementat aquest m�tode sense fer �s de l'anterior.
        // una iteraci� for-each sobre el segon par�metre us ser� �til.
        // Recordeu que la paraula (primer par�metre) pot ser nova o no.
        String pMaj = paraula.toUpperCase();
        Set<String> sinonimsParaula;
        boolean resultat = false;
        if (this.infrastructura.containsKey(pMaj))
            sinonimsParaula = this.infrastructura.get(pMaj);
        else {
            // crear i vincular
            sinonimsParaula = new TreeSet<String>();
            this.infrastructura.put(pMaj, sinonimsParaula);
        }
        for (String sinonim : sinonims) {
            resultat = sinonimsParaula.add(sinonim.toUpperCase()) || resultat;
        }
        return resultat;
    }

    public String[] recuperar(String paraula) {
        String pMaj = paraula.toUpperCase();
        String [] resultat;
        // si la paraula hi �s, recuperem el seu conjunt de sin�nims i el
        // "volquem" en una taula de nova creaci�
        if (this.infrastructura.containsKey(pMaj)) {
            Set<String> sinonims = this.infrastructura.get(pMaj);
            resultat = new String[sinonims.size()];
            int i = 0;
            for (String s: sinonims) {
                resultat[i]=s;
                i++;
            }
         }
         else {
            // i si no hi �s ens limitem a crear una taula de mida 0
            resultat = new String[0];
         }
         return (resultat);
    }

    public String[] paraulesConegudes() {
        Set<String> paraules;
        String [] resultat;
        paraules = this.infrastructura.keySet();
        resultat = new String[paraules.size()];
        int i = 0;
        for (String s: paraules) {
            resultat [i] =s;
            i++;
        }
        return(resultat);
    }

}
