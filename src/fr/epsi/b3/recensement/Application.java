package fr.epsi.b3.recensement;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Ville> villes = new ArrayList<>();
        villes.add(new Ville(3, "PDLA", 85, 85000, "LRSY", 50000));
        villes.add(new Ville(12, "LA", 44, 44200, "Nantes", 300000));
        villes.add(new Ville(54, "RegionBraux", 1, 10000, "Braux", 5));
        villes.add(new Ville(54, "RegionBraux", 1, 10000, "Braux", 5));

        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < villes.size(); i++) {
            Ville ville = villes.get(i);
            String nomCommune = ville.getNomCommune();

            Integer compteur = compteurs.get(nomCommune);
            if (compteur == null) {
                compteur = 0;
            }
            compteur++;
            compteurs.put(nomCommune, compteur);
        }

        Set<String> nomCommunes = compteurs.keySet();
        Iterator<String> iterateur = nomCommunes.iterator();

        while (iterateur.hasNext()) {
            String nomCommune = iterateur.next();
            Integer valeurCompteur = compteurs.get(nomCommune);
            System.out.println("Nom commune : " + nomCommune + " - Nombre de région : " + valeurCompteur);
        }

//        String[] morceaux = ligne.split(";");
//        String codeRegion = morceaux[0];
//        String nomRegion = morceaux[1];
//        String codeDepartement = morceaux[2];
//        String codeCommune = morceaux[5];
//        String nomCommune = morceaux[6];
//        String population = morceaux[7];
//
//        int populationTotale = Integer.parseInt(population.replace(" ", "").trim());
//
//        Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
    }
}
