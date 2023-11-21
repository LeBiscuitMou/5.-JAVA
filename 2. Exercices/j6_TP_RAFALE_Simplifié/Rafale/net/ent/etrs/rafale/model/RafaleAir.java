package net.ent.etrs.rafale.model;

import net.ent.etrs.rafale.model.exceptions.RafaleAirException;
import net.ent.etrs.rafale.model.exceptions.RafaleException;
import net.ent.etrs.rafale.model.references.Bombe;
import net.ent.etrs.rafale.model.references.ConstantesMetier;
import net.ent.etrs.rafale.model.references.MissileAA;

import java.util.List;
import java.util.Objects;

public class RafaleAir extends Rafale {
    private boolean possedeBombeNucleaire;
    public RafaleAir(String identificationRafale, int carburantInterne, int nombrePilote, boolean possedeUneBombeNucleaire) throws RafaleException {
        super(identificationRafale, carburantInterne, nombrePilote);
        this.setPossedeBombeNucleaire(possedeUneBombeNucleaire);
    }

    public boolean isPossedeBombeNucleaire() {
        return possedeBombeNucleaire;
    }

    public void setPossedeBombeNucleaire(boolean possedeBombeNucleaire) {
        this.possedeBombeNucleaire = possedeBombeNucleaire;
    }

    @Override
    public void ajouterMissileAA(MissileAA missileAA) throws RafaleAirException {
        if (Objects.isNull(missileAA)) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
    }

    @Override
    public void ajouterBombe(Bombe bombe) throws RafaleAirException {
        if (Objects.isNull(bombe)) {
            throw new RafaleAirException(ConstantesMetier.RAFALE_METIER_BOMBE_NULL);
        }
        if ()
    }

    @Override
    protected boolean verifierNbPilote(int nbPilote) throws RafaleException {
        if (nbPilote < 0) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE_NEGATIF);
        }
        if (nbPilote < ConstantesMetier.NOMBRE_PILOTE_MINI || nbPilote > ConstantesMetier.NOMBRE_PILOTE_MAX) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
        }

        return true;
    }
}