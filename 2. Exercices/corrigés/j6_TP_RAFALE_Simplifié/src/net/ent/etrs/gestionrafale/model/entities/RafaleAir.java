package net.ent.etrs.gestionrafale.model.entities;

import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierBombeException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierMissileException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierNombrePiloteException;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.model.references.ConstantesMetier;

public class RafaleAir extends Rafale {

    /**
     * Permet de savoir si le RAFALE possède un missile nucléaire
     */
    private boolean possedeBombeNucleaire;

    protected RafaleAir(String identificationRafale, int nombrePilote, int carburantInterne) throws RafaleMetierException {
        super(identificationRafale, nombrePilote, carburantInterne);
    }

    public boolean isPossedeBombeNucleaire() {
        return possedeBombeNucleaire;
    }

    protected void setPossedeBombeNucleaire(boolean possedeBombeNucleaire) {
        this.possedeBombeNucleaire = possedeBombeNucleaire;
    }

    @Override
    public void ajouterMissileAA(MissileAA missileAjoute) throws RafaleMetierMissileException {
        if (possedeBombeNucleaire) {
            throw new RafaleMetierMissileException(ConstantesMetier.RAFALE_METIER_MISSILE_NUC);
        } else {
            super.ajouterMissileAA(missileAjoute);
        }
    }

    @Override
    public void ajouterBombe(Bombe bombeAjoutee) throws RafaleMetierBombeException {
        if (possedeBombeNucleaire) {
            throw new RafaleMetierBombeException(ConstantesMetier.RAFALE_METIER_MISSILE_NUC);
        } else {
            super.ajouterBombe(bombeAjoutee);
        }
    }

    @Override
    protected boolean verifierNbPilote(int nombrePilote) throws RafaleMetierNombrePiloteException {
        if (nombrePilote < ConstantesMetier.NOMBRE_PILOTE_MINI && nombrePilote > ConstantesMetier.NOMBRE_PILOTE_MAX) {
            throw new RafaleMetierNombrePiloteException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
        }
        return true;
    }

    @Override
    public String toString() {
        return "RafaleAir{" +
                "possedeBombeNucleaire=" + possedeBombeNucleaire +
                "} " + super.toString();
    }
}
