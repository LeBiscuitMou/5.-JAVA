package net.ent.etrs.pjjeudesociete.views.facade.impl;

import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.EntitiesFactory;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.JeuSocieteException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.references.Pays;
import net.ent.etrs.pjjeudesociete.views.commons.utils.AffichageConsole;
import net.ent.etrs.pjjeudesociete.views.commons.utils.LectureConsole;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;
import net.ent.etrs.pjjeudesociete.views.facade.exceptions.FacadeViewException;
import net.ent.etrs.pjjeudesociete.views.references.ConstanteView;

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
     * Permet de saisir un nouveau jeu de société
     *
     * @param lesAuteursPossible le set des Auteur disponible
     * @param lesMAisonEditions  le set des Maison d'édition disponible
     * @return le nouveau jeu de société
     */
    @Override
    public JeuSociete saisirJeuSociete(Set<Auteur> lesAuteursPossible, Set<MaisonEdition> lesMAisonEditions) throws FacadeViewException {
        afficherMessage(ConstanteView.SAISIR_JEU_DE_SOCIETE);
        List<Mecanisme> mecanismeList = new ArrayList<>();
        int nbJMin = LectureConsole.lectureEntier(ConstanteView.SAISIR_NB_JOUEUR_MIN);
        int nbJMax = LectureConsole.lectureEntier(ConstanteView.SAISIR_NB_JOUEUR_MAX);
        float prixHT = (float) LectureConsole.lectureDouble(ConstanteView.SAISIR_PRIX_HT);
        String nom = LectureConsole.lectureChaineCaracteres(ConstanteView.SAISIR_NOM_JDS);
        Auteur auteur = choisirAuteur(lesAuteursPossible);
        MaisonEdition maisonEdition = choisirMaisonEdition(lesMAisonEditions);

        try {
            return EntitiesFactory.fabriquerJeuSociete(nbJMax, mecanismeList, nbJMin, prixHT, maisonEdition, nom, auteur);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATION_JDS, e);
        }
    }

    /**
     * Permet de saisir un nouvel auteur
     *
     * @return le nouvel auteur
     */
    @Override
    public Auteur saisirAuteur() throws FacadeViewException {
        afficherMessage(ConstanteView.SAISIR_AUTEUR);
        String nom = LectureConsole.lectureChaineCaracteres(ConstanteView.SAISIR_NOM_AUTEUR);
        String prenom = LectureConsole.lectureChaineCaracteres(ConstanteView.SAISIR_PRENOM_AUTEUR);

        try {
            return EntitiesFactory.fabriquerAuteur(nom, prenom);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATION_AUTEUR_ERROR, e);
        }
    }

    /**
     * Permet de modifier le prix d'un jeu de société
     *
     * @param jds le jeu de société dont on va modifier le prix
     * @return le jeu de société modifié
     */
    @Override
    public JeuSociete modifierJeuSociete(JeuSociete jds) throws FacadeViewException {
        float nouveauPrixHT = (float) LectureConsole.lectureDouble(ConstanteView.SAISIR_NOUVEAU_PRIX);
        try {
            jds.setPrixHT(nouveauPrixHT);
            return jds;
        } catch (JeuSocieteException e) {
            throw new FacadeViewException(e);
        }
    }

    /**
     * Permet d'afficher est de choisir un jeu de société
     *
     * @param lesJds un Set trié par Auteur des jeu de société
     * @return le Jeu de société choisie
     */
    @Override
    public JeuSociete choisirJeuSociete(Set<JeuSociete> lesJds) {
        List<String> lesJdsString = new ArrayList<>();
        for (JeuSociete jeuSociete : lesJds) {
            lesJdsString.add(jeuSociete.toString());
        }
        AffichageConsole.afficherMenuSimple(lesJdsString);
        afficherMessage(ConstanteView.SELECTIONNER_JEU_SOCIETE);
        int choix = lectureChoix(lesJdsString.size());
        return (JeuSociete) lesJds.toArray()[choix - 1];
    }

    /**
     * Permet d'afficher est de choisir un auteur
     *
     * @param lesAuteurs un Set des auteur
     * @return l'auteur choisi
     */
    @Override
    public Auteur choisirAuteur(Set<Auteur> lesAuteurs) {
        List<String> lesAuteursString = new ArrayList<>();
        for (Auteur auteur : lesAuteurs) {
            lesAuteursString.add(auteur.toString());
        }
        AffichageConsole.afficherMenuSimple(lesAuteursString);
        afficherMessage(ConstanteView.SELECTIONNER_AUTEUR);
        int choix = lectureChoix(lesAuteursString.size());
        return (Auteur) lesAuteurs.toArray()[choix - 1];
    }

    /**
     * Permet d'afficher est de choisir une maison d'edition
     *
     * @param lesMaisonEditions un Set
     * @return la maison d'édition choisie
     */
    @Override
    public MaisonEdition choisirMaisonEdition(Set<MaisonEdition> lesMaisonEditions) {
        List<String> lesMaisonsEditionsString = new ArrayList<>();
        for (MaisonEdition maisonEdition : lesMaisonEditions) {
            lesMaisonsEditionsString.add(maisonEdition.toString());
        }
        AffichageConsole.afficherMenuSimple(lesMaisonsEditionsString);
        afficherMessage(ConstanteView.SELECTIONNER_MAISON);
        int choix = lectureChoix(lesMaisonsEditionsString.size());
        return (MaisonEdition) lesMaisonEditions.toArray()[choix - 1];
    }

    /**
     * Permet d'afficher les jeu de société par catégorie
     * ceux-ci seront trié par ordre naturel
     *
     * @param jds un set des jeu de société de la catégorie
     */
    @Override
    public void afficherJeuSocieteParMecanisme(Set<JeuSociete> jds) {
        choisirMecanisme();
        StringBuilder affichage = new StringBuilder();
        int i = 1;
        for (JeuSociete jeuSociete : jds) {
            affichage.append("Jeu numéro ").append(i).append(" :\n");
            affichage.append("\tNom: ").append(jeuSociete.getNom()).append("\n");
            affichage.append("\tNombre de joueurs: ").append(jeuSociete.getNbJoueurMin()).append(" - ").append(jeuSociete.getNbJoueurMax()).append("\n");
            affichage.append("\tMaison d'Edition: ").append(jeuSociete.getMaisonEdition().getNom()).append("\n");
            affichage.append("\tAuteur: ").append(jeuSociete.getAuteur().getNom()).append(jeuSociete.getAuteur().getPrenom()).append("\n");
            i++;
        }
        afficherMessage(affichage.toString());
    }

    /**
     * Permet d'afficher les maison d'édition suivi de leur jeux de société.
     *
     * @param jeuParMaisonEdition Map qui contient les Maisons d'édition et leurs jeux de société
     */
    @Override
    public void afficherMaisonEditionJeusociete(Map<MaisonEdition, List<JeuSociete>> jeuParMaisonEdition) {
        StringBuilder affichage = new StringBuilder();
        for (Map.Entry<MaisonEdition, List<JeuSociete>> entry : jeuParMaisonEdition.entrySet()) {
            affichage.append(entry.getKey().toString()).append('\n');
            for (JeuSociete jeuSociete : entry.getValue()) {
                affichage.append(String.format("%s%s", "\t+", jeuSociete.getNom()));
            }
        }
        afficherMessage(affichage.toString());
    }

    /**
     * Permet d'afficher le menu principal en le construisant
     *
     * @return la liste contenant le menu principal
     */
    @Override
    public List<String> afficherMenuPrincipal() {
        List<String> listOptions = new ArrayList<>();
        listOptions.add("Ajouter un jeu de société");
        listOptions.add("Modifier prix jeu de société");
        listOptions.add("Ajouter un auteur");
        listOptions.add("Ajouter maison d'édition");
        listOptions.add("Afficher jeux par mécanisme");
        listOptions.add("Afficher maisons d'édition avec leurs jeux de société");
        listOptions.add("Créer une commande");
        listOptions.add("Quitter le programme");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < listOptions.size(); i++) {
            map.put(i + 1, listOptions.get(i));
        }
        AffichageConsole.afficherMenuEntoure(map, ConstanteView.NOM_PROGRAMME);
        return listOptions;
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
        return LectureConsole.lectureBoolean(ConstanteView.OUI_NON);
    }

    /**
     * Permet d'afficher une facture de commande détaillée.
     * Le prix total avec application de la TVA est à prendre en compte
     *
     * @param commande Map de jeu de société avec la quantité.
     */
    @Override
    public void afficherCommande(Map<JeuSociete, Integer> commande) {

    }

    /**
     * Permet à l'utilisateur de choisir le Mécanisme
     *
     * @return un mécanisme choisi
     */
    @Override
    public Mecanisme choisirMecanisme() {
        List<String> lsMeca = new ArrayList<>();
        for (Mecanisme mecanisme : Mecanisme.values()) {
            lsMeca.add(mecanisme.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lsMeca);
        afficherMessage(ConstanteView.SELECTIONNER_MECANISME);
        int choix = lectureChoix(lsMeca.size());
        return Mecanisme.values()[choix - 1];
    }

    /**
     * Permet à l'utilisateur de choisir un mécanisme parmis ceux libre
     *
     * @param lesMecanismeJDS les mecanisme affectés à un jeu de société
     * @return le mécanisme choisi
     */
    @Override
    public Mecanisme choisirMecanisme(List<Mecanisme> lesMecanismeJDS) {
        List<String> lsMeca = new ArrayList<>();
        for (Mecanisme mecanisme : lesMecanismeJDS) {
            lsMeca.add(mecanisme.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lsMeca);
        afficherMessage(ConstanteView.SELECTIONNER_MECANISME);
        int choix = lectureChoix(lsMeca.size());
        return Mecanisme.values()[choix - 1];
    }

    /**
     * Permet à l'usager de saisir une Maison d'Edition
     *
     * @return la maison fabriquée
     */
    @Override
    public MaisonEdition saisirMaisonEdition() throws FacadeViewException {
        afficherMessage(ConstanteView.SAISIR_MAISON_EDITION);
        String nom = LectureConsole.lectureChaineCaracteres(ConstanteView.SAISIR_NOM_MAISON_EDITION);
        LocalDate date = LectureConsole.lectureLocalDate(ConstanteView.SAISIR_DATE_FONDATION_MAISON_EDITION, ConstanteView.DATE_PATTERN);
        Pays pays = selectionnerPays();

        try {
            return EntitiesFactory.fabriquerMaisonEdition(nom, date, pays);
        } catch (EntitiesFactoryException e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATION_ME_ERROR, e);
        }
    }

    public Pays selectionnerPays() {
        List<String> lsPays = new ArrayList<>();
        for (Pays pays : Pays.values()) {
            lsPays.add(pays.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lsPays);
        afficherMessage(ConstanteView.SELECTIONNER_PAYS);
        int choix = lectureChoix(lsPays.size());
        return Pays.values()[choix - 1];
    }
}