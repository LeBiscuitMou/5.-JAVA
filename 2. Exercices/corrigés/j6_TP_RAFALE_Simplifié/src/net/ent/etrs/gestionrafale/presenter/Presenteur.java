package net.ent.etrs.gestionrafale.presenter;

import net.ent.etrs.gestionrafale.model.entities.Rafale;
import net.ent.etrs.gestionrafale.model.entities.RafaleAir;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierBombeException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierMissileException;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.model.facades.FacadeMetierRafale;
import net.ent.etrs.gestionrafale.model.facades.exception.RafaleFacadeException;
import net.ent.etrs.gestionrafale.model.facades.impl.FacadeFactory;
import net.ent.etrs.gestionrafale.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionrafale.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionrafale.view.facade.FacadeViewRafale;
import net.ent.etrs.gestionrafale.view.facade.exception.FacadeViewRafaleException;
import net.ent.etrs.gestionrafale.view.facade.impl.FacadeFactoryView;

import java.util.ArrayList;
import java.util.List;

public class Presenteur {

    private static FacadeMetierRafale facadeMetierRafale = FacadeFactory.fabriquerFacadeMetierRafale();

    private static FacadeViewRafale facadeView = FacadeFactoryView.fabriquerFacadeViewRafale();

    private static void traitementMenuPrincipal(int choix) {
        switch (choix) {
            case 1:
                creerRafale();
                break;
            case 2:
                afficherRafaleAvecArmenent();
                break;
            case 3:
                afficherTousLesRafales();
                break;
            case 4:
                ajouterBombeRafale();
                break;
            case 5:
                ajouterMissileRafale();
                break;
            case 6:
                supprimerRafale();
                break;
            default:
                break;
        }

    }

    private static void afficherTousLesRafales() {
        List<String> afficherLesRafales = new ArrayList<>();
        for (Rafale r : facadeMetierRafale.selectionnerTousLesRafales()) {
            afficherLesRafales.add(String.format("Rafale Immatriculation : %s", r.getIdentificationRafale()));
        }
        AffichageConsole.afficherMenuSimple(afficherLesRafales);
    }

    private static void ajouterBombeRafale() {
        try {
            Rafale r = facadeView.selectionnerRafale(facadeMetierRafale.selectionnerTousLesRafales());
            Bombe b = facadeView.selectionnerBombe();

            facadeMetierRafale.ajouterBombeRafale(r.getIdentificationRafale(), b);
            facadeView.afficherMessage("Bombe Ajoutée");
        } catch (RafaleMetierBombeException | RafaleFacadeException | FacadeViewRafaleException e) {
            AffichageConsole.afficherMessageAvecSautLigne(e.getMessage());
        }
    }

    private static void ajouterMissileRafale() {
        try {
            Rafale r = facadeView.selectionnerRafale(facadeMetierRafale.selectionnerTousLesRafales());
            MissileAA missileAA = facadeView.selectionnerMissile();


            facadeMetierRafale.ajouterMissileAARafale(r.getIdentificationRafale(), missileAA);
            facadeView.afficherMessage("Missile AA Ajouté");
        } catch (RafaleMetierMissileException | RafaleFacadeException | FacadeViewRafaleException e) {
            AffichageConsole.afficherMessageAvecSautLigne(e.getMessage());
        }
    }

    private static void supprimerRafale() {

        try {
            Rafale r = facadeView.selectionnerRafale(facadeMetierRafale.selectionnerTousLesRafales());
            facadeMetierRafale.supprimerRafale(r.getIdentificationRafale());
            facadeView.afficherMessage("Rafale Supprimé");
        } catch (RafaleFacadeException | FacadeViewRafaleException e) {

        }
    }

    private static void afficherRafaleAvecArmenent() {
        Rafale r = null;
        try {
            r = facadeView.selectionnerRafale(facadeMetierRafale.selectionnerTousLesRafales());
            facadeView.affichageDetailRafale(r);
        } catch (FacadeViewRafaleException e) {
            AffichageConsole.afficherMessageAvecSautLigne(e.getMessage());
        }

    }

    private static void creerRafale() {
        try {
            Rafale r = facadeView.creerRafale();
            if (r instanceof RafaleAir ra) {
                facadeMetierRafale.creerRafale(r.getIdentificationRafale(), r.getNombrePilote(), r.getCarburantInterne(), ra.isPossedeBombeNucleaire());
            }

        } catch (FacadeViewRafaleException | RafaleMetierException | RafaleFacadeException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private static List<String> initMenuPrincipal() {
        List<String> retour = new ArrayList<>();
        retour.add("Créer un Rafale");
        retour.add("Afficher un Rafale avec son Armement");
        retour.add("Afficher tous les Rafales");
        retour.add("Ajouter une bombe à un Rafale");
        retour.add("Ajouter un missile Anti-Aérien à un Rafale");
        retour.add("Supprimer un Rafale");

        return retour;
    }

    public void init() {
        List<String> menuPrincipale = initMenuPrincipal();
        int choix;
        do {
            facadeView.afficherMenuPrincipal(menuPrincipale);
            choix = LectureConsole.lectureChoixInt(0, menuPrincipale.size());
            traitementMenuPrincipal(choix);
        } while (choix != 0);
    }
}
