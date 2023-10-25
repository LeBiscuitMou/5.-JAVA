package net.ent.etrs;

import net.ent.etrs.model.entities.Personne;

public class Test {
    public static void main(String[] args) {
        Personne quidam;
        quidam = new Personne("Dupuis");
        quidam.setSociete("Michelin");

        quidam.presenteToi();
    }
}