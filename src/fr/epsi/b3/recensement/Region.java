package fr.epsi.b3.recensement;

public class Region {
    private String nom;
    private int population;
    
    public Region(String nom, int population) {
        this.nom = nom;
        this.population = population;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPopulation() {
        return population;
    }
    public void addPopulation(int population) {
        this.population += population;
    }
}
