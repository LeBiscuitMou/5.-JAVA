package net.ent.etrs.gestionJeuxVideo.view.facade.impl;

import net.ent.etrs.gestionJeuxVideo.models.entities.Console;
import net.ent.etrs.gestionJeuxVideo.models.entities.EntitiesFactory;
import net.ent.etrs.gestionJeuxVideo.models.entities.Fabriquant;
import net.ent.etrs.gestionJeuxVideo.models.entities.JeuVideo;
import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionJeuxVideo.models.references.Genre;
import net.ent.etrs.gestionJeuxVideo.models.references.Pays;
import net.ent.etrs.gestionJeuxVideo.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionJeuxVideo.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionJeuxVideo.view.facade.FacadeView;
import net.ent.etrs.gestionJeuxVideo.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.gestionJeuxVideo.view.references.ConstanteView;

import java.time.LocalDate;
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
        return null;
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
    public boolean lectureChoixBoolean() {
        return LectureConsole.lectureBoolean("Oui ou Non ?");
    }

    /**
     * Permet de saisir une console
     *
     * @param fabriquantList
     * @return la console construite
     */
    @Override
    public Console saisirConsole(List<Fabriquant> fabriquantList) throws FacadeViewException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la console : ");
        Fabriquant fabriquant = saisirFabriquant();
        try {
            return EntitiesFactory.fabriquerConsole(fabriquant, nom);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATION_CONSOLE, e);
        }
    }

    /**
     * Permet de saisir un jeu video
     *
     * @param fabriquantList
     * @return le jeu video construit
     */
    @Override
    public JeuVideo saisirJeuVideo(List<Fabriquant> fabriquantList) throws FacadeViewException {
        List<Genre> genreList = Arrays.asList(Genre.values());

        Fabriquant fabriquant = saisirFabriquant();
        LocalDate dateSortie = saisieDate();
        String nom = LectureConsole.lectureChaineCaracteres("Saisissez le nom du jeu-vidéo : ");
        Genre genre = selectionnerGenre(genreList);

        try {
            return EntitiesFactory.fabriquerJeuVideo(fabriquant, dateSortie, nom, genre);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_ERROR_JEU_VIDEO, e);
        }
    }

    @Override
    public Fabriquant saisirFabriquant() throws FacadeViewException {
        LocalDate dateCreation = saisieDate();
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom du fabriquant : ");
        Pays pays = selectionnerPays();
        try {
            return EntitiesFactory.fabriquerFabriquant(dateCreation, nom, pays);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATION_FABRIQUANT, e);
        }
    }

    @Override
    public LocalDate saisieDate() {
        return LectureConsole.lectureLocalDate("Entrer la date (" + AffichageConsole.PATTERN_DATE_PAR_DEFAUT + ") : ", AffichageConsole.PATTERN_DATE_PAR_DEFAUT);
    }

    /**
     * Permet d'ajouter une console à un jeu video
     *
     * @param jv le jeu video à modifier
     * @return le jeu video modifié
     */
    @Override
    public JeuVideo ajouterConsoleJeuVideo(JeuVideo jv) throws FacadeViewException {
        if (Objects.isNull(jv)) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_GENRE);
        }
        jv.addPlateform();
        return jv;
    }

    /**
     * Permet de selectionner une console dans une liste
     *
     * @param consoleList la liste des console
     * @return la console choisie
     */
    @Override
    public Console selectionnerConsole(List<Console> consoleList) throws FacadeViewException {
        if (consoleList.isEmpty()) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_GENRE);
        }
        List<String> lstConsole = new ArrayList<>();
        for (Console c : consoleList) {
            lstConsole.add(c.toString());
        }
        AffichageConsole.afficherMenuSimple(lstConsole);
        afficherMessage("Sélectionner la console");
        int choix = lectureChoix(lstConsole.size());
        return consoleList.get(choix - 1);
    }

    @Override
    public Pays selectionnerPays() {
        List<String> lstPays = new ArrayList<>();
        for (Pays p : Pays.values()) {
            lstPays.add(p.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lstPays);
        afficherMessage("Saisir le pays : ");
        int choix = lectureChoix(lstPays.size());
        return Pays.values()[choix - 1];
    }

    /**
     * Permet de selectionner un genre de jeu video
     *
     * @param listeGenre la liste des genre de jeu video
     * @return le genre selectionner
     */
    @Override
    public Genre selectionnerGenre(List<Genre> listeGenre) throws FacadeViewException {
        if (listeGenre.isEmpty()) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_GENRE);
        }
        List<String> lstGenre = new ArrayList<>();
        for (Genre g : listeGenre) {
            lstGenre.add(g.toString());
        }
        AffichageConsole.afficherMenuSimple(lstGenre);
        afficherMessage("Sélectionner le genre");
        int choix = lectureChoix(lstGenre.size());
        return listeGenre.get(choix - 1);
    }

    /**
     * Affiche une liste de jeux video
     *
     * @param jeuVideoList liste de jeux video
     */
    @Override
    public void afficherJeuVideo(List<JeuVideo> jeuVideoList) {
        for (JeuVideo jv : jeuVideoList) {
            AffichageConsole.afficherMessageAvecSautLigne(jv.toString());
        }
    }

    /**
     * Affiche un catalogue des console avec leur jeux video
     *
     * @param catalogueJeuVideoConsole map de Console / liste de jeux video
     */
    @Override
    public void afficherConsoleAvecJeuVideo(Map<Console, List<JeuVideo>> catalogueJeuVideoConsole) throws FacadeViewException {
        if (Objects.isNull(catalogueJeuVideoConsole)) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_GENRE);
        }
        for (Map.Entry<Console, List<JeuVideo>> catalogueJeuVideoConsoleEntry : catalogueJeuVideoConsole.entrySet()) {
            AffichageConsole.afficherMessageAvecSautLigne(String.format("%s %s", catalogueJeuVideoConsoleEntry.getKey().getNom(), catalogueJeuVideoConsoleEntry.getKey().getFabriquant()));
            for (JeuVideo jeuVideo : catalogueJeuVideoConsoleEntry.getValue()) {
                AffichageConsole.afficherMessageAvecSautLigne(String.format("\t%s %s %s %s", jeuVideo.getNom(), jeuVideo.getGenre().toString(), jeuVideo.getDateSortie().toString(), jeuVideo.getStudioDev().toString()));
            }
        }
    }
}