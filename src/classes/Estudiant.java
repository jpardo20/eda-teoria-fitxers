package classes;

/* La classe Estudiant. Un estudiant és una encapsulació que consta de:
un nom, una edat, una qualificació per l'assignatura Mates,
una altra per a l'assignatura Anglès i una tercera per l'assignatura Programació. */

public class Estudiant {

    // Declaració dels atributs
    private String nom;
    private int edat;
    private double notaMates;
    private double notaAngles;
    private double notaProg;

    // Constructor
    public Estudiant(String nom, int edat) {
        /* Un estudiat es construeix a partir del nom i de l'edat.
         * Inicialment, les notes de les assignatures són totes 0.0 double. */
        this.nom = nom;
        this.edat = edat;

        this.notaMates = 0.0;
        this.notaAngles = 0.0;
        this.notaProg = 0.0;
    }

    // Mètodes get: Consulta dels atributs
    public String getNom() {return this.nom;}
    public int getEdat() {return this.edat;}
    public double getNotaMates() {return this.notaMates;}
    public double getNotaAngles() {return this.notaAngles;}
    public double getNotaProg() {return this.notaProg;}

    // Mètodes set: Modificació dels atributs
    public void setEdat(int _edat) {
        if (_edat >= 18) {
            this.edat = _edat;
        }
    }

    public void setNotaMates(double _notaMates) {
        if (this.notaValida(_notaMates)) {
            this.notaMates = _notaMates;
        }
    }

    public void setNotaAngles(double _notaAngles) {
        if (this.notaValida(_notaAngles)) {
            this.notaAngles = _notaAngles;
        }
    }

    public void setNotaProg(double _notaProg) {
        if (this.notaValida(_notaProg)) {
            this.notaProg = _notaProg;
        }
    }
    
    // Altres mètodes
    public double mitjana() {
        double calculMitjana;
        calculMitjana = this.notaMates + this.notaAngles + this.notaProg;
        calculMitjana = calculMitjana / 3.0;
        return(calculMitjana);
    }

    public double mitjanaPonderada(double _pes1, double _pes2, double _pes3) {
        double suma;
        suma = _pes1 * this.notaMates + _pes2 * this.notaAngles + _pes3 * this.notaProg;
        return suma;
    }

    // Mètode toString que no era present la primera versió d'aquesta classe
    public String toString () {
        String resultat;
        resultat = this.nom.toUpperCase() + " (" + this.edat + " anys)\n";
        resultat += "  Matemàtiques: " + this.notaMates + "\n";
        resultat += "  Anglàs:       " + this.notaAngles + "\n";
        resultat += "  Programació:  " + this.notaProg;
        return resultat;
    }

    // Mètode privat
    private boolean notaValida(double nota) {
        // atès que és privat, aquest mètode no és accessible des de l'exterior
        return ((nota >= 0.0) && (nota <= 10.0));
    }
    
}