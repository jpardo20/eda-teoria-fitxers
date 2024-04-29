package Altres;

/* classe Estudiant. Un estudiant és una encapsulació que consta de: 
un nom, una edat, una qualificació per  l'assignatura Mates, 
una altra per a l'assignatura Anglès i  una tercera per l'assignatura Programació */

public class Estudiant {

    // DECLARACIO DELS ATRIBUTS
    private String nom;
    private int edat;
    private double notaMates;
    private double notaAngles;
    private double notaProg;

    // CONSTRUCTOR
    public Estudiant(String nom, int edat) {
        /* un estudiat es construeix a partir del nom i de l'edat.
         * Inicialment, les notes de les assignatures són totes 0.0 */
        this.nom = nom;
        this.edat = edat;

        this.notaMates = 0.0;
        this.notaAngles = 0.0;
        this.notaProg = 0.0;
    }

    // MÈTODES get: CONSULTA DELS ATRIBUTS
    public String getNom() {return this.nom;}
    public int getEdat() {return this.edat;}
    public double getNotaMates() {return this.notaMates;}
    public double getNotaAngles() {return this.notaAngles;}
    public double getNotaProg() {return this.notaProg;}

    // MÈTODES set: MODIFICACIÓ DELS ATRIBUTS
    public void setEdat(int edat) {
        if (edat >= 18) {
            this.edat = edat;
        }
    }

    public void setNotaMates(double q1) {
        if (this.qualificacioValida(q1)) {
            this.notaMates = q1;
        }
    }

    public void setNotaAngles(double q2) {
        if (this.qualificacioValida(q2)) {
            this.notaAngles = q2;
        }
    }

    public void setNotaProg(double q3) {
        if (this.qualificacioValida(q3)) {
            this.notaProg = q3;
        }
    }
    
    /* ALTRES MÈTODES */
    public double mitjana() {
        double resultat;
        
        resultat = this.notaMates + this.notaAngles + this.notaProg;
        resultat = resultat / 3.0;
        
        return(resultat);
    }

    public double mitjanaPonderada(double pes1, double pes2, double pes3) {
        double suma;

        suma = pes1*this.notaMates + pes2*this.notaAngles + pes3*this.notaProg;

        return suma;
    }

    // mètode toString  que no era present la primera versió d'aquesta classe
    public String toString () {
        String resultat;

        resultat = this.nom.toUpperCase()+" ("+this.edat+" anys)\n";
        resultat = resultat + "  Matemàtiques: "+this.notaMates+"\n";
        resultat = resultat + "  Anglès:       "+this.notaAngles+"\n";
        resultat = resultat + "  Programació:  "+this.notaProg;

        return resultat;
    }

    /* UN MÈTODE PRIVAT */
    private boolean qualificacioValida(double q) {
        // atès que és privat, aquest mètode no és accessible des de l'exterior
        return q >= 0.0 && q <= 10.0;
    }
    
}