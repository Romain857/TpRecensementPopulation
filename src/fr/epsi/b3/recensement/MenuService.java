package fr.epsi.b3.recensement;

import java.util.Scanner;

public abstract class MenuService {

    private Scanner scanner = new Scanner(System.in);
    private Recensement recensement;

    public MenuService(Recensement recensement) {
        this.recensement = recensement;
    };

    public void afficherMenu() {
        int choix = 0;
        while (0 < choix && choix < 9) {
            
        }
        System.out.println("RECENSEMENT :\n1. Population d'une ville donnée\n2. Population d'un département donné\n3. Population d'une région donnée\n4. Afficher les 10 régions les plus peuplées\n5. Afficher les 10 départements les plus peuplés\n6. Afficher les 10 villes les plus peuplées d’un département\n7. Afficher les 10 villes les plus peuplées d’une région\n8. Afficher les 10 villes les plus peuplées de France\n9. Sortir");
        choix = scanner.nextInt();
        selecteurChoix(choix);
    }

    public void afficherPopVille() {
        System.out.println("Quelle ville ?");
        String inputVille = scanner.nextLine();

        if (recensement.getVille(inputVille)) {
            Ville ville = recensement.getVille(inputVille);
            System.out.println("La ville " + ville.getNomCommune() + " a une population de " + ville.getPopTotale());
        }
        else {
            System.out.println("Cette ville n'existe pas !");
        }
        
    }

    public void afficherPopDepartement() {
        System.out.println("Quel département ? (code)");
        String inputDp = scanner.nextLine();

        if (recensement.getDpPop(inputDp)) {
            System.out.println("Le département " +  inputDp + " a une population de " + recensement.getDpPop(inputDp));
        }
        else {
            System.out.println("Ce département n'existe pas !");
        }

    }
    
    public void afficherPopRegion() {
        System.out.println("Quelle région ?");
        String inputRegion = scanner.nextLine();

        if (recensement.getRegionPop(inputRegion)) {
            System.out.println("La région " +  inputRegion + " a une population de " + recensement.getRegionPop(inputRegion));
        }
        else {
            System.out.println("Cette région n'existe pas !");
        }
    }

    public void afficherTopRegion() {
        System.out.println("TOP 10 Régions/pop. :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+". " + recensement.getTopRegions()[i] +"\n");
        }
    }

    public void afficherTopDp() {
        System.out.println("TOP 10 Départements/pop. :");
        for (int i = 0; i < 10; i++) {
            System.out.println(i+". " + recensement.getTopDp()[i] +"\n");
        }
    }

    public void afficherTopVilles() {
        System.out.println("TOP 10 Villes/pop. :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+". " + recensement.getTopVilles()[i] +"\n");
        }
    }

    public void afficherTopVillesDp() {
        System.out.println("Quel département ?");
        String inputDp = scanner.nextLine();

        if (recensement.getTopVillesDp(inputDp)) {
            System.out.println("TOP 10 Villes/pop. du " + inputDp + " :");
            for (int i = 1; i <= 10; i++) {
                System.out.println(i+". " + recensement.getTopVillesDp(inputDp)[i] +"\n");
            }
        }        
        else {
            System.out.println("Ce département n'existe pas !");
        }
    }

    public void afficherTopVillesRegion() {
        System.out.println("Quelle région ?");
        String inputRegion = scanner.nextLine();

        if (recensement.getTopVillesRegion(inputRegion)) {
            System.out.println("TOP 10 Villes/pop. de " + inputRegion + " :");
            for (int i = 1; i <= 10; i++) {
                System.out.println(i+". " + recensement.getTopVillesRegion(inputRegion)[i] +"\n");
            }
        }
        else {
            System.out.println("Cette région n'existe pas !");
        }
    }

    public void sortir() {
        System.out.println("Adios.");
    }

    public void selecteurChoix(int choix) {
        switch (choix) {
            case 1:
                    afficherPopVille();
                break;
            case 2:
                    afficherPopDepartement();
                break;
            case 3:
                    afficherPopRegion();
                break;
            case 4:
                    afficherTopRegion();
                break;
            case 5:
                    afficherTopDp();
                break;
            case 6:
                    afficherTopVillesDp();
                break;
            
            case 7:
                    afficherTopVillesRegion();
                break;
            
            case 8:
                    afficherTopVilles();
                break;
            
            case 9:
                    sortir();
                break;
        }
    }


}
