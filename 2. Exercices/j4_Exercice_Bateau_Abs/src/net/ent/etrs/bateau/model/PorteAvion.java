package net.ent.etrs.bateau.model;

public class PorteAvion extends Bateau {
    private Avion avion;

    public PorteAvion(String nom, int nbEquipage, boolean estPret, MoyenPropulsion moyenPropulsion, Armement[] armements) {
        super(nom, nbEquipage, estPret, moyenPropulsion, armements);
    }
}