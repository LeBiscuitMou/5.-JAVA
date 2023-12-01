package net.ent.etrs.poinsot.potion.view.facade;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.entities.references.Nature;

import java.util.List;

public interface FacadeView {
    void afficherLesIngredients(List<Ingredient> lesIngredients);
    Ingredient creerUnIngredient();
    Ingredient selectionnerIngredient(List<Ingredient> lesIngredients);
    int afficherMenuPrincipal();
    Potion creerUnePotion();
    void afficherToutesLesPotions(List<Potion> lesPotions);
    void afficherMessageErreur(String message);
    Potion ajouterUnIngredient(Potion potion, Ingredient ingredient);
    void afficherMessage(String message);
    Potion supprimerUnePotion(List<Potion> lesPotions);
    Nature selectionnerNatureIngredient();
}
