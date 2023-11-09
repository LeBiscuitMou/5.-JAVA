package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;

public class Fregate extends Bateau {
    private Helico helico;


    protected Fregate(String nom, int nbEquipage, float tonnage, String moyenPropulsion, Armement[] armements) throws BateauException {
        super(nom, nbEquipage, estPret, tonnage, moyenPropulsion, armements);
    }

    @Override
    public void setTonnage(float tonnage) {

    }

    @Override
    public void setMoyenPropulsion(String moyenPropulsion) {

    }
}
