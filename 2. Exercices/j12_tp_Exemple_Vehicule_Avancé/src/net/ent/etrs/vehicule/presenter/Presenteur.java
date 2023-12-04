package net.ent.etrs.vehicule.presenter;

import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.facade.FacadeMetier;
import net.ent.etrs.vehicule.model.facade.exceptions.FacadeException;
import net.ent.etrs.vehicule.model.facade.impl.FacadeFactory;
import net.ent.etrs.vehicule.view.commons.utils.AffichageConsole;
import net.ent.etrs.vehicule.view.commons.utils.LectureConsole;
import net.ent.etrs.vehicule.view.facade.FacadeView;
import net.ent.etrs.vehicule.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.vehicule.view.facade.impl.FacadeFactoryView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenteur {
    private static final FacadeMetier facadeMetier = FacadeFactory.fabriquerFacadeMetier();
    private static final FacadeView facadeView = FacadeFactoryView.fabriquerFacadeView();


    private static void traitementMenuPrincipal(int choix) {
        switch (choix) {
            case 0:
                //sortie
                break;
            case 1:
                creerVehicule();
                break;
            case 2:
                afficherToutLesVéhicule();
                break;
            case 3:
                afficherVehiculeSortieAvant();
                break;
            case 4:
                afficherVehiculeConsoSup();
                break;
            case 5:
                supprimerVehicule();
                break;
            default:
                facadeView.afficherMessageErreur("Anomalie Switch Présenteur !");
                break;
        }
    }

    private static List<String> initMenuPrincipal() {
        List<String> retour = new ArrayList<>();
        retour.add("Créer un véhicule");
        retour.add("Afficher tout les véhicule");
        retour.add("Afficher les véhicule sortie avant ...");
        retour.add("Afficher les véhicule ayant une conso supérieur à ....");
        retour.add("Supprimer véhicule");

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

    private static void creerVehicule(){
        try {
            Vehicule v = facadeMetier.sauvegarderVehicule(facadeView.creerVehicule());
            facadeView.afficherMessage("Véhicule : +"+v.getImmat()+" sauvegarder");
        } catch (FacadeException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }
    private static void supprimerVehicule(){
        try{
            Vehicule v = facadeView.selectionnerVehicule(facadeMetier.selectionnerToutLesVehicule());
            facadeMetier.supprimerUnVehicule(v);
            facadeView.afficherMessage("Véhicule : +"+v.getImmat()+" supprimer");
        } catch (FacadeException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }
    private static void afficherToutLesVéhicule(){

        facadeView.afficherLesVehicule(facadeMetier.selectionnerToutLesVehicule());
    }
    private static void afficherVehiculeSortieAvant(){
        try {

            facadeView.afficherLesVehicule(facadeMetier.vehiculeSortieAvantDate(facadeView.saisieDate()));
        } catch (FacadeException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }
    private static void afficherVehiculeConsoSup(){
        facadeView.afficherLesVehicule(facadeMetier.vehiculeConsoSupA(facadeView.saisieConso()));
    }
}
