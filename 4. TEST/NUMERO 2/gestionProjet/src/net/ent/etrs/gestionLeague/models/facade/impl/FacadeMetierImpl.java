package net.ent.etrs.gestionLeague.models.facade.impl;

import net.ent.etrs.gestionLeague.models.daos.IDaoChallenge;
import net.ent.etrs.gestionLeague.models.daos.IDaoLeague;
import net.ent.etrs.gestionLeague.models.daos.IDaoPersonnage;
import net.ent.etrs.gestionLeague.models.daos.exceptions.DaoException;
import net.ent.etrs.gestionLeague.models.daos.impl.DaoFactory;
import net.ent.etrs.gestionLeague.models.entities.Challenge;
import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.Personnage;
import net.ent.etrs.gestionLeague.models.entities.exceptions.ChallengeException;
import net.ent.etrs.gestionLeague.models.entities.references.ConstantesMetier;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;
import net.ent.etrs.gestionLeague.models.facade.FacadeMetier;
import net.ent.etrs.gestionLeague.models.facade.exception.BusinessException;

import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {

    private IDaoLeague daoLeague = DaoFactory.fabriquerDaoLeague();
    private IDaoChallenge daoChallenge = DaoFactory.fabriquerDaoChallenge();
    private IDaoPersonnage daoPersonnage = DaoFactory.fabriquerDaoPersonnage();

    /**
     * Permet d'initialiser Permet d'initialiser le logiciel
     *
     * @param init
     * @throws BusinessException s'il y a un soucis lors du chargement de l'init
     */
    @Override
    public void initialisation(List<String> init) throws BusinessException {

    }

    /**
     * Permet de sauvegarder un personnage
     *
     * @param personnage le personnage à sauvegarder
     */
    @Override
    public void savePersonnage(Personnage personnage) throws BusinessException {
        try {
            if (Objects.isNull(personnage)) {
                throw new BusinessException(ConstantesMetier.FACADE_PERSONNAGE_NULL);
            }
            this.daoPersonnage.save(personnage);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_PERSONNAGE_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de sauvegarder un challenge
     *
     * @param challenge le challenge à sauvegarder
     */
    @Override
    public void saveChallenge(Challenge challenge) throws BusinessException {
        try {
            if (Objects.isNull(challenge)) {
                throw new BusinessException(ConstantesMetier.FACADE_CHALLENGE_NULL);
            }
            this.daoChallenge.save(challenge);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_CHALLENGE_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de sauvegarder une League
     *
     * @param league la league à sauvegarder
     */
    @Override
    public void saveLeague(League league) throws BusinessException {
        try {
            if (Objects.isNull(league)) {
                throw new BusinessException(ConstantesMetier.FACADE_LEAGUE_NULL);
            }
            this.daoLeague.save(league);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_LEAGUE_ERROR_SAVE_DAO, e);
        }
    }

    /**
     * Permet de récupérer tous les personnages
     *
     * @return les personnages de la base
     */
    @Override
    public Set<Personnage> findAllPersonnages() throws BusinessException {
        Set<Personnage> personnages = new HashSet<>();
        try {
            daoPersonnage.findAll().iterator().forEachRemaining(personnages::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_PERSONNAGE_ERROR_FIND_ALL_DAO, e);
        }
        return Collections.unmodifiableSet(personnages);
    }

    /**
     * Permet de récupérer tous les challenges
     *
     * @return les challenges de la base
     */
    @Override
    public Set<Challenge> findAllChallenges() throws BusinessException {
        Set<Challenge> challenges = new HashSet<>();
        try {
            daoChallenge.findAll().iterator().forEachRemaining(challenges::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_CHALLENGE_ERROR_FIND_ALL_DAO, e);
        }
        return Collections.unmodifiableSet(challenges);
    }

    /**
     * Permet de récupérer toutes les leagues
     *
     * @return les leagues de la base
     */
    @Override
    public Set<League> findAllLeagues() throws BusinessException {
        Set<League> leagues = new HashSet<>();
        try {
            daoLeague.findAll().iterator().forEachRemaining(leagues::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_LEAGUE_ERROR_FIND_ALL_DAO, e);
        }
        return Collections.unmodifiableSet(leagues);
    }

    /**
     * Permet de récupérer le challenge qui rapport le plus de points
     *
     * @return le challenge qui possède le plus de points
     */
    @Override
    public Challenge findBestChallenge() throws BusinessException {
        try {
            Challenge meilleur = new Challenge("testest", 0, "blablabla");
            for (Challenge c : daoChallenge.findAll()) {
                if (meilleur.getRewardPoints() < c.getRewardPoints()) {
                    meilleur = c;
                }
            }
            return meilleur;
        } catch (DaoException | ChallengeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Permet de récupérer les rewards points par League
     *
     * @return une Map contenant la league et la somme de ses reward points.
     */
    @Override
    public Map<League, Long> findRewardPointsByLeague() throws DaoException, BusinessException {
        return Collections.unmodifiableMap(this.daoLeague.getRewardPointsByLeague());
    }

    /**
     * Permet de récupérer les 3 meilleurs builds de la league
     *
     * @param league league choisie
     * @return un Set des trois meilleurs build
     */
    @Override
    public Set<LabySpecialite> findTopThreeBestBuild(League league) {
        return null;
    }

    /**
     * Permet de connaître les 3 meilleurs builds pour chaque League
     *
     * @return une Map contenant la league ainsi que les 3 meilleurs builds.
     */
    @Override
    public Map<League, Set<LabySpecialite>> findBestBuildByLeague() throws BusinessException {
        return Collections.unmodifiableMap(this.daoLeague.getBestBuildByLeague());
    }
}