package fr.epsi.b3.recensement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recensement {
    private List<Ville> villes = new ArrayList<>();
    private List<Departement> departements = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public void addVille(int codeRegion, String nomRegion, String codeDepartement, int codeCommune, String nomCommune, int populationTotale) {
        villes.add(new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale));
    }
  
    public Ville getVille(String inputVille){
        for (Ville ville : villes) {
            if (Objects.equals(ville.getNomCommune(), inputVille)) {
                return ville;
            }
        }
        return null;
    }

    public int getDpPop(String codeDepartement) {
        int totalpop = 0;
        for (Ville ville : villes) {
            if (Objects.equals(ville.getCodeDepartement(), codeDepartement)) {
                totalpop += ville.getPopTotale();
            }
        }
        return totalpop;
    }

    public int getRegionPop(String regionName) {
        int totalpop = 0;
        for (Ville ville : villes) {
            if (Objects.equals(ville.getNomRegion(), regionName)) {
                totalpop += ville.getPopTotale();
            }
        }
        return totalpop;
    }

    public List<Ville> getTopVilles() {
        List<Ville> listPopTotVille = villes;
        int t = listPopTotVille.size();
        Ville tmp;
        for (int i = t-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (villes.get(j + 1).getPopTotale() > villes.get(j).getPopTotale()) {
                    tmp = listPopTotVille.get(j + 1);
                    listPopTotVille.set(j + 1, listPopTotVille.get(j));
                    listPopTotVille.set(j, tmp);
                }
            }
        }
        return listPopTotVille;
    }

    public List<Departement> getTopDp(){
        List<Departement> listTopDp = new ArrayList<>();
        for(int dp = 1; dp<=95; dp++) {
            int habParDep = getDpPop(String.valueOf(dp));
            int t = departement.size();
            Integer tmp;
            departement.add(habParDep);
            for (int i = t-1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if (departement.get(j + 1) > habParDep) {
                        tmp = departement.get(j + 1);
                        departement.set(j + 1, habParDep);
                        departement.set(j, tmp);
                    }
                }
            }
        }
        return departement;
    }
}