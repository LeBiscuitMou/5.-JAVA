package net.ent.etrs.pjjeudesociete.views.facade.impl;

import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.EntitiesFactory;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.JeuSocieteException;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.entities.references.Pays;
import net.ent.etrs.pjjeudesociete.views.commons.utils.AffichageConsole;
import net.ent.etrs.pjjeudesociete.views.commons.utils.LectureConsole;
import net.ent.etrs.pjjeudesociete.views.commons.utils.Utils;
import net.ent.etrs.pjjeudesociete.views.exception.ViewException;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;
import net.ent.etrs.pjjeudesociete.views.references.ConstantesView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class FacadeViewImpl implements FacadeView {
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

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
    public JeuSociete saisirJeuSociete(Set<Auteur> lesAuteursPossible, Set<MaisonEdition> lesMAisonEditions) throws ViewException {
        //Info du Jeu societe
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom du jeu");
        int nbMinJoueur = LectureConsole.lectureEntier("Nombre de joueurs au minimum :");
        int nbMaxJoueur = LectureConsole.lectureEntier("Nombre de joueurs au maximum :");
        while (nbMaxJoueur < nbMinJoueur) {
            AffichageConsole.afficherMessageAvecSautLigne("Le nombre de joueur maximal est inférieur au minimum");
            nbMaxJoueur = LectureConsole.lectureEntier("Nombre de joueurs au maximum :");
        }
        float prix = LectureConsole.lectureFloat("Saissir le prix du jeu de société");


        //Info Auteur
        Auteur a = choisirAuteur(lesAuteursPossible);
        //Info Maison d'Edition
        MaisonEdition me = choisirMaisonEdition(lesMAisonEditions);

        //Les mecanisme
        List<Mecanisme> lesMecanismes = new ArrayList<>();
        do {
            lesMecanismes.add(choisirMecanisme(lesMecanismes));
        } while (LectureConsole.lectureBoolean("Souhaitez-vous ajouter un autre mécanisme?"));

        try {
            return EntitiesFactory.fabriquerJeuSociete(nom, nbMinJoueur, nbMaxJoueur, prix, a, me, lesMecanismes);
        } catch (EntitiesFactoryException e) {
            throw new ViewException(ConstantesView.VIEW_JDS_ERROR, e);
        }
    }

    /**
     * Permet de saisir un nouvel auteur
     *
     * @return le nouvel auteur
     */
    @Override
    public Auteur saisirAuteur() throws ViewException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de l'auteur");
        String prenom = LectureConsole.lectureChaineCaracteres("Saisir le prénom de l'auteur");
        try {
            return EntitiesFactory.fabriquerAuteur(nom, prenom);
        } catch (EntitiesFactoryException e) {
            throw new ViewException(ConstantesView.VIEW_AUTEUR_ERROR, e);
        }
    }

    @Override
    public JeuSociete modifierJeuSociete(JeuSociete jds) throws ViewException {
        try {
            jds.setPrixHT(LectureConsole.lectureFloat("Saisir le nouveau prix HT"));
        } catch (JeuSocieteException e) {
            throw new ViewException(ConstantesView.VIEW_JDS_PRIX_ERROR, e);
        }
        return jds;
    }

    /**
     * Permet d'afficher est de choisir un jeu de société
     *
     * @param lesJds un Set trié par Auteur des jeu de société
     * @return le Jeu de société choisie
     */
    @Override
    public JeuSociete choisirJeuSociete(Set<JeuSociete> lesJds) {

        return Utils.récupérationObjet(lesJds);
    }

    /**
     * Permet d'afficher est de choisir un auteur
     *
     * @param lesAuteurs un Set des auteur
     * @return l'auteur choisi
     */
    @Override
    public Auteur choisirAuteur(Set<Auteur> lesAuteurs) {

        return Utils.récupérationObjet(lesAuteurs);
    }

    /**
     * Permet d'afficher est de choisir une maison d'edition
     *
     * @param lesMaisonEditions un Set
     * @return la maison d'édition choisie
     */
    @Override
    public MaisonEdition choisirMaisonEdition(Set<MaisonEdition> lesMaisonEditions) {
        return Utils.récupérationObjet(lesMaisonEditions);
    }

    @Override
    public void afficherJeuSocieteParMecanisme(Set<JeuSociete> jds) {
        for (JeuSociete j : jds) {
            afficherMessage(String.format("Nom : %s%n " +
                            "Nombre de Joueur : %s - %s%n" +
                            "Maison d'Edition : %s%n" +
                            "Auteur : %s%n",
                    j.getNom(), j.getNbJoueurMin(), j.getNbJoueurMax(), j.getMaisonEdition().getNom(), j.getAuteur().getNom()));
            afficherMessage("Mecanismes :");
            for (Mecanisme m : j.getMecanismes()) {
                afficherMessage(String.format("- %s", m.name()));
            }
        }

    }

    @Override
    public void afficherMaisonEditionJeusociete(Map<MaisonEdition, List<JeuSociete>> jeuParMaisonEdition) {
        for (Map.Entry<MaisonEdition, List<JeuSociete>> entry : jeuParMaisonEdition.entrySet()) {
            afficherMessage(String.format("- %s :", entry.getKey().getNom()));
            for (JeuSociete jds : entry.getValue()) {
                afficherMessage(String.format("%-10s", jds.getNom()));
            }
        }

    }

    @Override
    public List<String> afficherMenuPrincipal() {
        List<String> menuPrincipals = new ArrayList<>();
        menuPrincipals.add("Initialiser");
        menuPrincipals.add("creer un Auteur");
        menuPrincipals.add("creer une Maison d'Edition");
        menuPrincipals.add("creer un Jeu Societe");
        menuPrincipals.add("mise à jour d'un Jeu Societe");
        menuPrincipals.add("afficher Jeu par Categorie");
        menuPrincipals.add("afficher les Jeu de société d'une maison d'édition");
        menuPrincipals.add("Créer un commande de jeux de société");

        AffichageConsole.afficherMenuSimpleAvecOptionSortie(menuPrincipals, "Quitter");
        return menuPrincipals;
    }

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
        return LectureConsole.lectureBoolean("Souhaitez vous ajouter un autre jeu de société à votre commande");
    }

    @Override
    public void afficherCommande(Map<JeuSociete, Integer> commande) {
        float total = 0;
        for (Map.Entry<JeuSociete, Integer> entry : commande.entrySet()) {
            float calculPrix = (BigDecimal.valueOf(entry.getKey().getPrixHT() * entry.getValue())
                    .add(BigDecimal.valueOf(ConstantesView.TVA / 100)
                            .multiply(BigDecimal.valueOf(entry.getKey().getPrixHT())))).floatValue();
            afficherMessage(String.format("Jeu de société : %s, quantité : %s, prix = (%s*%s)+ TVA:%s=%s",
                    entry.getKey(), entry.getValue(), entry.getKey().getPrixHT(), entry.getValue(), ConstantesView.TVA, calculPrix));
            total += calculPrix;
        }
        afficherMessage(String.format("Prix total = %s", total));

    }

    /**
     * Permet à l'utilisateur de choisir le Mécanisme
     *
     * @return un mécanisme choisi
     */
    @Override
    public Mecanisme choisirMecanisme() {
        return Utils.récupérationObjet(Arrays.asList(Mecanisme.values()));
    }

    /**
     * Permet à l'utilisateur de choisir un mécanisme parmis ceux libre
     *
     * @param lesMecanismeJDS les mecanisme affectés à un jeu de société
     * @return le mécanisme choisi
     */
    @Override
    public Mecanisme choisirMecanisme(List<Mecanisme> lesMecanismeJDS) {
        List<Mecanisme> listMeca = Arrays.asList(Mecanisme.values());
        listMeca.removeAll(lesMecanismeJDS);
        return Utils.récupérationObjet(listMeca);
    }

    /**
     * Permet à l'usager de saisir une Maison d'Edition
     *
     * @return la maison fabriquée
     */
    @Override
    public MaisonEdition saisirMaisonEdition() throws ViewException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la maison d'édition");
        LocalDate dateCreation = LectureConsole.lectureLocalDate("Saisir la date de création de la Maison d'Edition", ConstantesView.PATTERN_GDH);
        Pays pays = Utils.récupérationObjet(Arrays.asList(Pays.values()));
        try {
            return EntitiesFactory.fabriquerMaisonEdition(nom, dateCreation, pays);
        } catch (EntitiesFactoryException e) {
            throw new ViewException(ConstantesView.VIEW_MAISON_ERROR, e);
        }
    }
}
