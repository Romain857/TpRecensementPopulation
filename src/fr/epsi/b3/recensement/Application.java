package fr.epsi.b3.recensement;

import java.io.*;
import java.util.*;

public class Application {

    public static Recensement recensement = new Recensement();
    public static void main(String[] args) throws IOException {

        String file = "../recensement_2016.csv";
        String line;
        String [] ligne;
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();//Lis la première ligne, n'en fait rien
        while((line = br.readLine()) != null){
            ligne = line.split(";");
            recensement.addVille(Integer.parseInt(ligne[0]), ligne[1], ligne[2], Integer.parseInt(ligne[5]), ligne[6], Integer.parseInt(ligne[9].replaceAll("\s", "")));
        }

    }


}
