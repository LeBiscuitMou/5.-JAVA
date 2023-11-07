package net.ent.etrs.exoVille.model.entities;

public class Ville {
    public String nom;
    public int nbHabitants;

    public Ville() {
        super();
    }

    public Ville(String nom) {
        super();
        this.nom = nom;
    }

    public Ville(String nom, int nbHabitants) {
        super();
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public void afficherCaracteristiques() {
        System.out.println("Ville de " + nom);
        System.out.println("Nombre d'habitants dans " + nom + " : " + nbHabitants);
    }
}