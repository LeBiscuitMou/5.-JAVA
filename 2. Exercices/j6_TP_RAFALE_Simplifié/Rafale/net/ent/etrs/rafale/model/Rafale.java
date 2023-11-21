package net.ent.etrs.rafale.model;

import net.ent.etrs.rafale.model.exceptions.RafaleAirException;
import net.ent.etrs.rafale.model.exceptions.RafaleException;
import net.ent.etrs.rafale.model.references.Bombe;
import net.ent.etrs.rafale.model.references.ConstantesMetier;
import net.ent.etrs.rafale.model.references.MissileAA;

import java.util.*;

public abstract class Rafale {
    private String identificationRafale;
    private int carburantInterne;
    private List<MissileAA> lesMissilesEmportes = new ArrayList<>(ConstantesMetier.CAPACITE_MAX_MISSILE_AA);
    private List<Bombe> lesBombesEmportees = new ArrayList<>(ConstantesMetier.CAPACITE_MAX_BOMBES);
    private int nombrePilote;

    protected Rafale(String identificationRafale, int carburantInterne, int nombrePilote) throws RafaleException {
        this.setIdentificationRafale(identificationRafale);
        this.setCarburantInterne(carburantInterne);
        this.setNombrePilote(nombrePilote);
    }

    public String getIdentificationRafale() {
        return identificationRafale;
    }

    public void setIdentificationRafale(String identificationRafale) throws RafaleException {
        if (Objects.isNull(identificationRafale)) {
            throw new RafaleException(ConstantesMetier.RAFALE_DAO_IDENTIFICATION_NULL);
        }
        this.identificationRafale = identificationRafale;
    }

    public int getCarburantInterne() {
        return carburantInterne;
    }

    public void setCarburantInterne(int carburantInterne) throws RafaleException {
        if (carburantInterne < 0) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_CARBURANT_MINI);
        }
        if (carburantInterne > ConstantesMetier.CAPACITE_MAX_CARBURANT_INTERNE) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_CARBURANT_MAX_INTERNE);
        }
        this.carburantInterne = carburantInterne;
    }

    public List<MissileAA> getLesMissilesEmportes() {
        return Collections.unmodifiableList(this.lesMissilesEmportes);
    }

    public void setLesMissilesEmportes(List<MissileAA> lesMissilesEmportes) throws RafaleException {
        if (Objects.isNull(lesMissilesEmportes)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_LISTE_MISSILES_EMPORTE_NULL);
        }
        this.lesMissilesEmportes = lesMissilesEmportes;
    }

    public List<Bombe> getLesBombesEmportees() {
        return Collections.unmodifiableList(this.lesBombesEmportees);
    }

    public void setLesBombesEmportees(List<Bombe> lesBombesEmportees) throws RafaleException {
        if (Objects.isNull(lesBombesEmportees)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_LISTE_BOMBES_EMPORTE_NULL);
        }
        this.lesBombesEmportees = lesBombesEmportees;
    }

    public int getNombrePilote() {
        return nombrePilote;
    }

    public void setNombrePilote(int nombrePilote) throws RafaleException {
        if (!verifierNbPilote(nombrePilote)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE_NEGATIF);
        }
        this.nombrePilote = nombrePilote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rafale rafale = (Rafale) o;
        return Objects.equals(identificationRafale, rafale.identificationRafale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationRafale);
    }

    public abstract void ajouterMissileAA(MissileAA missileAA) throws RafaleAirException;

    public abstract void ajouterBombe(Bombe bombe) throws RafaleAirException;

    protected abstract boolean verifierNbPilote(int nbPilote) throws RafaleException;

    private boolean bombePeutEtreEmporte(Bombe bombe) throws RafaleException {
        if (Objects.isNull(bombe)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_BOMBE_NULL);
        }
        if (calculPoidsEmport() + bombe.getPoids() > ConstantesMetier.RAFALE_METIER_POIDS_MAX) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_BOMBE_LOURD);
        }
        return true;
    }

    private boolean missilePeutEtreEmporte(MissileAA missileAA) throws RafaleException {
        if (Objects.isNull(missileAA)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
        return false;
    }

    private int calculPoidsEmport() {
        int totalPoids = 0;

        for (Bombe b : lesBombesEmportees) {
            totalPoids += b.getPoids();
        }
        for (MissileAA maa : lesMissilesEmportes) {
            totalPoids += maa.getPoids();
        }

        return totalPoids;
    }
}