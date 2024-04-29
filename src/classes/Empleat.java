package Altres;

public class Empleat implements Comparable<Empleat> {

	private String id;
	private String nom;
	private String posicio;
	private int anyIngres;
	private double sou;
	
	public Empleat (String id) {
		this(id, "sense nom", "sense posicio", 0, 0.0);
	}
	
	public Empleat (String id, String nom, String posicio, int anyIngres, double sou) {
		this.id = id;
		this.nom = nom;
		this.posicio = posicio;
		this.anyIngres = anyIngres;
		this.sou = sou;
	}
	
	public String getId() {return this.id;}
	public String getNom () {return this.nom;}
	public String getPosicio () {return this.posicio;}
	public int getAnyIngres () {return this.anyIngres;}
	public double getSou () {return this.sou;}
	
	public void setNom (String nom) {this.nom = nom;}
	public void setPosicio (String posicio) {this.posicio = posicio;}
	public void setAnyIngres (int anyIngres) {this.anyIngres = anyIngres;}
	public void setSou (double sou) {this.sou = sou;}
	
	public int compareTo (Empleat e) {
		return this.id.compareTo(e.id);
	}
	
	public boolean equals (Object o) {
		return (o instanceof Empleat) ? compareTo((Empleat)o)==0 : false;
	}
	
	public int hashCode () {return id.hashCode();}
	
	public String toString () {
		return "< "+id+" "+nom+" "+posicio+" "+anyIngres+" "+sou+" >";
	}
	
}
