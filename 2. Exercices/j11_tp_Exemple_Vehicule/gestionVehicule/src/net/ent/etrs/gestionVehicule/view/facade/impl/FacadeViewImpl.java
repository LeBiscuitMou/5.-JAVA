package net.ent.etrs.gestionVehicule.view.facade.impl;

import net.ent.etrs.gestionVehicule.model.entities.EntitiesFactory;
import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.model.entities.exception.EntitiesFactoryExceptions;
import net.ent.etrs.gestionVehicule.model.references.Vignette;
import net.ent.etrs.gestionVehicule.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionVehicule.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionVehicule.view.facade.FacadeView;
import net.ent.etrs.gestionVehicule.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.gestionVehicule.view.facade.references.ConstanteView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeViewImpl implements FacadeView {
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
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, "Gestion de vehicules");
    }

    @Override
    public void afficherVehicules(List<Vehicule> lesVehicules) {
        List<String> vehiculeString = Collections.singletonList(lesVehicules.toString());
        AffichageConsole.afficherMenuSimple(vehiculeString);
    }

    @Override
    public float saisirConsommation() {
        return (float) LectureConsole.lectureDouble("Saisir la consommation de la voiture");
    }

    @Override
    public LocalDate saisirDateSortie() {
        return LectureConsole.lectureLocalDate("Saisir la date de sortie de la voiture (" + ConstanteView.PATTERN_DATE + ")", ConstanteView.PATTERN_DATE);
    }

    @Override
    public Vehicule selectionnerVehicule(List<Vehicule> lesVehicules) throws FacadeViewException {
        if (lesVehicules.size() == 0) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_VEHICULE);
        }
        List<String> lesVehiculesString = new ArrayList<>();
        for (Vehicule v :
                lesVehicules) {
            lesVehiculesString.add(v.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lesVehiculesString);
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner le véhicule");
        int choix = LectureConsole.lectureChoixInt(0, lesVehiculesString.size());
        return lesVehicules.get(choix - 1);
    }

    @Override
    public Vehicule creerVehicule() throws FacadeViewException {
        String immat = LectureConsole.lectureChaineCaracteres("Saisir l'immat de la voiture");
        LocalDate dateSortie = saisirDateSortie();
        int nbLitres = LectureConsole.lectureEntier("Saisir le nombre de litres de la voiture");
        float consommation = saisirConsommation();
        List<String> vignettes = new ArrayList<>();
        for (Vignette vi :
                Vignette.values()) {
            vignettes.add(vi.toString().toUpperCase());
        }
        afficherMessage("Saisir le classement pollution");
        AffichageConsole.afficherMenuSimple(vignettes);
        int choixClassementPollution = LectureConsole.lectureChoixInt(0, vignettes.size());

        try {
            return EntitiesFactory.fabriquerVehicule(immat, dateSortie, nbLitres, consommation, Vignette.valueOf(vignettes.get(choixClassementPollution - 1)));
        } catch (EntitiesFactoryExceptions e) {
            throw new FacadeViewException(ConstanteView.FACADE_CREATE_VEHICULE_ERROR, e);
        }
    }
}