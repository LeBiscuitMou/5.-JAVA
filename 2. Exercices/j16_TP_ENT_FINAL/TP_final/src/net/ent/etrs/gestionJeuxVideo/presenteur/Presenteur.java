package net.ent.etrs.gestionJeuxVideo.presenteur;

import net.ent.etrs.gestionJeuxVideo.models.entities.Console;
import net.ent.etrs.gestionJeuxVideo.models.entities.Fabriquant;
import net.ent.etrs.gestionJeuxVideo.models.facade.FacadeMetier;
import net.ent.etrs.gestionJeuxVideo.models.facade.exceptions.BusinessException;
import net.ent.etrs.gestionJeuxVideo.presenteur.exceptions.PresenteurException;
import net.ent.etrs.gestionJeuxVideo.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionJeuxVideo.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionJeuxVideo.view.facade.FacadeView;
import net.ent.etrs.gestionJeuxVideo.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.gestionJeuxVideo.view.references.ConstanteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private void initialiser() {
        List<String> lstInit = new ArrayList<>();
        lstInit.add("JEU;Diablo IV;05/06/2023;HNS;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;Overwatch;24/05/2016;Strategie;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;Overwatch 2;04/10/2022;MMORPG;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;League of Legends;27/10/2009;MOBA;Riot Games;22/09/2006;USA");
        lstInit.add("JEU;Valorant;02/06/2020;FPS;Riot Games;22/09/2006;USA");

        lstInit.add("CONSOLE;Playstation;SONY;16/11/1993;USA;JAPON;03/12/1994;USA;09/09/1995;FRANCE;29/09/1995");
        lstInit.add("CONSOLE;PS One;SONY;16/11/1993;USA;JAPON;14/07/2000;USA;19/09/2000;FRANCE;29/09/2000");
        lstInit.add("CONSOLE;PS 4;SONY;16/11/1993;USA;JAPON;22/02/2014;USA;15/11/2013;FRANCE;29/11/2013");
        lstInit.add("CONSOLE;PS 5;SONY;16/11/1993;USA;JAPON;12/11/2020;USA;12/11/2020;FRANCE;19/11/2020");
        lstInit.add("CONSOLE;Xbox Series X;Microsoft;04/04/1975;USA;JAPON;10/11/2020;USA;10/11/2020;FRANCE;10/11/2020");
        lstInit.add("CONSOLE;Xbox One;Microsoft;04/04/1975;USA;JAPON;04/09/2014;USA;22/11/2013;FRANCE;22/11/2013");

        try {
            this.facadeMetier.initialisation(lstInit);
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private static List<String> initMenuPrincipal() {
        List<String> retour = new ArrayList<>();
        retour.add("Créer une console");
        retour.add("Créer un fabriquant");
        retour.add("Créer un jeu-vidéo");
        retour.add("Ajouter une console à un jeu video");
        retour.add("Afficher les jeux video par un Genre --> trier par ordre naturel");
        retour.add("Afficher les jeux video par Console --> trier par Genre");
        retour.add("Afficher toutes les Consoles avec leurs jeux video");

        return retour;
    }

    private void traitementMenuPrincipal(int choix) {
        switch (choix) {
            case 1:
                creerConsole();
                break;
                
            case 2:
                creerFabriquant();
                break;
                
            case 3:
                creerJeuVideo();
                break;
                
            case 4:
                ajouterConsoleAJeuVideo();
                break;
                
            case 5:
                afficherJeuxVideosParGenre();
                break;
                
            case 6:
                afficherJeuxVideosParConsole();
                break;
                
            case 7:
                afficherToutesLesConsolesEtJeux();
                break;
                
            default:
                facadeView.afficherMessageErreur("SWITCH ANOMALIE CHOIX");
        }
    }

    private void afficherToutesLesConsolesEtJeux() {
    }

    private void afficherJeuxVideosParConsole() {
    }

    private void afficherJeuxVideosParGenre() {
    }

    private void ajouterConsoleAJeuVideo() {
    }

    private void creerJeuVideo() {
        try {
            facadeMetier.sauvergarderJeuVideo(facadeView.saisirJeuVideo(facadeMetier.recupererFabriquants()));
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerFabriquant() {
        try {
            facadeMetier.sauvegarderFabriquant(facadeView.saisirFabriquant());
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerConsole() {
        try {
            Console c = facadeView.saisirConsole(facadeMetier.recupererFabriquants());
            facadeMetier.sauvegarderConsole(c);
        } catch (FacadeViewException | BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    public void start() {
        List<String> menuPrincipale = initMenuPrincipal();
        int choix;
        do {
            facadeView.afficherMenuPrincipal();
            choix = facadeView.lectureChoix(menuPrincipale.size());
            traitementMenuPrincipal(choix);
        } while (choix != 0);
    }
}