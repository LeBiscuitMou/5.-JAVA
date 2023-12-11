package net.ent.etrs.gestionJeuxVideo.models.facade;

import net.ent.etrs.gestionJeuxVideo.models.entities.Console;
import net.ent.etrs.gestionJeuxVideo.models.entities.Fabriquant;
import net.ent.etrs.gestionJeuxVideo.models.entities.JeuVideo;
import net.ent.etrs.gestionJeuxVideo.models.entities.references.Genre;
import net.ent.etrs.gestionJeuxVideo.models.facade.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface FacadeMetier {

    /**
     * Permet de sauvegarder un jeu video
     * @param jv le jeu vidfeo à sauvegarder
     * @return le jeu video sauvegarder
     */
    JeuVideo sauvergarderJeuVideo(JeuVideo jv) throws BusinessException;

    /**
     * Permet de sauvegarder un fabriquant
     * @param fabriquant le fabriquant à sauvegarder
     * @return le fabriquant sauvegarder
     */
    Fabriquant sauvegarderFabriquant(Fabriquant fabriquant) throws BusinessException;

    /**
     * Permet de sauvegarder une console
     * @param console la console à sauvegarder
     * @return la console sauvegarder
     */
    Console sauvegarderConsole(Console console) throws BusinessException;

    /**
     * Permet de récupérer tous les fabriquant
     * @return la liste de tous les fabriquant
     */
    List<Fabriquant> recupererFabriquants() throws BusinessException;

    /**
     * Permet de récupérer toutes les consoles
     * @return la liste de toutes les console
     */
    List<Console> recupererConsole() throws BusinessException;

    /**
     * Permet de récuperer tous les jeux video
     * @return la liste de tous les jeux video
     */
    List<JeuVideo> recupererJeuVideo() throws BusinessException;

    /**
     * Permet de récuperer tous les jeux video du genre choisi
     * @param genre le genre choisi
     * @return la liste des jeux video de ce genre
     */
    List<JeuVideo> recupererJeuVideoParGenre(Genre genre) throws BusinessException;

    /**
     * Permet de récuperer un dictionnaire contenant toutes les consoles avec leur jeux video
     * @return une map contenant toutes les consoles avec leur jeux video
     */
    Map<Console,List<JeuVideo>> recupererConsoleAvecLeurJeuxVideo() throws BusinessException;

    /**
     * Permet d'initialisaer les données du logiciel
     * @param init liste de chaine de caractères contenant les données d'initilisation
     */
    void initialisation(List<String> init) throws BusinessException;


}
