package net.ent.etrs.poinsot.potion.view.facade.impl;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.entities.references.Nature;
import net.ent.etrs.poinsot.potion.view.facade.FacadeView;

import java.util.List;

public class FacadeViewImpl implements FacadeView {
    @Override
    public void afficherLesIngredients(List<Ingredient> lesIngredients) {

    }

    @Override
    public Ingredient creerUnIngredient() {
        return null;
    }

    @Override
    public Ingredient selectionnerIngredient(List<Ingredient> lesIngredients) {
        return null;
    }

    @Override
    public int afficherMenuPrincipal() {
        return 0;
    }

    @Override
    public Potion creerUnePotion() {
        return null;
    }

    @Override
    public void afficherToutesLesPotions(List<Potion> lesPotions) {

    }

    @Override
    public void afficherMessageErreur(String message) {

    }

    @Override
    public Potion ajouterUnIngredient(Potion potion, Ingredient ingredient) {
        return null;
    }

    @Override
    public void afficherMessage(String message) {

    }

    @Override
    public Potion supprimerUnePotion(List<Potion> lesPotions) {
        return null;
    }

    @Override
    public Nature selectionnerNatureIngredient() {
        return null;
    }
}