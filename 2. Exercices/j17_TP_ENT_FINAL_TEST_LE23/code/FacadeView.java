package net.ent.etrs.pjjeudesociete.views.facade;

import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.views.exception.ViewException;

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
     * Permet de saisir un nouveau jeu de société
     *
     * @param lesAuteursPossible le set des Auteur disponible
     * @param lesMAisonEditions  le set des Maison d'édition disponible
     * @return le nouveau jeu de société
     */
    JeuSociete saisirJeuSociete(Set<Auteur> lesAuteursPossible, Set<MaisonEdition> lesMAisonEditions) throws ViewException;

    /**
     * Permet de saisir un nouvel auteur
     *
     * @return le nouvel auteur
     */
    Auteur saisirAuteur() throws ViewException;

    /**
     * Permet de modifier le prix d'un jeu de société
     *
     * @param jds le jeu de société dont on va modifier le prix
     * @return le jeu de société modifié
     */
    JeuSociete modifierJeuSociete(JeuSociete jds) throws ViewException;

    /**
     * Permet d'afficher est de choisir un jeu de société
     *
     * @param lesJds un Set trié par Auteur des jeu de société
     * @return le Jeu de société choisie
     */
    JeuSociete choisirJeuSociete(Set<JeuSociete> lesJds);

    /**
     * Permet d'afficher est de choisir un auteur
     *
     * @param lesAuteurs un Set des auteur
     * @return l'auteur choisi
     */
    Auteur choisirAuteur(Set<Auteur> lesAuteurs);

    /**
     * Permet d'afficher est de choisir une maison d'edition
     *
     * @param lesMaisonEditions un Set
     * @return la maison d'édition choisie
     */
    MaisonEdition choisirMaisonEdition(Set<MaisonEdition> lesMaisonEditions);


    /**
     * Permet d'afficher les jeu de société par catégorie
     * ceux-ci seront trié par ordre naturel
     *
     * @param jds un set des jeu de société de la catégorie
     */
    void afficherJeuSocieteParMecanisme(Set<JeuSociete> jds);

    /**
     * Permet d'afficher les maison d'édition suivi de leur jeux de société.
     *
     * @param jeuParMaisonEdition Map qui contient les Maisons d'édition et leurs jeux de société
     */
    void afficherMaisonEditionJeusociete(Map<MaisonEdition, List<JeuSociete>> jeuParMaisonEdition);

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
     * Permet d'afficher une facture de commande détaillée.
     * Le prix total avec application de la TVA est à prendre en compte
     *
     * @param commande Map de jeu de société avec la quantité.
     */
    void afficherCommande(Map<JeuSociete, Integer> commande);

    /**
     * Permet à l'utilisateur de choisir le Mécanisme
     *
     * @return un mécanisme choisi
     */
    Mecanisme choisirMecanisme();

    /**
     * Permet à l'utilisateur de choisir un mécanisme parmis ceux libre
     *
     * @param lesMecanismeJDS les mecanisme affectés à un jeu de société
     * @return le mécanisme choisi
     */
    Mecanisme choisirMecanisme(List<Mecanisme> lesMecanismeJDS);
	
	    /**
     * Permet à l'usager de saisir une Maison d'Edition
     * @return la maison fabriquée
     */
    MaisonEdition saisirMaisonEdition() throws ViewException;
}
