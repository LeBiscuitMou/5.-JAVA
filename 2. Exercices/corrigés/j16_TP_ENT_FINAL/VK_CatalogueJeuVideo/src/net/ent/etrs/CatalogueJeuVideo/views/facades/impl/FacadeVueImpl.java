package net.ent.etrs.CatalogueJeuVideo.views.facades.impl;
import net.ent.etrs.CatalogueJeuVideo.model.entities.*;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.EntitiesException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.JeuVideoException;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstMetier;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;
import net.ent.etrs.CatalogueJeuVideo.views.commons.utils.*;
import net.ent.etrs.CatalogueJeuVideo.views.exceptions.ViewException;
import net.ent.etrs.CatalogueJeuVideo.views.facades.FacadeView;
import net.ent.etrs.CatalogueJeuVideo.views.references.ConstView;

import java.time.LocalDate;
import java.util.*;


public class FacadeVueImpl implements FacadeView {
    protected FacadeVueImpl() {

    }

    /**
     * Permet d'afficher un message d'erreur.
     *
     * @param message le message de l'exception
     */
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }


    /**
     * Permet d'afficher un message à l'utilisateur.
     *
     * @param message le message pour l'utilisateur
     */
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    /**
     * Permet d'afficher le menu principal en le construisant et de lire le choix de la saisie utilisateur.
     *
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public List<String> afficherMenuPrincipal() {
        List<String> listOptions = new ArrayList<>(Arrays.asList(ConstView.MENU));
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < listOptions.size(); i++) {
            map.put(i+1, listOptions.get(i));
        }
        AffichageConsole.afficherMenuEntoure(map, ConstView.NOM_PROGRAMME);
        return listOptions;
    }

    /**
     * Permet de lire le choix de la saisie utilisateur.
     *
     * @param size le choix maximal
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public int lectureChoix(int size) {
        return LectureConsole.lectureChoixInt(1, size);
    }

    /**
     * Permet de lire le choix de la saisie utilisateur pour un Oui / Non.
     *
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public boolean lectureChoixBoolean() {
        return LectureConsole.lectureBoolean(ConstView.OUI_NON);
    }

    /**
     * Permet de saisir une console.
     *
     * @param fabriquantList liste de tous les fabricants
     * @return la console construite
     */
    @Override
    public Console saisirConsole(List<Fabriquant> fabriquantList) throws ViewException {
        afficherMessage(ConstView.SAISIR_CONSOLE);
        String nom = LectureConsole.lectureChaineCaracteres(ConstView.SAISIE_NOM);
        Fabriquant fabriquant = selectionnerFabriquant(fabriquantList);

        try {
            return EntitiesFactory.fabriquerConsole(nom, fabriquant);
        } catch (EntitiesException e) {
            throw new ViewException(e);
        }
    }

    /**
     * Permet de saisir un jeu video.
     *
     * @param fabriquantList liste de tous les fabricants
     * @return le jeu video construit
     */
    @Override
    public JeuVideo saisirJeuVideo(List<Fabriquant> fabriquantList) throws ViewException {
        afficherMessage(ConstView.SAISIR_JEU_VIDEO);
        String nom = LectureConsole.lectureChaineCaracteres(ConstView.SAISIE_NOM);
        LocalDate date = LectureConsole.lectureLocalDate("la date de sortie ?:", ConstMetier.DATE_PATTERN);
        Genre genre = selectionnerGenre(List.of(Genre.values()));
        Fabriquant fabriquant = selectionnerFabriquant(fabriquantList);

        JeuVideo jeu;
        try {
            jeu = EntitiesFactory.fabriquerJeuVideo(nom, date, genre, fabriquant);
        } catch (EntitiesException e) {
            throw new ViewException(e);
        }
        return jeu;
    }

    /**
     * Permet de saisir un jeu video.
     *
     * @return le jeu video construit
     */
    @Override
    public Fabriquant saisirFabricant() throws ViewException {
        afficherMessage(ConstView.SAISIR_FABRIQUANT);
        String nom = LectureConsole.lectureChaineCaracteres(ConstView.SAISIE_NOM);
        LocalDate date = LectureConsole.lectureLocalDate("la date de création ?", ConstMetier.DATE_PATTERN);
        Pays pays = selectionnerPays(List.of(Pays.values()));
        try {
            return EntitiesFactory.fabriquerFabriquant(nom, date, pays);
        } catch (EntitiesException e) {
            throw new ViewException(e);
        }
    }


    /**
     * Permet d'ajouter une console à un jeu video.
     *
     * @param jv le jeu video à modifier
     * @param consoleList la liste de toutes les consoles.
     * @return le jeu video modifié
     */
    @Override
    public JeuVideo ajouterConsoleJeuVideo(JeuVideo jv, List<Console> consoleList) throws ViewException {
        List<Console> list = new ArrayList<>(List.copyOf(consoleList));
        list.removeAll(jv.getPlateformes());
        Console console = selectionnerConsole(list);

        try {
            jv.addPlateforme(console);
        } catch (JeuVideoException e) {
            throw new ViewException(e);
        }
        return jv;
    }

    /**
     * Permet de sélectionner une console dans une liste.
     *
     * @param consoleList la liste des console
     * @return la console choisie
     */
    @Override
    public Console selectionnerConsole(List<Console> consoleList) {
        return (Console) selectObjet(consoleList, ConstView.CHOISIR_CONSOLE);
    }

    /**
     * Permet de sélectionner un fabricant dans une liste.
     *
     * @param fabriquantList la liste des fabricants
     * @return le fabricant choisi
     */
    @Override
    public Fabriquant selectionnerFabriquant(List<Fabriquant> fabriquantList) {
        return (Fabriquant) selectObjet(fabriquantList, ConstView.CHOISIR_FABRIQUANT);
    }

    /**
     * Permet de sélectionner un genre de jeu video.
     *
     * @param listeGenre la liste des genres de jeu video
     * @return le genre sélectionné
     */
    @Override
    public Genre selectionnerGenre(List<Genre> listeGenre) {
        return (Genre) selectObjet(listeGenre, ConstView.CHOISIR_GENRE);
    }

    /**
     * Affiche une liste de jeux video.
     *
     * @param jeuVideoList liste de jeux video
     */
    @Override
    public void afficherJeuVideo(List<JeuVideo> jeuVideoList) {
        StringBuilder affichage = new StringBuilder();
        for(JeuVideo jeu : jeuVideoList){
            affichage.append(jeu);
            for(Console console: jeu.getPlateformes()){
                affichage.append(String.format(" | %s", console.getNom()));
            }
            affichage.append('\n');
        }
        afficherMessage(affichage.toString());
    }

    /**
     * Affiche un catalogue des consoles avec leurs jeux video.
     *
     * @param catalogueJeuVideoConsole map de Console / liste de jeux video
     */
    @Override
    public void afficherConsoleAvecJeuVideo(Map<Console, List<JeuVideo>> catalogueJeuVideoConsole) {
        StringBuilder affichage = new StringBuilder();
        for(Map.Entry<Console, List<JeuVideo>> entry : catalogueJeuVideoConsole.entrySet()){
            affichage.append(entry.getKey().toString()).append('\n');
            for(JeuVideo jeu : entry.getValue()){
                affichage.append(String.format("%s%s", ConstView.BLANC, jeu.getNom()));
            }
        }
        afficherMessage(affichage.toString());
    }

    /**
     * Choisir un pays dans une liste.
     *
     * @param paysList liste de pays
     * @return le pays choisi
     */
    @Override
    public Pays selectionnerPays(List<Pays> paysList){
        return (Pays) selectObjet(paysList, ConstView.CHOISIR_PAYS);
    }

    @Override
    public JeuVideo selectionnerJeuVideo(List<JeuVideo> jeuVideoList){
        return (JeuVideo) selectObjet(jeuVideoList, ConstView.CHOISIR_JEU_VIDEO);
    }

    private Object selectObjet(List<?> list, String message){
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i+1, list.get(i).toString());
        }
        AffichageConsole.afficherMenuEntoure(map, message);
        return list.get(lectureChoix(map.size())-1);
    }

}
