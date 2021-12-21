package fr.epsi.b3.recensement;

public class Ville {
    private int codeRegion;
    private String nomRegion;
    private int codeDepartement;
    private int codeCommune;
    private String nomCommune;
    private  int popTotale;

    public Ville(int codeRegion, String nomRegion, int codeDepartement, int codeCommune, String nomCommune, int popTotale){
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.popTotale = popTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(int codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(int codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public int getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(int codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public int getPopTotale() {
        return popTotale;
    }

    public void setPopTotale(int popTotale) {
        this.popTotale = popTotale;
    }
}
