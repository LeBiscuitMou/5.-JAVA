package net.ent.etrs.gestionrafale.model.facades.impl;

import net.ent.etrs.gestionrafale.model.entities.EntitiesFactory;
import net.ent.etrs.gestionrafale.model.entities.Rafale;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierBombeException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierMissileException;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.model.facades.FacadeMetierRafale;
import net.ent.etrs.gestionrafale.model.facades.exception.RafaleFacadeException;
import net.ent.etrs.gestionrafale.model.references.ConstantesMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierRafaleImpl implements FacadeMetierRafale {

    List<Rafale> persistanceMetier = new ArrayList<>();

    protected FacadeMetierRafaleImpl() {
    }

    /**
     * Methode pour créer un Rafale
     *
     * @param identificationRafale identifiant du RAFALE
     * @param nombrePilote         le nombre de pilote dans le Rafale
     * @param carburantInterne     le poids en kg du carburant embarqué
     * @param possedeArmeNucleaire savoir s'il possède une arme nucléaire
     * @return
     */
    @Override
    public Rafale creerRafale(String identificationRafale, int nombrePilote, int carburantInterne, boolean possedeArmeNucleaire) throws RafaleFacadeException {

        Rafale rafale = null;
        try {
            rafale = (EntitiesFactory.fabriquerRafale(identificationRafale, nombrePilote, carburantInterne, possedeArmeNucleaire));
        } catch (RafaleMetierException e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(rafale)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_RAFALE_NULL);
        }
        if (persistanceMetier.contains(rafale)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_RAFALE_EXIST);
        }
        persistanceMetier.add(rafale);
        return rafale;
    }

    /**
     * Permet de selectionner un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @return le Rafale identifier
     */
    @Override
    public Rafale selectionnerRafale(String identificationRafale) throws RafaleFacadeException {
        if (Objects.isNull(identificationRafale)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_IDENTIFICATION_NULL);
        }
        for (Rafale rafale : persistanceMetier) {
            if (identificationRafale.equals(rafale.getIdentificationRafale())) {
                return rafale;
            }
        }
        throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_RAFALE_NOT_EXIST);
    }

    /**
     * Permet de ramener tous les Rafales de la base
     *
     * @return la liste des Rafale en base
     */
    @Override
    public List<Rafale> selectionnerTousLesRafales() {

        return Collections.unmodifiableList(persistanceMetier);
    }

    /**
     * Permet de modifier un Rafale
     *
     * @param rafaleModifier le Rafale modifié
     * @return le Rafale modifié
     */
    @Override
    public Rafale modifierRafale(Rafale rafaleModifier) throws RafaleFacadeException {
        if (Objects.isNull(rafaleModifier)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_RAFALE_NULL);
        }
        if (!persistanceMetier.contains(rafaleModifier)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_RAFALE_NOT_EXIST);
        }

        Rafale r = persistanceMetier.set(persistanceMetier.indexOf(rafaleModifier), rafaleModifier);

        return r;
    }

    /**
     * Permet d'ajouter un missile Anti Aérien à un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @param missileAjoute        le missile AA à ajouter
     */
    @Override
    public void ajouterMissileAARafale(String identificationRafale, MissileAA missileAjoute) throws RafaleFacadeException {
        Rafale rafale = null;
        try {
            rafale = selectionnerRafale(identificationRafale);
            rafale.ajouterMissileAA(missileAjoute);
            modifierRafale(rafale);
        } catch (RafaleMetierMissileException e) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_FACADE_RAFALE_NULL, e);
        }

    }

    /**
     * Permet d'ajouter une bombe à un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @param bombeAjoutee         la bombe à ajouter
     */
    @Override
    public void ajouterBombeRafale(String identificationRafale, Bombe bombeAjoutee) throws RafaleFacadeException {
        Rafale rafale = null;
        try {
            rafale = selectionnerRafale(identificationRafale);
            rafale.ajouterBombe(bombeAjoutee);
            modifierRafale(rafale);
        } catch (RafaleMetierBombeException e) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_FACADE_RAFALE_NULL, e);
        }
    }

    /**
     * Permet de supprimer un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     */
    @Override
    public void supprimerRafale(String identificationRafale) throws RafaleFacadeException {
        if (Objects.isNull(identificationRafale)) {
            throw new RafaleFacadeException(ConstantesMetier.RAFALE_DAO_IDENTIFICATION_NULL);
        }
        List<Rafale> listRafale = new ArrayList<>(persistanceMetier);

        for (Rafale r : listRafale) {
            if (r.getIdentificationRafale().equals(identificationRafale)) {
                persistanceMetier.remove(r);
            }
        }
    }
}
