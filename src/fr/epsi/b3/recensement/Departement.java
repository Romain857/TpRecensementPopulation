package fr.epsi.b3.recensement;

public class Departement {
    private String codeDp;
    private int population;

    public Departement(int population, String codeDp) {
        this.population = population;
        this.codeDp = codeDp;
    }


    public String getCodeDp() {
        return codeDp;
    }
    public void setCodeDp(String codeDp) {
        this.codeDp = codeDp;
    }
    public int getPopulation() {
        return population;
    }
    public void addPopulation(int population) {
        this.population += population;
    }
}
