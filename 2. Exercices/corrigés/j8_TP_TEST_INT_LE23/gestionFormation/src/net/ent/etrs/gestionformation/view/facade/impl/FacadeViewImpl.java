package net.ent.etrs.gestionformation.view.facade.impl;

import net.ent.etrs.gestionformation.models.entities.*;
import net.ent.etrs.gestionformation.models.entities.exceptions.CoursException;
import net.ent.etrs.gestionformation.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionformation.models.entities.exceptions.JourneeException;
import net.ent.etrs.gestionformation.models.entities.references.TypeMatiere;
import net.ent.etrs.gestionformation.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionformation.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionformation.view.facade.FacadeView;
import net.ent.etrs.gestionformation.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.gestionformation.view.facade.references.ConstanteView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FacadeViewImpl implements FacadeView {


    /**
     * Permet d'afficher le Menu de l'application
     *
     * @param menu la listte contenant le menu
     */
    @Override
    public void afficherMenu(List<String> menu) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu,"Gestionnaire d'Emploi du Temps");
    }

    /**
     * Permet d'afficher un message d'erreur
     *
     * @param message le message à afficher
     */
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    /**
     * Permet d'afficher un message à l'utilisateur
     *
     * @param message le message à afficher
     */
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    /**
     * Permet à l'utilisateur de créer un cours
     *
     * @param matiere la matière a qui on ajout le cours
     * @return le cours créé
     */
    @Override
    public Cours saisirCours(Matiere matiere) throws FacadeViewException {
        int num = LectureConsole.lectureEntier("Saisir le numéro du cours");
        afficherMessage("Saisir la durée du cours :");
        int duree = LectureConsole.lectureChoixInt(0,4);
        String idCours = matiere.getCodeMatiere()+"-"+num;
        try {
            return EntitiesFactory.fabriquerCours(idCours,duree);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATE_COURS_EROR,e);
        }
    }


    /**
     * Permet à l'utilisateur de créer une matière
     *
     * @return la matière créé
     */
    @Override
    public Matiere saisirMatiere() throws FacadeViewException {

        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la matière");
        String codeMatiere = LectureConsole.lectureChaineCaracteres("Saisir le code de la matière");
        List<String> typesMatieres = new ArrayList<>();
        for (TypeMatiere type : TypeMatiere.values()) {
            typesMatieres.add(type.toString().toUpperCase());
        }
        afficherMessage("Saisir le type de la matière");
        AffichageConsole.afficherMenuSimple(typesMatieres);
       int choixTypeMatiere = LectureConsole.lectureChoixInt(0,typesMatieres.size());

        try {
            return EntitiesFactory.fabriquerMatiere(nom,codeMatiere,TypeMatiere.valueOf(typesMatieres.get(choixTypeMatiere)));
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATE_MATIERE_ERROR,e);
        }
    }

    /**
     * Permet à l'utilisateur de créer un UV
     *
     * @return l'UV créer
     */
    @Override
    public UniteValeur saisirUV() throws FacadeViewException {

        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de l'UV");
        LocalDate dateDebut= null;
        do {
            afficherMessage("La date de début d'UV doit être un Lundi");
            dateDebut = LectureConsole.lectureLocalDate("Saisir la date de début de l'UV (" + ConstanteView.PATTERN_DATE + ")" , ConstanteView.PATTERN_DATE);

        }while (!dateDebut.getDayOfWeek().equals(DayOfWeek.MONDAY));

        try {
            return EntitiesFactory.fabriquerUniteValeur(nom,dateDebut);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATE_UV_ERROR,e);
        }
    }



    /**
     * Permet d'afficher une semaine
     *
     * @param semaine la liste des journée de la semaine
     */
    @Override
    public void afficherSemaine(List<Journee> semaine) {
        for (Journee j: semaine) {
            afficherMessage(String.format("Journée %s",j.getDate()));
            for (Cours c : j.getLesCours()) {
                afficherMessage(String.format("Cours : %s à %s",c.getIdCours(),c.getDebutCours().toString()));
            }
        }

    }

    /**
     * Permet de selectioonner une matière parmis celle existante
     *
     * @param matieres les matières existante
     * @return la matière selectionnée
     */
    @Override
    public Matiere selectionnerMatière(List<Matiere> matieres) throws FacadeViewException {
        AffichageConsole.afficherMenuSimple(Collections.singletonList(matieres.toString()));
        int choix = LectureConsole.lectureChoixInt(0,matieres.size());
        if (choix == 0) {
            throw new FacadeViewException(ConstanteView.FACADE_SELECT_MATIERE_ERROR);
        }
        return matieres.get(choix-1);
    }

    /**
     * Permet de selectionner un cours
     *
     * @param cours la liste des cours d'une matière
     * @return le cours selectionner
     * @throws FacadeViewException s'il y a un soucis à la selection
     */
    @Override
    public Cours selectionnerCours(List<Cours> cours) throws FacadeViewException {
        AffichageConsole.afficherMenuSimple(Collections.singletonList(cours.toString()));
        int choix = LectureConsole.lectureChoixInt(0,cours.size());
        if (choix == 0) {
            throw new FacadeViewException(ConstanteView.FACADE_SELECT_COURS_ERROR);
        }
        return cours.get(choix-1);
    }

    /**
     * Permet de selectionner une UV
     *
     * @param uniteValeurs les UV possible
     * @return l'UV selectionnée
     */
    @Override
    public UniteValeur selectionnerUV(List<UniteValeur> uniteValeurs) throws FacadeViewException {
        AffichageConsole.afficherMenuSimple(Collections.singletonList(uniteValeurs.toString()));
        int choix = LectureConsole.lectureChoixInt(0,uniteValeurs.size());
        if (choix == 0) {
            throw new FacadeViewException(ConstanteView.FACADE_SELECT_UV_ERROR);
        }
        return uniteValeurs.get(choix-1);
    }

    /**
     * Permet d'afficher les matière d'une UV
     *
     * @param matiereList la lioste des Matière
     */
    @Override
    public void afficherMatiereOfUV(List<Matiere> matiereList) {
        List<String> lesmatiere = Collections.singletonList(matiereList.toString());
        AffichageConsole.afficherMenuSimple(lesmatiere);
    }

    /**
     * Permet d'afficher les Cours d'une Matière
     *
     * @param lesCours les cours de la matière
     */
    @Override
    public void afficherCoursOfMatiere(List<Cours> lesCours) {
        List<String> coursMatiere = Collections.singletonList(lesCours.toString());
        AffichageConsole.afficherMenuSimple(coursMatiere);
    }

    /**
     * Permet d'initialiser une journée
     *
     * @return la journée saisie
     */
    @Override
    public Journee saisirJour() throws FacadeViewException {
        try {
            LocalDate dateJour = LectureConsole.lectureLocalDate("Saisir la date du Jour ("+ConstanteView.PATTERN_DATE+")",ConstanteView.PATTERN_DATE);
            return EntitiesFactory.fabriquerJournee(dateJour);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATE_DAY,e);
        }
    }

    /**
     * Permet d'ajouter un cours à un créneau de la journée
     *
     * @param c    le cours à ajouter
     * @param jour la journée à modifier
     * @return la journée modifier
     */
    @Override
    public Journee ajouterCours(Cours c, Journee jour) throws FacadeViewException {
        if(Objects.isNull(jour)){
            throw new FacadeViewException(ConstanteView.FACADE_JOUR_NULL);
        }
        if(Objects.isNull(c)){
            throw new FacadeViewException(ConstanteView.FACADE_COURS_NULL);
        }
        //On vérifie les créneau utilisés
        List<LocalDateTime> lesCreneauUtilise = afficherCreneauHoraireOccuper(jour);
        LocalDateTime ldtCours = null;
        do{
            afficherMessage("Saisir une heure de début de cours libre :");
            int choix = LectureConsole.lectureChoixInt(8,16);
            ldtCours = jour.getDate().atTime(choix,0);
        }while (lesCreneauUtilise.contains(ldtCours));


        try {
            //On défini le début du Cours
            c.setDebutCours(ldtCours);
            //On ajout le cours à la journée
            jour.ajouterCours(c);
        } catch (CoursException | JourneeException e) {
            throw new FacadeViewException(ConstanteView.FACADE_AJOUT_COURS,e);
        }

        return jour;
    }

    private List<LocalDateTime> afficherCreneauHoraireOccuper(Journee jour) throws FacadeViewException {
        List<LocalDateTime> retour = new ArrayList<>();

        if (jour.getLesCours().size() > 0) {
            for (Cours c:jour.getLesCours()) {
                afficherMessage(c.getDebutCours().format(DateTimeFormatter.ofPattern("hh:mm")));
                retour.add(c.getDebutCours());
                for (int i = 0; i < c.getDuree(); i++) {
                    afficherMessage(c.getDebutCours().plusHours(i).format(DateTimeFormatter.ofPattern("hh:mm")));
                    retour.add(c.getDebutCours().plusHours(i));
                }
            }
        }
        return retour;
    }
}
