package net.ent.etrs.rafale.model.facade;

import net.ent.etrs.rafale.model.Rafale;
import net.ent.etrs.rafale.model.facade.exceptions.FacadeFactoryException;
import net.ent.etrs.rafale.model.facade.exceptions.FacadeMetierException;
import net.ent.etrs.rafale.model.references.Bombe;
import net.ent.etrs.rafale.model.references.MissileAA;

import java.util.List;

public interface FacadeMetier {
    void ajouterBombeRafale(String idRafale, Bombe bombe);
    List<Rafale> selectionnerTousLesRafales();
    void modifierRafale(Rafale rafale) throws FacadeMetierException;
    void ajouterMissileAARafale(String idRafale, MissileAA leMissileAA);
    Rafale selectionnerRafale(String idRafale);
    void creerRafale(String idRafale, int leCarburantInterne, int leNombrePilote, boolean possedeUneBombeNucleaire, boolean verifierLeNombrePilote) throws FacadeFactoryException;
    void supprimerRafale(String idRafale);
}