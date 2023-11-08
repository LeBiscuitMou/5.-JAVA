package net.ent.etrs.bateau.model;

public class Fregate extends Bateau {
    private Helico helico;

    public Fregate(String nom, int nbEquipage, boolean estPret, MoyenPropulsion moyenPropulsion, Armement[] armements) {
        super(nom, nbEquipage, estPret, moyenPropulsion, armements);
    }
}
