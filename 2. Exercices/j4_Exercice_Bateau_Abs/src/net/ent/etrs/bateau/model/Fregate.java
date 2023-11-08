package net.ent.etrs.bateau.model;

public class Fregate extends Bateau {
    private Helico helico;

    public Fregate(String nom, MoyenPropulsion moyenPropulsion, Armement[] armements) {
        super(nom, moyenPropulsion, armements);
    }
}
