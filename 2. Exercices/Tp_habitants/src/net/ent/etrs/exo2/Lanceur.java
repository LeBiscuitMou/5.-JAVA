package net.ent.etrs.exo2;

public class Lanceur {
    public static void main(String[] args) {
        // Création d'une instance de ville
        Ville uneVille = new Ville();

        uneVille.nom = "Lupstein";
        uneVille.nbHabitants = 795;

        uneVille.afficherInfo();
    }
}