package net.ent.etrs.bateau.model;

public class TypeBateau {
    private String nom;
    private int longueur;
    private float tonnageMax;

    public TypeBateau(String nom, int longueur, float tonnageMax) {
        this.nom = nom;
        this.longueur = longueur;
        this.tonnageMax = tonnageMax;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public float getTonnageMax() {
        return tonnageMax;
    }

    public void setTonnageMax(float tonnageMax) {
        this.tonnageMax = tonnageMax;
    }

    public void afficherInfoTypeBateau() {
        System.out.println("Nom type de bâteau : " + nom);
        System.out.println("Longueur : " + longueur);
        System.out.println("Tonnage max : " + tonnageMax);
    }
}