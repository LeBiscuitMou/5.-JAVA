package net.ent.etrs.exoVille;

import net.ent.etrs.exoVille.model.entities.Ville;

public class ProgMain {
    public static void main(String[] args) {
        Ville cesson = new Ville();
        Ville rennes = new Ville("Rennes");
        Ville lupstein = new Ville("Lupstein", 575);

        cesson.setNom("Cesson-Sevigne");
        cesson.setNbHabitants(25_000);

        rennes.setNbHabitants(275_000);

        cesson.afficherCaracteristiques();
        rennes.afficherCaracteristiques();
        lupstein.afficherCaracteristiques();
    }
}