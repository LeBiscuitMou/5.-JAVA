package net.ent.etrs.pjjeudesociete.models.facade.impl;

import net.ent.etrs.pjjeudesociete.models.dao.IDaoAuteur;
import net.ent.etrs.pjjeudesociete.models.dao.IDaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.dao.IDaoMaisonEdition;
import net.ent.etrs.pjjeudesociete.models.dao.exceptions.DaoException;
import net.ent.etrs.pjjeudesociete.models.dao.impl.DaoFactory;
import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.models.facade.exceptions.BusinessException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;

import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {
    IDaoAuteur daoAuteur = DaoFactory.fabriquerAuteurDao();
    IDaoMaisonEdition daoMaisonEdition = DaoFactory.fabriquerMaisonEditionDao();
    IDaoJeuSociete daoJeuSociete = DaoFactory.fabriquerJeuSocieteDao();

    protected FacadeMetierImpl() {
    }

    /**
     * Permet d'initialiser les jeux de societe
     *
     * @param listJeuInit la liste des String d'intialisation
     */
    @Override
    public void initialisation(List<String> listJeuInit) throws BusinessException {
        List<String[]> listJeuSociete = new ArrayList<>();
        for (String text : listJeuInit) {
            listJeuSociete.add(text.split(";"));
        }
    }

    /**
     * Permet de sauvegarder un jeu de société
     *
     * @param jeuSociete le jeu a sauvegarder
     * @return le jeu de société sauvegarder
     * @throws BusinessException s'il y a eu un problème de sauvegarde
     */
    @Override
    public JeuSociete sauvegarderJeuSociete(JeuSociete jeuSociete) throws BusinessException {
        try {
            if (Objects.isNull(jeuSociete)) {
                throw new BusinessException(ConstanteMetier.FACADE_JDS_NULL);
            }
            return daoJeuSociete.save(jeuSociete);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_JDS_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de sauvegarder un Auteur
     *
     * @param auteur Auteur a sauvegarder
     * @return l'auteur sauvegardé
     */
    @Override
    public Auteur creerAuteur(Auteur auteur) throws BusinessException {
        try {
            if (Objects.isNull(auteur)) {
                throw new BusinessException(ConstanteMetier.FACADE_AUTEUR_NULL);
            }
            return daoAuteur.save(auteur);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_AUTEUR_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de sauvegarde une maison d'édition
     *
     * @param maisonEdition maison d'édition à sauvegarder
     * @return maison d'édition sauvegardée
     */
    @Override
    public MaisonEdition creerMaisonEdition(MaisonEdition maisonEdition) throws BusinessException {
        try {
            if (Objects.isNull(maisonEdition)) {
                throw new BusinessException(ConstanteMetier.FACADE_MAISON_EDITION_NULL);
            }
            return daoMaisonEdition.save(maisonEdition);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_MAISON_EDITION_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de récupérer les maison d'édition avec leur jeu de société
     *
     * @return une map qui possède lesmaison d'édition et une liste de leur jeux de société
     */
    @Override
    public Map<MaisonEdition, List<JeuSociete>> getLesMaisonEditionAvecJeuSociete() throws BusinessException {
        try {
            Map<MaisonEdition, List<JeuSociete>> map = new HashMap<>();
            for (MaisonEdition maisonEdition : daoMaisonEdition.findAll()) {
                map.put(maisonEdition, new ArrayList<>());
            }
            return map;
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_GET_ME_JDS, e);
        }
    }

    /**
     * Permet de récupérer une list de jeu qui possède le mécanisme
     *
     * @param mecanisme mécanisme selectionné
     * @return la liste des jeux qui possède le mécanisme
     */
    @Override
    public List<JeuSociete> getLesJeuSocieteParMecanisme(Mecanisme mecanisme) throws BusinessException {
        if (Objects.isNull(mecanisme)) {
            throw new BusinessException(ConstanteMetier.FACADE_MECANISME_NULL);
        }
        return Collections.unmodifiableList(daoJeuSociete.getLesJeuSocieteParMecanisme(mecanisme));
    }

    /**
     * Permet de récupérer tous les auteurs
     *
     * @return les auteurs sauvegardés
     */
    @Override
    public List<Auteur> getlesAuteurs() throws BusinessException {
        List<Auteur> auteurList = new ArrayList<>();
        try {
            daoAuteur.findAll().iterator().forEachRemaining(auteurList::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_AUTEUR_ERROR_FIND_ALL, e);
        }
        return Collections.unmodifiableList(auteurList);
    }

    /**
     * Permet de récupérer toutes les maison d'édition
     *
     * @return les maisons d'édition
     */
    @Override
    public List<MaisonEdition> getLesMaisonEdition() throws BusinessException {
        List<MaisonEdition> maisonEditions = new ArrayList<>();
        try {
            daoMaisonEdition.findAll().iterator().forEachRemaining(maisonEditions::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_MAISON_EDITION_ERROR_FIND_ALL, e);
        }
        return Collections.unmodifiableList(maisonEditions);
    }

    /**
     * Permet de récupérer tous les jeux de société
     *
     * @return les jeux de société
     */
    @Override
    public List<JeuSociete> getlesJeuSociete() throws BusinessException {
        List<JeuSociete> jeuSocieteList = new ArrayList<>();
        try {
            daoJeuSociete.findAll().iterator().forEachRemaining(jeuSocieteList::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADE_JDS_ERROR_FIND_ALL, e);
        }
        return Collections.unmodifiableList(jeuSocieteList);
    }
}