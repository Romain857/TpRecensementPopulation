package fr.epsi.b3.recensement;

import java.io.*;
import java.util.*;

public class Application {

    public static Recensement recensement = new Recensement();
    public static MenuService affichage = new MenuService(recensement);

    public static void main(String[] args) throws IOException {

        String file = "../recensement_2016.csv";
        String line;
        List<String[]> tableaucsv = new ArrayList<>();
        String [] ligne;
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();//Lis la première ligne, n'en fait rien
        while((line = br.readLine()) != null){
            ligne = line.split(";");
            tableaucsv.add(ligne);
            recensement.addVille(Integer.parseInt(ligne[0]), ligne[1], ligne[2], Integer.parseInt(ligne[5]), ligne[6], Integer.parseInt(ligne[9].replaceAll("\s", "")));
        }


        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < recensement.getVilles().size(); i++) {
            Ville ville = recensement.getVilles().get(i);
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

        affichage.afficherMenu();

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
