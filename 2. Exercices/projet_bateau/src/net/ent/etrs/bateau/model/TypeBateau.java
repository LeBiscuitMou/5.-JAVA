package net.ent.etrs.bateau.model;

public class TypeBateau {
    private String nom;
    private int longueur;
    private float tonnageMax;

    public TypeBateau(String nom, int longueur, float tonnageMax) {
        this.setNom(nom);
        this.setLongueur(longueur);
        this.setTonnageMax(tonnageMax);
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

    @Override
    public String toString() {
        return "TypeBateau{" +
                "nom='" + nom + '\'' +
                ", longueur=" + longueur +
                ", tonnageMax=" + tonnageMax +
                '}';
    }
}