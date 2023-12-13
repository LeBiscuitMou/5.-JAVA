package net.ent.etrs.gestionLeague.models.facade;

import net.ent.etrs.gestionLeague.models.daos.exceptions.DaoException;
import net.ent.etrs.gestionLeague.models.entities.Challenge;
import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.Personnage;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;
import net.ent.etrs.gestionLeague.models.facade.exception.BusinessException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FacadeMetier {
    /**
     * Permet d'initialiser Permet d'initialiser le logiciel
     *
     * @throws BusinessException s'il y a un soucis lors du chargement de l'init
     */
    void initialisation(List<String> init) throws BusinessException;

    /**
     * Permet de sauvegarder un personnage
     *
     * @param personnage le personnage à sauvegarder
     */
    void savePersonnage(Personnage personnage) throws BusinessException;

    /**
     * Permet de sauvegarder un challenge
     *
     * @param challenge le challenge à sauvegarder
     */
    void saveChallenge(Challenge challenge) throws BusinessException;

    /**
     * Permet de sauvegarder une League
     *
     * @param league la league à sauvegarder
     */
    void saveLeague(League league) throws BusinessException;

    /**
     * Permet de récupérer tous les personnages
     *
     * @return les personnages de la base
     */
    Set<Personnage> findAllPersonnages() throws BusinessException;

    /**
     * Permet de récupérer tous les challenges
     *
     * @return les challenges de la base
     */
    Set<Challenge> findAllChallenges() throws BusinessException;

    /**
     * Permet de récupérer toutes les leagues
     *
     * @return les leagues de la base
     */
    Set<League> findAllLeagues() throws BusinessException;

    /**
     * Permet de récupérer le challenge qui rapport le plus de points
     *
     * @return le challenge qui possède le plus de points
     */
    Challenge findBestChallenge() throws BusinessException;

    /**
     * Permet de récupérer les rewards points par League
     *
     * @return une Map contenant la league et la somme de ses reward points.
     */
    Map<League, Long> findRewardPointsByLeague() throws DaoException, BusinessException;

    /**
     * Permet de récupérer les 3 meilleurs builds de la league
     *
     * @param league league choisie
     * @return un Set des trois meilleurs build
     */
    Set<LabySpecialite> findTopThreeBestBuild(League league);

    /**
     * Permet de connaître les 3 meilleurs builds pour chaque League
     *
     * @return une Map contenant la league ainsi que les 3 meilleurs builds.
     */
    Map<League, Set<LabySpecialite>> findBestBuildByLeague() throws BusinessException;
}