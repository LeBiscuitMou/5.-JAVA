package net.ent.etrs.model.entities;

public class Personne {
    private String nom;
    private String societe;

    public Personne(String nom) {
        super();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }
    public void presenteToi() {
        System.out.println("Je m'appelle " + nom);
        System.out.println("Je travaille à " + societe);
    }
}