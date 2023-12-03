package net.ent.etrs.rafale.model.facades.impl;

import net.ent.etrs.rafale.model.entities.Rafale;
import net.ent.etrs.rafale.model.entities.references.Bombe;
import net.ent.etrs.rafale.model.entities.references.MissileAA;
import net.ent.etrs.rafale.model.facades.FacadeMetierRafale;

import java.util.List;

public class FacadeMetierRafaleImpl implements FacadeMetierRafale {
    @Override
    public void ajouterBombe(String identification, Bombe bombe) {

    }

    @Override
    public List<Rafale> selectionnerTousLesRafales() {
        return null;
    }

    @Override
    public void modifierRafale(Rafale rafale) {

    }

    @Override
    public void ajouterMissileAARafale(String identification, MissileAA missileAA) {

    }

    @Override
    public Rafale selectionnerRafale(String identification) {
        return null;
    }

    @Override
    public void creerRafale(String identification, int carburant, int nbPilote, boolean possedeNucleaire, boolean oui) {

    }

    @Override
    public void supprimerRafale(String identification) {

    }
}