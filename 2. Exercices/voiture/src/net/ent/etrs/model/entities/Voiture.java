package net.ent.etrs.model.entities;

public class Voiture {
    String nom;
    int numSerie;

    public Voiture(String nom, int numSerie) {
        this.nom = nom;
        this.numSerie = numSerie;
    }
    public void afficherInfo() {
        System.out.println("La voiture est une " + nom);
        System.out.println("Le numéro de série est " + numSerie);
    }
}