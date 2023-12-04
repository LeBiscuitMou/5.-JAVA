package net.ent.etrs.arene.model;

import net.ent.etrs.arene.model.exceptions.GladiateurException;
import net.ent.etrs.arene.model.references.ConstantesMetier;

import java.util.Objects;

public abstract class Gladiateur {
    private String nom;
    private int experience;

    public Gladiateur(String nom, int experience) throws GladiateurException {
        this.setNom(nom);
        this.setExperience(experience);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws GladiateurException {
        // Test de base
        // si c'est null
        if (Objects.isNull(nom)){
            throw new GladiateurException("Gladiateur est null");
        }
        // si c'est vide
        if (nom.isBlank()){
            throw new GladiateurException("Le nom du gladiateur est vide");
        }
        this.nom = nom;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) throws GladiateurException {
        if (experience <= 0) {
            throw new GladiateurException("L'expérience est inférieure à 0");
        }
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gladiateur that = (Gladiateur) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Gladiateur{" +
                "nom='" + nom + '\'' +
                ", experience=" + experience +
                '}';
    }

    public abstract void combattre();
}