package net.ent.etrs.bateau.model;

import java.util.Objects;

public class TypeBateau {
    private String nom;
    private int longueur;
    private float tonnageMax;

    public TypeBateau( String leNomTypeBateau, int laLongueur, float leTonnageMax) {
        this.setNom(leNomTypeBateau);
        this.setLongueur(laLongueur);
        this.setTonnageMax(leTonnageMax);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeBateau that = (TypeBateau) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
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
