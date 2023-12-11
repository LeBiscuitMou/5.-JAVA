package net.ent.etrs.CatalogueJeuVideo.views.facades;

import net.ent.etrs.CatalogueJeuVideo.model.entities.*;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;
import net.ent.etrs.CatalogueJeuVideo.views.exceptions.ViewException;

import java.util.List;
import java.util.Map;

public interface FacadeView {
    /**
     * Permet d'afficher un message d'erreur.
     *
     * @param message le message de l'exception
     */
    void afficherMessageErreur(String message);

    /**
     * Permet d'afficher tous les messages liés à une erreur.
     *
     * @param error l'exception dont il faut afficher les messages
     */
    void afficherMessageErreur(Throwable error);

    /**
     * Permet d'afficher un message à l'utilisateur.
     *
     * @param message le message pour l'utilisateur
     */
    void afficherMessage(String message);


    /**
     * Permet d'afficher le menu principal en le construisant et de lire le choix de la saisie utilisateur.
     *
     * @return le choix effectué par l'utilisateur
     */
    List<String> afficherMenuPrincipal();

    /**
     * Permet de lire le choix de la saisie utilisateur.
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
    Console saisirConsole(List<Fabriquant> fabriquantList) throws ViewException;

    /**
     * Permet de saisir un jeu video
     * @return le jeu video construit
     */
    JeuVideo saisirJeuVideo(List<Fabriquant> fabriquantList) throws ViewException;

    /**
     * Permet de saisir un jeu video
     *
     * @return le jeu video construit
     */
    Fabriquant saisirFabricant() throws ViewException;

    /**
     * Permet d'ajouter une console à un jeu video
     * @param jv le jeu video à modifier
     * @return le jeu video modifié
     */
    JeuVideo ajouterConsoleJeuVideo(JeuVideo jv, List<Console> consoleList) throws ViewException;

    /**
     * Permet de sélectionner une console dans une liste
     * @param consoleList la liste des console
     * @return la console choisie
     */
    Console selectionnerConsole(List<Console> consoleList);

    /**
     * Permet de sélectionner un fabricant dans une liste
     *
     * @param fabriquantList la liste des fabricants
     * @return le fabricant choisi
     */
    Fabriquant selectionnerFabriquant(List<Fabriquant> fabriquantList);


    /**
     * Permet de sélectionner un genre de jeu video
     * @param listeGenre la liste des genres de jeu video
     * @return le genre sélectionné
     */
    Genre selectionnerGenre(List<Genre> listeGenre);


    /**
     * Affiche une liste de jeux video
     * @param jeuVideoList liste de jeux video
     */
    void afficherJeuVideo(List<JeuVideo> jeuVideoList);

    /**
     * Affiche un catalogue des consoles avec leurs jeux video
     * @param catalogueJeuVideoConsole map de Console / liste de jeux video
     */
    void afficherConsoleAvecJeuVideo(Map<Console,List<JeuVideo>> catalogueJeuVideoConsole);

    /**
     * Choisir un pays dans une liste.
     *
     * @param paysList liste de pays
     * @return le pays choisi
     */
    Pays selectionnerPays(List<Pays> paysList);

    JeuVideo selectionnerJeuVideo(List<JeuVideo> jeuVideoList);
}
