package net.ent.etrs.poinsot.potion.presenteur;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.potion.model.facade.impl.exceptions.FacadeMetierException;
import net.ent.etrs.poinsot.potion.presenteur.exceptions.PresenteurException;
import net.ent.etrs.poinsot.potion.view.commons.utils.LectureConsole;
import net.ent.etrs.poinsot.potion.view.facade.FacadeView;
import net.ent.etrs.poinsot.potion.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.poinsot.potion.view.references.ConstanteView;

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

    private List<String> initMenu(){
        List<String> list = new ArrayList<>();

        list.add("Afficher toutes les potions");
        list.add("Afficher tous les ingrédients");
        list.add("Créer une potion");
        list.add("Créer un ingrédient");
        list.add("Supprimer une potion");

        return list;
    }

    public void start() {
        int choix = -1;
        List<String> menuPrincipal = initMenu();
        do {
            facadeView.afficherMenuPrincipal(menuPrincipal);
            choix = LectureConsole.lectureChoixInt(0, menuPrincipal.size());
            gererChoixMenuPrincipal(choix);
        } while (choix != 0);
    }

    private void gererChoixMenuPrincipal(int choix) {
        switch (choix) {
            case 1 -> afficherPotions();
            case 2 -> afficherIngredients();
            case 3 -> creerPotion();
            case 4 -> creerIngredient();
            case 5 -> supprimerPotion();
            default -> facadeView.afficherMessageErreur("ANOMALIE SWITCH PRESENTEUR !");
        }
    }

    private void supprimerPotion() {
        List<Potion> lesPotions = facadeMetier.afficherLesPotions();
        Potion p = null;
        try {
            p = facadeView.supprimerUnePotion(lesPotions);
            facadeMetier.supprimerPotion(p);
            facadeView.afficherMessage("La potion : " + p.getNom() + " a été supprimé avec succès");
        } catch (FacadeViewException | FacadeMetierException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerIngredient() {
        Ingredient i = null;
        try {
            i = facadeView.creerUnIngredient();
            facadeMetier.creerIngredient(i);
            facadeView.afficherMessage("L'ingrédient : " + i.getNom() + " a été créé avec succès");
        } catch (FacadeViewException | FacadeMetierException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerPotion() {
        Potion p = null;
        try {
            p = facadeView.creerUnePotion();
            facadeMetier.creerPotion(p);
        } catch (FacadeMetierException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherIngredients() {
        List<Ingredient> lesIngredients = facadeMetier.afficherLesIngredients();
        facadeView.afficherLesIngredients(lesIngredients);
    }

    private void afficherPotions() {
        List<Potion> lesPotions = facadeMetier.afficherLesPotions();
        facadeView.afficherToutesLesPotions(lesPotions);
    }
}