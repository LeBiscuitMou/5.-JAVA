package net.ent.etrs.rafale.model.facade.impl;

import net.ent.etrs.rafale.model.Rafale;
import net.ent.etrs.rafale.model.RafaleAir;
import net.ent.etrs.rafale.model.exceptions.RafaleException;
import net.ent.etrs.rafale.model.facade.FacadeMetier;
import net.ent.etrs.rafale.model.facade.exceptions.FacadeFactoryException;
import net.ent.etrs.rafale.model.facade.exceptions.FacadeMetierException;
import net.ent.etrs.rafale.model.references.Bombe;
import net.ent.etrs.rafale.model.references.ConstantesMetier;
import net.ent.etrs.rafale.model.references.MissileAA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    List<Rafale> lesRafales = new ArrayList<>();
    List<MissileAA> lesMissilesAA = new ArrayList<>(ConstantesMetier.CAPACITE_MAX_MISSILE_AA);
    List<Bombe> lesBombes = new ArrayList<>(ConstantesMetier.CAPACITE_MAX_BOMBES);

    protected FacadeMetierImpl() {
    }

    @Override
    public void ajouterBombeRafale(String idRafale, Bombe bombe) {

    }

    @Override
    public List<Rafale> selectionnerTousLesRafales() {
        return Collections.unmodifiableList(lesRafales);
    }

    @Override
    public void modifierRafale(Rafale rafale) {
        supprimerRafale(rafale.getIdentificationRafale());
        creerRafale(rafale.getIdentificationRafale(), rafale.getCarburantInterne(), rafale.getNombrePilote(), true, true);
    }

    @Override
    public void ajouterMissileAARafale(String idRafale, MissileAA leMissileAA) {

    }

    @Override
    public Rafale selectionnerRafale(String idRafale) {
        return null;
    }

    @Override
    public void creerRafale(String idRafale, int leCarburantInterne, int leNombrePilote, boolean possedeUneBombeNucleaire, boolean verifierLeNombrePilote) {

    }

    @Override
    public void supprimerRafale(String idRafale) {

    }
}