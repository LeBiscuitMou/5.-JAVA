package net.ent.etrs.poeleague.model.facade;

import net.ent.etrs.poeleague.model.commons.Utils;
import net.ent.etrs.poeleague.model.daos.DaoChallenge;
import net.ent.etrs.poeleague.model.daos.DaoFactory;
import net.ent.etrs.poeleague.model.daos.DaoLeague;
import net.ent.etrs.poeleague.model.daos.DaoPersonnage;
import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.Challenge;
import net.ent.etrs.poeleague.model.entities.EntitiesFactory;
import net.ent.etrs.poeleague.model.entities.League;
import net.ent.etrs.poeleague.model.entities.Personnage;
import net.ent.etrs.poeleague.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poeleague.model.entities.exceptions.LeagueException;
import net.ent.etrs.poeleague.model.entities.references.ConstantMetier;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;
import net.ent.etrs.poeleague.model.facade.exception.BusinessException;

import java.time.LocalDate;
import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {
    DaoChallenge daoChallenge;
    DaoLeague daoLeague;
    DaoPersonnage daoPersonnage;

    public FacadeMetierImpl() {
        this.daoChallenge = DaoFactory.getDaoChallenge();
        this.daoLeague = DaoFactory.getDaoLeague();
        this.daoPersonnage = DaoFactory.getDaoPersonnage();
    }

    /**
     * Permet d'initialiser le logiciel
     *
     * @throws BusinessException s'il y a un soucis lors du chargement de l'init
     */
    @Override
    public void initialisation(List<String> init) throws BusinessException {
        League league = null;
        Challenge challenge;
        Personnage personnage;
        try {


            for (String line : init) {
                String[] ligne = line.split(";");

                //La ligne commence par LEAGUE
                if (ligne[0].contains("LEAGUE")) {
                    String nom = ligne[1];
                    LocalDate dd = LocalDate.parse(ligne[2], ConstantMetier.DATE_FORMAT);
                    LocalDate df = null;
                    if (ligne.length > 3) {
                        df = LocalDate.parse(ligne[3], ConstantMetier.DATE_FORMAT);
                    }

                    league = EntitiesFactory.fabriquerLeague(nom, dd, df);
                }
                //La ligne commence par CHALLENGE
                if (ligne[0].contains("CHALLENGE")) {
                    String nom = ligne[1];
                    String desc = ligne[2];
                    Integer reward = Integer.parseInt(ligne[3]);
                    challenge = EntitiesFactory.fabriquerChallenge(nom, desc, reward);
                    challenge = daoChallenge.save(challenge);
                    if (Objects.nonNull(league)) {
                        league.ajouterChallenge(challenge);
                        daoLeague.save(league);
                    }
                }
                //La ligne commence par PERSONNAGE
                if (ligne[0].contains("PERSONNAGE")) {
                    String pseudo = ligne[2];
                    LabySpecialite build = LabySpecialite.valueOf(ligne[3].toUpperCase());
                    Integer level = Integer.parseInt(ligne[4]);
                    Integer classement = Integer.parseInt(ligne[1]);
                    personnage = EntitiesFactory.fabriquerPersonnage(pseudo, build, level);
                    personnage = daoPersonnage.save(personnage);
                    if (Objects.nonNull(league)) {
                        league.ajouterPersonnage(personnage, classement);
                        daoLeague.save(league);
                    }

                }


            }
        } catch (EntitiesFactoryException | LeagueException | DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Permet de sauvegarder un personnage
     *
     * @param personnage le personnage à sauvegarder
     */
    @Override
    public void savePersonnage(Personnage personnage) throws BusinessException {
        try {
            this.daoPersonnage.save(personnage);
        } catch (DaoException e) {
            throw new BusinessException("Impossible de sauvegarder le personnage", e);
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
            this.daoChallenge.save(challenge);
        } catch (DaoException e) {
            throw new BusinessException("Impossible de sauvegarder le challenge", e);
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
            this.daoLeague.save(league);
        } catch (DaoException e) {
            throw new BusinessException("Impossible de sauvegarder la league", e);
        }
    }


    /**
     * Permet de récupérer tous les personnages
     *
     * @return les personnages de la base
     */
    @Override
    public Set<Personnage> findAllPersonnages() throws BusinessException {

        try {
            return new HashSet<>(Utils.iterableToList(this.daoPersonnage.findAll()));
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer les personnages", e);
        }
    }

    /**
     * Permet de récupérer tous les challenges
     *
     * @return les challenges de la base
     */
    @Override
    public Set<Challenge> findAllChallenges() throws BusinessException {
        try {
            return new HashSet<>(Utils.iterableToList(this.daoChallenge.findAll()));
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer les challenges", e);
        }
    }

    /**
     * Permet de récupérer toutes les leagues
     *
     * @return les leagues de la base
     */
    @Override
    public Set<League> findAllLeagues() throws BusinessException {
        try {
            return new HashSet<>(Utils.iterableToList(this.daoLeague.findAll()));
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer les leagues", e);
        }
    }

    /**
     * Permet de récupérer le challenge qui rapport le plus de points
     *
     * @return le challenge qui possède le plus de points
     */
    @Override
    public Challenge findBestChallenge() throws BusinessException {
        try {
            return this.daoChallenge.getBestChallenge().orElseThrow();
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer le meilleur challenge", e);
        }
    }

    /**
     * Permet de récupérer les rewards points par League
     *
     * @return une Map contenant la league et la somme de ses reward points.
     */
    @Override
    public Map<League, Long> findRewardPointsByLeague() throws BusinessException {
        try {
            return this.daoLeague.getRewardPointsByLeague();
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer les leagues avec leur points", e);
        }
    }

    /**
     * Permet de récupérer les 3 meilleurs builds de la league
     *
     * @param league league choisie
     * @return un Set des trois meilleurs build
     */
    @Override
    public Set<LabySpecialite> findTopThreeBestBuild(League league) {
        return daoLeague.topThreeBestBuild(league);
    }

    /**
     * Permet de connaître les 3 meilleurs builds pour chaque League
     *
     * @return une Map contenant la league ainsi que les 3 meilleurs builds.
     */
    @Override
    public Map<League, Set<LabySpecialite>> findBestBuildByLeague() throws BusinessException {
        try {
            return daoLeague.bestBuildByLeague();
        } catch (DaoException e) {
            throw new BusinessException("Impossible de récupérer les leagues avec leur best build", e);
        }
    }
}
