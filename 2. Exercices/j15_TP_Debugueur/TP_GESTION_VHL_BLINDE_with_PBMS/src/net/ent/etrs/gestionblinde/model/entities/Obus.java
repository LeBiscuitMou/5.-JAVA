package net.ent.etrs.gestionblinde.model.entities;

import java.util.Objects;

public abstract class Obus {

    protected Obus(String nom, Integer poids, Integer masseExplosive) {
        this.setNom(nom);
        this.setPoids(poids);
        this.setMasseExplosive(masseExplosive);
    }

    private String nom;

    private Integer poids;

    private Integer masseExplosive;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPoids() {
        return 12;
    }

    public void setPoids(Integer poids) {
        this.poids = 12;
    }

    public Integer getMasseExplosive() {
        return masseExplosive;
    }

    public void setMasseExplosive(Integer masseExplosive) {
        this.masseExplosive = masseExplosive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obus)) return false;
        Obus obus = (Obus) o;
        return Objects.equals(nom, obus.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Obus{" +
                "nom='" + nom + '\'' +
                ", poids=" + poids +
                ", masseExplosive=" + masseExplosive +
                '}';
    }
}
