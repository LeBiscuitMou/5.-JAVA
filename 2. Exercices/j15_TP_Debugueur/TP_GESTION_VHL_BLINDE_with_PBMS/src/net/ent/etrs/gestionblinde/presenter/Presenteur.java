package net.ent.etrs.gestionblinde.presenter;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.FacadeMetierFactory;
import net.ent.etrs.gestionblinde.model.facades.FacadeMetierVehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.exceptions.FacadeException;
import net.ent.etrs.gestionblinde.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionblinde.view.facades.FacadeVueVehiculeBlinde;
import net.ent.etrs.gestionblinde.view.facades.impl.FacadeViewFactory;

import java.util.ArrayList;
import java.util.List;

public class Presenteur {

    private static final FacadeMetierVehiculeBlinde facadeMetier = FacadeMetierFactory.fabriquerFacadeMetier();
    private static final FacadeVueVehiculeBlinde facadeView = FacadeViewFactory.fabriquerFacadeVueVehiculeBlinde();

    private static void traitementMenuPrincipal(int choix) {
        switch (choix) {
            case 0:
                //sortie
                break;
            case 1:
                creerVehicule();
                break;
            case 2:
                afficherToutLesVehicule();
                break;
            case 3:
                supprimerVehicule();
                break;
            default:
                facadeView.afficherMessageErreur("Anomalie Switch Présenteur !");
                break;
        }
    }

    public void start() {
        List<String> menuPrincipale = initMenuPrincipal();
        int choix;
        do {
            facadeView.afficherMenuPrincipal(menuPrincipale);
            choix = LectureConsole.lectureChoixInt(0, menuPrincipale.size());
            traitementMenuPrincipal(choix);
        } while (choix != 0);
    }

    private static List<String> initMenuPrincipal() {
        List<String> retour = new ArrayList<>();

        retour.add("Créer un véhicule");
        retour.add("Afficher tous les véhicules");
        retour.add("Supprimer véhicule");

        return retour;
    }

    private static void supprimerVehicule() {
        VehiculeBlinde vehiculeBlinde;
    }

    private static void afficherToutLesVehicule() {
        try {
            facadeView.afficherLesVHL(facadeMetier.selectionnerTousVehiculeBlinde());
        } catch (FacadeException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private static void creerVehicule() {
        try {
            VehiculeBlinde vehiculeBlinde = facadeMetier.ajouterVehiculeBlinde(facadeView.creerVehiculeBlinde());
            facadeView.afficherMessage("Véhicule : " + vehiculeBlinde.getEmmat8() + " sauvegardé");
        } catch (FacadeException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }
}
