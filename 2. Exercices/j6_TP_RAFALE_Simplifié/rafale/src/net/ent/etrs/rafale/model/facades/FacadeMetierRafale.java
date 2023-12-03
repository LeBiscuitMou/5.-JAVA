package net.ent.etrs.rafale.model.facades;

import net.ent.etrs.rafale.model.entities.Rafale;
import net.ent.etrs.rafale.model.entities.references.Bombe;
import net.ent.etrs.rafale.model.entities.references.MissileAA;

import java.util.List;

public interface FacadeMetierRafale {
    public void ajouterBombe(String identification, Bombe bombe);
    public List<Rafale> selectionnerTousLesRafales();
    public void modifierRafale(Rafale rafale);
    public void ajouterMissileAARafale(String identification, MissileAA missileAA);
    public Rafale selectionnerRafale(String identification);
    public void creerRafale(String identification, int carburant, int nbPilote, boolean possedeNucleaire, boolean oui);
    public void supprimerRafale(String identification);
}
