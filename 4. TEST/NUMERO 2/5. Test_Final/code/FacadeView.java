package net.ent.etrs.poeleague.view.facade;

import net.ent.etrs.poeleague.model.entities.Challenge;
import net.ent.etrs.poeleague.model.entities.League;
import net.ent.etrs.poeleague.model.entities.Personnage;
import net.ent.etrs.poeleague.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FacadeView {

    /**
     * Permet d'afficher un message d'erreur
     *
     * @param message le message de l'exception
     */
    void afficherMessageErreur(String message);

    /**
     * Permet d'afficher un message à l'utilisateur
     *
     * @param message le message pour l'utilisateur
     */
    void afficherMessage(String message);

    /**
     * Permet d'afficher le menu principal en le construisant
     *
     * @return la liste contenant le menu principal
     */
    List<String> afficherMenuPrincipal();

    /**
     * Permet de lire le choix de la saisie utilisateur
     *
     * @param size le choix maximal
     * @return le choix effectué par l'utilisateur
     */
    int lectureChoix(int size);

    /**
     * Permet de lire le choix de la saisie utilisateur pour un Oui / Non
     *
     * @return le choix effectué par l'utilisateur
     */
    boolean lectureChoixBoolean(String entete);


    /**
     * Permet d'afficher des Leagues
     *
     * @param lesLeagues les leagues à afficher
     */
    void afficherToutesLesLeague(List<League> lesLeagues);


    /**
     * Permet d'afficher des Challenges
     *
     * @param challenges les Challenges à afficher
     */
    void afficherlesChallenges(List<Challenge> challenges);

    /**
     * Permet d'afficher des Personnages
     *
     * @param personnages les Personnages à afficher
     */
    void afficherlesPersonnages(List<Personnage> personnages);

    /**
     * Permet d'afficher les league avec leur spécialité du Labyrinth
     *
     * @param lesLeagues map contenant les Leagues avec leur top 3 des spécialité
     */
    void afficherLesLeaguesAvecLesMeilleursSpecialite(Map<League, Set<LabySpecialite>> lesLeagues);

    /**
     * Permet de créer une league sans joueurs ni challenge
     *
     * @return la league créé
     * @throws EntitiesFactoryException exception si pb ç la création
     */
    League saisirNouvelleLeague() throws EntitiesFactoryException;

    /**
     * permet de choisir un challenge
     *
     * @param lesChallenges les challenges
     * @return le challenge choisi
     */
    Challenge choisirChallenge(Set<Challenge> lesChallenges);

    /**
     * Permet de choisir un personnage
     *
     * @param lesPersonnages les personnage existant
     * @return le personnage choisi
     */
    Personnage choisirPersonnage(Set<Personnage> lesPersonnages);

    /**
     * Permet de choisir une League
     *
     * @param lesLeagues les leagues existantes
     * @return la league choisie
     */
    League choisirLeague(Set<League> lesLeagues);
}
