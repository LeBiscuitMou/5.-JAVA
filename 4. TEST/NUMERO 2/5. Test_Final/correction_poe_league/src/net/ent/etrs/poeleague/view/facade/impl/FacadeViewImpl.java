package net.ent.etrs.poeleague.view.facade.impl;

import net.ent.etrs.poeleague.model.entities.Challenge;
import net.ent.etrs.poeleague.model.entities.EntitiesFactory;
import net.ent.etrs.poeleague.model.entities.League;
import net.ent.etrs.poeleague.model.entities.Personnage;
import net.ent.etrs.poeleague.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;
import net.ent.etrs.poeleague.view.commons.utils.AffichageConsole;
import net.ent.etrs.poeleague.view.commons.utils.LectureConsole;
import net.ent.etrs.poeleague.view.commons.utils.Utils;
import net.ent.etrs.poeleague.view.facade.FacadeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<String> ret = new ArrayList<>();
        ret.add("Initialiser");
        ret.add("Creer une League");
        ret.add("Afficher toutes les Leagues");
        ret.add("Afficher les Challenges d'une League");
        ret.add("Afficher les Personnages d'une League");
        ret.add("Afficher les leagues avec leurs meilleurs build");
        AffichageConsole.afficherMenuSimple(ret);
        return ret;
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
        for (League league : lesLeagues) {
            AffichageConsole.afficherMessageAvecSautLigne(
                    String.format("Nom de la League : %s%n" +
                                    "Du %s %s%n" +
                                    "Est valide : %s",
                            league.getNom(), league.getDateDebut(),
                            league.getDateFin() == null ? "à une fin non déterminée" : "au " + league.getDateFin(),
                            league.estValide())
            );
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
            AffichageConsole.afficherMessageAvecSautLigne(String.format("Challenge : %s rapportant %s nombre de points", c.getNom(), c.getRewardPoints()));
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
            AffichageConsole.afficherMessageAvecSautLigne(String.format("Pseudo : %s%n" +
                    "Spécialité : %s%n" +
                    "Level : %s", p.getPseudo(), p.getBuild(), p.getLevel()));
        }
    }

    /**
     * Permet d'afficher les league avec leur spécialité du Labyrinth
     *
     * @param lesLeagues map contenant les Leagues avec leur top 3 des spécialité
     */
    @Override
    public void afficherLesLeaguesAvecLesMeilleursSpecialite(Map<League, Set<LabySpecialite>> lesLeagues) {
        for (Map.Entry<League, Set<LabySpecialite>> entry : lesLeagues.entrySet()) {
            AffichageConsole.afficherMessageAvecSautLigne(
                    String.format("League : %s", entry.getKey().getNom())
            );
            for (LabySpecialite ls : entry.getValue()) {
                AffichageConsole.afficherMessageAvecSautLigne(
                        String.format("\tSpecialite : %s", ls.toString())
                );
            }
        }
    }

    @Override
    public League saisirNouvelleLeague() throws EntitiesFactoryException {

        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la league");
        AffichageConsole.afficherMessageAvecSautLigne("Saisissez la date début au format : (" + AffichageConsole.PATTERN_DATE_PAR_DEFAUT + ")");
        LocalDate dateDebut = LectureConsole.lectureLocalDate(AffichageConsole.PATTERN_DATE_PAR_DEFAUT);
        AffichageConsole.afficherMessageAvecSautLigne("Saisissez la date fin au format : (" + AffichageConsole.PATTERN_DATE_PAR_DEFAUT + ")");
        LocalDate dateFin = LectureConsole.lectureLocalDate(AffichageConsole.PATTERN_DATE_PAR_DEFAUT);
        League l = EntitiesFactory.fabriquerLeague(nom, dateDebut, dateFin);

        return l;
    }

    @Override
    public Challenge choisirChallenge(Set<Challenge> lesChallenges) {
        return Utils.récupérationObjet(lesChallenges);
    }

    @Override
    public Personnage choisirPersonnage(Set<Personnage> lesPersonnages) {
        return Utils.récupérationObjet(lesPersonnages);
    }

    /**
     * Permet de choisir une League
     *
     * @param lesLeagues les leagues existantes
     * @return la league choisie
     */
    @Override
    public League choisirLeague(Set<League> lesLeagues) {
        return Utils.récupérationObjet(lesLeagues);
    }
}
