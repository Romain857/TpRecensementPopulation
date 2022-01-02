package fr.epsi.b3.recensement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recensement {
    private List<Ville> villes = new ArrayList<>();

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public void addVille(int codeRegion, String nomRegion, String codeDepartement, int codeCommune, String nomCommune, int populationTotale) {
        villes.add(new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale));
    }

    public Ville getville(String inputVille) {
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

    public List<String> getTopVilles() {
        List<String> listPopTotVille = new ArrayList<>();
        int t = villes.size();
        String tmp;
        for (int i = 0; i < t - 1; i++) {
            for (int j = t - 1; j > i; j--) {
                if (villes.get(j - 1).getPopTotale() > villes.get(j).getPopTotale()) {
                    tmp = String.valueOf(villes.get(j - 1).getPopTotale());
                    listPopTotVille.set(j - 1, String.valueOf(villes.get(j).getPopTotale()));
                    listPopTotVille.set(j, tmp);
                }
            }
        }
        return listPopTotVille;
    }
}