package net.ent.etrs.pjjeudesociete.presenter;

import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.comparator.ComparatorJeuSocieteByAuteur;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.models.facade.exception.BusinessException;
import net.ent.etrs.pjjeudesociete.presenter.exception.PresenteurException;
import net.ent.etrs.pjjeudesociete.presenter.references.ConstantesPresenteur;
import net.ent.etrs.pjjeudesociete.views.exception.ViewException;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;

import java.util.*;

public class Presenteur {

    FacadeMetier facadeMetier;

    FacadeView facadeView;

    private boolean estInitialise;

    public Presenteur(FacadeMetier facadeMetier, FacadeView facadeView) throws PresenteurException {
        this.setFacadeMetier(facadeMetier);
        this.setFacadeView(facadeView);
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if (Objects.isNull(facadeMetier)) {
            throw new PresenteurException(ConstantesPresenteur.FACADE_MET_ERROR);
        }
        this.facadeMetier = facadeMetier;
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if (Objects.isNull(facadeView)) {
            throw new PresenteurException(ConstantesPresenteur.FACADE_VIEW_ERROR);
        }
        this.facadeView = facadeView;
    }

    public void start() {
        int choix;
        do {
            List<String> menu = facadeView.afficherMenuPrincipal();
            choix = facadeView.lectureChoix(menu.size());
            gererChoix(choix);
        } while (choix != 0);

    }

    private void gererChoix(int choix) {
        switch (choix) {
            case 1 -> initialiser();
            case 2 -> creerAuteur();
            case 3 -> creerMaisonEdition();
            case 4 -> creerJeuSociete();
            case 5 -> miseJeuSociete();
            case 6 -> afficherJeuByMecanisme();
            case 7 -> afficherMaisonEditJeuSociete();
            case 8 -> creerCommandeJeuSociete();
        }
    }

    private void creerMaisonEdition() {
        try {
            //Saisir information maison Edition
            MaisonEdition maison = this.facadeView.saisirMaisonEdition();
            //Sauvegarder maison Edition
            this.facadeMetier.creerMaisonEdition(maison);
        } catch (BusinessException | ViewException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerCommandeJeuSociete() {
        Map<JeuSociete, Integer> commande = new HashMap<>();
        try {
            do {
                //Selectionner un Jeu de Société
                Set<JeuSociete> setJds = new HashSet<>(this.facadeMetier.getlesJeuSociete());
                JeuSociete jds = this.facadeView.choisirJeuSociete(setJds);
                //Ajouter à la map tant que la commande n'est pas finie
                commande.put(jds, 1);
            } while (this.facadeView.lectureChoixBoolean());

            //Afficher la commande détaillée
            this.facadeView.afficherCommande(commande);
        } catch (BusinessException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void afficherMaisonEditJeuSociete() {

        try {
            //Afficher les Maison d'édition
            facadeView.afficherMaisonEditionJeusociete(this.facadeMetier.getLesMaisonEditionAvecJeuSociete());
        } catch (BusinessException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherJeuByMecanisme() {
        //Choisir le Mecanisme
        Mecanisme mecanisme = this.facadeView.choisirMecanisme();
        //Récupérer les jeu de société par mécanismes
        Set<JeuSociete> listTriee = new TreeSet<>(facadeMetier.getLesJeuSocieteParMecanisme(mecanisme));
        // Les trié par Auteur
        this.facadeView.afficherJeuSocieteParMecanisme(listTriee);

    }

    private void miseJeuSociete() {
        try {
            //Lister les Jeux de société
            Set<JeuSociete> listTriee = new TreeSet<>(new ComparatorJeuSocieteByAuteur());
            listTriee.addAll(this.facadeMetier.getlesJeuSociete());

            // Utilisateur choisi un jeux
            JeuSociete jds = this.facadeView.choisirJeuSociete(listTriee);
            // mise à jour de son prix
            jds = this.facadeView.modifierJeuSociete(jds);
            //sauvegarde du Jeu

            this.facadeMetier.sauvegarderJeuSociete(jds);
        } catch (BusinessException | ViewException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerJeuSociete() {
        try {
            //Saisir un jeu de société

            // Selectionner un Auteur
            Set<Auteur> lesAuteurs = new HashSet<>(this.facadeMetier.getlesAuteurs());
            //Selectionner une maison d'édition
            Set<MaisonEdition> LesMAisonsEdition = new HashSet<>(this.facadeMetier.getLesMaisonEdition());
            JeuSociete jds = this.facadeView.saisirJeuSociete(lesAuteurs, LesMAisonsEdition);
            //sauvegarder le jeu
            this.facadeMetier.sauvegarderJeuSociete(jds);
        } catch (BusinessException | ViewException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerAuteur() {

        try {
            //Saisir information auteur
            Auteur auteur = this.facadeView.saisirAuteur();
            //Sauvegarder auteur
            this.facadeMetier.creerAuteur(auteur);
        } catch (BusinessException | ViewException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    /**
     * Methode fournie
     */
    private void initialiser() {
        if (!estInitialise) {
            List<String> lstInit = new ArrayList<>();
            lstInit.add("Small World Of Warcraft;2;5;48.55;Days of wonder;01/01/2002;France;Keyaerts;Phillipe;Affrontement;Des");
            lstInit.add("Turing Machine;1;4;30.51;le Scorpion masqué;01/01/2006;Canada;Gridel;Fabien;Déduction;Logique");
            lstInit.add("Root;1;6;71.96;Matagot;01/01/2005;France;Wehrle;Cole;Pouvoirs;Asymétrie");
            lstInit.add("KingDomino;2;4;19.9;Blue Orange;18/11/2005;France;Cathala;Bruno;Tuiles;Placement");
            lstInit.add("Maui;2;4;22.05;Next Move;01/07/2017;France;Largey;Grégoire;Placement;Tuiles");
            lstInit.add("Azul : Les Vitraux de Sintra;2;4;36.45;Next Move;01/07/2017;France;Kiesling;Micheal;Tuiles;Placement;Collection");
            lstInit.add("Les Aventuriers du Rail - Europe 15ème Anniversaire;2;5;81;Days of wonder;01/01/2002;France;Moon;Alan;Collection");
            lstInit.add("Carcasonne;2;5;28.35;Zman Games;01/07/1999;USA;Wrede;Klaus-Jürgen;Majorité;Tuiles;Placement");
            lstInit.add("Agricola;1;4;44.91;Funforge;01/01/2008;FRANCE;Franz;Klemens;Développement;Placement");
            lstInit.add("Isle of Skye;2;5;23.92;Funforge;01/01/2008;FRANCE;Franz;Klemens;Tuiles;Placement");
            lstInit.add("Les Aventuriers du Rail - Berlin;2;4;22.5;Days of wonder;01/01/2002;France;Moon;Alan;Placement");
            lstInit.add("Save The Meeples;2;4;40.5;Blue Cocker;25/08/2013;France;Sireix;Florian;Affrontement");
            lstInit.add("Zombicide - Undead or Alive;1;6;99.95;Cmon;15/06/2003;USA;Raoult;Nicolas;Affrontement;Coopératif");
            lstInit.add("Colt Express - Convoyeurs & Train blindé;2;6;26.9;Ludonaute;14/03/2010;FRANCE;Valbuena;Jordi;Combinaison;Affrontement;Pouvoirs");
            lstInit.add("Tranquillité;1;5;10.8;Lucky Duck Games;05/05/2006;USA;Emmerson;James;Coopératif;Déduction");
            lstInit.add("The 7th Continent;1;4;69;Serious Poulp;30/05/2010;France;Roudy;Ludovic;Coopératif;Cartes");
            lstInit.add("Clash of Cultures - Monumental Edition;2;4;160;Matagot;01/01/2005;France;Wehrle;Cole;Placement;Pouvoirs;Logique");
            lstInit.add("Perfect Shot;2;4;17.9;Matagot;01/01/2005;France;Caterdjian;Romain;Placement;Collection;Cartes");
            lstInit.add("Cairn;2;2;27.9;Matagot;01/01/2005;France;Martinez;Christian;Affrontement;Placement");
            lstInit.add("Kingdomino Duel;2;2;14.5;Blue Orange;18/11/2005;France;Cathala;Bruno;Combinaison;Des;Placement");
            lstInit.add("Queendomino XL;2;4;63.9;Blue Orange;18/11/2005;France;Cathala;Bruno;Combinaison;Des;Placement");
            lstInit.add("7 Wonders Duel;2;2;22.95;Repos Production;01/08/2005;France;Cathala;Bruno;Affrontement;Cartes");
            lstInit.add("Abyss;2;4;44.95;Bombyx;01/06/2011;France;Cathala;Bruno;Développement;Combinaison");
            lstInit.add("Five Tribes;2;4;55;Days of wonder;01/01/2002;France;Cathala;Bruno;Placement;Cartes");
            lstInit.add("Kiwara;2;2;17.01;Oz Editions;01/04/2016;France;Cathala;Bruno;Pouvoirs;Placement");
            lstInit.add("Splendor Duel;2;2;22.95;Space Cowboys;02/02/2013;France;Cathala;Bruno;Combinaison;Développement;Collection");

            try {
                this.facadeMetier.initialisation(lstInit);
                estInitialise = true;
            } catch (BusinessException e) {
                facadeView.afficherMessageErreur(e.getMessage());
            }
        } else {
            this.facadeView.afficherMessage("L'initialisation a déjà été effectuée.");
        }
    }

}
