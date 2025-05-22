package exercicis.ex_07_IO_DiccionariSinonims;

import java.util.*;

public interface DiccionariSinonims {

    /* Per afegir un sinònim d'una paraula. Retorna true si efectivament
     * s'ha pogut afegir i false si no s'ha pogut fer -perquè el sinònim
     * ja era conegut per a aquella paraula. Les implementacions d'aquest
     * mètode no haurien de ser sensibles a la distinció entre majúscules
     * i minúscules */
    boolean afegir(String paraula, String sinonim);

    /* Per afegir a la paraula tots els sinònims del conjunt. Retorna true
     * si algun dels sinònims s'ha pogut afegir a la paraula i false en
     * cas contrari Les implementacions d'aquest mètode no haurien de ser
     * sensibles a la distinció entre majúscules i minúscules. */
    boolean afegir(String paraula, Set<String> sinonims);

    /* Recupera els sinònims coneguts de la paraula donada com a paràmetre.
     * La taula ha de tenir la mida exacta (tantes posicions com sinònims
     * té la paraula. Si la paraula no té cap sinònim -no és coneguda- llavors
     * la taula ha de tenir mida (length) 0. Les implementacions d'aquest
     * mètode no haurien de ser sensibles a la distinció entre majúscules
     * i minúscules */
    String [] recuperar (String paraula);

    /* Retorna una taula amb totes les paraules de les quals se'n tenen
     * sinònims. La taula ha de tenir la mida exacta (tantes posicions com
     * paraules tinguin sinònims. Si el diccionari és buit llavors la taula
     * ha de tenir mida (length) 0 */
    String [] paraulesConegudes ();

}
