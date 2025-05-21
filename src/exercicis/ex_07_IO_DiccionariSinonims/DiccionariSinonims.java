package exercicis.ex_07_IO_DiccionariSinonims;

import java.util.*;

public interface DiccionariSinonims {

    /* afegir un sin�nim d'una paraula. Retorna true si efectivament
     * s'ha pogut afegir i false si no s'ha pogut fer -perqu� el sin�nim
     * ja era conegut per a aquella paraula. Les implementacions d'aquest
     * m�tode no haurien de ser sensibles a la distinci� entre maj�scules
     * i min�scules */
    boolean afegir(String paraula, String sinonim);

    /* afegeix a la paraula tots els sin�nims del conjunt. Retorna true
     * si algun dels sin�nims s'ha pogut afegir a la paraula i false en
     * cas contrari Les implementacions d'aquest m�tode no haurien de ser
     * sensibles a la distinci� entre maj�scules i min�scules */
    boolean afegir(String paraula, Set<String> sinonims);

    /* recupera els sin�nims coneguts de la paraula donada com a par�metre.
     * La taula ha de tenir la mida exacta (tantes posicions com sin�nims
     * t� la paraula. Si la paraula no t� cap sin�nim -no �s coneguda- llavors
     * la taula ha de tenir mida (length) 0. Les implementacions d'aquest
     * m�tode no haurien de ser sensibles a la distinci� entre maj�scules
     * i min�scules */
    String [] recuperar (String paraula);

    /* Retorna una taula amb totes les paraules de les quals se'n tenen
     * sin�nims. La taula ha de tenir la mida exacta (tantes posicions com
     * parules tinguin sin�nims. Si el diccionari es buit llavors la taula
     * ha de tenir mida (length) 0 */
    String [] paraulesConegudes ();

}
