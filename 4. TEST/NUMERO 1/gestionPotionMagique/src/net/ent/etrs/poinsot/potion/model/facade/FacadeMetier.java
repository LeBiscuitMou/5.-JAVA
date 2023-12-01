package net.ent.etrs.poinsot.potion.model.facade;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;

import java.util.List;

public interface FacadeMetier {
    void supprimerIngredient(Ingredient ingredient);
    void supprimerPotion(Potion potion);
    void supprimerToutesLesPotions();
    Ingredient creerIngredient(Ingredient ingredient);
    List<Ingredient> afficherLesIngredients();
    List<Potion> afficherLesPotions();
    Potion creerPotion(Potion potion);
}
