package net.ent.etrs.poinsot.potion.view.facade;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.references.Nature;
import net.ent.etrs.poinsot.potion.view.facade.exceptions.FacadeViewException;

import java.util.List;

public interface FacadeView {
    void afficherLesIngredients(List<Ingredient> lesIngredients);
    Ingredient creerUnIngredient() throws FacadeViewException;
    Ingredient selectionnerIngredient(List<Ingredient> lesIngredients) throws FacadeViewException;
    void afficherMenuPrincipal(List<String> menu);
    Potion creerUnePotion();
    void afficherToutesLesPotions(List<Potion> lesPotions);
    void afficherMessageErreur(String message);
    Potion ajouterUnIngredient(Potion potion, Ingredient ingredient);
    void afficherMessage(String message);
    Potion supprimerUnePotion(List<Potion> lesPotions) throws FacadeViewException;
    Nature selectionnerNatureIngredient();
}
