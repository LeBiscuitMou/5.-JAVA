package net.ent.etrs.gestionrafale.model.facades;

import net.ent.etrs.gestionrafale.model.entities.Rafale;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierBombeException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierMissileException;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.model.facades.exception.RafaleFacadeException;

import java.util.List;

public interface FacadeMetierRafale {

    /**
     * Methode pour créer un Rafale
     *
     * @param identificationRafale identifiant du RAFALE
     * @param nombrePilote         le nombre de pilote dans le Rafale
     * @param carburantInterne     le poids en kg du carburant embarqué
     * @param possedeArmeNucleaire savoir s'il possède une arme nucléaire
     * @return
     */
    public Rafale creerRafale(String identificationRafale, int nombrePilote, int carburantInterne, boolean possedeArmeNucleaire) throws RafaleMetierException, RafaleFacadeException;

    /**
     * Permet de selectionner un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @return le Rafale identifier
     */
    public Rafale selectionnerRafale(String identificationRafale) throws RafaleFacadeException;

    /**
     * Permet de ramener tous les Rafales de la base
     *
     * @return la liste des Rafale en base
     */
    public List<Rafale> selectionnerTousLesRafales();

    /**
     * Permet de modifier un Rafale
     *
     * @param rafaleModifier le Rafale modifié
     * @return
     */
    public Rafale modifierRafale(Rafale rafaleModifier) throws RafaleFacadeException;

    /**
     * Permet d'ajouter un missile Anti Aérien à un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @param missileAjoute        le missile AA à ajouter
     */
    public void ajouterMissileAARafale(String identificationRafale, MissileAA missileAjoute) throws RafaleMetierMissileException, RafaleFacadeException;

    /**
     * Permet d'ajouter une bombe à un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     * @param bombeAjoutee         la bombe à ajouter
     */
    public void ajouterBombeRafale(String identificationRafale, Bombe bombeAjoutee) throws RafaleMetierBombeException, RafaleFacadeException;

    /**
     * Permet de supprimer un Rafale
     *
     * @param identificationRafale identifiant du Rafale
     */
    public void supprimerRafale(String identificationRafale) throws RafaleFacadeException;

}
