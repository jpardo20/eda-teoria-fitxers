package exercicis.ex_08_09_Save_and_Restore;

import java.util.*;

public class Producte {

    private String nom;
    private double preu;
    private Set<Part> parts;

    public Producte (String nom, double preu, Set<Part> parts) {
        this.nom = nom;
        this.preu = preu;
        this.parts = parts;
    }

    public String getNom() {return this.nom;}
    public double getPreu() {return this.preu;}
    public Set<Part> getParts() {return this.parts;}

}
