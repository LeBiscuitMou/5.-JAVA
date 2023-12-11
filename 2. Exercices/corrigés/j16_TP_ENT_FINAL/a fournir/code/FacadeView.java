package net.ent.etrs.gestionJeuxVideo.view.facade;

import net.ent.etrs.gestionJeuxVideo.models.entities.Console;
import net.ent.etrs.gestionJeuxVideo.models.entities.JeuVideo;
import net.ent.etrs.gestionJeuxVideo.models.entities.references.Genre;

import java.util.List;
import java.util.Map;

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
    boolean lectureChoixBoolean();

    /**
     * Permet de saisir une console
     * @return la console construite
     */
   Console saisirConsole();

    /**
     * Permet de saisir un jeu video
     * @return le jeu video construit
     */
   JeuVideo saisirJeuVideo();

    /**
     * Permet d'ajouter une console à un jeu video
     * @param jv le jeu video à modifier
     * @return le jeu video modifié
     */
   JeuVideo ajouterConsoleJeuVideo(JeuVideo jv);

    /**
     * Permet de selectionner une console dans une liste
     * @param consoleList la liste des console
     * @return la console choisie
     */
   Console selectionnerConsole(List<Console> consoleList);

    /**
     * Permet de selectionner un genre de jeu video
     * @param listeGenre la liste des genre de jeu video
     * @return le genre selectionner
     */
   Genre selectionnerGenre(List<Genre> listeGenre);


    /**
     * Affiche une liste de jeux video
     * @param jeuVideoList liste de jeux video
     */
   void afficherJeuVideo(List<JeuVideo> jeuVideoList);

    /**
     * Affiche un catalogue des console avec leur jeux video
     * @param catalogueJeuVideoConsole map de Console / liste de jeux video
     */
   void afficherConsoleAvecJeuVideo(Map<Console,List<JeuVideo>> catalogueJeuVideoConsole);
}
