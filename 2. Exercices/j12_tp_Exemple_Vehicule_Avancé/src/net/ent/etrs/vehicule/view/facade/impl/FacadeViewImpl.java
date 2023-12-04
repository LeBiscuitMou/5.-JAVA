package net.ent.etrs.vehicule.view.facade.impl;




import net.ent.etrs.vehicule.model.entities.EntitiesFactory;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.exceptions.FactoryException;
import net.ent.etrs.vehicule.model.references.Vignette;
import net.ent.etrs.vehicule.view.commons.utils.AffichageConsole;
import net.ent.etrs.vehicule.view.commons.utils.LectureConsole;
import net.ent.etrs.vehicule.view.facade.FacadeView;
import net.ent.etrs.vehicule.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.vehicule.view.references.ConstantesView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacadeViewImpl implements FacadeView {
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMenuPrincipal(List<String> menu) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, "Menu principale");
    }

// base vehicule
    @Override
    public Vehicule creerVehicule() throws FacadeViewException {
        //Entrer vos implementation d'attribut ici
        String immat = LectureConsole.lectureChaineCaracteres("Entrer l'immat: ");
        int nbLitre = LectureConsole.lectureEntier("Entrer le nombre de litre du réservoir: ");
        Vignette vignette = selectionnerVignette();
        LocalDate dateSortie = saisieDate();
        float consomation = saisieConso();
        try {
            return EntitiesFactory.creerVehicule(immat,dateSortie,nbLitre,consomation,vignette);
        } catch (FactoryException e) {
            throw new FacadeViewException(ConstantesView.FACADE_IMPOSSIBLE_CREER_VEHICULE);
        }
    }

    public Vignette selectionnerVignette(){
        List<String> lsVignette = new ArrayList<>();
        for(Vignette vi : Arrays.asList(Vignette.values())){
            lsVignette.add(vi.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lsVignette);
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner une vignette: ");
        int choix = LectureConsole.lectureChoixInt(0, lsVignette.size());
        return Vignette.values()[choix-1];
    }
    @Override
    public Vehicule selectionnerVehicule(List<Vehicule> listeDeVehicule) throws FacadeViewException {
        if (listeDeVehicule.isEmpty()) {
            throw new FacadeViewException(ConstantesView.FACADE_AUCUN_VEHICULE);
        }
        List<String> lsVehicule = new ArrayList<>();
        for (Vehicule p : listeDeVehicule) {
            lsVehicule.add(p.toFormattedString());
        }
        for (int i = 0; i < 50; ++i) System.out.println();
        AffichageConsole.afficherMenuSimple(lsVehicule);
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner un vehicule: ");
        int choix = LectureConsole.lectureChoixInt(0, lsVehicule.size());

        return listeDeVehicule.get(choix - 1);
    }
    @Override
    public void afficherLesVehicule(List<Vehicule> listVehicule) {
        for (Vehicule p : listVehicule) {
           AffichageConsole.afficherMessageAvecSautLigne(p.toFormattedString());
        }
    }
    //Autre
    @Override
    public LocalDate saisieDate(){
        return LectureConsole.lectureLocalDate("Entrer la date de sortie ("+AffichageConsole.PATTERN_DATE_PAR_DEFAUT+")   : ",
                AffichageConsole.PATTERN_DATE_PAR_DEFAUT);

    }
    @Override
    public float saisieConso(){
        //TODO peut-être créer une méthode pour les Float ?
        return  (float) LectureConsole.lectureDouble("Entrer la conso: ");
    }



}
