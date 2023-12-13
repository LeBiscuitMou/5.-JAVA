package net.ent.etrs.gestionLeague.views.facade.impl;

import net.ent.etrs.gestionLeague.models.entities.Challenge;
import net.ent.etrs.gestionLeague.models.entities.EntitiesFactory;
import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.Personnage;
import net.ent.etrs.gestionLeague.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;
import net.ent.etrs.gestionLeague.views.commons.utils.AffichageConsole;
import net.ent.etrs.gestionLeague.views.commons.utils.LectureConsole;
import net.ent.etrs.gestionLeague.views.commons.utils.Utils;
import net.ent.etrs.gestionLeague.views.exception.ViewException;
import net.ent.etrs.gestionLeague.views.facade.FacadeView;
import net.ent.etrs.gestionLeague.views.references.ConstantesView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FacadeViewImpl implements FacadeView {

    /**
     * Permet d'afficher un message d'erreur
     *
     * @param message le message de l'exception
     */
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    /**
     * Permet d'afficher un message à l'utilisateur
     *
     * @param message le message pour l'utilisateur
     */
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    /**
     * Permet d'afficher le menu principal en le construisant
     *
     * @return la liste contenant le menu principal
     */
    @Override
    public List<String> afficherMenuPrincipal() {
        List<String> menuPrincipal = new ArrayList<>();
        menuPrincipal.add("Initialiser");
        menuPrincipal.add("Ajouter league");
        menuPrincipal.add("Afficher toutes les leagues");
        menuPrincipal.add("Afficher les challenges d'une league");
        menuPrincipal.add("Afficher les personnages d'une league");
        menuPrincipal.add("Afficher les leagues avec leurs 3 meilleurs builds");

        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menuPrincipal, "Quitter");
        return menuPrincipal;
    }

    /**
     * Permet de lire le choix de la saisie utilisateur
     *
     * @param size le choix maximal
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public int lectureChoix(int size) {
        return LectureConsole.lectureChoixInt(0, size);
    }

    /**
     * Permet de lire le choix de la saisie utilisateur pour un Oui / Non
     *
     * @param entete
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public boolean lectureChoixBoolean(String entete) {
        return LectureConsole.lectureBoolean(entete);
    }

    /**
     * Permet d'afficher des Leagues
     *
     * @param lesLeagues les leagues à afficher
     */
    @Override
    public void afficherToutesLesLeague(List<League> lesLeagues) {
        for (League l : lesLeagues) {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern(ConstantesView.DATE_PATTERN);
            String formatedDateDebut = l.getDateDebut().format(pattern);

            if (l.getDateFin().equals(LocalDate.MAX)) {
                afficherMessage(String.format("- Nom de la ligue : %s%n" +
                                                "\tDu %s%n" +
                                                "\tEst validée : %b",
                        l.getNom(), formatedDateDebut, l.estValide()));
            } else {
                String formatedDateFin = l.getDateFin().format(pattern);
                afficherMessage(String.format("- Nom de la ligue : %s%n" +
                                                "\tDu %s au %s%n" +
                                                "\tEst validée : %b",
                        l.getNom(), formatedDateDebut, formatedDateFin, l.estValide()));
            }
        }
    }

    /**
     * Permet d'afficher des Challenges
     *
     * @param challenges les Challenges à afficher
     */
    @Override
    public void afficherlesChallenges(List<Challenge> challenges) {
        for (Challenge c : challenges) {
            afficherMessage(c.toString());
        }
    }

    /**
     * Permet d'afficher des Personnages
     *
     * @param personnages les Personnages à afficher
     */
    @Override
    public void afficherlesPersonnages(List<Personnage> personnages) {
        for (Personnage p : personnages) {
            afficherMessage(p.toString());
        }
    }

    /**
     * Permet d'afficher les league avec leur spécialité du Labyrinth
     *
     * @param lesLeagues map contenant les Leagues avec leur top 3 des spécialité
     */
    @Override
    public void afficherLesLeaguesAvecLesMeilleursSpecialite(Map<League, Set<LabySpecialite>> lesLeagues) {

    }

    /**
     * Permet de créer une league sans joueurs ni challenge
     *
     * @return la league créé
     * @throws ViewException exception si pb ç la création
     */
    @Override
    public League saisirNouvelleLeague() throws ViewException {
        afficherMessage(ConstantesView.SAISIR_NOUVELLE_LEAGUE);
        String nom = LectureConsole.lectureChaineCaracteres(ConstantesView.SAISIR_NOM_NOUVELLE_LEAGUE);
        LocalDate dateDebut = LectureConsole.lectureLocalDate(ConstantesView.SAISIR_DATE_DEBUT_NOUVELLE_LEAGUE, ConstantesView.DATE_PATTERN);
        LocalDate dateFin = LectureConsole.lectureLocalDate(ConstantesView.SAISIR_DATE_FIN_NOUVELLE_LEAGUE, ConstantesView.DATE_PATTERN);

        try {
            return EntitiesFactory.fabriquerLeague(dateDebut, dateFin, nom);
        } catch (EntitiesFactoryException e) {
            throw new ViewException(e);
        }
    }

    /**
     * permet de choisir un challenge
     *
     * @param lesChallenges les challenges
     * @return le challenge choisi
     */
    @Override
    public Challenge choisirChallenge(Set<Challenge> lesChallenges) {
        return Utils.recuperationObjet(lesChallenges);
    }

    /**
     * Permet de choisir un personnage
     *
     * @param lesPersonnages les personnage existant
     * @return le personnage choisi
     */
    @Override
    public Personnage choisirPersonnage(Set<Personnage> lesPersonnages) {
        return Utils.recuperationObjet(lesPersonnages);
    }

    /**
     * Permet de choisir une League
     *
     * @param lesLeagues les leagues existantes
     * @return la league choisie
     */
    @Override
    public League choisirLeague(Set<League> lesLeagues) {
        return Utils.recuperationObjet(lesLeagues);
    }
}
