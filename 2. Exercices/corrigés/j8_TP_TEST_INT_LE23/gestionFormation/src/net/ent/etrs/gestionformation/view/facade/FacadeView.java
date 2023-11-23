package net.ent.etrs.gestionformation.view.facade;

import net.ent.etrs.gestionformation.models.entities.Cours;
import net.ent.etrs.gestionformation.models.entities.Journee;
import net.ent.etrs.gestionformation.models.entities.Matiere;
import net.ent.etrs.gestionformation.models.entities.UniteValeur;
import net.ent.etrs.gestionformation.view.facade.exceptions.FacadeViewException;

import java.util.List;

public interface FacadeView {


    /**
     * Permet d'afficher le Menu de l'application
     * @param menu la listte contenant le menu
     */
    void afficherMenu(List<String> menu);

    /**
     * Permet d'afficher un message d'erreur
     * @param message le message à afficher
     */
    void afficherMessageErreur(String message);

    /**
     * Permet d'afficher un message à l'utilisateur
     * @param message le message à afficher
     */
    void afficherMessage(String message);

    /**
     * Permet à l'utilisateur de créer un cours
     * @param matiere la matière a qui on ajout le cours
     * @return le cours créé
     */
    Cours saisirCours(Matiere matiere) throws FacadeViewException;

    /**
     * Permet à l'utilisateur de créer une matière
     * @return la matière créé
     */
    Matiere saisirMatiere() throws FacadeViewException;

    /**
     * Permet à l'utilisateur de créer un UV
     * @return l'UV créer
     */
    UniteValeur saisirUV() throws FacadeViewException;



    /**
     * Permet d'afficher une semaine
     * @param semaine la liste des journée de la semaine
     */
    void afficherSemaine(List<Journee> semaine);

    /**
     * Permet de selectioonner une matière parmis celle existante
     * @param matieres les matières existante
     * @return la matière selectionnée
     */
    Matiere selectionnerMatière(List<Matiere> matieres) throws FacadeViewException;

    /**
     * Permet de selectionner un cours
     * @param cours la liste des cours d'une matière
     * @return le cours selectionner
     * @throws FacadeViewException s'il y a un soucis à la selection
     */
    Cours selectionnerCours(List<Cours> cours) throws FacadeViewException;


    /**
     * Permet de selectionner une UV
     * @param uniteValeurs les UV possible
     * @return l'UV selectionnée
     */
    UniteValeur selectionnerUV(List<UniteValeur> uniteValeurs) throws FacadeViewException;

    /**
     * Permet d'afficher les matière d'une UV
     * @param matiereList la lioste des Matière
     */
    void afficherMatiereOfUV(List<Matiere> matiereList);

    /**
     * Permet d'afficher les Cours d'une Matière
     * @param lesCours les cours de la matière
     */
    void afficherCoursOfMatiere(List<Cours> lesCours);

    /**
     * Permet d'initialiser une journée
     * @return la journée saisie
     */
    Journee saisirJour() throws FacadeViewException;

    /**
     * Permet d'ajouter un cours à un créneau de la journée
     * @param c le cours à ajouter
     * @param jour la journée à modifier
     * @return la journée modifier
     */
    Journee ajouterCours(Cours c, Journee jour) throws FacadeViewException;
}
