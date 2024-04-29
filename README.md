Estructures de  Dades i Algorismes

Exercicis sobre  “col·leccions” 

![alt text](./img/logo-tc.png)

EXERCICIS PER  REALITZAR


Ens basarem en aquestes classes per fer els següents exercicis:

```java
public class Element {
    private String name;
    private int value;
    // Constructor
    public Element (String name, int value) {
        this.name = name;
        this.value = value;
    }
    // setters & getter
    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newVal) {
        this.value=newVal;
    }

    // equality (overriding of superclass equals)
    public boolean equals (Object o) {
        Element other;
        try {
            other = (Element)o;
            return this.name.equals(other.name);
        }
        catch(Exception e) {
            return false;
        }
    }
    // toString (overriding of superclass toString)
    public String toString () {
        return "Element["+name+" "+value+"]";
    }
}
```

Podeu trobar el codi al fitxer [**`Element.java`**](./files/Element.java).


```java
public class Criatura implements Comparable{
    // Declaració de constants
    public static final int NEN = 10;
    public static final int NENA = 20;
    public static final int MIN_EDAT=0;
    public static final int MAX_EDAT=6;
    
    // Atributs
    private String nom;
    private int edat;
    private int sexe;

    // Constructor amb tots els paràmetres
    public Criatura(String _nom, int _edat, int _sexe) {
        if (_edat<MIN_EDAT || _edat>MAX_EDAT)
            throw new IllegalArgumentException("edat no vàlida: "+_edat);
        if (_sexe!=NEN && _sexe!=NENA)
            throw new IllegalArgumentException("sexe no vàlid: "+_sexe);  
        this.nom = _nom;
        this.edat = _edat;
        this.sexe = _sexe;
    }
    
    // Setters i Getters
    public String getNom() {
        return this.nom;
    }
    
    public int getEdat() {
        return this.edat;
    }
    
    public int getSexe() {
        return this.sexe;
    }

    public void setNom(String _nom) {
        this.nom = _nom;
    }

    public void setEdat(int _edat) {
        this.edat = _edat;
    }

    public void setSexe(int _sexe) {
        this.sexe = _sexe;
    }
  
    // Redefinició del mètode toString heretat d'Object
    public String toString () {
        String resultat;
        resultat = "Criatura de nom: " + this.nom + ", té " + this.edat + " anys. ";
        return resultat += (sexe == NEN) ? "Sexe: nen": "Sexe: nena";
    }
    
    // Implementació de la interfície Comparable
    public int compareTo(Object objecteAComparar) {
        // comparació basada en l'ordre lexicogràfic
        // sense distingir majúscules de minúscules.
        Criatura unaAltraCriatura = (Criatura) objecteAComparar;
        return this.nom.compareToIgnoreCase(unaAltraCriatura.nom);
    }
    
    // Redefinició del mètode equals heretat d'object.
    public boolean equals(Object objecteAComparar) {
        // redefinició compatible amb compareTo
        try {
            return (this.compareTo(objecteAComparar) == 0);
        }
        catch(ClassCastException excepcio) {
            return false;
        }
    }
}
```

## Familiaritzar-se amb **`Collection`**
 
Trobareu aquest exercici en el paquet ex_00. S’utilitza la **classe `Element`**, el codi de la qual teniu en el fitxer [**`Element.java`**](./files/Element.java).

### Heu de completar els punts que s’indica per tal de realitzar les accions que s’especifiquen. 

