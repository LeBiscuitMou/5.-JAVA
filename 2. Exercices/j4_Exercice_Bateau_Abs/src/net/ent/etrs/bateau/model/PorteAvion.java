package net.ent.etrs.bateau.model;

public class PorteAvion extends Bateau {
    private Avion avion;

    public PorteAvion(String nom, MoyenPropulsion moyenPropulsion, Armement[] armements) {
        super(nom, moyenPropulsion, armements);
    }
}