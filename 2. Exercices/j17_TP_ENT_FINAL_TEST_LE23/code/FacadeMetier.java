package net.ent.etrs.pjjeudesociete.models.facade;

import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.facade.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface FacadeMetier {


    /**
     * Permet d'initialiser les jeux de societe
     *
     * @param listJeuInit la liste des String d'intialisation
     */
    void initialisation(List<String> listJeuInit) throws BusinessException;

    /**
     * Permet de sauvegarder un jeu de société
     *
     * @param jeuSociete le jeu a sauvegarder
     * @return le jeu de société sauvegarder
     * @throws BusinessException s'il y a eu un problème de sauvegarde
     */
    JeuSociete sauvegarderJeuSociete(JeuSociete jeuSociete) throws BusinessException;

    /**
     * Permet de sauvegarder un Auteur
     *
     * @param auteur Auteur a sauvegarder
     * @return l'auteur sauvegardé
     */
    Auteur creerAuteur(Auteur auteur) throws BusinessException;

    /**
     * Permet de sauvegarde une maison d'édition
     *
     * @param maisonEdition maison d'édition à sauvegarder
     * @return maison d'édition sauvegardée
     */
    MaisonEdition creerMaisonEdition(MaisonEdition maisonEdition) throws BusinessException;

    /**
     * Permet de récupérer les maison d'édition avec leur jeu de société
     *
     * @return une map qui possède lesmaison d'édition et une liste de leur jeux de société
     */
    Map<MaisonEdition, List<JeuSociete>> getLesMaisonEditionAvecJeuSociete() throws BusinessException;

    /**
     * Permet de récupérer une list de jeu qui possède le mécanisme
     *
     * @param mecanisme mécanisme selectionné
     * @return la liste des jeux qui possède le mécanisme
     */
    List<JeuSociete> getLesJeuSocieteParMecanisme(Mecanisme mecanisme);

    /**
     * Permet de récupérer tous les auteurs
     *
     * @return les auteurs sauvegardés
     */
    List<Auteur> getlesAuteurs() throws BusinessException;

    /**
     * Permet de récupérer toutes les maison d'édition
     *
     * @return les maisons d'édition
     */
    List<MaisonEdition> getLesMaisonEdition() throws BusinessException;

    /**
     * Permet de récupérer tous les jeux de société
     *
     * @return les jeux de société
     */
    List<JeuSociete> getlesJeuSociete() throws BusinessException;


}
