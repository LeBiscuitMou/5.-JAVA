package net.ent.etrs.exo2;
public class Ville {
    String nom;
    int nbHabitants;

    public void afficherInfo() {
        System.out.println("Ville : " + nom);
        System.out.println("Nombre d'habitants : " + nbHabitants);
    }
}