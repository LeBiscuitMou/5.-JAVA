package net.ent.etrs.rafale.model.entities;

import net.ent.etrs.rafale.model.entities.exceptions.RafaleAirException;
import net.ent.etrs.rafale.model.entities.exceptions.RafaleException;
import net.ent.etrs.rafale.model.entities.references.Bombe;
import net.ent.etrs.rafale.model.entities.references.MissileAA;
import net.ent.etrs.rafale.model.references.ConstantesMetier;

public class RafaleAir extends Rafale {
    private boolean possedeBombeNucleaire;

    protected RafaleAir(String identificationRafale, int carburantInterne, int nombrePilote) throws RafaleException {
        super(identificationRafale, carburantInterne, nombrePilote);
    }

    public boolean isPossedeBombeNucleaire() {
        return possedeBombeNucleaire;
    }

    public void setPossedeBombeNucleaire(boolean possedeBombeNucleaire) {
        this.possedeBombeNucleaire = possedeBombeNucleaire;
    }

    @Override
    public String toString() {
        return "RafaleAir{" +
                "possedeBombeNucleaire=" + possedeBombeNucleaire +
                '}';
    }

    public void ajouterMissileAA(MissileAA missileAA) throws RafaleAirException, RafaleException {
        if (null == missileAA) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
        if (possedeBombeNucleaire) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_MISSILE_NUC);
        }
        super.ajouterMissileAA(missileAA);
    }

    public void ajouterBombe(Bombe bombe) throws RafaleException, RafaleAirException {
        if (null == bombe) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
        if (possedeBombeNucleaire) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_MISSILE_NUC);
        }
        super.ajouterBombe(bombe);
    }

    protected boolean verifierNbPilote(int nbPilote) throws RafaleAirException {
        if ((nbPilote > ConstantesMetier.NOMBRE_PILOTE_MAX)
        && (nbPilote < ConstantesMetier.NOMBRE_PILOTE_MINI)) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
        }
        return true;
    }
}