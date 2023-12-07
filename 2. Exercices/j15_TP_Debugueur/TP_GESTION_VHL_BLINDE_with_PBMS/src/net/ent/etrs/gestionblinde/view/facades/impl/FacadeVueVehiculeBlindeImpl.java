package net.ent.etrs.gestionblinde.view.facades.impl;

import net.ent.etrs.gestionblinde.model.entities.EntitiesFactory;
import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.exceptions.FacadeException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;
import net.ent.etrs.gestionblinde.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionblinde.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionblinde.view.facades.FacadeVueVehiculeBlinde;

import java.util.ArrayList;
import java.util.List;

public class FacadeVueVehiculeBlindeImpl implements FacadeVueVehiculeBlinde {
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMessageErreur(String message) {
AffichageConsole.afficherErreur(message);
    }

    @Override
    public void afficherMenuPrincipal(List<String> menu) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, "Menu principal");
    }

    @Override
    public void afficherLesVHL(List<VehiculeBlinde> vhls) throws FacadeException {
        for (VehiculeBlinde v:vhls) {
            AffichageConsole.afficherMessageAvecSautLigne(v.toString());
        }
    }

    @Override
    public VehiculeBlinde creerVehiculeBlinde() {
        String emmat8 = LectureConsole.lectureChaineCaracteres("Entrez l'emmat8 : ");
        Integer poids = LectureConsole.lectureEntier("Entrez le poids du véhicule blindé : ");
        return EntitiesFactory.fabriquerVhlTransportTroupes(emmat8, poids);
    }

    @Override
    public VehiculeBlinde supprimerVehiculeBlinde(List<VehiculeBlinde> vhls) throws FacadeException {
        if (vhls.isEmpty()) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_CREATE);
        }
        List<String> vhlsString = new ArrayList<>();

        for (VehiculeBlinde vehiculeBlinde : vhls) {
            vhlsString.add(vehiculeBlinde.toString());
        }

        AffichageConsole.afficherMenuSimple(vhlsString);
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner le véhicule à supprimer");
        int choix = LectureConsole.lectureChoixInt(0, vhlsString.size());

        return vhls.get(choix - 1);
    }
}
