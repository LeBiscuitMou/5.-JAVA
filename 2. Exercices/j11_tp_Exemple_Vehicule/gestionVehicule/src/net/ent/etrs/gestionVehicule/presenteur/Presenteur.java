package net.ent.etrs.gestionVehicule.presenteur;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.model.facade.FacadeMetier;
import net.ent.etrs.gestionVehicule.model.facade.exceptions.FacadeMetierException;
import net.ent.etrs.gestionVehicule.presenteur.exceptions.PresenteurException;
import net.ent.etrs.gestionVehicule.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionVehicule.view.facade.FacadeView;
import net.ent.etrs.gestionVehicule.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.gestionVehicule.view.facade.references.ConstanteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Presenteur {
    private FacadeView fv;
    private FacadeMetier fm;

    public Presenteur(FacadeView fv, FacadeMetier fm) throws PresenteurException {
        this.setFv(fv);
        this.setFm(fm);
    }

    public void setFv(FacadeView fv) throws PresenteurException {
        if (Objects.isNull(fv)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FV_IS_NULL);
        }
        this.fv = fv;
    }

    public void setFm(FacadeMetier fm) throws PresenteurException {
        if (Objects.isNull(fm)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FM_IS_NULL);
        }
        this.fm = fm;
    }

    private List<String> initMenu(){
        List<String> list = new ArrayList<>();

        list.add("Afficher tous les véhicules");
        list.add("Creer un véhicule");
        list.add("Sélectionner un véhicule");
        list.add("Supprimer un véhicule");

        return list;
    }

    public void start() {
        int choix = -1;
        List<String> menuPrincipal = initMenu();
        do {
            fv.afficherMenuPrincipal(menuPrincipal);
            choix = LectureConsole.lectureChoixInt(0, menuPrincipal.size());
            gererChoixMenuPrincipal(choix);
        } while (choix != 0);
    }

    private void gererChoixMenuPrincipal(int choix) {
        switch (choix) {
            case 1 -> afficherVehicules();
            case 2 -> creerVehicule();
            case 3 -> selectionnerVehicule();
            case 4 -> supprimerVehicule();
        }
    }

    private void supprimerVehicule() {
        try {
            List<Vehicule> lesVehicules = fm.recupererTousVehicule();
            Vehicule v = fv.selectionnerVehicule(lesVehicules);
            fm.supprimerVehicule(v);
        } catch (FacadeViewException | FacadeMetierException e) {
            fv.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerVehicule() {
        Vehicule v = null;
        try {
            v = fv.creerVehicule();
            fm.sauvegarderVehicule(v);
        } catch (FacadeViewException | FacadeMetierException e) {
            fv.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherVehicules() {
        List<Vehicule> lesVehicules = fm.recupererTousVehicule();
        fv.afficherVehicules(lesVehicules);
    }

    private void selectionnerVehicule() {
        try {
            List<Vehicule> lesvehicules = fm.recupererTousVehicule();
            Vehicule v = fv.selectionnerVehicule(lesvehicules);
        } catch (FacadeViewException e) {
            fv.afficherMessageErreur(e.getMessage());
        }
    }
}