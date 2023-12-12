package net.ent.etrs.pjjeudesociete.presenteur;

import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.models.facade.exceptions.BusinessException;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.references.Pays;
import net.ent.etrs.pjjeudesociete.presenteur.exceptions.PresenteurException;
import net.ent.etrs.pjjeudesociete.views.commons.utils.AffichageConsole;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;
import net.ent.etrs.pjjeudesociete.views.facade.exceptions.FacadeViewException;
import net.ent.etrs.pjjeudesociete.views.references.ConstanteView;

import java.util.*;

public class Presenteur {
    private FacadeView facadeView;
    private FacadeMetier facadeMetier;

    public Presenteur(FacadeView facadeView, FacadeMetier facadeMetier) throws PresenteurException {
        this.setFacadeView(facadeView);
        this.setFacadeMetier(facadeMetier);
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if (Objects.isNull(facadeView)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FACADE_VIEW_IS_NULL);
        }
        this.facadeView = facadeView;
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if (Objects.isNull(facadeMetier)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FACADE_METIER_IS_NULL);
        }
        this.facadeMetier = facadeMetier;
    }

    /**
     * Methode fournie
     */
    private void initialiser() {
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
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    public void start() {
        initialiser();
        boolean quitter = false;
        do {
            int choixMenu = facadeView.lectureChoix(facadeView.afficherMenuPrincipal().size());
            switch (choixMenu) {
                case 1 :
                    creerJeu();
                    break;
                case 2 :
                    modifierPrix();
                    break;
                case 3 :
                    creerAuteur();
                    break;
                case 4 :
                    creerMaisonEdition();
                    break;
                case 5 :
                    afficherJeuParMeca();
                    break;
                case 6 :
                    afficherMaisonEtJeux();
                    break;
                case 7 :
                    creerCommande();
                    break;
                case 8 :
                    facadeView.afficherMessage(ConstanteView.MESSAGE_SORTIE_PROGRAMME);
                    quitter = true;
                    break;
                default:
                    break;
            }
        } while (!quitter);
    }

    private void creerJeu() {
        try {
            facadeMetier.sauvegarderJeuSociete(facadeView.saisirJeuSociete());
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void modifierPrix() {
        try {
            Set<JeuSociete> jeuSocieteSet = Set.copyOf(facadeMetier.getlesJeuSociete());
            JeuSociete jeu = null;
            jeu = facadeView.modifierJeuSociete(facadeView.choisirJeuSociete(jeuSocieteSet));
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerAuteur() {
        try {
            facadeMetier.creerAuteur(facadeView.saisirAuteur());
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void creerMaisonEdition() {
        try {
            facadeMetier.creerMaisonEdition(facadeView.saisirMaisonEdition());
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherJeuParMeca() {
        Mecanisme mecanisme = facadeView.choisirMecanisme();
        try {
            List<JeuSociete> list = new ArrayList<>(facadeMetier.getLesJeuSocieteParMecanisme(mecanisme));
            if (list.isEmpty()) {
                facadeView.afficherMessage("Pas de jeu trouvé ayant le mécanisme " + mecanisme.toString());
            } else {
                Collections.sort(list);
                facadeView.afficherJeuSocieteParMecanisme(list);
            }
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherMaisonEtJeux() {
    }

    private void creerCommande() {
    }
}