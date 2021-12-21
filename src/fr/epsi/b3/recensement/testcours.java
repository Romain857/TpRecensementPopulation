package fr.epsi.b3.recensement;

import java.util.*;

class Article {
    /**
     * nom de l'article
     */
    private String nom;
    /**
     * référence de l'article
     */
    private String reference;
    /**
     * catégorie
     */
    private String categorie;
    /**
     * prix en euros
     */
    private double prix;

    /**
     * Constructeur * @param nom nom de l'article * @param reference référence de l'article * @param categorie catégorie * @param prix prix en euros
     */
    public Article(String nom, String reference, String categorie, double prix) {
        super();
        this.nom = nom;
        this.reference = reference;
        this.categorie = categorie;
        this.prix = prix;
    }

    /**
     * Getter * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Setter * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Getter * @return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Setter * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * Getter * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Setter * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
}

/**
 * Application de comptage utilisant les HashMap
 */
class AppComptage {
    /**
     * Point d'entrée * * @param args non utilisés ici
     */
    public static void main(String[] args) {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("IPhone 11", "REF001", "Smartphone", 859.0));
        articles.add(new Article("Dragon Quest XI: Les combattants de la destinée", "REF013", "Jeu vidéo", 44.49));
        articles.add(new Article("IPhone 11 Pro", "REF002", "Smartphone", 1159.0));
        articles.add(new Article("Izuku support téléphone voiture", "REF003", "Accessoires Smartphone", 11.99));
        articles.add(new Article("Fire TV Stick", "REF004", "Accessoires High Tech", 11.99));
        articles.add(new Article("Echo dot enceinte connectée", "REF005", "Accessoires High Tech", 59.99));
        articles.add(new Article("FIFA 20", "REF006", "Jeu vidéo", 54.99));
        articles.add(new Article("Joyguard coque IPhone 11", "REF007", "Accessoires Smartphone", 5.99));
        articles.add(new Article("Samsung Galaxy A10 Dual sim", "REF008",
                "Smartphone", 121.0));
        articles.add(new Article("HETP Ecouteur Bluetooth sans fil", "REF009", "Accessoires High Tech", 121.0));
        articles.add(new Article("XIAOMI Redmi Note 7", "REF010", "Smartphone", 169.94));
        articles.add(new Article("Rampow adaptateur USB C vers OTG 3.1", "REF011", "Accessoires High Tech", 6.99));
        articles.add(new Article("The legend of Zelda: Link'a Awakening", "REF012", "Jeu vidéo", 41.99));

        HashMap<String, Integer> compteurs = new HashMap<>();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String categorie = article.getCategorie();
            Integer compteur = compteurs.get(categorie);

            if (compteur == null) {
                compteur = 0;
            }
            compteur++;
            compteurs.put(categorie, compteur);
        }
        Set<String> categories = compteurs.keySet();
        Iterator<String> iterateur = categories.iterator();
        while (iterateur.hasNext()) {
            String categorie = iterateur.next();
            Integer valeurCompteur = compteurs.get(categorie);
            System.out.println("Categorie:" + categorie + " - Nombre d'articles:" + valeurCompteur);
        }
    }
}