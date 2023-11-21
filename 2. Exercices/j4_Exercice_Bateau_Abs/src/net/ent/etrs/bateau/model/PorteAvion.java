package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;

public class PorteAvion extends Bateau {
    private Avion avion;

    public PorteAvion(String nom, int nbEquipage, boolean estPret, float tonnage, String moyenPropulsion, Armement[] armements) throws BateauException {
        super(nom, nbEquipage, estPret, tonnage, moyenPropulsion, armements);
    }


    @Override
    public void setTonnage(float tonnage) {

    }

    @Override
    public void setMoyenPropulsion(String moyenPropulsion) {

    }
}