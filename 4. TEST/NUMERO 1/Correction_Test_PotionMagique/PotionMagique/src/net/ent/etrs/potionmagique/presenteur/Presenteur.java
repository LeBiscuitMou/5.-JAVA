package net.ent.etrs.potionmagique.presenteur;

import net.ent.etrs.potionmagique.models.entities.Ingredient;
import net.ent.etrs.potionmagique.models.entities.Potion;
import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;
import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.facade.FacadeMetier;
import net.ent.etrs.potionmagique.presenteur.exception.PresenteurException;
import net.ent.etrs.potionmagique.presenteur.references.ConstantPresenteur;
import net.ent.etrs.potionmagique.view.facade.FacadeView;

public class Presenteur {

    FacadeView facadeView;

    FacadeMetier facadeMetier;

    public Presenteur(FacadeView facadeView, FacadeMetier facadeMetier) throws PresenteurException {
        this.setFacadeMetier(facadeMetier);
        this.setFacadeView(facadeView);
    }

    public FacadeView getFacadeView() {
        return this.facadeView;
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if (null == facadeView) {
            throw new PresenteurException(ConstantPresenteur.FACADE_VIEW_NULL);
        }
        this.facadeView = facadeView;
    }

    public FacadeMetier getFacadeMetier() {
        return this.facadeMetier;
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if (null == facadeMetier) {
            throw new PresenteurException(ConstantPresenteur.FACADE_METIER_NULL);
        }
        this.facadeMetier = facadeMetier;
    }

    public void start() {
        //Afficher Menu Principal
        int choix;
        do {
            choix = this.facadeView.afficherMenuPrincipal();
            //Gérer le choix du Menu
            this.gererChoixMenu(choix);
        } while (choix != 0);


    }

    private void gererChoixMenu(int choix) {
        switch (choix) {
            case 1 -> afficherPotions();
            case 2 -> afficherIngredients();
            case 3 -> creerPotion();
            case 4 -> creerIngredient();
            case 5 -> supprimerPotion();
        }
    }

    private void supprimerPotion() {

        try {
            if (!facadeMetier.afficherLesPotions().isEmpty()) {
                Potion potion = this.facadeView.supprimerUnePotion(facadeMetier.afficherLesPotions());
                this.facadeMetier.supprimerPotion(potion);
                this.facadeView.afficherMessage(ConstantPresenteur.POTION_SUPPRIMER);
            } else {
                facadeView.afficherMessage(ConstantPresenteur.LIST_POTION_EMPTY);
            }

        } catch (BusinessException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void creerIngredient() {
        try {
            Ingredient i = this.facadeView.creerUnIngredient();
            this.facadeMetier.creerIngredient(i);
            this.facadeView.afficherMessage(ConstantPresenteur.INGREDIENT_CREER);
        } catch (BusinessException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void creerPotion() {
        try {
            Potion p = this.facadeView.creerUnePotion();
            this.facadeMetier.creerPotion(p);
            do {

                facadeView.ajouterUnIngredient(p, facadeView.selectionnerIngredient(facadeMetier.afficherLesIngredients()));
            } while (!p.estFinie());
            this.facadeView.afficherMessage(ConstantPresenteur.POTION_CREER);
        } catch (BusinessException | PotionException e) {
            this.facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherIngredients() {
        this.facadeView.afficherLesIngredients(this.facadeMetier.afficherLesIngredients());
    }

    private void afficherPotions() {
        this.facadeView.afficherToutesLesPotions(this.facadeMetier.afficherLesPotions());
    }

}
