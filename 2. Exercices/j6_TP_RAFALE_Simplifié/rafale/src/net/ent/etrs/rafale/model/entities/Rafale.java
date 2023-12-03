package net.ent.etrs.rafale.model.entities;

import net.ent.etrs.rafale.model.entities.exceptions.RafaleAirException;
import net.ent.etrs.rafale.model.entities.exceptions.RafaleException;
import net.ent.etrs.rafale.model.entities.references.Bombe;
import net.ent.etrs.rafale.model.entities.references.MissileAA;
import net.ent.etrs.rafale.model.references.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Rafale {
    private String identificationRafale;
    private int carburantInterne;
    private List<MissileAA> lesMissilesEmportes = new ArrayList<>();
    private List<Bombe> lesBombesEmportees = new ArrayList<>();
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
        if (null == identificationRafale) {
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
        if (carburantInterne > ConstantesMetier.CARBURANT_POIDS_MAXIMUM) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_CARBURANT_MAX_INTERNE);
        }
        this.carburantInterne = carburantInterne;
    }

    public List<MissileAA> getLesMissilesEmportes() {
        return Collections.unmodifiableList(this.lesMissilesEmportes);
    }

    public List<Bombe> getLesBombesEmportees() {
        return Collections.unmodifiableList(this.lesBombesEmportees);
    }

    public int getNombrePilote() {
        return nombrePilote;
    }

    public void setNombrePilote(int nombrePilote) throws RafaleException {
        if (!verifierNbPilote(nombrePilote)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
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

    @Override
    public String toString() {
        return "Rafale{" +
                "identificationRafale='" + identificationRafale + '\'' +
                ", carburantInterne=" + carburantInterne +
                ", nombrePilote=" + nombrePilote +
                '}';
    }

    private boolean bombePeutEtreEmporte(Bombe bombe) throws RafaleException {
        if ((lesBombesEmportees.size() < ConstantesMetier.NOMBRE_MAXIMUM_DE_BOMBES)
        &&  (calculPoidsEmport() + bombe.getPoids() < ConstantesMetier.POIDS_MAXIMUM_RAFALE)) {
            return true;
        }
        return false;
    }

    public void ajouterMissileAA(MissileAA missileAA) throws RafaleException, RafaleAirException {
        if (Objects.isNull(missileAA)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
        if (!missilePeutEtreEmporte(missileAA)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_MISSILE_LOURD);
        }
        this.lesMissilesEmportes.add(missileAA);
    }

    private boolean missilePeutEtreEmporte(MissileAA missileAA) {
        if ((lesMissilesEmportes.size() < ConstantesMetier.NOMBRE_MAXIMUM_DE_MISSILES_AA)
        &&  (calculPoidsEmport() + missileAA.getPoids() < ConstantesMetier.POIDS_MAXIMUM_RAFALE)) {
            return true;
        }
        return false;
    }

    protected boolean verifierNbPilote(int nbPilote) throws RafaleException, RafaleAirException {
        if (nbPilote != ConstantesMetier.NOMBRE_PILOTE_MINI) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
        }
        return true;
    }

    public void ajouterBombe(Bombe bombe) throws RafaleException, RafaleAirException {
        if (Objects.isNull(bombe)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_BOMBE_NULL);
        }
        if (!bombePeutEtreEmporte(bombe)) {
            throw new RafaleException(ConstantesMetier.RAFALE_METIER_BOMBE_LOURD);
        }
        this.lesBombesEmportees.add(bombe);
    }

    private int calculPoidsEmport() {
        int totalPoids = 0;

        for (Bombe b : lesBombesEmportees) {
            totalPoids += b.getPoids();
        }

        for (MissileAA mAA : lesMissilesEmportes) {
            totalPoids += mAA.getPoids();
        }

        return totalPoids;
    }
}
