package net.ent.etrs.bateau.model;

import java.util.Objects;

public class Armement {
    private String nom;
    private float calibre;
    private int portee;

    public Armement(String nom, float calibre, int portee) {
        this.nom = nom;
        this.calibre = calibre;
        this.portee = portee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armement armement = (Armement) o;
        return Float.compare(calibre, armement.calibre) == 0 && Objects.equals(nom, armement.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, calibre);
    }

    @Override
    public String toString() {
        return "Armement{" +
                "nom='" + nom + '\'' +
                ", calibre=" + calibre +
                ", portee=" + portee +
                '}';
    }
}
