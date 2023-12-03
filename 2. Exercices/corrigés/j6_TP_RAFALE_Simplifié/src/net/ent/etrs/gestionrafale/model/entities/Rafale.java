package net.ent.etrs.gestionrafale.model.entities;

import net.ent.etrs.gestionrafale.model.entities.exceptions.*;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.model.references.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Rafale {

    /**
     * Poids total Max d'un RAFALE en kg
     */
    private final int POIDS_MAX_RAFALE = 24500;
    /**
     * Poids à vide d'un RAFALE en kg
     */
    private final int POIDS_RAFALE_A_VIDE = 10000;
    /**
     * Poids maximum du carburant interne
     */
    private final int POIDS_CARBURANT_INTERNE = 4500;
    /**
     * Capacité d'emport maximum pour l'armement du RAFALE
     */
    private final int CAPACITE_EMPORT_MAX_ARMEMENT = 9500;
    /**
     * Nombre Maximum de Bombe équipées
     */
    private final short NOMBRE_MAXIMUM_BOMBE_EQUIPEES = 5;
    /**
     * Nombre Maximum de Missile Anti Aérien équipés
     */
    private final short NOMBRE_MAXIMUM_MISSILE_AA_EQUIPES = 9;

    // Constantes
    /**
     * Identifiant Unique du RAFALE
     */
    private String identificationRafale;

    // Attributs
    /**
     * Nombre de pilote dans le RAFALE
     */
    private int nombrePilote;
    /**
     * Poids total de carburant emporté
     */
    private int carburantInterne;
    /**
     * Liste des bombes emportées par le RAFALE
     */
    private List<Bombe> lesBombesEmportees = new ArrayList<>();
    /**
     * Liste des Missile Anti Aérien emportées par le RAFALE
     */
    private List<MissileAA> lesMissilesEmportes = new ArrayList<>();

    public Rafale(String identificationRafale, int nombrePilote, int carburantInterne) throws RafaleMetierException {
        try {
            this.setIdentificationRafale(identificationRafale);
            this.setNombrePilote(nombrePilote);
            this.setCarburantInterne(carburantInterne);
        } catch (RafaleMetierIdentificationException | RafaleMetierNombrePiloteException |
                 RafaleMetierCaburantException e) {
            throw new RafaleMetierException(ConstantesMetier.RAFALE_METIER_NOT_CREATE);
        }

    }

    //Getters / Setters

    public String getIdentificationRafale() {
        return identificationRafale;
    }

    private void setIdentificationRafale(String identificationRafale) throws RafaleMetierIdentificationException {
        if (Objects.isNull(identificationRafale)) {
            throw new RafaleMetierIdentificationException(ConstantesMetier.RAFALE_METIER_IDENTIFICATION_EXCEPTION);
        }
        this.identificationRafale = identificationRafale;
    }

    public int getNombrePilote() {
        return nombrePilote;
    }

    protected void setNombrePilote(int nombrePilote) throws RafaleMetierNombrePiloteException {
        if (verifierNbPilote(nombrePilote)) {
            this.nombrePilote = nombrePilote;
        }

    }

    public int getCarburantInterne() {
        return carburantInterne;
    }

    private void setCarburantInterne(int carburantInterne) throws RafaleMetierCaburantException {
        if (carburantInterne < 0) {
            throw new RafaleMetierCaburantException(ConstantesMetier.RAFALE_METIER_CARBURANT_MINI);
        }
        if (carburantInterne > POIDS_CARBURANT_INTERNE) {
            throw new RafaleMetierCaburantException(ConstantesMetier.RAFALE_METIER_CARBURANT_MAX_INTERNE);
        }
        this.carburantInterne = carburantInterne;
    }

    public List<Bombe> getLesBombesEmportees() {
        return Collections.unmodifiableList(lesBombesEmportees);
    }

    public void ajouterBombe(Bombe bombeAjoutee) throws RafaleMetierBombeException {
        if (Objects.isNull(bombeAjoutee)) {
            throw new RafaleMetierBombeException(ConstantesMetier.RAFALE_METIER_BOMBE_NULL);
        }
        if (!bombePeutEtreEmporte(bombeAjoutee)) {
            throw new RafaleMetierBombeException(ConstantesMetier.RAFALE_METIER_BOMBE_LOURD);
        }
        this.lesBombesEmportees.add(bombeAjoutee);
    }

    public List<MissileAA> getLesMissilesEmportes() {
        return Collections.unmodifiableList(lesMissilesEmportes);
    }

    public void ajouterMissileAA(MissileAA missileAjoute) throws RafaleMetierMissileException {
        if (Objects.isNull(missileAjoute)) {
            throw new RafaleMetierMissileException(ConstantesMetier.RAFALE_METIER_MISSILE_NULL);
        }
        if (!missilePeutEtreEmporte(missileAjoute)) {
            throw new RafaleMetierMissileException(ConstantesMetier.RAFALE_METIER_MISSILE_LOURD);
        }
        this.lesMissilesEmportes.add(missileAjoute);
    }

    /**
     * Methode pour vérifier si le Rafale peut emporté le missile
     *
     * @param missileAjoute missile supplémentaire à emporter
     * @return si le missile peut être ajouté
     */
    private boolean missilePeutEtreEmporte(MissileAA missileAjoute) {
        if ((lesMissilesEmportes.size() < NOMBRE_MAXIMUM_MISSILE_AA_EQUIPES) &&
                (calculPoidsEmport() + missileAjoute.getPoids() < CAPACITE_EMPORT_MAX_ARMEMENT)) {
            return true;
        }
        return false;
    }

    /**
     * Methode pour vérifier si le Rafale peut emporté une bombe
     *
     * @param bombeAjoutee bombe supplémentaire à emporter
     * @return si la bombe peut être ajouté
     */
    private boolean bombePeutEtreEmporte(Bombe bombeAjoutee) {
        if ((lesBombesEmportees.size() < NOMBRE_MAXIMUM_BOMBE_EQUIPEES) &&
                (calculPoidsEmport() + bombeAjoutee.getPoids() < CAPACITE_EMPORT_MAX_ARMEMENT)) {
            return true;
        }
        return false;
    }

    /**
     * Methode qui permet de calculer le poids de l'emport courant
     *
     * @return le poids calculé
     */
    private int calculPoidsEmport() {
        int retour = 0;

        for (MissileAA mAA : lesMissilesEmportes) {
            retour = retour + mAA.getPoids();
        }
        for (Bombe b : lesBombesEmportees) {
            retour = retour + b.getPoids();
        }

        return retour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rafale)) return false;
        Rafale rafale = (Rafale) o;
        return Objects.equals(identificationRafale, rafale.identificationRafale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationRafale);
    }

    protected boolean verifierNbPilote(int nombrePilote) throws RafaleMetierNombrePiloteException {
        if (nombrePilote != ConstantesMetier.NOMBRE_PILOTE_MINI) {
            throw new RafaleMetierNombrePiloteException(ConstantesMetier.RAFALE_METIER_NOMBRE_PILOTE);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rafale{" +
                ", identificationRafale='" + identificationRafale + '\'' +
                ", nombrePilote=" + nombrePilote +
                ", carburantInterne=" + carburantInterne +
                '}';
    }
}
