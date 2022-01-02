package fr.epsi.b3.recensement;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Application {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception{
        List<Ville> villes = new ArrayList<>();

        String fileName= "/Users/romai/Desktop/recensement_2016.csv";
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+",");
        }
        scanner.close();

        File file= new File(fileName);
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(";");
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNo = 1;
        for(List<String> line: lines) {
            int columnNo = 1;
            for (String value: line) {
                System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
                columnNo++;
            }
            lineNo++;
        }

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